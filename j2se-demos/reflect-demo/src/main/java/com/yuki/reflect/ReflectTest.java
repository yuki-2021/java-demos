package com.yuki.reflect;



import sun.plugin.com.BeanClass;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/*
* Reflect反射 - 获取到Class对象，然后获取Constructor、Method、Field、Annotation，
*                             然后获取注解、调用构造函数、调用方法、获取字段的过程。
*
*
*   构造函数 - Constructor
*   Constructor<T>[] getConstructors() - 获取公有的Constructor
*   Constructor<T>   getConstructor(Class<?>... paramterTypes)
*   Constructor<T>[] getDeclaredConstructor() - 获取所有构造方法
*   Constructor<T>   getDeflcardConstrctor(Class<?>... paramTypes)
*
*   方法 - Method
*   Method[] getMethods() - 获取所有 public方法
*   Method getMethod()
*   Method[] getDeclaredMethods() - 获取自身的方法
*   Method getDeclaredMethod()
*
*   Field - 字段
*   Field[]  getFields()   - 获取public字段
*   Filed    getField()
*   Field[] getDeclaredFileds() - 获取所有字段
*   Field    getDeclaredField()
*
*   Annotation - 注解
*   Annotation getAnnoation()
*   Annitation getAnnoations()
*              getDeclaredAnnotation()
*              getDeclaredAnnoations()
*
*   getSuperClass()
*   getInterfaces()
*
*   getPackage()
*   getName()
*   getSimpleName()
*
*
* */
public class ReflectTest {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException, ClassNotFoundException {

        // 1. 获取Class<ClassBean>对象
        Class<ClassBean> beanClass = ClassBean.class;
        // 2. 反射操作
        /*
        * Construcoor - 创建对象
        * */
        System.out.println("------------Constructor ----------");
        Constructor<ClassBean> constructor = beanClass.getConstructor(String.class);
        ClassBean bean = constructor.newInstance("hello-world");
        System.out.println(bean);
        /*
        * Method
        * */
        System.out.println("------------ Method  -------------");
        Method info = beanClass.getMethod("info");
        info.invoke(bean);
        /*
        * Field
        * */
        System.out.println("------------ Field  -------------");
        Field name = beanClass.getDeclaredField("name");
        name.setAccessible(true);
        System.out.println(name.get(bean));

    }

    private static Class<ClassBean> classInfo() {
        // 1. 获取Class对象
        Class<ClassBean> beanClass = ClassBean.class;
        // 2. 获取Annotation、Method、Field、Constructor
        /*
        * Constructor 构造函数 -
        * */
        Constructor<?>[] constructors = beanClass.getConstructors();
        Constructor<?>[] declaredConstructors = beanClass.getDeclaredConstructors();
        System.out.println("------------- Constructor - 共有构造方法 ----------------------");
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor.getParameterTypes().length);
        }
        System.out.println("------------- DeclareConstructor - 共有构造方法 ----------------------");
        for (Constructor<?> constructor : declaredConstructors) {
            System.out.println(constructor.getParameterTypes().length);
        }
        /*
        * Method 方法 -
        * */
        Method[] methods = beanClass.getMethods();
        Method[] declaredMethods = beanClass.getDeclaredMethods();
        System.out.println("----------- Methods - 所有共有方法 ---------------");
        for (Method method : methods) {
            System.out.println(method.getName());
        }
        System.out.println("----------- DeclaredMethods - 自身所有方法 ---------------");
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod.getName());
        }
        /*
        * Filed -
        * */
        Field[] fields = beanClass.getFields();
        Field[] declaredFields = beanClass.getDeclaredFields();
        System.out.println("----------- Fields - 所有的Field ---------------");
        for (Field field : fields) {
            System.out.println(field.getName());
        }
        System.out.println("----------- DeclaredFields - 自己的Field ---------------");
        for (Field field : declaredFields) {
            System.out.println(field.getName());
        }
        /*
        * Annotation
        * */
        Deprecated anno = beanClass.getAnnotation(Deprecated.class);
        Annotation[] annos = beanClass.getAnnotations();
        Annotation[] declaredAnnos = beanClass.getDeclaredAnnotations();
        System.out.println("----------- getAnnotation()  ---------------");
        System.out.println(anno.annotationType());
        System.out.println("----------- getAnnotations() ---------------");
        for (Annotation annotation : annos) {
            System.out.println(anno.annotationType());
        }
        System.out.println(declaredAnnos.length);
        /*
        * 基本信息
        * */
        System.out.println("------------ 基本信息 -----------------------");
        System.out.println(beanClass.getPackage());
        System.out.println(beanClass.getSimpleName());
        System.out.println(beanClass.getName());
        System.out.println(beanClass.getSuperclass());
        System.out.println(beanClass.getInterfaces().getClass());
        return beanClass;
    }

    private static void getClasses() throws ClassNotFoundException {
        /*
         * 1. 三种方式获取 Class
         * */
        Class<ClassBean> beanClass1 = (Class<ClassBean>) Class.forName("com.yuki.reflect.ClassBean");
        Class<ClassBean> beanClass2 = ClassBean.class;
        Class<? extends ClassBean> beanClass3 = new ClassBean("aa").getClass();
        System.out.println(beanClass1);
        System.out.println(beanClass2);
        System.out.println(beanClass3);
    }
}
