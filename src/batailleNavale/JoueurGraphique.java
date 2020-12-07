package batailleNavale;

import java.awt.Color;
import java.awt.EventQueue;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.JOptionPane;

public class JoueurGraphique extends JoueurAvecGrille {
	private GrilleGraphique grilleTirs;
	
	public JoueurGraphique(GrilleNavaleGraphique grilleDefense, GrilleGraphique grilleTirs, String nom) {
		super(grilleDefense,nom);
		this.grilleTirs=grilleTirs;
	}
	
	public JoueurGraphique(GrilleNavaleGraphique grilleDefense, GrilleGraphique grilleTirs) {
		super(grilleDefense);
		this.grilleTirs=grilleTirs;
	}

	public Coordonnee choisirAttaque() {
		return this.grilleTirs.getCoordonneeSelectionnee();
	}

	protected void retourDefense(Coordonnee c, int etat) {
		
		switch (etat) {
		case TOUCHE:
			JOptionPane.showMessageDialog(grilleTirs, "L'ennemi a touché un navire en " + c);
			break;
		case COULE:
			JOptionPane.showMessageDialog(grilleTirs, "L'ennemi a coulé un navire en " + c);
			break;
		case GAMEOVER:
			JOptionPane.showMessageDialog(grilleTirs, "Vous avez PERDU...");
		}
	}

	protected void retourAttaque(Coordonnee c, int etat) {
		Color couleur = etat == A_L_EAU ? Color.BLUE : Color.RED;
		grilleTirs.colorie(c, couleur);
		switch (etat) {
		case TOUCHE:
			JOptionPane.showMessageDialog(grilleTirs, "Vous avez touche un navire en " + c);
			break;
		case COULE:
			JOptionPane.showMessageDialog(grilleTirs, "Vous avez coulé un navire en " + c);
			break;
		case GAMEOVER:
			JOptionPane.showMessageDialog(grilleTirs, "Vous avez GAGNE !!!");
		}
	}
}