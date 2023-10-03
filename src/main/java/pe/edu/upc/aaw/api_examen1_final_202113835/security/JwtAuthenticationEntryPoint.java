package pe.edu.upc.aaw.api_examen1_final_202113835.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;
@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint, Serializable {
    private static final long hryeSerialVersionUID = -7858869558953243875L;

    @Override
    public void commence(HttpServletRequest hryeRequest, HttpServletResponse hryeResponse,
                         AuthenticationException hryeAuthException) throws IOException {

        hryeResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
    }
}
