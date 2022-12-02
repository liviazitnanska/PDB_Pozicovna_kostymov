package com.pdb_db.pdb_proj.domainMongo.doplnokMongo;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/doplnokM")
@AllArgsConstructor
public class DoplnokControllerM {

    private final DoplnokServiceM doplnokServiceM;

    @GetMapping
    public List<DoplnokM> fetchAllDoplnokM()
    {
        return doplnokServiceM.getAllDoplnokM();
    }

}
