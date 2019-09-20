package com.tonasolution;

import static com.tonasolution.ThreadColor.ANSI_BLUE;

public class AnotherThread extends Thread{
    @Override
    public void run() {

        System.out.println(ANSI_BLUE + "Hello from another thread : " + currentThread().getName());

        try {
            sleep(3000);
        } catch (InterruptedException e) {
            System.out.println(ANSI_BLUE + "Another thread woke up me ");
        }

        System.out.println(ANSI_BLUE + "Another thread: Three second passed");
    }
}
