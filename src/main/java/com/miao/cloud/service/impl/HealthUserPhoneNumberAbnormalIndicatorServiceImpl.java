package com.miao.cloud.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.miao.cloud.bean.HealthUserPhoneNumberAbnormalIndicator;
import com.miao.cloud.mapper.HealthUserPhoneNumberAbnormalIndicatorMapper;
import com.miao.cloud.service.HealthUserPhoneNumberAbnormalIndicatorService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author qujianhao
 * @date 2021/8/17 14:44
 */
@Service
public class HealthUserPhoneNumberAbnormalIndicatorServiceImpl extends ServiceImpl<HealthUserPhoneNumberAbnormalIndicatorMapper, HealthUserPhoneNumberAbnormalIndicator> implements HealthUserPhoneNumberAbnormalIndicatorService {


    @Override
    public List<HealthUserPhoneNumberAbnormalIndicator> getListById(Long id) {
        return super.getBaseMapper().getListById(id);
    }
}
