package sample;

public class Evolution
{
    private Country country;

    private Map map;

    private Specimen specimen_bis;

    private Specimen specimen_ter;

    private int eliminated = 0;

    private int counter_bis = 0;

    private int counter_ter = 0;

    private int replaced;
    private int replaced_bis;
    private int added;
    private int temp;


    public Country getCountry()
    {
        return country;
    }

    public void setCountry(Country country)
    {
        this.country = country;
    }

    public Map getMap()
    {
        return map;
    }

    public void setMap(Map map)
    {
        this.map = map;
    }

    public Specimen getSpecimen_bis()
    {
        return specimen_bis;
    }

    public void setSpecimen_bis(Specimen specimen_bis)
    {
        this.specimen_bis = specimen_bis;
    }

    public Evolution()
    {
        country = new Country();
        map = new Map(country.getCities(), country.getBorderPoints(), country.getBorders());

        specimen_ter = new Specimen(0, map);
    }

    public Specimen evolution_control()
    {
        int counter = 20;
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

        while (counter_bis < 25 && counter_ter < 25)
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

        if (counter_bis == 25)
            return specimen_bis;
        else
            return specimen_ter;

    }

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

    public void mutation(Specimen specimen, int id)
    {
        int check = 0;
        replaced = 0;
        replaced_bis = 0;
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