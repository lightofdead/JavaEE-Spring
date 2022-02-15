package rucifrak.Tabakaev.model;

import lombok.*;
import rucifrak.Tabakaev.model.dto.NewsDto;

import javax.persistence.*;

@Entity
@Table(name = "News")
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @ManyToOne
    private NewsType newsType;

    public News() {
    }

    public News(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public static  News from(NewsDto newsDto){
        News news = new News();
        news.setName(newsDto.getName());
        return news;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public NewsType getNewsType() {
        return newsType;
    }

    public void setNewsType(NewsType newsType) {
        this.newsType = newsType;
    }
}
