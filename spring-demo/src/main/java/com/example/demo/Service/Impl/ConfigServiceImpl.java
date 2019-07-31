//package com.example.demo.Service.Impl;
//
//import com.example.demo.Bean.Config;
//import com.example.demo.Dao.ConfigMapper;
//import com.example.demo.Service.ConfigService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class ConfigServiceImpl implements ConfigService {
//    @Autowired
//    private ConfigMapper configMapper;
//
//    @Override
//    public List<Config> getConfig() {
//        List<Config> list = configMapper.selectAll();
//        return list;
//    }
//
//    @Override
//    public List<String> getCronExpression() {
//        List<Config> configsList = getConfig();
//        List<String> list = new ArrayList<>();
//        for (Config config : configsList) {
//            list.add(config.getCron());
//        }
//        return list;
//    }
//
//    @Override
//    public List<String> getTips() {
//        List<Config> configsList = getConfig();
//        List<String> list = new ArrayList<>();
//        for (Config config : configsList) {
//            list.add(config.getTips());
//        }
//        return list;
//    }
//
//
//}
