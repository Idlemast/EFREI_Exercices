package tp3;

public class LigneDepot {
    //On met les valeurs par défaut
    private String numeroArticle = "";
    private int nbExemplairesDepot = 1;
    
    public LigneDepot(String numeroArticle, int nbExemplairesDepot){
	this.numeroArticle = numeroArticle;
	this.nbExemplairesDepot = nbExemplairesDepot;
    }
    
    public LigneDepot(String numeroArticle){
	this.numeroArticle = numeroArticle;
    }
    
    public String getNumeroArticle(){ return numeroArticle; }
    public int getNbExemplairesDepot(){ return nbExemplairesDepot; }
    
    public void setNumeroArticle(String x){ numeroArticle = x; }
    public void setNbExemplairesDepot(int x){ nbExemplairesDepot = x; }
    
    //1 si Magazine (8), 0 si le reste (13)
    public boolean isMagazine(){ return numeroArticle.length() == 8; }
    
    @Override
    public String toString(){
	return String.format("%-17s %-41s",
	    numeroArticle, nbExemplairesDepot
	);
    }
}
