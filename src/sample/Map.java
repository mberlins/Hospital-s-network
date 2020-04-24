package sample;

public class Map
{
    //Country country;
    final int x_extent = 689;
    final int y_extent = 649;
    private int field[][] = new int[649][689];
    final int circle_radius = 187;
    private int size;
    private int sizeBorders;
    private int temp;
    private City cities[];
    private City borderPoints[];
    private City borders[];


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
        this.sizeBorders = borders.length;
        this.borderPoints = borderPoints;
        this.borders = borders;

        temp = borderPoints[6].getY_coor();


        for (int i = 0; i < x_extent; i++)
            for (int j=0; j< y_extent; j++)
                field[j][i] = -1;

        /* 6 pętli - rysują uproszczoną mapę Polski w tabeli fields */
        for (int i = borderPoints[0].getX_coor(); i <= borderPoints[2].getX_coor(); i++)
            for (int j=borderPoints[0].getY_coor(); j<= borderPoints[1].getY_coor(); j++)
                field[j][i] = 0;

        for (int i = borderPoints[4].getX_coor(); i <= borderPoints[2].getX_coor(); i++)
            for (int j=borderPoints[4].getY_coor(); j<= borderPoints[5].getY_coor(); j++)
                field[j][i] = 0;

        for (int i = borderPoints[6].getX_coor(); i <= borderPoints[2].getX_coor(); i++)
            for (int j=borderPoints[5].getY_coor(); j<= borderPoints[6].getY_coor(); j++)
                field[j][i] = 0;

        for (int i = borderPoints[6].getX_coor(); i >= borderPoints[4].getX_coor(); i--)
        {
            for (int j = borderPoints[5].getY_coor(); j <= temp; j++)
                field[j][i] = 0;
            if(i % 2 == 0)
                temp--;
        }

        for (int i = borderPoints[7].getX_coor(); i <= borderPoints[8].getX_coor(); i++)
            for (int j = borderPoints[7].getY_coor(); j<= borderPoints[0].getY_coor(); j++)
                field[j][i] = 0;

        for (int i = borderPoints[8].getX_coor(); i <= borderPoints[2].getX_coor(); i++)
            for (int j = borderPoints[8].getX_coor(); j <= borderPoints[0].getY_coor(); j++)
                field[j][i] = 0;

        /* wypełnia tabelę fields punktami oznaczającymi dokładne granice Polski */
        for (int i = 0; i < sizeBorders; i++)
            field[borders[i].getY_coor()][borders[i].getX_coor()] = 0;


        /* inkrementuje kółka */
        for(int i=0; i<size; i++)
        {
            for (int j = cities[i].getX_coor() - circle_radius; j <= circle_radius + cities[i].getX_coor(); j++)
            {
                for (int k = cities[i].getY_coor() - circle_radius; k<= circle_radius + cities[i].getY_coor(); k++)
                {
                    double distance_to_centre = Math.sqrt((j - cities[i].getX_coor()) * (j - cities[i].getX_coor()) + (k - cities[i].getY_coor()) * (k - cities[i].getY_coor()));
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
        for (int i = cities[number].getX_coor() - circle_radius; i <= circle_radius + cities[number].getX_coor(); i++)
        {
            for (int j = cities[number].getY_coor() - circle_radius; j<= circle_radius + cities[number].getY_coor(); j++)
            {
                double distance_to_centre = Math.sqrt((i - cities[number].getX_coor()) * (i - cities[number].getX_coor()) + (j - cities[number].getY_coor()) * (j - cities[number].getY_coor()));
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
        for (int i = cities[number].getX_coor() - circle_radius; i <= circle_radius + cities[number].getX_coor(); i++)
        {
            for (int j = cities[number].getY_coor() - circle_radius; j<= circle_radius + cities[number].getY_coor(); j++)
            {
                double distance_to_centre = Math.sqrt((i - cities[number].getX_coor()) * (i - cities[number].getX_coor()) + (j - cities[number].getY_coor()) * (j - cities[number].getY_coor()));
                if (distance_to_centre < circle_radius + 0.5)
                {
                    if (j<649 && j>0 && i<689 && i>0 && field[j][i] != -1)
                        field[j][i]++;
                }
            }
        }
    }

}