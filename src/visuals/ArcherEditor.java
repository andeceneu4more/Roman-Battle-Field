package visuals;

import domain.individuals.Archer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ArcherEditor implements Initializable
{

    private Archer object;

    @FXML
    private TextField soldierId;

    @FXML
    private TextField name;

    @FXML
    private TextField health;

    @FXML
    private TextField stamina;

    @FXML
    private TextField xp;

    @FXML
    private TextField age;

    @FXML
    private TextField rangeDamage;

    @FXML
    private TextField criticalHitRate;

    @FXML
    private Button saveButton;

    @FXML
    private Button backButton;

    @FXML
    private Button resetButton;

    @FXML
    void onBackClick(ActionEvent event) throws Exception
    {
        Parent pane = FXMLLoader.load(getClass().getResource("archer.fxml"));
        Scene scene = new Scene(pane);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setTitle("Archers");
        window.setScene(scene);
        window.show();
    }

    @FXML
    void onResetClick(ActionEvent event)
    {
        soldierId.setText(Integer.toString(object.getSoldierId()));
        name.setText("");
        health.setText("");
        stamina.setText("");
        xp.setText("");
        age.setText("");
        rangeDamage.setText("");
        criticalHitRate.setText("");
    }

    @FXML
    void onSaveClick(ActionEvent event)
    {
        object.setSoldierId(Integer.parseInt(soldierId.getText()));
        object.setName(name.getText());
        object.setHealth(Integer.parseInt(health.getText()));
        object.setStamina(Integer.parseInt(stamina.getText()));
        object.setXp(Integer.parseInt(xp.getText()));
        object.setAge(Integer.parseInt(age.getText()));
        object.setRangeDamage(Integer.parseInt(rangeDamage.getText()));
        object.setCriticalHitRate(Double.parseDouble(criticalHitRate.getText()));

        ArcherController.setObject(object);
        ArcherController.saveObject();
    }


    public void initialize(URL url, ResourceBundle rb)
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("archer.fxml"));

        object = ArcherController.getObject();

        if (object == null)
            object = new Archer();

        soldierId.setText(Integer.toString(object.getSoldierId()));
        name.setText(object.getName());
        health.setText(Integer.toString(object.getHealth()));
        stamina.setText(Integer.toString(object.getStamina()));
        xp.setText(Integer.toString(object.getXp()));
        age.setText(Integer.toString(object.getAge()));
        rangeDamage.setText(Integer.toString(object.getRangeDamage()));
        criticalHitRate.setText(Double.toString(object.getCriticalHitRate()));
    }
}
