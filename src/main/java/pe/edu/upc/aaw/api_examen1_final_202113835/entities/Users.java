package pe.edu.upc.aaw.api_examen1_final_202113835.entities;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hryeId;

    @Column(length = 30, unique = true)
    private String hryeUsername;
    @Column(length = 200)
    private String hryePassword;
    private Boolean hryeEnabled;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "hrye_user_id")
    private List<Role> hryeRoles;

    public Users() {
    }

    public Long getHryeId() {
        return hryeId;
    }

    public void setHryeId(Long hryeId) {
        this.hryeId = hryeId;
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

    public Boolean getHryeEnabled() {
        return hryeEnabled;
    }

    public void setHryeEnabled(Boolean hryeEnabled) {
        this.hryeEnabled = hryeEnabled;
    }

    public List<Role> getHryeRoles() {
        return hryeRoles;
    }

    public void setHryeRoles(List<Role> hryeRoles) {
        this.hryeRoles = hryeRoles;
    }
}
