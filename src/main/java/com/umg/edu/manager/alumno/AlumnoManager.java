package com.umg.edu.manager.alumno;

import com.umg.edu.entity.Alumno;

import java.util.List;

public interface AlumnoManager {
    Alumno saveAlumno(Alumno alumno);

    Alumno getAlumnoById(Long id);

    List<Alumno> getAllAlumnos();

    Alumno updateAlumno(Alumno alumno, Long id);

    void deleteAlumno(Long id);
}
