package sample;

/**
 * Klasa City przechowuje informacje o pojedynczym punkcie
 */
public class City
{
    /**
     * Id obiektu
     */
    private int id=0;

    /**
     * Nazwa obiektu (miasta)
     */
    private String name;

    /**
     * Współrzędna x danego punktu
     */
    private int x_coor;

    /**
     * Współrzędna y danego punktu
     */
    private int y_coor;

    /**
     * @return zwraca id punktu (miasta)
     */
    public int getId()
    {
        return id;
    }

    /**
     * @param id ustawia pole id na zadaną wartość
     */
    public void setId(int id)
    {
        this.id = id;
    }

    /**
     * @return nazwę punktu (miasta)
     */
    public String getName()
    {
        return name;
    }

    /**
     * @param name ustawia pole name na zadaną wartość
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * @return współrzędną x
     */
    public int getX_coor()
    {
        return x_coor;
    }

    /**
     * @param x_coor ustawia współrzędną x na zadaną wartość
     */
    public void setX_coor(int x_coor)
    {
        this.x_coor = x_coor;
    }

    /**
     * @return współrzędną y
     */
    public int getY_coor()
    {
        return y_coor;
    }

    /**
     * @param y_coor ustawia współrzędną y na zadaną wartość
     */
    public void setY_coor(int y_coor)
    {
        this.y_coor = y_coor;
    }

    /**
     * Konstruktor obiektu klasy City służący do utworzenia miasta
     * @param id przekazuje wartość id
     * @param name przekazuje nazwę miasta
     * @param x_coor przekazuje współrzędną x miasta
     * @param y_coor przekazuje współrzędną y miasta
     */
    public City(int id, String name, int x_coor, int y_coor)
    {
        this.id = id;
        this.name = name;
        this.x_coor = x_coor;
        this.y_coor = y_coor;
    }

    /**
     * Konstruktor tworzący punkt graniczny
     * @param x_coor przekazuje współrzędną x punktu
     * @param y_coor przekazuje współrzędną y punktu
     */
    public City(int x_coor, int y_coor)
    {
        id = -1;
        name = "-";
        this.x_coor = x_coor;
        this.y_coor = y_coor;
    }
}

