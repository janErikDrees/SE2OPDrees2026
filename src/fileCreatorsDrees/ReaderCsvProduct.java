package fileCreatorsDrees;

import java.io.BufferedReader;
//import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReaderCsvProduct extends ReaderProductDrees {
	private BufferedReader ein;
	
	public ReaderCsvProduct() throws IOException {
		ein = new BufferedReader(new FileReader("Getraenk.csv"));
	}

	@Override
	public String[] leseAusDatei() throws IOException {
		String[] zeile = this.ein.readLine().split(";");
		return zeile;
	}

	@Override
	public void schliesseDatei() throws IOException {
		this.ein.close();
	}

}
