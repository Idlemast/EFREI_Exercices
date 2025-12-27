package projet_final;

/**
GRP : William WAN & Hsiao-Wen-Paul LO
 */

class PrestationTresSale extends Prestation {
    // Attributs
    private int typeSalissure; 
    
    // Constructeurs
    public PrestationTresSale(char categorieVehicule, int typeSalissure) {
        super(categorieVehicule); // classe mère prestation 
        this.typeSalissure = typeSalissure;
    }
    
    // Getters
    public int getTypeSalissure() {
        return typeSalissure;
    }
    // Methodes 
    private double surcout() {
        switch (typeSalissure) {
            case 1: // nourriture
                return 1.0;
            case 2: // boue
                return 1.99;
            case 3: // transpiration
                return 2.5;
            case 4: // graisse
                return 5.0;
            case 5: 
                return 6.33; // moisissure ( bonus )
            default:
                return 10.0; // autre
        }
    }
    @Override
    public double lavage() {
        return super.lavage() + surcout();
    }
    
    @Override
    public double prelavage() {
        return super.prelavage() + surcout();
    }
    
    @Override
    public double nettoyage() {
        return prelavage() + lavage() + sechage() + prixNettoyageInterieur();
    }
    
    // ToString()
    @Override
    public String toString() {
        String typeStr;
        switch (typeSalissure) {
            case 1:
                typeStr = "taches de nourriture";
                break;
            case 2:
                typeStr = "taches de boue";
                break;
            case 3:
                typeStr = "taches de transpiration";
                break;
            case 4:
                typeStr = "taches de graisse";
                break;
            case 5:
                typeStr = "taches de moisissure"; //bonus
                break;
            default:
                typeStr = "autre";
        }
        return "Prestation Très Sale - Catégorie du véhicule : " + categorieVehicule + 
                "\n"  + typeStr;
    }
}    
