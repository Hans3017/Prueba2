package pe.edu.upc.aaw.api_examen1_final_202113835.security;

import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import pe.edu.upc.aaw.api_examen1_final_202113835.serviceimplements.JwtUserDetailsService;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Component
public class JwtRequestFilter extends OncePerRequestFilter {
    @Autowired
    private JwtUserDetailsService hryeJwtUserDetailsService;
    @Autowired
    private JwtTokenUtil hryeJwtTokenUtil;
    @Override
    protected void doFilterInternal(HttpServletRequest hryeRequest, HttpServletResponse hryeResponse, FilterChain hryeChain)
            throws ServletException, IOException {
        final String hryeRequestTokenHeader = hryeRequest.getHeader("Authorization");
        String hryeUsername = null;
        String hryeJwtToken = null;
        // JWT Token is in the form "Bearer token". Remove Bearer word and get
        // only the Token
        if (hryeRequestTokenHeader != null && hryeRequestTokenHeader.startsWith("Bearer ")) {
            //jwtToken = requestTokenHeader.substring(7);
            hryeJwtToken = hryeRequestTokenHeader.split(" ")[1].trim();

            try {
                hryeUsername = hryeJwtTokenUtil.getUsernameFromToken(hryeJwtToken);
            } catch (IllegalArgumentException hryeE) {
                System.out.println("No se puede encontrar el token JWT");
            } catch (ExpiredJwtException hryeE) {
                System.out.println("Token JWT ha expirado");
            }
        } else {
            logger.warn("JWT Token no inicia con la palabra Bearer");
        }

        // Once we get the token validate it.
        if (hryeUsername != null && SecurityContextHolder.getContext().getAuthentication() == null) {

            UserDetails hryeUserDetails = this.hryeJwtUserDetailsService.loadUserByUsername(hryeUsername);

            // if token is valid configure Spring Security to manually set
            // authentication
            if (hryeJwtTokenUtil.validateToken(hryeJwtToken, hryeUserDetails)) {

                UsernamePasswordAuthenticationToken hryeUsernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                        hryeUserDetails, null, hryeUserDetails.getAuthorities());
                hryeUsernamePasswordAuthenticationToken
                        .setDetails(new WebAuthenticationDetailsSource().buildDetails(hryeRequest));
                // After setting the Authentication in the context, we specify
                // that the current user is authenticated. So it passes the
                // Spring Security Configurations successfully.
                SecurityContextHolder.getContext().setAuthentication(hryeUsernamePasswordAuthenticationToken);
            }
        }
        hryeChain.doFilter(hryeRequest, hryeResponse);
    }
}
