package com.pdb_db.pdb_proj.domainMongo.recenzia_kostymMongo;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/recenziakostymM")
@AllArgsConstructor
public class RecenziaKostymControllerM
{
    private final RecenziaKostymServiceM recenziaKostymServiceM;

    @GetMapping
    public List<RecenziaKostymM> fetchAllRecenziaKostymM()
    {
        return recenziaKostymServiceM.getAllRecenziaKostymM();
    }
}
