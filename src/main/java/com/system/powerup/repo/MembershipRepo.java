package com.system.powerup.repo;

import com.system.powerup.Entity.Membership;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MembershipRepo extends JpaRepository<Membership, Integer> {

}
