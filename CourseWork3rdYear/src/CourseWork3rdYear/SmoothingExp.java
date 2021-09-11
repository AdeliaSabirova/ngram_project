package CourseWork3rdYear;


/**
 * Created by Аделя on 03.05.2017.
 */
public class SmoothingExp {
    private Graphic first;
    private Graphic second;

    public Graphic getFirst() {return first;}
    public Graphic getSecond() {return second;}
    public void setFirst(Graphic first) {this.first = first;}
    public void setSecond(Graphic second) {this.second = second;}
    public SmoothingExp(Graphic first, Graphic second, double alf){
        this.first=new Graphic();
        this.second=new Graphic();
        this.first.setX(first.getX());
        this.second.setX(second.getX());
        for(int i=0; i<second.getY().size(); i++){
            if(i==0) {
                this.second.getY().add(second.getY().get(i));
                this.first.getY().add(first.getY().get(i));
            }
            else {
                this.second.getY().add(this.second.getY().get(i - 1) + alf * (second.getY().get(i) - this.second.getY().get(i - 1)));
                this.first.getY().add(this.first.getY().get(i-1)+alf * (first.getY().get(i) - this.first.getY().get(i - 1)));
            }
        }
    }
    public void First(){
        Partition partition=new Partition(this.first, this.second);
        partition.firstCharacterization();
    }

    public void Second(){
        SecondCharact secondCharact=new SecondCharact(this.first, this.second);
        secondCharact.secondCharacterization(first, second);
    }

}
