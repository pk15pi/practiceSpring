package com.example.firstspring.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Employee")
public class Employee {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name="NAME")
    @NotBlank(message = "Name is mandatory")
    private String name;

    @Column(name="TITLE")
    private String title;

    @Column(name="DOB")
    private LocalDate dob;

    @Column(name="CITY")
    private String city;

    @Column(name="PIN")
    private Long pin;

}
