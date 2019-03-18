import java.io.*;

public class TestMyContainer
{
    public static void main(String[] args) throws IOException
    {
        MyArrayList<String> strings = new MyArrayList<>();
        MyArrayList<String> stringsEqualTest = new MyArrayList<>();

        System.out.println(ColorFont.RED + "TEST METHOD ADD" + ColorFont.RED);
        System.out.print(ColorFont.RESET);

        strings.add("Student");
        strings.add("Arsen");
        strings.add("Podoba");
        strings.add("CS-108");
        strings.add("I go to the University");

        System.out.print("Elements which were added:");
        System.out.println(ColorFont.BLUE);

        for(String x: strings)
            System.out.println(x);

        System.out.println(ColorFont.RESET);

        stringsEqualTest.add("Student");
        stringsEqualTest.add("Arsen");

        System.out.println(ColorFont.RED + "TEST METHOD CONTAINS");
        System.out.print(ColorFont.RESET);
        System.out.println("We check is in our container word \"Student\" ");
        System.out.print(ColorFont.BLUE + "Program result: ");

        System.out.println(strings.contains("Student"));

        System.out.println(ColorFont.RESET);

        System.out.print(ColorFont.RED + "TEST METHOD REMOVE");
        System.out.println(ColorFont.RESET);

        System.out.println("We are removing word \"CS-108\" ");
        strings.remove("CS-108");

        System.out.println("Elements after removing:");
        System.out.print(ColorFont.BLUE);

        for(String x: strings)
            System.out.println(x);

        System.out.println(ColorFont.RESET);

        System.out.print(ColorFont.RED + "TEST METHOD SIZE");
        System.out.println(ColorFont.RESET);

        System.out.print(ColorFont.BLUE);
        System.out.println("Program result: " + strings.size());
        System.out.println(ColorFont.RESET);

        System.out.print(ColorFont.RED + "TEST METHOD TOSTRING");
        System.out.println(ColorFont.RESET);
        System.out.println(ColorFont.BLUE + "Program result:");
        System.out.print(ColorFont.RESET);
        System.out.println(strings.toString());
        System.out.println();

        System.out.print(ColorFont.RED + "TEST METHOD CONTAINSALL");
        System.out.println(ColorFont.RESET);
        System.out.println("We are checking with collection, which contained stings: \"Student\" , \"Podoba\" ");
        System.out.println(ColorFont.BLUE + "Result program: " + strings.containsAll(stringsEqualTest));
        System.out.println(ColorFont.RESET);

        System.out.print(ColorFont.RED + "TEST SERIALIZATION AND DESERIALIZATION");
        System.out.println(ColorFont.RESET);
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Strings.dat")))
        {
            oos.writeObject(strings);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Strings.dat")))
        {
            Object stringsSeriasiable = ois.readObject();
            System.out.println(ColorFont.BLUE+"Object after deserialization:");
            System.out.println(stringsSeriasiable.toString());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        strings.clear();
    }
}
