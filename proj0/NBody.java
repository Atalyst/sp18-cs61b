public class NBody {
    public static double readRadius(String fileName){
        In in = new In(fileName);
        in.readInt();
        return in.readDouble();
    }

    public static Planet[] readpa(String fileName){
        In in = new In(fileName);
        int num = in.readInt();
        in.readDouble();
        Planet[] pa = new Planet[num];
        for(int index = 0;index < num;index++){
            double xP = in.readDouble();
            double yP = in.readDouble();
            double xV = in.readDouble();
            double yV = in.readDouble();
            double m = in.readDouble();
            String iF = in.readString();
            pa[index] = new Planet(xP,yP,xV,yV,m,iF);
        }
        return pa;
    }

    public static void main(String[] args){
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        double r = readRadius(filename);
        Planet[] pa = readpa(filename);

        /*     Draw    */
        StdDraw.setScale(-r,r);
        StdDraw.clear();
        StdDraw.picture(0,0,"images/starfield.jpg");
        for(Planet p : pa){
            p.draw();
        }

        /*     Animation     */
        StdDraw.enableDoubleBuffering();
        double[] xForce = new double[pa.length];
        double[] yForce = new double[pa.length];
        for(int time = 0;time <= T;time++){
            int index = 0;
            int index_2 = 0;
            for (Planet p : pa){
                xForce[index] = p.calcNetForceExertedByX(pa);
                yForce[index] = p.calcNetForceExertedByY(pa);
                index++;
            }
            for (Planet p : pa){
                p.update(dt,xForce[index_2],yForce[index_2]);
                index_2++;
            }
            StdDraw.picture(0,0,"images/starfield.jpg");
            for (Planet p : pa){
                p.draw();
            }
            StdDraw.show();
            StdDraw.clear();
            StdDraw.pause(10);

        }

        /*    Print    */
        StdOut.printf("%d\n", pa.length);
        StdOut.printf("%.2e\n", r);
        for (int i = 0; i < pa.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    pa[i].xxPos, pa[i].yyPos, pa[i].xxVel,
                    pa[i].yyVel, pa[i].mass, pa[i].imgFileName);
        }
    }
}
