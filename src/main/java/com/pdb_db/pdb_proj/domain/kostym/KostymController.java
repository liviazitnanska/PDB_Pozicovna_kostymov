package com.pdb_db.pdb_proj.domain.kostym;

import com.pdb_db.pdb_proj.domain.doplnok.Doplnok;
import com.pdb_db.pdb_proj.domain.doplnok.DoplnokService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/kostym")
public class KostymController
{
    private final KostymService kostymService;

    @Autowired
    public KostymController(KostymService kostymService) {
        this.kostymService = kostymService;
    }

    @GetMapping
    public List<Kostym> getKostymy()
    {
        return kostymService.getKostymy();
    }

    /*@GetMapping
    public Kostym getKostymById(Integer id)
    {
        return kostymService.getKostymById(id);
    }*/

    @PostMapping
    public void registerNewKostym(@RequestBody Kostym kostym)
    {
        kostymService.addNewKostym(kostym);
    }

    @DeleteMapping(path = "{kostymId}")
    public void deleteKostym(@PathVariable("kostymId") Integer kostymId)
    {
        kostymService.deleteKostym(kostymId);
    }

    @PutMapping(path = "{kostymId}")
    public void updateDoplnok(
            @PathVariable("kostymId") Integer kostymId,
            @RequestParam(required = false) String nazov,
            @RequestParam(required = false) String popis,
            @RequestParam(required = false) String material,
            @RequestParam(required = false) String kategoria,
            @RequestParam(required = false) Integer velkost,
            @RequestParam(required = false) java.sql.Date vyroba)
    {
        kostymService.updateKostym(kostymId,nazov,popis,material,kategoria,velkost,vyroba);
    }
}
