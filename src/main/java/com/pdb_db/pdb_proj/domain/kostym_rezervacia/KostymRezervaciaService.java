package com.pdb_db.pdb_proj.domain.kostym_rezervacia;

import com.pdb_db.pdb_proj.domain.kostym.Kostym;
import com.pdb_db.pdb_proj.domain.rezervacia.Rezervacia;
import com.pdb_db.pdb_proj.domain.rezervacia.RezervaciaRepository;
import com.pdb_db.pdb_proj.domain.uzivatel.Uzivatel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class KostymRezervaciaService {

    private final KostymRezervaciaRepository kostymRezervaciaRepository;
    private final RezervaciaRepository rezervaciaRepository;

    @Autowired
    public KostymRezervaciaService(KostymRezervaciaRepository kostymRezervaciaRepository, RezervaciaRepository rezervaciaRepository) {
        this.kostymRezervaciaRepository = kostymRezervaciaRepository;
        this.rezervaciaRepository = rezervaciaRepository;
    }

    public List<KostymRezervacia> getKostymRezervacie()
    {
        return kostymRezervaciaRepository.findAll();
    }

    /*public void addNewKostymRezervacia(KostymRezervacia kostymRezervacia)
    {
        kostymRezervaciaRepository.save(kostymRezervacia);
    }*/

    public void addNewKostymRezervacia(KostymRezervacia kostymRezervacia)
    {
        //Check user
        Optional<Uzivatel> uzivatelOptional = kostymRezervaciaRepository.findUzivatelById(kostymRezervacia.getUzivid());
        if(!uzivatelOptional.isPresent())
        {
            throw new IllegalStateException("Can not create costume reservation to non existent user");
        }

        //Check costume
        Optional<Kostym> kostymOptional = kostymRezervaciaRepository.findKostymById(kostymRezervacia.getKostymid());
        if(!kostymOptional.isPresent())
        {
            throw new IllegalStateException("Can not create costume reservation for non existent costume");
        }

        kostymRezervaciaRepository.save(kostymRezervacia);
    }

    public void addNewRezervacia(Rezervacia rezervacia)
    {
        //Check user
        Optional<Uzivatel> uzivatelOptional = rezervaciaRepository.findUzivatelById(rezervacia.getUzivid());

        if(!uzivatelOptional.isPresent())
        {
            throw new IllegalStateException("Can not create costume reservation to non existent user");
        }
        rezervaciaRepository.save(rezervacia);
    }




    public void deleteKostymRezervacia(Integer kostymRezervaciaId) {

        boolean exists = kostymRezervaciaRepository.existsById(kostymRezervaciaId);

        if (!exists)
        {
            throw new IllegalStateException("KostymRezervacia with this ID "+kostymRezervaciaId+" does not exist");
        }
        else
        {
            Optional<KostymRezervacia> kostymRezervaciaOptional = kostymRezervaciaRepository.findById(kostymRezervaciaId);

            if(!kostymRezervaciaOptional.isPresent())
            {
                throw new IllegalStateException("Can not delete reservation");
            }
            else
            {
                rezervaciaRepository.deleteById(kostymRezervaciaOptional.get().getRezervaciaid());
            }
        }
        kostymRezervaciaRepository.deleteById(kostymRezervaciaId);
    }

   /* public void deleteKostymRezervacia(Integer kostymRezervaciaId) {

        boolean exists = kostymRezervaciaRepository.existsById(kostymRezervaciaId);

        if (!exists)
        {
            throw new IllegalStateException("KostymRezervacia with this ID "+kostymRezervaciaId+" does not exist");
        }
                kostymRezervaciaRepository.deleteById(kostymRezervaciaId);
    }*/

    @Transactional
    public void updateKostymRezervacia(Integer kostymRezervaciaId, Integer uzivid, Integer kostymid)
    {
        KostymRezervacia kostymRezervacia = kostymRezervaciaRepository.findById(kostymRezervaciaId)
                .orElseThrow(() -> new IllegalStateException("KostymRezervacia with ID "+kostymRezervaciaId+"does not exist"));

        if (uzivid != null)
        {
            kostymRezervacia.setUzivid(uzivid);
        }
        if (kostymid != null)
        {
            kostymRezervacia.setKostymid(kostymid);
        }
    }
}
