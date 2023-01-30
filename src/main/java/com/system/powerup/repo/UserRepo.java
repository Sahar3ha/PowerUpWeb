//package com.system.powerup.repo;
//
//import com.system.powerup.Entity.SignUp;
//import com.system.powerup.Entity.User;
//import lombok.RequiredArgsConstructor;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
//
//import java.util.Optional;
//
//@Repository
//public interface UserRepo extends JpaRepository<User, Integer> {
//    @Query(value = "SELECT * FROM users WHERE email = ?1", nativeQuery = true)
//    Optional<SignUp> findByEmail(String email);
//}