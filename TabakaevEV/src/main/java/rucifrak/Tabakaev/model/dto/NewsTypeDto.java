package rucifrak.Tabakaev.model.dto;

import rucifrak.Tabakaev.model.News;
import rucifrak.Tabakaev.model.dto.NewsDto;
import rucifrak.Tabakaev.model.NewsType;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class NewsTypeDto {
    private Long id;
    private  String name;
    private List<NewsDto> newsDtoList = new ArrayList<>();

    public static NewsTypeDto from(NewsType newsType){
        NewsTypeDto newsTypeDto = new NewsTypeDto();
        newsTypeDto.setId(newsType.getId());
        newsTypeDto.setName(newsType.getName());
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

    public List<NewsDto> getNewsDtoList() {
        return newsDtoList;
    }

    public void setNewsDtoList(List<NewsDto> newsDtoList) {
        this.newsDtoList = newsDtoList;
    }
}
