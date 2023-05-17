package com.umg.edu.web;

import com.umg.edu.entity.Catedratico;
import com.umg.edu.manager.catedratico.CatedratioManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/catedratico")
@CrossOrigin(origins = "${angular.url}", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class CatedraticoController {

    @Autowired
    private CatedratioManager catedratioManager;

    @PostMapping("/new/")
    public Catedratico saveMessage(@RequestBody Catedratico catedratico) {
        return catedratioManager.saveCatedratico(catedratico);
    }

    @GetMapping("/get/{id}/")
    public Catedratico getMessageById(@PathVariable("id") Long id) {
        return catedratioManager.getCatedraticoById(id);
    }

    @GetMapping("/listAll/")
    public List<Catedratico> getMessageList() {
        return catedratioManager.getAllCatedraticos();
    }

    @PutMapping("/update/{id}/")
    public Catedratico updateMessage(@RequestBody Catedratico catedratico, @PathVariable("id") Long id) {
        return catedratioManager.updateCatedratico(catedratico, id);
    }

    @DeleteMapping("/delete/{id}/")
    public String deleteMessageById(@PathVariable("id") Long id){
        catedratioManager.deleteCatedratico(id);
        return "Message deleted successfully";
    }
}
