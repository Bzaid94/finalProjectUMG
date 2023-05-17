package com.umg.edu.manager.catedratico;

import com.umg.edu.entity.Catedratico;
import com.umg.edu.repository.CatedraticoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CatedraticoManagerImpl implements CatedratioManager {
    Logger logger = LoggerFactory.getLogger(CatedraticoManagerImpl.class);

    @Autowired
    private CatedraticoRepository catedraticoRepository;

    @Override
    public Catedratico saveCatedratico(Catedratico catedratico) {
        logger.info("Catedratico saved {}", catedratico);
        catedratico.setStatus(true);
        return catedraticoRepository.save(catedratico);
    }

    @Override
    public Catedratico getCatedraticoById(Long id) {
        logger.info("Catedratico by ID {}", id);
        return catedraticoRepository.findById(id).get();
    }

    @Override
    public List<Catedratico> getAllCatedraticos() {
        logger.info("Get all Catedraticos");
        return catedraticoRepository.findByStatusTrue();
    }

    @Override
    public Catedratico updateCatedratico(Catedratico catedratico, Long id) {
        logger.info("Request update Catedratico by Id: {}", id);

        Catedratico catedraticoUpdate = catedraticoRepository.findById(id).get();

        if(Objects.nonNull(catedratico.getName()) && !"".equalsIgnoreCase(catedratico.getName())){
            catedraticoUpdate.setName(catedratico.getName());
        }

        if(Objects.nonNull(catedratico.getSpeciality()) && !"".equalsIgnoreCase(catedratico.getSpeciality())){
            catedraticoUpdate.setSpeciality(catedratico.getSpeciality());
        }

        if(Objects.nonNull(catedratico.getEmail()) && !"".equalsIgnoreCase(catedratico.getEmail())){
            catedraticoUpdate.setEmail(catedratico.getEmail());
        }


        logger.info("Catedratico updated {}", catedraticoUpdate);
        return catedraticoRepository.save(catedraticoUpdate);
    }

    @Override
    public void deleteCatedratico(Long id) {
        logger.info("Request delete by Id {}", id);
        Catedratico catedratico = catedraticoRepository.findById(id).orElseThrow(()->
                new RuntimeException("Catedratico not found with Id: " + id));
        catedratico.setStatus(false);
        logger.info("Catedratico deleted {}", id);
        catedraticoRepository.save(catedratico);
    }
}
