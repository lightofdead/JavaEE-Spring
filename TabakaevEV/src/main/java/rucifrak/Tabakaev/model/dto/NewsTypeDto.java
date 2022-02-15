package rucifrak.Tabakaev.model.dto;

import rucifrak.Tabakaev.model.NewsType;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class NewsTypeDto {
    private Long id;
    private  String name;
    private String color;
    private List<NewsDto> newsDtoList = new ArrayList<>();

    public static NewsTypeDto from(NewsType newsType){
        NewsTypeDto newsTypeDto = new NewsTypeDto();
        newsTypeDto.setId(newsType.getId());
        newsTypeDto.setName(newsType.getName());
        newsType.setColor(newsType.getColor());
        newsTypeDto.setNewsDtoList(newsType.getNewsList().stream().map(NewsDto::from).collect(Collectors.toList()));
        return newsTypeDto;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public List<NewsDto> getNewsDtoList() {
        return newsDtoList;
    }

    public void setNewsDtoList(List<NewsDto> newsDtoList) {
        this.newsDtoList = newsDtoList;
    }
}
