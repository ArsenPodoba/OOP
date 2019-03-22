public class Work
{
    private int experience;
    private String specialty;

    Work(int experience, String specialty)
    {
        this.experience = experience;
        this.specialty = specialty;
    }

    public int getExperience() { return experience; }

    public String getSpecialty() { return specialty; }

    @Override
    public String toString()
    {
        String string = specialty + " for " + experience + " years";
        return string;
    }
}