package com.easy1400.common.security.feign;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;
import com.easy1400.common.core.constant.SecurityConstants;
import com.easy1400.common.core.utils.ServletUtils;
import com.easy1400.common.core.utils.StringUtils;
import com.easy1400.common.core.utils.ip.IpUtils;
import feign.RequestInterceptor;
import feign.RequestTemplate;

/**
 * feign 请求拦截器
 * 
 * @author easy1400
 */
@Component
public class FeignRequestInterceptor implements RequestInterceptor
{
    @Override
    public void apply(RequestTemplate requestTemplate)
    {
        HttpServletRequest httpServletRequest = ServletUtils.getRequest();
        if (StringUtils.isNotNull(httpServletRequest))
        {
            Map<String, String> headers = ServletUtils.getHeaders(httpServletRequest);
            // 传递用户信息请求头，防止丢失
            String userId = headers.get(SecurityConstants.DETAILS_USER_ID);
            if (StringUtils.isNotEmpty(userId))
            {
                requestTemplate.header(SecurityConstants.DETAILS_USER_ID, userId);
            }
            String userKey = headers.get(SecurityConstants.USER_KEY);
            if (StringUtils.isNotEmpty(userKey))
            {
                requestTemplate.header(SecurityConstants.USER_KEY, userKey);
            }
            String userName = headers.get(SecurityConstants.DETAILS_USERNAME);
            if (StringUtils.isNotEmpty(userName))
            {
                requestTemplate.header(SecurityConstants.DETAILS_USERNAME, userName);
            }
            String authentication = headers.get(SecurityConstants.AUTHORIZATION_HEADER);
            if (StringUtils.isNotEmpty(authentication))
            {
                requestTemplate.header(SecurityConstants.AUTHORIZATION_HEADER, authentication);
            }

            // 配置客户端IP
            requestTemplate.header("X-Forwarded-For", IpUtils.getIpAddr());
        }
    }
}