public class ArrayDeque <T>{

    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    public ArrayDeque()
    {
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = 2;
        nextLast = 3;
    }
    /**
    public ArrayDeque( ArrayDeque other)
    {
        this.nextFirst = other.nextFirst;
        this.nextLast = other.nextLast;
        this.size = other.size;
        items = (T[]) new Object[other.items.length];
        System.arraycopy(other.items,nextFirst+1,items,nextFirst+1,size );

    }

     */

    private void resize(float factor)
    {
        T[] oldItems = items;
        items = (T[]) new Object[ Math.round(oldItems.length * factor)];

        int startIndex = Math.round(oldItems.length*factor/4);

        System.arraycopy(oldItems,nextFirst+1,items,startIndex,size );

        nextLast =  startIndex +size;
        nextFirst = startIndex-1;


    }

    public void addFirst (T item)
    {
        if(nextFirst==0)
        {
            resize(2);
        }

        items[nextFirst] = item;
        size++;
        nextFirst--;
    }


    public void addLast (T item)
    {
        if(nextLast == items.length)
        {
            resize(2);
        }

        items[nextLast] = item;
        size++;
        nextLast++;
    }

    public boolean isEmpty()
    {
        return size==0;
    }

    public int size()
    {
        return size;
    }

    public T removeFirst()
    {
        if(size == 0)
        {
            return null;
        }
        if(items.length>=16 && ((float)(size-1)/(float)items.length) <0.25)
        {
            resize(0.5F);
        }

        size--;
        nextFirst++;
        return items[nextFirst];
    }


    public void printDeque()
    {
        for(int i = nextFirst+1; i< nextLast; i++)
        {
            System.out.print( this.items[i] +" ");
        }
        System.out.println();
    }


    public T removeLast()
    {
        if(size == 0)
        {
            return null;
        }
        if(items.length>=16 && ((float)(size-1)/(float)(items.length)) <0.25)
        {
            resize(0.5F);
        }
        size--;
        nextLast--;
        return items[nextLast];
    }

    public T get( int index)
    {
        if( index >=size)
        {
            return null;
        }
        return items[nextFirst+1+index];
    }

}
