package CourseWork3rdYear;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by Аделя on 11.09.2017.
 */
public class Frequency {
    private List<Double> TotalList;
    private Graphic FirstWord;
    private Graphic SecondWord;

    Frequency(String fileName1, String fileName2) throws FileNotFoundException{
        String line;
        File file1=new File("C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\test4\\Total.txt");
        Scanner scan1=new Scanner(file1);
        TotalList = new ArrayList<Double>();
        while (scan1.hasNextLine()) {
            line = scan1.nextLine();

            TotalList.add(Double.parseDouble(line.substring(0,findTheEnd(line))));
        }

        FirstWord=ReadFile(fileName1);
        SecondWord=ReadFile(fileName2);
        FirstWord=putExtra(FirstWord);
        SecondWord=putExtra(SecondWord);
        FirstWord=Sort(FirstWord);
        SecondWord=Sort(SecondWord);
    }

    private Graphic Sort(Graphic graphic){
        int year=0;
        double value=0;
        for(int j=0; j<graphic.getX().size()-1; j++) {
            for (int i = 0; i < graphic.getX().size() - j - 1; i++) {
                if (graphic.getX().get(i) < graphic.getX().get(i + 1)) {
                    year = graphic.getX().get(i);
                    value = graphic.getY().get(i);
                    graphic.getX().set(i, graphic.getX().get(i + 1));
                    graphic.getY().set(i, graphic.getY().get(i + 1));
                    graphic.getX().set(i + 1, year);
                    graphic.getY().set(i + 1, value);

                }
            }
        }
        return graphic;
    }

    private Graphic ReadFile(String fileName1)throws FileNotFoundException{
        File file2=new File(fileName1);
        Scanner scan2=new Scanner(file2);
        Graphic word = new Graphic();
        String line;
        while (scan2.hasNextLine()) {
            line=scan2.nextLine();
            if((line.charAt(4)=='\t')&&(Integer.parseInt(line.substring(0,4))>=1920)&&(Integer.parseInt(line.substring(0,4))<=2009)){
                putIfTab(Double.parseDouble(line.substring(5,line.length())),Integer.parseInt(line.substring(0,4)), word);
            }
            else if(line.charAt(4)=='-'){
                int i=Integer.parseInt(line.substring(0,4));
                if (line.charAt(9) == '\t') {
                    double value = Double.parseDouble(line.substring(10, line.length())) / (Integer.parseInt(line.substring(4, 8)) - Integer.parseInt(line.substring(0, 4)) + 1);
                    while ((i <= Integer.parseInt(line.substring(5, 9))) && (i >= 1920) && (i <= 2009)) {
                        putIfTab(value, i, word);
                        i++;
                    }
                }
                else if(line.charAt(9)==' '&&line.charAt(10)=='|') {
                    double value = Double.parseDouble(line.substring(16, line.length())) / (Integer.parseInt(line.substring(4, 8)) - Integer.parseInt(line.substring(0, 4))+2);
                    while ((i <= Integer.parseInt(line.substring(5, 9))) && (i >= 1920) && (i <= 2009)) {
                        putIfTab(value, i, word);
                        i++;
                    }
                    if ((i >= 1920) && (i <= 2009)) {
                        putIfTab(value,Integer.parseInt(line.substring(12,16)), word);
                    }
                }

            }
            else if((line.charAt(4)==' '&&line.charAt(5)=='|')){
                double value=Double.parseDouble(line.substring(12,line.length()))/(2);
                if ((Integer.parseInt(line.substring(0,4))>=1920)&&(Integer.parseInt(line.substring(0,4))<=2009))
                    putIfTab(value,Integer.parseInt(line.substring(0,4)),word);
                if ((Integer.parseInt(line.substring(7,11))>=1920)&&(Integer.parseInt(line.substring(7,11))<=2009))
                    putIfTab(value,Integer.parseInt(line.substring(7,11)),word);
            }
        }
        return word;
    }

    public Graphic Frequency(boolean b){
        Graphic newGraphic=new Graphic();
        for(int i=FirstWord.getX().size()-1; i>=0; i--){
            newGraphic.getX().add(FirstWord.getX().get(i));
        }
        for(int i=FirstWord.getY().size()-1; i>=0; i--)
            if(b)
                newGraphic.getY().add(FirstWord.getY().get(i)/TotalList.get(i));
            else
                newGraphic.getY().add(SecondWord.getY().get(i)/TotalList.get(i));
        return newGraphic;
    }

    private Graphic putExtra(Graphic graphic){
        for(int i=1920; i<2010; i++){
            if(!contains(graphic.getX(),i)){
                graphic.getX().add(i);
                graphic.getY().add(0.0);
            }
        }
        return graphic;
    }

    private void putIfTab( double value, int year, Graphic FirstWord){
        if (!contains(FirstWord.getX(), year)) {
            FirstWord.getX().add(year);
            FirstWord.getY().add(value);
        } else {
            double temp;
            int j = findYear(String.valueOf(year), FirstWord.getX());
            temp = value + FirstWord.getY().get(j);
            FirstWord.getY().set(j, temp);
        }
    }

    private int findYear(String word, Vector year){
        int i=0;
        while(!year.get(i).equals(Integer.parseInt(word)))
            i++;
        return i;
    }

    private int findTheEnd(String word){
        int i=0;
        while(word.charAt(i)!='\t')
            i++;
        return i;
    }

    private boolean contains(Vector years, int year){
        for(int i=0; i<years.size(); i++)
            if(years.get(i).equals(year))
                return true;
        return false;
    }

}
