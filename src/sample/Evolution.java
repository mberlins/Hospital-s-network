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
        map = new Map(country.cities, country.borderPoints, country.borders);

        specimen_ter = new Specimen(0, map);
    }

    public Specimen evolution_control()
    {
        int check_ter=1000;
        int check_bis=1000;
        eliminated = (int)(Math.random()*1234);
        eliminated = eliminated%74;
        map.erase_city(eliminated);

        specimen_bis = new Specimen(specimen_ter.getGeneration(), map, specimen_ter.getHospitals(), eliminated, specimen_ter.getSize());

        check_bis = specimen_bis.adaptation();

        if(check_bis!=1000)
            replace_specimen(specimen_bis, 1);
        else
            replace_specimen(specimen_ter, 2);

        while(counter_bis < 10 && counter_ter < 10)
        {
            check_ter = specimen_ter.adaptation();
            check_bis = specimen_bis.adaptation();

           /* if (counter_ter > 1 || counter_bis > 1)
                map.add_city(eliminated);*/

            if (specimen_ter.adaptation() == 1000 || specimen_bis.adaptation() == 1000)
                map.add_city(eliminated);

            if (check_bis<check_ter)
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
        }

        if(counter_bis == 10)
            return specimen_bis;
        else
            return specimen_ter;

    }

    public void replace_specimen(Specimen specimen, int id)
    {
        int check = 0;
        while (check == 0)
        {
            eliminated = (int) (Math.random() * 1234);
            eliminated = eliminated % 74;

            if (specimen.hospitals[eliminated]==1) {
                check = 1;
            }
        }
        map.erase_city(eliminated);

        if (id ==1)
            specimen_ter = new Specimen(specimen.getGeneration(), map, specimen.getHospitals(), eliminated, specimen.getSize());
        else if ( id ==2)
            specimen_bis = new Specimen(specimen.getGeneration(), map, specimen.getHospitals(), eliminated, specimen.getSize());

    }

}
