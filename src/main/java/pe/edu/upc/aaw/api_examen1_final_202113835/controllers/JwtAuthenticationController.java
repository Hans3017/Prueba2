package pe.edu.upc.aaw.api_examen1_final_202113835.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upc.aaw.api_examen1_final_202113835.security.JwtRequest;
import pe.edu.upc.aaw.api_examen1_final_202113835.security.JwtResponse;
import pe.edu.upc.aaw.api_examen1_final_202113835.security.JwtTokenUtil;
import pe.edu.upc.aaw.api_examen1_final_202113835.serviceimplements.JwtUserDetailsService;

@RestController
@CrossOrigin
public class JwtAuthenticationController {
    @Autowired
    private AuthenticationManager hryeAuthenticationManager;
    @Autowired
    private JwtTokenUtil hryeJwtTokenUtil;
    @Autowired
    private JwtUserDetailsService hryeUserDetailsService;
    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest hryeAuthenticationRequest) throws Exception {
        authenticate(hryeAuthenticationRequest.getHryeUsername(), hryeAuthenticationRequest.getHryePassword());
        final UserDetails hryeUserDetails = hryeUserDetailsService.loadUserByUsername(hryeAuthenticationRequest.getHryeUsername());
        final String hryeToken = hryeJwtTokenUtil.generateToken(hryeUserDetails);
        return ResponseEntity.ok(new JwtResponse(hryeToken));
    }
    private void authenticate(String hryeUsername, String hryePassword) throws Exception {
        try {
            hryeAuthenticationManager.authenticate(new UsernamePasswordAuthenticationToken(hryeUsername, hryePassword));
        } catch (DisabledException hryeE) {
            throw new Exception("USER_DISABLED", hryeE);
        } catch (BadCredentialsException hryeE) {
            throw new Exception("INVALID_CREDENTIALS", hryeE);
        }
    }
}
