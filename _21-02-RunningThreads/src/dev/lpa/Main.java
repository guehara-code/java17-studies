package dev.lpa;

public class Main {

    public static void main(String[] args) {

        System.out.println("Main thread running");
        try {
            System.out.println("Main thread paused for one second");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread thread = new Thread(() -> {
            String tname = Thread.currentThread().getName();
            System.out.println(tname + " should take 10 dots to run.");
            for (int i = 0; i < 10; i++) {
                System.out.print(". ");
                try {
                    Thread.sleep(500);
//                    System.out.println("A. State = " + Thread.currentThread().getState());
                } catch (InterruptedException e) {
                    System.out.println("\nWhoops!! " + tname + " interrupted.");
                    Thread.currentThread().interrupt();
//                    System.out.println("A1. State =  " + Thread.currentThread().getState());
                    return;
                }
            }
            System.out.println("\n" + tname + " completed.");
        });

        Thread installThread = new Thread(() -> {
            try {
                for (int i = 0; i < 3; i++) {
                    Thread.sleep(250);
                    System.out.println("Installation Step " + (i + 1) +
                            " is completed.");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "InstallThread");

//        System.out.println(thread.getName() + " starting");
//        thread.start();

//        System.out.println("Main thread would continue here");
//
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        thread. interrupt();

        Thread threadMonitor = new Thread(() -> {
            long now = System.currentTimeMillis();
            while (thread.isAlive()) {
                try {
                    Thread.sleep(1000);
                    if (System.currentTimeMillis() - now > 2000) {
                        thread.interrupt();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }});

        System.out.println(thread.getName() + " starting");
        thread.start();
        threadMonitor.start();

//        long now = System.currentTimeMillis();
//        while (thread.isAlive()) {
////            System.out.println("\nWaiting for thread to complete");
//            try {
//                Thread.sleep(1000);
////                System.out.println("B. State = " + thread.getState());
//
//                if (System.currentTimeMillis() - now > 2000) {
//                    thread.interrupt();
//                }
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }

//        System.out.println("C. State = " + thread.getState());

        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if (!thread.isInterrupted()) {
            installThread.start();
        } else {
            System.out.println("Previous thread was interrupted, " +
                    installThread.getName() + " can't run.");
        }
    }
}
