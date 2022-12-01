DROP TABLE Wishlist;
DROP TABLE Recenzia_kostym;
DROP TABLE Recenzia_doplnok;
DROP TABLE Rezervacia;
DROP TABLE Kostym;
DROP TABLE Doplnok;
DROP TABLE Uzivatel;
DROP TABLE Kostym_rezervacia;
DROP TABLE Dosplnok_rezervacia;

CREATE TABLE Uzivatel (
                          ID int NOT NULL PRIMARY KEY,
                          Meno varchar(150) NOT NULL,
                          Priezvisko varchar(150) NOT NULL,
                          Email varchar(50),
                          Telefon varchar(15),
                          Stat varchar(50),
                          Mesto varchar(50),
                          Ulica varchar(50),
                          CisloDomu int,
                          PSC int
);


CREATE TABLE Kostym (
                        ID int NOT NULL PRIMARY KEY,
                        Nazov varchar(150) NOT NULL,
                        Popis varchar(600),
                        Material varchar(50) NOT NULL,
                        Kategoria varchar(50) NOT NULL,
                        Velkost int NOT NULL,
                        Vyroba date
);


CREATE TABLE Doplnok (
                         ID int NOT NULL PRIMARY KEY,
                         Nazov varchar(150) NOT NULL,
                         Popis varchar(600),
                         Material varchar(50) NOT NULL,
                         Kategoria varchar(50) NOT NULL,
                         Vyroba date
);

CREATE TABLE Rezervacia (
                            ID int NOT NULL PRIMARY KEY,
                            Cas_pozicania date NOT NULL,
                            Cas_vratenia date,
                            Vratenie NUMBER(1) NOT NULL,
                            UzivID int NOT NULL,
                            CONSTRAINT FK_Rezervacia_Uzivatel_ID FOREIGN KEY (UzivID)REFERENCES  Uzivatel(ID)
);

CREATE TABLE Recenzia_doplnok (
                                  ID int NOT NULL PRIMARY KEY,
                                  Nazov varchar(150) NOT NULL,
                                  Popis varchar(600) NOT NULL,
                                  Suhlas int,
                                  Nesuhlas int,
                                  UzivID int NOT NULL,
                                  DoplnokID int NOT NULL,
                                  CONSTRAINT FK_RD_Uzivatel_ID FOREIGN KEY (UzivID)REFERENCES Uzivatel(ID),
                                  CONSTRAINT FK_RD_Doplnok_ID  FOREIGN KEY (DoplnokID) REFERENCES Doplnok(ID)
);

CREATE TABLE Recenzia_kostym (
                                 ID int NOT NULL PRIMARY KEY,
                                 Nazov varchar(150) NOT NULL,
                                 Popis varchar(600) NOT NULL,
                                 Suhlas int,
                                 Nesuhlas int,
                                 UzivID int NOT NULL,
                                 KostymID int NOT NULL,
                                 CONSTRAINT FK_RK_Uzivatel_ID FOREIGN KEY (UzivID)REFERENCES  Uzivatel(ID),
                                 CONSTRAINT FK_RK_kostym_ID FOREIGN KEY (KostymID)REFERENCES  Kostym(ID)
);

CREATE TABLE Wishlist (
                          ID int NOT NULL PRIMARY KEY,
                          Nazov varchar(150),
                          uzivID int NOT NULL,
                          CONSTRAINT FK_Wishlislt_Uzivatel_ID FOREIGN KEY (uzivID) REFERENCES Uzivatel(ID)

);

CREATE TABLE Kostym_rezervacia(
                                  ID int NOT NULL PRIMARY KEY,
                                  UzivID int NOT NULL,
                                  RezervaciaID int NOT NULL,
                                  KostymID int NOT NULL
);

CREATE TABLE Doplnok_rezervacia(
                                    ID int NOT NULL PRIMARY KEY,
                                    UzivID int NOT NULL,
                                    RezervaciaID int NOT NULL,
                                    DoplnokID int NOT NULL
);