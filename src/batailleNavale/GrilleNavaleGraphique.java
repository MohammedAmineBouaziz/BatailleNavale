package batailleNavale;

import java.awt.Color;

public class GrilleNavaleGraphique extends GrilleNavale {

	private GrilleGraphique grille;

	public GrilleNavaleGraphique(int taille) {
		super(taille, taille);// nombre navires = grille
		   grille = new GrilleGraphique(taille);
		  // grille.setClicActive(false);
	
	}
	
	
	public GrilleGraphique getGrilleGraphique() {
		//Accesseur en lecture pour grille.
		return grille;
		
		}

	public boolean ajouteNavire(Navire n) {
		if (super.ajouteNavire(n)) {
			grille.colorie(n.getDebut(), n.getFin(), Color.GREEN);
			return true;
		}else return false;
		
	}

	public boolean recoitTir(Coordonnee c) {
		// Sp�cialisation de la m�thode h�rit�e de GrilleNavale.
		// La case correspondant au tir doit �tre colori�e en Color.RED si le tir a
		// touch� un navire ou en Color.BLUE s'il est � l'eau.}
		if (super.recoitTir(c)) {
			grille.colorie(c, Color.RED);
			return true;
		}else {
			grille.colorie(c, Color.BLUE);
			return false;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
