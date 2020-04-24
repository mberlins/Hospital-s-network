package sample;


public class City
{
    private int id=0;
    private String name;
    private int x_coor;
    private int y_coor;


    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getX_coor()
    {
        return x_coor;
    }

    public void setX_coor(int x_coor)
    {
        this.x_coor = x_coor;
    }

    public int getY_coor()
    {
        return y_coor;
    }

    public void setY_coor(int y_coor)
    {
        this.y_coor = y_coor;
    }

    public City(int id, String name, int x_coor, int y_coor)
    {
        this.id = id;
        this.name = name;
        this.x_coor = x_coor;
        this.y_coor = y_coor;
    }

    public City(int x_coor, int y_coor)
    {
        id = -1;
        name = "-";
        this.x_coor = x_coor;
        this.y_coor = y_coor;
    }
}

