package sample;

public class Map
{
    //Country country;
    final int x_extent = 689;
    final int y_extent = 649;
    int field[][] = new int[649][689];
    final int circle_radius = 187;
    int size;
    int sizeBorders;
    int temp;
    City cities[];
    City borderPoints[];
    City borders[];


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

    public void setCities(City[] cities)
    {
        this.cities = cities;
    }

    /**
     * Funkcja zapełnia tablicę field domyślnymi wartościami (szpitale w każdym mieście)
     * @param cities
     */
    public Map(City[] cities, City[] borderPoints, City[] borders) // Map(country.getCities())
    {
        this.size = cities.length;
        this.cities = cities;
        this.sizeBorders = borderPoints.length;
        this.borderPoints = borderPoints;
        this.borders = borders;

        temp = borderPoints[6].y_coor;


        for (int i = 0; i < x_extent; i++)
            for (int j=0; j< y_extent; j++)
                field[j][i] = -1;

        /* 6 pętli - rysują uproszczoną mapę Polski w tabeli fields */
        for (int i = borderPoints[0].x_coor; i <= borderPoints[2].x_coor; i++)
            for (int j=borderPoints[0].y_coor; j<= borderPoints[1].y_coor; j++)
                field[j][i] = 0;

        for (int i = borderPoints[4].x_coor; i <= borderPoints[2].x_coor; i++)
            for (int j=borderPoints[4].y_coor; j<= borderPoints[5].y_coor; j++)
                field[j][i] = 0;

        for (int i = borderPoints[6].x_coor; i <= borderPoints[2].x_coor; i++)
            for (int j=borderPoints[5].y_coor; j<= borderPoints[6].y_coor; j++)
                field[j][i] = 0;

        for (int i = borderPoints[6].x_coor; i >= borderPoints[4].x_coor; i--)
        {
            for (int j = borderPoints[5].y_coor; j <= temp; j++)
                field[j][i] = 0;
            if(i % 2 == 0)
                temp--;
        }

        for (int i = borderPoints[7].x_coor; i <= borderPoints[8].x_coor; i++)
            for (int j = borderPoints[7].y_coor; j<= borderPoints[0].y_coor; j++)
                field[j][i] = 0;

        for (int i = borderPoints[8].x_coor; i <= borderPoints[2].x_coor; i++)
            for (int j = borderPoints[8].x_coor; j <= borderPoints[0].y_coor; j++)
                field[j][i] = 0;

        /* wypełnia tabelę fields punktami oznaczającymi dokładne granice Polski */
        for (int i = 0; i < sizeBorders; i++)
            field[borders[i].y_coor][borders[i].x_coor] = 0;


        /* inkrementuje kółka */
        for(int i=0; i<size; i++)
        {
            for (int j = cities[i].x_coor - circle_radius; j <= circle_radius + cities[i].x_coor; j++)
            {
                for (int k = cities[i].y_coor - circle_radius; k<= circle_radius + cities[i].y_coor; k++)
                {
                    double distance_to_centre = Math.sqrt((j - cities[i].x_coor) * (j - cities[i].x_coor) + (k - cities[i].y_coor) * (k - cities[i].y_coor));
                    if (distance_to_centre < circle_radius + 0.5)
                    {
                        if (k<649 && k>0 && j<689 && j>0 && field[k][j] != -1)
                            field[k][j]++;
                    }
                }
            }
        }

    }

    /**
     * Funkcja dekrementuje pola tablicy field będące w zasięgu usuwanego szpitala
     * @param number oznacza nr usuwanego miasta, w którym usuwany jest szpital
     */
    public void erase_city(int number)
    {
        for (int i = cities[number].x_coor - circle_radius; i <= circle_radius + cities[number].x_coor; i++)
        {
            for (int j = cities[number].y_coor - circle_radius; j<= circle_radius + cities[number].y_coor; j++)
            {
                double distance_to_centre = Math.sqrt((i - cities[number].x_coor) * (i - cities[number].x_coor) + (j - cities[number].y_coor) * (j - cities[number].y_coor));
                if (distance_to_centre < circle_radius + 0.5)
                {
                    if (j<649 && j>0 && i<689 && i>0 && field[j][i] != -1)
                        field[j][i]--;
                }
            }
        }

    }

    public void add_city(int number)
    {
        for (int i = cities[number].x_coor - circle_radius; i <= circle_radius + cities[number].x_coor; i++)
        {
            for (int j = cities[number].y_coor - circle_radius; j<= circle_radius + cities[number].y_coor; j++)
            {
                double distance_to_centre = Math.sqrt((i - cities[number].x_coor) * (i - cities[number].x_coor) + (j - cities[number].y_coor) * (j - cities[number].y_coor));
                if (distance_to_centre < circle_radius + 0.5)
                {
                    if (j<649 && j>0 && i<689 && i>0 && field[j][i] != -1)
                        field[j][i]++;
                }
            }
        }
    }

}
