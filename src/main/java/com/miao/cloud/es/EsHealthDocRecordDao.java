//
//package com.miao.cloud.es;
//
//import com.miao.cloud.bean.HealthDocRecord;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.Resource;
//import java.util.List;
//
//
///**
// * @author qujianhao
// * @date 2021/8/17 15:13
// */
//
//
//@Component
//public class EsHealthDocRecordDao {
//
//    @Autowired
//    private HealthDocRecordRepository healthDocRecordRepository;
//
//    public void insertBulkDocRecord(List<HealthDocRecord> docRecordList){
//        Iterable<HealthDocRecord> healthDocRecords = healthDocRecordRepository.saveAll(docRecordList);
//        System.out.println(healthDocRecords.toString());
//    }
//
//}
//
