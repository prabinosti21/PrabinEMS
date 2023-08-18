package com.diyo.Event.Management.System.EMS.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "event")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "eventId_generator")
    @SequenceGenerator(name = "eventId_generator", sequenceName = "event_sequence")
    private Long eventId;

    @NotBlank(message = "Please provide a event name.")
    private String eventName;

    @NotBlank(message = "Please provide a event organizer name.")
    private String eventOrganizerName;

    @NotBlank(message = "Please provide a event venue name.")
    private String eventVenue;

    @NotBlank(message = "Please provide a event date")
    private String eventDate;

    @NotBlank(message = "Please provide a event organizer phone number.")
    private String eventOrganizerPhone;

    @NotBlank(message = "Please provide a event organizer address.")
    private String eventOrganizerAddress;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "event-Id", referencedColumnName = "eventId")
    @NotBlank
    private List<Guests>guestDetails;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "event-Id", referencedColumnName = "eventId")
    @NotBlank
    private List<FoodAndDrinks>foodDetails;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "event-Id", referencedColumnName = "eventId")
    @NotBlank
    private List<Equipments>equipmentDetails;
}
