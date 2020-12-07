package batailleNavale;

public class testCordonne {

	public static void TestCordonneNavire() {
		 System.out.println("--------------Test de Constructeur-------------");
		
		 System.out.print("test parametre null: ");
		 try{
			new Coordonnee(null);
			System.out.println("NON");
			
		 } catch (NullPointerException e) {
			 System.out.println("OK");
		 }
		 
		 try {
				System.out.println("test Coordonnee (0,-1)");
				Coordonnee test2 = new Coordonnee(0, -1);
				System.out.println("Non : pas d'exception levée"+ "\n"); 
			} catch (IllegalArgumentException e) {
				System.out.println("OK (exception ->" + e.getMessage() +")"+ "\n");
			}
		// (-1,0)
			try {
				System.out.println("test Coordonnee (-1,0)");
				Coordonnee test3 = new Coordonnee(-1, 0);
				System.out.println("Not OK -> pas d'exception levée"+ "\n");
			} catch (IllegalArgumentException e) {
				System.out.println("OK (exception ->" + e.getMessage() + ")"+ "\n");
			}		
			// (-1,-1)
			try {
				System.out.println("test Coordonnee (-1,-1)");
				Coordonnee test4 = new Coordonnee(-1, -1);
				System.out.println("Not OK -> pas d'exception levée"+ "\n");

			} catch (IllegalArgumentException e) {
				System.out.println("OK (exception :" + e.getMessage() + ")"+ "\n");
			}
			// (26,0)
			try {
				System.out.println("test du constructeur incorrecte Coordonnee (26,0)");
				Coordonnee test5 = new Coordonnee(26, 0);
				System.out.println("Not OK -> pas d'exception levée"+ "\n");

			} catch (IllegalArgumentException e) {
				System.out.println("OK (exception -> " + e.getMessage() + ")"+ "\n");
			}
			// (0, 26)
			try {
				System.out.println("test Coordonnee (0,26)");
				Coordonnee test6 = new Coordonnee(0, 26);
				System.out.println("Not OK -> pas d'exception levée"+ "\n");

			} catch (IllegalArgumentException e) {
				System.out.println("OK (exception -> " + e.getMessage() + ")"+ "\n");
			}
			// (26, 26)
			try {
				System.out.println("test Coordonnee (26,26)");
				Coordonnee test7 = new Coordonnee(26, 26);
				System.out.println("Not OK -> pas d'exception levée"+ "\n");
			} catch (IllegalArgumentException e) {
				System.out.println("OK (exception -> " + e.getMessage() + ")"+ "\n");
			}

			
			System.out.println(">>Test du deuxième constructeur : parametres String"+ "\n");
		
			
			// "AA"
			try {
				System.out.println("Test Coordonnee (\"AA\")");
				Coordonnee test9 = new Coordonnee("AA");
				System.out.println("Not OK -> pas d'exception levée"+ "\n");
			} catch(IllegalArgumentException e) {
				System.out.println("OK (exception -> " + e.getMessage() + ")"+ "\n");
			}
			// "1A"
			try {
				System.out.println("Test Coordonnee (\"1A\")");
				Coordonnee test10 = new Coordonnee("1A");
				System.out.println("Not OK -> pas d'exception levée"+ "\n");
			} catch(IllegalArgumentException e) {
				System.out.println("OK (exception -> " + e.getMessage() + ")"+ "\n");
			}
			// "11"
			try {
				System.out.println("Test Coordonnee (\"11\")");
				Coordonnee test11 = new Coordonnee("11");
				System.out.println("Not OK -> pas d'exception levée"+ "\n");
			} catch(IllegalArgumentException e) {
				System.out.println("OK (exception -> " + e.getMessage() + ")"+ "\n");
			}
			// "A27"
			try {
				System.out.println("Test Coordonnee (\"A27\")");
				Coordonnee test12 = new Coordonnee("A27");
				System.out.println("Not OK -> pas d'exception levée"+ "\n");
			} catch(IllegalArgumentException e) {
				System.out.println("OK (exception -> " + e.getMessage() + ")"+ "\n");
			}
			// "00"
			try {
				System.out.println("Test Coordonnee (\"00\")");
				Coordonnee test13 = new Coordonnee("00");
				System.out.println("Not OK -> pas d'exception levée"+ "\n");
			} catch(IllegalArgumentException e) {
				System.out.println("OK (exception -> " + e.getMessage() + ")"+ "\n");
			}
			// "A0"
			try {
				System.out.println("Test Coordonnee (\"A0\")");
				Coordonnee test14 = new Coordonnee("A0");
				System.out.println("Not OK -> pas d'exception levée"+ "\n");
			} catch(IllegalArgumentException e) {
				System.out.println("OK (exception -> " + e.getMessage() + ")"+ "\n");
			}
			// "0"
			try {
				System.out.println("Test Coordonnee (\"0\")");
				Coordonnee test15 = new Coordonnee("0");
				System.out.println("Not OK -> pas d'exception levée"+ "\n");
			} catch(IllegalArgumentException e) {
				System.out.println("OK (exception -> " + e.getMessage() + ")"+ "\n");
			}
			// "0A"
			try {
				System.out.println("Test Coordonnee (\"0A\")");
				Coordonnee test16 = new Coordonnee("0A");
				System.out.println("Not OK ->  pas d'exception levée"+ "\n");
			} catch(IllegalArgumentException e) {
				System.out.println("OK (exception -> " + e.getMessage() + ")"+ "\n");
			}	
			// "cool"
			try {
				System.out.println("Test Coordonnee (\"cool\")");
				Coordonnee test17 = new Coordonnee("cool");
				System.out.println("Not OK -> pas d'exception levée"+ "\n");
			} catch(IllegalArgumentException e) {
				System.out.println("OK (exception -> " + e.getMessage() + ")"+ "\n");
			}		
			System.out.println(">>Termine test du constructeur \n");

			
		}
   
		
	public static void TestMethode() {
		
	}
	

	public static void main(String[] args) {
		TestCordonneNavire();
		

	}

}
