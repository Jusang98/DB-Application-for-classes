package com.nhnacademy.jdbc.domain;

import java.util.Date;

public class Teacher {
    private final Long id;
    private final String name;
    private final Date createAt;

    public Teacher(Long id, String name, Date createAt) {
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
