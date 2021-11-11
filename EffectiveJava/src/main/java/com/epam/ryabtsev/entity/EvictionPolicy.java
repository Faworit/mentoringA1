package com.epam.ryabtsev.entity;

import java.util.Objects;

public class EvictionPolicy implements Comparable<EvictionPolicy> {
    Integer key;
    Integer hitCount;
    Long lastTime;

    public EvictionPolicy(Integer key, Integer hitCount, Long lastTime) {
        this.key = key;
        this.hitCount = hitCount;
        this.lastTime = lastTime;
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public Integer getHitCount() {
        return hitCount;
    }

    public void setHitCount(Integer hitCount) {
        this.hitCount = hitCount;
    }

    public Long getLastTime() {
        return lastTime;
    }

    public void setLastTime(Long lastTime) {
        this.lastTime = lastTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EvictionPolicy that = (EvictionPolicy) o;
        return Objects.equals(key, that.key) && Objects.equals(hitCount, that.hitCount) && Objects.equals(lastTime, that.lastTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, hitCount, lastTime);
    }

    public int compareTo(EvictionPolicy o) {
        int hr = hitCount.compareTo(o.hitCount);
        return hr != 0 ? hr : lastTime.compareTo(o.lastTime);
    }

}
