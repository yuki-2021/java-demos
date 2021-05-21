package com.yuki.log.web;

import com.yuki.log.dao.YDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

@Controller
public class YController {
    Logger logger = LoggerFactory.getLogger(YController.class);


    public void log() {

        logger.debug("web");
        logger.info("web");
    }

}
