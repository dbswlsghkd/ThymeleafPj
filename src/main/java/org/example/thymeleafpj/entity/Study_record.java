package org.example.thymeleafpj.entity;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

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
    @Column(name = "key_id")
    private Integer keyId;
    @Column(name = "study_day")
    private String studyDay;
    private String contents;

    @Column(updatable = false, name = "reg_day")  // 첫 생성 시에만 값을 넣도록 설정
    private LocalDateTime regDay;
    @Column(name = "mod_day")
    private OffsetDateTime modDay;

    // 생성 시 시간 자동 설정
    @PrePersist
    public void prePersist() {
        if (this.regDay == null) {
            this.regDay = LocalDateTime.now();  // 현재 시간을 설정
        }
    }
    // 업데이트 시 시간 자동 설정
    @PreUpdate
    public void preUpdate() {
        this.modDay = OffsetDateTime.now();  // 현재 시간을 설정
    }

}
