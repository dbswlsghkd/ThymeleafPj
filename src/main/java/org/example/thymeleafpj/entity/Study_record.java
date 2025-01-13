package org.example.thymeleafpj.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Table(name = "study_record")
@Entity
@Data
public class Study_record {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int key_id;
    private String study_day;
    private String contents;
    private LocalDateTime reg_day;

    public Study_record(int key_id, String study_day, String contents, LocalDateTime reg_day) {
        this.key_id = key_id;
        this.study_day = study_day;
        this.contents = contents;
        this.reg_day = reg_day;
    }

    public Study_record() {
    }

    public static Study_recordBuilder builder() {
        return new Study_recordBuilder();
    }

    public int getKey_id() {
        return this.key_id;
    }

    public String getStudy_day() {
        return this.study_day;
    }

    public String getContents() {
        return this.contents;
    }

    public LocalDateTime getReg_day() {
        return this.reg_day;
    }

    public void setKey_id(int key_id) {
        this.key_id = key_id;
    }

    public void setStudy_day(String study_day) {
        this.study_day = study_day;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public void setReg_day(LocalDateTime reg_day) {
        this.reg_day = reg_day;
    }

    public static class Study_recordBuilder {
        private int key_id;
        private String study_day;
        private String contents;
        private LocalDateTime reg_day;

        Study_recordBuilder() {
        }

        public Study_recordBuilder key_id(int key_id) {
            this.key_id = key_id;
            return this;
        }

        public Study_recordBuilder study_day(String study_day) {
            this.study_day = study_day;
            return this;
        }

        public Study_recordBuilder contents(String contents) {
            this.contents = contents;
            return this;
        }

        public Study_recordBuilder reg_day(LocalDateTime reg_day) {
            this.reg_day = reg_day;
            return this;
        }

        public Study_record build() {
            return new Study_record(this.key_id, this.study_day, this.contents, this.reg_day);
        }

        public String toString() {
            return "Study_record.Study_recordBuilder(key_id=" + this.key_id + ", study_day=" + this.study_day + ", contents=" + this.contents + ", reg_day=" + this.reg_day + ")";
        }
    }
}
