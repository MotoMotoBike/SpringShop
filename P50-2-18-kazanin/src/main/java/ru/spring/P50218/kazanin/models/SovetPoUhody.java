package ru.spring.P50218.kazanin.models;

import javax.persistence.*;

@Entity
@Table(name = "sovet")
public class SovetPoUhody {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;
    private String header;

    @Column(length = 2550)
    private String text;

    @ManyToOne(optional = true,cascade = CascadeType.ALL)
    private Poroda poroda;

    @ManyToOne( optional = true,cascade = CascadeType.ALL)
    private Image imageSovet;

    public void setId(Long id) {
        this.id = id;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setPoroda(Poroda poroda) {
        this.poroda = poroda;
    }

    public void setImageSovet(Image imageSovet) {
        this.imageSovet = imageSovet;
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

    public Poroda getPoroda() {
        return poroda;
    }

    public Image getImageSovet() {
        return imageSovet;
    }
}
