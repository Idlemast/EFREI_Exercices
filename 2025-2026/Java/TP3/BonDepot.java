package tp3;
import java.time.LocalDate;

public class BonDepot {
    private int id;
    private String numeroTelephone = "+33 6 11 11 11 11";
    private LocalDate dateEmission = LocalDate.now();
    private LigneDepot[] lignes;
    //pour avoir un id unique
    private static int idCount = 1;
    //count local des éléments
    private int nbLigneDepot = 0;
    //Limite du tableau prédéfinie car taille du tableau non modifiable
    private int limiteLignes = 9;
    
    public BonDepot(String numeroTelephone, LocalDate dateEmission){
	//augmenter le count pour tout les BonDepot = avoir un id différent
	this.id = idCount++;
	this.numeroTelephone = numeroTelephone;
	this.dateEmission = dateEmission;
        this.lignes = new LigneDepot[limiteLignes]; 
        this.nbLigneDepot = 0;
    }
    
    public BonDepot(String numeroTelephone){
	//augmenter le count pour tout les BonDepot = avoir un id différent
	this.id = idCount++;
	this.numeroTelephone = numeroTelephone;
        this.lignes = new LigneDepot[limiteLignes]; 
        this.nbLigneDepot = 0;
    }
    
    public BonDepot(){
	//augmenter le count pour tout les BonDepot = avoir un id différent
	this.id = idCount++;
        this.lignes = new LigneDepot[limiteLignes]; 
        this.nbLigneDepot = 0;
    }
    
    public int getId(){ return id; }
    public String getNumeroTelephone(){ return numeroTelephone; }
    public LocalDate getDateEmission(){ return dateEmission; }
    public LigneDepot[] getLignes(){ return lignes; }
    public int getLimite(){ return limiteLignes; }
    public int getNbArticles(){
	if(lignes.length > 0){
	    int x = 0;
	    for(LigneDepot l : lignes){
		if(l != null) x += l.getNbExemplairesDepot();
	    }
	    return x;
	}
	return 0;
    }
    
    public void setNumeroTelephone(String x){ numeroTelephone = x; }
    public void setDateEmission(LocalDate x){ dateEmission = x; }
    public void setLimite(int x){ limiteLignes = x; }
    
    //Si ajout en Article, reférence la méthode demandé et du coup il n'y aura pas d'erreurs
    public boolean ajouterLigne(Article a){
	return ajouterLigne(a.getNumero(), a.getNbExemplaires());
    }
    
    public boolean ajouterLigne(String codeArticle, int nbEx){
        if (nbLigneDepot < limiteLignes) {   
            lignes[nbLigneDepot] = new LigneDepot(codeArticle, nbEx);
            nbLigneDepot++;
	    return true;
        } else {
	    return false; }
    }

    
    @Override
    public String toString(){
	String str = "";
	str += "%nBon de depot " + id + "%n";
	str += "Numero de telephone : " + numeroTelephone
		+ "%nDate d'emission : " + dateEmission.toString()
		+ "%nNombre d'articles deposes: " + getNbArticles() + "%n";
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
