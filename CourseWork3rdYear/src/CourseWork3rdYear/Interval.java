package CourseWork3rdYear;


/**
 * Created by Аделя on 27.01.2017.
 */
public class Interval {
    protected int x1;
    protected int x2;

    protected int number;
    protected double part=0;

    public int getX1(){return x1;}
    public int getX2() {return x2;}
    public void setNumber(int number) {this.number = number;}
    public int getNumber() {return number;}
    public void setX1(int x1) {this.x1 = x1;}
    public void setX2(int x2) {this.x2 = x2;}
    public double getPart(){return part;}
    public void setPart(double part){this.part=part;}
    public void clear(){x1=0; x2=0;}
    public double lengthOfInterval(){return Math.sqrt(Math.pow(x2-x1,2));}
    public String toString(){return "[ "+getX1()+", "+getX2()+" ]";}
    private int findX1AtGraphic(Graphic graphic){
        int k;
        for(k=0; getX1()!=graphic.getX().get(k); k++);
        return k;
    }
    public boolean increaseAndDecrease(Graphic graphic){
        int i=findX1AtGraphic(graphic), j=0;
        boolean b=true;
        if(graphic.getY().get(i)<graphic.getY().get(i+1)){
            b=true;
        }
        else if(graphic.getY().get(i)>graphic.getY().get(i+1)){
            b=false;
        }
        else{
            if(graphic.getY().get(i+1)<graphic.getY().get(i+2)){
                b=true;
            }
            else if(graphic.getY().get(i+1)>graphic.getY().get(i+2)){
                b=false;
            }
        }
        return b;
    }
}
