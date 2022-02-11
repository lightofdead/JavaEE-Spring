package ru.cifrak.Tabakaev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.cifrak.Tabakaev.model.News;
import ru.cifrak.Tabakaev.repository.NewsRepository;

import java.util.List;
import java.util.Optional;

@Service
public class NewsService {
    private final NewsRepository newsRepository;

    @Autowired
    public NewsService(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    public News findById(Long id){
        return  newsRepository.getById(id);
    }

    public List<News> list(){
        return  newsRepository.findAll();
    }

    public void createNews(News news){
        newsRepository.save(news);
    }

    public void deleteNews(Long id){
        newsRepository.deleteById(id);
    }

    public void update(News news){
        Optional<News> row = newsRepository.findById(news.getId());
        if(row.isPresent()){
            News item = row.get();
            if(!news.getName().isEmpty()){
               item.setName(news.getName());
            }
            if(!news.getShort_description().isEmpty()){
                item.setShort_description(news.getShort_description());
            }
            if(!news.getFull_description().isEmpty()){
                item.setFull_description(news.getFull_description());
            }
            /*if(news.getNews_type() != null){
                item.setNews_type(news.getNews_type());
            }*/
            newsRepository.save(item);
        }
    }

}
