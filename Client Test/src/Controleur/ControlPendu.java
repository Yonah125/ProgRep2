package Controleur;

import java.net.URL;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.fxml.FXML;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import Modele.PenduInter;
import Modele.Pendu;

public class ControlPendu implements Initializable {
	PenduInter obj;
	Pendu A;
	@FXML
	private Label mot;
	@FXML
	private TextField lettre;

	public void initialize(URL arg0, ResourceBundle arg1) {
		try{
			this.obj = (PenduInter)Naming.lookup("rmi://localhost:8000/Jeux");
			this.A = obj.initPartie();
			this.mot.setText(A.getMotEnvoye());

		
	}catch(Exception e){
		System.out.println("Pendu exception: " + e);

}
}
	public void Find() throws RemoteException {
		String l = this.lettre.getText();
		this.A = obj.lettreFind(A, l.charAt(0));
		System.out.println(A.getMotEnvoye());
		this.mot.setText(A.getMotEnvoye());
		this.lettre.clear();
		boolean Win = this.obj.winCheck(A);
		
		
		
		
	}
		
}
