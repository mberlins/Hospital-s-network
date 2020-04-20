package sample;

public class Map
{
    Country country;
    final int x_extent = 689;
    final int y_extent = 649;
    int field[][] = new int[649][689];
    int circle_radius = 187;


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

    public Country getCountry()
    {
        return country;
    }

    public void setCountry(Country country)
    {
        this.country = country;
    }

    public Map(Country country)
    {
        this.country = country;

        for (int i = 0; i < x_extent; i++)
            for (int j=0; j< y_extent; j++)
                field[j][i] = 0;

        /* inkrementuje kółka */
        for(int i=0; i<country.cities.length; i++)
        {
            for (int j = country.cities[i].x_coor - circle_radius; j <= circle_radius + country.cities[i].x_coor; j++)
            {
                for (int k = country.cities[i].y_coor - circle_radius; k<= circle_radius + country.cities[i].y_coor; k++)
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

}
