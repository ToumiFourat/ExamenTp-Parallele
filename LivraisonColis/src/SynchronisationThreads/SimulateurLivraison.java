package SynchronisationThreads;

import gestioncolis.Colis;
import gestioncolis.GestionnaireColis;
import InterfaceGraphique.MainApplication;

public class SimulateurLivraison extends Thread {
    private final GestionnaireColis gestionnaireColis;
    private final MainApplication mainApp; // Référence à l'interface graphique

    // Constructeur
    public SimulateurLivraison(GestionnaireColis gestionnaireColis, MainApplication mainApp) {
        this.gestionnaireColis = gestionnaireColis;
        this.mainApp = mainApp;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(5000); // Simulation toutes les 5 secondes.

                // Modifier les états des colis
                boolean miseAJourEffectuee = false;
                for (Colis colis : gestionnaireColis.obtenirColis()) {
                    if (colis.getEtat().equals("En attente")) {
                        colis.setEtat("En transit");
                        miseAJourEffectuee = true;
                    } else if (colis.getEtat().equals("En transit")) {
                        gestionnaireColis.marquerLivraison(colis.getId());
                        miseAJourEffectuee = true;
                    }
                }

                // Si une mise à jour a été effectuée, notifier l'interface graphique
                if (miseAJourEffectuee) {
                    mainApp.notifierChangementEtat();
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}
