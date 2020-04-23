package sample;

public class Evolution
{
    private Country country;

    private Map map;

    private Specimen patient_zero;

    private Specimen specimen_bis;

    private Specimen specimen_ter;

    int advancement = 1;

    int check = 0;

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
        int eliminated = (int)(Math.random()*1234);
        eliminated = eliminated%74;
        map.erase_city(eliminated);

        specimen_bis = new Specimen(patient_zero.getGeneration(), map, patient_zero.getHospitals(), eliminated, patient_zero.getSize());

        while (advancement!=0)
        {

            eliminated = (int)(Math.random()*1234);
            eliminated = eliminated%74;

            map.erase_city(eliminated);
            



        }
    }
}
