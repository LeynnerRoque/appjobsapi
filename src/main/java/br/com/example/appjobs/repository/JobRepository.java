package br.com.example.appjobs.repository;

import br.com.example.appjobs.domain.JobModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepository extends JpaRepository<JobModel, Long> {

    JobModel findById(Integer id);

    @Query(value = "select * from job j where  j.enterprise_id = :id", nativeQuery = true)
    List<JobModel> findJobsByIdEnterprise(@Param("id") Integer id);

    JobModel findJobModelsByTitle(String title);
}
