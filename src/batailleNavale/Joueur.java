package batailleNavale;

public abstract class Joueur {
	
	public final static int TOUCHE = 1;
	public final static int COULE = 2;
	public final static int A_L_EAU = 3;
	public final static int GAMEOVER = 4;
	
	private Joueur adversaire;
	private int tailleGrille;
	private String nom;
	
	
	
	public Joueur(int tailleGrille, String nom) {
		//permet d'obtenir un joueur de nom nom et jouant sur une grille de taille taillegrille.
		this.nom = nom;
		this.tailleGrille = tailleGrille;
		
				
	}
	//
	public Joueur(int tailleGrille) {
		//permet d'obtenir un joueur de nom nom et jouant sur une grille de taille taillegrille.
		this.tailleGrille = tailleGrille;
		 this.nom="joueur";
	
	}
	
	public int getTailleGrille() {
		//Accesseur en lecture pour tailleGrille.
		return this.tailleGrille;
	}
	
	public String getNom() {
		//Accesseur en lecture pour nom.
		return this.nom;
		}
	
	public void jouerAvec(Joueur j) {
		//	D�marre une partie contre j. Avant de lancer le d�roulement du jeu, il faut veiller � �tablir
		//	le lien entre les 2 joueurs et bien entendu v�rifier qu�il puisse �tre �tabli.
			
		    this.adversaire = j;
			j.adversaire = this;
	
		deroulementJeu (this,j);
		
	}
	
	private static void deroulementJeu(Joueur attaquant, Joueur defenseur) {
		int res = 0;
		while (res != GAMEOVER) {
		Coordonnee c = attaquant.choisirAttaque();
		res = defenseur.defendre(c);
		attaquant.retourAttaque(c, res);
		defenseur.retourDefense(c, res);
		Joueur x = attaquant;
		attaquant = defenseur;
		defenseur = x;
		}
		}
//-------------1.3 Explications pour les m�thodes abstraites.
	
	 protected abstract void retourAttaque(Coordonnee c, int etat);
	//	Cette m�thode est invoqu�e sur le joueur attaquant � la fin d�un tour de jeu. c est la
	//	coordonn�e � laquelle le tir a eu lieu et etat le r�sultat de l'attaque. etat ne peut �tre que
	//	TOUCHE, COULE, A_L_EAU, ou GAMEOVER.
	
	 protected abstract void retourDefense(Coordonnee c, int etat);
	//	Cette m�thode est invoqu�e sur le joueur defenseur � la fin d�un tour de jeu. c est la
	//	coordonn�e � laquelle le tir a eu lieu et etat le r�sultat de ce tir. etat ne peut �tre que
	//	TOUCHE, COULE, A_L_EAU, ou GAMEOVER.
	
	 public abstract Coordonnee choisirAttaque();
	//	Cette m�thode est invoqu�e sur le joueur attaquant au d�but d�un tour de jeu. Elle retourne
	//	la coordonn�e cible du tir effectu� par l�attaquant.
	
	 public abstract int defendre(Coordonnee c);
	//	Cette m�thode est invoqu�e sur le joueur d�fenseur apr�s le choix de l�attaquant, c est la
	//	coordonn�e � laquelle l�attaquant a choisi d�effectuer un tir. Elle retourne le r�sultat du tir
	//	qui ne peut �tre que TOUCHE, COULE, A_L_EAU, ou GAMEOVER.
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		
		
	}

}
