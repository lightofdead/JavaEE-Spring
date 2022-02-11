package ru.cifrak.Tabakaev.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "news_type")
@ToString
public class NewsType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name ="name")
    private String name;
    @Column(name ="color")
    private String color;

    @OneToMany(mappedBy = "newsType", fetch = FetchType.LAZY)
    private List<News> news;

    public NewsType() {

    }

   /* public NewsType(String name, String color*//*, List<News> news*//*) {
        this.name = name;
        this.color = color;
        //this.news = news;
    }*/

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setColor(String color) {
        this.color = color;
    }

}
