package com.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.app.pojos.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
    
    
    
    // Find all admins except the given admin id
    // List<Admin> findAllByIdNot(Long id);
    
    // Find admins by name or email
    // List<Admin> findByNameContainingIgnoreCaseOrEmailContainingIgnoreCase(String name, String email);
    
	// Find admin by email
    Optional<Admin> findByUser_Email(String email);
    
    // Count number of admins
    long count();
    
}

