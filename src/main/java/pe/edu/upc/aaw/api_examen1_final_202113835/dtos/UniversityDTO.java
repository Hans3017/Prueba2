package pe.edu.upc.aaw.api_examen1_final_202113835.dtos;

import javax.persistence.Column;

public class UniversityDTO {
    private Long hryeId;
    private String hryeName;
    private String hryeAddress;
    private String hryeEmail;

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
