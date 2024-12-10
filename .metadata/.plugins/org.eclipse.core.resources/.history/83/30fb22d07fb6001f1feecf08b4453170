package InterfaceGraphique;

import gestioncolis.Colis;
import gestioncolis.GestionnaireColis;
import SynchronisationThreads.SimulateurLivraison;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Date;

public class MainApplication extends JFrame {

    private final GestionnaireColis gestionnaireColis = new GestionnaireColis();
    private final DefaultListModel<Colis> listModel = new DefaultListModel<>();
    private final JList<Colis> colisList = new JList<>(listModel);

    private JPanel formPanel;
    private JTextField utilisateurField;
    private JTextField destinationField;
    private JButton ajouterButton;

    public MainApplication() {
        setTitle("Système de Livraison de Colis");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Configuration principale avec un BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // En-tête
        JLabel headerLabel = new JLabel("Gestion des Colis", SwingConstants.CENTER);
        headerLabel.setFont(new Font("SansSerif", Font.BOLD, 24));
        mainPanel.add(headerLabel, BorderLayout.NORTH);

        // Créer et configurer le formulaire
        initComponents(); // Configuration des composants

        // Ajouter le formulaire dans la partie supérieure
        mainPanel.add(formPanel, BorderLayout.PAGE_START);

        // Liste des colis
        JScrollPane scrollPane = new JScrollPane(colisList);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Liste des Colis"));
        colisList.setFont(new Font("SansSerif", Font.PLAIN, 14));

        // Listener pour les détails du colis
        colisList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && colisList.getSelectedValue() != null) {
                Colis selectedColis = colisList.getSelectedValue();
                JOptionPane.showMessageDialog(this, selectedColis.afficherDetails(),
                        "Détails du Colis", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        // Ajouter la liste sous le formulaire
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        // Pied de page
        JLabel footerLabel = new JLabel("Application développée par Fourat", SwingConstants.CENTER);
        footerLabel.setFont(new Font("SansSerif", Font.ITALIC, 12));
        mainPanel.add(footerLabel, BorderLayout.SOUTH);

        // Ajouter le panneau principal à la fenêtre
        add(mainPanel);

        new SimulateurLivraison(gestionnaireColis, this).start();
    }

    private void initComponents() {
        formPanel = new JPanel(new GridBagLayout());
        formPanel.setBorder(BorderFactory.createTitledBorder("Ajouter un Colis"));

        // Ajouter le champ utilisateur
        addComponent(formPanel, new JLabel("Nom Utilisateur:"), 0, 0);
        utilisateurField = new JTextField(20);
        addComponent(formPanel, utilisateurField, 1, 0);

        // Ajouter le champ destination
        addComponent(formPanel, new JLabel("Destination:"), 0, 1);
        destinationField = new JTextField(20);
        addComponent(formPanel, destinationField, 1, 1);

        // Ajouter le bouton
        ajouterButton = new JButton("Ajouter");
        addComponent(formPanel, ajouterButton, 1, 2);

        // Écouter les actions sur Entrée ou bouton
        utilisateurField.addActionListener(this::ajouterAction);
        destinationField.addActionListener(this::ajouterAction);
        ajouterButton.addActionListener(this::ajouterAction);
    }

    private void addComponent(Container container, Component component, int x, int y) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.anchor = GridBagConstraints.WEST;
        container.add(component, gbc);
    }

    private void ajouterAction(ActionEvent e) {
        String utilisateur = utilisateurField.getText();
        String destination = destinationField.getText();
        if (!utilisateur.isEmpty() && !destination.isEmpty()) {
            Colis colis = new Colis(
                    gestionnaireColis.obtenirColis().size() + 1,
                    "En attente",
                    utilisateur,
                    destination,
                    new Date(),
                    null
            );
            gestionnaireColis.ajouterColis(colis);
            utilisateurField.setText("");
            destinationField.setText("");
            mettreAJourListe();
        } else {
            JOptionPane.showMessageDialog(this, "Veuillez remplir tous les champs.",
                    "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void mettreAJourListe() {
        listModel.clear();
        for (Colis colis : gestionnaireColis.obtenirColis()) {
            listModel.addElement(colis);
        }
    }

    public synchronized void notifierChangementEtat() {
        SwingUtilities.invokeLater(this::mettreAJourListe);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainApplication().setVisible(true));
    }
}
