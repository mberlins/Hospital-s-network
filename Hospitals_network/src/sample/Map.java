package sample;

public class Map
{
    //Country country;
    final int x_extent = 689;
    final int y_extent = 649;
    int field[][] = new int[649][689];
    int circle_radius = 187;
    int size;
    City cities[] = new City[size];


    public int getX_extent()
    {
        return x_extent;
    }

    public int getY_extent()
    {
        return y_extent;
    }

    public int[][] getField()
    {
        return field;
    }

    public void setField(int[][] field)
    {
        this.field = field;
    }

    public int getSize()
    {
        return size;
    }

    public void setSize(int size)
    {
        this.size = size;
    }

    public City[] getCities()
    {
        return cities;
    }

    public void setCities(City[] cities) {
        this.cities = cities;
    }

    public Map(City[] cities)
    {
        this.size = cities.length;
        this.cities = cities;

        for (int i = 0; i < x_extent; i++)
            for (int j=0; j< y_extent; j++)
                field[j][i] = 0;

        /* inkrementuje kółka */
        for(int i=0; i<cities.length; i++)
        {
            for (int j = cities[i].x_coor - circle_radius; j <= circle_radius + cities[i].x_coor; j++)
            {
                for (int k = cities[i].y_coor - circle_radius; k<= circle_radius + cities[i].y_coor; k++)
                {
                    double distance_to_centre = Math.sqrt((j - circle_radius) * (j - circle_radius) + (k - circle_radius) * (k - circle_radius));
                    if (distance_to_centre < circle_radius + 0.5)
                    {
                        if (k<649 && k>0 && j<689 && j>0 && field[k][j] != -1)
                            field[k][j]++;
                    }

                }
            }
        }
    }

    public void erase_city(int number)
    {
            for (int i = cities[number].x_coor - circle_radius; i <= circle_radius + cities[number].x_coor; i++)
            {
                for (int j = cities[number].y_coor - circle_radius; j<= circle_radius + cities[number].y_coor; j++)
                {
                    double distance_to_centre = Math.sqrt((i - circle_radius) * (i - circle_radius) + (j - circle_radius) * (j - circle_radius));
                    if (distance_to_centre < circle_radius + 0.5)
                    {
                        if (j<649 && j>0 && i<689 && i>0 && field[j][i] != -1)
                            field[j][i]--;
                    }

                }
            }
    }

}
