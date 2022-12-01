package com.pdb_db.pdb_proj.domain.kostym_rezervacia;

import com.pdb_db.pdb_proj.domain.doplnok.DoplnokService;
import com.pdb_db.pdb_proj.domain.kostym.Kostym;
import com.pdb_db.pdb_proj.domain.rezervacia.Rezervacia;
import com.pdb_db.pdb_proj.dto.DTOKostymRezervacia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path="api/v1/kostymrezervacia")
public class KostymRezervaciaController
{
    private final KostymRezervaciaService kostymRezervaciaService;

    @Autowired
    public KostymRezervaciaController(KostymRezervaciaService kostymRezervaciaService) {
        this.kostymRezervaciaService = kostymRezervaciaService;
    }

    @GetMapping
    public List<KostymRezervacia> getKostymRezervacie()
    {
        return kostymRezervaciaService.getKostymRezervacie();
    }

    /*@PostMapping
    public void registerNewKostymRezervacia(@RequestBody KostymRezervacia kostymRezervacia)
    {
        kostymRezervaciaService.addNewKostymRezervacia(kostymRezervacia);
    }*/
    @PostMapping
    public void registerNewKostymRezervacia
    (
            @RequestBody DTOKostymRezervacia dtoKostymRezervacia
            )
    {
        Rezervacia rezervacia = new Rezervacia(dtoKostymRezervacia.getCasPozicania(),dtoKostymRezervacia.getCasVratenia(),dtoKostymRezervacia.getVratenie(),dtoKostymRezervacia.getUzivid());
        kostymRezervaciaService.addNewRezervacia(rezervacia);

        KostymRezervacia kostymRezervacia = new KostymRezervacia(dtoKostymRezervacia.getUzivid(),dtoKostymRezervacia.getKostymid(),rezervacia.getId());
        kostymRezervaciaService.addNewKostymRezervacia(kostymRezervacia);
    }

    @DeleteMapping(path = "{kostymRezervaciaId}")
    public void deleteKostymRezervacia(@PathVariable("kostymRezervaciaId") Integer kostymRezervaciaId)
    {
        kostymRezervaciaService.deleteKostymRezervacia(kostymRezervaciaId);
    }

    @PutMapping(path = "{kostymRezervaciaId}")
    public void updateKostymRezervacia(
            @PathVariable("kostymRezervaciaId") Integer kostymRezervaciaId,
            @RequestParam(required = false) Integer uzivid,
            @RequestParam(required = false)Integer kostymid)
    {
        kostymRezervaciaService.updateKostymRezervacia(kostymRezervaciaId,uzivid,kostymid);
    }
}
