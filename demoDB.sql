
INSERT INTO Uzivatel (ID,Meno,Priezvisko,Email,Telefon,Stat,Mesto,Ulica,CisloDomu,PSC) VALUES (1, 'Anna', 'Novakova','annanov@pdb.com', 1234, 'Slovensko', 'Bratislava', 'Hlavna', '12', '2412');
INSERT INTO Uzivatel (ID,Meno,Priezvisko,Email,Telefon,Stat,Mesto,Ulica,CisloDomu,PSC) VALUES (2, 'Ivan', 'Bilik','ivanbili@pdb.com', 1234, 'Slovensko', 'Bratislava', 'Hlavna', '34', '2412');
INSERT INTO Uzivatel (ID,Meno,Priezvisko,Email,Telefon,Stat,Mesto,Ulica,CisloDomu,PSC) VALUES (3, 'Maria', 'Svetla','mari@pdb.com',0918345678, 'Slovensko', 'Nitra', 'Mostna', '4524', '91647');
INSERT INTO Uzivatel (ID,Meno,Priezvisko,Email,Telefon,Stat,Mesto,Ulica,CisloDomu,PSC) VALUES (4, 'Mario', 'Plavy','mariop@pdb.com', 463994, 'Slovensko', 'Piestany', 'Winterova', '45', '91622');

INSERT INTO Kostym (ID, Nazov,Popis,Material,Kategoria,Velkost,Vyroba) VALUES (1,'Pastier', 'kostym', 'bavlna', 'muzske', 40, TO_DATE('1989-12-09','YYYY-MM-DD'));
INSERT INTO Kostym (ID, Nazov,Popis,Material,Kategoria,Velkost,Vyroba) VALUES (2,'Anjel', 'kostym', 'saten', 'zenske', 36, TO_DATE('2002-07-08','YYYY-MM-DD'));
INSERT INTO Kostym (ID, Nazov,Popis,Material,Kategoria,Velkost,Vyroba) VALUES (3,'Cert', 'kostym', 'bavlna', 'muzske', 38, TO_DATE('1999-05-03','YYYY-MM-DD'));
INSERT INTO Kostym (ID, Nazov,Popis,Material,Kategoria,Velkost,Vyroba) VALUES (4,'Mikulas', 'kostym', 'bavlna', 'muzske', 44, TO_DATE('2001-04-19','YYYY-MM-DD'));

INSERT INTO Doplnok(ID, Nazov,Popis,Material,Kategoria,Vyroba) VALUES (1,'Palica', 'doplnok', 'drevo', 'muzske', TO_DATE('1989-02-17','YYYY-MM-DD'));
INSERT INTO Doplnok(ID, Nazov,Popis,Material,Kategoria,Vyroba) VALUES (2,'Krídla', 'doplnok', 'paperie', 'zenske', TO_DATE('1989-09-09','YYYY-MM-DD'));
INSERT INTO Doplnok(ID, Nazov,Popis,Material,Kategoria,Vyroba) VALUES (3,'Maska', 'doplnok', 'plast', 'zenske', TO_DATE('1989-04-21','YYYY-MM-DD'));

INSERT INTO Rezervacia (ID,Cas_pozicania,Cas_vratenia,Vratenie,UzivID) VALUES (1, TO_DATE('2021-06-25','YYYY-MM-DD') ,TO_DATE('2021-06-28','YYYY-MM-DD'),1,1);
INSERT INTO Rezervacia (ID,Cas_pozicania,Cas_vratenia,Vratenie,UzivID) VALUES (2, TO_DATE('2021-04-30','YYYY-MM-DD') ,TO_DATE('2021-06-28','YYYY-MM-DD'),1,1);
INSERT INTO Rezervacia (ID,Cas_pozicania,Cas_vratenia,Vratenie,UzivID) VALUES (3, TO_DATE('2021-05-21','YYYY-MM-DD') ,'',0,2);
INSERT INTO Rezervacia (ID,Cas_pozicania,Cas_vratenia,Vratenie,UzivID) VALUES (4, TO_DATE('2021-02-15', 'YYYY-MM-DD') ,TO_DATE('2021-02-16','YYYY-MM-DD'),1,3);

