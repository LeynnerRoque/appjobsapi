package br.com.example.appjobs.repository;

import br.com.example.appjobs.domain.EnterpriseDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnterpriseRepository extends JpaRepository<EnterpriseDomain, Long> {

}
