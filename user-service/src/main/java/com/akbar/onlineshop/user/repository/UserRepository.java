package com.akbar.onlineshop.user.repository;

import com.akbar.onlineshop.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
    Optional<User> findByUserId(String userId);
    Optional<User> findByLogin(String login);
}
