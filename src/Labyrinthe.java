import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import javax.swing.text.html.HTMLDocument.Iterator;

public class Labyrinthe {

	int[][] labyrinthe=
			{
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 0, 0, 0, 0, 1, 1, 0, 1 },
			{ 1, 1, 0, 1, 0, 1, 1, 0, 0, 1 },
			{ 1, 0, 0, 1, 0, 0, 1, 0, 1, 1 },
			{ 1, 0, 1, 0, 0, 1, 1, 0, 0, 1 },
			{ 1, 0, 1, 1, 0, 1, 1, 1, 0, 1 },
			{ 1, 0, 1, 1, 0, 0, 0, 0, 0, 0 },
			{ 1, 0, 0, 0, 0, 1, 1, 1, 1, 1 },
			{ 1, 0, 1, 1, 0, 0, 0, 0, 0, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }};
	

	List<String> chemin = new LinkedList<String>();

	public Labyrinthe() {

	}

	public String toString() {
		String normal="";
		for (int i=0;i<this.labyrinthe.length;i++) {
			for (int j=0;j<this.labyrinthe.length;j++) {
				switch(this.labyrinthe[i][j]) {
				case 1:
					normal+="*";
					break;
				case 2:
					normal+=".";
					break;
				case 0:
					normal+=" ";
					break;
				}
			} 
			normal+="\n";
		}
		return normal;
	}

	public boolean existeChemin(int x, int y) throws IllegalArgumentException {
		if(this.labyrinthe[x][y]==1) {
			throw new IllegalArgumentException("Mur");
		}

		this.labyrinthe[x][y]=2;

		if (x==6 && y==9) {
			return true;
		}

		if (this.labyrinthe[x-1][y]==0) {
			
			if (this.existeChemin(x-1, y)) {
				chemin.add("haut");
				return true;
			}
		}

		if(this.labyrinthe[x+1][y]==0) {
			if(this.existeChemin(x+1, y)) {
				chemin.add("bas");
				return true;
			}
		}

		if(this.labyrinthe[x][y-1]==0) {
			if(this.existeChemin(x, y-1)) {
				chemin.add("gauche");
				return true;
			}
		}

		if(this.labyrinthe[x][y+1]==0) {
			if(this.existeChemin(x, y+1)) {
				chemin.add("droite");
				return true;
			}
		}		
		return false;
	}
	
	public String afficherChemin(){
		String resultat="";
		ListIterator<String> iterator = this.chemin.listIterator(this.chemin.size());
		while(iterator.hasPrevious()) {
			resultat+=iterator.previous();
		}
		return resultat;
	}
}