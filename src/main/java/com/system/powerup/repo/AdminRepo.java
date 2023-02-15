package com.system.powerup.repo;

import com.system.powerup.Entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepo extends JpaRepository<Admin,Integer> {
//    @Query(value = "SELECT * FROM users WHERE email = ?1", nativeQuery = true)
//    Optional<SignUp> findByEmail(String email);
}