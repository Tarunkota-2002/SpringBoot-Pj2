package com.spwbthirdapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import jakarta.servlet.http.HttpServletRequest;

@RestController
public class Controllers {

    @Autowired
    private Service1 service;

    // GET: show login form
    @RequestMapping(path="/login", method=RequestMethod.GET)
    public String loginForm() {
        return "login"; // /WEB-INF/views/login.jsp
    }

    // POST: process login
    @RequestMapping(path="/login", method=RequestMethod.POST)
    public ModelAndView loginSubmit(HttpServletRequest request) {
        String email = request.getParameter("username");
        String password = request.getParameter("password");

      //  String status = service.validateUser(email, password);

        ModelAndView mv = new ModelAndView("msg");
       // mv.addObject("msgs", status);
        return mv;
    }

    // GET: show verification form
    @RequestMapping(path="/verify", method=RequestMethod.GET)
    public String verifyForm() {
        return "verify"; // /WEB-INF/views/verify.jsp
    }

    // POST: process verification
    @RequestMapping(path="/verify", method=RequestMethod.POST)
    public ModelAndView verifySubmit(HttpServletRequest request) {
        String email = request.getParameter("username");

       // String status = service.findByUsername(email);

        ModelAndView mv = new ModelAndView("verify");
      //  mv.addObject("msgs", status);
        return mv;
    }

    // GET: show registration form
    @RequestMapping(path="/register", method=RequestMethod.GET)
    public String registerForm() {
        return "register"; // /WEB-INF/views/register.jsp
    }

    // POST: register new user
    @RequestMapping(path="/register", method=RequestMethod.POST)
    public ModelAndView registerSubmit(HttpServletRequest request) {
        String email = request.getParameter("username");
        String password = request.getParameter("password");

      //  String status = service.createUser(email, password);

        ModelAndView mv = new ModelAndView("msg");
      //  mv.addObject("msgs", status);
        return mv;
    }
    
    @PutMapping(path="/update/password/{username}")
    public Users updatingpassword(@RequestBody UsersDto usersdto,@PathVariable("username")String username){
    	
    	
    	
		return service.updateusers(usersdto, username);
    	
    }
    
    @PostMapping(path="/create/users")
    public String createuser(@RequestBody UsersDto userdto) {
    	return service.createuserreg(userdto);
    }
    
}
