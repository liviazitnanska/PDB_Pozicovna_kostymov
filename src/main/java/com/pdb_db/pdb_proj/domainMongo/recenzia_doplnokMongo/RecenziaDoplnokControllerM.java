package com.pdb_db.pdb_proj.domainMongo.recenzia_doplnokMongo;

import com.pdb_db.pdb_proj.domain.recenzia_doplnok.RecenziaDoplnok;
import com.pdb_db.pdb_proj.domainMongo.doplnokMongo.DoplnokM;
import com.pdb_db.pdb_proj.domainMongo.doplnokMongo.DoplnokServiceM;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/recenziadoplnokM")
@AllArgsConstructor
public class RecenziaDoplnokControllerM
{
    private final RecenziaDoplnokServiceM recenziaDoplnokServiceM;

    @GetMapping
    public List<RecenziaDoplnokM> fetchAllRecenziaDoplnokM()
    {
        return recenziaDoplnokServiceM.getAllRecenziaDoplnokM();
    }
}
