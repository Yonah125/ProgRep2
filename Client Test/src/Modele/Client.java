package Modele;


import java.rmi.*;
import java.rmi.server.*;
import java.util.Scanner;

import Modele.Pendu;
import Modele.PenduInter;
public class Client {
	
 public static void main(String[] argv) {
	 
  try {
   int port = 8000;
   PenduInter obj = (PenduInter) Naming.lookup("rmi://localhost:8000/Jeux");
   Pendu P = obj.initPartie();
   Scanner sc = new Scanner(System.in); 
   while(true) {
	   	System.out.println(P.getMotEnvoyé());
	   	System.out.println("Ecrit une lettre fdp, chance restante: "+P.getChance());
	   	char c = sc.next().charAt(0);
	   	P = obj.lettreFind(P, c);
	   	if (P.getChance() == 0) {
	   		System.out.println("TU ES NUL");
	   		break;
	   	}
	   	boolean win = obj.winCheck(P);
	   	if(win) {
	   		System.out.println(P.getMotEnvoyé());
	   		System.out.println("GG ! ");
	   		break;
	   	}

   }
  } catch (Exception e) {
   System.out.println("Client exception: " + e);
  }
 }
}