package tp3;
import java.time.LocalDate;


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
    
    public BonDepot ajouter(String numeroTelephone){
        if (nbBons >= limiteBons){
            System.out.printf("Plus de place pour ajouter un bon de depot dans %s%n", nom);
            return null;
        }

        BonDepot b = new BonDepot(numeroTelephone);

        int pos = 0;
        while (pos < nbBons && bons[pos].getDateEmission().isBefore(b.getDateEmission()))
            pos++;

        for (int i = nbBons; i > pos; i--)
            bons[i] = bons[i - 1];

        bons[pos] = b;
        nbBons++;

        return b;
    }

    
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
    for (int i = 0; i < nbArticles; i++){
        if (articles[i].getNumero().equals(numero))
            return articles[i];
    }
    return null;
    }
    public void ajouter(String numero, int qte){
    Article a = rechercher(numero);
    if (a != null) a.ajouter(qte);
    }
    public void retirer(String numero, int qte){
    Article a = rechercher(numero);
    if (a != null) a.retirer(qte);
    }
}
