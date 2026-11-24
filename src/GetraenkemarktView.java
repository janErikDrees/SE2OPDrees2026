import business.Getraenk;
import business.GetraenkemarktModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import ownUtil.*;

public class GetraenkemarktView {
	private GetraenkemarktControl getrContr;
	private GetraenkemarktModel getrModel;
	private Stage primaryStage;

	private Pane pane     					= new Pane();
	private Label lblEingabe    	 		= new Label("Eingabe");
	private Label lblAnzeige   	 	    	= new Label("Anzeige");
	private Label lblArtikelnummer 			= new Label("Artikelnummer:");
	private Label lblEinkaufspreis   		= new Label("Einkaufspreis:");
	private Label lblVerkaufspreis  	 	= new Label("Verkaufspreis:");
	private Label lblMitAlkohol   			= new Label("mit Alkohol:");
	private Label lblBehaeltnisse  			= new Label("Behaeltnisse:");
	private TextField txtArtikelnummer 	 	= new TextField();
	private TextField txtEinkaufspreis		= new TextField();
	private TextField txtVerkaufspreis		= new TextField();
	private TextField txtMitAlkohol			= new TextField();
	private TextField txtBehaeltnisse	 	= new TextField();
	private TextArea txtAnzeige  			= new TextArea();
	private Button btnEingabe 		 		= new Button("Eingabe");
	private Button btnAnzeige 		 		= new Button("Anzeige");
	private MenuBar mnbrMenuLeiste  		= new MenuBar();
	private Menu mnDatei             		= new Menu("Datei");
	private MenuItem mnItmCsvImport 		= new MenuItem("csv-Import");
	private MenuItem mnItmTxtImport 		= new MenuItem("txt-Import");
	private MenuItem mnItmCsvExport 		= new MenuItem("csv-Export");

	public GetraenkemarktView(GetraenkemarktControl getrControl, GetraenkemarktModel getrModel, Stage primaryStage) {
		this.getrContr = getrControl;
		this.getrModel = getrModel;
		this.primaryStage = primaryStage;
		Scene scene = new Scene(this.pane, 700, 340);
		this.primaryStage.setScene(scene);
		this.primaryStage.setTitle("Verwaltung eines Getraenkemarkts");
		this.primaryStage.show();
		this.initKomponenten();
		this.initListener();
	}

	private void initKomponenten() {
		// Labels
		lblEingabe.setLayoutX(20);
		lblEingabe.setLayoutY(40);
		Font font = new Font("Arial", 24);
		lblEingabe.setFont(font);
		lblEingabe.setStyle("-fx-font-weight: bold;");
		lblAnzeige.setLayoutX(400);
		lblAnzeige.setLayoutY(40);
		lblAnzeige.setFont(font);
		lblAnzeige.setStyle("-fx-font-weight: bold;");
		lblArtikelnummer.setLayoutX(20);
		lblArtikelnummer.setLayoutY(90);
		lblEinkaufspreis.setLayoutX(20);
		lblEinkaufspreis.setLayoutY(130);
		lblVerkaufspreis.setLayoutX(20);
		lblVerkaufspreis.setLayoutY(170);
		lblMitAlkohol.setLayoutX(20);
		lblMitAlkohol.setLayoutY(210);
		lblBehaeltnisse.setLayoutX(20);
		lblBehaeltnisse.setLayoutY(250);
		pane.getChildren().addAll(lblEingabe, lblAnzeige,
			lblArtikelnummer, lblEinkaufspreis, lblVerkaufspreis,
			lblMitAlkohol, lblBehaeltnisse);

		// Textfelder
		txtArtikelnummer.setLayoutX(170);
		txtArtikelnummer.setLayoutY(90);
		txtArtikelnummer.setPrefWidth(200);
		txtEinkaufspreis.setLayoutX(170);
		txtEinkaufspreis.setLayoutY(130);
		txtEinkaufspreis.setPrefWidth(200);
		txtVerkaufspreis.setLayoutX(170);
		txtVerkaufspreis.setLayoutY(170);
		txtVerkaufspreis.setPrefWidth(200);
		txtMitAlkohol.setLayoutX(170);
		txtMitAlkohol.setLayoutY(210);
		txtMitAlkohol.setPrefWidth(200);
		txtBehaeltnisse.setLayoutX(170);
		txtBehaeltnisse.setLayoutY(250);
		txtBehaeltnisse.setPrefWidth(200);
		pane.getChildren().addAll(
			txtArtikelnummer, txtEinkaufspreis, txtVerkaufspreis,
			txtMitAlkohol, txtBehaeltnisse);

		// Textbereich
		txtAnzeige.setEditable(false);
		txtAnzeige.setLayoutX(400);
		txtAnzeige.setLayoutY(90);
		txtAnzeige.setPrefWidth(270);
		txtAnzeige.setPrefHeight(185);
		pane.getChildren().add(txtAnzeige);

		// Buttons
		btnEingabe.setLayoutX(20);
		btnEingabe.setLayoutY(290);
		btnAnzeige.setLayoutX(400);
		btnAnzeige.setLayoutY(290);
		pane.getChildren().addAll(btnEingabe, btnAnzeige);

		// Menue
		this.mnbrMenuLeiste.getMenus().add(mnDatei);
		this.mnDatei.getItems().add(mnItmCsvImport);
		this.mnDatei.getItems().add(mnItmTxtImport);
		this.mnDatei.getItems().add(new SeparatorMenuItem());
		this.mnDatei.getItems().add(mnItmCsvExport);
		pane.getChildren().add(mnbrMenuLeiste);
	}

	private void initListener() {
		btnEingabe.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				nehmeGetraenkAuf();
			}
		});
		btnAnzeige.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				zeigeGetraenkeAn();
			}
		});
		mnItmCsvImport.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				getrContr.leseAusDatei("csv");
			}
		});
		mnItmTxtImport.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				getrContr.leseAusDatei("txt");
			}
		});
		mnItmCsvExport.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				getrContr.schreibeGetraenkeInCsvDatei();
			}
		});
	}

	private void nehmeGetraenkAuf() {
		try {
			Getraenk getraenk = new Getraenk(
				txtArtikelnummer.getText(),
				Float.parseFloat(txtEinkaufspreis.getText()),
				Float.parseFloat(txtVerkaufspreis.getText()),
				txtMitAlkohol.getText(),
				txtBehaeltnisse.getText().split(";")
			);
			this.getrModel.setGetraenk(getraenk);
			zeigeInformationsfensterAn("Das Getraenk wurde aufgenommen!");
		} catch (Exception exc) {
			zeigeFehlermeldungsfensterAn(exc.getMessage());
		}
	}

	private void zeigeGetraenkeAn() {
		if (this.getrModel.getGetraenk() != null) {
			txtAnzeige.setText(this.getrModel.getGetraenk().gibGetraenkZurueck(' '));
		} else {
			zeigeInformationsfensterAn("Bisher wurde kein Getraenk aufgenommen!");
		}
	}

	public void zeigeInformationsfensterAn(String meldung) {
		new MeldungsfensterAnzeiger(AlertType.INFORMATION,
			"Information", meldung).zeigeMeldungsfensterAn();
	}

	public void zeigeFehlermeldungsfensterAn(String meldung) {
		new MeldungsfensterAnzeiger(AlertType.ERROR,
			"Fehler", meldung).zeigeMeldungsfensterAn();
	}
}