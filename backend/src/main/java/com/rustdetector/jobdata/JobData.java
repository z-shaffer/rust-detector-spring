package com.rustdetector.jobdata;

import jakarta.persistence.*;

import java.time.Year;
import java.time.Month;

@Entity
@Table()
public class JobData {
    @Id
    @SequenceGenerator(
            name = "job_data_sequence",
            sequenceName = "job_data_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator =  "job_data_sequence"
    )
    private Long id;
    private Integer rustCount;
    private Integer pythonCount;
    private Integer goCount;
    private Integer month;
    private Integer year;

    public JobData() {
        this.year = Year.now().getValue();
        this.month = Month.from(java.time.LocalDate.now()).getValue();
    }

    public JobData(Integer rustCount, Integer pythonCount, Integer goCount) {
        this.rustCount = rustCount;
        this.pythonCount = pythonCount;
        this.goCount = goCount;
        this.year = Year.now().getValue();
        this.month = Month.from(java.time.LocalDate.now()).getValue();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getRustCount() {
        return rustCount;
    }

    public void setRustCount(Integer rustCount) {
        this.rustCount = rustCount;
    }

    public Integer getPythonCount() {
        return pythonCount;
    }

    public void setPythonCount(Integer pythonCount) {
        this.pythonCount = pythonCount;
    }

    public Integer getGoCount() {
        return goCount;
    }

    public void setGoCount(Integer goCount) {
        this.goCount = goCount;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "JobData " + month + year + " {" +
                "Rust Jobs = " + rustCount +
                ", Python Jobs = " + pythonCount +
                ", Go Jobs= " + goCount +
                '}';
    }
}
