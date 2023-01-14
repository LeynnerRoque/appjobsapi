package br.com.example.appjobs.repository;

import br.com.example.appjobs.domain.JobEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<JobEntity, Long> {
}
