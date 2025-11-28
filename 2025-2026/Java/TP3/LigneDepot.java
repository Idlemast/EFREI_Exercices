/**
 *
 * @author William
 */
public class LigneDepot {
    private String codeArticle;
    private int nbExemplairesDepot;
    
    public LigneDepot(String codeArticle){
	this.codeArticle = codeArticle;
	this.nbExemplairesDepot = 1;
    }
    
    public LigneDepot(String codeArticle, int nbExemplairesDepot){
	this(codeArticle);
	this.nbExemplairesDepot = nbExemplairesDepot;
    }
    
    public String getCodeArticle(){ return codeArticle; }
    public int getNbExemplairesDepot(){ return nbExemplairesDepot; }
    
    public void setNbExemplairesDepot(int x){ nbExemplairesDepot = x; }
    
    //1 si Magazine (8), 0 si le reste (13)
    public boolean isMagazine(){ return codeArticle.length() == 8; }
    
    @Override
    public String toString(){
	return String.format("%-17s %-41s",
	    codeArticle, nbExemplairesDepot
	);
    }
}
