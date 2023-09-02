package com.diyo.Event.Management.System.EMS.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "feedback")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reviews {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "reviewId_generator")
    @SequenceGenerator(name = "reviewId_generator", sequenceName = "reviews_sequence")
    private Long reviewId;

    private String comment;
    private String userName;
}
