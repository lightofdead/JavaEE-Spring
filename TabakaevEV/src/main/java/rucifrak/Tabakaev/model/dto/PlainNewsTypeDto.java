package rucifrak.Tabakaev.model.dto;

import rucifrak.Tabakaev.model.NewsType;

public class PlainNewsTypeDto {
    private Long id;
    private String name;

    public PlainNewsTypeDto() {
    }

    public static  PlainNewsTypeDto from (NewsType newsType){
        PlainNewsTypeDto plainNewsTypeDto = new PlainNewsTypeDto();
        plainNewsTypeDto.setId(newsType.getId());
        plainNewsTypeDto.setName(newsType.getName());
        return plainNewsTypeDto;
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
}
