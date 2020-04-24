package sample;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Klasa View jest odpowiedzialna za wyświetlanie wyniku algorytmu.
 */
public class View {

    /**
     * Referencja na primaryStage.
     */
    private Stage stage;

    /**
     * Obiekt typu Pane.
     */
    private Pane group;

    /**
     * Obiekt typu Scene, główna scena.
     */
    private Scene scene;

    /**
     * Obiekt typu BackgroundImage, wyświetla tło w postaci mapy Polski.
     */
    private BackgroundImage myBI;


    /**
     * Inicjuje i buduje okno.
     */
    public void initialize() {
        group.setBackground(new Background(myBI));
        stage.setTitle("Hospitals locations - Evolutionary algorithm");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Konstruktor klasy View
     * @param stage przekazuje primaryStage
     */
    public View(Stage stage) {
        this.stage = stage;
        group = new Pane();
        scene = new Scene(group, 1050, 800);
        myBI = new BackgroundImage(new Image("file:mapa.png", 900, 800, false, true),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
    }

    /**
     * Dodaje okrąg oznaczający zasięg szpitala na mapie
     * @param x współrzędna x środka okręgu
     * @param y współrzędna y środka okręgu
     * @param radius promień okręgu
     */
    public void addCircle(double x, double y, double radius) {
        Color color = Color.web("0x0000FF", 0.3);
        Circle circle = new Circle(x + 88, y + 77, radius, color);
        group.getChildren().addAll(circle);
    }

    /**
     * Dodaje okrąg oznaczający zasięg szpitala na mapie
     * @param x współrzędna x początku napisu
     * @param y współrzędna y początku napisu
     * @param name  tekst napisu
     */
    public void addText(double x, double y, String name) {
        Text lastReward = new Text(x, y, name);
        lastReward.setFont(new Font("Book Antiqua", 15));
        lastReward.setFill(Color.BLACK);
        group.getChildren().add(lastReward);
    }

}