package batailleNavale;

public class Navire {

	private Coordonnee debut;
	private Coordonnee fin;
	private Coordonnee[] partiesTouchees;
	private int nbTouchees;

	public Navire(Coordonnee debut, int longueur, boolean estVertical) {
		//permet d'obtenir un navire debut
		this.debut = debut;

		if (estVertical) {
			fin = new Coordonnee(debut.getLigne() + longueur - 1, debut.getColonne());
		} else {
			fin = new Coordonnee(debut.getLigne(), debut.getColonne() + longueur - 1);
		}

		partiesTouchees = new Coordonnee[longueur];
		// partiesTouchees[0] = null;
		nbTouchees = 0;

	}
////////////////////////////////////////
	public String toString() {
		String s;
		int longueur;

		if (this.debut.getLigne() == this.fin.getLigne()) {
			s = "Horizontale";
			longueur = this.fin.getColonne() - this.debut.getColonne();

		} else {
			s = "Vertical";
			longueur = this.fin.getLigne() - this.debut.getLigne();

		}

		return "Navire(" + this.debut.toString() + ", " + (longueur+1) + " , " + s + ")";
	}

	public Coordonnee getDebut() {
		return debut;
	}

	public Coordonnee getFin() {
		return fin;
	}
////////////////////////////////////////
	public boolean contient(Coordonnee c) {
		return c.getColonne() >= debut.getColonne() && c.getColonne() <= fin.getColonne()
				&& c.getLigne() >= debut.getLigne() && c.getLigne() <= fin.getLigne();
	}

	public boolean chevauche(Navire n) {
		if (this.debut.getLigne() == this.fin.getLigne()) {

			return n.debut.getColonne() >= this.debut.getColonne() && n.debut.getColonne() <= this.fin.getColonne()
					&& this.debut.getLigne() >= n.debut.getLigne() && this.debut.getLigne() <= n.fin.getLigne();

		} else {

			return n.debut.getLigne() >= this.debut.getLigne() && n.debut.getLigne() <= this.fin.getLigne()
					&& this.debut.getColonne() >= n.debut.getColonne() && this.debut.getColonne() <= n.fin.getColonne();

		}

	}
////////////////////////////////////////
	public boolean estTouche(Coordonnee c) {
		for (int i = 0; i < nbTouchees; i++) {
			if (partiesTouchees[i].equals(c)) {
				return true;
			}
		}
		return false;
	}
////////////////////////////////////////
	public boolean recoitTir(Coordonnee c) {
		if (this.contient(c)) {
			partiesTouchees[nbTouchees] = c;
			nbTouchees++;
			return true;
		}

		return false;
	}
////////////////////////////////////////
	public boolean estTouche() {
		return nbTouchees > 0;
	}
////////////////////////////////////////
	public boolean estCoule() {
		/*
		 * for(int i = 0 ; i <partiesTouchees.length ; i++){ if(partiesTouchees[i]==
		 * null){ return false; } } return false; }
		 */

		return partiesTouchees.length == nbTouchees;

	}
////////////////////////////////////////
	public boolean touche(Navire n) {

		boolean ThisV = this.debut.getColonne() == this.fin.getColonne();
		boolean nV = n.debut.getColonne() == n.fin.getColonne();
		int ColonneThis = this.debut.getColonne();
		int nColonne = n.debut.getColonne();

		if (ThisV && nV) {
			for (int i = this.debut.getLigne(); i <= this.fin.getLigne(); i++) {
				for (int j = n.debut.getLigne(); j <= n.fin.getLigne(); j++) {
					Coordonnee x = new Coordonnee(i, ColonneThis);
					Coordonnee y = new Coordonnee(j, nColonne);
					if (x.voisine(y)) {
						return true;
					}

				}
			}

		} else if (ThisV && !nV) {

			for (int i = this.debut.getLigne(); i <= this.fin.getLigne(); i++) {
				for (int j = n.debut.getColonne(); j <= n.fin.getColonne(); j++) {
					Coordonnee x = new Coordonnee(i, this.debut.getColonne());
					Coordonnee y = new Coordonnee(n.debut.getLigne(), j);
					if (x.voisine(y)) {
						return true;
					}

				}
			}

		} else if (!ThisV && nV) {
			for (int i = this.debut.getColonne(); i <= this.fin.getColonne(); i++) {
				for (int j = n.debut.getLigne(); j <= n.fin.getLigne(); j++) {
					Coordonnee x = new Coordonnee(this.debut.getLigne(), i);
					Coordonnee y = new Coordonnee(j, n.debut.getColonne());
					if (x.voisine(y)) {
						return true;
					}

				}
			}

		} else if (!ThisV && !nV) {
			for (int i = this.debut.getColonne(); i <= this.fin.getColonne(); i++) {
				for (int j = n.debut.getColonne(); j <= n.fin.getColonne(); j++) {
					Coordonnee x = new Coordonnee(this.debut.getLigne(), i);
					Coordonnee y = new Coordonnee(n.debut.getLigne(), j);
					if (x.voisine(y)) {
						return true;
					}

				}
			}

		}
		return false;
	}



	public static void main(String[] args) {
		Coordonnee n = new Coordonnee("D3");
		Coordonnee n1 = new Coordonnee("E1");
		Navire v = new Navire(n,3,true);
		Navire f = new Navire(n1,3,true);
  	    System.out.print(v);
	}

}
