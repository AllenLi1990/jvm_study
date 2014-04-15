package com.liyj4.jvm.chapter3;

/**
 * User: liyj4
 * Date: 14-4-15
 * Time: 下午9:55
 */
public class NewRegionMinorGC {

    private static final int _1MB = 1024 * 1024;

    public static void testAllocation(){
        byte[] allocation1, allocation2, allocation3, allocation4;

        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];


        allocation4 = new byte[4 * _1MB];   // MinorGC
    }

    public static void main(String[] args){
        testAllocation();
    }

}
