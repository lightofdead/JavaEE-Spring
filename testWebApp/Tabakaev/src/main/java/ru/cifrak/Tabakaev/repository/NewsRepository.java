package ru.cifrak.Tabakaev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.cifrak.Tabakaev.model.News;

import java.util.List;

public interface NewsRepository extends JpaRepository<News, Long> {
    //@Query("select n, nt.name, nt.color from News n inner join NewsType nt ON n.newsType.id=nt.id")
    /*@Query("select n.name from News n where  n.id= 1")
    List<News> findAllnews();*/
}
