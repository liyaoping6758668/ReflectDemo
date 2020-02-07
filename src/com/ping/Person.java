package com.ping;

/**
 * @author:lyp
 * @date 2020/2/7-10:54
 */
public class Person {
    private String name;
    public  int age;

    //公有参构造函数
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    //公有无参数构造函数
    public Person() {
    }
    //私有构造函数
    private Person(String name) {
        this.name = name;
    }

    //get、set方法
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    //toString()方法
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    //公有方法
    public void show(){
        System.out.println("你好，我是一个人");
    }

    //私有方法
    private String showNation(String nation){
        System.out.println("我的国籍是"+nation);
        return nation;
    }
}
