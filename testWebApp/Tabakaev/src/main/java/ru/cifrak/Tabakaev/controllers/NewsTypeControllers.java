package ru.cifrak.Tabakaev.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.cifrak.Tabakaev.model.NewsType;
import ru.cifrak.Tabakaev.service.NewsTypeService;

import java.util.List;

@RestController
@RequestMapping("/tabak")
public class NewsTypeControllers {
    private final NewsTypeService newsTypeService;

    @Autowired
    public NewsTypeControllers(NewsTypeService newsTypeService) {
        this.newsTypeService = newsTypeService;
    }
    @GetMapping("/news-types")
    public List<NewsType> findAll(){
        return  newsTypeService.list();
    }


    @PostMapping("/news_type-add")
    public List<NewsType> createNews(@RequestBody NewsType news_type){
        newsTypeService.createNews(news_type);
        return newsTypeService.list();
    }
    @DeleteMapping("/news_type-delete/{id}")
    public void deleteNews(@PathVariable("id") Long id){
        newsTypeService.deleteNews(id);
        findAll();
    }

    @PutMapping("/news_type-Update")
    public void updateNews(@RequestBody NewsType news_type){
        newsTypeService.update(news_type);
    }
}
