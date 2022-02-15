package rucifrak.Tabakaev.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import rucifrak.Tabakaev.model.NewsType;

@Repository
public interface NewsTypeRepository extends CrudRepository<NewsType, Long> {
}
