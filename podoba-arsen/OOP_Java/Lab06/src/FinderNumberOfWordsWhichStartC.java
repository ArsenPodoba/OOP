public class FinderNumberOfWordsWhichStartC implements Runnable
{
    MyLinkedList<String> myLinkedList;

    FinderNumberOfWordsWhichStartC(MyLinkedList myLinkedList) {
        this.myLinkedList = myLinkedList;
    }
    @Override
    public void run()
    {
        int numvebOfWords = 0;
        for (String x: myLinkedList){
            if(x.charAt(0) == 'c' || x.charAt(0) == 'C')
                numvebOfWords++;
        }
        System.out.println("Number of words which start on 'C' are " + numvebOfWords);
    }
}
