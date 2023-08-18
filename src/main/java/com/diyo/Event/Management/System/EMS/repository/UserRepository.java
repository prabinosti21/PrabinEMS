package com.diyo.Event.Management.System.EMS.repository;

import com.diyo.Event.Management.System.EMS.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmailAndPassword(String email, String password);

    Optional<User>findByEmail(String email);

    Optional<User>findByEmailAndSecurityAnswer(String email, String securityAnswer);
}
