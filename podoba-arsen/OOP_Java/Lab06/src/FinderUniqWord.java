public class FinderUniqWord implements Runnable
{
    MyLinkedList<String> myLinkedList;

    FinderUniqWord(MyLinkedList myLinkedList)
    {
        this.myLinkedList = myLinkedList;
    }

    @Override
    public void run()
    {
        int counterE = 0;
        int maxE = 0;
        String uniqWord = "";
        for (String x : myLinkedList)
        {
            for (int i = 0; i < x.length(); i++)
            {
                if (x.charAt(i) == 'e' || x.charAt(i) == 'E')
                    counterE++;
            }

            if (counterE > maxE)
            {
                maxE = counterE;
                uniqWord = x;
            }

            counterE = 0;
        }

        System.out.println("Words which has most letters 'e' is " + "\"" + uniqWord + "\"" + " it has " + maxE + " letters 'e'!");
    }
}

