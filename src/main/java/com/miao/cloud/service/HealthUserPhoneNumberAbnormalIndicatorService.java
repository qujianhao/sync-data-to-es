package com.miao.cloud.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.miao.cloud.bean.HealthUserPhoneNumberAbnormalIndicator;

import java.util.List;

/**
 * @author qujianhao
 * @date 2021/8/24 14:23
 */
public interface HealthUserPhoneNumberAbnormalIndicatorService extends IService<HealthUserPhoneNumberAbnormalIndicator> {

    /**
     * 批量查询大于某个ID的500条有效数据
     * @param id
     * @return
     */
    List<HealthUserPhoneNumberAbnormalIndicator> getListById(Long id);
}
