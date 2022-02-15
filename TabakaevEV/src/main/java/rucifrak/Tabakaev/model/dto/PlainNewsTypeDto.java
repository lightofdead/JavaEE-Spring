package rucifrak.Tabakaev.model.dto;

import rucifrak.Tabakaev.model.NewsType;

public class PlainNewsTypeDto {
    private Long id;
    private String name;
    private String color;

    public PlainNewsTypeDto() {
    }

    public static  PlainNewsTypeDto from (NewsType newsType){
        PlainNewsTypeDto plainNewsTypeDto = new PlainNewsTypeDto();
        plainNewsTypeDto.setId(newsType.getId());
        plainNewsTypeDto.setName(newsType.getName());
        plainNewsTypeDto.setColor(newsType.getColor());
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setName(String name) {
        this.name = name;
    }


}
