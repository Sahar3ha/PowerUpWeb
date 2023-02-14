package com.system.powerup.repo;

import com.system.powerup.Entity.Membership;
import com.system.powerup.Entity.SignUp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MembershipRepo extends JpaRepository<Membership, Integer> {

    @Query(value = "SELECT * FROM membership WHERE user_id = ?1", nativeQuery = true)
    Optional<Membership> fetchById(Integer userId);
//
//    @Query(value = "SELECT * FROM membership WHERE user_id = ?1", nativeQuery = true)
//    Optional<Membership> fetchById(SignUp Id);

    @Query(value = "SELECT * FROM membership WHERE user_id = ?1", nativeQuery = true)
    Optional<List<Membership>> fetchAll(Integer userId);

    void deleteById(Integer id);


//    @Query(value = "SELECT * FROM signup WHERE user_id = ?1", nativeQuery = true)
//    Optional<List<Membership>> fetchAll(Integer userId);

}
