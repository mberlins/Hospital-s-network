package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception
    {

        //View view = new View(primaryStage);
        //view.initialize();
        Country country = new Country();
        Map map = new Map(country.getCities(), country.getBorderPoints(), country.getBorders());
        //Specimen pacjent_zero = new Specimen(1, country.getCities(), map);
        Specimen patient_zero = new Specimen(1, map);
        int a = patient_zero.adaptation();
        //System.out.print(a);


    }


    public static void main(String[] args)
    {
        launch(args);
    }
}