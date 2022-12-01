package com.pdb_db.pdb_proj.domain.doplnok;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/doplnok")
public class DoplnokController
{
    private final DoplnokService doplnokService;

    @Autowired
    public DoplnokController(DoplnokService doplnokService) {
        this.doplnokService = doplnokService;
    }

    @GetMapping
    public List<Doplnok> getDoplnky()
    {
        return doplnokService.getDoplnky();
    }

    @PostMapping
    public void registerNewDoplnok(@RequestBody Doplnok doplnok)
    {
        doplnokService.addNewDoplnok(doplnok);
    }
   /* @PostMapping
    public void pokus(@RequestParam(value = "s") String s)
    {
        System.out.println(s);
    }*/

    @DeleteMapping(path = "{doplnokId}")
    public void deleteDoplnok(@PathVariable("doplnokId") Integer doplnokId)
    {
        doplnokService.deleteDoplnok(doplnokId);
    }

    @PutMapping(path = "{doplnokId}")
    public void updateDoplnok(
            @PathVariable("doplnokId") Integer doplnokId,
            @RequestParam(required = false) String nazov,
            @RequestParam(required = false) String popis,
            @RequestParam(required = false) String material,
            @RequestParam(required = false) String kategoria,
            @RequestParam(required = false) java.sql.Date vyroba)
    {
        doplnokService.updateDoplnok(doplnokId,nazov,popis,material,kategoria,vyroba);
    }
}
