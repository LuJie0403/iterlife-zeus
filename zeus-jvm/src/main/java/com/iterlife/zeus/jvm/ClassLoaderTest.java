package com.iterlife.zeus.jvm;

import java.io.IOException;
import java.io.InputStream;

public class ClassLoaderTest {

    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        Object object = new MyClassLoader().loadClass("com.iterlife.zeus.jvm.ClassLoaderTest").newInstance();
        //双亲委派机制，最终被系统内置的加载器加载
        Object string = new MyClassLoader().loadClass("java.lang.String").newInstance();

        System.out.println("[string.getClass()]:" + string.getClass());
        System.out.println("[string.toString()]:" + string.toString());
        System.out.println("[string.equals(\"\")]:" + string.equals(""));
        System.out.println("[string.equals(\"111\")]:" + string.equals("111"));
        System.out.println(string instanceof String);

        System.out.println("[object.getClass()]:" + object.getClass());
        System.out.println(object instanceof ClassLoaderTest);

    }
}

class MyClassLoader extends ClassLoader {
    //用自定义的类加载器加载一个类
    @Override
    public Class<?> loadClass(String className) throws ClassNotFoundException {
        //加载 String 类型
        int length = className.lastIndexOf(".") + 1;
        String fileName = className.substring(length).concat(".class");
        InputStream inputStream = getClass().getResourceAsStream(fileName);
        if (inputStream == null) {
            return super.loadClass(className);
        }
        byte[] bytes = new byte[0];
        try {
            bytes = new byte[inputStream.available()];
            inputStream.read(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return defineClass(className, bytes, 0, bytes.length);
    }
}


