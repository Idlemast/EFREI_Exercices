
import java.util.ArrayList;



/**
 *
 * @author William
 */
public class Manuel extends Article {
    private String ISBN;
    private int nbPages;
    private Matiere matiere;
    private Niveau niveau;
    public enum Matiere {
	FR("Français"),
	EN("Anglais"),
	ES("Espagnol"),
	MATHS("Mathématiques"),
	BIO("Biologie"),
	INFO("Informatique");

	private final String toString;

	Matiere(String x) { this.toString = x; }
	
	@Override
	public String toString(){ return toString; }
    }
    public enum Niveau {
	CP("CP"), CE1("CE1"), CE2("CE2"),
	CM1("CM1"), CM2("CM2"), C6e("6e"),
	C5e("5e"), C4e("4e"), C3e("3e"),
	L2e("2nde"), L1e("1e"), lTerm("Terminale"),
	B2("BTS/DUT"), B3("Licence"), B5("Master"), BDoc("Doctorat");

	private final String toString;

	Niveau(String x){ this.toString = x; }
	
	@Override
	public String toString(){ return toString; }
    }
    public static enum Champs {
	DESC("Description"), PRIX_INITIAL("Prix initial de vente"),
	NB_EX("Nombre d'exemplaires"), CODE("ISBN"), NB_PAGES("Nombre de pages"),
	MATIERE("Matiere"), NIVEAU("Niveau");

	private final String toString;

	Champs(String x){ this.toString = x; }
	
	@Override
	public String toString(){ return toString; }
    }
    
    public Manuel(String description, double prixInitialVente, int nbExemplaires, String ISBN, int nbPages, Matiere matiere, Niveau niveau){
	super(description, prixInitialVente, nbExemplaires);
	this.ISBN = ISBN;
	this.nbPages = nbPages;
	this.matiere = matiere;
	this.niveau = niveau;
    }
    
    public Manuel(String description, String ISBN, int nbPages, Matiere matiere, Niveau niveau){
	super(description);
	this.ISBN = ISBN;
	this.nbPages = nbPages;
	this.matiere = matiere;
	this.niveau = niveau;
    }
    
    public Manuel(String description, String ISBN, int nbPages){
	super(description);
	this.ISBN = ISBN;
	this.nbPages = nbPages;
	this.matiere = Matiere.BIO;
	this.niveau = Niveau.CP;
    }
    
    public String getISBN(){ return ISBN; }
    public int getNbPages(){ return nbPages; }
    public Matiere getMatiere(){ return matiere; }
    public Niveau getNiveau(){ return niveau; }
    
    public void setISBN(String x){ ISBN = x; }
    public void setNbPages(int x){ nbPages = x; }
    
    @Override
    public String toString(){
	int[] lengths = printArticleLengths();
	String separator = "%n" + "-".repeat(lengths[0] + lengths.length - 1) + "%n";
	return String.format(separator
	    + "%-" + lengths[1] + "s %-" + lengths[2] + "s %-" + lengths[3] + "s %-" + lengths[4] + "s %-" + lengths[5] + "s %-" + lengths[6] + "s %-" + lengths[7] + "s"
	    + separator
	    + "%-" + lengths[1] + "s %-" + lengths[2] + "s %-" + lengths[3] + "s %-" + lengths[4] + "s %-" + lengths[5] + "s %-" + lengths[6] + "s %-" + lengths[7] + "s"
	    + separator,
	    Champs.DESC, Champs.PRIX_INITIAL, Champs.NB_EX, Champs.CODE, Champs.NB_PAGES, Champs.MATIERE, Champs.NIVEAU,
	    getDescription(), super.getPrixInitialVente(), super.getNbExemplaires(), getISBN(), getNbPages(), matiere.toString, niveau.toString
	);
    }
    
    //Calcul pour déterminer de combien caractères il faut décaler la prochaine colonne
    public int[] printArticleLengths(){
	int[] lengths = new int[8];
	//Description
	lengths[1] = Math.max(Champs.DESC.toString().length(), getDescription().length()) + 1;
	//Prix initial
	lengths[2] = Math.max(Champs.PRIX_INITIAL.toString().length(), Double.toString(super.getPrixInitialVente()).length()) + 1;
	//Nombre d'exemplaires
	lengths[3] = Math.max(Champs.NB_EX.toString().length(), Integer.toString(super.getNbExemplaires()).length()) + 1;
	//ISBN
	lengths[4] = Math.max(Champs.CODE.toString().length(), getISBN().length())+ 1;
	//Nombre de pages
	lengths[5] = Math.max(Champs.NB_PAGES.toString().length(), Integer.toString(getNbPages()).length()) + 1;
	//Matiere
	lengths[6] = Math.max(Champs.MATIERE.toString().length(), matiere.toString.length()) + 1;
	//Niveau
	lengths[7] = Math.max(Champs.NIVEAU.toString().length(), niveau.toString.length()) + 1;
	//Calcul du maximum entre les différentes propriétés pour le séparateur
	lengths[0] = 0;
	for (int l : lengths) {
	    lengths[0] += l;
	}
	return lengths;
    }
}
