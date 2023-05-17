package com.umg.edu.manager.catedratico;

import com.umg.edu.entity.Catedratico;

import java.util.List;

public interface CatedratioManager {
    Catedratico saveCatedratico(Catedratico catedratico);

    Catedratico getCatedraticoById(Long id);

    List<Catedratico> getAllCatedraticos();

    Catedratico updateCatedratico(Catedratico catedratico, Long id);

    void deleteCatedratico(Long id);
}
