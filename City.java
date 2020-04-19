package sample;


public class City
{
    static int id=0;
    String name;
    int x_coor;
    int y_coor;


    public static int getId()
    {
        return id;
    }

    public static void setId(int id)
    {
        City.id = id;
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

    public City(String name, int x_coor, int y_coor)
    {
        this.name = name;
        this.x_coor = x_coor;
        this.y_coor = y_coor;
    }
}

