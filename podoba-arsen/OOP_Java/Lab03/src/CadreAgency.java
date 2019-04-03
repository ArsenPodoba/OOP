import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class CadreAgency
{
    private ArrayList<Person> people = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public CadreAgency()
    {
    }

    public void showPerson()
    {
        if(!people.isEmpty())
        {
            for (Person x : people)
                System.out.println(x+"\n");
        }
        else
            System.out.println("Cadre Agency hasn't employee");
    }

    public boolean removePerson(int registrationNumber)
    {
        for(int i = 0; i < people.size(); i++)
        {
            if (people.get(i).getRegistrotionNumber() == registrationNumber)
                {
                people.remove(i);
                return true;
            }
        }
        return false;
    }

    public void addPerson()
    {
        System.out.println("Enter person's specialty: ");
        String specialty = scanner.nextLine();
        System.out.println("Enter amount of years while person was working: ");
        int years = scanner.nextInt();
        Work job = new Work(years, specialty);

        System.out.println("Enter person's Education");
        scanner.nextLine();
        String education = scanner.nextLine();

        System.out.println("Enter data of person's release: Year Month Day");
        int year = scanner.nextInt();
        int month = scanner.nextInt();
        int day = scanner.nextInt();

        Date date = new Date(year - 1, month -1 , day);

        System.out.println("Does person has any require? Press y - yes, n - no.");
        scanner.nextLine();
        String choice = scanner.nextLine();

        if (choice.equals("n"))
        {
            people.add(new Person(job, education, date));
            System.out.println("Person has been added");
        }
        else if (choice.equals("y"))
        {
            String specialtyWanted;
            String conditionOfwork;
            int minSalary;

            System.out.println("Enter specialty, on which person wants. You can skip this point");
            specialtyWanted = scanner.nextLine();

            System.out.println("Enter special condition. You can skip this point");
            conditionOfwork = scanner.nextLine();

            System.out.println("Enter minimal salary. You can skip this point");
            minSalary = scanner.nextInt();

            people.add(new Person(job, education, new RequireToFutureWork(specialtyWanted, conditionOfwork, minSalary), date));

            System.out.println("Person has been added");
        }
        else
            System.out.println("Enter your choice....");
    }

    public ArrayList<Person> getPeople() { return people; }

    public void setPeople(ArrayList<Person> people) { this.people = people; }
}