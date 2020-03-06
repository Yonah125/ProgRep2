package Modele;

import java.io.Serializable;
public class Pendu implements Serializable {
	int Chance;
	String Mot;
	String motEnvoye;
	
	public Pendu(int chance, String mot, String motEnvoye) {
		super();
		this.Chance = chance;
		this.Mot = mot;
		this.motEnvoye = motEnvoye;
	}


	public int getChance() {
		return Chance;
	}

	public void setChance(int chance) {
		Chance = chance;
	}

	public String getMot() {
		return Mot;
	}

	public void setMot(String mot) {
		Mot = mot;
	}

	public String getmotEnvoye() {
		return motEnvoye;
	}

	public void setmotEnvoye(String motEnvoye) {
		this.motEnvoye = motEnvoye;
	}
	
	
	
	
	
	

}
