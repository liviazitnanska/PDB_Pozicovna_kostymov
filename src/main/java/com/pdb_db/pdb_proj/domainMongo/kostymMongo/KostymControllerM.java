package com.pdb_db.pdb_proj.domainMongo.kostymMongo;

import com.pdb_db.pdb_proj.domain.kostym.KostymService;
import com.pdb_db.pdb_proj.domainMongo.doplnokMongo.DoplnokM;
import com.pdb_db.pdb_proj.domainMongo.doplnokMongo.DoplnokServiceM;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/kostymM")
@AllArgsConstructor
public class KostymControllerM
{
    private final KostymServiceM kostymServiceM;

    @GetMapping
    public List<KostymM> fetchAllKostym()
    {
        return kostymServiceM.getAllKostymM();
    }
}
