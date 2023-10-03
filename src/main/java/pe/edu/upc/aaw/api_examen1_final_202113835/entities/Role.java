package pe.edu.upc.aaw.api_examen1_final_202113835.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "roles", uniqueConstraints = { @UniqueConstraint(columnNames = { "hrye_user_id", "hrye_rol" }) })
public class Role implements Serializable {
    private static final long hryeSerialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hryeId;
    @Column(name="hrye_rol",length = 50)
    private String hryeRol;

    @ManyToOne
    @JoinColumn(name="hrye_user_id", nullable=false)
    private Users hryeUser;

    public Role() {
    }

    public Long getHryeId() {
        return hryeId;
    }

    public void setHryeId(Long hryeId) {
        this.hryeId = hryeId;
    }

    public String getHryeRol() {
        return hryeRol;
    }

    public void setHryeRol(String hryeRol) {
        this.hryeRol = hryeRol;
    }

    public Users getHryeUser() {
        return hryeUser;
    }

    public void setHryeUser(Users hryeUser) {
        this.hryeUser = hryeUser;
    }
}
