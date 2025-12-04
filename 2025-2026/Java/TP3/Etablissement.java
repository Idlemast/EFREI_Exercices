package tp3;
import java.time.LocalDate;


public class Etablissement {
    //On met les valurs par défaut
    private String nom = "Grande Epicerie de Paris";
    private int nbArticles = 0, nbBons = 0;
    private int limiteArticles = 9, limiteBons = 9;
    private Article[] articles;
    private BonDepot[] bons;
    
    public Etablissement(String nom, int limiteArticles, int limiteBons){
	this.nom = nom;
	this.limiteArticles = limiteArticles;
	this.limiteBons = limiteBons;
	this.articles = new Article[limiteArticles];
	this.bons = new BonDepot[limiteBons];
    }
    
    public Etablissement(String nom){
	this.nom = nom;
	this.articles = new Article[limiteArticles];
	this.bons = new BonDepot[limiteBons];
    }
    
    public Etablissement(){
	this.articles = new Article[limiteArticles];
	this.bons = new BonDepot[limiteBons];
    }
    
    public String getNom(){ return nom; }
    public int getLimiteArticles(){ return limiteArticles; }
    public int getLimiteBons(){ return limiteBons; }
    public int getNbArticles(){ return nbArticles; }
    public int getNbBons(){ return nbBons; }
    
    public void setNom(String x){ nom = x; }
    public void setLimiteArticles(int x){ limiteArticles = x; }
    public void setLimiteBons(int x){ limiteBons = x; }
    
    public void ajouterLivre(String description, double prixInitialDeVente, int nbExemplaires, String ISBN, int nbPages){
        ajouterArticle(new Livre(description, prixInitialDeVente, nbExemplaires, ISBN, nbPages));
    }
    
    public void ajouterManuel(String description, double prixInitialDeVente, int nbExemplaires, String ISBN, int nbPages, Manuel.Matiere matiere, Manuel.Niveau niveau){
        ajouterArticle(new Manuel(description, prixInitialDeVente, nbExemplaires, ISBN, nbPages, matiere, niveau));
    }
    
    public void ajouterMagazine(String description, double prixInitialDeVente, int nbExemplaires, String ISSN, Magazine.Periodicite periodicite, LocalDate datePublication){
        ajouterArticle(new Magazine(description, prixInitialDeVente, nbExemplaires, ISSN, periodicite, datePublication));
    }
    
    public Article rechercher(String numero){
	for(Article a : articles){
	    if(a != null && a.getNumero().equals(numero))
		return a;
	}
	return null;
    }
    
    //Si on ajoute directement un Article, appelle la bonne fonction, gain de temps
    public boolean ajouter(Article a){
	return ajouter(a.getNumero(), a.getNbExemplaires());
    }
    
    //Il faut juste vérifier que le code correspond à un Article
    public boolean ajouter(String numero, int qte){
	if(rechercher(numero) != null){
	    if(rechercher(numero) != null){
		rechercher(numero).ajouter(qte);
		return true;
	    } else {
		return false;
	    }
	} else {
	    System.out.println(String.format("L'article %s  n'est pas dans les articles de l'etablissement %s !%n", numero, nom));
	    return false;
	}
    }
    
    //Il faut juste vérifier que le code correspond à un Article
    public void retirer(String numero, int qte){
	if(rechercher(numero) != null){
	    if(rechercher(numero).retirer(qte)){
		System.out.println(String.format("Vous avez retire %s a l'article %s !%n", Integer.toString(qte), numero));
	    } else {
		System.out.println("Vous ne pouvez pas retirer " + qte + " a " + rechercher(numero).getNbExemplaires() + " exemplaires");
	    }
	} else {
	    System.out.println(String.format("L'article %s  n'est pas dans les articles de l'etablissement %s !%n", numero, nom));
	}
    }
    
    @Override
    public String toString(){
	String str = "%n";
	str += "-----Nom de l'etablissement : " + nom + "-----%n";
	boolean isEmpty = true;
	
	for(Article a : articles){
	    if(a != null){
		str += a + "%n";
		isEmpty = false;
	    }
	}
	for(BonDepot b : bons){
	    if(b != null){
		str += b + "%n";
		isEmpty = false;
	    }
	}
	if(isEmpty){ str += "vide%n"; }
	return String.format(str);
    }
    
    
    public void ajouterArticle(Article a){
        if (nbArticles >= limiteArticles){
            System.out.format(
            "%nPlus de place pour rajouter des articles dans l'établissement %s (max : %s)",
            nom, limiteArticles
            );
        return;
        }
        
        int pos = 0;
        while (pos < nbArticles && !articles[pos].placerApres(a))
            pos++;

        for (int i = nbArticles; i > pos; i--)
            articles[i] = articles[i - 1];

        articles[pos] = a;
        nbArticles++;
    }
    
    //Pour ajouter un BonDepot
    public boolean ajouter(String numeroTelephone){
	//On s'assure que nbBons est bien strictement inférieur à la limite
        if (nbBons >= limiteBons){ return false; }
	BonDepot b = new BonDepot(numeroTelephone);
	
	//On crée un int qui balaye les dates inférieures
        int pos = 0;
        while (pos < nbBons && bons[pos].getDateEmission().isBefore(b.getDateEmission())){
            pos++;
	}
	//et incrémente les dates supérieures
        for(int i = nbBons; i > pos; i--){
            bons[i] = bons[i - 1];
	}
        bons[pos] = b;
        nbBons++;

        return true;
    }
}
