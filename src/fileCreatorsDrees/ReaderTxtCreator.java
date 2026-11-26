package fileCreatorsDrees;

import java.io.IOException;

public class ReaderTxtCreator extends ReaderCreatorDrees {

	@Override
	public ReaderProductDrees fabrikmethode() throws IOException {
		// TODO Auto-generated method stub
		return new ReaderTxtProduct();
	}

}
