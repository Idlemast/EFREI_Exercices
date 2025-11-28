import java.time.LocalDate;

/**
 *
 * @author William
 */
public class BonDepot {
    private int id;
    private String numeroTelephone;
    private LocalDate dateEmission;
    private LigneDepot[] lignes;
    private static int idCount = 1;
    //count local des éléments
    private int nbLigneDepot = 0;
    //Limite du tableau prédéfinie car taille du tableau non modifiable
    private int limite = 9;
    
    public BonDepot(String numeroTelephone){
	//augmenter le count pour tout les BonDepot = avoir un id différent
	this.id = idCount++;
	this.dateEmission = LocalDate.now();
	this.numeroTelephone = numeroTelephone;
	this.lignes = new LigneDepot[limite];
    }
    
    public BonDepot(String numeroTelephone, LocalDate dateEmission){
	this(numeroTelephone);
	this.dateEmission = dateEmission;
    }
    
    public BonDepot(String numeroTelephone, LocalDate dateEmission, int limite){
	this(numeroTelephone, dateEmission);
	this.limite = limite;
    }
    
    public int getId(){ return id; }
    public String getNumeroTelephone(){ return numeroTelephone; }
    public LocalDate getDateEmission(){ return dateEmission; }
    public LigneDepot[] getLignes(){ return lignes; }
    
    public void setNumeroTelephone(String x){ numeroTelephone = x; }
    public void setDateEmission(LocalDate x){ dateEmission = x; }
    
    public void addLigne(LigneDepot ligne){
	if(nbLigneDepot + ligne.getNbExemplairesDepot() <= limite){
	    lignes[nbLigneDepot] = ligne;
	    System.out.format(
		"L'article \"%s\" a ete ajoute au bon de depot %s%n%n",
		ligne.getCodeArticle(), id
	    );
	    nbLigneDepot += ligne.getNbExemplairesDepot();
	} else {
	    System.out.format(
		"Impossible d'ajouter %s article(s) pour le bon de depot %s (%s/%s)%n%n",
		ligne.getNbExemplairesDepot(), id, nbLigneDepot, limite
	    );
	}
    }
    
    @Override
    public String toString(){
	String str = "";
	str += "Bon de depot " + id + "%n";
	str += "Numero de telephone : " + numeroTelephone
		+ "%nDate d'emission : " + dateEmission.toString()
		+ "%nNombre d'articles deposes: " + nbLigneDepot + "%n";
	boolean needHeaders = true;
	for(LigneDepot ligne : lignes){
	    if(ligne != null){
		if(needHeaders == true){
		    needHeaders = false;
		    str += "Code de l'article Nombre d'exemplaires deposes%n";
		}
		str += ligne + "%n";
	    }
	}
	return String.format(str);
    }
}
