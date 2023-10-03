package pe.edu.upc.aaw.api_examen1_final_202113835.security;

import java.io.Serializable;

public class JwtResponse implements Serializable {
    private static final long hryeSerialVersionUID = -8091879091924046844L;
    private final String hryeJwttoken;

    public String getJwttoken() {
        return hryeJwttoken;
    }

    public JwtResponse(String hryeJwttoken) {
        super();
        this.hryeJwttoken = hryeJwttoken;
    }
}
