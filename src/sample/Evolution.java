package sample;

public class Evolution
{
    private Country country;

    private Map map;

    private Specimen patient_zero;

    private Specimen specimen_bis;

    private Specimen specimen_ter;

    private int exit_condition = 1;

    private int eliminated = 0;


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

    public Specimen getPatient_zero()
    {
        return patient_zero;
    }

    public void setPatient_zero(Specimen patient_zero)
    {
        this.patient_zero = patient_zero;
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

        patient_zero = new Specimen(0, map);
    }

    public void evolution_control()
    {
        int check_ter=100;
        int check_bis=100;
        eliminated = (int)(Math.random()*1234);
        eliminated = eliminated%74;
        map.erase_city(eliminated);

        specimen_bis = new Specimen(patient_zero.getGeneration(), map, patient_zero.getHospitals(), eliminated, patient_zero.getSize());

        check_bis = specimen_bis.adaptation();

        if(check_bis!=1000)
            replace_specimen(specimen_bis, 1);
        else
            replace_specimen(patient_zero, 2);

        while(exit_condition != 0)
        {
            check_ter = specimen_ter.adaptation();
            check_bis = specimen_bis.adaptation();


            if (check_bis<check_ter)
            {
                replace_specimen(specimen_bis, 1);
            }
            else
            {
                replace_specimen(specimen_ter, 2);
            }
        }
    }

    public void replace_specimen(Specimen specimen, int id)
    {
        int check = 0;
        eliminated = 0;
        while (check == 0)
        {
            eliminated = (int) (Math.random() * 1234);
            eliminated = eliminated % 74;

            if (specimen_bis.hospitals[eliminated]==1)
                check = 1;
        }
        map.erase_city(eliminated);

        if (id ==1)
            specimen_ter = new Specimen(specimen.getGeneration(), map, specimen.getHospitals(), eliminated, specimen.getSize());
        else if ( id ==2)
            specimen_bis = new Specimen(specimen.getGeneration(), map, specimen.getHospitals(), eliminated, specimen.getSize());


    }

}
