package rucifrak.Tabakaev.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import rucifrak.Tabakaev.model.dto.NewsTypeDto;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "NewsType")
public class NewsType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private  String name;
    @OneToMany
    @JoinColumn(name="news_type_id")
    private List<News> newsList = new ArrayList<>();

    public NewsType() {
    }

    public NewsType(String name, List<News> newsList) {
        this.name = name;
        this.newsList = newsList;
    }

    public static NewsType from(NewsTypeDto newsTypeDto){
        NewsType newsType = new NewsType();
        newsType.setName(newsTypeDto.getName());
        return newsType;
    }

    public void addNews(News news){
        newsList.add(news);
    }

    public void removeNews(News news){
        newsList.remove(news);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<News> getNewsList() {
        return newsList;
    }

    public void setNewsList(List<News> newsList) {
        this.newsList = newsList;
    }
}
