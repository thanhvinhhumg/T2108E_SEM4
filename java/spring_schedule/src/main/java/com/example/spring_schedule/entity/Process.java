package com.example.spring_schedule.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;


@Entity
@Table(name = "process")
@Data
public class Process {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name = "process_id")
    private Integer processId;
    @Column(name = "process_created_at")
    private Timestamp processCreatedAt;
}
