package com.easy1400.viid.service;

import com.easy1400.viid.domain.ViidCascadePlatform;
import com.easy1400.viid.domain.ViidSubscribe;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author chenghong
* @description 针对表【viid_subscribe】的数据库操作Service
* @createDate 2023-08-17 19:05:25
*/
public interface ViidSubscribeService extends IService<ViidSubscribe> {

    String add(ViidSubscribe subscribe, ViidCascadePlatform viidCascadePlatform);

}
