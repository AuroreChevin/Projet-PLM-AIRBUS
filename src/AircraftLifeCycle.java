import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
/**
 * Réalisation d'une application de gestion du cycle de vie d'avions AIRBUS.
 * @author ChevinA
 * @since 1.0
 * @version 1.0
 * La classe AircraftLifeCycle contient l'essentiel du programme.
 */
public class AircraftLifeCycle {
	/**
	 * Méthode permettant d'afficher la HashMap contenant une ArrayList
	 * @param hMap est une HashMap prenant en paramètres un Integer et une ArrayList de String.
	 */
	public static void disPlanes(HashMap<Integer, ArrayList<String>> hMap) {
		hMap.forEach((key,value)->System.out.println(key+ ":" +value));
	}
	/**
	 * Méthode permettant d'afficher un tableau à 2 dimensions.
	 * @param tab est un tableau à 2 dimensions de string.
	 */
	public static void disComponents(String[][] tab) {
		for(int i = 0; i<tab.length; i++) {
			System.out.print(i+1+ " : ");
			for(int j = 0; j<tab[i].length; j++) {
				System.out.print(tab[i][j]+" ");
			}
			System.out.println();
		}
	}
	/**
	 * Méthode permettant d'ajouter un élement choisi par un utilisateur, à une l'ArrayList de la hashMap
	 * @param scan 
	 * @param str tableau de String à 2 dimensions. 
	 * @param hMap est une HashMap prenant en paramètres un Integer et une ArrayList de String.
	 */
	public static void addComponent(Scanner scan, String[][] str, HashMap<Integer, ArrayList<String>> hMap) {
		int nbcomponent = 0;
		int nbPlane = scan.nextInt();
		System.out.println("\nVoici les pièces que nous vous proposons :");
		disComponents(str);
		System.out.println("Quelle pièce choisissez-vous ? Veuillez saisir le chiffre correspondant à la pièce :");
		nbcomponent = scan.nextInt();
		String choiceComponent = str[nbcomponent-1][0];
		hMap.get(nbPlane).add(choiceComponent);
	}
	
	public static boolean yes(String str) {
		if(str.equals(str))return true;
		else return false;
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int chMenu = 0; String word = ""; String answer = "oui";
		String [][] components = {{"harnais", "électrique", "221€"},
									{"valve", "hydraulique", "598€"},
									{"capteur", "pression", "1000"},
									{"frein", "pression", "850"}};
		ArrayList<String> plane1 = new ArrayList<String>(Arrays.asList("A300","faisisabilité","fret"));
		ArrayList<String> plane2 = new ArrayList<String>(Arrays.asList("A320","en service","passager"));
		ArrayList<String> plane3 = new ArrayList<String>(Arrays.asList("A400M","conception","militaire"));
		ArrayList<String> plane4 = new ArrayList<String>(Arrays.asList("ACJ330","construction","affaires"));
		ArrayList<String> plane5 = new ArrayList<String>(Arrays.asList("A350","conception","passager"));
		HashMap<Integer, ArrayList<String>> planes = new HashMap<Integer, ArrayList<String>>();
		planes.put(1, plane1);
		planes.put(2, plane2);
		planes.put(3, plane3);
		planes.put(4, plane4);
		planes.put(5, plane5);
		// 1.2 Titre appli
		System.out.println("Bienvenue dans l'application de gestion du cycle des avions AIRBUS.\n"
				+ "Choisissez ce que vous voulez faire en saisissant le chiffre correspondant\n");
	//   Interaction avec utilisateur pour demander ce qu'il veut (affichage d'un menu avec diff choix)
			// si interaction repose sur entrée chiffre il faut qu'il soit entre 1 et 5, gérer les entrées non valides 
			// et redemander son choix
		while(chMenu > 5 || chMenu == 0){
			System.out.println("1 : Affichage de tous les avions.\n"
					+ "2 : Affichage d'un liste d'avions à partir d'un mot saisi\n"
					+ "3 : Ajout ou suppression d'une pièce pour un avion\n"
					+ "4 : Affichage de toutes les pièces d'un avion donné\n"
					+ "5 : Quitter l'application");		
			while(scan.hasNextInt()==false) scan.next();		
			chMenu = scan.nextInt();
			switch(chMenu) {
			case 1 : //choix 1: afficher la liste des avions
				System.out.println();
				disPlanes(planes);
				break;
			case 2 : //choix 2: afficher les avions à partir d'un mot clef
				scan.nextLine();
				System.out.println("\nSaisissez une lettre ou un nombre "
						+ "pour afficher la liste des avions correspondant à cette saisie :");
				word = scan.nextLine();						
				for(Integer key : planes.keySet()) {
					if(planes.get(key).get(0).contains(word.toUpperCase())) {
						System.out.println(planes.get(key).get(0));}}							
				break;
			case 3 : //choix 3: ajout ou suppression d'un pièce
				while(answer.equalsIgnoreCase("oui")) {							
					System.out.println("\nSur quel avion voulez vous ajouter une pièce ?");
					disPlanes(planes);
					addComponent(scan, components, planes);
					scan.nextLine();
					System.out.println("Voulez-vous ajouter une autre pièce (oui/non) ? :");
					answer = scan.nextLine();
				}
				System.out.println("ok"); 						
				break;
			case 4 : //choix 4: affichant toutes les pièces

				break;
			case 5 : System.out.println("Merci, d'avoir utilisé cette application");
				break;
			default : System.out.println("Je n'ai pas compris votre choix. Veuillez saisir un chiffre :");
				break;			
			}
		}		
		scan.close();
	}
	
	
	
}
