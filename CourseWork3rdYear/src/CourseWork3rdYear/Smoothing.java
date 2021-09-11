package CourseWork3rdYear;

import java.util.ArrayList;

/**
 * Created by Аделя on 03.05.2017.
 */
public class Smoothing {
    private Graphic first;
    private Graphic second;

    public Graphic getFirst() {
        return first;
    }

    public Graphic getSecond() {
        return second;
    }

    public void setFirst(Graphic first) {
        this.first = first;
    }

    public void setSecond(Graphic second) {
        this.second = second;
    }

    public Smoothing(Graphic first, Graphic second, int n) {
        this.first = new Graphic();
        this.second = new Graphic();
        for (int i = 0; i < first.getY().size()-n+1; i++) {
            this.second.getX().add(second.getX().get(i));
            this.first.getX().add(first.getX().get(i));
        }
        for (int i = 0; i < second.getY().size()-n+1; i++) {
            this.second.getY().add(smoothing(second, i, n));
            this.first.getY().add(smoothing(first, i, n));
        }
    }

    public Smoothing() {
    }

    private double smoothing(Graphic graphic, int t, int n) {
        double sum = 0;
        if (graphic.getY().size() >= t + n) {
            for (int i = t; i < n + t; i++)
                sum += graphic.getY().get(i);
        }
        return sum / n;
    }

    public void First() {
        Partition partition = new Partition(this.first, this.second);
        System.out.println("firstCharacterization= " + partition.firstCharacterization());
    }

    public void Second() {
        SecondCharact secondCharact = new SecondCharact(first, second);
        secondCharact.secondCharacterization(first, second);
    }
}