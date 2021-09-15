package com.example.SecondProjecdemo.Model;




import ch.qos.logback.classic.db.names.ColumnName;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;

@Entity
@Table
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String user_Name;

    private String email;

    private String password;

    private int age;



    public User() {
    }

    //    public User() {
//        this.userId = userId;
//        this.userName = userName;
//        this.email = email;
//        this.password = password;
//        this.age = age;
//    }

//    public User(String userName,String email, String password, int age) {
//        this.userId = userId;
//        this.userName = userName;
//        this.email = email;
//        this.password = password;
//        this.age = age;
//    }

    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }


    public String getUser_Name() {
        return user_Name;
    }

    public void setUser_Name(String userName) {
        this.user_Name = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

//    public Collections<Role> getRoles(){
//        return roles;
//    }
//    public void setRoles(Collection<Role> role){
//        this.roles=roles;
//    }

    //@ManyToMany(cascade = CascadeType.MERGE);
}
