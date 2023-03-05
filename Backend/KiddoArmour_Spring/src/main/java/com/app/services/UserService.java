package com.app.services;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.app.pojos.Role;
import com.app.pojos.User;

public interface UserService {
    
    public User saveUser(User user);
    public List<User> getAllUsers();
    public List<User> findByRole(Role role);
    public User getUserById(Long id);
    public User findByEmail(String email);
    public User updateUser(Long id, User userDetails);
    public void deleteUser(Long id);
    public UserDetails loadUserByEmail(String email) throws UsernameNotFoundException;
}


/*
public interface UserService {

//    User findByEmail(String email);

//    List<User> findByRole(Role role);

//    User saveUser(User user);

//    User updateUser(User user);

    
//    void deleteUser(User user);

//    List<User> getAllUsers();

//	UserDetails loadUserByEmail(String email);

    
}

*/