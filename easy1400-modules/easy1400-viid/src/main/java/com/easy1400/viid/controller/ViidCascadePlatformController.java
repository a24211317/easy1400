package com.easy1400.viid.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.easy1400.common.core.web.domain.AjaxResult;
import com.easy1400.viid.common.util.ViidHttpUtil;
import com.easy1400.viid.domain.ViidCascadePlatform;
import com.easy1400.viid.domain.ViidSubscribe;
import com.easy1400.viid.service.ViidCascadePlatformService;
import com.easy1400.viid.service.ViidSubscribeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName ViidCascadePlatformController
 * @Author CH
 * @Date 2023/8/16 19:55
 * @Version 1.0
 */
@RestController
@RequestMapping("/VIID/Platform")
public class ViidCascadePlatformController {
    @Autowired
    private ViidCascadePlatformService viidCascadePlatformService;
    @Autowired
    private ViidSubscribeService viidSubscribeService;
    @Autowired
    private ViidHttpUtil viidHttpUtil;

    /**
     * 增加上/下级平台信息
     *
     * @param viidCascadePlatform
     * @return
     */
    @PostMapping("/ViidCascadePlatform")
    public AjaxResult addViidCascadePlatform(@RequestBody ViidCascadePlatform viidCascadePlatform) {
        return AjaxResult.success(viidCascadePlatformService.addViidCascadePlatform(viidCascadePlatform));
    }

    /**
     * 手动向上级平台注册
     *
     * @param systemid
     * @return
     */
    @GetMapping("/registerSend")
    public AjaxResult registerSend(String systemid) {
        LambdaQueryWrapper<ViidCascadePlatform> queryWrapper = new LambdaQueryWrapper();
        queryWrapper.eq(ViidCascadePlatform::getSystemID, systemid);
        queryWrapper.eq(ViidCascadePlatform::getType, "0");
        ViidCascadePlatform viidCascadePlatform = viidCascadePlatformService.getOne(queryWrapper);
        if (viidCascadePlatform != null) {
            return AjaxResult.success(viidHttpUtil.registerSend(viidCascadePlatform));
        }
        return AjaxResult.error("未找到上级平台信息");
    }

    @PostMapping("/ViidSubscribe")
    public AjaxResult addViidSubscribe(@RequestBody ViidSubscribe viidSubscribe) {
        if (viidSubscribeService.save(viidSubscribe)) {
            switch (viidSubscribe.getSubscribeType()) {
                //订阅上级需要像上级发送通知
                case "0":
                    ViidCascadePlatform viidCascadePlatform=viidCascadePlatformService.getById(viidSubscribe.getResourceURI());
                    return AjaxResult.success(viidSubscribeService.add(viidSubscribe,viidCascadePlatform));
            }
            return AjaxResult.success("save success");
        }
        return AjaxResult.error("500", "save error");
    }
}
