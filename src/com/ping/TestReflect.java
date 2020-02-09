package com.ping;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author:lyp
 * @date 2020/2/7-10:54
 * 测试反射
 */
public class TestReflect {

    //反射之前对person可以进行操作
    @Test
    public void test1(){
        //1.创建person对象
        Person person=new Person("tom",11);
        person.age=10;
        System.out.println(person.toString());

        person.show();

        //在person外部，不可以调用person对象内部的私有方法
        //比如私有的name,showNation以及私有构造器
    }

    //通过反射对person可以进行操作
    @Test
    public void test2() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        /**
         * 1.使用反射调用公有的构造方法，属性和方法
         */
        //1.创建person对象
        Class personClass = Person.class;
        Constructor constructor = personClass.getConstructor(String.class, int.class);
        Object tom = constructor.newInstance("Tom", 10);
        Person p=(Person)tom;
        System.out.println(tom);
        //2.通过反射获取属性和方法
        Field age = personClass.getDeclaredField("age");
        age.set(p,15);
        System.out.println(p);
        Method show = personClass.getDeclaredMethod("show");
        show.invoke(p);

        /**
         * 2.使用反射调用私有构造方法、属性、方法
         */
        Constructor constructor1 = personClass.getDeclaredConstructor(String.class);
        constructor1.setAccessible(true);
        Object newInstance = constructor1.newInstance("陈龙");
        Person p1=(Person)newInstance;
        System.out.println(p1);
        //调用私有属性
        Field name = personClass.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p1,"李耀平");
        System.out.println(p1);
        //调用私有方法
        Method showNation = personClass.getDeclaredMethod("showNation",String.class);
        showNation.setAccessible(true);
        showNation.invoke(p1,"日本子");

    }

    /**
     * 3.通过class实例方式
     */
    @Test
    public void test3() throws ClassNotFoundException {
        //方式1
        Class<Person> personClass = Person.class;
        System.out.println(personClass);

        //方式2
        Person person=new Person();
        Class aClass = person.getClass();
        System.out.println(aClass);

        //方式3
        Class aClass1 = Class.forName("com.ping.Person");
        System.out.println(aClass1);

        System.out.println(personClass==aClass);
        System.out.println(personClass==aClass1);
    }
}
