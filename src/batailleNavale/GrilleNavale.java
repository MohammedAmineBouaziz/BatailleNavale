package batailleNavale;

public class GrilleNavale {
	public Navire[] navires;
	private int nbNavires;
	private int taille;
	public Coordonnee[] tirsRecus;
	private int nbTirsRecus;

	public GrilleNavale(int taille, int[] taillesNavires) {
		this.taille = taille;
		navires = new Navire[taillesNavires.length];
		this.nbNavires = 0;
		nbTirsRecus = 0;
		tirsRecus = new Coordonnee[taille * taille];

		placementAuto(taillesNavires);

	}

	public GrilleNavale(int taille, int nbNavires) {
		if (taille < 0 || (taille + 1) * (taille + 1) < nbNavires || nbNavires < 0) {
			throw new IllegalArgumentException("la taille ou le nbNavires est incorrects");

		}
		this.taille = taille;
		this.nbNavires = 0;
		navires = new Navire[nbNavires];
		nbTirsRecus = 0;
		tirsRecus = new Coordonnee[taille * taille];

	}

	public String toString() {
		String str = new String();
		str = "";
//		for (int i = 0; i < 1 ; i++) {
//			for (int j = 0; j <= taille; j++) {
//				char c = (char) ('A' + j);
//				str = str + " " + c ;
//			}
//			str = str + "\n";
//			int n = i + 1;
//			str = str + n;
//		}
//		for (int i = 0; i <  taille ; i++) {
//			for (int j = 0; j <= 1; j++) {
//				
//			}
//			str = str + "\n";
//			int n = i + 1;
//			str = str + n;
//		}

		String[][] tab = new String[taille + 1][taille + 1];
		tab[0][0] = " ";

		for (int i = 0; i < 1; i++) {
			for (int j = 1; j < tab.length; j++) {
				char c = (char) ('A' + j - 1);
				String str2 = new String();
				if (c == 'A') {

					str2 = " " + c;
				} else {
					str2 = "" + c;
				}

				tab[i][j] = str2;
			}
		}

		for (int i = 1; i < tab.length; i++) {
			String str3 = new String();
			if (i < 10)
				str3 = " " + i;
			else
				str3 = "" + i;
			tab[i][0] = str3;
		}

		for (int i = 1; i < tab.length; i++) {
			for (int j = 1; j < tab[i].length; j++) {
				String str2 = new String();
				str2 = ".";
				tab[i][j] = str2;
			}
		}

		/* To#################################################### */

		for (int i = 0; i < nbNavires; i++) {
			int linDeb = navires[i].getDebut().getLigne();
			int colDeb = navires[i].getDebut().getColonne();

			int linFin = navires[i].getFin().getLigne();
			int colFin = navires[i].getFin().getColonne();

			if (colDeb == colFin) {

				for (int j = linDeb; j <= linFin; j++) {

					tab[j + 1][colDeb + 1] = "#";
				}
			} else {
				for (int k = colDeb; k <= colFin; k++) {
					tab[linDeb + 1][k + 1] = "#";
				}

			}

		}

		/* OOOOOOOOOOOOOOOOOOOOOOOXXXXXXXXXXXXXXXXXXXXXXXXXXXXX */

		for (int i = 0; i < nbTirsRecus; i++) {
			int lindeb = tirsRecus[i].getLigne();
			int coldeb = tirsRecus[i].getColonne();

			if (estTouche(tirsRecus[i])) {
				tab[lindeb + 1][coldeb + 1] = "X";
			} else {
			tab[lindeb + 1][coldeb + 1] = "O";
			}
		}

		/* OOOOOOOOOOOOOOOOOOOOOOOXXXXXXXXXXXXXXXXXXXXXXXXXXXXX */

		for (int i = 0; i < tab.length; i++) {
			for (int j = 0; j < tab[i].length; j++) {
				str = str + " " + tab[i][j];
			}
			str = str + "\n";
		}

		return str;
	}

	public int getTaille() {
		return this.taille;
	}

	public boolean ajouteNavire(Navire n) {

		if (!estDansGrille(n.getDebut()) || !estDansGrille(n.getFin())) {
			/////
			System.out.println("En dehors de la grille");
			return false;
		}

		for (int i = 0; i < nbNavires; i++) {
			if ((navires[i].touche(n) || navires[i].chevauche(n))) {
				return false;
			}

		}
		this.navires[nbNavires] = n;
		this.nbNavires++;
		return true;

	}

