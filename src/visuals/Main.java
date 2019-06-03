package visuals;

import domain.Senate;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import services.AuditLog;


public class Main extends Application
{
    public static void main(String[] args)
    {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception
    {
        AuditLog.open();
        Senate spqr = new Senate();
        spqr.readSoldiers();
        spqr.rating();
        ArcherController.setSpqr(spqr);

        Parent root = FXMLLoader.load(getClass().getResource("primaryStage.fxml"));
        primaryStage.setTitle("Main Menu");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

        AuditLog.close();
    }

}