import java.util.Random;

public class ArrayDequeTest {
    public static void main(String[] args){
        ArrayDeque test = new ArrayDeque();
        Random r = new Random();
        for(int i = 0; i < 50; i++){
            switch (r.nextInt(4)) {                                               //java 12特性：switch简化
                case 0 -> test.addLast(r.nextInt(50));
                case 1 -> test.addFirst(r.nextInt(50));
                case 2 -> test.removeFirst();
                case 3 -> test.removeLast();
            }
        }
        test.printDeque();
        int i = test.size();
        System.out.println("size :" + i);
    }
}
