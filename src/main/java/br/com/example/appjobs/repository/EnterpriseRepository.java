package br.com.example.appjobs.repository;

import br.com.example.appjobs.domain.EnterpriseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnterpriseRepository extends JpaRepository<EnterpriseEntity, Long> {
}
