import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.Scanner;

public class ProgramMenu
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        String choice;
        CadreAgency cadreAgency = new CadreAgency();

        try(XMLDecoder decoder = new XMLDecoder(
                new BufferedInputStream(
                        new FileInputStream("Person.xml"))))
        {
            Object help = decoder.readObject();
            decoder.close();

            cadreAgency = (CadreAgency) help;
        }
        catch (Exception ex)
        {
            System.out.println("Cadre agency is empty");
        }
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
                    try(XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream("Person.xml"))))
                    {
                        encoder.writeObject(cadreAgency);
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