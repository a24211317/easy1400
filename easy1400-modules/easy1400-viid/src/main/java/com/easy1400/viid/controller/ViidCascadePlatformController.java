package com.easy1400.viid.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.easy1400.common.core.utils.StringUtils;
import com.easy1400.common.core.web.domain.AjaxResult;
import com.easy1400.viid.common.util.ViidHttpUtil;
import com.easy1400.viid.domain.ViidCascadePlatform;
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
     * 删除上/下级平台信息
     *
     * @param id
     * @return
     */
    @DeleteMapping("/ViidCascadePlatform/{id}")
    public AjaxResult delViidCascadePlatform(@PathVariable String id) {
        return AjaxResult.success(viidCascadePlatformService.removeById(id));

    }

    /**
     * 查询上/下级平台信息
     *
     * @param type
     * @param name
     * @return
     */
    @GetMapping("/ViidCascadePlatform")
    public AjaxResult getViidCascadePlatform(String type, String name) {
        LambdaQueryWrapper<ViidCascadePlatform> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(StringUtils.isNotEmpty(type), ViidCascadePlatform::getType, type);
        queryWrapper.like(StringUtils.isNotEmpty(name), ViidCascadePlatform::getName, name);
        return AjaxResult.success(viidCascadePlatformService.list(queryWrapper));
    }

    /**
     * 修改上/下级平台信息
     *
     * @param viidCascadePlatform
     * @return
     */
    @PutMapping("/ViidCascadePlatform")
    public AjaxResult updateViidCascadePlatform(@RequestBody ViidCascadePlatform viidCascadePlatform) {
        return AjaxResult.success(viidCascadePlatformService.updateById(viidCascadePlatform));
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
        queryWrapper.eq(ViidCascadePlatform::getType, "1");
        ViidCascadePlatform viidCascadePlatform = viidCascadePlatformService.getOne(queryWrapper);
        if (viidCascadePlatform != null) {
            if (viidHttpUtil.registerSend(viidCascadePlatform)) {
                return AjaxResult.success();
            }
            return AjaxResult.error("注册时发生错误");
        }
        return AjaxResult.error("未找到上级平台信息");
    }
}
