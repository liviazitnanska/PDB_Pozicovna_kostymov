package com.pdb_db.pdb_proj.domain.recenzia_doplnok;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/recenzia_doplnok")
public class RecenziaDoplnokControler {

    private final RecenziaDoplnokService recenziaDoplnokService;

    @Autowired
    public RecenziaDoplnokControler(RecenziaDoplnokService recenziaDoplnokService){
        this.recenziaDoplnokService = recenziaDoplnokService;
    }

    @GetMapping
    public List<RecenziaDoplnok> getRecenziaDoplnok(){
        return recenziaDoplnokService.getRecenziaDoplnok();
    }

    @PostMapping
    public void registerNewRecenziaDoplnok(@RequestBody RecenziaDoplnok recenziaDoplnok){
        recenziaDoplnokService.addNewRecenziaDoplnok(recenziaDoplnok);
    }

    @DeleteMapping(path = "{id}")
    public void deleteRecenziaDoplnok(@PathVariable("id") Integer id){
        recenziaDoplnokService.deleteRecenziaDoplnok(id);
    }

    @PutMapping(path = "{id}")
    public void updateRecenziaDoplnok(
        @PathVariable("id") Integer id,
        @RequestParam(required = false) String nazov,
        @RequestParam(required = false) String popis,
        @RequestParam(required = false) Integer suhlas,
        @RequestParam(required = false) Integer nesuhlas,
        @RequestParam(required = false) Integer uzivid,
        @RequestParam(required = false) Integer doplnokid
    ){
        recenziaDoplnokService.updateRecenziaDoplnok(id, nazov, popis, suhlas, nesuhlas, uzivid, doplnokid);
    }

}
