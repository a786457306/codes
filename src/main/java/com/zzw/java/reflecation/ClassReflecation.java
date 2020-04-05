package com.zzw.java.reflecation;

import com.zzw.utils.ClassUtils;
import com.zzw.utils.Person;

/**
 * asSubclass(Class<U> clazz)	把传递的类的对象转换成代表其子类的对象
 * Cast	把对象转换成代表类或是接口的对象
 * getClassLoader()	获得类的加载器
 * getClasses()	返回一个数组，数组中包含该类中所有公共类和接口类的对象
 * getDeclaredClasses()	返回一个数组，数组中包含该类中所有类和接口类的对象
 * forName(String className)	根据类名返回类的对象
 * getName()	获得类的完整路径名字
 * newInstance()	创建类的实例
 * getPackage()	获得类的包
 * getSimpleName()	获得类的名字
 * getSuperclass()	获得当前类继承的父类的名字
 * getInterfaces()	获得当前类实现的类或是接口
 *
 * @author Daydreamer
 * @date 2019/11/27 15:25
 */
public class ClassReflecation {

    public static void getPersonClass() throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        // 1. 获取person的.class文件

        ClassLoader classLoader = ClassUtils.getDefaultClassLoader();
        Person o = (Person)classLoader.loadClass("com.zzw.utils.Person").newInstance();
        System.out.println(o);
    }

    public static void main(String[] args) throws Exception {
        getPersonClass();
    }
}
