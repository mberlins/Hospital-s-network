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
        int hospitals[];
        Specimen specimen;
        Country country = new Country();
        Map map = new Map(country.getCities(), country.getBorderPoints(), country.getBorders());
        //Specimen pacjent_zero = new Specimen(1, country.getCities(), map);
        //Specimen patient_zero = new Specimen(1, map);
        //int a = patient_zero.adaptation();
        //System.out.print(a);

        Evolution evolution = new Evolution();

        specimen = evolution.evolution_control();

        hospitals = specimen.getHospitals();

        int field[][] = specimen.getField();

        View view = new View(primaryStage);
        view.initialize();

        for(int i = 0; i < 74; i++)
        {
            if(hospitals[i] == 1)
                view.addCircle(country.getCity(i).getX_coor(), country.getCity(i).getY_coor(), 187);
        }

        for (int i = 0; i < 649; i++) {
            for (int j = 0; j < 689; j++)
                System.out.print(field[i][j]);

            System.out.println("\n");
        }

        for (int i = 0; i < 74; i++)
            System.out.print(hospitals[i]);


    }


    public static void main(String[] args)
    {
        launch(args);
    }
}