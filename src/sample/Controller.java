package sample;

import javafx.stage.Stage;

/**
 * Klasa Controller zarządza działaniem aplikacji.
 */
public class Controller
{
    /**
     * Referencja na primary stage
     */
    private Stage stage;

    /**
     * Obiekt typu Country.
     */
    private Country country;

    /**
     * Referencja na ostatniego potomka.
     */
    private Specimen specimen;

    /**
     * Referencja na tablicę hospitals ostatniego potomka.
     */
    private int hospitals[];

    /**
     * Obiekt typu Map.
     */
    private Map map;

    /**
     * Obiekt typu Evolution.
     */
    private Evolution evolution;

    /**
     * Referencja na tablicę field ostatniego osobnika.
     */
    private int field[][];

    /**
     * Obiekt typu View.
     */
    private View view;

    /**
     * Współrzędna X pierwszego napisu w oknie wynikowym.
     */
    private int x = 905;

    /**
     * Współrzędna Y pierwszego napisu w oknie wynikowym.
     */
    private int y = 20;

    /**
     * Konstruktor klasy Controller
     * @param stage przekazuje primaryStage
     */
    public Controller(Stage stage)
    {
        this.stage = stage;
    }

    /**
     * Rozpoczęcie programu.
     */
    public void start()
    {
        country = new Country();

        map = new Map(country.getCities(), country.getBorderPoints(), country.getBorders());

        evolution = new Evolution();

        specimen = evolution.evolution_control();

        hospitals = specimen.getHospitals();

        field = specimen.getField();

        view = new View(stage);
        view.initialize();

        for(int i = 0; i < 74; i++)
        {
            if(hospitals[i] == 1)
                view.addCircle(country.getCity(i).getX_coor(), country.getCity(i).getY_coor(), 187);
        }


        for(int i = 0; i < 74; i++)
        {
            if(hospitals[i] == 1) {
                view.addText(x, y, country.getCity(i).getName());
                y += 20;
            }
        }

        y += 20;
        view.addText(x, y, "Liczba pokoleń:");
        y += 20;
        view.addText(x, y, Integer.toString(evolution.getCounter() - 20));

    }
}
