import java.time.LocalDate;

public class Person
{
    private static int id = 0;
    private int registrationNumber;
    private Work work;
    private String education;
    private LocalDate releaseDate;
    private RequireToFutureWork requireToFutureWork;

    Person(Work work, String education, RequireToFutureWork requireToFutureWork, LocalDate releaseDate)
    {
        this.registrationNumber = ++id;
        this.work = work;
        this.education = education;
        this.releaseDate = releaseDate;
        this.requireToFutureWork = requireToFutureWork;
    }

    Person(Work work, String education, LocalDate releaseDate)
    {
        this.registrationNumber = ++id;
        this.work = work;
        this.education = education;
        this.releaseDate = releaseDate;
    }

    public int getRegistrotionNumber() { return registrationNumber; }

    public Work getWork() { return work; }

    public LocalDate getReleaseDate() { return releaseDate; }

    public String getEducation() { return education; }

    public RequireToFutureWork getRequireToFutureWork() { return requireToFutureWork; }

    @Override
    public String toString()
    {
        if (requireToFutureWork == null)
            return ColorFont.RED + "Registration number: " + ColorFont.BLUE + registrationNumber +
                    ColorFont.RED + ";\nWork: " + ColorFont.BLUE + work +
                    ColorFont.RED + ";\nEducation: " + ColorFont.BLUE + education +
                    ColorFont.RED + ";\nRelease Data: " + ColorFont.BLUE + releaseDate + ColorFont.RED + ";" + ColorFont.RESET;
        else
            return ColorFont.RED + "Registration number: " + ColorFont.BLUE + registrationNumber +
                    ColorFont.RED + ";\nWork: " + ColorFont.BLUE + work +
                    ColorFont.RED + ";\nEducation: " + ColorFont.BLUE + education +
                    ColorFont.RED + ";\nRelease Data: " + ColorFont.BLUE + releaseDate +
                    ColorFont.RED + ";\nRequire: " + ColorFont.BLUE + requireToFutureWork + ColorFont.RED + ";" + ColorFont.RESET;
    }
}