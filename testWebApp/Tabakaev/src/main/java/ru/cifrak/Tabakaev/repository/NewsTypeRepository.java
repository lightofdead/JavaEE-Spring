package ru.cifrak.Tabakaev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.cifrak.Tabakaev.model.News;
import ru.cifrak.Tabakaev.model.NewsType;

import java.util.List;

public interface NewsTypeRepository extends JpaRepository<NewsType, Long> {
    /*@Query("select nt.id, nt.name, nt.color from NewsType nt")
    List<NewsType> findAllNewsType();*/
}
