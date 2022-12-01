package com.pdb_db.pdb_proj.domain.doplnok_rezervacia;

import com.pdb_db.pdb_proj.domain.kostym.Kostym;
import com.pdb_db.pdb_proj.domain.kostym_rezervacia.KostymRezervacia;
import com.pdb_db.pdb_proj.domain.rezervacia.Rezervacia;
import com.pdb_db.pdb_proj.dto.DTODoplnokRezervacia;
import com.pdb_db.pdb_proj.dto.DTOKostymRezervacia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/doplnokrezervacia")
public class DoplnokRezervaciaController
{

    private final DoplnokRezervaciaService doplnokRezervaciaService;

    @Autowired
    public DoplnokRezervaciaController(DoplnokRezervaciaService doplnokRezervaciaService) {
        this.doplnokRezervaciaService = doplnokRezervaciaService;
    }

    @GetMapping
    public List<DoplnokRezervacia> getDoplnokRezervacie()
    {
        return doplnokRezervaciaService.getDoplnokRezervacie();
    }

    /*@PostMapping
    public void registerNewDoplnokRezervacia(@RequestBody DoplnokRezervacia doplnokRezervacia)
    {
        doplnokRezervaciaService.addNewDoplnokRezervacia(doplnokRezervacia);
    }*/

    @PostMapping
    public void registerNewDoplnokRezervacia(@RequestBody DTODoplnokRezervacia dtoDoplnokRezervacia)
    {
        Rezervacia rezervacia = new Rezervacia(dtoDoplnokRezervacia.getCasPozicania(),dtoDoplnokRezervacia.getCasVratenia(),dtoDoplnokRezervacia.getVratenie(),dtoDoplnokRezervacia.getUzivid());
        doplnokRezervaciaService.addNewRezervacia(rezervacia);

        DoplnokRezervacia doplnokRezervacia = new DoplnokRezervacia(dtoDoplnokRezervacia.getUzivid(),dtoDoplnokRezervacia.getDoplnokid(),rezervacia.getId());
        doplnokRezervaciaService.addNewDoplnokRezervacia(doplnokRezervacia);
    }

    @DeleteMapping(path = "{doplnokRezervaciaId}")
    public void deleteDoplnokRezervacia(@PathVariable("doplnokRezervaciaId") Integer doplnokRezervaciaId)
    {
        doplnokRezervaciaService.deleteDoplnokRezervacia(doplnokRezervaciaId);
    }
    @PutMapping(path = "{doplnokRezervaciaId}")
    public void updateDoplnokRezervacia(
            @PathVariable("doplnokRezervaciaId") Integer doplnokRezervaciaId,
            @RequestParam(required = false) Integer uzivid,
            @RequestParam(required = false)Integer doplnokid)
    {
        doplnokRezervaciaService.updateDoplnokRezervacia(doplnokRezervaciaId,uzivid,doplnokid);
    }
}
