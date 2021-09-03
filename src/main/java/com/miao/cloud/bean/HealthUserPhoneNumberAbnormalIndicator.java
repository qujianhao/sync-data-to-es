package com.miao.cloud.bean;

import lombok.Data;
import org.joda.time.DateTime;
import org.springframework.data.elasticsearch.annotations.Field;

/**
 * @author qujianhao
 * @date 2021/8/24 14:14
 */
@Data
public class HealthUserPhoneNumberAbnormalIndicator {

    @Field
    private Long id;

    @Field
    private Integer app_id;

    @Field
    private Long profile_id;

    @Field
    private String channel_name;

    @Field
    private String phone_number;

    @Field
    private String source_port;

    @Field
    private String source_entrance;

    @Field
    private String source_category;

    @Field
    private Long abnormal_indicator_code;

    @Field
    private Long base_data_item_code;

    @Field
    private String base_item_name;

    @Field
    private String base_item_value;

    @Field
    private Boolean has_abnormal;

    @Field
    private String abnormal_tips;

    @Field
    private Boolean is_abnormal;

    @Field
    private String abnormal_indicator_level_name;

    @Field
    private String record_date;

    @Field
    private Boolean has_expiration_time;

    @Field
    private String expiration_time;

    @Field
    private Integer date_key;

    @Field
    private String reference_value_show;

    @Field
    private String create_time;

    @Field
    private String update_time;

}
