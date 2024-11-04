package com.simeon.lab2.beans;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class History implements Serializable {
    @Serial
    private static final long serialVersionUID = 4078483457730741479L;

    private final List<CheckResult> resultList = new ArrayList<>();

    public List<CheckResult> getResultList() {
        return resultList;
    }

    public void addResult(CheckResult result) {
        resultList.add(result);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        History history = (History) o;
        return Objects.equals(resultList, history.resultList);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(resultList);
    }

    @Override
    public String toString() {
        return "History{" +
                "resultList=" + resultList +
                '}';
    }
}
