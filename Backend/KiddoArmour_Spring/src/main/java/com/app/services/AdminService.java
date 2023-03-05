package com.app.services;

import java.util.List;
import com.app.pojos.Admin;

public interface AdminService {
	
	Admin authenticateAdmin(String email, String password);
		
    Admin getAdminById(Long adminId);

//    Admin registerAdmin(Admin admin);

    List<Admin> getAllAdmins();

    void deleteAdmin(Long adminId);
    
    Admin saveAdmin(Admin admin);

}
