package br.com.example.appjobs.repository;

import br.com.example.appjobs.domain.EnterpriseModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EnterpriseRepository extends JpaRepository<EnterpriseModel, Long> {

    EnterpriseModel findById(Integer id);

}
