package fileCreatorsDrees;

import java.io.IOException;

public class ReaderCsvCreator extends ReaderCreatorDrees {

	@Override
	public ReaderProductDrees fabrikmethode() throws IOException {
		// TODO Auto-generated method stub
		return new ReaderCsvProduct();
	}

}
