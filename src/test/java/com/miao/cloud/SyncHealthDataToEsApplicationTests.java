package com.miao.cloud;

import com.baomidou.mybatisplus.core.toolkit.BeanUtils;

import com.miao.cloud.bean.HealthDocRecord;
//import com.miao.cloud.es.EsHealthDocRecordDao;
import com.miao.cloud.service.HealthDoRecordService;
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
import java.util.List;
import java.util.Map;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SyncHealthDataToEsApplicationTests {


//    @Resource
//    private EsHealthDocRecordDao esHealthDocRecordDao;

    @Resource
    private HealthDoRecordService healthDoRecordService;

    @Resource
    private RestHighLevelClient restHighLevelClient;

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
           // start = listById.get(listById.size()-1).getId();
            start = start-500;
            System.out.println(start);
        }

    }
}
