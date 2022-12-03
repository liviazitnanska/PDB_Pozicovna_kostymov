package com.pdb_db.pdb_proj.tests.uzivatel;

import com.pdb_db.pdb_proj.domain.uzivatel.Uzivatel;
import com.pdb_db.pdb_proj.domain.uzivatel.UzivatelRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@SpringBootTest
//@AutoConfigureMockMvc
//@DataJpaTest
class UzivatelRepositoryTests
{
    @Autowired
    private UzivatelRepository uzivatelRepository;

    String email = "jarina@pdb.com";
    @Test
    void create_user()
    {

        Uzivatel uzivatel = new Uzivatel("Jarka","Mala",email,"0911234567","Slovensko","Nitra", "Nabrezna", 9,91423);
        uzivatelRepository.save(uzivatel);

        boolean exists = false;
        if(uzivatelRepository.findUzivatelByEmail(email).isPresent())
            exists = true;

        assertThat(exists).isTrue();
    }

    @Test
    void no_user_no_email()
    {
        boolean exists = false;
        if(uzivatelRepository.findUzivatelByEmail("ABCDEF").isPresent())
            exists = true;

        assertThat(exists).isFalse();
    }
}
