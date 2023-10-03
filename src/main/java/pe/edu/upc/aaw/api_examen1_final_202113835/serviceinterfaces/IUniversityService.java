package pe.edu.upc.aaw.api_examen1_final_202113835.serviceinterfaces;

import org.springframework.data.repository.query.Param;
import pe.edu.upc.aaw.api_examen1_final_202113835.entities.Student;
import pe.edu.upc.aaw.api_examen1_final_202113835.entities.University;

import java.util.List;

public interface IUniversityService {
    public void insert(University hryeUniversity);
    public List<String[]>findStudensByIdUniversity(Long hrye_id);
    public List<String[]>StudensByQualificationAsc(double hrye_weitghted_average);

}
