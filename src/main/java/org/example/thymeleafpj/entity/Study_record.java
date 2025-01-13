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

    @Column(updatable = false)  // 첫 생성 시에만 값을 넣도록 설정
    private LocalDateTime reg_day;
    private LocalDateTime mod_day;

    // 생성 시 시간 자동 설정
    @PrePersist
    public void prePersist() {
        if (this.reg_day == null) {
            this.reg_day = LocalDateTime.now();  // 현재 시간을 설정
        }
    }
    // 업데이트 시 시간 자동 설정
    @PreUpdate
    public void preUpdate() {
        this.mod_day = LocalDateTime.now();  // 현재 시간을 설정
    }

}
