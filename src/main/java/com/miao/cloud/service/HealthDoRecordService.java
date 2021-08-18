package com.miao.cloud.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.miao.cloud.bean.HealthDocRecord;

import java.util.List;

/**
 * @author qujianhao
 * @date 2021/8/17 14:43
 */
public interface HealthDoRecordService extends IService<HealthDocRecord> {

    /**
     * 批量查询大于某个ID的500条有效数据
     * @param id
     * @return
     */
    List<HealthDocRecord> getListById(Long id);
}
