package pe.edu.upc.aaw.api_examen1_final_202113835.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.aaw.api_examen1_final_202113835.entities.Student;
import pe.edu.upc.aaw.api_examen1_final_202113835.repositories.IStudentRepository;
import pe.edu.upc.aaw.api_examen1_final_202113835.serviceinterfaces.IStudentService;
@Service
public class StudentServiceImplement implements IStudentService {
    @Autowired
    private IStudentRepository hryeSR;

    @Override
    public void insert(Student hryeStudent) {
        hryeSR.save(hryeStudent);
    }
}
