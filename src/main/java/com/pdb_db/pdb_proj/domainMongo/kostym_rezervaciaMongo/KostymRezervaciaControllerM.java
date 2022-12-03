package com.pdb_db.pdb_proj.domainMongo.kostym_rezervaciaMongo;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/kostymrezervaciaM")
@AllArgsConstructor
public class KostymRezervaciaControllerM {

    private final KostymRezervaciaServiceM kostymRezervaciaServiceM;

    @GetMapping
    public List<KostymRezervaciaM> fetchAllKostymRezervaciaM()
    {
        return kostymRezervaciaServiceM.getAllKostymRezervaciaM();
    }
}
