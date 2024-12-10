package gestioncolis;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.Date;

public class GestionnaireColis {
    private final List<Colis> colisList = new ArrayList<>();
    private final Semaphore semaphore = new Semaphore(1); // Sémaphore pour synchroniser l'accès.

    // Méthode pour ajouter un colis à la liste
    public void ajouterColis(Colis colis) {
        try {
            semaphore.acquire(); // Accès exclusif à la liste des colis.
            colisList.add(colis);
            System.out.println("Colis ajouté: " + colis.getId());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            semaphore.release(); // Libération du sémaphore.
        }
    }

    // Méthode pour obtenir la liste des colis
    public List<Colis> obtenirColis() {
        try {
            semaphore.acquire();
            return new ArrayList<>(colisList); // Retourne une copie pour éviter les conflits.
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return new ArrayList<>();
        } finally {
            semaphore.release();
        }
    }

    // Méthode pour marquer un colis comme livré
    public synchronized void marquerLivraison(int id) {
        try {
            semaphore.acquire(); // Accès exclusif pour éviter les conflits de modification.

            // Recherche du colis par ID et mise à jour de son état
            for (Colis colis : colisList) {
                if (colis.getId() == id) {
                    // Mise à jour de l'état du colis
                    colis.setEtat("Livré");
                    colis.setDateLivraison(new Date());  // Mise à jour de la date de livraison
                    System.out.println("Colis ID: " + id + " marqué comme livré.");
                    return;
                }
            }
            System.out.println("Colis avec ID " + id + " non trouvé.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            semaphore.release();
        }
    }

    // Méthode pour afficher l'état de tous les colis
    public void afficherEtatColis() {
        try {
            semaphore.acquire();  // Accès exclusif pour afficher les colis
            for (Colis colis : colisList) {
                System.out.println(colis.afficherDetails());  // Affiche les détails de chaque colis
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            semaphore.release();
        }
    }
}
