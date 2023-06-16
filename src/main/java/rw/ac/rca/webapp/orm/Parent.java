
package rw.ac.rca.webapp.orm;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "parents")
public class Parent  extends Person{
    @Column
    @NotNull
    private String nationalId;
    @Column
    @NotNull
    private Long schoolFees;

    @ManyToOne
    @JoinColumn(name = "studentId")
    private Student student;

    public Parent(String nationalId, Long schoolFees, Student student) {
        this.nationalId = nationalId;
        this.schoolFees = schoolFees;
        this.student = student;
    }

    public Parent(String firstName, String lastName, Date dateOfBirth, String phoneNumber, String nationalId, Long schoolFees, Student student) {
        super(firstName, lastName, dateOfBirth, phoneNumber);
        this.nationalId = nationalId;
        this.schoolFees = schoolFees;
        this.student = student;
    }

    public Parent() {

    }

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public Long getSchoolFees() {
        return schoolFees;
    }

    public void setSchoolFees(Long schoolFees) {
        this.schoolFees = schoolFees;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}