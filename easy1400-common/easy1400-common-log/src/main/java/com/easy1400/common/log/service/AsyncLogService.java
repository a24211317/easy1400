package com.easy1400.common.log.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import com.easy1400.common.core.constant.SecurityConstants;
import com.easy1400.system.api.RemoteLogService;
import com.easy1400.system.api.domain.SysOperLog;

/**
 * 异步调用日志服务
 * 
 * @author easy1400
 */
@Service
public class AsyncLogService
{
    @Autowired
    private RemoteLogService remoteLogService;

    /**
     * 保存系统日志记录
     */
    @Async
    public void saveSysLog(SysOperLog sysOperLog) throws Exception
    {
        remoteLogService.saveLog(sysOperLog, SecurityConstants.INNER);
    }
}
