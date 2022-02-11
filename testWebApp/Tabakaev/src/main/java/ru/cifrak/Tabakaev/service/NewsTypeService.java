package ru.cifrak.Tabakaev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.cifrak.Tabakaev.model.NewsType;
import ru.cifrak.Tabakaev.repository.NewsTypeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class NewsTypeService {
    private final NewsTypeRepository newsTypeRepository;

    @Autowired
    public NewsTypeService(NewsTypeRepository newsTypeRepository) {
        this.newsTypeRepository = newsTypeRepository;
    }

    public NewsType findById(Long id){
        return  newsTypeRepository.getById(id);
    }

    public List<NewsType> list(){
        return  newsTypeRepository.findAll();
    }

    public void createNews(NewsType news_type){
        newsTypeRepository.save(news_type);
    }

    public void deleteNews(Long id){
        newsTypeRepository.deleteById(id);
    }

    public void update(NewsType news_type){
        Optional<NewsType> row = newsTypeRepository.findById(news_type.getId());
        if(row.isPresent()){
            NewsType item = row.get();
                if(!news_type.getName().isEmpty()){
                item.setName(news_type.getName());
                }
                if(!news_type.getColor().isEmpty()){
                item.setColor(news_type.getColor());
                }
            newsTypeRepository.save(item);
        }
    }
}
