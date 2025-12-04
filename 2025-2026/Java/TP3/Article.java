package tp3;

public abstract class Article {
    //On met les valeurs par défaut
    private String description = "Article Test";
    private double prixInitialVente = 9.9;
    private int nbExemplaires = 1;
    
    public Article(String description, double prixInitialVente, int nbExemplaires){
	this.description = description;
	this.prixInitialVente = Math.round(prixInitialVente * 100.0) / 100.0;
	this.nbExemplaires = nbExemplaires;
    }
    
    public Article(String description, double prixInitialVente){
	this.description = description;
	this.prixInitialVente = Math.round(prixInitialVente * 100.0) / 100.0;
    }
    
    public Article(String description){
	this.description = description;
    }
    
    public Article(){}
    
    public String getDescription(){ return description; }
    public double getPrixInitialVente(){ return prixInitialVente; }
    public int getNbExemplaires(){ return nbExemplaires; }
    
    public void setDescription(String x){ description = x; }
    public void setPrixInitialVente(double x){ prixInitialVente = x; }
    public void setNbExemplaires(int x){ nbExemplaires = x; }
    
    // Chaque sous-classe doit renvoyer son propre numéro (ISBN ou ISSN)
    public abstract String getNumero();

    public boolean placerApres(Article a){ return this.getNumero().compareTo(a.getNumero()) > 0;}
    
    public boolean ajouter(int x){
	this.nbExemplaires += x;
	return true;
    }
    
    //Utilisation de ajouter étant donné que c'est factuellement pareil, juste en inversé
    public boolean retirer(int x){
	if(x <= this.nbExemplaires){
	    this.ajouter(-x);
	    return true;
	} else { return false; }
    }
    
    //Définition d'une méthode abstraite pour que les cas soient gérées dans les classes concernées
    public abstract double calculerPrix();
}
