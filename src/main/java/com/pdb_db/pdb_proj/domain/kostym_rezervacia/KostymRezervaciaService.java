package com.pdb_db.pdb_proj.domain.kostym_rezervacia;

import com.pdb_db.pdb_proj.domain.doplnok_rezervacia.DoplnokRezervacia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
public class KostymRezervaciaService {

    private final KostymRezervaciaRepository kostymRezervaciaRepository;

    @Autowired
    public KostymRezervaciaService(KostymRezervaciaRepository kostymRezervaciaRepository) {
        this.kostymRezervaciaRepository = kostymRezervaciaRepository;
    }

    public List<KostymRezervacia> getKostymRezervacie()
    {
        return kostymRezervaciaRepository.findAll();
    }

    public void addNewKostymRezervacia(KostymRezervacia kostymRezervacia)
    {
        System.out.println(kostymRezervacia);
        kostymRezervaciaRepository.save(kostymRezervacia);
    }

    public void deleteKostymRezervacia(Integer kostymRezervaciaId) {

        boolean exists = kostymRezervaciaRepository.existsById(kostymRezervaciaId);

        if (!exists)
        {
            throw new IllegalStateException("KostymRezervacia with this ID "+kostymRezervaciaId+" does not exist");
        }
        kostymRezervaciaRepository.deleteById(kostymRezervaciaId);
    }

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
