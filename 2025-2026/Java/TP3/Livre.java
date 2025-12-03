package tp3;
import java.util.Collections;

public class Livre extends Article {
    private String ISBN;
    private int nbPages;
    public static enum CHAMPS {
	DESC("Description"), PRIX_INITIAL("Prix initial de vente"),
	NB_EX("Nombre d'exemplaires"), CODE("ISBN"), NB_PAGES("Nombre de pages");

	private final String toString;

	CHAMPS(String x){ this.toString = x; }
	
	@Override
	public String toString(){ return toString; }
    }
    
    public Livre(String description, double prixInitialVente, int nbExemplaires, String ISBN, int nbPages){
	super(description, prixInitialVente, nbExemplaires);
	this.ISBN = ISBN;
	this.nbPages = nbPages;
    }
    
    public Livre(String description, String ISBN, int nbPages){
	super(description);
	this.ISBN = ISBN;
	this.nbPages = nbPages;
    }
    
    public String getISBN(){ return ISBN; }
    public int getNbPages(){ return nbPages; }
    
    public void setISBN(String x){ ISBN = x; }
    public void setNbPages(int x){ nbPages = x; }
    
    @Override
    public String toString(){
	int[] lengths = printArticleLengths();
	String separator = "%n" + "-".repeat(lengths[0] + lengths.length - 1) + "%n";
	return String.format(
	    separator
	    + "%-" + lengths[1] + "s %-" + lengths[2] + "s %-" + lengths[3] + "s %-" + lengths[4] + "s %-" + lengths[5] + "s"
	    + separator
	    + "%-" + lengths[1] + "s %-" + lengths[2] + "s %-" + lengths[3] + "s %-" + lengths[4] + "s %-" + lengths[5] + "s%n"
	    + separator,
	    CHAMPS.DESC, CHAMPS.PRIX_INITIAL, CHAMPS.NB_EX, CHAMPS.CODE, CHAMPS.NB_PAGES,
	    getDescription(), super.getPrixInitialVente(), super.getNbExemplaires(), getISBN(), getNbPages()
	);
    }
    
    //Calcul pour déterminer de combien caractères il faut décaler la prochaine colonne
    public int[] printArticleLengths(){
	int[] lengths = new int[6];
	//Description
	lengths[1] = Math.max(CHAMPS.DESC.toString().length(), getDescription().length()) + 1;
	//Prix initial
	lengths[2] = Math.max(CHAMPS.PRIX_INITIAL.toString().length(), Double.toString(super.getPrixInitialVente()).length()) + 1;
	//Nombre d'exemplaires
	lengths[3] = Math.max(CHAMPS.NB_EX.toString().length(), Integer.toString(super.getNbExemplaires()).length()) + 1;
	//ISBN
	lengths[4] = Math.max(CHAMPS.CODE.toString().length(), getISBN().length())+ 1;
	//Nombre de pages
	lengths[5] = Math.max(CHAMPS.NB_PAGES.toString().length(), Integer.toString(getNbPages()).length()) + 1;
	//Calcul du maximum entre les différentes propriétés pour le séparateur
	lengths[0] = 0;
	for (int l : lengths) {
	    lengths[0] += l;
	}
	return lengths;
    }
    @Override
    public String getNumero() {
        return this.getISBN(); 
    }

}
