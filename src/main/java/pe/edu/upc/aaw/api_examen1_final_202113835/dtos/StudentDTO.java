package pe.edu.upc.aaw.api_examen1_final_202113835.dtos;

import pe.edu.upc.aaw.api_examen1_final_202113835.entities.University;


public class StudentDTO {
    private Long hryeId;
    private String hryeCode;
    private String hryeName;
    private double hryeWeightedAverage;
    private University hryeUniversity;

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
