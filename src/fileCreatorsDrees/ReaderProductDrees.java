package fileCreatorsDrees;

import java.io.IOException;

public abstract class ReaderProductDrees {
	
	public abstract String[] leseAusDatei() throws IOException;
	
	public abstract void schliesseDatei() throws IOException;
}
