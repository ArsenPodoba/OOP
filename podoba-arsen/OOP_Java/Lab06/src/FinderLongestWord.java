public class FinderLongestWord implements Runnable
{
    MyLinkedList<String> myLinkedList;

    FinderLongestWord(MyLinkedList myLinkedList) {
        this.myLinkedList = myLinkedList;
    }

    @Override
    public void run() {
        int max = 0;
        String maxLenghtWord = "";
        for(String x: myLinkedList) {
            if(x.length() > max)
            {
                max = x.length();
                maxLenghtWord = x;
            }
        }
        System.out.println("The longest word is " + "\"" + maxLenghtWord +"\"" + " with length " + max);
    }
}
