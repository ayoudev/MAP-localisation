package com.pfa.localisation.repository;

import com.pfa.localisation.entity.vehicules;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehiculeRepository extends JpaRepository<vehicules,Integer> {
}
