package com.yuki.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

/*
* 编程式 - 事务
* */
@Service
public class CodeService {


    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Autowired
    private DataSourceTransactionManager transactionManager;

    @Autowired
    private TransactionTemplate transactionTemplate;

    /*
    * 使用事务 - @Transitional
    * */
    public void useTxManager() {
        // 1. 初始化TransitionDefinition -
        DefaultTransactionDefinition transitionDefinition = new DefaultTransactionDefinition();
        transitionDefinition.setPropagationBehavior(Propagation.REQUIRED.value());
        // 2. 开启事务
        TransactionStatus transactionStatus = transactionManager.getTransaction(transitionDefinition);
        try {
           // 1. 插入数据
           int update = jdbcTemplate.update("insert into tb_area value (null,'东校区')");
           // 2. 抛出异常
           if(update == 1) {
               throw new RuntimeException("出现了错误");
           }
           transactionManager.commit(transactionStatus);
       }catch (Exception e) {
            e.printStackTrace();
            transactionManager.rollback(transactionStatus);
       }
    }

    /*
    * 使用事务 - TransitionTemplate、TransitionCallabck、TransactionCallbackWithoutResult
    * */
    public void useTxTemplate() {
        transactionTemplate.execute(new TransactionCallback() {
            public Object doInTransaction(TransactionStatus transactionStatus) {
                int update = jdbcTemplate.update("insert into tb_area value (null,'东校区')");
                // 2. 抛出异常
                if(update == 1) {
                    throw new RuntimeException("出现了错误");
                }
                // 3. 返回值
                return update;
            }
        });
    }

}
