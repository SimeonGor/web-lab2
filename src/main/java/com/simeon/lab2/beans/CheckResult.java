package com.simeon.lab2.beans;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class CheckResult implements Serializable {
    @Serial
    private static final long serialVersionUID = 2524062387050598152L;

    private BigDecimal x;
    private BigDecimal y;
    private BigDecimal r;
    private boolean hit;
    private long workingTime;
    private LocalDateTime createdAt;

    public CheckResult() {}

    public CheckResult(BigDecimal x, BigDecimal y, BigDecimal r, boolean hit, long workingTime, LocalDateTime createdAt) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.hit = hit;
        this.workingTime = workingTime;
        this.createdAt = createdAt;
    }

    public BigDecimal getX() {
        return x;
    }

    public void setX(BigDecimal x) {
        this.x = x;
    }

    public BigDecimal getY() {
        return y;
    }

    public void setY(BigDecimal y) {
        this.y = y;
    }

    public BigDecimal getR() {
        return r;
    }

    public void setR(BigDecimal r) {
        this.r = r;
    }

    public boolean isHit() {
        return hit;
    }

    public void setHit(boolean hit) {
        this.hit = hit;
    }

    public long getWorkingTime() {
        return workingTime;
    }

    public void setWorkingTime(long workingTime) {
        this.workingTime = workingTime;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
