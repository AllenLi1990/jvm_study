package com.liyj4.jvm.chapter2;

/**
 * User: liyj4
 * Date: 14-4-9
 * Time: 下午8:24
 */
public class JavaVmStackSOF {

    private int stackLength = 1;

    public void stackLeak(){
        stackLength++;
        byte[] bytes = new  byte[50000];
        stackLeak();
    }

    private void dontStop(){
        while(true){

        }
    }

    public void stackLeakByThread(){
        while(true){
            Thread thread = new Thread(new Runnable(){

                @Override
                public void run() {
                    dontStop();
                }
            });
            thread.start();
        }
    }

    public static void main(String[] args) throws Throwable{
        JavaVmStackSOF oom = new JavaVmStackSOF();
        oom.stackLeakByThread();
        try{
//            oom.stackLeak();

        } catch(Throwable e) {
            System.out.println("stack length:" + oom.stackLength);
            throw e;
        }
    }
}
