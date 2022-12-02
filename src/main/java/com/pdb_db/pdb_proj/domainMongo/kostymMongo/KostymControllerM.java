package com.pdb_db.pdb_proj.domainMongo.kostymMongo;

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

// KostymM fetchKostym(Integer kostymid){return kostymServiceM.getKostym(kostymid); }
}
