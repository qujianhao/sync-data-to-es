package com.miao.cloud.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.miao.cloud.bean.HealthUserInfo;
import com.miao.cloud.mapper.HealthUserInfoMapper;
import com.miao.cloud.service.HealthUserInfoService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author qujianhao
 * @date 2021/8/18 10:28
 */

@Service
public class HealthUserInfoServiceImpl extends ServiceImpl<HealthUserInfoMapper, HealthUserInfo> implements HealthUserInfoService {


    @Override
    public List<HealthUserInfo> getListById(Long id) {
        return super.getBaseMapper().getListById(id);
    }
}
