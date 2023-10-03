package pe.edu.upc.aaw.api_examen1_final_202113835.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.aaw.api_examen1_final_202113835.dtos.Report1;
import pe.edu.upc.aaw.api_examen1_final_202113835.dtos.Report2;
import pe.edu.upc.aaw.api_examen1_final_202113835.dtos.StudentDTO;
import pe.edu.upc.aaw.api_examen1_final_202113835.dtos.UniversityDTO;
import pe.edu.upc.aaw.api_examen1_final_202113835.entities.University;
import pe.edu.upc.aaw.api_examen1_final_202113835.serviceinterfaces.IUniversityService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class UniversityController {
    @Autowired
    private IUniversityService hryeUS;

    @PreAuthorize("hasAuthority('ADMINISTRATOR')")
    @PostMapping("/universities")
    public void registrar(@RequestBody UniversityDTO hryeDto) {
        ModelMapper hryeM = new ModelMapper();
        University hryeD = hryeM.map(hryeDto, University.class);
        hryeUS.insert(hryeD);
    }
    @GetMapping("/students_u/{hrye_id_university}")
    @PreAuthorize("hasAuthority('USER')")
    public List<Report1> listaEstudiantesPorIdUniversidad(@PathVariable("hrye_id_university") Long hrye_id_university){
        List<String[]>hryeLista=hryeUS.findStudensByIdUniversity(hrye_id_university);
        List<Report1>hryeListaDTO=new ArrayList<>();
        for(String[] data:hryeLista){
            Report1 hryeDto=new Report1();
            hryeDto.setHrye_id(Long.parseLong((data[0])));
            hryeDto.setHrye_code(data[1]);
            hryeDto.setHrye_name(data[2]);
            hryeDto.setHrye_weighted_average(Double.parseDouble(data[3]));
            hryeDto.setHrye_university(Long.parseLong(data[4]));
            hryeListaDTO.add(hryeDto);
        }
        return hryeListaDTO;
    }

    @GetMapping("/students_q/{hrye_qualification}")
    @PreAuthorize("hasAuthority('USER')")
    public List<Report2> listaEstudiantesPorCalificacion(@PathVariable("hrye_qualification") double hrye_qualification){
        List<String[]>hryeLista=hryeUS.StudensByQualificationAsc(hrye_qualification);
        List<Report2>hryeListaDTO=new ArrayList<>();
        for(String[] data:hryeLista){
            Report2 hryeDto=new Report2();
            hryeDto.setHrye_id(Long.parseLong((data[0])));
            hryeDto.setHrye_code(data[1]);
            hryeDto.setHrye_name(data[2]);
            hryeDto.setHrye_weighted_average(Double.parseDouble(data[3]));
            hryeDto.setHrye_university(Long.parseLong(data[4]));
            hryeListaDTO.add(hryeDto);
        }
        return hryeListaDTO;
    }
}
