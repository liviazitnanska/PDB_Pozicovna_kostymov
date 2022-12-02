package com.pdb_db.pdb_proj.domainMongo.rezervaciaMongo;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/rezervaciaM")
@AllArgsConstructor
public class RezervaciaControllerM
{
    private final RezervaciaServiceM rezervaciaServiceM;

    @GetMapping
    public List<RezervaciaM> fetchAllRezervaciaM()
    {
        return rezervaciaServiceM.getAllRezervaciaM();
    }
}
