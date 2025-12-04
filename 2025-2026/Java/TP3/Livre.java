package tp3;

import java.time.LocalDate;

public class Livre extends Article {
    //On met les champs, c'est juste pour l'esthétique de la console
    public static enum Champs {
	DESC("Description"), PRIX_INITIAL("Prix initial de vente"),
	NB_EX("Nombre d'exemplaires"), CODE("ISBN"), NB_PAGES("Nombre de pages");

	private final String toString;

	Champs(String x){ this.toString = x; }
	
	@Override
	public String toString(){ return toString; }
    }
    
    //on met les valeurs par défaut
    private String ISBN = "1598753147532";
    private int nbPages = 200;
    
    public Livre(String description, double prixInitialVente, int nbExemplaires, String ISBN, int nbPages){
	super(description, prixInitialVente, nbExemplaires);
	this.ISBN = ISBN;
	this.nbPages = nbPages;
    }
    
    public Livre(String description, double prixInitialVente, int nbExemplaires, String ISBN){
	super(description, prixInitialVente, nbExemplaires);
	this.ISBN = ISBN;
    }
    
    public Livre(String description, double prixInitialVente, int nbExemplaires){
	super(description, prixInitialVente, nbExemplaires);
    }
    
    public Livre(String description, double prixInitialVente){
	super(description, prixInitialVente);
    }
    
    public Livre(String description){
	super(description);
    }
    
    public Livre(String description, String ISBN, int nbPages){
	super(description);
	this.ISBN = ISBN;
	this.nbPages = nbPages;
    }
    
    public Livre(){}
    
    
    @Override
    public String getNumero() { return ISBN; }
    
    public int getNbPages(){ return nbPages; }
    
    public void setISBN(String x){ ISBN = x; }
    public void setNbPages(int x){ nbPages = x; }
    
    @Override
    public double calculerPrix(){
	LocalDate now = LocalDate.now();
        double prix = getPrixInitialVente();
	return now.getMonthValue() == 4 ? prix /= 2 : prix;
    }
    
    @Override
    public String toString(){
	int[] lengths = printArticleLengths();
	String separator = "-".repeat(lengths[0] + lengths.length - 1) + "%n";
	return String.format(separator
	    + "%-" + lengths[1] + "s %-" + lengths[2] + "s %-" + lengths[3] + "s %-" + lengths[4] + "s %-" + lengths[5] + "s%n"
	    + separator
	    + "%-" + lengths[1] + "s %-" + lengths[2] + "s %-" + lengths[3] + "s %-" + lengths[4] + "s %-" + lengths[5] + "s%n"
	    + separator,
	    Champs.DESC, Champs.PRIX_INITIAL, Champs.NB_EX, Champs.CODE, Champs.NB_PAGES,
	    getDescription(), super.getPrixInitialVente(), super.getNbExemplaires(), getNumero(), getNbPages()
	);
    }
    
    //Calcul pour déterminer de combien caractères il faut décaler la prochaine colonne
    public int[] printArticleLengths(){
	int[] lengths = new int[6];
	//Description
	lengths[1] = Math.max(Champs.DESC.toString().length(), getDescription().length()) + 1;
	//Prix initial
	lengths[2] = Math.max(Champs.PRIX_INITIAL.toString().length(), Double.toString(super.getPrixInitialVente()).length()) + 1;
	//Nombre d'exemplaires
	lengths[3] = Math.max(Champs.NB_EX.toString().length(), Integer.toString(super.getNbExemplaires()).length()) + 1;
	//ISBN
	lengths[4] = Math.max(Champs.CODE.toString().length(), getNumero().length())+ 1;
	//Nombre de pages
	lengths[5] = Math.max(Champs.NB_PAGES.toString().length(), Integer.toString(getNbPages()).length()) + 1;
	//Calcul du maximum entre les différentes propriétés pour le séparateur
	lengths[0] = 0;
	for (int l : lengths) {
	    lengths[0] += l;
	}
	return lengths;
    }
}
