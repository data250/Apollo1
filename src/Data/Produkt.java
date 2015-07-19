package Data;

public class Produkt {
	
	private int id;
	private String nazwa;
	private String PKWiU;
	private String kategoria;		/* Typ wyliczeniowy ? */
	private String opis;
	private double cena;
	private double ilosc;
	private String jednostka;		/* Typ wiliczeniowy ? */
	private double podatek;			/* TYP WYLICZENIOWY ?*/
	
	public Produkt(int id, String nazwa, String pKWiU, String kategoria,
			String opis, double cena, double ilosc, String jednostka,
			double podatek) {
		super();
		this.id = id;
		this.nazwa = nazwa;
		this.PKWiU = pKWiU;
		this.kategoria = kategoria;
		this.opis = opis;
		this.cena = cena;
		this.ilosc = ilosc;
		this.jednostka = jednostka;
		this.podatek = podatek;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public String getPKWiU() {
		return PKWiU;
	}

	public void setPKWiU(String pKWiU) {
		PKWiU = pKWiU;
	}

	public String getKategoria() {
		return kategoria;
	}

	public void setKategoria(String kategoria) {
		this.kategoria = kategoria;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public double getCena() {
		return cena;
	}

	public void setCena(double cena) {
		this.cena = cena;
	}

	public double getIlosc() {
		return ilosc;
	}

	public void setIlosc(double ilosc) {
		this.ilosc = ilosc;
	}

	public String getJednostka() {
		return jednostka;
	}

	public void setJednostka(String jednostka) {
		this.jednostka = jednostka;
	}

	public double getPodatek() {
		return podatek;
	}

	public void setPodatek(double podatek) {
		this.podatek = podatek;
	}
	
	
	
	
	

}
