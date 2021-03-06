import java.util.ArrayList;

class StringEditor
{
    private String string;
    private ArrayList<Character> editor = new ArrayList<>();
    private MyArrayList<String> strings = new MyArrayList<>();
    private StringBuilder stringBuilder = new StringBuilder();

    boolean emptyString() { return null != string; }

    boolean emptyArrayList() { return editor.isEmpty(); }

    void setString (String string)
    {
        this.string = string;
    }

    void editString ()
    {
        for (int i = 0; i < string.length(); i++)
        {
            if (Character.isSpaceChar(string.charAt(i)) || Character.isLetter(string.charAt(i)) || string.charAt(i) == '.' || string.charAt(i) == ',')
                editor.add(string.charAt(i));
        }

        while(Character.isSpaceChar(editor.get(editor.size() - 1)))
            editor.remove(editor.size() - 1);

        for (int i = 0; i < editor.size(); i++)
        {
            if ((editor.get(i) == '.' || editor.get(i) == ',') && i != editor.size() - 1)
                editor.add(i + 1, ' ');

            if (Character.isSpaceChar(editor.get(i)) && Character.isSpaceChar(editor.get(i + 1)))
            {
                editor.remove(i + 1);
                i--;
            }

            if ((editor.get(i) == '.' || editor.get(i) == ',') && Character.isSpaceChar(editor.get(i - 1)))
            {
                editor.remove(i - 1);
                i--;
            }
        }

        while (Character.isSpaceChar(editor.get(0)))
            editor.remove(0);

        for(Character x : editor)
        {
            stringBuilder.append(x);
        }

        strings.add(stringBuilder.toString());
    }

    void showString()
    {
        System.out.println(string);
    }

    void showResult()
    {
        for (Character x: editor)
            System.out.print(x);
        System.out.println();
        System.out.println(strings.get(0));
    }
}