package br.com.example.appjobs.repository;

import br.com.example.appjobs.domain.PeopleDomain;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeopleRepository extends JpaRepository<PeopleDomain, Long> {
}
