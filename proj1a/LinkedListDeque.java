public class LinkedListDeque<T> {
    public class LLDeque {
        private T item;
        private LLDeque prev;
        private LLDeque next;

        public LLDeque(T item, LLDeque prev, LLDeque next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }

    private LLDeque sentinel;
    private int size;

    public LinkedListDeque() {
        sentinel = new LLDeque(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    public LinkedListDeque(T x) {
        sentinel = new LLDeque(null, null, null);
        sentinel.next = new LLDeque(x, sentinel, sentinel);
        sentinel.prev = sentinel.next;
        size = 1;
    }

    public void addFirst(T x) {
        LLDeque prevfirst = sentinel.next;
        sentinel.next = new LLDeque(x, sentinel, sentinel.next);
        prevfirst.prev = sentinel.next;
        size++;
    }

    public void addLast(T x) {
        LLDeque prevlast = sentinel.prev;
        sentinel.prev = new LLDeque(x, prevlast, sentinel);
        prevlast.next = sentinel.prev;
        size++;
    }

    public T get(int index) {
        LLDeque pt = sentinel.next;
        int count = 1;
        while (pt != sentinel) {
            if (count == index) {
                return pt.item;
            }
            pt = pt.next;
            count++;
        }
        return null;
    }

    private T getRecursiveHelper(int index, int count, LLDeque pt) {
        if (count == index) {
            return pt.item;
        }
        return getRecursiveHelper(index, count + 1, pt.next);
    }

    public T getRecursive(int index) {
        if (index > size) {
            return null;
        }
        int count = 0;
        LLDeque pt = sentinel.next;
        return getRecursiveHelper(index, count, pt);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        if (0 == size) {
            return true;
        }
        return false;
    }

    public void printDeque() {
        LLDeque pt = sentinel.next;
        while (pt != sentinel) {
            System.out.print(pt.item + " ");
            pt = pt.next;
        }
    }

    public T removeFirst(){
        if(0 == size){
            return null;
        }
        T pt = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        size -= 1;
        return pt;
    }

    public T removeLast(){
        if(0 == size){
            return null;
        }
        T pt = sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        size -= 1;
        return pt;
    }
}