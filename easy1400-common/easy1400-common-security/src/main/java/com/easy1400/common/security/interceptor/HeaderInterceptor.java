package com.easy1400.common.security.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.easy1400.common.security.auth.AuthUtil;
import com.easy1400.common.security.utils.SecurityUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.AsyncHandlerInterceptor;
import com.easy1400.common.core.constant.SecurityConstants;
import com.easy1400.common.core.context.SecurityContextHolder;
import com.easy1400.common.core.utils.ServletUtils;
import com.easy1400.common.core.utils.StringUtils;
import com.easy1400.system.api.model.LoginUser;

import java.util.Arrays;

/**
 * 自定义请求头拦截器，将Header数据封装到线程变量中方便获取
 * 注意：此拦截器会同时验证当前用户有效期自动刷新有效期
 *
 * @author easy1400
 */
public class HeaderInterceptor implements AsyncHandlerInterceptor {
    //放行类路径，1400对接时的接口不需要拦截
    private final String[] ReleaseClassPath = {"com.easy1400.viid.controller.ViidSystemController"};

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        if (Arrays.asList(ReleaseClassPath).contains(((HandlerMethod) handler).getBeanType().getName())) return true;
        SecurityContextHolder.setUserId(ServletUtils.getHeader(request, SecurityConstants.DETAILS_USER_ID));
        SecurityContextHolder.setUserName(ServletUtils.getHeader(request, SecurityConstants.DETAILS_USERNAME));
        SecurityContextHolder.setUserKey(ServletUtils.getHeader(request, SecurityConstants.USER_KEY));

        String token = SecurityUtils.getToken();
        if (StringUtils.isNotEmpty(token)) {
            LoginUser loginUser = AuthUtil.getLoginUser(token);
            if (StringUtils.isNotNull(loginUser)) {
                AuthUtil.verifyLoginUserExpire(loginUser);
                SecurityContextHolder.set(SecurityConstants.LOGIN_USER, loginUser);
            }
        }
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        SecurityContextHolder.remove();
    }
}
