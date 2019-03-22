import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class ProgramMenu
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        String choice;
        CadreAgency cadreAgency = new CadreAgency();

        System.out.println("a. Show employee");
        System.out.println("b. Hire employee for a job");
        System.out.println("c. Add employee");
        System.out.println("q. Quit program");

        while(true)
        {
            choice = scanner.nextLine();

            switch (choice)
            {
                case "a":
                    cadreAgency.showPerson();
                    break;
                case "b":
                    System.out.println("Enter registration number peron who you want to hire a job");
                    int registrationNumber = scanner.nextInt();
                    if(cadreAgency.removePerson(registrationNumber))
                        System.out.println("Employee has been hired successfully");
                    else
                        System.out.println("Cadre agency hasn't person who have registration number " + registrationNumber);
                    break;
                case "c":
                    cadreAgency.addPerson();
                    break;
                case "q":
                    try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Data.dat")))
                    {
                        oos.writeObject(cadreAgency.getPeople());
                    }
                    catch (Exception e)
                    {
                        System.out.println(e.getMessage());
                    }
                    System.exit(0);
                    break;
            }
        }
    }
}