package com.epam.ryabtsev;

import java.util.PriorityQueue;
import java.util.Queue;

public class QueueAction {
    static Queue<String> messages = new PriorityQueue<>();

    public void addMessage(String message) {
        messages.add(message);
    }

    public String readMessage() {
        String message;
        if (!messages.isEmpty()) {
            message = messages.poll();
        } else {
            message = "No active messages in queue";
        }
        return message;
    }
}
