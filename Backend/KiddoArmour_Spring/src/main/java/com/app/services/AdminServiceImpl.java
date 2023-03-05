package com.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import com.app.exceptions.ResourceNotFoundException;

import com.app.pojos.Admin;
import com.app.pojos.User;
import com.app.repository.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminRepository adminRepository;

	
		
//	@Override
//	public Admin registerAdmin(Admin admin) {
//		return adminRepository.save(admin);
//	}
	
	@Override
    public Admin saveAdmin(Admin admin) {
		System.out.println("In save Admin");
        return adminRepository.save(admin);
    }
	
//	@Override
//	public Admin authenticateAdmin(String email, String password) {
//		Optional<Admin> admin = adminRepository.findByUser_Email(email);
//		if (admin.isPresent() && admin.get().getUser().getPassword().equals(password)) {
//			return admin.get();
//		} else {
//			throw new ResourceNotFoundException("Invalid email or password");
//		}
//	}
	
	@Override
	public Admin authenticateAdmin(String email, String password) {
		Admin admin = adminRepository.findByUser_Email(email).orElse(null);
		System.out.println("Hello in authenticate");
	    if (admin != null) {
	        String hashedPassword = admin.getUser().getHashedPassword();
	        if (BCrypt.checkpw(password, hashedPassword)) {
	            return admin;
	        }
	    }
	    return null;
	}
	
//	public Admin authenticateAdmin(String email, String password) {
//	    Admin admin = adminRepository.findByUser_Email(email).orElse(null);
//	    if (admin != null && BCrypt.checkpw(password, admin.getUser().getHashedPassword())) {
//	        return admin;
//	    } else {
//	        return null;
//	    }
//	}

	
	@Override
	public Admin getAdminById(Long adminId) {
		return adminRepository.findById(adminId)
				.orElseThrow(() -> new ResourceNotFoundException("Admin not found with id " + adminId));
	}
	
	


	@Override
	public List<Admin> getAllAdmins() {
		return adminRepository.findAll();
	}
	

	@Override
	public void deleteAdmin(Long adminId) {
		if (adminRepository.existsById(adminId)) {
			adminRepository.deleteById(adminId);
		} else {
			throw new ResourceNotFoundException("Admin not found with id " + adminId);
		}
	}

}
