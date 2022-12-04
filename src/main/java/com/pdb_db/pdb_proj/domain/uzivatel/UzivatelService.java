package com.pdb_db.pdb_proj.domain.uzivatel;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pdb_db.pdb_proj.domain.doplnok_rezervacia.DoplnokRezervacia;
import com.pdb_db.pdb_proj.domain.doplnok_rezervacia.DoplnokRezervaciaRepository;
import com.pdb_db.pdb_proj.domain.doplnok_rezervacia.DoplnokRezervaciaService;
import com.pdb_db.pdb_proj.domain.kostym_rezervacia.KostymRezervacia;
import com.pdb_db.pdb_proj.domain.kostym_rezervacia.KostymRezervaciaRepository;
import com.pdb_db.pdb_proj.domain.kostym_rezervacia.KostymRezervaciaService;
import com.pdb_db.pdb_proj.domain.wishlist_doplnok.WishlistDoplnok;
import com.pdb_db.pdb_proj.domain.wishlist_doplnok.WishlistDoplnokRepository;
import com.pdb_db.pdb_proj.domain.wishlist_doplnok.WishlistDoplnokService;
import com.pdb_db.pdb_proj.domain.wishlist_kostym.WishlistKostym;
import com.pdb_db.pdb_proj.domain.wishlist_kostym.WishlistKostymRepository;
import com.pdb_db.pdb_proj.domain.wishlist_kostym.WishlistKostymService;
import com.pdb_db.pdb_proj.utilities.rest_operationType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UzivatelService {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    private final UzivatelRepository uzivatelRepository;

    // WishlistDoplnok
    private final WishlistDoplnokRepository wishlistDoplnokRepository;
    private final WishlistDoplnokService wishlistDoplnokService;

    // WishlistKostym
    private final WishlistKostymRepository wishlistKostymRepository;
    private final WishlistKostymService wishlistKostymService;

    // DoplnokRezervacia
    private final DoplnokRezervaciaRepository doplnokRezervaciaRepository;
    private final DoplnokRezervaciaService doplnokRezervaciaService;

    // KostymRezervacia
    private final KostymRezervaciaRepository kostymRezervaciaRepository;
    private final KostymRezervaciaService kostymRezervaciaService;


    @Autowired
    public UzivatelService(UzivatelRepository uzivatelRepository,
                           // WishlistDoplnok
                           WishlistDoplnokRepository wishlistDoplnokRepository,
                           WishlistDoplnokService wishlistDoplnokService,
                           // WishlistKostym
                           WishlistKostymRepository wishlistKostymRepository,
                           WishlistKostymService wishlistKostymService,
                           // DoplnokRezervacia
                           DoplnokRezervaciaRepository doplnokRezervaciaRepository,
                           DoplnokRezervaciaService doplnokRezervaciaService,
                           // KostymRezervacia
                           KostymRezervaciaRepository kostymRezervaciaRepository,
                           KostymRezervaciaService kostymRezervaciaService

    ) {
        this.uzivatelRepository = uzivatelRepository;
        // WishlistDoplnok
        this.wishlistDoplnokRepository = wishlistDoplnokRepository;
        this.wishlistDoplnokService = wishlistDoplnokService;
        // WishlistKostym
        this.wishlistKostymRepository = wishlistKostymRepository;
        this.wishlistKostymService = wishlistKostymService;
        // DoplnokRezervacia
        this.doplnokRezervaciaRepository = doplnokRezervaciaRepository;
        this.doplnokRezervaciaService = doplnokRezervaciaService;
        // KostymRezervacia
        this.kostymRezervaciaRepository = kostymRezervaciaRepository;
        this.kostymRezervaciaService = kostymRezervaciaService;

    }

    public List<Uzivatel> getUzivatel() {
        return uzivatelRepository.findAll();
    }


    /*Operacia Vytvorit uzivatela*/
    public void addNewUzivatel(Uzivatel uzivatel)
    {
        //Can't have new user with same email
        Optional<Uzivatel> uzivatelOptional =  uzivatelRepository.findUzivatelByEmail(uzivatel.getEmail());

        if(uzivatelOptional.isPresent())
        {
            throw new IllegalStateException("Uzivatel with this email already exists");
        }

        // Oracle
        uzivatelRepository.save(uzivatel);
        // Kafka -> MongoDB
        uzivatel.setOperation(rest_operationType.POST);
        this.kafka_sendMessage(uzivatel);
    }

    /*Operacia: Zmazat uzivatela*/
    public void deleteUzivatel(Integer id) {
        boolean exists = uzivatelRepository.existsById(id);
        if (!exists){
            throw new IllegalStateException("Unsuccessful DELETE request. Record with id: "+id+" is NOT exists!");
        }

        // Oracle
        uzivatelRepository.deleteById(id);
        // Kafka -> MongoDB
        Uzivatel uzivatel = new Uzivatel(id);
        uzivatel.setOperation(rest_operationType.DELETE);
        this.kafka_sendMessage(uzivatel);

        // Cascade delete all user's doplnok wishes
        List<WishlistDoplnok> wishlistDoplnokList = wishlistDoplnokRepository.findAllWishlistDoplnokByUzivid(id);
        for (WishlistDoplnok wishlistDoplnok : wishlistDoplnokList) {
            wishlistDoplnokService.deleteWishlist(wishlistDoplnok.getId());
        }


        // Cascade delete all user's kostym wishes
        List<WishlistKostym> wishlistKostymList = wishlistKostymRepository.findAllWishlistKostymByUzivid(id);
        for (WishlistKostym wishlistKostym : wishlistKostymList) {
            wishlistKostymService.deleteWishlist(wishlistKostym.getId());
        }

        // Cascade delete all user's doplnok reservations
        List<DoplnokRezervacia> doplnokRezervaciaList = doplnokRezervaciaRepository.findAllDoplnokRezervaciaByUzivid(id);
        for (DoplnokRezervacia doplnokRezervacia : doplnokRezervaciaList){
            doplnokRezervaciaService.deleteDoplnokRezervacia(doplnokRezervacia.getId());
        }

        // Cascade delete all user's kostym reservations
        List<KostymRezervacia> kostymRezervaciaList = kostymRezervaciaRepository.findAllKostymRezervaciaByUzivid(id);
        for (KostymRezervacia kostymRezervacia : kostymRezervaciaList){
            kostymRezervaciaService.deleteKostymRezervacia(kostymRezervacia.getId());
        }

    }

    /*Operacia: Uprava profilu*/
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

        // Kafka -> MongoDB
        uR.setOperation(rest_operationType.PUT);
        this.kafka_sendMessage(uR);
    }

    @Autowired
    private KafkaTemplate<Long, String> kafkaTemplate;

    public void kafka_sendMessage(Uzivatel uzivatel) {
        try {
            String str_uzivatel = OBJECT_MAPPER.writeValueAsString(uzivatel);
            //SOT = Source of truth
            kafkaTemplate.send("uzivatelService_SOT_event", str_uzivatel);
        } catch (Exception e){
            System.out.println("Custom exception error [KafkaSender]: " + e.getMessage());
        }

    }
}
