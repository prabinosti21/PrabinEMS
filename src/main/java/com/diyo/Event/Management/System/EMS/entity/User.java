package com.diyo.Event.Management.System.EMS.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user_table")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "userId_generator")
    @SequenceGenerator(name = "userId_generator", sequenceName = "user_sequence")
    private Long userId;

    @NotBlank(message = "Please provide an email id")
    @Email
    private String email;

    @NotBlank(message = "Please provide password")
    private  String password;

    @Transient
    private String securityQuestion = "What is your favorite pet name?";

    private String securityAnswer;


}