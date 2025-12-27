package projet_final;

/**
GRP : William WAN & Hsiao-Wen-Paul LO
 */

public class Client {
    // Attributs
    private int numeroClient;
    private String nom;
    private String telephone;
    private String email;
    
    // Constructeurs
    // Sans email
    public Client(int numeroClient, String nom, String telephone) {
        this.numeroClient = numeroClient;
        this.nom = nom;
        this.telephone = telephone;
        this.email = null; 
    }
    
    // Avec email
    public Client(int numeroClient, String nom, String telephone, String email) {
        this.numeroClient = numeroClient;
        this.nom = nom;
        this.telephone = telephone;
        this.email = email;
    }
    
    // Getters
    public int getNumero() {
        return numeroClient;
    }
    
    public String getNom() {
        return nom;
    }
    
    public String getTelephone() {
        return telephone;
    }
    
    public String getEmail() {
        return email;
    }
    // Methodes 
    public boolean placerApres(Client autre) {
        // Comparaison par nom en utilisant comparetoignorecase
        int comparaisonNom = this.nom.compareToIgnoreCase(autre.nom);
        
        if (comparaisonNom > 0) {
            return true;
        } else if (comparaisonNom < 0) {
            return false;
        } else {
            // Si le nom est pareil, on fait avec le numéro de téléphone ( qui doit départager )
            // On peut utiliser compareto à la place de ignorecase parce que c'est un num de tel 
            return this.telephone.compareTo(autre.telephone) > 0;
        }
    }
    
    // ToString()
    @Override
    public String toString() {
        String texte = "Client N°" + numeroClient + " " + nom + " "
        + telephone ;
        if (email != null && !email.isEmpty()) {
            texte += " - " + email;
        }
        return texte;
    }
}