package gestioncolis;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Colis {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy HH:mm");

    private int id;
    private String etat; // Etat : "En attente", "En transit", "Livré"
    private String detailsUtilisateur; // Nom et autres détails de l'utilisateur
    private String destination; // Destination du colis
    private Date dateEnregistrement; // Date d'ajout du colis
    private Date dateLivraison; // Date de livraison si disponible

    public Colis(int id, String etat, String detailsUtilisateur, String destination, Date dateEnregistrement, Date dateLivraison) {
        this.id = id;
        this.etat = etat;
        this.detailsUtilisateur = detailsUtilisateur;
        this.destination = destination;
        this.dateEnregistrement = dateEnregistrement;
        this.dateLivraison = dateLivraison;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getEtat() { return etat; }

    public void setEtat(String etat) { this.etat = etat; }

    public String getDetailsUtilisateur() { return detailsUtilisateur; }

    public void setDetailsUtilisateur(String detailsUtilisateur) { this.detailsUtilisateur = detailsUtilisateur; }

    public String getDestination() { return destination; }

    public void setDestination(String destination) { this.destination = destination; }

    public Date getDateEnregistrement() { return dateEnregistrement; }

    public void setDateEnregistrement(Date dateEnregistrement) { this.dateEnregistrement = dateEnregistrement; }

    public Date getDateLivraison() { return dateLivraison; }

    public void setDateLivraison(Date dateLivraison) { this.dateLivraison = dateLivraison; }

    // Affichage des détails avec formatage des dates
    public String afficherDetails() {
        String dateEnregistrementFormattee = DATE_FORMAT.format(dateEnregistrement);
        String dateLivraisonFormattee = (dateLivraison != null) ? DATE_FORMAT.format(dateLivraison) : "Non livrée";

        return "ID: " + id + "\n" +
               "État: " + etat + "\n" +
               "Utilisateur: " + detailsUtilisateur + "\n" +
               "Destination: " + destination + "\n" +
               "Date Enregistrement: " + dateEnregistrementFormattee + "\n" +
               "Date Livraison: " + dateLivraisonFormattee;
    }
    @Override
    public String toString() {
        return "ID: " + id + 
               " | État: " + etat + 
               " | Utilisateur: " + detailsUtilisateur + 
               " | Destination: " + destination + 
               " | Enregistré le: " + dateEnregistrement.toString() +
               " | Livré le: " + (dateLivraison != null ? dateLivraison.toString() : "Non livré");
    }

}
