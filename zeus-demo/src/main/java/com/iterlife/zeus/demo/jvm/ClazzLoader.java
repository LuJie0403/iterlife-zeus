package com.iterlife.zeus.demo.jvm;

import java.io.IOException;
import java.io.InputStream;
import java.security.CodeSource;
import java.security.ProtectionDomain;
import java.security.cert.Certificate;

public class ClazzLoader {

    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        //双亲委派机制，最终被系统内置的加载器加载
        ClassLoader classLoader = new String().getClass().getClassLoader();
        ClassLoader myClassLoader = new MyClassLoader();

        Object string = new String();
        //Exception in thread "main" java.lang.SecurityException: Prohibited package name: java.lang
        Object myString = myClassLoader.loadClass("java.lang.String").newInstance();

        System.out.println("[string.getClass()]:" + string.getClass() + " | " + myString.getClass());
        System.out.println("[string.getClass().getClassLoader()]:" + string.getClass().getClassLoader() + " | " + myString.getClass().getClassLoader());
        System.out.println("[string.equals(\"\")]:" + string.equals("") + " | " + myString.equals(""));
        System.out.println("[string.equals(\"One\")]:" + string.equals("One") + " | " + myString.equals("One"));
        System.out.println("[string instanceof String]:" + (string instanceof String) + " | " + (myString instanceof String));
        //    System.out.println("[loader instanceof ClassLoader]:" + (classLoader instanceof ClassLoader) + " | " + (myClassLoader instanceof ClassLoader));
        //    System.out.println("[loader instanceof ClazzLoader]:" + (classLoader instanceof MyClassLoader) + " | " + (classLoader instanceof MyClassLoader));
    }
}

class MyClassLoader extends ClassLoader {

    static native Class<?> defineClass1(ClassLoader loader, String name, byte[] b, int off, int len, ProtectionDomain pd, String source);

    //用自定义的类加载器加载一个类
    @Override
    public Class<?> loadClass(String className) throws ClassNotFoundException {
        //加载 String 类型
        int length = className.lastIndexOf(".") + 1;
        String fileName = new StringBuilder("/java/lang/").append(className.substring(length)).append(".class").toString();
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
       // return defineMyClass(className, bytes, 0, bytes.length, new ProtectionDomain(new CodeSource(null, (Certificate[]) null), null, this, null));
    }

    private Class<?> defineMyClass(String name, byte[] b, int off, int len, ProtectionDomain protectionDomain) throws ClassFormatError {
        CodeSource cs = protectionDomain.getCodeSource();
        String source = null;
        if (cs != null && cs.getLocation() != null) {
            source = cs.getLocation().toString();
        }
        return defineClass1(this, name, b, off, len, protectionDomain, source);
    }
}


