package sample;

public class Specimen
{
    int generation;
    int size;
    City cities[] = new City[size];
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

    public Specimen(int generation, City[] cities, Map map)
    {
        this.generation = generation;
        this.size = cities.length;
        this.cities = cities;

        this.map = map;
    }

    public void delete_city(int number)
    {
        size--;
        map.erase_city(number-1);
    }
}
