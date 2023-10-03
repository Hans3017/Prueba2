package pe.edu.upc.aaw.api_examen1_final_202113835.dtos;

public class Report2 {
    private Long hrye_id;
    private String hrye_code;
    private String hrye_name;
    private double hrye_weighted_average;
    private Long hrye_university;

    public Long getHrye_id() {
        return hrye_id;
    }

    public void setHrye_id(Long hrye_id) {
        this.hrye_id = hrye_id;
    }

    public String getHrye_code() {
        return hrye_code;
    }

    public void setHrye_code(String hrye_code) {
        this.hrye_code = hrye_code;
    }

    public String getHrye_name() {
        return hrye_name;
    }

    public void setHrye_name(String hrye_name) {
        this.hrye_name = hrye_name;
    }

    public double getHrye_weighted_average() {
        return hrye_weighted_average;
    }

    public void setHrye_weighted_average(double hrye_weighted_average) {
        this.hrye_weighted_average = hrye_weighted_average;
    }

    public Long getHrye_university() {
        return hrye_university;
    }

    public void setHrye_university(Long hrye_university) {
        this.hrye_university = hrye_university;
    }
}
