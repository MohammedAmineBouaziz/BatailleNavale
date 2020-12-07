package batailleNavale;

public abstract class JoueurAvecGrille extends Joueur {
	private GrilleNavale grille;

	public JoueurAvecGrille(GrilleNavale g, String nom) {
		super(g.getTaille(), nom);
		this.grille = g;

	}

	public JoueurAvecGrille(GrilleNavale g) {
		super(g.getTaille());
		this.grille = g;
	}

	public String toString() {
		return grille.toString();
	}

	public boolean ext(Coordonnee c) {
		return grille.estDansTirsRecus(c);

	}

	public int defendre(Coordonnee c) {
		this.grille.recoitTir(c);

		if (this.grille.estALEau(c)) {// si on est tire dans l'eau
			return 3;
		} else if (this.grille.estCoule(c)) { // si le bateau est couler
			if (this.grille.perdu()) {
				return 4; // soit on est perdu
			} else {
				return 2; // soit juste bateau qui a coule et en continue la partie
			}
		} else {
			return 1; // on a touche le bateau
		}
	}

}
