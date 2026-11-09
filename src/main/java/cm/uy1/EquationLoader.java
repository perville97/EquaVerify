
package cm.uy1;

public class EquationLoader {

    public static IEquation charger(String nomClasse)
            throws ReflectiveOperationException {

        // 1. Charger la classe à partir de son nom
        Class<?> classe = Class.forName(nomClasse);

        // 2. Vérifier que la classe implémente IEquation
        if (!IEquation.class.isAssignableFrom(classe)) {
            throw new IllegalArgumentException(
                "La classe ne respecte pas le contrat IEquation."
            );
        }

        // 3. Créer une instance dynamiquement
        Object objet = classe.getDeclaredConstructor().newInstance();

        // 4. Convertir l'objet en IEquation
        return (IEquation) objet;
    }
}
