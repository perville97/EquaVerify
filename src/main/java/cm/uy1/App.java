package cm.uy1;

public class App {

    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println(
                "Utilisation : java cm.uy1.App nom.complet.ClasseSolveur"
            );
            return;
        }

        try {
            IEquation solveur = EquationLoader.charger(args[0]);

            System.out.println("Solveur chargé avec succès !");

            System.out.println(
                "Résultat : " + solveur.resoudre(1, -3, 2)
            );

        } catch (ReflectiveOperationException
                 | IllegalArgumentException e) {

            System.err.println(
                "Impossible de charger le solveur : " + e.getMessage()
            );
        }
    }
}