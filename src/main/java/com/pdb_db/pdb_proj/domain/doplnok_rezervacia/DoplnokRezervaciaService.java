package com.pdb_db.pdb_proj.domain.doplnok_rezervacia;

import com.pdb_db.pdb_proj.domain.doplnok.Doplnok;
import com.pdb_db.pdb_proj.domain.kostym_rezervacia.KostymRezervacia;
import com.pdb_db.pdb_proj.domain.rezervacia.Rezervacia;
import com.pdb_db.pdb_proj.domain.rezervacia.RezervaciaRepository;
import com.pdb_db.pdb_proj.domain.uzivatel.Uzivatel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class DoplnokRezervaciaService
{
    private final DoplnokRezervaciaRepository doplnokRezervaciaRepository;
    private final RezervaciaRepository rezervaciaRepository;

    @Autowired
    public DoplnokRezervaciaService(DoplnokRezervaciaRepository doplnokRezervaciaRepository, RezervaciaRepository rezervaciaRepository) {
        this.doplnokRezervaciaRepository = doplnokRezervaciaRepository;
        this.rezervaciaRepository = rezervaciaRepository;
    }

    public List<DoplnokRezervacia> getDoplnokRezervacie()
    {
        return doplnokRezervaciaRepository.findAll();
    }

   /* public void addNewDoplnokRezervacia(DoplnokRezervacia doplnokRezervacia) {
        System.out.println(doplnokRezervacia);
        doplnokRezervaciaRepository.save(doplnokRezervacia);
    }*/

    public void addNewDoplnokRezervacia(DoplnokRezervacia doplnokRezervacia)
    {
        //Check user
        Optional<Uzivatel> uzivatelOptional = doplnokRezervaciaRepository.findUzivatelById(doplnokRezervacia.getUzivid());
        if(!uzivatelOptional.isPresent())
        {
            throw new IllegalStateException("Can not create doplnok reservation to non existent user");
        }

        //Check doplnok
        Optional<Doplnok> doplnokOptional = doplnokRezervaciaRepository.findDoplnokById(doplnokRezervacia.getDoplnokid());
        if(!doplnokOptional.isPresent())
        {
            throw new IllegalStateException("Can not create costume reservation for non existent costume");
        }

        doplnokRezervaciaRepository.save(doplnokRezervacia);

    }
    public void addNewRezervacia(Rezervacia rezervacia)
    {
        //Check user
        Optional<Uzivatel> uzivatelOptional = rezervaciaRepository.findUzivatelById(rezervacia.getUzivid());
        if(!uzivatelOptional.isPresent())
        {
            throw new IllegalStateException("Can not create doplnok reservation to non existent user");
        }

        rezervaciaRepository.save(rezervacia);
    }

    public void deleteDoplnokRezervacia(Integer doplnokRezervaciaId)
    {
        boolean exists = doplnokRezervaciaRepository.existsById(doplnokRezervaciaId);

        if (!exists)
        {
            throw new IllegalStateException("DoplnokRezervacia with this ID "+doplnokRezervaciaId+" does not exist");
        }
        else
        {
            Optional<DoplnokRezervacia> doplnokRezervaciaOptional = doplnokRezervaciaRepository.findById(doplnokRezervaciaId);
            if(!doplnokRezervaciaOptional.isPresent())
            {
                throw new IllegalStateException("Can not delete reservation");
            }
            else
            {
                rezervaciaRepository.deleteById(doplnokRezervaciaOptional.get().getRezervaciaid());
            }
        }
        doplnokRezervaciaRepository.deleteById(doplnokRezervaciaId);
    }
    @Transactional
    public void updateDoplnokRezervacia(Integer doplnokRezervaciaId, Integer uzivid, Integer doplnokid)
    {
        DoplnokRezervacia doplnokRezervacia = doplnokRezervaciaRepository.findById(doplnokRezervaciaId)
                .orElseThrow(() -> new IllegalStateException("DoplnokRezervacia with ID "+doplnokRezervaciaId+"does not exist"));

        if (uzivid != null)
        {
            doplnokRezervacia.setUzivid(uzivid);
        }
        if (doplnokid != null)
        {
            doplnokRezervacia.setDoplnokid(doplnokid);
        }
    }


}
