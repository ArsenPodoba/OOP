import java.util.Scanner;

public class TextMenu
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        String string;
        StringEditor stringEditor = new StringEditor();

        if(args != null && args.length == 1 && args[0].equals("-help"))
        {
            System.out.println("The program has a purpose to handle a text string.");
            System.out.println("All characters that are not letters are removed from the line. The number of spaces is edited.");
            System.out.println("Program author Arsen Podoba");
        }
        else if (args != null && args.length == 1 && args[0].equals("-d"))
        {
            System.out.println("Enter string");

            stringEditor.setString(scanner.nextLine());
            stringEditor.showResult();
        }
        else if (args.length == 0)
        {
            System.out.println("Please chose any point...");
            System.out.println("a. Enter data");
            System.out.println("b. Show data");
            System.out.println("c. Performance calculations");
            System.out.println("d. Show result");
            System.out.println("q. Quit a program");

            while(true)
            {
                string = scanner.nextLine();

                switch(string)
                {
                    case "a":
                        System.out.println("Enter your string:");
                        stringEditor.setString(scanner.nextLine());
                        System.out.println("Enter next step");
                        break;
                    case "b":
                        if(stringEditor.emptyString())
                        {
                            stringEditor.showString();
                            System.out.println("Enter next step");
                        }
                        else
                            System.out.println("Please enter your string...");
                        break;
                    case "c":
                        if(stringEditor.emptyString())
                        {
                            stringEditor.editString();
                            System.out.println("Enter next step");
                        }
                        else
                            System.out.println("Please enter your string...");
                        break;
                    case "d":
                        if(!stringEditor.emptyArrayList())
                        {
                            stringEditor.showResult();
                            System.out.println("Enter next step");
                        }
                        else
                            System.out.println("Please enter your string...");
                        break;
                    case "q":
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Enter correct point...");
                        break;
                }
            }
        }
        else
        {
            System.out.println("Incorrect entrance argc...");
            System.exit(0);
        }
    }
}