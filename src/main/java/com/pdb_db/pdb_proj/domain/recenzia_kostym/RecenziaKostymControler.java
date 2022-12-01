package com.pdb_db.pdb_proj.domain.recenzia_kostym;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/recenzia_kostym")
public class RecenziaKostymControler {

    private final RecenziaKostymService recenziaKostymService;

    @Autowired
    public RecenziaKostymControler(RecenziaKostymService recenziaKostymService){
        this.recenziaKostymService = recenziaKostymService;
    }

    @GetMapping
    public List<RecenziaKostym> getRecenziaKostym(){
        return recenziaKostymService.getRecenziaKostym();
    }

    @PostMapping
    public void registerNewRecenziaKostym(@RequestBody RecenziaKostym recenziaKostym){
        recenziaKostymService.addNewRecenziaKostym(recenziaKostym);
    }

    @DeleteMapping(path = "{id}")
    public void deleteRecenziaKostym(@PathVariable("id") Integer id){
        recenziaKostymService.deleteRecenziaKostym(id);
    }

    @PutMapping(path = "{id}")
    public void updateRecenziaKostym(
            @PathVariable("id") Integer id,
            @RequestParam(required = false) String nazov,
            @RequestParam(required = false) String popis,
            @RequestParam(required = false) Integer suhlas,
            @RequestParam(required = false) Integer nesuhlas,
            @RequestParam(required = false) Integer uzivid,
            @RequestParam(required = false) Integer kostymid
    ){
        recenziaKostymService.updateRecenziaKostym(id, nazov, popis, suhlas, nesuhlas, uzivid, kostymid);
    }

}
