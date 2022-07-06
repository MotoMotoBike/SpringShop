package ru.spring.P50218.kazanin.models;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Entity
@Table(name = "news")
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;

    private  String header;
    @Column(length = 2550)
    private  String text;
    private Date date;

    @ManyToOne( optional = true,cascade = CascadeType.ALL)
    private Kategory kategory;

    @ManyToOne( optional = true,cascade = CascadeType.ALL)
    private Image imageNews;

    @ManyToMany
    @JoinTable(name = "tovarInNews",
        joinColumns = @JoinColumn(name = "news_id"),
        inverseJoinColumns = @JoinColumn(name = "university_id"))
    private List<Tovar> tovars;

    public void setId(Long id) {
        this.id = id;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setKategory(Kategory kategory) {
        this.kategory = kategory;
    }

    public void setImageNews(Image imageNews) {
        this.imageNews = imageNews;
    }

    public void setTovars(List<Tovar> tovars) {
        this.tovars = tovars;
    }

    public Long getId() {
        return id;
    }

    public String getHeader() {
        return header;
    }

    public String getText() {
        return text;
    }

    public Date getDate() {
        return date;
    }

    public Kategory getKategory() {
        return kategory;
    }

    public Image getImageNews() {
        return imageNews;
    }

    public List<Tovar> getTovars() {
        return tovars;
    }
}
