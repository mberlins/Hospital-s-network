package sample;

public class Specimen
{
    int generation;
    int size;
    int hospitals[];
    final int x_extent = 689;
    final int y_extent = 649;
    int field[][] = new int[649][689];


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

    public int[] getHospitals()
    {
        return hospitals;
    }

    public void setHospitals(int[] hospitals)
    {
        this.hospitals = hospitals;
    }

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

    /**
     * Konstruktor klasy Specimen
     * @param generation oznacza generację osobnika
     * @param map przechowuje informacje o pokryciu powierzchni kraju przez siatkę szpitali, powinien być przekazywany
     *            przez osobnika poprzedniej generacji
     */
    public Specimen(int generation, Map map, int[] predecessors_hospitals, int number, int size) // (poprzednik.getGeneration(), poprzednik.getCities(), poprzednik.getMap(), number dostaje od algorytmu)
    {
        this.generation = generation+1;
        this.size = size-1;

        //System.arraycopy(map.getField(), 0, this.field, 0, 447161);


        for (int i = 0; i < 689; i++)
            for (int j=0; j< 649; j++)
                this.field[j][i] = map.getField()[j][i];

        hospitals = new int[74];
        System.arraycopy(predecessors_hospitals, 0, this.hospitals,0, 74);
        hospitals[number]=0;

    }

    public Specimen(int generation, Map map) // konstruktor pierwszego osobnika
    {
        this.generation = generation;
        this.size = map.getSize();

        hospitals = new int [74];
        for(int i = 0; i < 74; i++)
            hospitals[i] = 1;
    }


    public int adaptation()
    {

        for (int i = 0; i < x_extent; i++)
            for (int j=0; j< y_extent; j++)
            {
                if(field[j][i] == 0)
                    return 1000;
            }

        return size;
    }


}
