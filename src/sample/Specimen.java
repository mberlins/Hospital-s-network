package sample;

public class Specimen
{
    int generation;
    int size;
    int hospitals[];
    Map map;

    public int[] getHospitals() { return hospitals; }

    public int getGeneration()
    {
        return generation;
    }

    public void setGeneration(int generation)
    {
        this.generation = generation;
    }

    public int getSize()
    {
        return size;
    }

    public void setSize(int size)
    {
        this.size = size;
    }

    public Map getMap()
    {
        return map;
    }

    public void setMap(Map map)
    {
        this.map = map;
    }

    /**
     * Konstruktor klasy Specimen
     * @param generation oznacza generację osobnika
     * @param map przechowuje informacje o pokryciu powierzchni kraju przez siatkę szpitali, powinien być przekazywany
     *            przez osobnika poprzedniej generacji
     */
    public Specimen(int generation, Map map, int[] hospitals, int number, int size) // (poprzednik.getGeneration(), poprzednik.getCities(), poprzednik.getMap(), number dostaje od algorytmu)
    {
        this.generation = generation;
        this.size = size-1;
        this.map = map;
        this.hospitals = hospitals;
        hospitals[number]=0;
        map.erase_city(number);
    }

    public Specimen(int generation, Map map) // konstruktor pierwszego osobnika
    {
        this.generation = generation;
        this.size = map.getSize();
        this.map = map;

        hospitals = new int [75];
        for(int i = 1; i <= 74; i++)
            hospitals[i] = 1;

    }

    /**
     * Wywołuje metodę erase_city klasy Map
     * @param number przekazuje numer id miasta, w którym usuwamy szpital
     */
    public void add_city(int number)
    {
        size++;
        map.add_city(number-1);
        hospitals[number] = 1;
    }

    public int adaptation()
    {

        for (int i = 0; i < map.x_extent; i++)
            for (int j=0; j< map.y_extent; j++)
            {
                if(map.field[j][i] == 0)
                    return 0;
            }

        return size;
    }
}
