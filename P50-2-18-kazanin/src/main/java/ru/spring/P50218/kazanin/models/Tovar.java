package ru.spring.P50218.kazanin.models;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "tovar")
public class Tovar {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long    id;
    @NotNull
    private String  name;
    @Column(length = 2550)
    @Size(min = 1 , max = 2550)
    @NotNull
    private String  discription;

    @NotNull
    private Integer count;
    @NotNull
    private Integer cost;

    @ManyToOne(optional = true,cascade = CascadeType.ALL)
    private Image imageTovar;

    @ManyToOne(optional = true,cascade = CascadeType.ALL)
    private VidAnimal vidAnimal;

    @ManyToMany
    @JoinTable(name = "tovarInNews",
            joinColumns = @JoinColumn(name = "university_id"),
            inverseJoinColumns = @JoinColumn(name = "news_id"))
    private List<News> news;

    @OneToMany(mappedBy = "tovar",fetch = FetchType.LAZY)
    Collection<Chart> cart;

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public void setImageTovar(Image imageTovar) {
        this.imageTovar = imageTovar;
    }

    public void setVidAnimal(VidAnimal vidAnimal) {
        this.vidAnimal = vidAnimal;
    }

    public void setNews(List<News> news) {
        this.news = news;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDiscription() {
        return discription;
    }

    public Integer getCount() {
        return count;
    }

    public Integer getCost() {
        return cost;
    }

    public Image getImageTovar() {
        return imageTovar;
    }

    public VidAnimal getVidAnimal() {
        return vidAnimal;
    }

    public List<News> getNews() {
        return news;
    }
}
