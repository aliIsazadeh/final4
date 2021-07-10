package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity

@NoArgsConstructor

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Transient
    private Set<? extends GrantedAuthority> grantedAuthorities;
    private String firstName;
    private String password;
    private String lastName;
    private String userName;
    private String phoneNum;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<? extends GrantedAuthority> getGrantedAuthorities() {
        return grantedAuthorities;
    }

    public void setGrantedAuthorities(Set<? extends GrantedAuthority> grantedAuthorities) {
        this.grantedAuthorities = grantedAuthorities;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String username) {
        this.userName = userName;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }



    public User(String userName,String password, Set<? extends GrantedAuthority> grantedAuthorities, String firstName, String lastName, String phoneNum) {
        this.userName = userName;
        this.password = password;
        this.grantedAuthorities = grantedAuthorities;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNum = phoneNum;

    }


    public String getName(){
        return getFirstName()+" "+getLastName();
    }
}
