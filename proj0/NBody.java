public class NBody {
    public static double readRadius(String fileName){
        In in = new In(fileName);
        in.readInt();
        return in.readDouble();
    }

    public static Planet[] readPlanets(String fileName){
        In in = new In(fileName);
        int num = in.readInt();
        in.readDouble();
        Planet[] pa = new Planet[num];
    }

    public static void main(String[] args){
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
    }
}
