package com.miao.cloud;

import com.baomidou.mybatisplus.core.toolkit.BeanUtils;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.miao.cloud.bean.HealthDocRecord;
//import com.miao.cloud.es.EsHealthDocRecordDao;
import com.miao.cloud.bean.HealthUserAbnormalIndicator;
import com.miao.cloud.bean.HealthUserInfo;
import com.miao.cloud.bean.HealthUserPhoneNumberAbnormalIndicator;
import com.miao.cloud.service.HealthDoRecordService;
import com.miao.cloud.service.HealthUserAbnormalIndicatorService;
import com.miao.cloud.service.HealthUserInfoService;
import com.miao.cloud.service.HealthUserPhoneNumberAbnormalIndicatorService;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@SpringBootTest
@Slf4j
@RunWith(SpringRunner.class)
public class SyncHealthDataToEsApplicationTests {


//    @Resource
//    private EsHealthDocRecordDao esHealthDocRecordDao;

    @Resource
    private HealthDoRecordService healthDoRecordService;

    @Resource
    private HealthUserInfoService healthUserInfoService;

    @Resource
    private RestHighLevelClient restHighLevelClient;

    @Resource
    private HealthUserAbnormalIndicatorService healthUserAbnormalIndicatorService;

    @Resource
    private HealthUserPhoneNumberAbnormalIndicatorService healthUserPhoneNumberAbnormalIndicatorService;

    @Test
    public void contextLoads() {
        long start = 24751360L;
        while (true){
            List<HealthDocRecord> listById = healthDoRecordService.getListById(start);
            if (listById.size()<1){
                break;
            }
            BulkRequest bulkRequest = new BulkRequest();
            listById.stream().forEach(healthDocRecord -> {
                Map<String, Object> paramMap = BeanUtils.beanToMap(healthDocRecord);
                bulkRequest.add(new IndexRequest("index_health_doc_record","health_doc_record").source(paramMap));
            });

            try {
                restHighLevelClient.bulk(bulkRequest, RequestOptions.DEFAULT);
            } catch (IOException e) {
                e.printStackTrace();
            }
//
//            esHealthDocRecordDao.insertBulkDocRecord(listById);
            start = listById.get(listById.size()-1).getId();
//            start = listById.get(0).getId();
            System.out.println(start);
        }

    }


    @Test
    public void insertUserInfo() {
        long start = 1363728551126001281L;
        while (true){
            List<HealthUserInfo> listById = healthUserInfoService.getListById(start);
            if (listById.size()<1){
                break;
            }
            BulkRequest bulkRequest = new BulkRequest();
            listById.stream().forEach(healthUserInfo -> {
                Map<String, Object> paramMap = BeanUtils.beanToMap(healthUserInfo);
                bulkRequest.add(new IndexRequest("index_health_user_info","health_user_info").source(paramMap));
            });

            try {
                BulkResponse bulk = restHighLevelClient.bulk(bulkRequest, RequestOptions.DEFAULT);
                if (bulk.hasFailures()){
                    int size = Arrays.stream(bulk.getItems()).filter(bulkItemResponse -> {
                        if (StringUtils.isNotEmpty(bulkItemResponse.getFailureMessage())) {
                            return Boolean.TRUE;
                        }
                        return Boolean.FALSE;
                    }).collect(Collectors.toList()).size();
                    log.error("????????????????????????{}??????",size);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
//
//            esHealthDocRecordDao.insertBulkDocRecord(listById);
            start = listById.get(listById.size()-1).getId();
//            start = listById.get(0).getId();
            System.out.println(start);
        }

    }



    @Test
    public void insertHealthUserAbnormalIndicator(){
        Long start = 24761448L;
        String index = "index_health_user_abnormal_indicator";
        String  type = "health_user_abnormal_indicator";
        while (true){
            List<HealthUserAbnormalIndicator> listById = healthUserAbnormalIndicatorService.getListById(start);
            if (listById.size()<1){
                return;
            }
            bulkInsert(index,type,listById);
        }
    }

    @Test
    public void insertHealthUserPhoneNumberAbnormalIndicator(){
        Long start = 10782590L;
        String index = "index_health_user_phone_number_abnormal_indicator";
        String  type = "health_user_phone_number_abnormal_indicator";
        while (true){
            List<HealthUserPhoneNumberAbnormalIndicator> listById = healthUserPhoneNumberAbnormalIndicatorService.getListById(start);
            if (listById.size()<1){
                return;
            }
            bulkInsert(index,type,listById);
        }
    }

    private void bulkInsert(String indexName,String typeName,Object list){
        List<Object> objectList = (List<Object>) list;
        BulkRequest bulkRequest = new BulkRequest();
        objectList.stream().forEach(object -> {
            Map<String, Object> paramMap = BeanUtils.beanToMap(object);
            bulkRequest.add(new IndexRequest(indexName,typeName).source(paramMap));
        });

        try {
            BulkResponse bulk = restHighLevelClient.bulk(bulkRequest, RequestOptions.DEFAULT);
            int size = 0;
            if (bulk.hasFailures()){
                size = Arrays.stream(bulk.getItems()).filter(bulkItemResponse -> {
                    if (StringUtils.isNotEmpty(bulkItemResponse.getFailureMessage())) {
                        return Boolean.TRUE;
                    }
                    return Boolean.FALSE;
                }).collect(Collectors.toList()).size();
            }
            log.info("????????????????????????{}??????",objectList.size()-size);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
