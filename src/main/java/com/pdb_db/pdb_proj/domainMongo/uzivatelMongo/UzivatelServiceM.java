package com.pdb_db.pdb_proj.domainMongo.uzivatelMongo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pdb_db.pdb_proj.domain.uzivatel.Uzivatel;
import lombok.AllArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class UzivatelServiceM
{
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    private final UzivatelRepositoryM uzivatelRepositoryM;
    public List<UzivatelM> getAllUzivatelM()
    {
        return uzivatelRepositoryM.findAll();
    }

    @KafkaListener(topics = "uzivatelService_SOT_event", groupId = "group-id")
    public void kafka_receiveMessage(String message) {
        try {
            Uzivatel uzivatel = OBJECT_MAPPER.readValue(message, Uzivatel.class);

            // REST operation
            switch (uzivatel.getOperation()){
                case PUT -> {
                    //Get uzivatel (oracleDB) id
                    Integer id = uzivatel.getId();

                    //Find object by uzivatel (oracleDB) id in mongoDB
                    UzivatelM uzivatelM = uzivatelRepositoryM.findById(id
                    ).orElseThrow(() ->
                            new IllegalStateException("Unsuccessful UPDATE request in MongoDB. Record with id: "+id+" is NOT exists!"));

                    // Change mongoDB object properties
                    uzivatelM.setMeno(uzivatel.getMeno());
                    uzivatelM.setPriezvisko(uzivatel.getPriezvisko());
                    uzivatelM.setEmail(uzivatel.getEmail());
                    uzivatelM.setTelefon(uzivatel.getTelefon());
                    uzivatelM.setStat(uzivatel.getStat());
                    uzivatelM.setMesto(uzivatel.getMesto());
                    uzivatelM.setUlica(uzivatel.getUlica());
                    uzivatelM.setCislodomu(uzivatel.getCislodomu());
                    uzivatelM.setPsc(uzivatel.getPsc());

                    // Save mongoDB object
                    uzivatelRepositoryM.save(uzivatelM);
                    break;
                }
                case GET -> {
                    break;
                }
                case POST -> {
                    // Create object and init properties
                    UzivatelM uzivatelM = new UzivatelM(
                            uzivatel.getId(),
                            uzivatel.getMeno(),
                            uzivatel.getPriezvisko(),
                            uzivatel.getEmail(),
                            uzivatel.getTelefon(),
                            uzivatel.getStat(),
                            uzivatel.getMesto(),
                            uzivatel.getUlica(),
                            uzivatel.getCislodomu(),
                            uzivatel.getPsc()
                    );
                    // Save object to MongoDB
                    uzivatelRepositoryM.save(uzivatelM);
                    break;
                }
                case DELETE -> {
                    // Create object and init id
                    UzivatelM uzivatelM = new UzivatelM(
                            uzivatel.getId()
                    );
                    // Delete object in MongoDB
                    uzivatelRepositoryM.delete(uzivatelM);
                    break;
                }
            }

        } catch (Exception e){
            System.out.println("Custom exception error [KafkaListener] " + e.getMessage());
        }
    }

/*
    public UzivatelM getUzivatelMById(Integer id)
    {
        return uzivatelRepositoryM.findUzivatelMById(id).get();
    }

    public UzivatelM getUzivatelByAdresa(Integer cislodomu,
                                          String mesto,
                                          String stat,
                                          String ulica,
                                          Integer psc)
    {
        return uzivatelRepositoryM.findUzivatelMByByCislodomuAndMestoAndStatAndUlicaAndPsc(cislodomu, mesto, stat, ulica, psc);
    }

    public List<UzivatelM> getAllUzivatelbyAdresa(Integer cislodomu,
                                                  String mesto,
                                                  String stat,
                                                  String ulica,
                                                  Integer psc)
    {
        return uzivatelRepositoryM.findAllByCislodomuAndMestoAndStatAndUlicaAndPsc(cislodomu, mesto, stat, ulica, psc);
    }

    public UzivatelM getUzivatelByEmail(String email)
    {
        return uzivatelRepositoryM.findUzivatelMByEmail(email).get();
    }*/


}
