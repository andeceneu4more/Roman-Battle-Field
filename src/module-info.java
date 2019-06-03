module RomanBattleField
{
    requires javafx.fxml;
    requires javafx.controls;
    requires kotlin.stdlib;
    requires java.sql;

    opens visuals;
    opens domain.individuals;
}