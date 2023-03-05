package com.app.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.app.pojos.Role;
import com.app.pojos.User;
import com.app.repository.UserRepository;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import java.util.Collections;




@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        user.setHashedPassword(user.getHashedPassword());
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

//    @Override
//    public List<User> findByRole(Role role) {
//        return userRepository.findByRole(role);
//    }
    
    @Override
	public List<User> findByRole(Role role) {
		 return userRepository.findByRole(role);
		return null;
	}

    @Override
    public User getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElse(null);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User updateUser(Long id, User userDetails) {
        User user = getUserById(id);
        if (user == null) {
            return null;
        }
        user.setUsername(userDetails.getUsername());
        user.setFirstName(userDetails.getFirstName());
        user.setLastName(userDetails.getLastName());
        user.setEmail(userDetails.getEmail());
        user.setHint(userDetails.getHint());
        user.setRole(userDetails.getRole());
        user.setHashedPassword(userDetails.getHashedPassword());
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

   
    @Override
    public UserDetails loadUserByEmail(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with email: " + email);
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getHashedPassword(),
                new ArrayList<>());
    }

	
}


/*
public class UserServiceImpl implements UserService {
	
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
	@Override
	public User findByEmail(String email) {
        return userRepository.findByEmail(email);
	}

	@Override
	public List<User> findByRole(Role role) {
        return userRepository.findByRole(role);
	}

	@Override
	public User saveUser(User user) {
        return userRepository.save(user);

	}
	
	@Override
	public User updateUser(Long id, User userDetails) {
        return userRepository.save(user);

	}

//	@Override
//	public User updateUser(id,details) {
//        return userRepository.save(user);
//
//	}

	@Override
	public void deleteUser(Long id) {
        userRepository.delete(user);

	}

	@Override
	public List<User> getAllUsers() {
        return userRepository.findAll();

	}


	@Override
	public UserDetails loadUserByEmail(String email) throws UsernameNotFoundException {
	    User user = userRepository.findByEmail(email);
	    if (user == null) {
	        throw new UsernameNotFoundException("User not found with email: " + email);
	    }
	    return new org.springframework.security.core.userdetails.User(
	            user.getEmail(), 
	            user.getHashedPassword(),
	            Collections.singleton(new SimpleGrantedAuthority(user.getRole().name()))
	        );
	}

	@Override
	public User getUserById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void deleteUser(Long id) {
		// TODO Auto-generated method stub
		
	}


}
*/
