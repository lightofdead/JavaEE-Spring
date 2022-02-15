package rucifrak.Tabakaev.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import rucifrak.Tabakaev.model.News;

@Repository
public interface NewsRepository extends CrudRepository<News, Long> {
}
