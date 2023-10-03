package pe.edu.upc.aaw.api_examen1_final_202113835.security;

import java.io.Serializable;

public class JwtRequest implements Serializable {
    private static final long hryeSerialVersionUID = 5926468583005150707L;
    private String hryeUsername;
    private String hryePassword;
    public JwtRequest() {
        super();
        // TODO Auto-generated constructor stub
    }
    public JwtRequest(String hryeUsername, String hryePassword) {
        super();
        this.hryeUsername = hryeUsername;
        this.hryePassword = hryePassword;
    }
    public static long getHryeSerialVersionUID() {
        return hryeSerialVersionUID;
    }

    public String getHryeUsername() {
        return hryeUsername;
    }

    public void setHryeUsername(String hryeUsername) {
        this.hryeUsername = hryeUsername;
    }

    public String getHryePassword() {
        return hryePassword;
    }

    public void setHryePassword(String hryePassword) {
        this.hryePassword = hryePassword;
    }
}
