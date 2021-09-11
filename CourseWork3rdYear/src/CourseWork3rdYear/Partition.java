package CourseWork3rdYear;

import java.util.ArrayList;


/**
 * Created by Аделя on 29.01.2017.
 */

public class Partition {
    private ArrayList<Interval> goodIntervals;
    private ArrayList<Interval> badIntervals;

    public ArrayList<Interval> getGoodIntervals() {return goodIntervals;}
    public ArrayList<Interval> getBadIntervals() {return badIntervals;}
    public void setBadIntervals(ArrayList<Interval> badIntervals) {this.badIntervals = badIntervals;}
    public void setGoodIntervals(ArrayList<Interval> goodIntervals) {this.goodIntervals = goodIntervals;}
    private void addInterval(boolean b, int a, int c, int number){
        Interval interval = new Interval();
        interval.setX1(a);
        interval.setX2(c);
        interval.setNumber(number);
        if(!b){
            getGoodIntervals().add(interval);
        }
        else
            getBadIntervals().add(interval);
    }
    Partition(Graphic first, Graphic second){partition(first, second);}
    private void partition(Graphic first, Graphic second){
        goodIntervals=new ArrayList<>();
        badIntervals=new ArrayList<>();
        int a=0, c=0;
        double l=0, p=0;
        a=first.getX().get(0);

        int size=0;
        size=first.getX().size();
        boolean b=true;
        int number=0;
        int q=0;
        for (int i=0; i<size; i++){
            if(i==size-1){
                c=first.getX().get(i);
                addInterval(!b,a,c, number);
            }
            else if(i==0){
                if(b) {
                    if ((first.getY().get(i + 1) > first.getY().get(i)) && (second.getY().get(i + 1) < second.getY().get(i)))
                        b = false;
                    else if((first.getY().get(i + 1) < first.getY().get(i)) && (second.getY().get(i + 1) > second.getY().get(i)))
                        b=false;
                    else if(first.getY().get(i).equals(second.getY().get(i))&&(!((first.getY().get(i + 1) > first.getY().get(i)) && (second.getY().get(i + 1) > second.getY().get(i)))||!((first.getY().get(i + 1) < first.getY().get(i)) && (second.getY().get(i + 1) < second.getY().get(i)))))
                        b=false;
                    if(!b){
                        c=first.getX().get(i+1);
                        addInterval(b,a,c, number);
                        a=first.getX().get(i+1);
                        number++;
                        i++;
                    }
                }
                else {
                    if ((first.getY().get(i + 1) > first.getY().get(i)) && (second.getY().get(i + 1) > second.getY().get(i)))
                        b = true;
                    else if((first.getY().get(i + 1) < first.getY().get(i)) && (second.getY().get(i + 1) < second.getY().get(i)))
                        b=true;
                    else if(first.getY().get(i).equals(second.getY().get(i))&&(((first.getY().get(i + 1) > first.getY().get(i)) && (second.getY().get(i + 1) > second.getY().get(i)))||((first.getY().get(i + 1) < first.getY().get(i)) && (second.getY().get(i + 1) < second.getY().get(i)))))
                        b=true;
                    if(b){
                        c=first.getX().get(i+1);
                        addInterval(b,a,c, number);
                        a=first.getX().get(i+1);
                        number++;
                        i++;
                    }
                }
            }
                else {
                if (b) {
                    if ((first.getY().get(i + 1) > first.getY().get(i)) && (second.getY().get(i + 1) < second.getY().get(i)))
                        b = false;
                    else if(((first.getY().get(i + 1) > first.getY().get(i))&&(first.getY().get(i - 1) >= first.getY().get(i))) && ((second.getY().get(i + 1) > second.getY().get(i))&&(second.getY().get(i - 1) >= second.getY().get(i))))
                        q=1;
                    else if ((first.getY().get(i + 1) < first.getY().get(i)) && (second.getY().get(i + 1) > second.getY().get(i)))
                        b = false;
                    else if(((first.getY().get(i + 1) < first.getY().get(i))&&(first.getY().get(i - 1) <= first.getY().get(i))) && ((second.getY().get(i + 1) < second.getY().get(i))&&(second.getY().get(i - 1) <= second.getY().get(i))))
                        q=1;
                    else if(((first.getY().get(i + 1) < first.getY().get(i))&&(first.getY().get(i - 1) <= first.getY().get(i))) && ((second.getY().get(i + 1) > second.getY().get(i))&&(second.getY().get(i - 1) >= second.getY().get(i))))
                        q=1;
                    else if(((first.getY().get(i + 1) > first.getY().get(i))&&(first.getY().get(i - 1) >= first.getY().get(i))) && ((second.getY().get(i + 1) < second.getY().get(i))&&(second.getY().get(i - 1) <= second.getY().get(i))))
                        q=1;
                    else if (first.getY().get(i).equals(second.getY().get(i)) && (!((first.getY().get(i + 1) > first.getY().get(i)) && (second.getY().get(i + 1) > second.getY().get(i))) || !((first.getY().get(i + 1) < first.getY().get(i)) && (second.getY().get(i + 1) < second.getY().get(i)))))
                        b = false;
                    if (!b) {
                        c = first.getX().get(i);
                        addInterval(b, a, c, number);
                        a = first.getX().get(i);
                        number++;
                    }
                    if(q==1){
                        c = first.getX().get(i);
                        addInterval(!b, a, c, number);
                        a = first.getX().get(i);
                        number++;
                        q=0;
                    }
                } else {
                    if ((first.getY().get(i + 1) > first.getY().get(i)) && (second.getY().get(i + 1) > second.getY().get(i)))
                        b = true;
                    else if(((first.getY().get(i + 1) > first.getY().get(i))&&(first.getY().get(i - 1) >= first.getY().get(i))) && ((second.getY().get(i + 1) > second.getY().get(i))&&(second.getY().get(i - 1) >= second.getY().get(i))))
                        q=1;
                    else if ((first.getY().get(i + 1) < first.getY().get(i)) && (second.getY().get(i + 1) < second.getY().get(i)))
                        b = true;
                    else if(((first.getY().get(i + 1) < first.getY().get(i))&&(first.getY().get(i - 1) <= first.getY().get(i))) && ((second.getY().get(i + 1) < second.getY().get(i))&&(second.getY().get(i - 1) < second.getY().get(i))))
                        q=1;
                    else if(((first.getY().get(i + 1) < first.getY().get(i))&&(first.getY().get(i - 1) <= first.getY().get(i))) && ((second.getY().get(i + 1) > second.getY().get(i))&&(second.getY().get(i - 1) > second.getY().get(i))))
                        q=1;
                    else if(((first.getY().get(i + 1) > first.getY().get(i))&&(first.getY().get(i - 1) >= first.getY().get(i))) && ((second.getY().get(i + 1) < second.getY().get(i))&&(second.getY().get(i - 1) < second.getY().get(i))))
                        q=1;
                    else if (first.getY().get(i).equals(second.getY().get(i)) && (((first.getY().get(i + 1) > first.getY().get(i)) && (second.getY().get(i + 1) > second.getY().get(i))) || ((first.getY().get(i + 1) < first.getY().get(i)) && (second.getY().get(i + 1) < second.getY().get(i)))))
                        b = true;
                    if (b) {
                        c = first.getX().get(i);
                        addInterval(b, a, c, number);
                        a = first.getX().get(i);
                        number++;
                    }
                    if(q==1){
                        c = first.getX().get(i);
                        addInterval(!b, a, c, number);
                        a = first.getX().get(i);
                        number++;
                        q=0;
                    }
                }
            }
        }

    }
    private Interval minInBadIntervals(){
        Interval min;
        if(!getBadIntervals().isEmpty()) {
            min = getBadIntervals().get(0);
            for (int i = 1; i < getBadIntervals().size(); i++)
                if (min.lengthOfInterval() > getBadIntervals().get(i).lengthOfInterval()) {
                    min = getBadIntervals().get(i);
                }
        }
        else{
            min = getGoodIntervals().get(0);
            for (int i = 1; i < getGoodIntervals().size(); i++)
                if (min.lengthOfInterval() > getGoodIntervals().get(i).lengthOfInterval()) {
                    min = getGoodIntervals().get(i);
                }
        }
        return min;
    }
    public double[] firstCharacterization(){
        double good=0, sum=0, bad=0;
        Interval min=minInBadIntervals();
        ArrayList<Double> percentOfGood=new ArrayList<>();
        ArrayList<Double> percentOfBad=new ArrayList<>();
        for(int i=0; i<goodIntervals.size(); i++) {
            percentOfGood.add(goodIntervals.get(i).lengthOfInterval() / min.lengthOfInterval());
            goodIntervals.get(i).setPart(goodIntervals.get(i).lengthOfInterval() / min.lengthOfInterval());
        }
        for(int i=0; i<badIntervals.size(); i++) {
            percentOfBad.add(badIntervals.get(i).lengthOfInterval() / min.lengthOfInterval());
            badIntervals.get(i).setPart(badIntervals.get(i).lengthOfInterval() / min.lengthOfInterval());
        }
        for (int i=0; i<percentOfGood.size(); i++) {
            sum += percentOfGood.get(i);
            good+=percentOfGood.get(i);
        }
        for (int i=0; i<percentOfBad.size();i++){
            sum+=percentOfBad.get(i);
            bad+=percentOfBad.get(i);
        }
        double[] firstcharact=new double[2];
        firstcharact[0]=good/sum;
        firstcharact[1]=bad/sum;
        return firstcharact;
    }
    public void printIntervals(){
        System.out.println("goodIntervals are");
        for(int i=0; i<getGoodIntervals().size();i++){
            System.out.println(getGoodIntervals().get(i).toString() +" length of interval "+getGoodIntervals().get(i).lengthOfInterval()+ " number of interval "+getGoodIntervals().get(i).getNumber());
        }

        System.out.println("badIntervals are");
        for(int i=0; i<getBadIntervals().size();i++){
            System.out.println(getBadIntervals().get(i).toString() +" length of interval "+getBadIntervals().get(i).lengthOfInterval()+" number of interval "+getBadIntervals().get(i).getNumber());
        }
    }

}
