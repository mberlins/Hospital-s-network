package sample;

/**
 * Klasa Map generuje oraz obsuługuje mapę Polski wraz z rozmieszczoymi na niej szpitalami
 */
public class Map
{
    /**
     * Szerokość mapy
     */
    final int x_extent = 689;

    /**
     * Wysokość mapy
     */
    final int y_extent = 649;

    /**
     * Tablica field reprezentuje mapę Polski wraz z rozmieszczonymi szpitalami i ich zasięgami
     */
    private int field[][] = new int[649][689];

    /**
     * Zasięg szpitala
     */
    final int circle_radius = 187;

    /**
     * Aktualna ilość szpitali na mapie
     */
    private int size;

    /**
     * Ilość punktów granicznych
     */
    private int sizeBorders;

    /**
     * Zmienna pomocnicza, używana przy rysowaniu granic
     */
    private int temp;

    /**
     * Tablica miast, w których znajdują się szpitale
     */
    private City cities[];

    /**
     * Tablica punktów służących do wyznaczania uproszczonych granic
     */
    private City borderPoints[];

    /**
     * Tablica punktów granicznych
     */
    private City borders[];

    /**
     * @return szerokość mapy
     */
    public int getX_extent()
    {
        return x_extent;
    }

    /**
     * @return wysokość mapy
     */
    public int getY_extent()
    {
        return y_extent;
    }

    /**
     * @return referencję na tablicę field
     */
    public int[][] getField()
    {
        return field;
    }

    /**
     * @return zwraca ilość szpitali rozlokowanych ma mapie
     */
    public int getSize()
    {
        return size;
    }

    /**
     * @return referencję na tablicę cities
     */
    public City[] getCities()
    {
        return cities;
    }


    /**
     * Konstruktor obiektu klasy Map.Funkcja zapełnia tablicę field domyślnymi wartościami
     * (granice, punkty graniczne oraz szpital w każdym mieście).
     * @param cities przekazuje domyślną tablicę miast
     * @param borderPoints przekazuje domyślną tablicę punktów służących do wyznaczania uproszczonych granic
     * @param borders przekazuje domyślną tablicę punktów granicznych
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
     * @param number oznacza nr miasta, w którym usuwany jest szpital
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

    /**
     * Funkcja inkrementuje pola tablicy field będącę w zasięgu określonego miasta
     * @param number oznacza nr miasta, w którym jest zadany szpital
     */
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