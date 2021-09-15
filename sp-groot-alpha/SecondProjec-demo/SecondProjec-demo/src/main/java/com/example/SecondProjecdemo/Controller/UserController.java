package com.example.SecondProjecdemo.Controller;



import com.example.SecondProjecdemo.Model.User;
import com.example.SecondProjecdemo.Service.UserService;
import com.example.SecondProjecdemo.Service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserServiceImpl userServiceImp;

    //Display list of users
    @GetMapping("/users")
    public String viewUsers(Model model){
        Iterable<User> users = userServiceImp.getAllUsers();
        model.addAttribute("listUsers", users);
        return "users";
    }

    //saveUser
    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User user){
//        System.out.println("UserName :" + user.getUser_Name());
//            System.out.println("Email :" + user.getEmail());
//            System.out.println("password: " + user.getPassword());
//            System.out.println("age :" + user.getAge());
//        System.out.println("id :" + user.getId());
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/showNewUserForm")
    public String showNewUserForm(Model model){
        User user = new User();
        //Model attribute to bind data
        model.addAttribute("user", user);
        return "new_user";
    }

    @GetMapping("/showFormForUpdate/{Id}")
    public String showFormForUpdate(@PathVariable (value="Id") long Id, Model model){
        //get employee from the service
        User user = userService.getUserById(Id);
        //set employee as a model attribute to pre-populate the form
        model.addAttribute("user",user);
        return "update_user";
    }
    @GetMapping("/deleteUser/{Id}")
    public String deleteUser(@PathVariable (value="Id") long Id){
        //call delete user method
        this.userService.deleteUserById(Id);
        return "redirect:/users";
    }

    //********************************************************************
    //Register new user (user Role)


    @GetMapping("/about")
    public String showAbout(Model model){
        return "about";
    }

    @GetMapping("/SignIn")
    public String showLogin(Model model){
        return "signIn";
    }

    @GetMapping("/images")
    public String showImages(){
        return "images";
    }
    @GetMapping("/contact")
    public String showContact(){
        return "contact";
    }

    @GetMapping("/products")
    public String showProducts(){
        return "products";
    }

    @GetMapping("/signUp")
    public String showSignUp(Model model){
        User user = new User();
        model.addAttribute("user",user);
        return "signUp";
    }
    @PostMapping("/saveNewUser")
    public String saveNewUser(@ModelAttribute("user") User user){
        userService.saveUser(user);
        return "redirect:/SignIn";
    }

}
