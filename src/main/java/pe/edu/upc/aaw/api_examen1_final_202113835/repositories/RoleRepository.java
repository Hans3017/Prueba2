package pe.edu.upc.aaw.api_examen1_final_202113835.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.aaw.api_examen1_final_202113835.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
