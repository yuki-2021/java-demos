package com.yuki.log.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class YService {

    Logger logger = LoggerFactory.getLogger(YService.class);


    public void log() {

        logger.debug("service");
        logger.info("service");
    }
}
