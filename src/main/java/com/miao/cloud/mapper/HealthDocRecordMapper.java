package com.miao.cloud.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.miao.cloud.bean.HealthDocRecord;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author qujianhao
 * @date 2021/8/17 14:45
 */
@Repository
public interface HealthDocRecordMapper extends BaseMapper<HealthDocRecord> {

    List<HealthDocRecord> getListById(@Param("id")Long id);

}
