package com.miao.cloud.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.miao.cloud.bean.HealthDocRecord;
import com.miao.cloud.bean.HealthUserAbnormalIndicator;
import com.miao.cloud.mapper.HealthDocRecordMapper;
import com.miao.cloud.mapper.HealthUserAbnormalIndicatorMapper;
import com.miao.cloud.service.HealthDoRecordService;
import com.miao.cloud.service.HealthUserAbnormalIndicatorService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author qujianhao
 * @date 2021/8/24 14:25
 */
@Service
public class HealthUserAbnormalIndicatorServiceImpl extends ServiceImpl<HealthUserAbnormalIndicatorMapper, HealthUserAbnormalIndicator> implements HealthUserAbnormalIndicatorService {


    @Override
    public List<HealthUserAbnormalIndicator> getListById(Long id) {
        return super.getBaseMapper().getListById(id);
    }
}
