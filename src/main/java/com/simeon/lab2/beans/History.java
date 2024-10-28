package com.simeon.lab2.beans;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class History implements Serializable {
    @Serial
    private static final long serialVersionUID = 4078483457730741479L;

    private final List<CheckResult> resultList = new ArrayList<>();

    public History() {}

    public List<CheckResult> getResultList() {
        return resultList;
    }

    public void addResult(CheckResult result) {
        resultList.add(result);
    }
}
