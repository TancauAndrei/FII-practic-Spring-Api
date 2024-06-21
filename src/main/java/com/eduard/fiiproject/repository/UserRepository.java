package com.eduard.fiiproject.repository;

import com.eduard.fiiproject.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("select u from User u where u.firstName = ?1")
    List<User> findByFirstName(String firstName);
    @Query("select u from User u where u.lastName = ?1")
    List<User> findByLastName(String lastName);
    Optional<User> findByEmail(String email);
    Optional<User> findByUsername(String keyWord);
    boolean existsByUsername(String username);
    void deleteByUsername(String username);
    @Query("select exists (select u from User u where u.email = ?1)")
    boolean existsByEmail(String email);
}