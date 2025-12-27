package projet_final;

/**
GRP : William WAN & Hsiao-Wen-Paul LO
 */

class PrestationSale extends Prestation {
    // Constructeurs
    public PrestationSale(char categorieVehicule) {
    super(categorieVehicule); // classe mère prestation 
    }
    // Methodes
    @Override
    public double nettoyage() {
        return prelavage() + lavage() + sechage() + prixNettoyageInterieur();
    }
        
    // ToString()
    @Override
    public String toString() {
        return "Prestation Sale - Catégorie du véhicule : " + categorieVehicule + 
                " - Avec prélavage et nettoyage intérieur";
    }
}
