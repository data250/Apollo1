package main;

import Data.Kontrahent;

public class Apollo1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("DUPA");
		GlownaBaza baza = new GlownaBaza();
		//baza.createTables();
		Kontrahent kont = new Kontrahent(1, true, "TEST", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
		baza.insertKontrahent(kont);
		

	}

}
