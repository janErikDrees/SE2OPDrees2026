package business;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import fileCreatorsDrees.*;

public class GetraenkemarktModel {
	private Getraenk getraenk;

	public GetraenkemarktModel() {
	}

	public Getraenk getGetraenk() {
		return this.getraenk;
	}

	public void setGetraenk(Getraenk getraenk) {
		this.getraenk = getraenk;
	}

	public void leseAusDatei(String typ) throws IOException {
		ReaderProductDrees produkt;
		ReaderCreatorDrees creator;
		if (typ == "csv") {
			creator = new ReaderCsvCreator();
		} else {
			creator = new ReaderTxtCreator();
		}
		produkt = creator.fabrikmethode();
		String[] einlese = produkt.leseAusDatei();
		this.getraenk = new Getraenk(einlese[0], Float.parseFloat(einlese[1]), Float.parseFloat(einlese[2]), einlese[3], einlese[4].split("_"));
		produkt.schliesseDatei();
		
	}

	public void schreibeGetraenkeInCsvDatei() throws IOException {
		BufferedWriter aus = new BufferedWriter(new FileWriter("GetraenkeAusgabe.csv", true));
		aus.write(this.getraenk.gibGetraenkZurueck(';'));
		aus.close();
	}
}