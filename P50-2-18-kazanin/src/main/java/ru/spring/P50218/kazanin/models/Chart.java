package ru.spring.P50218.kazanin.models;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "cart")
public class Chart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;
    private int Count;

    @ManyToOne( optional = true,cascade = CascadeType.ALL)
    private User user;
    @ManyToOne( optional = true,cascade = CascadeType.ALL)
    private Tovar tovar;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCount() {
        return Count;
    }

    public void setCount(int count) {
        Count = count;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Tovar getTovar() {
        return tovar;
    }

    public void setTovar(Tovar tovar) {
        this.tovar = tovar;
    }
}
