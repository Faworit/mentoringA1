package com.epam.ryabtsev;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * Pool that block when it has not any items or it full
 */
public class BlockingObjectPool {
    private static ArrayBlockingQueue<Object> pool;
    private static BlockingObjectPool blockingObjectPool = null;

    private BlockingObjectPool() {
    }

    public synchronized BlockingObjectPool getInstance() {
        if (blockingObjectPool == null) {
            blockingObjectPool = new BlockingObjectPool();
        }

        return blockingObjectPool;
    }

    /**
     * Creates filled pool of passed size * * @param size of pool
     */
    public BlockingObjectPool(int size) {
        this.pool = new ArrayBlockingQueue<>(size);
    }

    /**
     * Gets object from pool or blocks if pool is empty * * @return object from pool
     */
    public Object get() {
        Object object = null;
        try {
            object = pool.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return object;
    }

    /**
     * Puts object to pool or blocks if pool is full * * @param object to be taken back to pool
     */
    public void take(Object object) {
        if ( (object != null) && (pool.size()<= pool.remainingCapacity())) {
            try {
                pool.put(object);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}