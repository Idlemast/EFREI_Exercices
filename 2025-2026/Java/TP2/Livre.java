package tp2;

public class Livre {
    private String titre;
    private int code;
    private String auteur;
    private int nbPages;
    private int anneeEdition;
    
    
    public Livre(){
	this.titre = "Harry Potter";
	this.code = 15487;
	this.auteur = "JK rowling";
	this.nbPages = 358;
	this.anneeEdition = 1998;
    }
    
    public Livre(String t, int c, String a, int nb, int y){
	this.titre = t;
	this.code = c;
	this.auteur = a;
	this.nbPages = nb;
	this.anneeEdition = y;
    }
    
    public String getTitre(){return titre;}
    public int getCode(){return code;}
    public String getAuteur(){return auteur;}
    public int getNbPages(){return nbPages;}
    public int getAnneeEdition(){return anneeEdition;}
    
    public void setTitre(String t){titre = t;}
    public void setCode(int c){code = c;}
    public void setAuteur(String a){auteur = a;}
    public void setNbPages(int nb){nbPages = nb;}
    public void setAnneeEdition(int y){anneeEdition = y;}
    
    @Override
    public String toString(){
	String x = "";
	x += "--- Livre ---";
	x += "\nTitre : " + titre;
	x += "\nCode : " + code;
	x += "\nAuteur : " + auteur;
	x += "\nNombre de pages : " + nbPages;
	x += "\nAnnée d\'édition : " + anneeEdition;
	return x;
    }
}