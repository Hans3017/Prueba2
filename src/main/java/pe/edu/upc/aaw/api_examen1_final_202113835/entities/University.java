package pe.edu.upc.aaw.api_examen1_final_202113835.entities;

import javax.persistence.*;

@Entity
@Table(name = "University")
public class University {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hryeId;
    @Column(name = "hryeName",nullable = false,length = 40)
    private String hryeName;
    @Column(name = "hryeAddress",nullable = false,length = 40)
    private String hryeAddress;
    @Column(name = "hryeEmail",nullable = false,length = 40)
    private String hryeEmail;

    public University() {
    }

    public Long getHryeId() {
        return hryeId;
    }

    public void setHryeId(Long hryeId) {
        this.hryeId = hryeId;
    }

    public String getHryeName() {
        return hryeName;
    }

    public void setHryeName(String hryeName) {
        this.hryeName = hryeName;
    }

    public String getHryeAddress() {
        return hryeAddress;
    }

    public void setHryeAddress(String hryeAddress) {
        this.hryeAddress = hryeAddress;
    }

    public String getHryeEmail() {
        return hryeEmail;
    }

    public void setHryeEmail(String hryeEmail) {
        this.hryeEmail = hryeEmail;
    }
}
