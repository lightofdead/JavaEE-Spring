package ru.cifrak.Tabakaev.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.cifrak.Tabakaev.model.News;
import ru.cifrak.Tabakaev.service.NewsService;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/tabak")
public class NewsController {
    private final NewsService newsService;

    @Autowired
    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping("/news")
    public List<News> findAll(){
        List<News> news =  newsService.list();
        return news;
        /*List<News> news2 = new ArrayList<>();
        for(News somenews : news){
            if(news.isEmpty()){

                news2.add(somenews);
            }
        }
        return news2;*/
    }


    @PostMapping("/news-add")
    public List<News> createNews(@RequestBody News news){
        newsService.createNews(news);
        return newsService.list();
    }
    @DeleteMapping("/news-delete/{id}")
    public void deleteNews(@PathVariable("id") Long id){
        newsService.deleteNews(id);
        findAll();
    }

    @PutMapping("/news-Update")
    public void updateNews(@RequestBody News news){
        newsService.update(news);
    }

}
