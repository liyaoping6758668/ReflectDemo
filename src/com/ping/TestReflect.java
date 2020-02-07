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

    }
}
