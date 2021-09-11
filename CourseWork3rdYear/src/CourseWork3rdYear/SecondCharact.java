package CourseWork3rdYear;

import java.util.ArrayList;
import java.util.Vector;

/**
 * Created by Аделя on 30.04.2017.
 */
public class SecondCharact {
    private Graphic anotherFirst;
    private Graphic anotherSecond;

    public SecondCharact(Graphic first, Graphic second){shiftGraphics(first, second);}

    public Graphic getAnotherFirst() {
        return anotherFirst;
    }

    public Graphic getAnotherSecond() {
        return anotherSecond;
    }

    private void addElements(Graphic graphic, Interval interval, Graphic newGraphic, int k, int q){
        int i=0;
        for(i=findX1AtGraphic2(graphic,interval); interval.getX2()!=graphic.getX().get(i); i++){
            if(graphic.getX().get(i).equals(graphic.getX().get(graphic.getX().size()-1))){
                newGraphic.getX().add(graphic.getX().get(graphic.getX().size()-1)+i + k);
                newGraphic.getY().add(graphic.getY().get(i));
            }
            else {
                newGraphic.getX().add(graphic.getX().get(i) + k + q);
                newGraphic.getY().add(graphic.getY().get(i));
            }
        }
    }
    private int findX1AtGraphic2 (Graphic graphic, Interval interval){
        int k;
        for(k=0; interval.getX1()!=graphic.getX().get(k); k++);
        return k;
    }
    private int findX2AtGraphic2 (Graphic graphic, Interval interval){
        int k;
        for(k=0; interval.getX2()!=graphic.getX().get(k); k++);
        return k;
    }
    private int shift(Graphic graphic, Interval interval, Graphic newGraphic, int k, int size, boolean b){
        int d=0;
        for(int i=0; i<size; i++){
            if(graphic.getX().get(i).equals(graphic.getX().get(graphic.getX().size()-1))){
                newGraphic.getX().add(graphic.getX().get(graphic.getX().size()-1)+i + k);
                newGraphic.getY().add(graphic.getY().get(findX1AtGraphic2(graphic,interval)));
            }
            else {
                if(b) {
                    newGraphic.getX().add(graphic.getX().get(findX2AtGraphic2(graphic, interval)) + i + k);
                    newGraphic.getY().add(graphic.getY().get(findX2AtGraphic2(graphic, interval)));
                }
                else {
                    newGraphic.getX().add(graphic.getX().get(findX1AtGraphic2(graphic, interval))+k + i);
                    newGraphic.getY().add(graphic.getY().get(findX1AtGraphic2(graphic,interval)));
                    d++;
                }
            }
        }
        return d;
    }
    private ArrayList<Interval> part(Graphic graphic){
        ArrayList<Interval> intervals=new ArrayList<>();
        int a=0, c=0, q=0;
        a=graphic.getX().get(0);
        int number=0;
        for(int i=1; i<graphic.getX().size(); i++){
            if(i==graphic.getX().size()-1){
                c=graphic.getX().get(i);
                addInterval(intervals,a,c, number);
            }
            else if(((graphic.getY().get(i + 1) < graphic.getY().get(i))&&(graphic.getY().get(i - 1) < graphic.getY().get(i))))
                q=1;
            else if(((graphic.getY().get(i + 1) > graphic.getY().get(i))&&(graphic.getY().get(i - 1) > graphic.getY().get(i))))
                q=1;
            if(q==1){
                c = graphic.getX().get(i);
                addInterval(intervals, a, c, number);
                a = graphic.getX().get(i);
                number++;
                q=0;
            }
        }
        return intervals;
    }
    private boolean findIntervalsInIntervalBool(ArrayList<Interval> intervals, Interval interval, int l){
        int k;
        for(k=0; interval.getX2()>=intervals.get(k).getX2(); k++){
            if(k==intervals.size()-1 && interval.getX2()>=intervals.get(k).getX2())
                break;
        }
        if((interval.getX2()-(intervals.get(k-1).getX2()+l))>(intervals.get(k).getX2()+l)-interval.getX2())
            return false;
        else
            return true;
    }
    private int findIntervalsInInterval(ArrayList<Interval> intervals, Interval interval, int l){
        int k;
        for(k=0; interval.getX2()>=intervals.get(k).getX2(); k++){
            if(k==intervals.size()-1 && interval.getX2()>=intervals.get(k).getX2())
                break;
        }
        if((interval.getX2()-(intervals.get(k-1).getX2()+l))>(intervals.get(k).getX2()+l)-interval.getX2()) {
            return k;
        }
        else {
            return k - 1;
        }
    }
    private int addElementsIntervalGood(Graphic first, Graphic second, int l, int k, Interval firstInterval, Interval secondInterval, Graphic anotherFirst, Graphic anotherSecond){
        int d;
        addElements(first, firstInterval, anotherFirst, l, 0);
        addElements(second, secondInterval, anotherSecond, k, 0);
        int q = shift(second, secondInterval, anotherSecond, k, (int) (firstInterval.lengthOfInterval() - secondInterval.lengthOfInterval()), true);
        d = (int) (firstInterval.lengthOfInterval() - secondInterval.lengthOfInterval())+q;
        return d;
    }
    private int addElementsIntervalBad(Graphic first, Graphic second, int l, int k, Interval firstInterval, Interval secondInterval, Graphic anotherFirst, Graphic anotherSecond, boolean b){
        addElements(first, firstInterval, anotherFirst, l, 0);
        int q;
            q = shift(second, secondInterval, anotherSecond, k, (int) (firstInterval.lengthOfInterval()), b);
            addElements(second, secondInterval, anotherSecond, k, q);
        return q;
    }
    private int insertionPointsToFillInterval(Graphic first, Interval firstInterval, Graphic anotherFirst, Graphic second, Interval secondInterval, int k, int l){
        int w=findX2AtGraphic2(first, firstInterval);
        int q=findX2AtGraphic2(first, firstInterval);
        int h=findX2AtGraphic2(second, secondInterval);
        int m=l;
        //m=l+1 m<=h-q+k
        for( m=l; m<=h-q+k-1; m++){
            anotherFirst.getX().add(first.getX().get(q-1)+m+1);
            anotherFirst.getY().add(first.getY().get(w-1));
        }
        return m;
    }
    private void addLastPoint(int i, int j, int sizeMin, int sizeMax, Graphic first, Graphic second, Graphic anotherFirst, Graphic anotherSecond, int l, int k){
        if(i==sizeMin-1){
            anotherFirst.getX().add(first.getX().get(first.getX().size()-1)+l);
            anotherFirst.getY().add(first.getY().get(first.getY().size()-1));
        }
        if(j==sizeMax-1){
            anotherSecond.getX().add(second.getX().get(second.getX().size()-1)+k);
            anotherSecond.getY().add(second.getY().get(second.getY().size()-1));
        }
    }

