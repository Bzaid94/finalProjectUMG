package com.umg.edu.manager.curso;

import com.umg.edu.entity.Curso;

import java.util.List;

public interface CursoManager {
    Curso saveCurso(Curso curso);

    Curso getCursoById(Long id);

    List<Curso> getAllCursos();

    Curso updateCurso(Curso curso, Long id);

    void deleteCurso(Long id);
}
