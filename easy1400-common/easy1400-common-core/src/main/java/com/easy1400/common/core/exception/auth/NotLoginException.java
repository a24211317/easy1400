package com.easy1400.common.core.exception.auth;

/**
 * 未能通过的登录认证异常
 * 
 * @author easy1400
 */
public class NotLoginException extends RuntimeException
{
    private static final long serialVersionUID = 1L;

    public NotLoginException(String message)
    {
        super(message);
    }
}
