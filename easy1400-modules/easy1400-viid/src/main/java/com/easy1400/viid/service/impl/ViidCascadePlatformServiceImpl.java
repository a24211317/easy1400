package com.easy1400.viid.service.impl;

import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.easy1400.viid.common.util.ViidHttpUtil;
import com.easy1400.viid.domain.ViidCascadePlatform;
import com.easy1400.viid.domain.message.RegisterRequest;
import com.easy1400.viid.service.ViidCascadePlatformService;
import com.easy1400.viid.mapper.ViidCascadePlatformMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author chenghong
 * @description 针对表【viid_cascade_platform】的数据库操作Service实现
 * @createDate 2023-08-16 19:46:16
 */
@Service
public class ViidCascadePlatformServiceImpl extends ServiceImpl<ViidCascadePlatformMapper, ViidCascadePlatform>
        implements ViidCascadePlatformService {

    @Autowired
    private ViidHttpUtil viidHttpUtil;

    @Override
    public Boolean addViidCascadePlatform(ViidCascadePlatform viidCascadePlatform) {
        //先保存数据入库
        Boolean hasSave = this.save(viidCascadePlatform);
        //如果添加的平台为上级平台 则需要向上级平台注册
        if (viidCascadePlatform.getType().equals("0")) {
            viidHttpUtil.registerSend(viidCascadePlatform);
        }
        return hasSave;
    }
}




