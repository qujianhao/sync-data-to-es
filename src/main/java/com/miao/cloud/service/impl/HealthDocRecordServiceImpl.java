package com.miao.cloud.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.miao.cloud.bean.HealthDocRecord;
import com.miao.cloud.mapper.HealthDocRecordMapper;
import com.miao.cloud.service.HealthDoRecordService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author qujianhao
 * @date 2021/8/17 14:44
 */
@Service
public class HealthDocRecordServiceImpl extends ServiceImpl<HealthDocRecordMapper, HealthDocRecord> implements HealthDoRecordService {


    @Override
    public List<HealthDocRecord> getListById(Long id) {
        return super.getBaseMapper().getListById(id);
    }
}
