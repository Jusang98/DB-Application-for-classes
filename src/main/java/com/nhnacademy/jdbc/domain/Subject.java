package com.nhnacademy.jdbc.domain;

import java.util.Date;

public class Subject {
    private final Long id;
    private final String name;
    private final Date createAt;

    public Subject(Long id, String name, Date createAt) {
        this.id = id;
        this.name = name;
        this.createAt = createAt;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getCreateAt() {
        return createAt;
    }

    @Override
    public String toString() {
        return name;
    }
}
