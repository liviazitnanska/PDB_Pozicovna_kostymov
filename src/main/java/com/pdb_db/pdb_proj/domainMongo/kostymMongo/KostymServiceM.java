package com.pdb_db.pdb_proj.domainMongo.kostymMongo;

import com.pdb_db.pdb_proj.domain.kostym.Kostym;
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

   /* public KostymM getKostym(Integer id) {
        return kostymRepositoryM.findKostymMById(id).get();
    }*/

   /* public List<KostymM> getAllKostymMbyKategoria(String kategoria)
    {

        return kostymRepositoryM.findAllByKategoria(kategoria);
    }*/

   /* public List<KostymM> getAllKostymMByMaterial(String material)
    {
        return kostymRepositoryM.findAllByMaterial(material);
    }*/


}
