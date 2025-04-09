package Control;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;

public class RechercheControl {

    @FXML
    private TextField identifiantField;

    @FXML
    private Button verifierBtn;

    @FXML
    private Label resultatLabel;

    @FXML
    void verifierObjet() {
        String identifiant = identifiantField.getText().trim();

        // Ici on simule une recherche
        if (identifiant.equalsIgnoreCase("123ABC")) {
            resultatLabel.setText("⚠️ Objet déclaré volé !");
        } else {
            resultatLabel.setText("✅ Objet non déclaré volé.");
        }
    }
}
