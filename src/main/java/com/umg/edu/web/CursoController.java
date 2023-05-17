package com.umg.edu.web;

import com.umg.edu.entity.Curso;
import com.umg.edu.manager.curso.CursoManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/curso")
@CrossOrigin(origins = "${angular.url}", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class CursoController {
    @Autowired
    private CursoManager cursoManager;

    @PostMapping("/new/")
    public Curso saveMessage(@RequestBody Curso curso) {
        return cursoManager.saveCurso(curso);
    }

    @GetMapping("/get/{id}/")
    public Curso getMessageById(@PathVariable("id") Long id) {
        return cursoManager.getCursoById(id);
    }

    @GetMapping("/listAll/")
    public List<Curso> getMessageList() {
        return cursoManager.getAllCursos();
    }

    @PutMapping("/update/{id}/")
    public Curso updateMessage(@RequestBody Curso curso, @PathVariable("id") Long id) {
        return cursoManager.updateCurso(curso, id);
    }

    @DeleteMapping("/delete/{id}/")
    public String deleteMessageById(@PathVariable("id") Long id){
        cursoManager.deleteCurso(id);
        return "Message deleted successfully";
    }

}
