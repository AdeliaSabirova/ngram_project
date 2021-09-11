package CourseWork3rdYear;

import java.util.Vector;

/**
 * Created by Аделя on 29.01.2017.
 */
public class Graphic {
    protected Vector<Integer> x;
    protected Vector<Double> y;

    public Graphic(){
        x=new Vector<>();
        y=new Vector<>();
    }
    public Graphic(Vector<Integer> x, Vector<Double> y){
        this.x=x;
        this.y=y;
    }
    public Vector<Integer> getX() {return x;}
    public Vector<Double> getY() {return y;}
    public void setX(Vector<Integer> x) {this.x = x;}
    public void setY(Vector<Double> y) {this.y = y;}
}
