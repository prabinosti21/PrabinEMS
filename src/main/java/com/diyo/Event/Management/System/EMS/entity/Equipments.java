package com.diyo.Event.Management.System.EMS.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "equipments")
public class Equipments {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "equipmentId_generator")
    @SequenceGenerator(name = "equipmentId_generator", sequenceName = "equipmentId_sequence")
    private Long equipmentId;

    @NotBlank(message = "Please provide equipments name.")
    private String equipmentName;

    @NotBlank(message = "Please provide equipments total cost")
    private String equipmentCost;

    @NotBlank(message = "Please provide equipments type.")
    private String equipmentType;
}
