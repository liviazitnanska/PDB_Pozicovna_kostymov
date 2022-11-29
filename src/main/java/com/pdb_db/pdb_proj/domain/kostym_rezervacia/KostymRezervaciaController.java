package com.pdb_db.pdb_proj.domain.kostym_rezervacia;

import com.pdb_db.pdb_proj.domain.doplnok.DoplnokService;
import com.pdb_db.pdb_proj.domain.kostym.Kostym;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public void registerNewKostymRezervacia(@RequestBody KostymRezervacia kostymRezervacia)
    {
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
