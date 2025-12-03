package tp3;
import java.time.LocalDate;

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
        this.lignes = new LigneDepot[limite]; 
        this.nbLigneDepot = 0; 
    }
    
    public int getId(){ return id; }
    public String getNumeroTelephone(){ return numeroTelephone; }
    public LocalDate getDateEmission(){ return dateEmission; }
    public LigneDepot[] getLignes(){ return lignes; }
    
    public void setNumeroTelephone(String x){ numeroTelephone = x; }
    public void setDateEmission(LocalDate x){ dateEmission = x; }
    
    public void ajouterLigne(String codeArticle, int nbEx){
        if (nbLigneDepot < limite) {   
            lignes[nbLigneDepot] = new LigneDepot(codeArticle, nbEx);
            System.out.format(
                "L'article \"%s\" a ete ajoute au bon de depot %s%n%n",
                lignes[nbLigneDepot].getCodeArticle(), id
            );
            nbLigneDepot++;           
        } else {
            System.out.format(
                "Impossible d'ajouter une nouvelle ligne : limite de %s lignes atteinte pour le bon %s%n%n",
                limite, id
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
