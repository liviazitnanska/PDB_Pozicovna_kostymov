package com.pdb_db.pdb_proj.domain.uzivatel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UzivatelService {

    private final UzivatelRepository uzivatelRepository;

    @Autowired
    public UzivatelService(UzivatelRepository uzivatelRepository) {
        this.uzivatelRepository = uzivatelRepository;
    }

    public List<Uzivatel> getUzivatel() {
        return uzivatelRepository.findAll();
    }


    public void addNewUzivatel(Uzivatel uzivatel) {
        uzivatelRepository.save(uzivatel);
    }

    public void deleteUzivatel(Integer id) {
        boolean exists = uzivatelRepository.existsById(id);
        if (!exists){
            throw new IllegalStateException("Unsuccessful DELETE request. Record with id: "+id+" is NOT exists!");
        }
        uzivatelRepository.deleteById(id);
    }

    @Transactional
    public void updateUzivatel(Integer id,
                               String meno,
                               String priezvisko,
                               String email,
                               String telefon,
                               String stat,
                               String mesto,
                               String ulica,
                               Integer cislodomu,
                               Integer psc ) {
        Uzivatel uR = uzivatelRepository.findById(id
        ).orElseThrow(() ->
                new IllegalStateException("Unsuccessful UPDATE request. Record with id: "+id+" is NOT exists!"));

        uR.setId(id);
        if (meno != null && meno.length() > 0){
            uR.setMeno(meno);
        }
        if (priezvisko != null && priezvisko.length() > 0){
            uR.setPriezvisko(priezvisko);
        }
        if (email != null && email.length() > 0){
            uR.setEmail(email);
        }
        if (telefon != null && telefon.length() > 0){
            uR.setTelefon(telefon);
        }
        if (stat != null && stat.length() > 0){
            uR.setStat(stat);
        }
        if (mesto != null && mesto.length() > 0){
            uR.setMesto(mesto);
        }
        if (ulica != null && ulica.length() > 0){
            uR.setUlica(ulica);
        }
        if (cislodomu != null){
            uR.setCislodomu(cislodomu);
        }
        if (psc != null){
            uR.setPsc(psc);
        }
    }

}
