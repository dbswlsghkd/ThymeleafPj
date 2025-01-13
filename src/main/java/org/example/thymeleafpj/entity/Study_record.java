package org.example.thymeleafpj.entity;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@ToString
@Setter
@Getter
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "study_record")
public class Study_record {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int key_id;
    private String study_day;
    private String contents;

    @CreationTimestamp
    private LocalDateTime reg_day;
    @UpdateTimestamp
    private LocalDateTime mod_day;

}