    private int simpleShift(Graphic anotherFirst, Graphic anotherSecond, Graphic first, Graphic second, int l, int k, Interval firstInterval, Interval secondInterval){
        int d=0;
        shift(second, secondInterval, anotherSecond, k, anotherFirst.getX().size() - anotherSecond.getX().size(), true);
        d= anotherFirst.getX().size() - anotherSecond.getX().size();
        return d;
    }

    private void buildGraphic(int sizeMin, int sizeMax, ArrayList<Interval> firstInterval, ArrayList<Interval> secondInterval, Graphic first, Graphic second, Graphic anotherFirst, Graphic anotherSecond){
        int k=0, l=0, j=0;
        boolean b=true;
        for(int i=0; i<sizeMin; i++){
            boolean entry=false;
            if(j<=sizeMax-1) {
                if (firstInterval.get(i).increaseAndDecrease(first) != secondInterval.get(j).increaseAndDecrease(second)) {
                    if (firstInterval.get(i).lengthOfInterval() > secondInterval.get(j).lengthOfInterval()) {
                        if ((int) firstInterval.get(i).lengthOfInterval() - secondInterval.get(j).lengthOfInterval() < 5) {
                            if ((int) secondInterval.get(j).lengthOfInterval() < 5) {
                                if (secondInterval.get(j).lengthOfInterval() / firstInterval.get(i).lengthOfInterval() < 0.5) {
                                    l += addElementsIntervalBad(second, first, k, l, secondInterval.get(j), firstInterval.get(i), anotherSecond, anotherFirst, false);
                                    j++;
                                    if (j <= sizeMax - 1) {
                                        addElements(second, secondInterval.get(j), anotherSecond, k, 0);
                                    }
                                    else if(j==sizeMax)
                                        j--;
                                } else {
                                    k += addElementsIntervalGood(first, second, l, k, firstInterval.get(i), secondInterval.get(j), anotherFirst, anotherSecond);
                                }
                            } else {
                                k += addElementsIntervalGood(first, second, l, k, firstInterval.get(i), secondInterval.get(j), anotherFirst, anotherSecond);
                            }
                        } else {
                            addElements(first, firstInterval.get(i), anotherFirst, l, 0);
                            while (((j < findIntervalsInInterval(secondInterval, firstInterval.get(i), k) + 1) || (anotherFirst.getX().get(anotherFirst.getX().size() - 1) - anotherSecond.getX().get(anotherSecond.getX().size() - 1) > 5)) && j < sizeMax) {
                                addElements(second, secondInterval.get(j), anotherSecond, k, 0);
                                if (anotherSecond.getX().get(anotherSecond.getX().size() - 1) - anotherFirst.getX().get(anotherFirst.getX().size() - 1) > 5) {
                                    i++;
                                    while ((anotherSecond.getX().get(anotherSecond.getX().size() - 1) - anotherFirst.getX().get(anotherFirst.getX().size() - 1) > 5)&&i<sizeMin) {
                                        addElements(first, firstInterval.get(i), anotherFirst, l, 0);
                                        i++;
                                    }
                                    i--;
                                }
                                j++;
                            }
                                if (anotherSecond.getX().get(anotherSecond.getX().size() - 1) < anotherFirst.getX().get(anotherFirst.getX().size() - 1)) {
                                    shift(second, secondInterval.get(j - 1), anotherSecond, k, Math.abs(firstInterval.get(i).getX2() + l - (secondInterval.get(j - 1).getX2() + k)), true);
                                    k += Math.abs(firstInterval.get(i).getX2() + l - (secondInterval.get(j - 1).getX2() + k));
                                } else {
                                    shift(first, firstInterval.get(i), anotherFirst, l, Math.abs(secondInterval.get(j - 1).getX2() + k - (firstInterval.get(i).getX2() + l)), true);
                                    l += Math.abs(secondInterval.get(j - 1).getX2() + k - (firstInterval.get(i).getX2() + l));
                                }
                                j--;
                        }
                    } else if (firstInterval.get(i).lengthOfInterval() < secondInterval.get(j).lengthOfInterval()) {
                        if ((int) secondInterval.get(j).lengthOfInterval() - firstInterval.get(i).lengthOfInterval() < 5) {
                            if ((int) firstInterval.get(i).lengthOfInterval() < 5) {
                                if (firstInterval.get(i).lengthOfInterval() / secondInterval.get(j).lengthOfInterval() < 0.5) {
                                    k += addElementsIntervalBad(first, second, l, k, firstInterval.get(i), secondInterval.get(j), anotherFirst, anotherSecond, false);
                                    i++;
                                    if (i <= sizeMin - 1) {
                                        addElements(first, firstInterval.get(i), anotherFirst, l, 0);
                                    }
                                    else if(i==sizeMin)
                                        i--;
                                } else {
                                    l += addElementsIntervalGood(second, first, k, l, secondInterval.get(j), firstInterval.get(i), anotherSecond, anotherFirst);
                                }
                            } else {
                                l += addElementsIntervalGood(second, first, k, l, secondInterval.get(j), firstInterval.get(i), anotherSecond, anotherFirst);
                            }
                        } else {
                            addElements(second, secondInterval.get(j), anotherSecond, k, 0);
                            while (((i < findIntervalsInInterval(firstInterval, secondInterval.get(j), l) + 1) || (anotherSecond.getX().get(anotherSecond.getX().size() - 1) - anotherFirst.getX().get(anotherFirst.getX().size() - 1) > 5)) && i < sizeMin) {
                                addElements(first, firstInterval.get(i), anotherFirst, l, 0);
                                if (anotherFirst.getX().get(anotherFirst.getX().size() - 1) - anotherSecond.getX().get(anotherSecond.getX().size() - 1) > 5) {
                                    j++;
                                    while ((anotherFirst.getX().get(anotherFirst.getX().size() - 1) - anotherSecond.getX().get(anotherSecond.getX().size() - 1) > 5)&&j<sizeMax) {
                                        addElements(second, secondInterval.get(j), anotherSecond, k, 0);
                                        j++;
                                    }
                                    j--;
                                }
                                i++;
                            }
                                if (anotherSecond.getX().get(anotherSecond.getX().size() - 1) > anotherFirst.getX().get(anotherFirst.getX().size() - 1)) {
                                    shift(first, firstInterval.get(i - 1), anotherFirst, l, Math.abs(secondInterval.get(j).getX2() + k - (firstInterval.get(i - 1).getX2() + l)), true);
                                    l += Math.abs(secondInterval.get(j).getX2() + k - (firstInterval.get(i - 1).getX2() + l));
                                } else {
                                    shift(second, secondInterval.get(j), anotherSecond, k, Math.abs(firstInterval.get(i - 1).getX2() + l - (secondInterval.get(j).getX2() + k)), true);
                                    k += Math.abs(firstInterval.get(i - 1).getX2() + l - (secondInterval.get(j).getX2() + k));
                                }
                                i--;
                        }
                    } else {
                        if (secondInterval.get(j).lengthOfInterval() < 5) {
                            k += addElementsIntervalGood(first, second, l, k, firstInterval.get(i), secondInterval.get(j), anotherFirst, anotherSecond);
                        } else {
                            addElements(second, secondInterval.get(j), anotherSecond, k, 0);
                            addElements(first, firstInterval.get(i), anotherFirst, l, 0);
                        }
                    }
                } else {
                    if (firstInterval.get(i).lengthOfInterval() > secondInterval.get(j).lengthOfInterval()) {
                        if ((int) firstInterval.get(i).lengthOfInterval() - secondInterval.get(j).lengthOfInterval() < 5) {
                            k += addElementsIntervalGood(first, second, l, k, firstInterval.get(i), secondInterval.get(j), anotherFirst, anotherSecond);
                        } else {
                            addElements(first, firstInterval.get(i), anotherFirst, l, 0);
                            while (((j < findIntervalsInInterval(secondInterval, firstInterval.get(i), k) + 1) || (anotherFirst.getX().get(anotherFirst.getX().size() - 1) - anotherSecond.getX().get(anotherSecond.getX().size() - 1) > 5)) && j < sizeMax) {
                                addElements(second, secondInterval.get(j), anotherSecond, k, 0);
                                if (anotherSecond.getX().get(anotherSecond.getX().size() - 1) - anotherFirst.getX().get(anotherFirst.getX().size() - 1) > 5) {
                                    i++;
                                    while ((anotherSecond.getX().get(anotherSecond.getX().size() - 1) - anotherFirst.getX().get(anotherFirst.getX().size() - 1) > 5)&&i<sizeMin) {
                                        addElements(first, firstInterval.get(i), anotherFirst, l, 0);
                                        i++;
                                    }
                                    i--;
                                }
                                j++;
                            }
                                if (anotherSecond.getX().get(anotherSecond.getX().size() - 1) < anotherFirst.getX().get(anotherFirst.getX().size() - 1)) {
                                    shift(second, secondInterval.get(j - 1), anotherSecond, k, Math.abs(firstInterval.get(i).getX2() + l - (secondInterval.get(j - 1).getX2() + k)), true);
                                    k += Math.abs(firstInterval.get(i).getX2() + l - (secondInterval.get(j - 1).getX2() + k));
                                } else {
                                    shift(first, firstInterval.get(i), anotherFirst, l, Math.abs(secondInterval.get(j - 1).getX2() + k - (firstInterval.get(i).getX2() + l)), true);
                                    l += Math.abs(secondInterval.get(j - 1).getX2() + k - (firstInterval.get(i).getX2() + l));
                                }
                                j--;
                        }
                    } else if (secondInterval.get(j).lengthOfInterval() > firstInterval.get(i).lengthOfInterval()) {
                        if ((int) secondInterval.get(j).lengthOfInterval() - firstInterval.get(i).lengthOfInterval() < 5) {
                            l += addElementsIntervalGood(second, first, k, l, secondInterval.get(j), firstInterval.get(i), anotherSecond, anotherFirst);
                        } else {
                            addElements(second, secondInterval.get(j), anotherSecond, k, 0);
                            while (((i < findIntervalsInInterval(firstInterval, secondInterval.get(j), l) + 1) || (anotherSecond.getX().get(anotherSecond.getX().size() - 1) - anotherFirst.getX().get(anotherFirst.getX().size() - 1) > 5)) && i < sizeMin) {
                                addElements(first, firstInterval.get(i), anotherFirst, l, 0);
                                if (anotherFirst.getX().get(anotherFirst.getX().size() - 1) - anotherSecond.getX().get(anotherSecond.getX().size() - 1) > 5) {
                                    j++;
                                    while ((anotherFirst.getX().get(anotherFirst.getX().size() - 1) - anotherSecond.getX().get(anotherSecond.getX().size() - 1) > 5)&&j<sizeMax) {
                                        addElements(second, secondInterval.get(j), anotherSecond, k, 0);
                                        j++;
                                    }
                                    j--;
                                }
                                i++;
                            }
                                if (anotherSecond.getX().get(anotherSecond.getX().size() - 1) > anotherFirst.getX().get(anotherFirst.getX().size() - 1)) {
                                    shift(first, firstInterval.get(i - 1), anotherFirst, l, Math.abs(secondInterval.get(j).getX2() + k - (firstInterval.get(i - 1).getX2() + l)), true);
                                    l += Math.abs(secondInterval.get(j).getX2() + k - (firstInterval.get(i - 1).getX2() + l));
                                } else {
                                    shift(second, secondInterval.get(j), anotherSecond, k, Math.abs(firstInterval.get(i - 1).getX2() + l - (secondInterval.get(j).getX2() + k)), true);
                                    k += Math.abs(firstInterval.get(i - 1).getX2() + l - (secondInterval.get(j).getX2() + k));
                                }
                                i--;
                        }
                    } else {
                        addElements(second, secondInterval.get(j), anotherSecond, k, 0);
                        addElements(first, firstInterval.get(i), anotherFirst, l, 0);
                    }
                }
                addLastPoint(i,j,sizeMin,sizeMax,first, second, anotherFirst, anotherSecond, l, k);
                if(i==sizeMin-1&&j==sizeMax-1) {
                    if (anotherFirst.getX().size() > anotherSecond.getX().size())
                        insertionPointsToFillInterval(second, secondInterval.get(j), anotherSecond, first, firstInterval.get(i),l+1,k+1);
                    else if (anotherFirst.getX().size() < anotherSecond.getX().size())
                        insertionPointsToFillInterval(first, firstInterval.get(i), anotherFirst, second, secondInterval.get(j),k+1,l+1);
                }
                if(i<sizeMin-1&&j<sizeMax-1||i<sizeMin-1&&j==sizeMax-1) {
                    if (anotherFirst.getX().size() > anotherSecond.getX().size())
                        k = insertionPointsToFillInterval(second, secondInterval.get(j), anotherSecond, first, firstInterval.get(i), l, k);
                    else if (anotherFirst.getX().size() < anotherSecond.getX().size())
                        l = insertionPointsToFillInterval(first, firstInterval.get(i), anotherFirst, second, secondInterval.get(j), k, l);
                }
                if(i==sizeMin&&j<=sizeMax-1)
                    break;

            }
            if(i<=sizeMin-1&&j==sizeMax){
                addElements(first, firstInterval.get(i), anotherFirst, l, 0);
                if(i==sizeMin-1&&j==sizeMax){
                    anotherFirst.getX().add(first.getX().get(first.getX().size()-1)+l);
                    anotherFirst.getY().add(first.getY().get(first.getY().size()-1));
                    if (anotherFirst.getX().size() > anotherSecond.getX().size())
                        insertionPointsToFillInterval(second, secondInterval.get(j-1), anotherSecond, first, firstInterval.get(i),l+1,k+1);
                    else if (anotherFirst.getX().size() < anotherSecond.getX().size())
                        insertionPointsToFillInterval(first, firstInterval.get(i), anotherFirst, second, secondInterval.get(j-1),k+1,l+1);
                }
                j--;
            }
            j++;
        }
        while(j<=sizeMax-1){
            addElements(second, secondInterval.get(j), anotherSecond, k, 0);
            if(j==sizeMax-1) {
                anotherSecond.getX().add(second.getX().get(second.getX().size() - 1) + k);
                anotherSecond.getY().add(second.getY().get(second.getY().size() - 1));
                if (anotherFirst.getX().size() > anotherSecond.getX().size())
                    insertionPointsToFillInterval(second, secondInterval.get(j), anotherSecond, first, firstInterval.get(sizeMin - 1),l+1,k+1);
                else if (anotherFirst.getX().size() < anotherSecond.getX().size())
                    insertionPointsToFillInterval(first, firstInterval.get(sizeMin - 1), anotherFirst, second, secondInterval.get(j),k+1,l+1);
            }
            j++;
        }
    }

