package com.pfa.localisation.repository;

import com.pfa.localisation.entity.users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface userRepository extends JpaRepository<users, Integer> {
    // Déclaration de la méthode findByMail
    users findByMail(String mail);
}
