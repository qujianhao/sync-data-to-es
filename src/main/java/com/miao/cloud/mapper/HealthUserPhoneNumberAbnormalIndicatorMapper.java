package com.miao.cloud.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.miao.cloud.bean.HealthUserAbnormalIndicator;
import com.miao.cloud.bean.HealthUserPhoneNumberAbnormalIndicator;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author qujianhao
 * @date 2021/8/24 14:18
 */
@Repository
public interface HealthUserPhoneNumberAbnormalIndicatorMapper extends BaseMapper<HealthUserPhoneNumberAbnormalIndicator> {

    List<HealthUserPhoneNumberAbnormalIndicator> getListById(@Param("id")Long id);

}
