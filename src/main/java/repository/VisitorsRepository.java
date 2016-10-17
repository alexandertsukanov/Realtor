package repository;

import entity.Visitors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Created by alex on 10/16/16.
 */
public interface VisitorsRepository extends JpaRepository<Visitors, Long> {


    List<Visitors> findByReservedProperty(Long id);

    Visitors findByReservedDate(Date date);

//    @Query("SELECT reservedDate FROM Visitors where reservedDate  = :reservedDate")
//    String findDate(@Param("reservedDate") Date date);


}
