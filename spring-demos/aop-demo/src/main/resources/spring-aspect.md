## 🌳 spring-aspectj

### 🍁 spring-aspectj-简介

`Spring 2.0`之后，`Spring AOP`整合了`AspectJ`。我们可以`用Aspect语法定义切面(Aspect)`,但是`织入过程(Weaving)`还是`Spring AOP完成`的

### 🍂 spring-aspectj-API

`TypePatternClassFilter` - 采用aspectj表达式匹配类

`AspectJExpressionPointCut` - 采用aspectj表达式匹配方法

`AspectJPointcutAdvisor` - 采用aspectj的Advisor(可以理解为spring aop定义的切面)

`ProxyFactoryBean` - 手动织入

`AspectJAwareAdvisorAutoProxyCreator` - 自动织入

`ProceedingJopintCut` - 用在@Advice中

- getTarget() - 获取target
- getThis() - 获取proxy
- getArgs() - 获取参数
- `proceed()` - 执行方法

## 🌲 spring-aspectj -手动织入

:one: 写Spring Aop的Advice​

```java
@Component("catBefore")
public class CatBeforeAdvice implements MethodBeforeAdvice {

    // 前置通知
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("Before - cat准备捕鱼 !!!");
    }
}

```

:two: 使用`ProxyFactoryBean`织入`AspectJExpressionPointcut`

```xml
 <!-- beforeAdvisor -->
<bean id="beforeAdvisor" class="org.springframework.aop.support.DefaultPointcutAdvisor">
    <property name="pointcut">
        <bean class="org.springframework.aop.aspectj.AspectJExpressionPointcut">
            <property name="expression" value="execution(* com.yuki.aop..Cat.*(..))" />
        </bean>
    </property>
    <property name="advice" ref="catBefore" />
</bean>

<!-- aspectj-手动织入 -->
<bean name="cat" class="org.springframework.aop.framework.ProxyFactoryBean">
    <!-- 不使用cglib代理 -->
    <property name="proxyTargetClass" value="true" />
    <property name="optimize" value="true" />
    <!-- 代理 -->
    <property name="target" ref="catTarget" />
    <property name="proxyInterfaces" value="com.yuki.aop.CatFace" />
    <property name="interceptorNames" value="beforeAdvisor" />
</bean>
```

## 🍀 Spring-aspectj-自动织入-注解

用到的注解如下

`@EnableAspectJAutoProxy` - 开启注解支持

`<aop:aspectj-autoproxy />` - 开启注解支持

`@Pointcut` - 定义切点

`@Before`、`@After`、`@AfterThrowing`、`@AfterReturning`、`@Around` - 定义切面

:one: 开启注解支持

```java
@EnableAspectJAutoProxy
@Configuration
@ComponentScan("com.yuki.aspect")
public class AspectConfig {
}
```

或者如下方式

```xml
<aop:aspectj-autoproxyproxy-target-class="true"/>
```

:two: 使用`@AspectJ注解`写切面

```java
@Aspect
@Component("catAspect")
public class CatAspect {

    // 定义切点
    @Pointcut("execution(* com.yuki.aspect..Cat.*(..))")
    public void catPoint() {}

    // Before Advice
    @Before("catPoint() && args(tool) && @annotation(anno)")
    public void beforeFish(String tool, CatAnno anno) {
        System.out.println("before  - Cat在准备装备!!! -- " + tool + "-----" + anno.values().toString());
    }

    // After throwing
    @AfterThrowing("catPoint()")
    public void afterThrow() {
        System.out.println("throwing - cat捕鱼失败 !!!");
    }

    // after return
    @AfterReturning("catPoint()")
    public void afterReturn() {
        System.out.println("return - Cat捕鱼成功 !!!");
    }

    // After
    @After("catPoint()")
    public void after() {
        System.out.println("after - Cat最后回到了家 !!!");
    }

    // Around
    @Around("catPoint()")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Around-------------");
        joinPoint.proceed();
        System.out.println("Around-------------");
    }
}
```

## 🍃Spring-aspectj-自动织入-xml方式

使用如下

```xml
<!-- aop -->
<aop:config>
    <!-- pointcut -->
    <aop:pointcut id="catPoint" expression="execution(* com.yuki.aspect..Cat.*(..))"/>
    <aop:pointcut id="catPointWithParam" expression="execution(* com.yuki.aspect..Cat.*(..)) &amp;&amp;  args(tool) &amp;&amp;  @annotation(anno)"/>
    <!-- aspect -->
    <aop:aspect id="catAspect" ref="catAspect">
        <!-- advice -->
        <aop:before method="beforeFish" pointcut-ref="catPointWithParam" />
        <aop:after method="after" pointcut-ref="catPoint" />
        <aop:after-returning method="afterReturn" pointcut-ref="catPoint" />
        <aop:after-throwing method="afterThrow" pointcut-ref="catPoint" />
        <aop:around method="around" pointcut-ref="catPoint" />
    </aop:aspect>
</aop:config>
```

## 🌿 aspectj表达式

#### 🌹 execution - 匹配什么

语法如下

```java
//     返回值  匹配的包、类、方法、参数
execution(*   com.sample.service.impl..*.*(..))
```

支持的`匹配符号`如下

- `*` - 表示任意
- `.`- 表示一层包
- `..` - 表示`多层包`或者`任意参数`

#### 🌷 @args - 把method参数传给advice

使用如下

```java
@Before("catPoint() && args(tool) && @annotation(anno)")
public void beforeFish(String tool, CatAnno anno) {
    System.out.println("before  - Cat在准备装备!!! -- " + tool + "-----" + 	anno.values().toString());
}

```

#### 🌼 @annotation- 把注解传给advice

```java
 @Before("catPoint() && args(tool) && @annotation(anno)")
public void beforeFish(String tool, CatAnno anno) {
    System.out.println("before  - Cat在准备装备!!! -- " + tool + "-----" + anno.values().toString());
}
```

## 🍖参考

[🍖 Aspect Oriented Programming with Spring](https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#aop)

[🍖 AspectJ切点表达式](https://blog.csdn.net/weixin_49930191/article/details/108360340)

> ​	