package com.pdb_db.pdb_proj.domain.doplnok_rezervacia;

import com.pdb_db.pdb_proj.domain.doplnok.Doplnok;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class DoplnokRezervaciaService
{
    private final DoplnokRezervaciaRepository doplnokRezervaciaRepository;

    @Autowired
    public DoplnokRezervaciaService(DoplnokRezervaciaRepository doplnokRezervaciaRepository) {
        this.doplnokRezervaciaRepository = doplnokRezervaciaRepository;
    }

    public List<DoplnokRezervacia> getDoplnokRezervacie()
    {
        return doplnokRezervaciaRepository.findAll();
    }

    public void addNewDoplnokRezervacia(DoplnokRezervacia doplnokRezervacia) {
        System.out.println(doplnokRezervacia);
        doplnokRezervaciaRepository.save(doplnokRezervacia);
    }

    public void deleteDoplnokRezervacia(Integer doplnokRezervaciaId)
    {
        boolean exists = doplnokRezervaciaRepository.existsById(doplnokRezervaciaId);

        if (!exists)
        {
            throw new IllegalStateException("DoplnokRezervacia with this ID "+doplnokRezervaciaId+" does not exist");
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
