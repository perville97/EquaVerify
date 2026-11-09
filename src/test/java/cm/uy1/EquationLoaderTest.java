
package cm.uy1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EquationLoaderTest {


    void doitChargerUneClasseImplementantIEquation() throws Exception {

        // Arrange : préparer le nom de la classe
        String nomClasse = "cm.uy1.EquationFictive";

        // Act : charger dynamiquement la classe
        IEquation equation = EquationLoader.charger(nomClasse);

        // Assert : vérifier le résultat
        assertNotNull(equation);
        assertInstanceOf(IEquation.class, equation);
    }
}
