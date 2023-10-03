package pe.edu.upc.aaw.api_examen1_final_202113835.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.aaw.api_examen1_final_202113835.entities.Student;
import pe.edu.upc.aaw.api_examen1_final_202113835.entities.University;
import pe.edu.upc.aaw.api_examen1_final_202113835.repositories.IUniversityRepository;
import pe.edu.upc.aaw.api_examen1_final_202113835.serviceinterfaces.IUniversityService;

import java.util.List;

@Service
public class UniversityServiceImplement implements IUniversityService {
    @Autowired
    private IUniversityRepository hryeUR;
    @Override
    public void insert(University hryeUniversity) {
        hryeUR.save(hryeUniversity);
    }

    @Override
    public List<String[]> findStudensByIdUniversity(Long hrye_id) {
        return hryeUR.findStudensByIdUniversity(hrye_id);
    }

    @Override
    public List<String[]> StudensByQualificationAsc(double hrye_weitghted_average) {
        return hryeUR.StudensByQualificationAsc(hrye_weitghted_average);
    }


}
