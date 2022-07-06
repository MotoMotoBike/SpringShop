package ru.spring.P50218.kazanin.models;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.util.Collection;

@Entity
@Table(name = "poroda")
public class Poroda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @NotNull
    private String name;

    @ManyToOne(optional = true,cascade = CascadeType.ALL)
    private VidAnimal vidAnimal;

    @OneToMany(mappedBy = "poroda",fetch = FetchType.LAZY)
    private Collection<SovetPoUhody> sovetPoUhody;

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVidAnimal(VidAnimal vidAnimal) {
        this.vidAnimal = vidAnimal;
    }

    public void setSovetPoUhody(Collection<SovetPoUhody> sovetPoUhody) {
        this.sovetPoUhody = sovetPoUhody;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public VidAnimal getVidAnimal() {
        return vidAnimal;
    }

    public Collection<SovetPoUhody> getSovetPoUhody() {
        return sovetPoUhody;
    }
}
