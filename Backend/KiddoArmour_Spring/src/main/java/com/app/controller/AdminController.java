package com.app.controller;

import com.app.exceptions.ResourceNotFoundException;
import com.app.pojos.Admin;
import com.app.repository.AdminRepository;
import com.app.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/admin")
public class AdminController {
	

    @Autowired
    private AdminService adminService;

    @Autowired
    private AdminRepository adminRepository;

    // Get all admins
    @GetMapping
    public ResponseEntity<List<Admin>> getAllAdmins() {
        List<Admin> admins = adminRepository.findAll();
        return new ResponseEntity<>(admins, HttpStatus.OK);
//        System.out.println("In Admin Controller");
    }

    // Get admin by ID
    @GetMapping("/{id}")
    public ResponseEntity<Admin> getAdminById(@PathVariable Long id) throws ResourceNotFoundException {
        Admin admin = adminService.getAdminById(id);//.orElseThrow(() -> new ResourceNotFoundException("Admin not found for this id :: " + id));
        if (admin == null) {
            throw new ResourceNotFoundException("Admin not found for this id :: " + id);
        }
        return new ResponseEntity<>(admin, HttpStatus.OK);
    }

    // Create admin
    @PostMapping
    public ResponseEntity<Admin> createAdmin(@RequestBody Admin admin) {
        Admin newAdmin = adminRepository.save(admin);
        return new ResponseEntity<>(newAdmin, HttpStatus.CREATED);
    }

    // Update admin
    @PutMapping("/{id}")
    public ResponseEntity<Admin> updateAdmin(@PathVariable Long id, @RequestBody Admin adminDetails) throws ResourceNotFoundException {
        Admin admin = adminService.getAdminById(id); //.orElseThrow(() -> new ResourceNotFoundException("Admin not found for this id :: " + id));
        if (admin == null) {
            throw new ResourceNotFoundException("Admin not found for this id :: " + id);
        }
        admin.getUser().setEmail(adminDetails.getUser().getEmail());
        admin.getUser().setHashedPassword(adminDetails.getUser().getHashedPassword());
        admin.getUser().setFirstName(adminDetails.getUser().getFirstName());
        admin.getUser().setLastName(adminDetails.getUser().getLastName());

        Admin updatedAdmin = adminService.saveAdmin(admin);
        return ResponseEntity.ok(updatedAdmin);
    }


    // Delete admin
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdmin(@PathVariable Long id) throws ResourceNotFoundException {
        Admin admin = adminService.getAdminById(id);//.orElseThrow(() -> new ResourceNotFoundException("Admin not found for this id :: " + id));
        if (admin == null) {
            throw new ResourceNotFoundException("Admin not found for this id :: " + id);
        }
        adminRepository.delete(admin);
        return ResponseEntity.noContent().build();
    }
}
