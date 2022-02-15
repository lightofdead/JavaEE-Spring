package rucifrak.Tabakaev.model.dto;

import lombok.Data;
import rucifrak.Tabakaev.model.News;

import java.util.Objects;

public class NewsDto {
    private Long id;
    private String name;
    private String shortDesc;
    private String longDesc;
    private  PlainNewsTypeDto plainNewsTypeDto;

    public NewsDto() {
    }


    public  static NewsDto from(News news){
        NewsDto newsDto = new NewsDto();
        newsDto.setId(news.getId());
        newsDto.setName(news.getName());
        newsDto.setShortDesc(news.getShortDesc());
        newsDto.setLongDesc(news.getLongDesc());
        if(Objects.nonNull(news.getNewsType())){
            newsDto.setPlainNewsTypeDto(PlainNewsTypeDto.from(news.getNewsType()));
        }
        return  newsDto;
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

    public PlainNewsTypeDto getPlainNewsTypeDto() {
        return plainNewsTypeDto;
    }

    public void setPlainNewsTypeDto(PlainNewsTypeDto plainNewsTypeDto) {
        this.plainNewsTypeDto = plainNewsTypeDto;
    }
}
