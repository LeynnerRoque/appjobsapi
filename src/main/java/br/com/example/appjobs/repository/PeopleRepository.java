package br.com.example.appjobs.repository;

import br.com.example.appjobs.domain.PeoplesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeopleRepository extends JpaRepository<PeoplesModel, Long> {
}
