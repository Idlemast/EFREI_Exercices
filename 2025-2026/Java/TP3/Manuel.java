package tp3;

import java.time.LocalDate;

public class Manuel extends Article {
    //On met les champs, c'est juste pour l'esthétique de la console
    public static enum Champs {
	DESC("Description"), PRIX_INITIAL("Prix initial de vente"),
	NB_EX("Nombre d'exemplaires"), CODE("ISBN"), NB_PAGES("Nombre de pages"),
	MATIERE("Matiere"), NIVEAU("Niveau");

	private final String toString;

	Champs(String x){ this.toString = x; }
	
	@Override
	public String toString(){ return toString; }
    }
    //On créé une sous-classe Niveau qui agit comme un sélecteur entre différents choix
    public static enum Niveau {
	_CP("CP"), _CE1("CE1"), _CE2("CE2"),
	_CM1("CM1"), _CM2("CM2"), _6e("6e"),
	_5e("5e"), _4e("4e"), _3e("3e"),
	_2nde("2nde"), _1ere("1e"), _Term("Terminale"),
	_Bac2("BTS/DUT"), _Bac3("Licence"), _Bac5("Master"), _Doc("Doctorat");

	private final String toString;

	Niveau(String x){ this.toString = x; }
	
	@Override
	public String toString(){ return toString; }
    }
    
    //Pareil pour Matiere
    public static enum Matiere {
	FR("Français"), EN("Anglais"), ES("Espagnol"),
	MATHS("Mathématiques"), BIO("Biologie"), INFO("Informatique");

	private final String toString;

	Matiere(String x) { this.toString = x; }
	
	@Override
	public String toString(){ return toString; }
    }
    
    //On met des valeurs par défaut
    private String ISBN = "1462594875264";
    private int nbPages = 50;
    private Matiere matiere = Manuel.Matiere.INFO;
    private Niveau niveau = Manuel.Niveau._CE2;
    
    public Manuel(String description, double prixInitialVente, int nbExemplaires, String ISBN, int nbPages, Matiere matiere, Niveau niveau){
	super(description, prixInitialVente, nbExemplaires);
	this.ISBN = ISBN;
	this.nbPages = nbPages;
	this.matiere = matiere;
	this.niveau = niveau;
    }
    
    public Manuel(String description, double prixInitialVente, int nbExemplaires, String ISBN, int nbPages, Matiere matiere){
	super(description, prixInitialVente, nbExemplaires);
	this.ISBN = ISBN;
	this.nbPages = nbPages;
	this.matiere = matiere;
    }
    
    public Manuel(String description, double prixInitialVente, int nbExemplaires, String ISBN, int nbPages){
	super(description, prixInitialVente, nbExemplaires);
	this.ISBN = ISBN;
	this.nbPages = nbPages;
    }
    
    public Manuel(String description, double prixInitialVente, int nbExemplaires, String ISBN){
	super(description, prixInitialVente, nbExemplaires);
	this.ISBN = ISBN;
    }
    
    public Manuel(String description, double prixInitialVente, int nbExemplaires){
	super(description, prixInitialVente, nbExemplaires);
    }
    
    public Manuel(String description, double prixInitialVente){
	super(description, prixInitialVente);
    }
    
    public Manuel(String description){
	super(description);
    }
    
    public Manuel(String description, String ISBN, int nbPages, Matiere matiere, Niveau niveau){
	super(description);
	this.ISBN = ISBN;
	this.nbPages = nbPages;
	this.matiere = matiere;
	this.niveau = niveau;
    }
    
    public Manuel(){}
    
    @Override
    public String getNumero() { return ISBN; }
    
    public int getNbPages(){ return nbPages; }
    public Matiere getMatiere(){ return matiere; }
    public Niveau getNiveau(){ return niveau; }
    public void setISBN(String x){ ISBN = x; }
    public void setNbPages(int x){ nbPages = x; }
    public void setMatiere(Matiere x){ matiere = x; }
    public void setNiveau(Niveau x){ niveau = x; }
    
    @Override
    public double calculerPrix(){
	LocalDate now = LocalDate.now();
        double prix = getPrixInitialVente();
	return now.getMonthValue() == 4 ? prix /= 2 : prix;
    }
    
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
	    getDescription(), super.getPrixInitialVente(), super.getNbExemplaires(), getNumero(), getNbPages(), matiere.toString(), niveau.toString()
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
	lengths[4] = Math.max(Champs.CODE.toString().length(), getNumero().length())+ 1;
	//Nombre de pages
	lengths[5] = Math.max(Champs.NB_PAGES.toString().length(), Integer.toString(getNbPages()).length()) + 1;
	//Matiere
	lengths[6] = Math.max(Champs.MATIERE.toString().length(), matiere.toString().length()) + 1;
	//Niveau
	lengths[7] = Math.max(Champs.NIVEAU.toString().length(), niveau.toString().length()) + 1;
	//Calcul du maximum entre les différentes propriétés pour le séparateur
	lengths[0] = 0;
	for (int l : lengths) {
	    lengths[0] += l;
	}
	return lengths;
    }
}
