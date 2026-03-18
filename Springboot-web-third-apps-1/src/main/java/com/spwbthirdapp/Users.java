package com.spwbthirdapp;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="demo_users")
public class Users {

    @Id
    @Column(nullable=false, unique=true)
    private String username;

    @Column(nullable=false)
    private String password;
    
    private String newpassword;
}
