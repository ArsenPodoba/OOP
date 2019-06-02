public class CurrentThread
{
    RusWords vocabluary;
    static final double DEVIDER = 1000000;

    CurrentThread(){
        vocabluary = new RusWords();
        vocabluary.fillContainer();
    }

    public void startThread(){
        long start = System.nanoTime();

        int counterE = 0;
        int maxE = 0;
        String uniqWord = "";
        for (String x : vocabluary.getRusWords())
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

        int numvebOfWords = 0;
        for (String x: vocabluary.getRusWords()){
            if(x.charAt(0) == 'c' || x.charAt(0) == 'C')
                numvebOfWords++;
        }
        System.out.println("Number of words which start on 'C' are " + numvebOfWords);

        int max = 0;
        String maxLenghtWord = "";
        for(String x: vocabluary.getRusWords()) {
            if(x.length() > max)
            {
                max = x.length();
                maxLenghtWord = x;
            }
        }
        System.out.println("The longest word is " + "\"" + maxLenghtWord + "\"" + " with length " + max);

        double result = ((double)(System.nanoTime() - start))/1000000.0;

        System.out.println("Processing lasted by " + result + " milliseconds");
    }
}
