package rucifrak.Tabakaev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rucifrak.Tabakaev.model.News;
import rucifrak.Tabakaev.model.NewsType;
import rucifrak.Tabakaev.model.exception.NewsAlreadyAssignedException;
import rucifrak.Tabakaev.model.exception.NewsTypeException;
import rucifrak.Tabakaev.repository.NewsTypeRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class NewsTypeService {
    private final NewsTypeRepository newsTypeRepository;
    public final NewsService newsService;

    @Autowired
    public NewsTypeService(NewsTypeRepository newsTypeRepository, NewsService newsService) {
        this.newsTypeRepository = newsTypeRepository;
        this.newsService = newsService;
    }

    public NewsType addNewsType(NewsType newsType){
        return  newsTypeRepository.save(newsType);
    }

    public List<NewsType> getNewsTypes(){
        return StreamSupport.stream(newsTypeRepository
                .findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public NewsType getNewsType(Long id){
        return  newsTypeRepository.findById(id)
                .orElseThrow(() -> new NewsTypeException(id));
    }

    public NewsType deleteNewsType(Long id){
        NewsType newsType = getNewsType(id);
        newsTypeRepository.delete(newsType);
        return newsType;
    }

    @Transactional
    public NewsType editNewsType(Long id, NewsType newsType){
        NewsType newsTypeToEdit = getNewsType(id);
        newsTypeToEdit.setName(newsType.getName());
        newsTypeToEdit.setColor(newsType.getColor());
        return newsTypeToEdit;
    }

    @Transactional
    public NewsType addNewsToNewsType(Long newsTypeId, Long newsId){
        NewsType newsType = getNewsType(newsTypeId);
        News news = newsService.getNewsById(newsId);
        if(Objects.nonNull(news.getNewsType())){
            throw new NewsAlreadyAssignedException(newsId, news.getNewsType().getId());
        }
        newsType.addNews(news);
        return newsType;
    }

    @Transactional
    public NewsType removeNewsFromNewsType(Long newsTypeId, Long newsId){
        NewsType newsType = getNewsType(newsTypeId);
        News news = newsService.getNewsById(newsId);
        newsType.removeNews(news);
        return newsType;
    }
}
