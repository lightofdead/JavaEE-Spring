package rucifrak.Tabakaev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
/*import rucifrak.Tabakaev.model.News;*/
import rucifrak.Tabakaev.model.NewsType;
/*import rucifrak.Tabakaev.model.dto.NewsDto;*/
import rucifrak.Tabakaev.model.dto.NewsTypeDto;
import rucifrak.Tabakaev.model.dto.PlainNewsTypeDto;
import rucifrak.Tabakaev.service.NewsTypeService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/news-types")
public class NewsTypeController {
    private final NewsTypeService newsTypeService;

    @Autowired
    public NewsTypeController(NewsTypeService newsTypeService) {
        this.newsTypeService = newsTypeService;
    }

    @PostMapping
    public ResponseEntity<NewsTypeDto> addNewsType(@RequestBody final NewsTypeDto newsTypeDto){
        NewsType newsType = newsTypeService.addNewsType(NewsType.from(newsTypeDto));
        return new ResponseEntity<>(NewsTypeDto.from(newsType), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<PlainNewsTypeDto>> getNews(){
        List<NewsType> newsList = newsTypeService.getNewsTypes();
        /*List<NewsTypeDto> newsTypesDto = newsList.stream().map(NewsTypeDto::from)
                .collect(Collectors.toList());*/
        List<PlainNewsTypeDto> plainNewsTypeDtos = newsList.stream().map(PlainNewsTypeDto::from).collect(Collectors.toList());
        return new ResponseEntity<>(plainNewsTypeDtos, HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<NewsTypeDto> getNewsTypes(@PathVariable final Long id){
        NewsType newsType = newsTypeService.getNewsType(id);
        return  new ResponseEntity<>(NewsTypeDto.from(newsType), HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    public String deleteNewsTypes(@PathVariable final Long id){
        NewsType newsType = newsTypeService.deleteNewsType(id);
        //return  new ResponseEntity<>(NewsTypeDto.from(newsType), HttpStatus.OK);
        return "Тип новости удален";
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<NewsTypeDto> editNewsTypes(@PathVariable final Long id,
                                                     @RequestBody final NewsTypeDto newsTypeDto){
        NewsType newsType = newsTypeService.editNewsType(id, NewsType.from(newsTypeDto));
        return  new ResponseEntity<>(NewsTypeDto.from(newsType), HttpStatus.OK);
    }

    @PostMapping(value = "{newsTypeId}/news/{newsId}/add")
    public ResponseEntity<NewsTypeDto> addNewsToNewsType(@PathVariable final Long newsTypeId,
                                                         @PathVariable final Long newsId){
        NewsType newsType = newsTypeService.addNewsToNewsType(newsTypeId, newsId);
        return  new ResponseEntity<>(NewsTypeDto.from(newsType), HttpStatus.OK);
    }

    @DeleteMapping(value = "{newsTypeId}/news/{newsId}/remove")
    public ResponseEntity<NewsTypeDto> deleteNewsToNewsType(@PathVariable final Long newsTypeId,
                                                         @PathVariable final Long newsId){
        NewsType newsType = newsTypeService.removeNewsFromNewsType(newsTypeId, newsId);
        return  new ResponseEntity<>(NewsTypeDto.from(newsType), HttpStatus.OK);
    }
}
