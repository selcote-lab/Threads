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
                try {
                    anotherThread.join(2000);
                    System.out.println(ANSI_BLUE + "Anotherthread terminated.So, I am running again");
                } catch (InterruptedException e) {
                    System.out.println(ANSI_BLUE + " I couldn't wait after all. I was interrupted");
                }
            }
        }).start();
//        anotherThread.interrupt();
        System.out.println(ANSI_CYAN + "Hello again from the main thread");

    }
}
