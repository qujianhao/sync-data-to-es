package com.miao.cloud.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.miao.cloud.bean.HealthUserInfo;

import java.util.List;

/**
 * @author qujianhao
 * @date 2021/8/18 10:26
 */
public interface HealthUserInfoService extends IService<HealthUserInfo> {

    List<HealthUserInfo> getListById(Long id);

}
