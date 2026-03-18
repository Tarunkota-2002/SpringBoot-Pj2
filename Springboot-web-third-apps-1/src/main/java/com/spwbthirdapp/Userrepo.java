package com.spwbthirdapp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;

import java.util.Optional;
import java.util.List;


@Transactional

public interface Userrepo extends JpaRepository<Users, String> {

	//Users findByUsername(String name);
    //Optional<Users> findByUsername(String username);
    //Optional<Users> findByUsernameAndPassword(String username, String password);
    //String findByUsername(String username);
	Users findByUsernameAndPassword(String username, String password);

	@Modifying
	@Query("UPDATE Users u SET u.password = :password WHERE u.username = :username")
	int updatePassword(@Param("username") String username,
	                   @Param("password") String password);


}