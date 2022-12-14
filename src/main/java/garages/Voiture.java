package garages;

import java.io.PrintStream;
import java.util.*;

public class Voiture {

    private final String immatriculation;
    private final List<Stationnement> myStationnements = new LinkedList<>();

    public Voiture(String i) {
        if (null == i) {
            throw new IllegalArgumentException("Une voiture doit avoir une immatriculation");
        }

        immatriculation = i;
    }

    public String getImmatriculation() {
        return immatriculation;
    }

    /**
     * Fait rentrer la voiture au garage Précondition : la voiture ne doit pas
     * être déjà dans un garage
     *
     * @param g le garage où la voiture va stationner
     * @throws java.lang.Exception Si déjà dans un garage
     */
    public void entreAuGarage(Garage g) throws Exception {

        if (myStationnements.size() > 0) {
            if (myStationnements.get(myStationnements.size() - 1).estEnCours()) {
                throw new java.lang.Exception("La voiture est déjà dans un garage");
            }
            // Et si la voiture est déjà dans un garage ?
        }
        Stationnement s = new Stationnement(this, g);
        myStationnements.add(s);
    }

    /**
     * Fait sortir la voiture du garage Précondition : la voiture doit être dans
     * un garage
     *
     * @throws java.lang.Exception si la voiture n'est pas dans un garage
     */
    public void sortDuGarage() throws Exception {

        if (myStationnements.size() > 0) {
            if (!(myStationnements.get(myStationnements.size() - 1).estEnCours())) {

                throw new java.lang.Exception("La voiture doit être dans un garage pour en sortir");
            }
        }

        myStationnements.get(myStationnements.size() - 1).terminer();

        //throw new UnsupportedOperationException("Pas encore implémenté");
        // TODO: Implémenter cette méthode
        // Trouver le dernier stationnement de la voiture
        // Terminer ce stationnement
    }

    /**
     * @return l'ensemble des garages visités par cette voiture
     */
    public Set<Garage> garagesVisites() {
        // TODO: Implémenter cette méthode
        Set<Garage> listeVisites = new HashSet();

        for (Stationnement stationnement : myStationnements) {
            listeVisites.add(stationnement.getGarage());
        }

        return listeVisites;
        //throw new UnsupportedOperationException("Pas encore implémenté");
    }

    /**
     * @return vrai si la voiture est dans un garage, faux sinon
     */
    public boolean estDansUnGarage() {
        // TODO: Implémenter cette méthode
        boolean r = false;
        if (myStationnements.size() > 0) {
            if (myStationnements.get(myStationnements.size() - 1).estEnCours()) {
                r = true;
            }
            //	throw new UnsupportedOperationException("Pas encore implémenté");
            // Vrai si le dernier stationnement est en cours
        }
        return r;
    }

    /**
     * Pour chaque garage visité, imprime le nom de ce garage suivi de la liste
     * des dates d'entrée / sortie dans ce garage
     * <br>
     * Exemple :
     *
     * <pre>
     * Garage Castres:
     *		Stationnement{ entree=28/01/2019, sortie=28/01/2019 }
     *		Stationnement{ entree=28/01/2019, en cours }
     *  Garage Albi:
     *		Stationnement{ entree=28/01/2019, sortie=28/01/2019 }
     * </pre>
     *
     * @param out l'endroit où imprimer (ex: System.out)
     */
    public void imprimeStationnements(PrintStream out) {
        // TODO: Implémenter cette méthode
        Set<Garage> liste = this.garagesVisites();
        for (Garage g : liste) {
            out.println(g.toString());
            for (Stationnement stationnement : myStationnements) {
                if (stationnement.getGarage().equals(g)) {
                   out.println(stationnement.toString());
                }

            }

            //throw new UnsupportedOperationException("Pas encore implémenté");
        }

    }
}
