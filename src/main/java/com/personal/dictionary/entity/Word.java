package com.personal.dictionary.entity;

import org.springframework.data.relational.core.mapping.Column;

import javax.persistence.*;

@Entity
@Table(name = "words", schema = "public")
public class Word {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column("id")
    private Long id;

    @Column("value")
    private String value;

    @Column("isNew")
    private boolean isNew;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private Translation translation;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "id")
    private Category category;


    public Translation getTranslation() {
        return translation;
    }

    public void setTranslation(Translation translation) {
        this.translation = translation;
    }

    public boolean isNew() {
        return isNew;
    }

    public void setNew(boolean aNew) {
        isNew = aNew;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }

    public Word() {
    }

    public Word(Long id, String value, boolean isNew, Translation translation) {
        this.id = id;
        this.value = value;
        this.isNew = isNew;
        this.translation = translation;
    }

    @Override
    public String toString() {
        return "Word{" +
                "id=" + id +
                ", value='" + value + '\'' +
                ", isNew=" + isNew +
                ", translation=" + translation +
                '}';
    }
}
