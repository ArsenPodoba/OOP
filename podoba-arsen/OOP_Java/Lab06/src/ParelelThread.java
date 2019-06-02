public class ParelelThread
{
    RusWords vocabluary;
    int mLimit;
    static final double DEVIDER = 1000000;

    ParelelThread(){
        vocabluary = new RusWords();
        vocabluary.fillContainer();
    }

    public void setmLimit(int mLimit) { this.mLimit = mLimit; }

    public void startThread(){
        Thread longestWord = new Thread(new FinderLongestWord(vocabluary.getRusWords()));
        Thread wordsC = new Thread(new FinderNumberOfWordsWhichStartC(vocabluary.getRusWords()));
        Thread uniq = new Thread(new FinderUniqWord(vocabluary.getRusWords()));

        long start = System.nanoTime();
        int count = 0;

        wordsC.start();
        longestWord.start();
        uniq.start();

        if(wordsC.isAlive() || longestWord.isAlive() || uniq.isAlive()){
            try {
                if(mLimit > 0)
                {
                    if((double)(System.nanoTime() - start)/DEVIDER > mLimit)
                    {
                        count++;
                        wordsC.stop();
                    }
                    else
                        wordsC.join();
                }
                else
                    wordsC.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            try {
                if(mLimit > 0)
                {
                    if((double)(System.nanoTime() - start)/DEVIDER > mLimit)
                    {
                        count++;
                        uniq.stop();
                    }
                    else
                        uniq.join();
                }
                else
                    uniq.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            try {
                if(mLimit > 0)
                {
                    if((double)(System.nanoTime() - start)/DEVIDER > mLimit)
                    {
                        count++;
                        longestWord.stop();
                    }
                    else
                        longestWord.join();
                }
                else
                    longestWord.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if(count > 0)
            System.out.println("System could not all made processing");
        else {
            double result = ((double) (System.nanoTime() - start)) / DEVIDER;

            System.out.println("Processing lasted by " + result + " milliseconds");
        }
    }
}
