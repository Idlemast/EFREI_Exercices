
import java.time.LocalDate;

/**
 *
 * @author William
 */
public class Etablissement {
    private String nom;
    int limiteArticles, limiteBons, nbArticles = 0, nbBons = 0;
    Article[] articles;
    BonDepot[] bons;
    
    public Etablissement(String nom, int limiteArticles, int limiteBons){
	this.nom = nom;
	this.limiteArticles = limiteArticles;
	this.limiteBons = limiteBons;
	this.articles = new Article[limiteArticles];
	this.bons = new BonDepot[limiteBons];
    }
    
    public Etablissement(String nom){
	this.nom = nom;
	this.limiteArticles = 5;
	this.limiteBons = 5;
	this.articles = new Article[limiteArticles];
	this.bons = new BonDepot[limiteBons];
    }
    
    public String getNom(){ return nom; }
    public int getLimiteArticles(){ return limiteArticles; }
    public int getLimiteBons(){ return limiteBons; }
    public int getNbArticles(){ return nbArticles; }
    public int getNbBons(){ return nbBons; }
    
    public void setNom(String x){ nom = x; }
    
    @Override
    public String toString(){
	String str = "%n";
	str += "-----Nom de l'etablissement : " + nom + "-----%n";
	
	for(Article a : articles){
	    if(a != null) str += a + "%n";
	}
	
	
	for(BonDepot b : bons){
	    if(b != null) str += b + "%n";
	}
	return String.format(str);
    }
    
    //si l'article est déjà créé
    public void addArticle(Article a){
	//si y'a de la place
	if(nbArticles + a.getNbExemplaires() <= limiteArticles){
	    //!!!Il faut faire en sorte de gérer les trucs qu'on ajoute dans Etablisssement,
	    //!!!je sais pas comment faire soit qte sur x ednroit du tableau mais du coup peut
	    //!!!être vide où à chaque endroit on met 1 de qte comme ça c'est bon
	    //!!!grosso modo c'est un peu différent de BonDepot
	    for(int i = nbArticles; i <= nbArticles + a.getNbExemplaires(); i++){
		articles[i] = a;
	    }
	    System.out.format(
		"%nL'article \"%s\" a ete ajoute a l'etablissement %s%n%n",
		a.getDescription(), nom
	    );
	    nbArticles += a.getNbExemplaires();
	} else {
	    System.out.format(
		"%nPlus de place pour rajouter des articles dans l'établissement %s (max : %s)",
		nom, limiteArticles
	    );
	}
    }
    
    public void addBonDepot(BonDepot b){
	if(nbBons <= limiteBons){
	    bons[nbBons] = b;
	    System.out.format(
		"Le bon de depot \"%s\" a ete ajoute a l'etablissement %s%n%n",
		b.getId(), nom
	    );
	    ++nbBons;
	} else {
	    System.out.format(
		"Plus de place pour rajouter des bons de depot dans l'etablissement %s (max : %s)%n%n",
		nom, limiteBons
	    );
	}
    }
    
    //!!! A changer comme dit plus haut
    public void addLivre(String description, double prixInitialDeVente, int nbExemplaires, String ISBN, int nbPages){
	//si y'a de la place
	if(nbArticles + nbExemplaires <= limiteArticles){
	    Livre x = new Livre(description, prixInitialDeVente, nbExemplaires, ISBN, nbPages);
	    articles[nbArticles] = x;
	    System.out.format(
		"Le livre \"%s\" a ete ajoute a l'etablissement %s%n%n",
		x.getDescription(), nom
	    );
	    ++nbArticles;
	} else {
	    System.out.format(
		"Plus de place pour rajouter le livre dans l'établissement %s (max : %s)",
		nom, limiteArticles
	    );
	}
    }
    
    //!!! A changer comme dit plus haut
    public void addManuel(String description, double prixInitialDeVente, int nbExemplaires, String ISBN, int nbPages, Manuel.Matiere matiere, Manuel.Niveau niveau){
	//si y'a de la place
	if(articles.length <= limiteArticles){
	    Manuel x = new Manuel(description, prixInitialDeVente, nbExemplaires, ISBN, nbPages, matiere, niveau);
	    articles[nbArticles] = x;
	    System.out.format(
		"Le manuel \"%s\" a ete ajoute a l'etablissement %s%n%n",
		x.getDescription(), nom
	    );
	    ++nbArticles;
	} else {
	    System.out.format(
		"Plus de place pour rajouter le manuel dans l'établissement %s (max : %s)",
		nom, limiteArticles
	    );
	}
    }
    
    //!!! A changer comme dit plus haut
    public void addMagazine(String description, double prixInitialDeVente, int nbExemplaires, String ISSN, Magazine.Periodicite periodicite, LocalDate datePublication){
	//si y'a de la place
	if(articles.length <= limiteArticles){
	    Magazine x = new Magazine(description, prixInitialDeVente, nbExemplaires, ISSN, periodicite, datePublication);
	    articles[nbArticles] = x;
	    System.out.format(
		"Le magazine \"%s\" a ete ajoute a l'etablissement %s%n%n",
		x.getDescription(), nom
	    );
	    ++nbArticles;
	} else {
	    System.out.format(
		"Plus de place pour rajouter le magazine dans l'établissement %s (max : %s)",
		nom, limiteArticles
	    );
	}
    }
}
