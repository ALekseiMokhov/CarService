package com.senla.carservice.controller.ui;

import com.senla.carservice.dto.UserDto;
import com.senla.carservice.dto.mappers.interfaces.UserMapper;
import com.senla.carservice.entity.user.Role;
import com.senla.carservice.security.jwt.JwtTokenProvider;
import com.senla.carservice.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.Set;

@Controller
@Profile( "ui" )
@RequestMapping("")
public class UserMenuController {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    JwtTokenProvider tokenProvider;
    @Autowired
    private IUserService userService;
    @Autowired
    private UserMapper userMapper;

    @GetMapping("/login")
    public String showLoginPage(){
        return "login";
    }
    @GetMapping("/registration")
    public String showRegPage (){
        return "registration";
    }

    @PostMapping("/registration")
    public String signUp(@RequestParam String name,
                           @RequestParam String password,
                           @RequestParam String cpassword,
                           @RequestParam Role role){
        if(userService.isPresent( name )){
            throw new IllegalStateException("User with name "+name +" already exists!");
        }
        if(password.equals( cpassword )==false){
            throw new IllegalStateException("Passwords don't identical!");

        }
        UserDto userDto = new UserDto(name,password, Collections.singleton( role ));
        this.userService.saveUser( userMapper.fromDto( userDto ) )  ;
        return "redirect:home";
    }


    @PostMapping("")
    public String signIn (@RequestParam String name,
                          @RequestParam String password){
                  return "home";
    }


}
