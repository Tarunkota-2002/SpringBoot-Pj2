package com.spwbthirdapp;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Service1 {

    @Autowired
    private Userrepo urepo;

    // Register new user
//    public String createUser(String email, String password) {
//        if (urepo.findById(email).isPresent()) {
//            return "User already exists";
//        }
//        Users user = new Users(email, password);
//        urepo.save(user);
//        return "User successfully registered";
//    }
//
//    // Login validation
//    public String validateUser(String email, String password) {
//        Optional<Users> user = urepo.findByUsernameAndPassword(email, password);
//        return user.isPresent() ? "Login Success" : "Wrong Email or Password";
//    }

    // Verify if user exists
//    public String findByUsername(String email) {
//        return urepo.findByUsername(email).isPresent() ? "User already exists" : "User does not exist";
//    }
    
    public String createuserreg(UsersDto userdto) {
    	 Users u1 = new Users();
    	u1.setNewpassword( userdto.getNewpassword());
    	u1.setPassword(userdto.getPassword());
    	u1.setUsername(userdto.getUsername());
    	urepo.save(u1);
    	return"Successfully Registered"+u1.getUsername();
    }
    
    public Users updateusers(UsersDto userdto,String name) {
    	Users users = urepo.findByUsernameAndPassword(name,userdto.getPassword());
    	if(users==null) {
    		return null;
    	}
    	else {
    		int a=urepo.updatePassword(userdto.getUsername(), userdto.getNewpassword());
    		Users u1 = new Users();
    		 users.setPassword(userdto.getNewpassword());
    		// u1.setUsername(userdto.getUsername());
    		System.out.println("Happy");
    		return  u1; // this is for returning object
    	}
	
    	
    }
}
