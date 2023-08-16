package com.easy1400.viid.service;

import com.easy1400.viid.domain.ViidCascadePlatform;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sun.org.apache.xpath.internal.operations.Bool;

/**
* @author chenghong
* @description 针对表【viid_cascade_platform】的数据库操作Service
* @createDate 2023-08-16 19:46:16
*/
public interface ViidCascadePlatformService extends IService<ViidCascadePlatform> {


  Boolean  addViidCascadePlatform(ViidCascadePlatform viidCascadePlatform);
}
