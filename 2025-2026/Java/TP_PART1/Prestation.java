package projet_final;

/**
GRP : William WAN & Hsiao-Wen-Paul LO
 */

public class Prestation {
    // Attributs
    protected char categorieVehicule; 
    
    // Constructeurs
    public Prestation(char categorieVehicule) {
        this.categorieVehicule = categorieVehicule;
    }
    
    // Getters
    public char getCategorieVehicule() {
        return categorieVehicule;
    }
    // Methodes 
    public double lavage() {
        double prixBase = 20.0;
        
        switch (categorieVehicule) {
            case 'A':
                return prixBase;
            case 'B':
                return prixBase * 1.5; 
            case 'C':
                return prixBase * 1.75; 
            default:
                return prixBase;
        }
    }  
    
    public double sechage() {
        double prixBase = 10.0;
        
        switch (categorieVehicule) {
            case 'A':
                return prixBase;
            case 'B':
                return prixBase * 1.05; 
            case 'C':
                return prixBase * 1.10; 
            default:
                return prixBase;
        }
    }
        public double prelavage() {
        double prixBase = 5.0;
        
        switch (categorieVehicule) {
            case 'A':
                return prixBase;
            case 'B':
                return prixBase * 1.5; 
            case 'C':
                return prixBase * 1.75; 
            default:
                return prixBase;
        }
    }
    public double nettoyage() {
        return lavage() + sechage();
    }
    
    protected double prixNettoyageInterieur() {
        if (categorieVehicule == 'C') {
            return 40.0;
        } else {
            return 30.0; 
        }
    }
    
    // ToString()
    @Override
    public String toString() {
        return "Catégorie du véhicule pour la prestation: " + categorieVehicule;
    }
}
