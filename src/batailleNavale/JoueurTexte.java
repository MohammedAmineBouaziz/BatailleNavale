package batailleNavale;

import java.util.Scanner;

public  class JoueurTexte extends JoueurAvecGrille {
	
	private Scanner sc = new Scanner(System.in);
	 
	
	
	public JoueurTexte(GrilleNavale g, String nom) {
		super(g, nom);
	}
	
	
	public JoueurTexte(GrilleNavale g) {
		super(g);
		}
	
	public  void afficher() {
		System.out.println(super.toString());
	}
	
	protected void retourAttaque(Coordonnee c, int etat) {
		//super.getTailleGrille();
		//super.defendre(c);
		
		StringBuffer resu = new StringBuffer ("");
		//afficher();
		if ( etat == 3) {//A l'eau 3
			resu.append("Dommage! Tu as tiré dans l'eau...");
			  
		}else if (etat == 1) {//Touché 1
			resu.append("Bravo! Tu as réussi à toucher ton adversaire.");
			
		}else if (etat == 2) {//Coulé 2
			
			resu.append("Wow! Tu as coulé un bateau!");
			
		}else if (etat == 4) {//GameOver 4
			
			resu.append("Bravo, tu viens de gagner la partie!");
		}
		
	System.out.println(this.getNom()+": Vous avez saisi  " + c + " : " + resu+"\n");
	}
	
	protected void retourDefense(Coordonnee c, int etat) {
		//super.getTailleGrille();
		//super.defendre(c);
		afficher();
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
		
		System.out.println(this.getNom()+": Votre adversaire a saisi  " + c + " : " + resu);		
	}
	
	
	
	
	public Coordonnee choisirAttaque() {
		Coordonnee coordAttaquee = null;
		while (coordAttaquee == null) {
			Scanner sc = new Scanner(System.in);
			System.out.println(this.getNom()+" Ou souhaitez vous attaquer l'ennemi?");
			String stringCoord = sc.next();
			try {
				coordAttaquee = new Coordonnee(stringCoord);
				if ((coordAttaquee.getColonne() + 1 > this.getTailleGrille())
						|| (coordAttaquee.getLigne() + 1 > this.getTailleGrille())) {
					coordAttaquee = null;
					System.out.println("Votre tentative est hors des eaux de la bataille. Rйessayez:");
				}
			} catch (IllegalArgumentException e) {
				System.out.println("Votre tentative est hors des eaux de la bataille. Rйessayez:");
			}
		}
		return coordAttaquee;
	}

 
	

	public static void main(String[] args) {
		
		int[] tab = { 1, 1, 1 };
		GrilleNavale Gr1 = new GrilleNavale(4,tab);
		GrilleNavale Gr2 = new GrilleNavale(4,tab);
		
		JoueurTexte a = new JoueurTexte(Gr1,"Vitalii");
		
		//JoueurTexte b = new JoueurTexte(Gr2,"Pierre");
		//JoueurAuto b = new JoueurAuto(Gr2,"Pierre");
		JoueurAutoFacille b = new JoueurAutoFacille(Gr2,"Pierre");
		
		System.out.println(Gr1.toString());
//		for (int i = 0; i < Gr1.navires.length; i++) {
//			System.out.println(Gr1.navires[i]);
//		}
		
		System.out.println(Gr2.toString());
		
		
		a.jouerAvec(b);
		System.out.println(Gr2.toString());
	
		
		
		
	}

	
	
	
	
	
	
	
	
	
}

