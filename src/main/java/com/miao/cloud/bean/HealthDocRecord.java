package com.miao.cloud.bean;

import lombok.Data;
import org.joda.time.DateTime;
import org.joda.time.LocalDateTime;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * @author qujianhao
 * @date 2021/8/17 14:31
 */

@Data
public class HealthDocRecord {

    @Field
    private Long id;

    @Field
    private String phone_number;

    @Field
    private String channel_name;

    @Field
    private String source_port;

    @Field
    private String source_entrance;

    @Field
    private String source_category;

    @Field
    private Integer app_id;

    @Field
    private Long profile_id;

    @Field
    private  String resource_id;

    @Field
    private  String resource_type;

    @Field
    private  String resource_remark;

    @Field
    private Long base_data_item_code;

    @Field
    private  String unit;

    @Field
    private  String base_data_item;

    @Field
    private  String base_data_value;

    @Field
    private  String record_date;

    @Field
    private  String tips;

    @Field
    private  String reference_range;

    @Field
    private Integer state;

    @Field
    private String create_time;

    @Field
    private String update_time;


}
