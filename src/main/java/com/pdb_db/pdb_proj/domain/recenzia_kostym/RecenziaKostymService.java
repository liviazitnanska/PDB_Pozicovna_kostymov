package com.pdb_db.pdb_proj.domain.recenzia_kostym;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class RecenziaKostymService {

    private final RecenziaKostymRepository recenziaKostymRepository;

    @Autowired
    public RecenziaKostymService(RecenziaKostymRepository recenziaKostymRepository) {
        this.recenziaKostymRepository = recenziaKostymRepository;
    }


    public List<RecenziaKostym> getRecenziaKostym() {
        return recenziaKostymRepository.findAll();
    }


    public void addNewRecenziaKostym(RecenziaKostym recenziaKostym) {
        recenziaKostymRepository.save(recenziaKostym);
    }

    public void deleteRecenziaKostym(Integer id) {
        boolean exists = recenziaKostymRepository.existsById(id);
        if (!exists){
            throw new IllegalStateException("Unsuccessful DELETE request. Record with id: "+id+" is NOT exists!");
        }
        recenziaKostymRepository.deleteById(id);
    }

    @Transactional
    public void updateRecenziaKostym(Integer id, String nazov, String popis, Integer suhlas, Integer nesuhlas, Integer uzivid, Integer kostymid) {
        RecenziaKostym rkR = recenziaKostymRepository.findById(id
        ).orElseThrow(() ->
                new IllegalStateException("Unsuccessful UPDATE request. Record with id: "+id+" is NOT exists!"));

        rkR.setId(id);
        if (nazov != null && nazov.length() > 0){
            rkR.setNazov(nazov);
        }
        if (popis != null && popis.length() > 0){
            rkR.setPopis(popis);
        }
        if (suhlas != null && suhlas >= 0){
            rkR.setSuhlas(suhlas);
        }
        if (nesuhlas != null && nesuhlas >= 0){
            rkR.setNesuhlas(nesuhlas);
        }
        if (uzivid != null){
            rkR.setUzivid(uzivid);
        }
        if (kostymid != null){
            rkR.setKostymid(kostymid);
        }
    }
}
