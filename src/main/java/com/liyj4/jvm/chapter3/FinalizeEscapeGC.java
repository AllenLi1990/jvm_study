package com.liyj4.jvm.chapter3;

/**
 * User: liyj4
 * Date: 14-4-13
 * Time: 下午9:29
 */
public class FinalizeEscapeGC {

    public static FinalizeEscapeGC SAVE_HOOK = null;

    public void isAlive(){
        System.out.println("yes i ma alive");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize method invoked");
        FinalizeEscapeGC.SAVE_HOOK = this;
    }

    public static void main(String[] args) throws InterruptedException {
        SAVE_HOOK = new FinalizeEscapeGC();

        SAVE_HOOK = null;

        System.gc();

        Thread.sleep(500);

        if(SAVE_HOOK != null){
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("oh, i am dead");
        }



        SAVE_HOOK = null;

        System.gc();

        Thread.sleep(500);

        if(SAVE_HOOK != null){
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("oh, i am dead");
        }
    }
}
