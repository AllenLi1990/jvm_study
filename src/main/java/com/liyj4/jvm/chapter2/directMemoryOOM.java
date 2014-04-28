package com.liyj4.jvm.chapter2;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * Created by lyj on 2014/4/10.
 */
public class directMemoryOOM {

    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) throws Exception{
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe)unsafeField.get(null);
        while(true){
            unsafe.allocateMemory(_1MB);
        }
    }


}
