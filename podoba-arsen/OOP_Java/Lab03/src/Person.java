import java.util.Date;
import java.util.Random;

public class Person
{

    private int registrationNumber;
    private Work work;
    private String education;
    private Date releaseDate;
    private RequireToFutureWork requireToFutureWork;
    private Random random = new Random();

    public Person() {}

    Person(Work work, String education, RequireToFutureWork requireToFutureWork, Date releaseDate)
    {
        this.registrationNumber = Math.abs(random.nextInt()%1000);
        this.work = work;
        this.education = education;
        this.releaseDate = releaseDate;
        this.requireToFutureWork = requireToFutureWork;
    }

    Person(Work work, String education, Date releaseDate)
    {
        this.registrationNumber = Math.abs(random.nextInt()%1000);
        this.work = work;
        this.education = education;
        this.releaseDate = releaseDate;
    }

    public int getRegistrotionNumber() { return registrationNumber; }

    public Work getWork() { return work; }

    public Date getReleaseDate() { return releaseDate; }

    public String getEducation() { return education; }

    public RequireToFutureWork getRequireToFutureWork() { return requireToFutureWork; }

    @Override
    public String toString()
    {
        if (requireToFutureWork == null)
            return ColorFont.RED + "Registration number: " + ColorFont.BLUE + registrationNumber +
                    ColorFont.RED + ";\nWork: " + ColorFont.BLUE + work +
                    ColorFont.RED + ";\nEducation: " + ColorFont.BLUE + education +
                    ColorFont.RED + ";\nRelease Data: " + ColorFont.BLUE + (releaseDate.getYear() + 1) + "-" + (releaseDate.getMonth() + 1) + "-" + releaseDate.getDate() + ColorFont.RED + ";" + ColorFont.RESET;
        else
            return ColorFont.RED + "Registration number: " + ColorFont.BLUE + registrationNumber +
                    ColorFont.RED + ";\nWork: " + ColorFont.BLUE + work +
                    ColorFont.RED + ";\nEducation: " + ColorFont.BLUE + education +
                    ColorFont.RED + ";\nRelease Data: " + ColorFont.BLUE + (releaseDate.getYear() + 1) + "-" + (releaseDate.getMonth() +1) + "-" + releaseDate.getDate() + ColorFont.RED  +
                    ColorFont.RED + ";\nRequire: " + ColorFont.BLUE + requireToFutureWork + ColorFont.RED + ";" + ColorFont.RESET;
    }

    public void setEducation(String education) { this.education = education; }

    public int getRegistrationNumber() { return registrationNumber; }

    public void setRegistrationNumber(int registrationNumber) { this.registrationNumber = registrationNumber; }

    public void setReleaseDate(Date releaseDate) { this.releaseDate = releaseDate; }

    public void setRequireToFutureWork(RequireToFutureWork requireToFutureWork) { this.requireToFutureWork = requireToFutureWork; }

    public void setWork(Work work) { this.work = work; }
}