package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

import org.springframework.stereotype.Repository;


import com.app.pojos.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	@Query("select u from UserEntity u join fetch u.userRoles where u.email=?1")
	Optional<User> findByEmail(String email);
    
    

}
