package visuals;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;

import javafx.event.ActionEvent;
import javafx.stage.Stage;

public class Visual
{
    @FXML
    private TextField tfGuild;

    @FXML
    public void onContinueClick(ActionEvent event) throws Exception
    {
        if (tfGuild.getText().equals("Archers"))
        {
            Parent pane = FXMLLoader.load(getClass().getResource("archer.fxml"));
            Scene scene = new Scene(pane);

            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setTitle("Archers");
            window.setScene(scene);
            window.show();
        }
    }

}
