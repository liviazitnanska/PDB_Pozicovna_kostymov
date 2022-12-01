package com.pdb_db.pdb_proj.domainMongo.kostymMongo;

import com.pdb_db.pdb_proj.domainMongo.doplnokMongo.DoplnokRepositoryM;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class KostymServiceM
{
    private final KostymRepositoryM kostymRepositoryM;
    public List<KostymM> getAllKostymM()
    {
        return kostymRepositoryM.findAll();
    }
}
