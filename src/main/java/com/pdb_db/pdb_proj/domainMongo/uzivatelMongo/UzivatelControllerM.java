package com.pdb_db.pdb_proj.domainMongo.uzivatelMongo;

import com.pdb_db.pdb_proj.domainMongo.doplnokMongo.DoplnokM;
import com.pdb_db.pdb_proj.domainMongo.doplnokMongo.DoplnokServiceM;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
