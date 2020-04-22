package sample;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class View {

    Stage stage;
    Pane group;
    Scene scene;
    BackgroundImage myBI;




    public void initialize()
    {
        group.setBackground(new Background(myBI));
        stage.setTitle("Hello World");
        stage.setScene(scene);
        stage.show();
    }

    public View(Stage stage1)
    {
        stage = stage1;
        group = new Pane();
        scene = new Scene(group, 1050, 800);
        myBI= new BackgroundImage(new Image("file:mapa.png",900 ,800,false,true),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
    }
}
