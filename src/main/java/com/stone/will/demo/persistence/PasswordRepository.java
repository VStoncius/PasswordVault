package com.stone.will.demo.persistence;

import com.stone.will.demo.model.WebSitePassword;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PasswordRepository extends JpaRepository<WebSitePassword, Long> {
}
