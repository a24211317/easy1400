package com.easy1400.viid.service.impl.es;

import com.easy1400.viid.domain.message.FaceRequest;
import com.easy1400.viid.service.ViidDataService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

/**
 * @ClassName ViidDataDBServiceImpl
 * @Author CH
 * @Date 2023/9/5 10:38
 * @Version 1.0
 */
@Service
@ConditionalOnProperty(name = "device.data.saveway", havingValue = "ES")
public class ViidDataESServiceImpl implements ViidDataService {
    @Override
    public void saveViidFaceData(FaceRequest faceRequest) {
        System.out.println();
    }
}
