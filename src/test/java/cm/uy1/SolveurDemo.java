package cm.uy1;

import java.util.ArrayList;

public class SolveurDemo implements IEquation {

    @Override
    public ArrayList<Double> resoudre(double a, double b, double c) {

        ArrayList<Double> racines = new ArrayList<>();

        // if (a == 0) {
        //     throw new IllegalArgumentException(
        //         "Le coefficient a doit être différent de zéro"
        //     );
        // }

        double delta = b * b - 4 * a * c;

        if (delta > 0) {
            racines.add((-b - Math.sqrt(delta)) / (2 * a));
            racines.add((-b + Math.sqrt(delta)) / (2 * a));

        } else if (delta == 0) {
            racines.add(-b / (2 * a));
        }

        return racines;
    }
}