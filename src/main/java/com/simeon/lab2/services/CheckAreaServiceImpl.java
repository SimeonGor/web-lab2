package com.simeon.lab2.services;

import jakarta.enterprise.inject.Model;

import java.math.BigDecimal;

@Model
public class CheckAreaServiceImpl implements CheckAreaService {
    @Override
    public boolean check(BigDecimal x, BigDecimal y, BigDecimal r) {
        return checkFirstQuarter(x, y, r)
                || checkSecondQuarter(x, y, r)
                || checkThirdQuarter(x, y, r)
                || checkForthQuarter(x, y, r);
    }

    private boolean checkFirstQuarter(BigDecimal x, BigDecimal y, BigDecimal r) {
        if (x.compareTo(new BigDecimal("0")) < 0 || y.compareTo(new BigDecimal("0")) < 0) return false;
        return (x.multiply(x).add(y.multiply(y))).compareTo(r.multiply(r)) <= 0;
    }

    private boolean checkSecondQuarter(BigDecimal x, BigDecimal y, BigDecimal r) {
        return false;
    }

    private boolean checkThirdQuarter(BigDecimal x, BigDecimal y, BigDecimal r) {
        if (x.compareTo(new BigDecimal("0")) > 0 || y.compareTo(new BigDecimal("0")) > 0) return false;
        return y.add(x).compareTo(r.negate()) >= 0;
    }

    private boolean checkForthQuarter(BigDecimal x, BigDecimal y, BigDecimal r) {
        if (x.compareTo(new BigDecimal("0")) < 0 || y.compareTo(new BigDecimal("0")) > 0) return false;
        return x.compareTo(r) <= 0 && y.compareTo(r.negate()) >= 0;
    }
}
