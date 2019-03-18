import java.io.Serializable;
import java.util.Iterator;

public class MyArrayList<T> implements  MyList<T>, Serializable
{
    private String [] values;

    MyArrayList() { values = new String[0]; }

    @Override
    public String toString()
    {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("[ ");
        for(int i = 0; i < values.length; i++)
        {
            if(i < values.length - 1)
                stringBuilder.append(values[i] + ", ");
            else
                stringBuilder.append(values[i] + " ");
        }

        stringBuilder.append("]");

        return stringBuilder.toString();
    }

    @Override
    public void add(String string)
    {
        try
        {
            String [] temp = values;
            values = new String[values.length + 1];

            System.arraycopy(temp, 0, values, 0, temp.length);

            values[temp.length] = string;
        }
        catch (ClassCastException ex)
        {
            ex.printStackTrace();
        }

    }

    @Override
    public String get(int index) { return values[index]; }

    @Override
    public void set(String string, int index)
    {
        if(index < values.length)
            values[index] = string;
        else
            return;
    }

    @Override
    public void clear() { values = null; }

    @Override
    public boolean remove(String string)
    {
        for(int i = 0; i < values.length; i++)
        {
            if(values[i].equals(string))
            {
                try
                {
                    String[] temp = values;
                    values = new String[values.length - 1];

                    System.arraycopy(temp, 0, values, 0, i);
                    int amountElementAfterCopy = temp.length - i - 1;

                    System.arraycopy(temp, i + 1, values, i, amountElementAfterCopy);
                }
                catch (ClassCastException ex)
                {
                    ex.printStackTrace();
                }
            }
        }

        return false;
    }

    @Override
    public int size() { return values.length; }

    @Override
    public boolean contains(String string)
    {
        for (int i = 0; i < values.length; i++)
        {
            if(values[i].equals(string))
                return true;
        }

        return false;
    }

    @Override
    public String[] toArray() { return values; }

    @Override
    public Iterator<T> iterator() { return new MyArrayIterator<>(values); }

    @Override
    public boolean containsAll(MyArrayList myArrayList)
    {
        if(values == null || myArrayList == null)
            return false;
        else
        {
            for (Object x : myArrayList)
            {
                int i = 0;
                for (String y : values)
                {
                    if (x.equals(y))
                        i++;
                }
                if (i == 0)
                    return false;
            }
            return true;
        }
    }
}