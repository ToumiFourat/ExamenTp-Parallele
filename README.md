# Simulation d’un Système de Livraison de Colis

## Description
Ce projet simule un système de gestion de livraison de colis en utilisant des concepts de programmation parallèle tels que les **threads**, les **sémaphores** et les **moniteurs**.  
Il inclut une interface graphique interactive (JavaFX) permettant de visualiser et d’interagir avec les colis enregistrés.

---

## Fonctionnalités
1. **Enregistrement des Colis**  
   - Plusieurs utilisateurs (threads) peuvent enregistrer des colis simultanément.  
   - Synchronisation assurée pour éviter les conflits.  

2. **Livraison des Colis**  
   - Simulation de la livraison des colis avec une mise à jour de leur état (`En attente`, `En transit`, `Livré`).  

3. **Affichage des États des Colis**  
   - Interface graphique pour visualiser les colis et leurs statuts en temps réel.  

---

## Technologies utilisées
- **Langage** : Java  
- **Interface graphique** : SWING  
- **Concepts parallèles** : Threads, Sémaphores, Moniteurs  

---


### Classes principales :
1. **Colis** : représente un colis avec ses attributs (`id`, `destination`, `état`, etc.).  
2. **GestionnaireColis** : gère les opérations d'enregistrement, de mise à jour des états, et de livraison.  
3. **MainApplication** : gère l’affichage via SWING.  
4. **SimilateurLivraison** : simule les utilisateurs enregistrant des colis.  
  

---

## Synchronisation
- **Threads** : utilisés pour simuler des utilisateurs concurrents.  
- **Sémaphores** : limitent le nombre de threads accédant simultanément à des ressources partagées.  
- **Moniteurs** : garantissent l’exclusion mutuelle lors de l’accès aux données.  

---

## Installation
1. **Cloner le dépôt** :
   ```bash
   git clone https://github.com/ToumiFourat/ExamenTp-Parallele.git
   cd ExamenTp-Parallele
