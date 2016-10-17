package repository;

import entity.Properties;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PropertiesRepository extends JpaRepository<Properties, Long> {

    List<Properties> findAll(Sort sort);
    Properties findByOwnerId(Long id);

}
