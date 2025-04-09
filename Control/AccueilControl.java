package Control;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class AccueilControl {

    @FXML
    private Button rechercherBtn;

    @FXML
    void allerVersRecherche(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/recherche.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) rechercherBtn.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Recherche d'un objet volé");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