    private void shiftGraphics(Graphic first, Graphic second){
        ArrayList<Interval> firstInterval=part(first), secondInterval=part(second);
        anotherFirst=new Graphic();
        anotherSecond=new Graphic();
        int sizeMin, sizeMax;
        if(firstInterval.size()<=secondInterval.size()) {
            sizeMin = firstInterval.size();
            sizeMax=secondInterval.size();
            buildGraphic(sizeMin, sizeMax, firstInterval,secondInterval,first,second, anotherFirst, anotherSecond);
        }
        else {
            sizeMin = secondInterval.size();
            sizeMax=firstInterval.size();
            buildGraphic(sizeMin, sizeMax, secondInterval,firstInterval,second,first,anotherSecond,anotherFirst);
        }
    }
    private void addInterval(ArrayList<Interval> intervals, int a, int c, int number){
        Interval interval = new Interval();
        interval.setX1(a);
        interval.setX2(c);
        interval.setNumber(number);
        intervals.add(interval);
    }

    public void secondCharacterization(Graphic first, Graphic second) {
        Partition partition = new Partition(first, second);
        double[] firstcharact = partition.firstCharacterization();
        Partition partition1 = new Partition(anotherFirst, anotherSecond);
        double[] firstcharact1=partition1.firstCharacterization();
        for (int i = 0; i < 2; i++) {
            if (i == 0)
                System.out.println("Measurement of similarity");
            else
                System.out.println("Measurement of difference");

            System.out.println("beforeShift first characterization= " + firstcharact[i]);
            if (i == 0) {
                System.out.println("beforeShiftRate + growthRate= " + growthRates(partition.getGoodIntervals(), first, second, partition.getBadIntervals()));
                System.out.println("beforeShiftAcceleration + growthAcceleration= " +  growthAcceleration(partition.getGoodIntervals(), first, second, partition.getBadIntervals()));
            }

            System.out.println("simple first characterization after shift= " + firstcharact1[i]);
            if (i == 0) {
                System.out.println("after shift + growthRate = " +  growthRates(partition1.getGoodIntervals(), anotherFirst, anotherSecond, partition.getBadIntervals()));
                System.out.println("after shift + growthAcceleration = " + growthAcceleration(partition1.getGoodIntervals(), anotherFirst, anotherSecond, partition.getBadIntervals()));
            }

            System.out.println();
        }
    }
    private int findX1AtGraphic(Graphic graphic, int j, ArrayList<Interval> interval){
        int k;
        for(k=0; interval.get(j).getX1()!=graphic.getX().get(k); k++);
        return k;
    }
    private Vector<Double> computingDerivation(Graphic graphic){
        Vector<Double> derivativeFunction=new Vector<>();
        for(int i=0; i<graphic.getY().size()-1; i++){
            derivativeFunction.add((graphic.getY().get(i + 1) - graphic.getY().get(i)) / (graphic.getX().get(i + 1) - graphic.getX().get(i)));
        }
        return derivativeFunction;
    }
    private ArrayList<Double> sumDerivation(ArrayList<Interval> interval, Graphic graphic, int k){
        ArrayList<Double> sumDerivation=new ArrayList<>();
        int i;
        for(int j=0; j<interval.size(); j++) {
            double sum=0;
            for (i = findX1AtGraphic(graphic,j, interval); (interval.get(j).getX2() != graphic.getX().get(i))&&(i<=graphic.getX().size()-k); i++)
                sum += graphic.getY().get(i);
            if(i==graphic.getX().size()-k)
                sum += graphic.getY().get(i);
            sumDerivation.add(sum);
        }
        return sumDerivation;
    }
    private ArrayList<Double> derivation(Graphic graphic, boolean b, ArrayList<Interval> interval){
        ArrayList<Double> sumDerivation;
        Graphic firstDerivativeFunc=new Graphic (graphic.getX(), computingDerivation(graphic));
        Graphic secondDerivativeFunc=new Graphic(firstDerivativeFunc.getX(), computingDerivation(firstDerivativeFunc));
        if(b) {
            //firstDerivativeFunc.getX().remove(firstDerivativeFunc.getX().size()-1);
            sumDerivation = sumDerivation(interval, firstDerivativeFunc, 2);
        }
        else {
            //secondDerivativeFunc.getX().remove(secondDerivativeFunc.getX().size() - 1);
            sumDerivation = sumDerivation(interval, secondDerivativeFunc, 3);
        }
        return sumDerivation;
    }
    private double comparing(ArrayList<Double> growthList, ArrayList<Double> growthAcceleration, ArrayList<Interval> intervals,ArrayList<Interval> badIntervals){

        double sum=0, first=0;
        for (int i=0; i<intervals.size(); i++) {
            if(growthAcceleration==null) {
                if (growthList.get(i) >= 1) {
                    sum += intervals.get(i).getPart() / growthList.get(i);
                    first += intervals.get(i).getPart() / growthList.get(i);
                } else {
                    sum += intervals.get(i).getPart() * growthList.get(i);
                    first += intervals.get(i).getPart() * growthList.get(i);
                }
            }
            else{
                if(growthAcceleration.get(i)>=1) {
                    if (growthList.get(i) >= 1) {
                        sum += intervals.get(i).getPart() / (growthList.get(i)*growthAcceleration.get(i));
                        first += intervals.get(i).getPart() / (growthList.get(i)*growthAcceleration.get(i));
                    } else {
                        sum += intervals.get(i).getPart() * growthList.get(i)/growthAcceleration.get(i);
                        first += intervals.get(i).getPart() * growthList.get(i)/growthAcceleration.get(i);
                    }
                }
                else{
                    if (growthList.get(i) >= 1) {
                        sum += intervals.get(i).getPart() *growthAcceleration.get(i) / growthList.get(i);
                        first += intervals.get(i).getPart() *growthAcceleration.get(i) / growthList.get(i);
                    } else {
                        sum += intervals.get(i).getPart() * growthList.get(i)*growthAcceleration.get(i);
                        first += intervals.get(i).getPart() * growthList.get(i)*growthAcceleration.get(i);
                    }
                }
            }

        }
        for(int i=0; i<badIntervals.size(); i++)
            sum+=badIntervals.get(i).getPart();
        return first/sum;
    }

