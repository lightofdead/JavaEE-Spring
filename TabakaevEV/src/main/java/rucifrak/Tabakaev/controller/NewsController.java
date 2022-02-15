package rucifrak.Tabakaev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rucifrak.Tabakaev.model.News;
import rucifrak.Tabakaev.model.dto.NewsDto;
import rucifrak.Tabakaev.service.NewsService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/news")
public class NewsController {
    private final NewsService newsService;

    @Autowired
    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @PostMapping
    public ResponseEntity<NewsDto> addNews(@RequestBody final NewsDto newsDto){
        News news = newsService.addNews(News.from(newsDto));
        return  new ResponseEntity<>(NewsDto.from(news), HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<NewsDto>> getNews(){
        List<News> newsList = newsService.getNews();
        List<NewsDto> newsDtos = newsList.stream().map(NewsDto::from)
                .collect(Collectors.toList());
        return new ResponseEntity<>(newsDtos, HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<NewsDto> getSomeNews(@PathVariable final Long id){
        News news = newsService.getNewsById(id);
        return new ResponseEntity<>(NewsDto.from(news), HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    public String deleteSomeNews(@PathVariable final Long id){
        News news = newsService.deleteNews(id);
        return "Новость удалена";
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<NewsDto> editSomeNews(@PathVariable final Long id,
                                                @RequestBody final NewsDto newsDto){
        News editedNews = newsService.editNews(id, News.from(newsDto));
        return new ResponseEntity<>(NewsDto.from(editedNews), HttpStatus.OK);
    }
}
