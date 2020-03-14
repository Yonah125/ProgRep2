package Controleur;

import java.net.URL;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.Optional;
import java.util.ResourceBundle;


import javafx.scene.control.ListView;
import javafx.fxml.Initializable;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
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
	@FXML 
	private ListView liste;
	@FXML
	private Label lbl_erreur;
	@FXML
	private Button replay;
	@FXML Line l1;
	@FXML Line l2;
	@FXML Line l3;
	@FXML Line l4;
	@FXML Line l5;
	@FXML Line l7;
	@FXML Line l8;
	@FXML Line l9;
	@FXML Line l10;
	@FXML Line l11;
	@FXML Circle l6;

	public void initialize(URL arg0, ResourceBundle arg1) {
		try{
			this.replay.setVisible(false);
			this.lbl_erreur.setVisible(false);
			this.obj = (PenduInter)Naming.lookup("rmi://localhost:8000/Jeux");
			startGame(obj);

		
	}catch(Exception e){
		System.out.println("Pendu exception: " + e);
}	
}
	
	
	public void replayF() throws RemoteException {
		this.l1.setVisible(false);
		this.l2.setVisible(false);
		this.l3.setVisible(false);
		this.l4.setVisible(false);
		this.l5.setVisible(false);
		this.l6.setVisible(false);
		this.l7.setVisible(false);
		this.l8.setVisible(false);
		this.l9.setVisible(false);
		this.l10.setVisible(false);
		this.l11.setVisible(false);
		this.replay.setVisible(false);
		this.liste.getItems().clear();
		startGame(this.obj);
		
	}
	public void startGame(PenduInter obj) throws RemoteException  {
		this.A = obj.initPartie();
		this.mot.setText(A.getMotEnvoye());
	}
	
	
	public void Find() throws RemoteException {
		String l = this.lettre.getText();
		if(!this.lettre.getText().isEmpty() && this.A.getList().contains(Character.toUpperCase(l.charAt(0)))==false ) {
			char c = l.charAt(0);
			this.lbl_erreur.setVisible(false);
			this.A = obj.lettreFind(A, Character.toUpperCase(c));
			this.mot.setText(A.getMotEnvoye());
			this.lettre.clear();
			boolean Win = this.obj.winCheck(A);
			this.liste.getItems().clear();
			this.liste.getItems().add(A.getList());
			switch(this.A.getChance()) {
					case 10 : this.l1.setVisible(true);
					break;
					case 9 : this.l2.setVisible(true);
					break;
					case 8 :  this.l3.setVisible(true);
					break;
					case 7 : this.l4.setVisible(true);
					break;
					case 6 : this.l5.setVisible(true);
					break;
					case 5 : this.l6.setVisible(true);
					break;
					case 4 : this.l7.setVisible(true);
					break;
					case 3 : this.l8.setVisible(true);
					break;
					case 2 : this.l9.setVisible(true);
					break;
					case 1 : this.l10.setVisible(true);
					break;
					case 0 : this.l11.setVisible(true);
					
					
			}
			
			if(Win) {
				this.replay.setVisible(true);
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Win");
				alert.setContentText("OUI DENIS");
				Optional<ButtonType> result = alert.showAndWait();
			}else if (!Win && A.getChance()==0) {
				this.replay.setVisible(true);
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Lose");
				alert.setContentText("Mais tu es bête, le mot c'étais "+A.getMot());
				Optional<ButtonType> result = alert.showAndWait();
			}
		
		
		}else
			if(!this.lettre.getText().isEmpty())
				this.lbl_erreur.setVisible(true);
		
		this.lettre.clear();
		
	}
		
}
