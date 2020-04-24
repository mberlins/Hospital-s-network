package sample;

/**
 * Klasa Specimen przechowuje informacje o osobniku (czyli konkretnym układzie szpitali).
 */
public class Specimen
{
    /**
     * Generacja sobnika.
     */
    private int generation;

    /**
     * Ilość szpitali jaką posiada osobnik
     */
    private int size;

    /**
     * Tablica indeksów szpitali, które posiada osobnik
     */
    private int hospitals[];

    /**
     * Ilość kolumn w tablicy field
     */
    final int x_extent = 689;

    /**
     * Ilość wierszy w tablicy field
     */
    final int y_extent = 649;

    /**
     * Tablica przechowująca aktualne zasięgi szpitali danego osobnika
     */
    private int field[][] = new int[649][689];

    /**
     * @return generację osobnika
     */
    public int getGeneration()
    {
        return generation;
    }

    /**
     * @param generation ustawia wartość pola generation
     */
    public void setGeneration(int generation)
    {
        this.generation = generation;
    }

    /**
     * @return wartość pola size
     */
    public int getSize()
    {
        return size;
    }

    /**
     * @param size ustawia wartość pola size
     */
    public void setSize(int size)
    {
        this.size = size;
    }

    /**
     * @return tablicę indeksów szpitali danego osobnika
     */
    public int[] getHospitals()
    {
        return hospitals;
    }

    /**
     * @param hospital przekazuje indeks elementu, którego wartość należy zmienić w tablicy hospitals
     * @param value przekazuje wartość do ustawienia dla danego elementu
     */
    public void setHospital (int hospital, int value)
    {
        this.hospitals[hospital] = value;
    }

    /**
     * @param index oznacza indeks elementu do zwrócenia
     * @return element z tablicy hospitals
     */
    public int getHospital(int index)
    {
        return this.hospitals[index];
    }

    /**
     * @return ilość kolumn tablicy field
     */
    public int getX_extent()
    {
        return x_extent;
    }

    /**
     * @return ilość wierszy tablicy Field
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
     * Konstruktor klasy specimen
     * @param generation przekazuje generacje rodzica
     * @param map przekazuje obiekt typu map, z którego pobrana zostanie tablica field
     * @param predecessors_hospitals przekazuje tablicę z numerami szpitali rodzica
     * @param number przekazuje id szpitala, który zostanie usunięty
     * @param size przekazuje rozmiar rodzica
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

    /**
     * Konstruktor klasy Specimen, wykorzystywany tylko do utworzenia pierwszego osobnika
     * @param generation przekazuje domyślną generację (0)
     * @param map przekazuje obiekt map z domyślnymi wartościami
     */
    public Specimen(int generation, Map map)
    {
        this.generation = generation;
        this.size = map.getSize();

        hospitals = new int [74];
        for(int i = 0; i < 74; i++)
            hospitals[i] = 1;
    }

    /**
     * Funkcja określająca jakość danego osobnika - jeśli mapa danego osobnika zawiera zera to oznacza, że pewien obszar
     * kraju jest za bardzo oddalony od najbliższego szpitala.
     * @return zwraca wartość size - im mniejszy osobnik tym lepszy
     */
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