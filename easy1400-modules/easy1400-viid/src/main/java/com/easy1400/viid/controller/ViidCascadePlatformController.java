package com.easy1400.viid.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.easy1400.common.core.web.domain.AjaxResult;
import com.easy1400.viid.common.util.ViidHttpUtil;
import com.easy1400.viid.domain.ViidCascadePlatform;
import com.easy1400.viid.service.ViidCascadePlatformService;
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
        queryWrapper.eq(ViidCascadePlatform::getSystemid, systemid);
        queryWrapper.eq(ViidCascadePlatform::getType, "0");
        ViidCascadePlatform viidCascadePlatform = viidCascadePlatformService.getOne(queryWrapper);
        if (viidCascadePlatform != null) {
            return AjaxResult.success(viidHttpUtil.registerSend(viidCascadePlatform));
        }
        return AjaxResult.error("未找到上级平台信息");
    }

}