INSERT INTO Rezervacia (ID,Cas_pozicania,Cas_vratenia,Vratenie,UzivID) VALUES (5, TO_DATE('2022-01-05','YYYY-MM-DD') ,TO_DATE('2022-06-28','YYYY-MM-DD'),1,2);
INSERT INTO Rezervacia (ID,Cas_pozicania,Cas_vratenia,Vratenie,UzivID) VALUES (6, TO_DATE('2022-02-15','YYYY-MM-DD') ,'',0,4);
INSERT INTO Rezervacia (ID,Cas_pozicania,Cas_vratenia,Vratenie,UzivID) VALUES (7, TO_DATE('2022-03-17','YYYY-MM-DD') ,TO_DATE('2022-03-28','YYYY-MM-DD'),1,4);

--TODO nejake osetrenie, ze recenzia moze byt len ak si rezervoval dany doplnok a kostym, pocet likov nemoze byt vacsi ako pocet uzivatelov
INSERT INTO Recenzia_kostym(ID,Nazov,Popis,Suhlas,Nesuhlas,UzivID,KostymID) VALUES (1,'Rec4','Zle',0,2,1,1);
INSERT INTO Recenzia_kostym(ID,Nazov,Popis,Suhlas,Nesuhlas,UzivID,KostymID) VALUES (2,'Rec4','Parada',2,2,2,2);
INSERT INTO Recenzia_kostym(ID,Nazov,Popis,Suhlas,Nesuhlas,UzivID,KostymID) VALUES (3,'Rec4','Eh',1,1,3,3);

INSERT INTO Recenzia_doplnok (ID ,Nazov, Popis,Suhlas,Nesuhlas,UzivID,DoplnokID) VALUES (1,'Rec1','Dobre',0,0,1,1);
INSERT INTO Recenzia_doplnok (ID ,Nazov, Popis,Suhlas,Nesuhlas,UzivID,DoplnokID) VALUES (2,'Rec2','Meh',2,4,4,3);
INSERT INTO Recenzia_doplnok (ID ,Nazov, Popis,Suhlas,Nesuhlas,UzivID,DoplnokID) VALUES (3,'Rec3','Fajne',4,1,3,2);

INSERT INTO WishlistKostym (ID, Nazov,uzivID) VALUES (1,'Vianoce',2,1);
INSERT INTO WishlistKostym (ID, Nazov,uzivID) VALUES (2,'Velka_noc',2,1);
INSERT INTO WishlistKostym (ID, Nazov,uzivID) VALUES (3,'Halloween',2,1);
INSERT INTO WishlistDoplnok (ID, Nazov,uzivID) VALUES (4,'W1',1,1);
INSERT INTO WishlistDoplnok (ID, Nazov,uzivID) VALUES (5,'W2',4,2);
INSERT INTO WishlistDoplnok (ID, Nazov,uzivID) VALUES (6,'Chcem',4,2);


INSERT INTO Kostym_rezervacia(ID, UzivID,RezervaciaID,KostymID) VALUES (1,1,2,1);
INSERT INTO Kostym_rezervacia(ID, UzivID,RezervaciaID,KostymID) VALUES (2,1,3,2);
INSERT INTO Kostym_rezervacia(ID, UzivID,RezervaciaID,KostymID) VALUES (3,3,2,3);
INSERT INTO Kostym_rezervacia(ID, UzivID,RezervaciaID,KostymID) VALUES (4,2,3,2);

INSERT INTO Doplnok_rezervacia(ID,UzivID,RezervaciaID, DoplnokID) VALUES (1,1,1,1);
INSERT INTO Doplnok_rezervacia(ID,UzivID,RezervaciaID, DoplnokID) VALUES (2,4,2,3);
INSERT INTO Doplnok_rezervacia(ID,UzivID,RezervaciaID, DoplnokID) VALUES (3,3,2,2);
