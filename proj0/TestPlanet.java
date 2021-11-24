/**
 *  My Tests class
 */
public class TestPlanet {
    public static void main(String[] args){
        checkCalcForceExertedBy();
    }

    private static void checkEquals(double actual,double expected,double eps,String label){
        if(Math.abs(actual - expected) <= eps * Math.max(actual,expected)){
            System.out.println("PASS:"+label+"actual:"+actual+"expected:"+expected);
        }else {
            System.out.println("FAIL"+label+"actual:"+actual+"expected:"+expected);
        }
    }

    private static void checkCalcForceExertedBy(){
        System.out.println("Checking CalcForceExertedBy...");

        Planet p1 = new Planet(1.0, 1.0, 3.0, 4.0, 5.0, "ball.gif");
        Planet p2 = new Planet(5.0, 2.0, 1.0, 1.0, 3.0, "acorn3.gif");

        checkEquals(p1.calcForceExertedBy(p2),5.89,1, "calcForceExertedBy()");
    }
}
