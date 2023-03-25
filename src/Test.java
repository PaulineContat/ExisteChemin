
public class Test {

	public static void main(String[] args) {
		Labyrinthe l = new Labyrinthe();
		System.out.println(l.toString());
		boolean chemin=l.existeChemin(1, 8);	
		System.out.println(chemin);
		System.out.println(l.afficherChemin());
	}
}
