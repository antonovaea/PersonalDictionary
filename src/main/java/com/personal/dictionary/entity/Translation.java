package com.personal.dictionary.entity;

import org.springframework.data.relational.core.mapping.Column;

import javax.persistence.*;

@Entity
@Table(name = "translations", schema = "public")
public class Translation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column("id")
    private Long id;

    @Column("value")
    private String value;

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Translation() {
    }

    public Translation(Long id, String value) {
        this.id = id;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Translation{" +
                "id=" + id +
                ", value='" + value + '\'' +
                '}';
    }
}
