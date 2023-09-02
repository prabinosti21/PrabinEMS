package com.diyo.Event.Management.System.EMS.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "likeAndDislikes")
public class LikeDislikes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "ldId_generator")
    @SequenceGenerator(name = "ldId_generator", sequenceName = "ldId_sequence")
    private Long ldId;

    private Integer likeCounts = 0;
    private Integer dislikeCounts = 0;
}
