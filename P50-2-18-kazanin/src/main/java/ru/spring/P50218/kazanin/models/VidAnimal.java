package ru.spring.P50218.kazanin.models;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "vid")
public class VidAnimal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private  String name;

    @OneToMany(mappedBy = "vidAnimal",fetch = FetchType.LAZY)
    Collection<Poroda> poroda;

    @OneToMany(mappedBy = "vidAnimal",fetch = FetchType.LAZY)
    Collection<Tovar> tovar;

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPoroda(Collection<Poroda> poroda) {
        this.poroda = poroda;
    }

    public void setTovar(Collection<Tovar> tovar) {
        this.tovar = tovar;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Collection<Poroda> getPoroda() {
        return poroda;
    }

    public Collection<Tovar> getTovar() {
        return tovar;
    }
}
