package com.pdb_db.pdb_proj.domain.rezervacia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/rezervacia")
public class RezervaciaControler {


    private final RezervaciaService rezervaciaService;

    @Autowired
    public RezervaciaControler(RezervaciaService rezervaciaService){
        this.rezervaciaService = rezervaciaService;
    }

    @GetMapping
    public List<Rezervacia> getRezervacia(){
        return rezervaciaService.getRezervacia();
    }

    @PostMapping
    public void registerNewRezervacia(@RequestBody Rezervacia rezervacia)
    {

        rezervaciaService.addNewRezervacia(rezervacia);
    }

    @DeleteMapping(path = "{id}")
    public void deleteRezervacia(@PathVariable("id") Integer id){
        rezervaciaService.deleteRezervacia(id);
    }

    @PutMapping(path = "{id}")
    public void updateRezervacia(
            @PathVariable("id") Integer id,
            //TODO post na cas nefunguje
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Date casPozicania,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Date casVratenia,
            @RequestParam(required = false) Integer vratenie,
            @RequestParam(required = false) Integer uzivid
    ){
        rezervaciaService.updateRezervacia(id, casPozicania, casVratenia, vratenie, uzivid);
    }


}
