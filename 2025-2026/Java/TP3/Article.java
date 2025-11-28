
import java.time.LocalDate;

/**
 *
 * @author William
 */
public abstract class Article {
    private String description;
    private double prixInitialVente;
    private int nbExemplaires;
    
    public Article(String description, double prixInitialVente, int nbExemplaires){
	this.description = description;
	this.prixInitialVente = Math.round(prixInitialVente * 100.0) / 100.0;
	this.nbExemplaires = nbExemplaires;
    }
    
    public Article(String description){
	this(description, 9.90, 1);
    }
    
    public Article(){
	this("", 9.90, 1);
    }
    
    public String getDescription(){ return description; }
    public double getPrixInitialVente(){ return prixInitialVente; }
    public int getNbExemplaires(){ return nbExemplaires; }
    
    public void setDescription(String x){ description = x; }
    public void setPrixInitialVente(double x){ prixInitialVente = x; }
    public void setNbExemplaires(int x){ nbExemplaires = x; }
    
//    public int[] printArticleLengths(int[] x){
//	switch(x.length){
//	    //6 = livre // 3m, 4m
//	    //8 = manuel // 3m, 4m, 5, 6
//	    //7 = magazine // 3, 4, 5
//	}
//	return x;
//    }
    
    //Selon l'enfant, on renvoie la bonne méthode
    public String getNumero(){
	if(this instanceof Magazine){
	    return ((Magazine) this).getISSN();
	} else if(this instanceof Livre){
	    return ((Livre) this).getISBN();
	} else {
	    return ((Manuel) this).getISBN();
	}
    }
    
    public boolean placerApres(Article a){ return this.getNumero().compareTo(a.getNumero()) > 0;}
    
    public void ajouter(int x){
	this.nbExemplaires += x;
    }
    
    //Utilisation de ajouter étant donné que c'est factuellement pareil, juste en inversé
    public void retirer(int x){
	if(x <= this.nbExemplaires){
	    this.ajouter(-x);
	} else {
	    System.out.println("Vous ne pouvez pas retirer " + x + " a " + this.nbExemplaires + " exemplaires");
	}
    }
    
    public double calculerPrix(){
	LocalDate now = LocalDate.now();
	if(this instanceof Magazine){
	    Magazine m = (Magazine) this;
	    if(
		//on calcul d'abord les -75%
		(m.getPeriodicite() == Magazine.Periodicite.H && m.getDateDePublication().plusWeeks(4).isBefore(now)) ||
		(m.getPeriodicite() == Magazine.Periodicite.M && m.getDateDePublication().plusMonths(4).isBefore(now)) ||
		(m.getPeriodicite() == Magazine.Periodicite.T && m.getDateDePublication().plusYears(1).isBefore(now))
	    ){
		this.prixInitialVente *= 0.25;
	    } else if(
		//puis les -50%
		(m.getPeriodicite() == Magazine.Periodicite.H && m.getDateDePublication().plusWeeks(2).isBefore(now)) ||
		(m.getPeriodicite() == Magazine.Periodicite.M && m.getDateDePublication().plusMonths(2).isBefore(now)) ||
		(m.getPeriodicite() == Magazine.Periodicite.T && m.getDateDePublication().plusMonths(6).isBefore(now))
	    ){
		this.prixInitialVente /= 2;
	    }
	} else {
	    //4 = avril
	    if(now.getMonthValue() == 4) this.prixInitialVente /= 2;
	}
	return this.prixInitialVente;
    }
    
    @Override
    public String toString(){
	String str = "";
	if(this instanceof Livre){ str += ((Livre) this).toString(); }
	else if(this instanceof Manuel){ str += ((Manuel) this).toString(); }
	else str += ((Magazine) this).toString();
	return str;
    }
}
