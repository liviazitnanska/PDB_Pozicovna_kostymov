
INSERT INTO Uzivatel (ID,Meno,Priezvisko,Email,Telefon,Stat,Mesto,Ulica,CisloDomu,PSC) VALUES (1, 'Anna', 'Novakova','annanov@pdb.com', 1234, 'Slovensko', 'Bratislava', 'Hlavna', '12', '2412');
INSERT INTO Uzivatel (ID,Meno,Priezvisko,Email,Telefon,Stat,Mesto,Ulica,CisloDomu,PSC) VALUES (2, 'Ivan', 'Bilik','ivanbili@pdb.com', 1234, 'Slovensko', 'Bratislava', 'Hlavna', '34', '2412');
INSERT INTO Uzivatel (ID,Meno,Priezvisko,Email,Telefon,Stat,Mesto,Ulica,CisloDomu,PSC) VALUES (3, 'Maria', 'Svetla','mari@pdb.com',0918345678, 'Slovensko', 'Nitra', 'Mostna', '4524', '91647');
INSERT INTO Uzivatel (ID,Meno,Priezvisko,Email,Telefon,Stat,Mesto,Ulica,CisloDomu,PSC) VALUES (4, 'Mario', 'Plavy','mariop@pdb.com', 463994, 'Slovensko', 'Piestany', 'Winterova', '45', '91622');

INSERT INTO Kostym (ID, Nazov,Popis,Material,Kategoria,Velkost,Vyroba) VALUES (1,'Pastier', 'kostym', 'bavlna', 'muzske', 40);
INSERT INTO Kostym (ID, Nazov,Popis,Material,Kategoria,Velkost,Vyroba) VALUES (2,'Anjel', 'kostym', 'saten', 'zenske', 36);
INSERT INTO Kostym (ID, Nazov,Popis,Material,Kategoria,Velkost,Vyroba) VALUES (3,'Cert', 'kostym', 'bavlna', 'muzske', 38);
INSERT INTO Kostym (ID, Nazov,Popis,Material,Kategoria,Velkost,Vyroba) VALUES (4,'Mikulas', 'kostym', 'bavlna', 'muzske', 44);

INSERT INTO Doplnok(ID, Nazov,Popis,Material,Kategoria,Vyroba) VALUES (1,'Palica', 'doplnok', 'drevo', 'muzske');
INSERT INTO Doplnok(ID, Nazov,Popis,Material,Kategoria,Vyroba) VALUES (2,'Krídla', 'doplnok', 'paperie', 'zenske');
INSERT INTO Doplnok(ID, Nazov,Popis,Material,Kategoria,Vyroba) VALUES (3,'Maska', 'doplnok', 'plast', 'zenske');

INSERT INTO Rezervacia (ID,Cas_pozicania,Cas_vratenia,Vratenie,UzivID) VALUES (1,'2021-06-25 12:34:21','2021-06-28 13:04:11',1,1);
INSERT INTO Rezervacia (ID,Cas_pozicania,Cas_vratenia,Vratenie,UzivID) VALUES (2,'2021-04-30 13:09:21','2021-06-28 13:04:11',1,1);
INSERT INTO Rezervacia (ID,Cas_pozicania,Cas_vratenia,Vratenie,UzivID) VALUES (3,'2021-05-21 14:33:21','',0,2);
INSERT INTO Rezervacia (ID,Cas_pozicania,Cas_vratenia,Vratenie,UzivID) VALUES (4,'2021-02-15 15:12:21','2021-02-16 23:12:51',1,3);

INSERT INTO Rezervacia (ID,Cas_pozicania,Cas_vratenia,Vratenie,UzivID) VALUES (5,'2022-01-05 02:21:21','2022-06-28 03:04:45',1,2);
INSERT INTO Rezervacia (ID,Cas_pozicania,Cas_vratenia,Vratenie,UzivID) VALUES (6,'2022-02-15 11:35:21','',0,4);
INSERT INTO Rezervacia (ID,Cas_pozicania,Cas_vratenia,Vratenie,UzivID) VALUES (7,'2022-03-17 22:33:21','2022-03-28 12:05:21',1,4);

--TODO nejake osetrenie, ze recenzia moze byt len ak si rezervoval dany doplnok a kostym, pocet likov nemoze byt vacsi ako pocet uzivatelov
INSERT INTO Recenzia_kostym(ID,Nazov,Popis,Suhlas,Nesuhlas,UzivID,KostymID) VALUES (1,'Rec4','Zle',0,2,1,1);
INSERT INTO Recenzia_kostym(ID,Nazov,Popis,Suhlas,Nesuhlas,UzivID,KostymID) VALUES (2,'Rec4','Parada',2,2,2,2);
INSERT INTO Recenzia_kostym(ID,Nazov,Popis,Suhlas,Nesuhlas,UzivID,KostymID) VALUES (3,'Rec4','Eh',1,1,3,3);

INSERT INTO Recenzia_doplnok (ID ,Nazov, Popis,Suhlas,Nesuhlas,UzivID,DoplnokID) VALUES (1,'Rec1','Dobre',0,0,1,1);
INSERT INTO Recenzia_doplnok (ID ,Nazov, Popis,Suhlas,Nesuhlas,UzivID,DoplnokID) VALUES (2,'Rec2','Meh',2,4,4,3);
INSERT INTO Recenzia_doplnok (ID ,Nazov, Popis,Suhlas,Nesuhlas,UzivID,DoplnokID) VALUES (3,'Rec3','Fajne',4,1,3,2);

INSERT INTO Wishlist (ID, Nazov,uzivID) VALUES (1,'Vianoce',2);
INSERT INTO Wishlist (ID, Nazov,uzivID) VALUES (2,'Velka_noc',2);
INSERT INTO Wishlist (ID, Nazov,uzivID) VALUES (3,'Halloween',2);
INSERT INTO Wishlist (ID, Nazov,uzivID) VALUES (4,'W1',1);
INSERT INTO Wishlist (ID, Nazov,uzivID) VALUES (5,'W2',4);
INSERT INTO Wishlist (ID, Nazov,uzivID) VALUES (6,'Chcem',4);

INSERT INTO Kostym_rezervacia(ID, UzivID,KostymID) VALUES (1,1,1);
INSERT INTO Kostym_rezervacia(ID, UzivID,KostymID) VALUES (2,1,2);
INSERT INTO Kostym_rezervacia(ID, UzivID,KostymID) VALUES (3,3,3);
INSERT INTO Kostym_rezervacia(ID, UzivID,KostymID) VALUES (4,2,2);

INSERT INTO Dosplnok_rezervacia(ID,UzivID, DoplnokID) VALUES (1,1,1);
INSERT INTO Dosplnok_rezervacia(ID,UzivID, DoplnokID) VALUES (2,4,3);
INSERT INTO Dosplnok_rezervacia(ID,UzivID, DoplnokID) VALUES (3,3,2);
