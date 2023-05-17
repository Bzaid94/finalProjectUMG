package com.umg.edu.manager.alumno;

import com.umg.edu.entity.Alumno;
import com.umg.edu.repository.AlumnoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class AlumnoManagerImpl implements AlumnoManager{
    Logger logger = LoggerFactory.getLogger(AlumnoManagerImpl.class);

    @Autowired
    private AlumnoRepository alumnoRepository;

    @Override
    public Alumno saveAlumno(Alumno alumno) {
        logger.info("Alumno saved {}", alumno);
        alumno.setStatus(true);
        return alumnoRepository.save(alumno);
    }

    @Override
    public Alumno getAlumnoById(Long id) {
        logger.info("Alumno by ID {}", id);
        return alumnoRepository.findById(id).get();
    }

    @Override
    public List<Alumno> getAllAlumnos() {
        logger.info("Get all Alumnos");
        return alumnoRepository.findByStatusTrue();
    }

    @Override
    public Alumno updateAlumno(Alumno alumno, Long id) {
        logger.info("Request update Alumno by Id: {}", id);

        Alumno alumnoUpdate = alumnoRepository.findById(id).get();

        if(Objects.nonNull(alumno.getName()) && !"".equalsIgnoreCase(alumno.getName())){
            alumnoUpdate.setName(alumno.getName());
        }

        if(Objects.nonNull(alumno.getLastName()) && !"".equalsIgnoreCase(alumno.getLastName())){
            alumnoUpdate.setLastName(alumno.getLastName());
        }

        if(Objects.nonNull(alumno.getEmail()) && !"".equalsIgnoreCase(alumno.getEmail())){
            alumnoUpdate.setEmail(alumno.getEmail());
        }


        logger.info("Alumno updated {}", alumnoUpdate);
        return alumnoRepository.save(alumnoUpdate);
    }

    @Override
    public void deleteAlumno(Long id) {
        logger.info("Request delete by Id {}", id);
        Alumno alumno = alumnoRepository.findById(id).orElseThrow(()->
                new RuntimeException("Alumno not found with Id: " + id));
        alumno.setStatus(false);
        logger.info("Alumno deleted {}", id);
        alumnoRepository.save(alumno);
    }
}
