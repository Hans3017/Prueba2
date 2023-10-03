package pe.edu.upc.aaw.api_examen1_final_202113835.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pe.edu.upc.aaw.api_examen1_final_202113835.entities.Users;
import pe.edu.upc.aaw.api_examen1_final_202113835.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;
@Service
public class JwtUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository hryeRepo;

    @Override
    public UserDetails loadUserByUsername(String hryeUsername) throws UsernameNotFoundException {
        Users hryeUser = hryeRepo.findByHryeUsername(hryeUsername);

        if(hryeUser == null) {
            throw new UsernameNotFoundException(String.format("User not exists", hryeUsername));
        }

        List<GrantedAuthority> hryeRoles = new ArrayList<>();

        hryeUser.getHryeRoles().forEach(rol -> {
            hryeRoles.add(new SimpleGrantedAuthority(rol.getHryeRol()));
        });

        UserDetails hryeUd = new org.springframework.security.core.userdetails.User(hryeUser.getHryeUsername(), hryeUser.getHryePassword(), hryeUser.getHryeEnabled(), true, true, true, hryeRoles);

        return hryeUd;
    }
}
