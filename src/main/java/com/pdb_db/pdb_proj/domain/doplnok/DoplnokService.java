package com.pdb_db.pdb_proj.domain.doplnok;

import com.pdb_db.pdb_proj.domain.kostym.Kostym;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
public class DoplnokService {

    private final DoplnokRepository doplnokRepository;

    @Autowired
    public DoplnokService(DoplnokRepository doplnokRepository) {
        this.doplnokRepository = doplnokRepository;
    }

    public List<Doplnok> getDoplnky()
    {
        return doplnokRepository.findAll();
    }


    public List<Doplnok> get_Doplnky_by_material(String material)
    {
        return  doplnokRepository.findAllByMaterial(material);
    }

    public Optional<Doplnok> getDoplnokById(Integer id)
    {
        return doplnokRepository.findById(id);
    }

    public Optional<Doplnok> getDoplnokByNazov(String nazov)
    {
        return doplnokRepository.findDoplnokByNazov(nazov);
    }


    public void addNewDoplnok(Doplnok doplnok)
    {
    //System.out.println(doplnok);
        Optional<Doplnok> doplnokOptional =  doplnokRepository.findDoplnokByNazov(doplnok.getNazov());

        //Make sure there is not a costume with a same name
        if(doplnokOptional.isPresent())
        {
            throw new IllegalStateException("Doplnok already exists");
        }
        doplnokRepository.save(doplnok);
    }

    public void deleteDoplnok(Integer doplnokId)
    {
        boolean exists = doplnokRepository.existsById(doplnokId);

        if (!exists)
        {
            throw new IllegalStateException("Doplnok with this ID "+doplnokId+" does not exist");
        }
        doplnokRepository.deleteById(doplnokId);
    }

    @Transactional
    public void updateDoplnok(Integer doplnokId, String nazov, String popis, String material, String kategoria, Date vyroba)
    {
        Doplnok doplnok = doplnokRepository.findById(doplnokId)
            .orElseThrow(() -> new IllegalStateException("Doplnok with ID "+doplnokId+"does not exist"));

        if (nazov != null && nazov.length() > 0
                //&& !Object.equals(doplnok.getNazov(),nazov)
        )
        {
           //Nazov cant be shared with two different objects
            Optional<Doplnok> doplnokOptional = doplnokRepository.findDoplnokByNazov(nazov);
            if(doplnokOptional.isPresent())
            {
                throw new IllegalStateException("Nazov of Doplnok taken");
            }
            doplnok.setNazov(nazov);
        }
        if (popis != null && popis.length() > 0)
        {
            doplnok.setPopis(popis);
        }
        if (material != null && material.length() > 0)
        {
            doplnok.setMaterial(material);
        }
        if (kategoria != null && kategoria.length() > 0)
        {
            doplnok.setKategoria(kategoria);
        }
        if (vyroba != null) //TODO mozno nieco pridat??
        {
            doplnok.setVyroba(vyroba);
        }
    }
}
