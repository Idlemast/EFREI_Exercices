package projet_final;

/**
GRP : William WAN & Hsiao-Wen-Paul LO
 */

public class RendezVous {
    // Attributs
    private Client client;
    private Prestation prestation;
    private double prix;
    
    // Constructeurs
    public RendezVous(Client client, Prestation prestation, double prix) {
        this.client = client;
        this.prestation = prestation;
        this.prix = prix;
    }
    
    // Getters
    public Client getClient() {
        return client;
    }
    
    public Prestation getPrestation() {
        return prestation;
    }
    
    public double getPrix() {
        return prix;
    }
    
    // Setters 
    public void setPrix(double prix) {
        this.prix = prix;
    }
    
    // ToString()
    @Override
    public String toString() {
        return "Rendez-vous de " + client.getNom() + 
               " N°" + client.getNumero() + "\n" +
               " - Prestation : " + prestation + "\n" +
               " - Prix : " + prix + " €";
    }
}
