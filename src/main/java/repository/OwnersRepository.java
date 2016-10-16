package repository;

import entity.Owners;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Locale;

/**
 * Created by alex on 10/16/16.
 */
public interface OwnersRepository extends JpaRepository<Owners, Long> {

    Owners getOwnerById(String id);

}