	public void placementAuto(int[] taillesNavires) {
		for (int i = 0; i < taillesNavires.length; i++) {
			Navire n1 = new Navire(new Coordonnee((int) (Math.random() * taille), (int) (Math.random() * taille)),
					taillesNavires[i], Math.random() < 0.5);
			while (this.ajouteNavire(n1) == false) {
				n1 = new Navire(new Coordonnee((int) (Math.random() * taille), (int) (Math.random() * taille)),
						taillesNavires[i], Math.random() < 0.5);
			}

		}
	}

	private boolean estDansGrille(Coordonnee c) {
		if ((c.getColonne() > this.taille - 1) || (c.getLigne() > this.taille - 1)) {
			return false;
		}
		return true;

	}

	public boolean estDansTirsRecus(Coordonnee c) {
		if (nbTirsRecus != 0) {
			for (int i = 0; i < nbTirsRecus; i++) {
				if (this.tirsRecus[i].equals(c)) {
					return true;
				}
			}
		}
		return false;

	}

	private boolean ajouteDansTirsRecus(Coordonnee c) {
		if (this.estDansTirsRecus(c))
			return false;
		else {

			tirsRecus[nbTirsRecus] = c;
			nbTirsRecus = nbTirsRecus + 1;

			return true;
		}

	}

	public boolean recoitTir(Coordonnee c) {

		for (int i = 0; i < nbTirsRecus; i++)

			if (tirsRecus[i].equals(c))

				return false;
		tirsRecus[nbTirsRecus] = c;
		nbTirsRecus++;

		for (int i = 0; i < nbNavires; i++) {

			if (navires[i].recoitTir(c)) {

				return true;
			}
		}
		return false;
	}

	public boolean estTouche(Coordonnee c) {
		if (this.estDansGrille(c)) {
			for (int i = 0; i < nbNavires; i++) {
				if (navires[i].estTouche(c)) {
					return true;
				}
			}
			return false;
		} else
			return false;

	}

	public boolean estALEau(Coordonnee c) {
		if (this.estDansGrille(c)) {
			for (int i = 0; i < nbNavires; i++) {
				if (navires[i].estTouche(c)) {
					return false;
				}
			}
			return true;
		} else
			return false;

	}

	public boolean estCoule(Coordonnee c) {
		if (this.estDansGrille(c) && this.estTouche(c)) {
			for (int i = 0; i < nbNavires; i++) {
				if (navires[i].contient(c) && navires[i].estCoule()) {
					return true;
				}
			}
			return false;
		} else
			return false;

	}

	public boolean perdu() {
		for (int i = 0; i < nbNavires; i++) {
			if (!navires[i].estCoule()) {
				return false;
			}
		}
		return true;

	}

	public static void main(String[] args) {

//		int tab[] = { 2, 3, 4 };
//
//		GrilleNavale G22 = new GrilleNavale(10, 2);
//		Coordonnee n = new Coordonnee("I6");
//		Coordonnee n1 = new Coordonnee("A4");
//		Navire v = new Navire(n, 2, true);
//		Navire f = new Navire(n1, 3, true);
//		System.out.println("\n");
//
//		System.out.println("############################################\n");
//
//		int tab1[] = { 2, 3, 4 };
//
//		GrilleNavale G21 = new GrilleNavale(9, 4);
//		System.out.println(G21.getTaille());
//		G21.placementAuto(tab1);
//
//		///////////
//		for (int i = 0; i < G21.nbNavires; i++)
//			System.out.println(G21.navires[i]);
//
//		System.out.println(G21);
//
//		Coordonnee n3 = new Coordonnee("C4");
//		Coordonnee n10 = new Coordonnee("F6");
//		Coordonnee n4 = new Coordonnee("H3");
//
//		System.out.print(G21.recoitTir(n3) + "  ");
//		System.out.print(G21.recoitTir(n10) + "  ");
//		System.out.print(G21.recoitTir(n4) + "  ");
//
//		System.out.println("---------------------------------------");
//
//		System.out.println(G21);

	}

}