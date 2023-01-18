package br.com.example.appjobs.repository;

import br.com.example.appjobs.domain.LocationModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LocationRepository extends JpaRepository<LocationModel, Long> {

    LocationModel findById(Integer id);
}
