# spring - transaction - 事务抽象
## 🌲Spring事务抽象 - 简介

### 🍁Spring事务抽象 - 模型

Spring提供了统一的`事务抽象`，可以让我们以`统一的Api进行事务管理`。`具体的操作`交给不同的`TransitionManager实现`完成。
![Spring抽象事务 - 模型](https://img-blog.csdnimg.cn/20210326203918477.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3NpbmF0XzM0MDAzNzIw,size_16,color_FFFFFF,t_70#pic_center)

### 🍂 Spring事务抽象 - 接口介绍

`PlatformTransactionManager` - 根据`TransitionDefinition`创建事务、事务回滚、事务提交

-  `getTransaction()` - 开启事务
-  commit() - 提交事务
-  rollback() - 回滚事务

`TransitionDefinition` - 定义事务特征，比如`传播机制`、`隔离界别`、`readonly`、`timeout`、`遇到什么异常回滚`
`TransactionStatus` - 保存**事务状态**

`Propagation` - 传播行为，一般`查询方法`使用`SUPPORTS`,`更新、插入、删除方法`使用`REQUIRED`

`Isolation` - 隔离级别

`TransitionTemplate` - 用于编程式事务(用法类似JdbcTemplate)

`TransitionCallback/TransactionCallbackWithoutResult`- 给TransationTemplate提供回调

## 🌳 声明式事务 - 注解方式

:one:配置TransactionManager(事务管理器)

```xml
<!-- spring-tx - 事务管理器-->
<bean id="transtionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
    <!-- 事务超时时间 default -1 -->
    <property name="defaultTimeout" value="-1" />
    <property name="dataSource" ref="datasource" />
</bean>
```

:two:开启`@Transaction`注解支持

```xml
<!-- 声明式事务 - 开启注解 -->
<tx:annotation-driven transaction-manager="transtionManager" />
```

:three: 使用`@Tranaction`注解​

```java
/*
* 使用事务 - @Transitional
* */
@Transactional
public void insert() {
    // 1. 插入数据
    int update = jdbcTemplate.update("insert into tb_area value (null,'东校区')");
    // 2. 抛出异常
    throw new RuntimeException("出现了错误");
    // 3. 查看是否回滚
}
```

## 🍀 声明式事务 - XML方式

:one: 配置TransactionManager

```xml
 <!-- spring-tx - 事务管理器-->
<bean id="transtionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
    <!-- 事务超时时间 default -1 -->
    <property name="defaultTimeout" value="-1" />
    <property name="dataSource" ref="datasource" />
</bean>

```

:two: 使用`<tx:advice>`定义`事务切面`

```xml
<!-- 声明式事务 - 开启注解 -->
<tx:advice id="txAdvice" transaction-manager="transtionManager">
	<tx:attributes>
		<tx:method name="*" />
	</tx:attributes>
</tx:advice>
```

:three:把​`<tx:advice>事务切面`织入到target

```xml
 <!-- 配置aspectj - 切面 -->
<aop:config>
    <aop:pointcut id="pc" expression="execution(* com.yuki.tx.XmlService.*(..))"/>
    <aop:advisor advice-ref="txAdvice" pointcut-ref="pc" />
</aop:config>
```

## 🌾 编程式事务

有两种方式

- 直接使用`TransactionManager` - 自己控制事务，自己决定什么时候`rollback`和`commit`
- 使用`TransactionTemplate` - 只用`提供回调`，方法抛`RuntimeException`回滚

### 🌱 使用TranactionManager

```java
/*
* 使用事务 - 
* DefaultTransactionDefinition - 定义事务特征，比如propagation、isolation
* TransactionManager - 事务管理
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
```

### 🌵 使用TransactionTemplate

:one:配置`TransactionTemplate`

```xml
 <!-- 编程式 - 事务 -->
<bean id="transactionTemplate" class="org.springframework.transaction.support.TransactionTemplate">
        <property name="transactionManager" ref="transtionManager" />
</bean>
```

使用`TranactionTemplate`，并使用`TransactionCallback`提供回调

```java
/*
* 使用事务 - 
* TransitionTemplate - 类似JdbcTemplate，内部视同TransactionManager进行事务操作
* TransitionCallabck、TransactionCallbackWithoutResult - 提供回调
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
```









