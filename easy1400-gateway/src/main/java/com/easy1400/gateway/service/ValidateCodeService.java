package com.easy1400.gateway.service;

import java.io.IOException;
import com.easy1400.common.core.exception.CaptchaException;
import com.easy1400.common.core.web.domain.AjaxResult;

/**
 * 验证码处理
 *
 * @author easy1400
 */
public interface ValidateCodeService
{
    /**
     * 生成验证码
     */
    public AjaxResult createCaptcha() throws IOException, CaptchaException;

    /**
     * 校验验证码
     */
    public void checkCaptcha(String key, String value) throws CaptchaException;
}
