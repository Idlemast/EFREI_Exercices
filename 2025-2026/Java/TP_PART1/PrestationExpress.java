package projet_final;

/**
GRP : William WAN & Hsiao-Wen-Paul LO
 */

class PrestationExpress extends Prestation {
    // Attributs
    private boolean nettoyageInterieur;
    
    // Constructeurs
    public PrestationExpress(char categorieVehicule, boolean nettoyageInterieur) {
        super(categorieVehicule); // classe mère prestation 
        this.nettoyageInterieur = nettoyageInterieur;
    }
    
    // Getters
    public boolean isNettoyageInterieur() {
        return nettoyageInterieur;
    }
    
    // Methodes
    @Override
    public double nettoyage() {
        double prix = lavage() + sechage();
        
        if (nettoyageInterieur) {
            prix += prixNettoyageInterieur();
        }
        
        return prix;
    }    
    // ToString()
    @Override
    public String toString() {
        String result = "Prestation Express - Catégorie du véhicule : " + categorieVehicule + "\n";  
        if (nettoyageInterieur) {
            result += " - Avec nettoyage intérieur";
        } 
        return result;
    }
}
