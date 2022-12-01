package com.pdb_db.pdb_proj.domain.rezervacia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
public class RezervaciaService {

    private final RezervaciaRepository rezervaciaRepository;


    @Autowired
    public RezervaciaService(RezervaciaRepository rezervaciaRepository) {
        this.rezervaciaRepository = rezervaciaRepository;
    }

    public List<Rezervacia> getRezervacia() {
        return rezervaciaRepository.findAll();
    }


    public void addNewRezervacia(Rezervacia rezervacia) {
        rezervaciaRepository.save(rezervacia);
    }

    public void deleteRezervacia(Integer id) {
        boolean exists = rezervaciaRepository.existsById(id);
        if (!exists){
            throw new IllegalStateException("Unsuccessful DELETE request. Record with id: "+id+" is NOT exists!");
        }
        rezervaciaRepository.deleteById(id);
    }

    @Transactional
    public void updateRezervacia(Integer id, LocalDate casPozicania, LocalDate casVratenia, Integer vratenie, Integer uzivid) {
        Rezervacia rR = rezervaciaRepository.findById(id
        ).orElseThrow(() ->
                new IllegalStateException("Unsuccessful UPDATE request. Record with id: "+id+" is NOT exists!"));

        rR.setId(id);
        if (casPozicania != null){
            rR.setCasPozicania(casPozicania);
        }
        if (casVratenia != null){
            rR.setCasVratenia(casVratenia);
        }
        if (vratenie != null && (vratenie == 0 || vratenie == 1)) {
            rR.setVratenie(vratenie);
        }
        if (uzivid != null){
            rR.setUzivid(uzivid);
        }
    }

}
