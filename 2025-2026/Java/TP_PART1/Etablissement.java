package projet_final;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;

/**
GRP : William WAN & Hsiao-Wen-Paul LO
 */

public class Etablissement {
    // Attributs
    private String nom;
    private int nombreClients;
    private Client[] clients;
    private RendezVous[][] planning; 
    
    // Constantes 
    private static final int NOMBRE_CRENEAUX = 16; // 10h-18h = 8h*2 ( 30 mins ) donc 16 créneaux
    private static final int NOMBRE_JOURS = 7;     
    private static final int MAX_CLIENTS = 5000; 
    
    // Constructeurs
    public Etablissement(String nom) {
        this.nom = nom;
        this.nombreClients = 0;
        this.clients = new Client[MAX_CLIENTS];
        this.planning = new RendezVous[NOMBRE_CRENEAUX][NOMBRE_JOURS];
    }
    
    // Getters
    public String getNom() {
        return nom;
    }
    
    public int getNombreClients() {
        return nombreClients;
    }
    
    public Client[] getClients() {
        return clients;
    }
    
    public RendezVous[][] getPlanning() {
        return planning;
    }
    // Methodes
    public Client rechercher(String nom, String telephone) {
        for (int i = 0; i < nombreClients; i++) {
            if (clients[i].getNom().equalsIgnoreCase(nom) && 
                clients[i].getTelephone().equals(telephone)) {
                return clients[i];
            }
        }
        return null; 
    }
    
    public Client ajouter(String nom, String telephone) {
        
        if (nombreClients >= MAX_CLIENTS) {
            System.out.println("On n'a plus de places pour de nouveaux clients (limite 5000 atteinte).");
            return null;
        }
        
        int nouveauNumero = nombreClients + 1;
        Client nouveauClient = new Client(nouveauNumero, nom, telephone);
        
        // Cherche et décale en même temps en commençant par la fin 
        int i = nombreClients;
        while (i > 0 && clients[i - 1].placerApres(nouveauClient)) {
            clients[i] = clients[i - 1];
            i--;
        }
        
        clients[i] = nouveauClient;
        nombreClients++;
        
        return nouveauClient;
    }
    
    public Client ajouter(String nom, String telephone, String email) {
        if (nombreClients >= MAX_CLIENTS) {
            System.out.println("On n'a plus de places pour de nouveaux clients (limite 5000 atteinte).");
            return null;
        }
        
        int nouveauNumero = nombreClients + 1;
        Client nouveauClient = new Client(nouveauNumero, nom, telephone, email);
        
        int i = nombreClients;
        while (i > 0 && clients[i - 1].placerApres(nouveauClient)) {
            clients[i] = clients[i - 1];
            i--;
        }
        
        clients[i] = nouveauClient;
        nombreClients++;
        
        return nouveauClient;
    }
    // ToString()
    @Override
    public String toString() {
        String message = "Établissement : " + nom + "\n";
        message += "Clients enregistrés : " + nombreClients + "/" + MAX_CLIENTS + "\n";
        message += "Liste des clients :\n";

        for (int i = 0; i < nombreClients; i++) {
            message += " - " + clients[i].toString() + "\n";
        }

        return message;
    }
    
}