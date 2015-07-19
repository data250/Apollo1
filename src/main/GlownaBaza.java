package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import Data.Faktura;
import Data.Kontrahent;

public class GlownaBaza {

	public static final String DRIVER = "org.sqlite.JDBC";
	public static final String DB_URL = "jdbc:sqlite:main_database.db";

	private Connection conn;
	private Statement stat;

	public GlownaBaza() {
		try {
			Class.forName(GlownaBaza.DRIVER);
		} catch (ClassNotFoundException e) {
			System.err.println("Brak sterownika JDBC");
			e.printStackTrace();
		}

		try {
			conn = DriverManager.getConnection(DB_URL);
			stat = conn.createStatement();
		} catch (SQLException e) {
			System.err.println("Problem z otwarciem polaczenia");
			e.printStackTrace();
		}

		//createTables();
	}

	public boolean createTables() {
		
		String createKontrahenci = "CREATE TABLE Kontrahenci (id INTEGER PRIMARY KEY AUTOINCREMENT, imie VARCHAR, nazwisko VARCHAR, nazwa_firmy VARCHAR, REGON VARCHAR, KRS VARCHAR, NIP VARCHAR, kod_pocztowy VARCHAR, poczta VARCHAR, kraj VARCHAR, wojewodztwo VARCHAR, powiat VARCHAR, miasto VARCHAR, ulica VARCHAR, numer_budynku VARCHAR, numer_lokalu VARCHAR, telefon_stacjonarny VARCHAR, telefon_komorkowy VARCHAR, FAX VARCHAR, email VARCHAR, www VARCHAR, skype VARCHAR, typ BOOLEAN)";
		String createFaktura = "CREATE TABLE Faktura (id INTEGER PRIMARY KEY AUTOINCREMENT UNIQUE, id_kontrahent INTEGER REFERENCES Kontrahenci (id) NOT NULL, numer_faktury VARCHAR)";
		String createMagazyn = "CREATE TABLE Magazyn (id INTEGER PRIMARY KEY AUTOINCREMENT, id_faktury INTEGER REFERENCES Faktura (id), numer_identyfikacyjny VARCHAR, typ VARCHAR, data DATE)";
		String createKategoria = "CREATE TABLE Kategoria (nazwa VARCHAR PRIMARY KEY UNIQUE)";
		String createJednostka = "CREATE TABLE Jednostka (nazwa PRIMARY KEY UNIQUE)";
		String createPodatek = "CREATE TABLE Podatek (id INTEGER PRIMARY KEY AUTOINCREMENT, opis VARCHAR, wartosc INTEGER)";
		String createProdukt = "CREATE TABLE Produkt (id INTEGER PRIMARY KEY AUTOINCREMENT, nazwa VARCHAR, PKWiU VARCHAR, kategoria VARCHAR REFERENCES Kategoria (nazwa), jednostka VARCHAR REFERENCES Jednostka (nazwa), podatek VARCHAR REFERENCES Podatek (id), ilosc DOUBLE)";
		String createMagazynProdukt = "CREATE TABLE MagazynProdukt (id_magazyn INTEGER REFERENCES Magazyn (id), id_produkt INTEGER REFERENCES Produkt (id), cena DOUBLE, podatek INTEGER, typ VARCHAR)";
		
		try {
		
			stat.execute(createKontrahenci);
			stat.execute(createFaktura);
			stat.execute(createMagazyn);
			stat.execute(createKategoria);
			stat.execute(createJednostka);
			stat.execute(createPodatek);
			stat.execute(createProdukt);
			stat.execute(createMagazynProdukt);
		} catch (SQLException e) {
			System.err.println("Blad przy tworzeniu tabeli");
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean insertKontrahent(Kontrahent kontrahent){
		  try {
	            PreparedStatement prepStmt = conn.prepareStatement(
	                    "insert into Kontrahenci values (NULL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
	            
	            prepStmt.setString(1, kontrahent.getImie());
	            prepStmt.setString(2, kontrahent.getNazwisko());
	            prepStmt.setString(3, kontrahent.getNazwa_firmy());
	            prepStmt.setString(4, kontrahent.getREGON());
	            prepStmt.setString(5, kontrahent.getKRS());
	            prepStmt.setString(6, kontrahent.getNIP());
	            prepStmt.setString(7, kontrahent.getKod_pocztowy());
	            prepStmt.setString(8, kontrahent.getPoczta());
	            prepStmt.setString(9, kontrahent.getKraj());
	            prepStmt.setString(10, kontrahent.getWojwodztwo());
	            prepStmt.setString(11, kontrahent.getPowiat());
	            prepStmt.setString(12, kontrahent.getMiasto());
	            prepStmt.setString(13, kontrahent.getUlica());
	            prepStmt.setString(14, kontrahent.getNrBudynku());
	            prepStmt.setString(15, kontrahent.getNrLokalu());
	            prepStmt.setString(16, kontrahent.getTelStac());
	            prepStmt.setString(17, kontrahent.getTelKom());
	            prepStmt.setString(18, kontrahent.getFax());
	            prepStmt.setString(19, kontrahent.getEmail());
	            prepStmt.setString(20, kontrahent.getWww());
	            prepStmt.setString(21, kontrahent.getSkype());
	            prepStmt.setString(22, Boolean.toString(kontrahent.getTyp()));

	        	prepStmt.execute();
	        } catch (SQLException e) {
	            System.err.println("Blad przy wstawianiu kontrahenta");
	            e.printStackTrace();
	            return false;
	        }
	        return true;
	}
	public boolean insertFaktura(Faktura faktura){
	try {
        PreparedStatement prepStmt = conn.prepareStatement(
                "insert into Faktura values (NULL, ?, ?, ?, ?, ?, ?, ?, ?);");
        
        
        prepStmt.setString(1, Integer.toString(faktura.getIdKon()) );
        prepStmt.setString(2, faktura.getNumerFaktury());
        prepStmt.setString(3, faktura.getDataWystawienia());
        prepStmt.setString(4, faktura);
        prepStmt.setString(5, faktura);
        prepStmt.setString(6, faktura);
        prepStmt.setString(7, faktura);
        prepStmt.setString(8, faktura);
        

    	prepStmt.execute();
    } catch (SQLException e) {
        System.err.println("Blad przy wstawianiu kontrahenta");
        e.printStackTrace();
        return false;
    }
    return true;
}

	

	public void closeConnection() {
		try {
			conn.close();
		} catch (SQLException e) {
			System.err.println("Problem z zamknieciem polaczenia");
			e.printStackTrace();
		}
	}

}
