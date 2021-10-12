/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Duy Hiep
 */
public class StudentCertificate {
    private Student student;
    private Certificate certificate;

    public StudentCertificate() {
    }

    public StudentCertificate(Student student, Certificate certificate) {
        this.student = student;
        this.certificate = certificate;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Certificate getCertificate() {
        return certificate;
    }

    public void setCertificate(Certificate certificate) {
        this.certificate = certificate;
    }
}
