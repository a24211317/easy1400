package com.easy1400.viid.service.impl.db;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.easy1400.viid.common.util.ViidHttpUtil;
import com.easy1400.viid.domain.ViidCascadePlatform;
import com.easy1400.viid.domain.ViidSubscribe;
import com.easy1400.viid.service.ViidSubscribeService;
import com.easy1400.viid.mapper.ViidSubscribeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author chenghong
 * @description 针对表【viid_subscribe】的数据库操作Service实现
 * @createDate 2023-08-17 19:05:25
 */
@Service
public class ViidSubscribeServiceImpl extends ServiceImpl<ViidSubscribeMapper, ViidSubscribe>
        implements ViidSubscribeService {
    @Autowired
    private ViidHttpUtil viidHttpUtil;

    @Override
    public String add(ViidSubscribe subscribe, ViidCascadePlatform viidCascadePlatform) {
        return viidHttpUtil.subscribeSend(subscribe, viidCascadePlatform);
    }
}




