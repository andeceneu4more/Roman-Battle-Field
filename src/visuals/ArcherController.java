package visuals;

import domain.Senate;
import domain.individuals.Archer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import tools.Enrollment;

import java.net.URL;
import java.util.ResourceBundle;

public class ArcherController implements Initializable
{
    private static Archer object;
    private static Senate spqr;

    public static Archer getObject()
    {
        return object;
    }

    public static void setObject(Archer object)
    {
        ArcherController.object = object;
    }

    public static void setSpqr(Senate spqr)
    {
        ArcherController.spqr = spqr;
    }

    @FXML
    private TableView<Archer> table;

    @FXML
    private TableColumn<Integer, Archer> soldierId;

    @FXML
    private TableColumn<Integer, Archer> unitId;

    @FXML
    private TableColumn<String, Archer> name;

    @FXML
    private TableColumn<Integer, Archer> health;

    @FXML
    private TableColumn<Integer, Archer> stamina;

    @FXML
    private TableColumn<Integer, Archer> xp;

    @FXML
    private TableColumn<Integer, Archer> age;

    @FXML
    private TableColumn<Integer, Archer> rangeDamage;

    @FXML
    private TableColumn<Double, Archer> criticalHitRate;

    @FXML
    private Button add;

    @FXML
    private Button edit;

    @FXML
    private Button kill;

    @FXML
    private Button getRandom;

    @FXML
    private Button mainMenu;

    public static void saveObject()
    {
        spqr.addArcher(object);
    }

    @FXML
    void onAddClick(ActionEvent event) throws Exception
    {
        Enrollment enrollment = new Enrollment();
        object = enrollment.withType("Archer").enrollArcher();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("archer-edit.fxml"));
        Parent pane = loader.load();
        Scene scene = new Scene(pane);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setTitle("Archer Editor");
        window.setScene(scene);
        window.show();
    }

    @FXML
    void onEditClick(ActionEvent event) throws Exception
    {
        Archer element = table.getSelectionModel().getSelectedItem();
        if (element != null)
        {
            object = element;

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("archer-edit.fxml"));
            Parent pane = loader.load();
            Scene scene = new Scene(pane);

            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setTitle("Archer Editor");
            window.setScene(scene);
            window.show();
        }
    }

    @FXML
    void onGetRandomClick(ActionEvent event) throws Exception
    {
        object = spqr.getRandomArcher();
        if (object != null)
        {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("archer-edit.fxml"));
            Parent pane = loader.load();
            Scene scene = new Scene(pane);

            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setTitle("Archer Editor");
            window.setScene(scene);
            window.show();
        }
    }

    @FXML
    void onKillClick(ActionEvent event) throws Exception
    {
        Archer element = table.getSelectionModel().getSelectedItem();
        if (element != null)
        {
            spqr.killSoldierById(element.getSoldierId());
            table.setItems(spqr.getAllArchers());
        }
    }

    @FXML
    void onMainMenuClick(ActionEvent event) throws Exception
    {
        Parent pane = FXMLLoader.load(getClass().getResource("primaryStage.fxml"));
        Scene scene = new Scene(pane);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setTitle("Main Menu");
        window.setScene(scene);
        window.show();
    }

    @FXML
    public void initialize(URL url, ResourceBundle rs)
    {
        soldierId.setCellValueFactory(new PropertyValueFactory<>("soldierId"));
        unitId.setCellValueFactory(new PropertyValueFactory<>("unitId"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        health.setCellValueFactory(new PropertyValueFactory<>("health"));
        stamina.setCellValueFactory(new PropertyValueFactory<>("stamina"));
        xp.setCellValueFactory(new PropertyValueFactory<>("xp"));
        age.setCellValueFactory(new PropertyValueFactory<>("age"));
        rangeDamage.setCellValueFactory(new PropertyValueFactory<>("rangeDamage"));
        criticalHitRate.setCellValueFactory(new PropertyValueFactory<>("criticalHitRate"));

        table.setItems(spqr.getAllArchers());
    }

    @FXML
    void onUpdateClick(ActionEvent event)
    {
        spqr.writeDataBaseSoldiers();
    }
}
