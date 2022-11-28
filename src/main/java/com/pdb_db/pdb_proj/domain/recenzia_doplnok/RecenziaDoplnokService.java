package com.pdb_db.pdb_proj.domain.recenzia_doplnok;


import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecenziaDoplnokService {


    public List<RecenziaDoplnok> getRecenziaDoplnok() {
        return List.of(
                new RecenziaDoplnok("Rec4", "Super", 1,0)
        );

    }
}
