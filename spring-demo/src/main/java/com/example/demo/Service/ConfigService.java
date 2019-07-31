package com.example.demo.Service;

import com.example.demo.Bean.Config;

import java.util.List;

public interface ConfigService {

    List<Config> getConfig();

    List<String> getCronExpression();

    List<String> getTips();
}
