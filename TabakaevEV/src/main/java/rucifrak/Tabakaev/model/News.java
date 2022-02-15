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
    private String shortDesc;
    private String longDesc;
    @ManyToOne
    private NewsType newsType;

    public News() {
    }


    public static  News from(NewsDto newsDto){
        News news = new News();
        news.setName(newsDto.getName());
        news.setShortDesc(newsDto.getShortDesc());
        news.setLongDesc(newsDto.getLongDesc());
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

    public String getShortDesc() {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    public String getLongDesc() {
        return longDesc;
    }

    public void setLongDesc(String longDesc) {
        this.longDesc = longDesc;
    }

    public void setNewsType(NewsType newsType) {
        this.newsType = newsType;
    }
}
