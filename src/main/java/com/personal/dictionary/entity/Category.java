package com.personal.dictionary.entity;

import org.springframework.data.relational.core.mapping.Column;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categories", schema = "public")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column("id")
    private Long id;

    @Column("name")
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category", cascade = CascadeType.ALL)
    private List<Word> wordsInCategory = new ArrayList<>();

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "id")
    private User user;

    public List<Word> getWordsInCategory() {
        return wordsInCategory;
    }

    public void setWordsInCategory(List<Word> wordsInCategory) {
        this.wordsInCategory = wordsInCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }

    public Category() {
    }

    public Category(Long id, String name, List<Word> wordsInCategory) {
        this.id = id;
        this.name = name;
        this.wordsInCategory = wordsInCategory;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", wordsInCategory=" + wordsInCategory +
                '}';
    }
}
