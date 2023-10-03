package pe.edu.upc.aaw.api_examen1_final_202113835.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import pe.edu.upc.aaw.api_examen1_final_202113835.entities.Student;
import pe.edu.upc.aaw.api_examen1_final_202113835.entities.University;

import java.util.List;

@Repository
public interface IUniversityRepository extends JpaRepository<University,Long> {
    @Query(value = "select s.hrye_id,\n" +
            " s.hrye_code,\n" +
            " s.hrye_name,\n" +
            " s.hrye_weighted_average,\n" +
            " s.hrye_university\n" +
            " from university u\n" +
            " inner join student s\n" +
            " on s.hrye_university=u.hrye_id\n" +
            " where u.hrye_id=:hrye_id",nativeQuery = true)
    public List<String[]>findStudensByIdUniversity(@Param("hrye_id") Long hrye_id);

    @Query(value = "select s.hrye_id,\n" +
            " s.hrye_code,\n" +
            " s.hrye_name,\n" +
            " s.hrye_weighted_average,\n" +
            " s.hrye_university\n" +
            " from student s\n" +
            " where s.hrye_weighted_average>=:hrye_weitghted_average\n" +
            " order by s.hrye_name asc",nativeQuery = true)
    public List<String[]>StudensByQualificationAsc(@Param("hrye_weitghted_average") double hrye_weitghted_average);

}
