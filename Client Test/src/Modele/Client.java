package Modele;


import java.rmi.*;
import java.rmi.server.*;
import java.util.Scanner;
import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;




import Modele.Pendu;
public class Client extends Application  {
	
	
	
 public static void main(String[] argv) {
	 
   launch(argv);
 
 }

public void start(Stage arg0) throws Exception {
		try {

			URL fxmlURL=getClass().getResource("../Vue/pendu.fxml");

			FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL);
			Node root = (Node) fxmlLoader.load();
			Scene scene = new Scene((BorderPane) root, 600, 400);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			arg0.setScene(scene);
			arg0.setTitle("Accueil");
			arg0.show();
		} catch (Exception e) {
			e.printStackTrace();
	} 
	}
	
	
}
