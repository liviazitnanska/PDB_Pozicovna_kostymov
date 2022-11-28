package com.pdb_db.pdb_proj.domain.recenzia_doplnok;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/recenzia_doplnok")
public class RecenziaDoplnokControler {

    private final RecenziaDoplnokService recenziaDoplnokService;

    @Autowired
    public RecenziaDoplnokControler(RecenziaDoplnokService recenziaDoplnokService){
        this.recenziaDoplnokService = recenziaDoplnokService;
    }

    @GetMapping
    public List<RecenziaDoplnok> getRecenziaDoplnok(){
        return recenziaDoplnokService.getRecenziaDoplnok();
    }

}
