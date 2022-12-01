package com.pdb_db.pdb_proj.domain.recenzia_doplnok;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class RecenziaDoplnokService {

    private final RecenziaDoplnokRepository recenziaDoplnokRepository;

    @Autowired
    public RecenziaDoplnokService(RecenziaDoplnokRepository recenziaDoplnokRepository) {
        this.recenziaDoplnokRepository = recenziaDoplnokRepository;
    }


    public List<RecenziaDoplnok> getRecenziaDoplnok() {
        return recenziaDoplnokRepository.findAll();
    }


    public void addNewRecenziaDoplnok(RecenziaDoplnok recenziaDoplnok) {
        recenziaDoplnokRepository.save(recenziaDoplnok);
    }

    public void deleteRecenziaDoplnok(Integer id) {
        boolean exists = recenziaDoplnokRepository.existsById(id);
        if (!exists){
            throw new IllegalStateException("Unsuccessful DELETE request. Record with id: "+id+" is NOT exists!");
        }
        recenziaDoplnokRepository.deleteById(id);
    }

    @Transactional
    public void updateRecenziaDoplnok(Integer id, String nazov, String popis, Integer suhlas, Integer nesuhlas, Integer uzivid, Integer doplnokid) {
        RecenziaDoplnok rdR = recenziaDoplnokRepository.findById(id
        ).orElseThrow(() ->
                new IllegalStateException("Unsuccessful UPDATE request. Record with id: "+id+" is NOT exists!"));

        rdR.setId(id);
        if (nazov != null && nazov.length() > 0){
            rdR.setNazov(nazov);
        }
        if (popis != null && popis.length() > 0){
            rdR.setPopis(popis);
        }
        if (suhlas != null && suhlas >= 0){
            rdR.setSuhlas(suhlas);
        }
        if (nesuhlas != null && nesuhlas >= 0){
            rdR.setNesuhlas(nesuhlas);
        }
        if (uzivid != null){
            rdR.setUzivid(uzivid);
        }
        if (doplnokid != null){
            rdR.setDoplnokid(doplnokid);
        }
    }
}
