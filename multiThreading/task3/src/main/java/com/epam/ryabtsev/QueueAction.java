package com.epam.ryabtsev;

import java.util.PriorityQueue;
import java.util.Queue;

public class QueueAction {
    private static final int MAX_SIZE_QUEUE = 30;
    private static Queue<String> messages = new PriorityQueue<>();

    synchronized public void addMessage(String message) throws InterruptedException {
        while (messages.size() == MAX_SIZE_QUEUE) {
            wait();
        }
        messages.add(message);
        notifyAll();
    }

    synchronized public String readMessage() throws InterruptedException {
        String message;
        while (messages.size() == 0) {
            wait();
        }
        message = messages.poll();
        notify();

        return message;
    }
}
