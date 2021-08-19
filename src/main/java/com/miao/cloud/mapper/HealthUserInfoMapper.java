package com.miao.cloud.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.miao.cloud.bean.HealthUserInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author qujianhao
 * @date 2021/8/18 10:22
 */
@Repository
public interface HealthUserInfoMapper extends BaseMapper<HealthUserInfo> {

    List<HealthUserInfo>  getListById(@Param("id")Long id);

}