    private  ArrayList<Double> derivation ( ArrayList<Interval> intervals, Graphic first, Graphic second){
        ArrayList<Double> firstDer=derivation(first, true, intervals);//true==first derivation, false==second derivation
        ArrayList<Double> secondDer=derivation(second,true, intervals);
        ArrayList<Double> growthRates=new ArrayList<>();
        for(int i=0; i<firstDer.size(); i++) {
            if(secondDer.get(i)!=0)
                growthRates.add(Math.abs(firstDer.get(i) / secondDer.get(i)));
            else
                growthRates.add(0.0);//значит совсем различные участки
        }
        return growthRates;
    }
    private double growthRates( ArrayList<Interval> intervals, Graphic first, Graphic second, ArrayList<Interval> badIntervals){
        ArrayList<Double> growthRates=derivation(intervals,first,second);
        return comparing(growthRates,null,  intervals, badIntervals);
    }

    private double growthAcceleration( ArrayList<Interval> intervals, Graphic first, Graphic second, ArrayList<Interval> badIntervals){
        ArrayList<Double> growthRates=derivation(intervals,first,second);
        ArrayList<Double> firstSecondDer=derivation(first,false, intervals);
        ArrayList<Double> secondSecondDer=derivation(second, false, intervals);
        ArrayList<Double> growthAcceleration=new ArrayList<>();
        for(int i=0; i<firstSecondDer.size(); i++) {
            if(secondSecondDer.get(i)!=0)
                growthAcceleration.add(Math.abs(firstSecondDer.get(i) / secondSecondDer.get(i)));
            else
                growthAcceleration.add(0.0);
        }
        return comparing(growthRates,growthAcceleration, intervals, badIntervals);
    }
}
