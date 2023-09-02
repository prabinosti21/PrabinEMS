package com.diyo.Event.Management.System.EMS.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.Date;

import static jakarta.persistence.CascadeType.ALL;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "guest")
public class Guests {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "guestId_generator")
    @SequenceGenerator(name = "guestId_generator", sequenceName = "guestId_sequence")
    private Long guestId;

    @NotBlank(message = "Please provide first name.")
    private String fullName;

    @NotBlank(message = "Please provide gender.")
    private String gender;

    @NotBlank(message = "Please provide phone number.")
    private String phone;

    @Email
    @NotBlank(message = "Please provide an email.")
    private String email;
}
