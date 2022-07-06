package ru.spring.P50218.kazanin.models;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "images")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;
    private  String url;

    @OneToMany(mappedBy = "imageNews",fetch = FetchType.LAZY)
    private Collection<News> news;

    @OneToMany(mappedBy = "imageSovet",fetch = FetchType.LAZY)
    private Collection<SovetPoUhody> sovetPoUhody;

    @OneToMany(mappedBy = "imageTovar",fetch = FetchType.LAZY)
    private Collection<Tovar> tovar;

    public void setId(Long id) {
        this.id = id;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setNews(Collection<News> news) {
        this.news = news;
    }

    public void setSovetPoUhody(Collection<SovetPoUhody> sovetPoUhody) {
        this.sovetPoUhody = sovetPoUhody;
    }

    public void setTovar(Collection<Tovar> tovar) {
        this.tovar = tovar;
    }

    public Long getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public Collection<News> getNews() {
        return news;
    }

    public Collection<SovetPoUhody> getSovetPoUhody() {
        return sovetPoUhody;
    }

    public Collection<Tovar> getTovar() {
        return tovar;
    }

}
