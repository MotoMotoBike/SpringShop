package ru.spring.P50218.kazanin.models;

import javax.persistence.*;
import java.util.Collection;


@Entity
@Table(name = "kategorys")
public class Kategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private  String name;

    @OneToMany(mappedBy = "kategory",fetch = FetchType.EAGER)
    private Collection<News> news;

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNews(Collection<News> news) {
        this.news = news;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Collection<News> getNews() {
        return news;
    }
}
