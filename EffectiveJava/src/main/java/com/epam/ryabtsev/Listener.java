package com.epam.ryabtsev;

import com.epam.ryabtsev.entity.Entry;
import com.google.common.cache.RemovalListener;
import com.google.common.cache.RemovalNotification;

public class Listener implements RemovalListener<Long, Entry> {

    @Override
    public void onRemoval(RemovalNotification<Long, Entry> removalNotification) {
        System.out.println(removalNotification.getCause() + " " + removalNotification.getValue());
    }
}