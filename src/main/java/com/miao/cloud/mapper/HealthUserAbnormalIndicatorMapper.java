package com.miao.cloud.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.miao.cloud.bean.HealthDocRecord;
import com.miao.cloud.bean.HealthUserAbnormalIndicator;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author qujianhao
 * @date 2021/8/24 14:15
 */
@Repository
public interface HealthUserAbnormalIndicatorMapper extends BaseMapper<HealthUserAbnormalIndicator> {

    List<HealthUserAbnormalIndicator> getListById(@Param("id")Long id);

}
