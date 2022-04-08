public class ArrayDeque<T> {
    private T[] items;
    private int nextFirst;
    private int nextLast;
    private final int CAPACITY = 8;

    public ArrayDeque(){
        items = (T[])new Object[CAPACITY];
        nextFirst = nextLast = 0;
    }

    /*must take constant time.*/
    public int size(){
            return (nextLast - nextFirst + items.length) % items.length;
    }

    public boolean isEmpty(){
        return this.size() == 0;
    }

    private void resize(int capacity){
        T[] a = (T[]) new Object[capacity];
        int index = nextFirst;
        int n;
        for (n = 0; index != nextLast; n++){
            a[n] = items[index];
            index = (index + 1 + items.length) % items.length;
        }
        items = a;
        nextFirst = 0;
        nextLast = n;
    }

    /*must take constant time.*/
    public T get(int index){
        if(index <= 0 || index > size() + 1 || isEmpty()){
            return null;
        }
        index = (index + nextFirst - 1) % items.length;
        return items[index];
    }

    /*must take constant time.*/
    public ArrayDeque addFirst(T item){
        if (this.size() != items.length - 1) {
            nextFirst = (nextFirst - 1 + items.length) % items.length;
            items[nextFirst] = item;
        } else {
            this.resize(items.length * 2);
            addFirst(item);
        }
        return this;
    }

    /*must take constant time.*/
    public ArrayDeque addLast(T item){           //**链式调用 return this
        if (this.size() != items.length - 1) {
            items[nextLast] = item;
            nextLast = (nextLast + 1 + items.length) % items.length;
        } else {
            this.resize(items.length * 2 );
            addLast(item);
        }
        return this;
    }

    /*must take constant time.*/
    public T removeFirst(){
        if(isEmpty()) {
            return null;
        }
        T tempitem = items[nextLast];
        items[nextFirst] = null;
        nextFirst = (nextFirst + 1 + items.length) % items.length;
        if(size() / (double)items.length < 0.25 && items.length >= 16){
            resize((int)(items.length * 0.5));
        }
        return tempitem;
    }

    /*must take constant time.*/
    public T removeLast(){
        if(isEmpty()) {
            return null;
        }
        T tempitem = items[nextLast];
        items[nextLast] = null;
        nextLast = (nextLast - 1 + items.length) % items.length;
        if(size() / (double)items.length < 0.25 && items.length >= 16){
            resize((int)(items.length * 0.5));
        }
        return tempitem;
    }

    public void printDeque(){
        int index = nextFirst;
        System.out.println(items[index]);
        index = (index + 1 + items.length) % items.length;
        while (index != nextLast){
            System.out.println(items[index]);
            index = (index + 1 + items.length) % items.length;
        }
    }

    public void showDeque(){
        int i = 0;
        while (i < items.length){
            System.out.println(items[i]);
            i++;
        }
    }
}
