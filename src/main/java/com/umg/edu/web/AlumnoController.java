package com.umg.edu.web;

import com.umg.edu.entity.Alumno;
import com.umg.edu.manager.alumno.AlumnoManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alumno")
@CrossOrigin(origins = "${angular.url}", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class AlumnoController {
    @Autowired
    private AlumnoManager alumnoManager;

    @PostMapping("/new/")
    public Alumno saveMessage(@RequestBody Alumno alumno) {
        return alumnoManager.saveAlumno(alumno);
    }

    @GetMapping("/get/{id}/")
    public Alumno getMessageById(@PathVariable("id") Long id) {
        return alumnoManager.getAlumnoById(id);
    }

    @GetMapping("/listAll/")
    public List<Alumno> getMessageList() {
        return alumnoManager.getAllAlumnos();
    }

    @PutMapping("/update/{id}/")
    public Alumno updateMessage(@RequestBody Alumno alumno, @PathVariable("id") Long id) {
        return alumnoManager.updateAlumno(alumno, id);
    }

    @DeleteMapping("/delete/{id}/")
    public String deleteMessageById(@PathVariable("id") Long id){
        alumnoManager.deleteAlumno(id);
        return "Message deleted successfully";
    }
}
