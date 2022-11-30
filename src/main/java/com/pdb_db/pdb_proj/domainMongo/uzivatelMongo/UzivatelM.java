package com.pdb_db.pdb_proj.domainMongo.uzivatelMongo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Data
@Document
public class UzivatelM
{
    @Id
    private Integer id;
    private String meno;
    private String priezvisko;
    @Indexed(unique = true)
    private String email;
    private String telefon;
    private String stat;
    private String mesto;
    private String ulica;
    private Integer cislodomu;
    private Integer psc;
    private List<String> wishlistyNazov;
    private List<Integer> recenzieDoplnkov;
    private List<Integer> recenzieKostymov;
}
