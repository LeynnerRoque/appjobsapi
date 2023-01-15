package br.com.example.appjobs.repository;

import br.com.example.appjobs.domain.JobModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends JpaRepository<JobModel, Long> {
}
