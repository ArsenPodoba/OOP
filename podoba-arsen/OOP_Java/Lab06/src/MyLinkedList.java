import java.io.Serializable;
import java.util.Iterator;

public class MyLinkedList <T> implements Iterable <T>, Serializable
{
    private Node<T> firstNode;
    private Node<T> lastNode;
    private int size = 0;

    private class Node<T> implements Serializable
    {
        T currentElement;
        Node<T> nextElement;

        Node(T currentElement, Node<T> nextElement)
        {
            this.currentElement = currentElement;
            this.nextElement = nextElement;
        }

        public Node(){}

        public T getCurrentElement()
        {
            return currentElement;
        }

        public Node<T> getNextElement()
        {
            return nextElement;
        }

        public void setNextElement(Node<T> nextElement)
        {
            this.nextElement = nextElement;
        }

        public void setCurrentElement(T currentElement)
        {
            this.currentElement = currentElement;
        }
    }

    public MyLinkedList()
    {
        lastNode = new Node<>(null, null);
        firstNode = new Node<>(null, lastNode);
    }

    private Node<T> getNextElement (Node<T> current) { return current.nextElement; }

    public void add(T element)
    {
        Node<T> temp = lastNode;
        temp.currentElement = element;
        lastNode = new Node<>(null, null);
        temp.nextElement = lastNode;
        size++;
    }

    public T get(int index)
    {
        Node<T> target = firstNode.nextElement;

        for (int i = 0; i < index; i++)
            target = getNextElement(target);

        return target.currentElement;
    }

    public boolean set(int index, T elemetn)
    {
        if(index >= size)
            return false;
        else
        {
            Node<T> target = firstNode.nextElement;

            for (int i = 0; i < index; i++)
                target = getNextElement(target);

            target.currentElement = elemetn;
            return true;
        }
    }

    public boolean remove (T element)
    {
        Node<T> targer = firstNode;

        for(int i = 0; i < size; i++)
        {
            if(targer.nextElement.currentElement.equals(element))
            {
                targer.nextElement = targer.nextElement.nextElement;
                size--;
                return true;
            }
            else
                targer = getNextElement(targer);
        }
        return false;
    }

    public boolean contain(T element)
    {
        Node<T> target = firstNode.nextElement;

        for(int i = 0; i < size; i++)
        {
            if(target.currentElement.equals(element))
                return true;
            else
                target = getNextElement(target);
        }

        return false;
    }

    public int size() { return size; }

    public void clear()
    {
        lastNode = new Node<>(null, null);
        firstNode = new Node<>(null, lastNode);
        size = 0;
    }

    public Object[] toArray()
    {
        Object[] massive = new Object[size];
        Node<T> temp = firstNode.nextElement;

        for (int i = 0; i < size; i++)
        {
            massive[i] = temp.currentElement;
            temp = getNextElement(temp);
        }

        return massive;
    }

    @Override
    public String toString()
    {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[ ");

        Node<T> temp = firstNode.nextElement;

        for(int i = 0; i < size; i++)
        {
            if(i == size - 1)
            {
                stringBuilder.append(temp.currentElement);
                temp = getNextElement(temp);
                stringBuilder.append(" ]");
            }
            else
            {
                stringBuilder.append(temp.currentElement);
                temp = getNextElement(temp);
                stringBuilder.append(", ");
            }
        }

        String finalString = stringBuilder.toString();

        return finalString;
    }

    @Override
    public Iterator<T> iterator()
    {
        return new Iterator<>()
        {
            int counter = 0;
            @Override
            public boolean hasNext()
            {
                return counter < size;
            }

            @Override
            public T next()
            {
                return get(counter++);
            }
        };
    }
}
