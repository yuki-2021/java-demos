package com.yuki.log;

import com.yuki.log.dao.YDao;
import com.yuki.log.service.YService;
import com.yuki.log.web.YController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class LogApplication {

    private static Logger logger = LoggerFactory.getLogger(LogApplication.class);

    public static void main(String[] args) {

        ConfigurableApplicationContext context =
                SpringApplication.run(LogApplication.class, args);

        logger.trace("hello-logback-trace"); // trace
        logger.debug("hello-logback-debug"); // debug
        logger.info("hello-logback-info");   // info
        logger.warn("hello-logback-warning");// warning
        logger.error("hello-logback-error"); // error


        logger.info("===== 测试日志组 =============");
        YDao dao = context.getBean(YDao.class);
        YService service = context.getBean(YService.class);
        YController web = context.getBean(YController.class);
        dao.log();
        service.log();
        web.log();

    }
}
