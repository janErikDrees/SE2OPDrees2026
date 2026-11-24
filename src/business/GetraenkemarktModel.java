package business;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

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
		if ("csv".equals(typ)) {
			BufferedReader ein = new BufferedReader(new FileReader("Getraenk.csv"));
			String[] zeile = ein.readLine().split(";");
			this.getraenk = new Getraenk(
				zeile[0],
				Float.parseFloat(zeile[1]),
				Float.parseFloat(zeile[2]),
				zeile[3],
				zeile[4].split("_")
			);
			ein.close();
		}
	}

	public void schreibeGetraenkeInCsvDatei() throws IOException {
		BufferedWriter aus = new BufferedWriter(new FileWriter("GetraenkeAusgabe.csv", true));
		aus.write(this.getraenk.gibGetraenkZurueck(';'));
		aus.close();
	}
}