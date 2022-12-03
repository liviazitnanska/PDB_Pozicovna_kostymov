package com.pdb_db.pdb_proj.domain.uzivatel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/uzivatel")
public class UzivatelControler {

    private final UzivatelService uzivatelService;

    @Autowired
    public UzivatelControler(UzivatelService uzivatelService) {
        this.uzivatelService = uzivatelService;
    }

    @GetMapping
    public List<Uzivatel> getUzivatel(){
        return uzivatelService.getUzivatel();
    }

    @PostMapping
    public void registerNewUzivatel(@RequestBody Uzivatel uzivatel){
        uzivatelService.addNewUzivatel(uzivatel);
    }

    @DeleteMapping(path = "{id}")
    public void deleteUzivatel(@PathVariable("id") Integer id){
        uzivatelService.deleteUzivatel(id);
    }

    @PutMapping(path = "{id}")
    public void updateUzivatel(
            @PathVariable("id") Integer id,
            @RequestParam(required = false) String meno,
            @RequestParam(required = false) String priezvisko,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String telefon,
            @RequestParam(required = false) String stat,
            @RequestParam(required = false) String mesto,
            @RequestParam(required = false) String ulica,
            @RequestParam(required = false) Integer cislodomu,
            @RequestParam(required = false) Integer psc
    ){
        uzivatelService.updateUzivatel(id, meno, priezvisko, email, telefon, stat, mesto, ulica, cislodomu, psc);
    }



}
