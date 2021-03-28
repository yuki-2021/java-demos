Before Advice 
AfterReturning Advice 
After throwing Advice 
After Advice 
Adround Advice 


@EnableAspectJAutoProxy - 开启Aspect支持 
<aop:aspectj-autoproxy/>

<aop:config proxy-target-class="true">
    <!-- other beans defined here... -->
</aop:config>
<aop:aspectj-autoproxy proxy-target-class="true"/>


AspectJProxyFactory factory = new AspectJProxyFactory(targetObject);
factory.addAspect(SecurityManager.class);
factory.addAspect(usageTracker);
MyInterfaceType proxy = factory.getProxy();

PointCut---------------------------------- 
Pointcut - 在代理被创建时候，缓存匹配结果
    - getClassFilter()
    - getMethodMatcher()

StaticMethodMatcherPointcut - 方法匹配 - 抽象类
 - JdkRegexpMethodPointcut   - 正则切点 - 静态切点
 - NamedMatchMethodPointcut
DynamicMethodPointcut - 动态切点
 - ControlFlowPointcut - 流程切入点 - 动态切点

RootClassFilter - 筛选Class
TypePatternClassFilter - 指定的Class 

Advice ---------------------------------- 
Interceptor -  拦截器 - aopNameMatchMethodPointcut
MethodInceptor - 方法拦截器
    - MethodInvocation - 连接点
MethodBeforeAdvice - 前置通知
ThrowsAdvice
AfterReturningAdvice - 一个仅仅包含一个通知对象和与之关联的切入点表达式的切面

Advisor  ---------------------------------- 
DefaultPointcutAdvisor - 组合任意Advisor和Pointcut

FactoryBean --------------------------------
ProxyFactoryBean
    - proxyTargetClass - 强制使用cglib
    - optimize - 强制使用cglib
    - target - 目标类
    - interceptorNames - advice
    - interfaces - 实现的接口 
ProxyFactory

AutoProxyCreator -----------------------------------





TypePatternClassFilter - aspectj语法的ClassFilter
AspectJExpressionPointcut - aspectj语法的Pointcut
RegexpMethodPointcutAdvisor - aspectj语法的Advisor
ProxyFactoryBean - 手动创建代理
AspectJAwareAdvisorAutoProxyCreator - 自动完成aspect语法切面的织入









