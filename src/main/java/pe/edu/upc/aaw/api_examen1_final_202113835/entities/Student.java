package pe.edu.upc.aaw.api_examen1_final_202113835.entities;

import javax.persistence.*;

@Entity
@Table(name = "Student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hryeId;
    @Column(name = "hryeCode",nullable = false,length = 40,unique = true)
    private String hryeCode;
    @Column(name = "hryeName",nullable = false,length = 40)
    private String hryeName;
    @Column(name = "hryeWeightedAverage",nullable = false,length = 40)
    private double hryeWeightedAverage;
    @ManyToOne
    @JoinColumn(name ="hryeUniversity")
    private University hryeUniversity;

    public Student() {
    }

    public Long getHryeId() {
        return hryeId;
    }

    public void setHryeId(Long hryeId) {
        this.hryeId = hryeId;
    }

    public String getHryeCode() {
        return hryeCode;
    }

    public void setHryeCode(String hryeCode) {
        this.hryeCode = hryeCode;
    }

    public String getHryeName() {
        return hryeName;
    }

    public void setHryeName(String hryeName) {
        this.hryeName = hryeName;
    }

    public double getHryeWeightedAverage() {
        return hryeWeightedAverage;
    }

    public void setHryeWeightedAverage(double hryeWeightedAverage) {
        this.hryeWeightedAverage = hryeWeightedAverage;
    }

    public University getHryeUniversity() {
        return hryeUniversity;
    }

    public void setHryeUniversity(University hryeUniversity) {
        this.hryeUniversity = hryeUniversity;
    }
}
