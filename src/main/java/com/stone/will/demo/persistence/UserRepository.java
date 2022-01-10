package com.stone.will.demo.persistence;

import com.stone.will.demo.model.ActiveUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<ActiveUser, Long> {
    public ActiveUser findByUsername(String username);
}
