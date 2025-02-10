package models;

public class Personne {
        private String nom;
        private String prenom;
        private Personne[] copains;
        private int nbCopains;  // Nombre actuel de copains
        public static final int MAX_COPAINS = 10;  // Constante MAX_COPAINS
    
        // Constructeur
        public Personne(String prenom, String nom) {
            this.prenom = prenom;
            this.nom = nom;
            this.copains = new Personne[MAX_COPAINS];  // Tableau de copains
            this.nbCopains = 0;  // Aucun copain au début
        }
    
        // Surcharge de la méthode toString()
        public String toString() {
            // Si le tableau des copains est vide
            if (nbCopains == 0) {
                return prenom + " " + nom.toUpperCase() + " et ses copains ()";
            }
    
            // Sinon on liste les copains
            String result = prenom + " " + nom.toUpperCase() + " et ses copains (";
    
            for (int i = 0; i < nbCopains; i++) {
                result += copains[i].prenom + " " + copains[i].nom.toUpperCase();
                if (i < nbCopains - 1) {
                    result += ", ";
                }
            }
            result += ")";
            return result;
        }
    
        // Méthode pour tenter d'ajouter un copain
        public boolean tenterAjouterCopain(Personne copain) {
            if (nbCopains < MAX_COPAINS) {
                // Vérifier si le copain est déjà dans le tableau
                for (int i = 0; i < nbCopains; i++) {
                    if (copains[i] == copain) {
                        return false;  // Copain déjà ajouté
                    }
                }
                copains[nbCopains] = copain;  // Ajoute le copain
                nbCopains++;  // Incrémenter le nombre de copains
                return true;  // Ajout réussi
            }
            return false;  // Impossible d'ajouter, la limite est atteinte
        }
    
        // Méthode pour tenter de supprimer un copain
        public boolean tenterSupprimerCopain(Personne copain) {
            for (int i = 0; i < nbCopains; i++) {
                if (copains[i] == copain) {
                    // Déplacer tous les copains après l'élément supprimé d'une case vers la gauche
                    for (int j = i; j < nbCopains - 1; j++) {
                        copains[j] = copains[j + 1];
                    }
                    copains[nbCopains - 1] = null;  // Libère la dernière case
                    nbCopains--;  // Décrémenter le nombre de copains
                    return true;  // Suppression réussie
                }
            }
            return false;  // Copain non trouvé
        }
    
        // Méthode main pour tester
        public static void main(String[] args) {
            Personne p1 = new Personne("Alex", "Terrieur");
            Personne p2 = new Personne("John", "D'Oeuf");
            Personne p3 = new Personne("Mac", "Haroni");
            Personne p4 = new Personne("Alain", "Terrieur");
    
            // Tentons d'ajouter des copains
            p1.tenterAjouterCopain(p2);  // Alex ajoute John
            p1.tenterAjouterCopain(p3);  // Alex ajoute Mac
            p1.tenterAjouterCopain(p4);  // Alex ajoute Alain
    
            // Affichage après ajout des copains
            System.out.println(p1.toString());
    
            // Tentons de supprimer un copain
            p1.tenterSupprimerCopain(p3);  // Alex supprime Mac
    
            // Affichage après suppression
            System.out.println(p1.toString());
        }
    }