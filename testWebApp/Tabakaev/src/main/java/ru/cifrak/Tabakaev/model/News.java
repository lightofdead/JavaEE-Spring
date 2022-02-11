package ru.cifrak.Tabakaev.model;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "news")
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name ="name")
    private String name;
    @Column(name =  "short_description")
    private String short_description;
    @Column(name =  "full_description")
    private String full_description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="news_type")
    private NewsType newsType;


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

   /* public News(String name, String short_description, String full_description*//*, NewsType newsType*//*) {
        this.name = name;
        this.short_description = short_description;
        this.full_description = full_description;
        *//*this.newsType = newsType;*//*
    }*/

    public String getShort_description() {
        return short_description;
    }

    public String getFull_description() {
        return full_description;
    }



    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setShort_description(String short_description) {
        this.short_description = short_description;
    }

    public void setFull_description(String full_description) {
        this.full_description = full_description;
    }

    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", short_description='" + short_description + '\'' +
                ", full_description='" + full_description + '\'' +
               /* ", newsType=" + newsType +*/
                '}';
    }
}
