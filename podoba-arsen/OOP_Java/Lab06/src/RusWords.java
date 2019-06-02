import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class RusWords
{
    MyLinkedList<String> rusWords;

    RusWords(){
        rusWords = new MyLinkedList<>();
    }

    void fillContainer(){
        BufferedReader bufferedReader;

        try {
            bufferedReader = new BufferedReader(new FileReader("word_rus.txt"));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                rusWords.add(line);
            }
        }
        catch (IOException m){
            System.out.println(m);
        }
    }

    public MyLinkedList<String> getRusWords() { return rusWords; }
}
