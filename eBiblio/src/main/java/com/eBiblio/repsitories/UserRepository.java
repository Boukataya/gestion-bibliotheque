package com.eBiblio.repsitories;

import com.eBiblio.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String userName);

    boolean existsByUsername(String username);

}