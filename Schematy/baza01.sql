--
-- Plik wygenerowany przez SQLiteStudio v3.0.6 dnia niedz. lip 19 15:46:26 2015
--
-- Użyte kodowanie tekstu: UTF-8
--
PRAGMA foreign_keys = off;
BEGIN TRANSACTION;

-- Tabela: MagazynProdukt
CREATE TABLE MagazynProdukt (id_magazyn INTEGER REFERENCES Magazyn (id), id_produkt INTEGER REFERENCES Produkt (id), cena DOUBLE, podatek INTEGER, typ VARCHAR);

-- Tabela: Faktura
CREATE TABLE Faktura (id INTEGER PRIMARY KEY AUTOINCREMENT UNIQUE, id_kontrahent INTEGER REFERENCES Kontrahenci (id) NOT NULL, numer_faktury VARCHAR);

-- Tabela: Kategoria
CREATE TABLE Kategoria (nazwa VARCHAR PRIMARY KEY UNIQUE);

-- Tabela: Magazyn
CREATE TABLE Magazyn (id INTEGER PRIMARY KEY AUTOINCREMENT, id_faktury INTEGER REFERENCES Faktura (id), numer_identyfikacyjny VARCHAR, typ VARCHAR, data DATE);

-- Tabela: Produkt
CREATE TABLE Produkt (id INTEGER PRIMARY KEY AUTOINCREMENT, nazwa VARCHAR, PKWiU VARCHAR, kategoria VARCHAR REFERENCES Kategoria (nazwa), jednostka VARCHAR REFERENCES Jednostka (nazwa), podatek VARCHAR REFERENCES Podatek (id), ilosc DOUBLE);

-- Tabela: Kontrahenci
CREATE TABLE Kontrahenci (id INTEGER PRIMARY KEY AUTOINCREMENT, imie VARCHAR, nazwisko VARCHAR, nazwa_firmy VARCHAR, REGON VARCHAR, KRS VARCHAR, NIP VARCHAR, kod_pocztowy VARCHAR, poczta VARCHAR, kraj VARCHAR, wojewodztwo VARCHAR, powiat VARCHAR, miasto VARCHAR, ulica VARCHAR, numer_budynku VARCHAR, numer_lokalu VARCHAR, telefon_stacjonarny VARCHAR, telefon_komorkowy VARCHAR, FAX VARCHAR, email VARCHAR, www VARCHAR, skype VARCHAR, typ BOOLEAN);

-- Tabela: Podatek
CREATE TABLE Podatek (id INTEGER PRIMARY KEY AUTOINCREMENT, opis VARCHAR, wartosc INTEGER);

-- Tabela: Jednostka
CREATE TABLE Jednostka (nazwa PRIMARY KEY UNIQUE);

COMMIT TRANSACTION;
PRAGMA foreign_keys = on;
