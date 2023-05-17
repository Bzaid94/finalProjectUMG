package com.umg.edu.manager.curso;


import com.umg.edu.entity.Curso;
import com.umg.edu.repository.CursoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CursoManagerImpl implements CursoManager{
    Logger logger = LoggerFactory.getLogger(CursoManagerImpl.class);

    @Autowired
    private CursoRepository cursoRepository;
    @Override
    public Curso saveCurso(Curso curso) {
        logger.info("Curso saved {}", curso);
        curso.setStatus(true);
        return cursoRepository.save(curso);
    }

    @Override
    public Curso getCursoById(Long id) {
        logger.info("Curso by id {}", id);
        return cursoRepository.findById(id).get();
    }

    @Override
    public List<Curso> getAllCursos() {
        logger.info("Get all cursos");
        return cursoRepository.findByStatusTrue();
    }

    @Override
    public Curso updateCurso(Curso curso, Long id) {
        logger.info("Request update Curso by ID: {}", id);

        Curso cursoUpdate = cursoRepository.findById(id).get();

        if(Objects.nonNull(curso.getName()) && !"".equalsIgnoreCase(curso.getName())){
            cursoUpdate.setName(curso.getName());
        }

        if(Objects.nonNull(curso.getDescription()) && !"".equalsIgnoreCase(curso.getDescription())){
            cursoUpdate.setDescription(curso.getDescription());
        }

        logger.info("Curso updated {}", cursoUpdate);
        return cursoRepository.save(cursoUpdate);
    }

    @Override
    public void deleteCurso(Long id) {
        logger.info("Request deleted by ID {}", id);
        Curso curso = cursoRepository.findById(id).orElseThrow(()->
                new RuntimeException("Catedratico not found with Id: " + id));
        curso.setStatus(false);
        logger.info("Catedratico deleted {}", id);
        cursoRepository.save(curso);
    }
}
