import java.io.IOException;

import business.GetraenkemarktModel;
import javafx.stage.Stage;

public class GetraenkemarktControl {
	private GetraenkemarktView getrView;
	private GetraenkemarktModel getrModel;

	public GetraenkemarktControl(Stage primaryStage) {
		this.getrModel = new GetraenkemarktModel();
		this.getrView = new GetraenkemarktView(this, this.getrModel, primaryStage);
	}

	public void leseAusDatei(String typ) {
		try {
			this.getrModel.leseAusDatei(typ);
			this.getrView.zeigeInformationsfensterAn("Das Getraenk wurde gelesen!");
			
		} catch (IOException exc) {
			this.getrView.zeigeFehlermeldungsfensterAn("IOException beim Lesen!");
		} catch (Exception exc) {
			this.getrView.zeigeFehlermeldungsfensterAn("Unbekannter Fehler beim Lesen!");
		}
	}

	public void schreibeGetraenkeInCsvDatei() {
		try {
			this.getrModel.schreibeGetraenkeInCsvDatei();
			this.getrView.zeigeInformationsfensterAn("Die Getraenke wurden gespeichert!");
		} catch (IOException exc) {
			this.getrView.zeigeFehlermeldungsfensterAn("IOException beim Speichern!");
		} catch (Exception exc) {
			this.getrView.zeigeFehlermeldungsfensterAn("Unbekannter Fehler beim Speichern!");
		}
	}
}