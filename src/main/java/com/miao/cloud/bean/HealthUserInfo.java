package com.miao.cloud.bean;

import lombok.Data;
import org.joda.time.LocalDateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author qujianhao
 * @date 2021/8/12 17:32
 */

@Data
@Document(indexName = "index_health_user_info",type = "health_user_info")
public class HealthUserInfo implements Serializable {

    @Id
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
    private Integer has_h_value;

    @Field
    private Integer has_phone_h_value;
    @Field
    private BigDecimal h_value;
    @Field
    private BigDecimal phone_h_value;
    @Field
    private Integer data_count;
    @Field
    private Integer has_average_m_value;

    @Field
    private Long profile_id;

    @Field
    private String user_name;

    @Field
    private String sex;

    @Field
    private String user_id_card;

    @Field
    private String nationality;

    @Field
    private String nation;

    @Field
    private String birthplace;

    @Field
    private String degree_education;

    @Field
    private String marital_status;

    @Field
    private String permanent_type;

    @Field
    private String company;

    @Field
    private String medical_insurance;

    @Field
    private String birthday;

    @Field
    private String present_address;

    @Field
    private String permanent_residence_address;

    @Field
    private String contact;

    @Field
    private Integer age;

    @Field
    private Integer income_per_capita;

    @Field
    private Integer personal_annual_income;

    @Field
    private String emergency_contact;

    @Field
    private String create_time;

    @Field
    private String update_time;


}
