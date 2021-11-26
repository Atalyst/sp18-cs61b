public class Planet  {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    public static final double G = 6.67e-11;
    public Planet(double xP,double yP,double xV,double yV,double m,String img){
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }
    public Planet(Planet p){
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }
    public double calcDistance(Planet p){
        double dx = Math.abs(this.xxPos - p.xxPos);
        double dy = Math.abs(this.yyPos - p.yyPos);
        return Math.sqrt(dx*dx + dy*dy);
    }

    public double calcForceExertedBy(Planet p){
        return (G * this.mass * p.mass)/(calcDistance(p) * calcDistance(p));
    }

    public double calcForceExertedByX(Planet p){
        return calcForceExertedBy(p)*(p.xxPos - xxPos)/calcDistance(p);
    }

    public double calcForceExertedByY(Planet p){
        return calcForceExertedBy(p)*(p.yyPos - this.yyPos)/calcDistance(p);
    }

    public double calcNetForceExertedByX(Planet[] pa){
        double nfx = 0;
        for(Planet p : pa){                //use foreach(features of java1.5): for(arrayType name :array).
            if (!this.equals(p)) {
                nfx += calcForceExertedByX(p);
            }
        }
        return nfx;
    }

    public double calcNetForceExertedByY(Planet[] pa){
        double nfy = 0;
        for(Planet p : pa){                //use foreach(features of java1.5): for(arrayType name :array).
            if (!this.equals(p)) {
                nfy += calcForceExertedByY(p);
            }
        }
        return nfy;
    }

    public void update(double t,double fX,double fY){
        xxVel += t * fX / this.mass;
        yyVel += t * fY / this.mass;
        xxPos += t * xxVel;
        yyPos += t * yyVel;
    }

    public void draw(){
        String imgName = this.imgFileName;
        StdDraw.picture(xxPos,yyPos,"images/"+imgName);
    }
}