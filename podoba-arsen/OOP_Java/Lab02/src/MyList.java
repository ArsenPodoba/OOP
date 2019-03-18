import java.util.Iterator;

public interface MyList <T> extends Iterable <T>
{
    String toString();

    void add (String string);

    String get (int index);

    void set (String string, int index);

    void clear();

    boolean remove(String string);

    int size();

    boolean contains (String string);

    String[] toArray();

    Iterator<T> iterator();

    boolean containsAll(MyArrayList myArrayList);
}
