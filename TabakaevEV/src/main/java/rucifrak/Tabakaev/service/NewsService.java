package rucifrak.Tabakaev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rucifrak.Tabakaev.model.News;
import rucifrak.Tabakaev.model.exception.NewsException;
import rucifrak.Tabakaev.repository.NewsRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class NewsService {
    private final NewsRepository newsRepository;

    @Autowired
    public NewsService(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    public News addNews(News news){
        return  newsRepository.save(news);
    }

    public List<News> getNews(){
        return StreamSupport.stream(newsRepository
                .findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public News getNewsById(Long id){
        return newsRepository.findById(id).orElseThrow(() -> new NewsException(id));
    }

    public News deleteNews(Long id){
        News news = getNewsById(id);
        newsRepository.delete(news);
        return news;
    }

    @Transactional
    public News editNews(Long id,News news){
        News newsToEdit = getNewsById(id);
        newsToEdit.setName(news.getName());
        newsToEdit.setShortDesc(news.getShortDesc());
        newsToEdit.setLongDesc(news.getLongDesc());
        return newsToEdit;
    }

}
