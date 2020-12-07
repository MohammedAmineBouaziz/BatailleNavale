package batailleNavale;

import java.util.Random;

public class JoueurAutoIdiot extends JoueurAvecGrille {
     public Coordonnee derCoor;
     
    private GrilleNavale Gr2 = new GrilleNavale(10,3);
     
	//private static Random r = new Random();

	public JoueurAutoIdiot(GrilleNavale g, String nom) {
		
		super(g, nom);
		
	}

	public JoueurAutoIdiot(GrilleNavale g) {
		super(g);
		
		
	}

	protected void retourAttaque(Coordonnee c, int etat) {
		StringBuffer resu = new StringBuffer ("");
		if ( etat == 3) {//A l'eau 3
			resu.append("Dommage! Tu as tire dans l'eau...");
			  
		}else if (etat == 1) {//Touché 1
			resu.append("Bravo! Tu as reussi à toucher ton adversaire.");
			
		}else if (etat == 2) {//Coulé 2
			
			resu.append("Wow! Tu as coule un bateau!");
			
		}else if (etat == 4) {//GameOver 4
			
			resu.append("Bravo, tu viens de gagner la partie!");
		}
		
	System.out.println(this.getNom()+": Vous avez saisi  " + c + " : " + resu+"\n");

	}
	

	protected void retourDefense(Coordonnee c, int etat) {
      StringBuffer resu = new StringBuffer ("");
		
		if (etat == 3) {//A l'eau 3
			resu.append("Ouf! Ton adversaire t'as raté.");
			  
		}else if (etat== 1) {//Touché 1
			resu.append("Aïe! Un de tes bateaux vient d'être touché....");
			
		}else if (etat== 2) {//Coulé 2
			resu.append("Olala...Tu viens de perdre un bateau!");
			
		}else if (etat == 4) {//GameOver 4
			resu.append("Désolé, tu as perdu la partie...");
		}
		 derCoor=c;
		System.out.println(this.getNom()+": Votre adversaire a saisi  " + c + " : " + resu);
		  
	}

	public Coordonnee choisirAttaque() {

		return derCoor;
	}

	
	public static void main(String[] args) {

	}

}
