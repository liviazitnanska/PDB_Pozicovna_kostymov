package com.pdb_db.pdb_proj.domain.kostym;

import com.pdb_db.pdb_proj.domain.doplnok.Doplnok;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
public class KostymService {

    private final KostymRepository kostymRepository;

    @Autowired
    public KostymService(KostymRepository kostymRepository) {
        this.kostymRepository = kostymRepository;
    }

    public List<Kostym> getKostymy()
    {
        return kostymRepository.findAll();
    }

    public Kostym getKostymById(Integer id)
    {
        Optional <Kostym> optionalKostym = kostymRepository.findById(id);
        if (!optionalKostym.isPresent())
        {
            throw new IllegalStateException("This Costume does not exist");
        }
        return optionalKostym.get();
    }

    public Optional<Kostym> getKostymByNazov(String nazov)
    {
        Optional <Kostym> optionalKostym = kostymRepository.findKostymByNazov(nazov);
        if (!optionalKostym.isPresent())
        {
            throw new IllegalStateException("This Costume does not exist");
        }
        return optionalKostym;
    }

    public List<Kostym> get_Kostymy_by_material(String material)
    {
        return  kostymRepository.findAllByMaterial(material);
    }

    public void addNewKostym(Kostym kostym)
    {
        //System.out.println(kostym);
        Optional<Kostym> kostymOptional =  kostymRepository.findKostymByNazov(kostym.getNazov());

        //Make sure there is not a costume with a same name
        if(kostymOptional.isPresent())
        {
            throw new IllegalStateException("Kostym already exists");
        }
        kostymRepository.save(kostym);
    }

    public void deleteKostym(Integer kostymId)
    {
        boolean exists = kostymRepository.existsById(kostymId);

        if (!exists)
        {
            throw new IllegalStateException("Kostym with this ID "+kostymId+" does not exist");
        }
        kostymRepository.deleteById(kostymId);
    }

    @Transactional
    public void updateKostym(Integer kostymId, String nazov, String popis, String material, String kategoria, Integer velkost, Date vyroba)
    {
        Kostym kostym = kostymRepository.findById(kostymId)
                .orElseThrow(() -> new IllegalStateException("Kostym with ID "+kostymId+"does not exist"));

        if (nazov != null && nazov.length() > 0)
        {
            //Nazov cant be shared with two different objects
            Optional<Kostym> kostymOptional = kostymRepository.findKostymByNazov(nazov);
            if(kostymOptional.isPresent())
            {
                throw new IllegalStateException("Nazov of Kostym taken");
            }
            kostym.setNazov(nazov);
        }
        if (popis != null && popis.length() > 0)
        {
            kostym.setPopis(popis);
        }
        if (material != null && material.length() > 0)
        {
            kostym.setMaterial(material);
        }
        if (kategoria != null && kategoria.length() > 0)
        {
            kostym.setKategoria(kategoria);
        }
        if (velkost!= null )
        {
            kostym.setVelkost(velkost);
        }
        if (vyroba != null) //TODO mozno nieco pridat??
        {
            kostym.setVyroba(vyroba);
        }
    }
}
