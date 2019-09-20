package com.tonasolution;

import static com.tonasolution.ThreadColor.*;

public class Main {

    public static void main(String[] args) {
        System.out.println(ANSI_PURPLE + "Hello from the main thread");

        Thread anotherThread = new AnotherThread();
        anotherThread.setName("Another thread");
        anotherThread.start();

        new Thread(){
            public void run() {
                System.out.println(ANSI_GREEN + "Hello from anonymous class thread");
            }
        }.start();

//        Thread myRunnableThread = new Thread(new MyRunnable());
//        myRunnableThread.start();

        new Thread(new MyRunnable(){
            @Override
            public void run() {
                System.out.println(ANSI_BLUE + " MyRunnable anonymous class");
            }
        }).start();
        System.out.println(ANSI_CYAN + "Hello again from the main thread");

    }
}
