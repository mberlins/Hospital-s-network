package sample;

public class Specimen
{
    int generation;
    int size;
    City cities[];
    Map map;

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

    /**
     * @return zwraca tablicę miast, w których znajdują się szpitale
     */
    public City[] getCities()
    {
        return cities;
    }

    public void setCities(City[] cities)
    {
        this.cities = cities;
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
     * @param cities jest listą miast, w których dany osobnik posiada szpitale
     * @param map przechowuje informacje o pokryciu powierzchni kraju przez siatkę szpitali, powinien być przekazywany
     *            przez osobnika poprzedniej generacji
     */
    public Specimen(int generation, City[] cities, Map map) // (poprzednik.getGeneration(), poprzednik.getCities(), poprzednik.getMap())
    {
        this.generation = generation;
        this.size = cities.length;
        this.cities = cities;
        this.map = map;
    }

    /**
     * Wywołuje metodę erase_city klasy Map
     * @param number przekazuje numer id miasta, w którym usuwamy szpital
     */
    public void delete_city(int number)
    {
        size--;
        map.erase_city(number-1);
    }
}
