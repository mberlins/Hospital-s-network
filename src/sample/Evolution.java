package sample;

/**
 * Klasa evoulution odpowiada za realizację algorytmu ewolucyjnego
 */
public class Evolution
{
    /**
     * Obiekt klasy Country
     */
    private Country country;

    /**
     * Obiekt klasy Map
     */
    private Map map;

    /**
     * Obiekt klasy Specimen
     */
    private Specimen specimen_bis;

    /**
     * Drugi obiekt klasy Specimen
     */
    private Specimen specimen_ter;

    /**
     * Indeks miasta, w którym usunięto szpital
     */
    private int eliminated = 0;

    /**
     * Licznik przechowujący informację ile razy z rzędu algorytm wybrał pierwszego osobnika
     */
    private int counter_bis = 0;

    /**
     * Licznik przechowujący informację ile razy z rzędu algorytm wybrał drugiego osobnika
     */
    private int counter_ter = 0;

    /**
     * Indeks miasta, które zostało zastąpione
     */
    private int replaced;

    /**
     * Indeks miasta, które zostało dodane w opracji zastąpienia
     */
    private int added;

    /**
     * Licznik pokoleń
     */
    private int counter = 20;

    /**
     * @return licznik pokoleń
     */
    public int getCounter()
    {
        return counter;
    }

    /**
     * @return obiekt klasy Country
     */
    public Country getCountry()
    {
        return country;
    }

    /**
     * @param country przekazuje do ustawienia obiekt klasy Country
     */
    public void setCountry(Country country)
    {
        this.country = country;
    }

    /**
     * @return obiekt klasy Map
     */
    public Map getMap()
    {
        return map;
    }

    /**
     * @param map przekazuje do ustawienia obiekt klasy Map
     */
    public void setMap(Map map)
    {
        this.map = map;
    }

    /**
     * @return pierwszego z obiektów klasy Specimen
     */
    public Specimen getSpecimen_bis()
    {
        return specimen_bis;
    }

    /**
     * @param specimen_bis ustawia obiekt klasy Specimen na zadany
     */
    public void setSpecimen_bis(Specimen specimen_bis)
    {
        this.specimen_bis = specimen_bis;
    }

    /**
     * Konstruktor tworzący obiekt klasy Country przechowujący dane miast i granic, mapę szpitali oraz granic, a także inicjalizujący
     * pierwszego osobnika klasy Specimen
     */
    public Evolution()
    {
        country = new Country();
        map = new Map(country.getCities(), country.getBorderPoints(), country.getBorders());

        specimen_ter = new Specimen(0, map);
    }

    /**
     * Funkcja zarządzająca procesem tworzenia nowych osobników (2 rodzaje mutacji) oraz wybierająca z populacji dwuelementowej
     * osobniika lepiej przystosowanego, który przekaże swoje geny. Mutacja może usunąć losowe miasto ze szpitalem z mapy
     * lub losowo usunąć jedno miasto i zastąpić je innym.
     * @return ostatniego osobnika (obiekt klasy Specimen)
     */
    public Specimen evolution_control()
    {
        int check_ter = 1000;
        int check_bis = 1000;
        eliminated = (int) (Math.random() * 1234);
        eliminated = eliminated % 74;
        map.erase_city(eliminated);

        specimen_bis = new Specimen(specimen_ter.getGeneration(), map, specimen_ter.getHospitals(), eliminated, specimen_ter.getSize());

        check_bis = specimen_bis.adaptation();

        if (check_bis != 1000)
            replace_specimen(specimen_bis, 1);
        else
            replace_specimen(specimen_ter, 2);

        while (counter_bis < 500 && counter_ter < 500)
        {
            check_ter = specimen_ter.adaptation();
            check_bis = specimen_bis.adaptation();

            int modulo = (int) (Math.random() * 12345) % 10;
            modulo++;

            if (counter % modulo == 4)
            {
                if (check_bis < check_ter)
                {
                    mutation(specimen_bis, 1);
                    counter++;
                    counter_bis++;
                    counter_ter = 0;
                }
                else
                {
                    mutation(specimen_ter, 2);
                    counter++;
                    counter_bis = 0;
                    counter_ter++;
                }
                continue;
            }

            if (check_bis < check_ter)
            {
                replace_specimen(specimen_bis, 1);
                counter_bis++;
                counter_ter = 0;
            }
            else
            {
                replace_specimen(specimen_ter, 2);
                counter_bis = 0;
                counter_ter++;
            }

            counter++;
        }

        if (counter_bis == 500)
            return specimen_bis;
        else
            return specimen_ter;

    }

    /**
     * Funkcja tworząca nowego osobnika na podstawie starego - usuwa losowe miasto.
     * @param specimen jest osobnikiem przekazującym geny
     * @param id przekazuje informację, którego osobnika należy zastąpić
     */
    public void replace_specimen(Specimen specimen, int id)
    {
        int check = 0;
        while (check == 0)
        {
            eliminated = (int) (Math.random() * 12304);
            eliminated = eliminated % 74;

            if (specimen.getHospital(eliminated) == 1)
            {
                check = 1;
            }
        }
        map.erase_city(eliminated);

        if (id == 1)
        {
            specimen_ter = new Specimen(specimen.getGeneration(), map, specimen.getHospitals(), eliminated, specimen.getSize());
            if(specimen_ter.adaptation() == 1000)
            {
                map.add_city(eliminated);
            }
        }
        else if (id == 2)
        {
            specimen_bis = new Specimen(specimen.getGeneration(), map, specimen.getHospitals(), eliminated, specimen.getSize());
            if(specimen_bis.adaptation() == 1000)
            {
                map.add_city(eliminated);
            }
        }

    }

    /**
     * Funkcja tworząca nowego osobnika na podstawie starego - usuwa losowe miasto i dodaje inne losowo wybrane miasto(wcześniej usunięte).
     * @param specimen jest osobnikiem przekazującym geny
     * @param id przekazuje informację, którego osobnika należy zastąpić
     */
    public void mutation(Specimen specimen, int id)
    {
        int check = 0;
        replaced = 0;
        added = 0;

        while (check == 0)
        {
            replaced = (int) (Math.random() * 12345);
            replaced = replaced % 74;

            if (specimen.getHospital(replaced) == 1)
                check = 1;
        }
        check = 0;

        while (check == 0)
        {
            added = (int) (Math.random() * 123456);
            added = added % 74;

            if (specimen.getHospital(added) == 0)
                check = 1;
        }

        map.erase_city(replaced);
        map.add_city(added);

        if (id == 1)
        {
            specimen_ter = new Specimen(specimen.getGeneration(), map, specimen.getHospitals(), replaced, specimen.getSize());
            specimen_ter.setHospital(added, 1);

            if(specimen_ter.adaptation() == 1000)
            {
                map.add_city(replaced);
                map.erase_city(added);
            }
        }
        else if (id == 2)
        {
            specimen_bis = new Specimen(specimen.getGeneration(), map, specimen.getHospitals(), replaced, specimen.getSize());
            specimen_bis.setHospital(added, 1);

            if(specimen_bis.adaptation() == 1000)
            {
                map.add_city(replaced);
                map.erase_city(added);
            }
        }
    }
}