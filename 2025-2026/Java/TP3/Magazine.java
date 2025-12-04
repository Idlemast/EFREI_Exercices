package tp3;
import java.time.LocalDate;

public class Magazine extends Article {
    //On met les champs, c'est juste pour l'esthétique de la console
    public static enum Champs {
	DESC("Description"), PRIX_INITIAL("Prix initial de vente"),
	NB_EX("Nombre d'exemplaires"), CODE("ISSN"), PERIODICITE("Periodicite"), DATE_PUBLICATION("Date de publication");

	private final String toString;

	Champs(String x){ this.toString = x; }
	
	@Override
	public String toString(){ return toString; }
    }
    
    //On créé une sous-classe Periodicite qui agit comme un sélecteur entre différents choix
    public static enum Periodicite {
        H("Hebdomadaire"),
        M("Mensuel"),
        T("Trimestriel");

        private final String label;

        Periodicite(String label) { this.label = label; }

        @Override
        public String toString() { return label; }
    }
    
    //On met lez valeurs par défaut
    private String ISSN = "15485926";
    private Periodicite periodicite = Magazine.Periodicite.H;
    private LocalDate dateDePublication = LocalDate.of(2022, 4, 15);
    
    public Magazine(String description, double prixInitialDeVente, int nbExemplaires, String ISSN, Periodicite periodicite, LocalDate dateDePublication){
	super(description, prixInitialDeVente, nbExemplaires);
	this.ISSN = ISSN;
	this.periodicite = periodicite;
	this.dateDePublication = dateDePublication;
    }
    
    public Magazine(String description, double prixInitialDeVente, int nbExemplaires, String ISSN, Periodicite periodicite){
	super(description, prixInitialDeVente, nbExemplaires);
	this.ISSN = ISSN;
	this.periodicite = periodicite;
    }
    
    public Magazine(String description, double prixInitialDeVente, int nbExemplaires, String ISSN){
	super(description, prixInitialDeVente, nbExemplaires);
	this.ISSN = ISSN;
    }
    
    public Magazine(String description, double prixInitialDeVente, int nbExemplaires){
	super(description, prixInitialDeVente, nbExemplaires);
    }
    
    public Magazine(String description, double prixInitialDeVente){
	super(description, prixInitialDeVente);
    }
    
    public Magazine(String description){
	super(description);
    }
    
    public Magazine(String description, String ISSN, Periodicite periodicite, LocalDate dateDePublication){
	super(description);
	this.ISSN = ISSN;
	this.periodicite = periodicite;
	this.dateDePublication = dateDePublication;
    }
    
    public Magazine(){}

    @Override
    public String getNumero() { return ISSN; }
    
    public Periodicite getPeriodicite(){ return periodicite; }
    public LocalDate getDateDePublication(){ return dateDePublication; }
    public void setISSN(String x){ ISSN = x; }
    public void setPeriodicite(Periodicite x){ periodicite = x; }
    public void setDateDePublication(LocalDate x){ dateDePublication = x; }
    
    @Override
    public double calculerPrix(){
	LocalDate now = LocalDate.now();
        double prix = getPrixInitialVente();
	if(
	    //on calcul d'abord les -75%
	    (getPeriodicite() == Magazine.Periodicite.H && getDateDePublication().plusWeeks(4).isBefore(now)) ||
	    (getPeriodicite() == Magazine.Periodicite.M && getDateDePublication().plusMonths(4).isBefore(now)) ||
	    (getPeriodicite() == Magazine.Periodicite.T && getDateDePublication().plusYears(1).isBefore(now))
	){
	    prix *= 0.25;
	} else if(
	    //puis les -50%
	    (getPeriodicite() == Magazine.Periodicite.H && getDateDePublication().plusWeeks(2).isBefore(now)) ||
	    (getPeriodicite() == Magazine.Periodicite.M && getDateDePublication().plusMonths(2).isBefore(now)) ||
	    (getPeriodicite() == Magazine.Periodicite.T && getDateDePublication().plusMonths(6).isBefore(now))
	){
	    prix /= 2;
	}
	return prix;
    }
    
    @Override
    public String toString(){
	int[] lengths = printArticleLengths();
	String separator = "%n" + "-".repeat(lengths[0] + lengths.length - 1) + "%n";
	return String.format(separator
	    + "%-" + lengths[1] + "s %-" + lengths[2] + "s %-" + lengths[3] + "s %-" + lengths[4] + "s %-" + lengths[5] + "s %-" + lengths[6] + "s"
	    + separator
	    + "%-" + lengths[1] + "s %-" + lengths[2] + "s %-" + lengths[3] + "s %-" + lengths[4] + "s %-" + lengths[5] + "s %-" + lengths[6] + "s"
	    + separator,
	    Champs.DESC, Champs.PRIX_INITIAL, Champs.NB_EX, Champs.CODE, Champs.PERIODICITE, Champs.DATE_PUBLICATION,
	    getDescription(), super.getPrixInitialVente(), super.getNbExemplaires(), ISSN, periodicite.toString(), dateDePublication.toString()
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
	//Périodicité
	lengths[5] = Math.max(Champs.PERIODICITE.toString().length(), periodicite.toString().length()) + 1;
	//Date de publication
	lengths[6] = Math.max(Champs.DATE_PUBLICATION.toString().length(), dateDePublication.toString().length()) + 1;
	//Calcul du maximum entre les différentes propriétés pour le séparateur
	lengths[0] = 0;
	for (int l : lengths) {
	    lengths[0] += l;
	}
	return lengths;
    }
}
