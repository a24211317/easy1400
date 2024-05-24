package com.easy1400.viid.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.easy1400.common.core.utils.StringUtils;
import com.easy1400.common.core.web.domain.AjaxResult;
import com.easy1400.viid.common.util.ViidHttpUtil;
import com.easy1400.viid.domain.ViidCascadePlatform;
import com.easy1400.viid.domain.ViidSubscribe;
import com.easy1400.viid.service.ViidCascadePlatformService;
import com.easy1400.viid.service.ViidSubscribeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName ViidSubscribeController
 * @Author CH
 * @Date 2024/5/24 09:55
 * @Version 1.0
 */
@RestController
@RequestMapping("/VIID/Subscribe")
public class ViidSubscribeController {
    @Autowired
    private ViidCascadePlatformService viidCascadePlatformService;
    @Autowired
    private ViidSubscribeService viidSubscribeService;
    @Autowired
    private ViidHttpUtil viidHttpUtil;

    /**
     * 新增订阅通知
     *
     * @param viidSubscribe
     * @return
     */
    @PostMapping("/ViidSubscribe")
    public AjaxResult addViidSubscribe(@RequestBody ViidSubscribe viidSubscribe, HttpServletRequest request) {
        LambdaQueryWrapper<ViidCascadePlatform> viidCascadePlatformQueryWrapper = new LambdaQueryWrapper<>();
        viidCascadePlatformQueryWrapper.eq(ViidCascadePlatform::getType, 2);
        ViidCascadePlatform viidCascadePlatform = viidCascadePlatformService.getOne(viidCascadePlatformQueryWrapper);
        String UserIdentify = request.getHeader("User-Identify");
        //被订阅
        if (StringUtils.isNotEmpty(UserIdentify)) {
            viidSubscribe.setSubscriberSendOrgID(UserIdentify);
            viidSubscribe.setSubscriberRecoverOrgID(viidCascadePlatform.getSystemID());
        } else {
            viidSubscribe.setSubscriberSendOrgID(viidCascadePlatform.getSystemID());
            viidSubscribe.setSubscriberRecoverOrgID(viidSubscribe.getSubscriberRecoverOrgID());
        }
        if (viidSubscribeService.save(viidSubscribe)) {
            switch (viidSubscribe.getSubscribeType()) {
                //订阅上级需要像上级发送通知
                case "0":
                    return AjaxResult.success(viidSubscribeService.add(viidSubscribe, viidCascadePlatform));
            }
            return AjaxResult.success("save success");
        }
        return AjaxResult.error("500","save error");
}

/**
 * 查询订阅信息
 *
 * @param type
 * @return
 */
@GetMapping("/ViidSubscribe")
public AjaxResult getViidCascadePlatform(String type) {
    LambdaQueryWrapper<ViidSubscribe> queryWrapper = new LambdaQueryWrapper<>();
    queryWrapper.eq(StringUtils.isNotEmpty(type), ViidSubscribe::getSubscribeType, type);
    return AjaxResult.success(viidSubscribeService.list(queryWrapper));
}


}
