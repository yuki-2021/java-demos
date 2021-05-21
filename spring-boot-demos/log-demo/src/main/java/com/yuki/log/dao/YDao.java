package com.yuki.log.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class YDao {
    Logger logger = LoggerFactory.getLogger(YDao.class);


    public void log() {

        logger.debug("dao");
        logger.info("dao");
    }
}
