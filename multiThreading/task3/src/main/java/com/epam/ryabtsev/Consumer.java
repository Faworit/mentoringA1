package com.epam.ryabtsev;

public class Consumer extends Thread{
    QueueAction queueAction = new QueueAction();

    public void run() {
        for (int i = 1; i > 0; i++) {
            synchronized (QueueAction.class) {
                System.out.println("Message from queue: " + queueAction.readMessage());
            }
            try {
                Thread.sleep(4);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
