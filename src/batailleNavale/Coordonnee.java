package batailleNavale;

public class Coordonnee implements Comparable<Coordonnee> {
	private int ligne;
	private int colonne;
	private static final char caractInitial = 'A';

	public Coordonnee(int ligne, int colonne) {
		// obtenir les coordonnees de la ligne et de la colonne
		if ((colonne < 0 || colonne > 25) || (ligne  < 0 || ligne > 25)) {
			throw new IllegalArgumentException("Only Positive Numbers");
		}
		this.ligne = ligne;
		this.colonne = colonne;
	}

	public Coordonnee(String s) {
		// obtenir une coordonnees d'après son expression donnee par s dans le systeme
		// de coordonnees de la bataille navale
		s = s.toUpperCase();
		if (s == null) {
			throw new NullPointerException("Paramètre égale à null");
		}
		if (s == "") {
			throw new NullPointerException("Paramètre égale à vide");
		}
		if (s.length() > 3) {
			throw new IllegalArgumentException("Paramètres incorrects");
		} else {
			if ((s.charAt(0) < 65 || s.charAt(0) > 90)) {
				throw new NumberFormatException("Paramètres incorrects ->Colonne ");
			} else if (Integer.parseInt(s.substring(1, s.length())) > 26
					|| Integer.parseInt(s.substring(1, s.length())) < 0) {
				throw new IllegalArgumentException("Paramètres incorrects -> Ligne");
			} else {

				colonne = s.charAt(0) - caractInitial;
				String ligne = s.substring(1, s.length());
				this.ligne = Integer.parseInt(ligne)-1;
			}
		}
	}

	public String toString() {
	// retourne une string exprimant this dans le systeme de coordonnees de la bataille navale ("C5")
		String st = new String();
		st = "";
		char c = (char) (this.colonne + caractInitial );//caractInitial
		st = st + c + (this.ligne+1);
		return st;
	}

	public int getLigne() {
		//Accesseur en lecture  de l'indice ligne
		return this.ligne;
	}

	public int getColonne() {
		//Accesseur en lecture  de l'indice colonne
		return this.colonne;

	}

	public boolean equals(Object obj) {
		//retourne true si et seulement si this est équivalent à obj
		if (obj instanceof Coordonnee) {
			Coordonnee c = (Coordonnee) obj;
			if ((this.ligne == c.ligne) && (this.colonne == c.colonne)) {
				return true;
			}
		}
		return false;

	}

	public boolean voisine(Coordonnee c) {
		//retourne true si et seulement si this est une coordonnees voisine de c 
		//(verticalement ou horizontalement)
		if (((this.colonne == c.getColonne()) && (Math.abs(this.ligne - c.getLigne()) == 1))

				|| ((this.ligne == c.getLigne()) && (Math.abs(this.colonne - c.getColonne()) == 1))) {

			return true;

		} else {

			return false;

		}

	}

	public int compareTo(Coordonnee c) {

		if (this.ligne < c.getLigne() || this.colonne < c.getColonne()) {
			return -1;
		} else if (this.ligne > c.getLigne() || this.colonne > c.getColonne()) {
			return 1;
		}
		return 0;
	}

	public static void main(String[] args) {

		// TODO Auto-generated method stub
//		Coordonnee c1, c2;
//		c1 = new Coordonnee(2, 2);
//		System.out.println(c1.getLigne());
//		System.out.println(c1.getColonne());
//		c2 = new Coordonnee("B2");
//		System.out.println(c2);
//		char b = '?';
//		int c = b+1;
//		System.out.println(c);
//		c3 = new Coordonnee(1, 1);
//		c4 = new Coordonnee(2, 10);
//		System.out.println(c2.voisine(c1));
//		System.out.println(c3.compareTo(c4));

		System.out.println("-------------A10----------------");
		Coordonnee c = new Coordonnee ("A10");
		System.out.println("c ligne :"+ c.getLigne());
		System.out.println(c.getLigne()== 9);
		System.out.println("c colonne : "+ c.getColonne());
		System.out.println(c.getColonne()== 0);
		System.out.println("-------------------C5---------------------");
		Coordonnee c1 = new Coordonnee ("C5");
		System.out.println("C1 ligne :"+ c1.getLigne());
		System.out.println(c1.getLigne()== 4);
		System.out.println("c1 colonne: "+c1.getColonne());
		System.out.println(c1.getColonne()== 2);
		System.out.println("-------------------TOTO---------------------");
		try {
		Coordonnee c2 = new Coordonnee ("toto");
		System.out.println(false);
		}catch (Exception e) {
		System.out.println(true);
		System.out.println("-------------------D8---------------------");
		Coordonnee c3 = new Coordonnee ("D8");
		System.out.println(c3.toString().contentEquals("D8"));
		System.out.println(c3.toString());
	}

}
}