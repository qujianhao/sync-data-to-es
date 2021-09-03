package com.miao.cloud.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.miao.cloud.bean.HealthDocRecord;
import com.miao.cloud.bean.HealthUserAbnormalIndicator;

import java.util.List;

/**
 * @author qujianhao
 * @date 2021/8/24 14:23
 */
public interface HealthUserAbnormalIndicatorService extends IService<HealthUserAbnormalIndicator> {

    /**
     * 批量查询大于某个ID的500条有效数据
     * @param id
     * @return
     */
    List<HealthUserAbnormalIndicator> getListById(Long id);
}
