package cm.uy1;

public class EquivalenceClasses {

    // Classes de a : le zéro est exclu
    // car a doit être différent de zéro.
    public static final double[] A = {
        1e10,       // Grand positif
        -1e10,      // Grand négatif
        1e2,        // Nominal positif
        -1e2,       // Nominal négatif
        1e-3,       // Petit positif
        -1e-3,      // Petit négatif
        -1e-8,      // Proche de zéro négatif
        1e-8        // Proche de zéro positif
    };

    // Classes de b : les 9 classes sont autorisées.
    public static final double[] B = {
        1e10,
        -1e10,
        0,
        1e2,
        -1e2,
        1e-3,
        -1e-3,
        -1e-8,
        1e-8
    };

    // Classes de c : les 9 classes sont autorisées.
    public static final double[] C = {
        1e10,
        -1e10,
        0,
        1e2,
        -1e2,
        1e-3,
        -1e-3,
        -1e-8,
        1e-8
    };
}