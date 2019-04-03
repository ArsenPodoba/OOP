import java.util.Iterator;

public class MyArrayIterator<T> implements Iterator<T>
{
    private int index = 0;
    private String[] values;

    MyArrayIterator(String[] values)
    {
        this.values = values;
    }

    @Override
    public boolean hasNext()
    {
        return index < values.length;
    }

    @Override
    public T next()
    {
        return (T)values[index++];
    }
}
