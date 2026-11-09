
package cm.uy1;

import java.util.ArrayList;

public class EquationFictive implements IEquation {

    @Override
    public ArrayList<Double> resoudre(double a, double b, double c) {

        // Valeur fictive : aucun calcul mathématique
        ArrayList<Double> resultat = new ArrayList<>();

        resultat.add(1.0);
        resultat.add(2.0);

        return resultat;
    }
}
