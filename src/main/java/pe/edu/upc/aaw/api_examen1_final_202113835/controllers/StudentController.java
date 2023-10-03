package pe.edu.upc.aaw.api_examen1_final_202113835.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.upc.aaw.api_examen1_final_202113835.dtos.StudentDTO;
import pe.edu.upc.aaw.api_examen1_final_202113835.dtos.UniversityDTO;
import pe.edu.upc.aaw.api_examen1_final_202113835.entities.Student;
import pe.edu.upc.aaw.api_examen1_final_202113835.entities.University;
import pe.edu.upc.aaw.api_examen1_final_202113835.serviceinterfaces.IStudentService;
import pe.edu.upc.aaw.api_examen1_final_202113835.serviceinterfaces.IUniversityService;

@RestController
@RequestMapping("/api")
public class StudentController {
    @Autowired
    private IStudentService hryeSS;

    @PreAuthorize("hasAuthority('ADMINISTRATOR')")
    @PostMapping("/students")
    public void registrar(@RequestBody StudentDTO hryeDto) {
        ModelMapper hryeM = new ModelMapper();
        Student hryeU = hryeM.map(hryeDto, Student.class);
        hryeSS.insert(hryeU);
    }
}
