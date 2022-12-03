package com.pdb_db.pdb_proj.domainMongo.uzivatelMongo;

import com.pdb_db.pdb_proj.domain.uzivatel.Uzivatel;
import com.pdb_db.pdb_proj.domainMongo.doplnokMongo.DoplnokM;
import com.pdb_db.pdb_proj.domainMongo.doplnokMongo.DoplnokServiceM;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/uzivatelM")
@AllArgsConstructor
public class UzivatelControllerM
{
    private final UzivatelServiceM uzivatelServiceM;

    @GetMapping
    public List<UzivatelM> fetchAllUzivatelM()
    {
        return uzivatelServiceM.getAllUzivatelM();
    }
}
