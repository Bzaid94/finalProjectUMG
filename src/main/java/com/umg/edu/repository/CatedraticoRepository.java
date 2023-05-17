package com.umg.edu.repository;

import com.umg.edu.entity.Catedratico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CatedraticoRepository extends JpaRepository<Catedratico, Long> {
    List<Catedratico> findByStatusTrue();
}
