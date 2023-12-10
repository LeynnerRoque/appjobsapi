package br.com.example.appjobs.repository;

import br.com.example.appjobs.domain.PeoplesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PeopleRepository extends JpaRepository<PeoplesModel, Long> {

    PeoplesModel findById(Integer id);

    @Query(value = "select * from peoples p where p.job_id = :id", nativeQuery = true)
    List<PeoplesModel> findPeoplesByJobID(@Param("id") Integer id);
    @Query(value = "select * from peoples p where p.location_id = :id", nativeQuery = true)
    List<PeoplesModel> findPeoplesByLocationId(@Param("id") Integer id);
}
