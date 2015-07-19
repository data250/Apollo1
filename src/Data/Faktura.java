package Data;
import java.util.GregorianCalendar;

public class Faktura {
	
	private int id;
	private Kontrahent idKon;
	private String numerFaktury;
	private GregorianCalendar dataWystawienia;
	private String rodzajZaplaty;
	private GregorianCalendar terminZaplaty;
	private String kontoKsiêgowe;
	private GregorianCalendar dostawaOd;
	private GregorianCalendar dostawaDo;
	
	public Faktura(int id, Kontrahent idKon, String numerFaktury,
			GregorianCalendar dataWystawienia, String rodzajZaplaty,
			GregorianCalendar terminZaplaty, String kontoKsiêgowe,
			GregorianCalendar dostawaOd, GregorianCalendar dostawaDo) {
		super();
		this.id = id;
		this.idKon = idKon;
		this.numerFaktury = numerFaktury;
		this.dataWystawienia = dataWystawienia;
		this.rodzajZaplaty = rodzajZaplaty;
		this.terminZaplaty = terminZaplaty;
		this.kontoKsiêgowe = kontoKsiêgowe;
		this.dostawaOd = dostawaOd;
		this.dostawaDo = dostawaDo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Kontrahent getIdKon() {
		return idKon;
	}

	public void setIdKon(Kontrahent idKon) {
		this.idKon = idKon;
	}

	public String getNumerFaktury() {
		return numerFaktury;
	}

	public void setNumerFaktury(String numerFaktury) {
		this.numerFaktury = numerFaktury;
	}

	public GregorianCalendar getDataWystawienia() {
		return dataWystawienia;
	}

	public void setDataWystawienia(GregorianCalendar dataWystawienia) {
		this.dataWystawienia = dataWystawienia;
	}

	public String getRodzajZaplaty() {
		return rodzajZaplaty;
	}

	public void setRodzajZaplaty(String rodzajZaplaty) {
		this.rodzajZaplaty = rodzajZaplaty;
	}

	public GregorianCalendar getTerminZaplaty() {
		return terminZaplaty;
	}

	public void setTerminZaplaty(GregorianCalendar terminZaplaty) {
		this.terminZaplaty = terminZaplaty;
	}

	public String getKontoKsiêgowe() {
		return kontoKsiêgowe;
	}

	public void setKontoKsiêgowe(String kontoKsiêgowe) {
		this.kontoKsiêgowe = kontoKsiêgowe;
	}

	public GregorianCalendar getDostawaOd() {
		return dostawaOd;
	}

	public void setDostawaOd(GregorianCalendar dostawaOd) {
		this.dostawaOd = dostawaOd;
	}

	public GregorianCalendar getDostawaDo() {
		return dostawaDo;
	}

	public void setDostawaDo(GregorianCalendar dostawaDo) {
		this.dostawaDo = dostawaDo;
	}
	
	
	
	
}
