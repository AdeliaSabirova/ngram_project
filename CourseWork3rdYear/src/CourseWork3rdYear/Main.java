package CourseWork3rdYear;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

/**
 * Created by Аделя on 12.02.2017.
 */

public class Main {

    private static int findTheEnd(String word){
        int i=0;
        while(word.charAt(i)!='\t')
            i++;
        return i;
    }
    public static Graphic setGraphic(String fileName) throws FileNotFoundException {
        File file=new File(fileName);
        Scanner scan=new Scanner(file);
        Vector<Integer> x=new Vector<>();
        Vector<Double> y=new Vector<>();
        while(scan.hasNextLine()){
            String line=scan.nextLine();
            x.add(Integer.parseInt(line.substring(0,4)));
            y.add(Double.parseDouble(line.substring(5,findTheEnd(line))));
        }
        Graphic graphic=new Graphic(x,y);
        return graphic;
    }
    public static Graphic setGraphicSeparate(String fileName1, String fileName2) throws FileNotFoundException{
        File file1=new File(fileName1);
        Scanner scan1=new Scanner(file1);
        File file2=new File(fileName2);
        Scanner scan2=new Scanner(file2);
        Vector<Integer> x=new Vector<>();
        Vector<Double> y=new Vector<>();
        while(scan1.hasNextLine()){
            String line1=scan1.nextLine();
            x.add(Integer.parseInt(line1.substring(0,4)));
        }
        while(scan2.hasNextLine()){
            String line2=scan2.nextLine();
            y.add(Double.parseDouble(line2.substring(0,findTheEnd(line2))));
        }
        return new Graphic(x,y);
    }
    public static void Algorithm(String filename1, String filename2, String filename3) throws FileNotFoundException{
        /*Graphic first=setGraphicSeparate(filename1,filename2);
        Graphic second=setGraphicSeparate(filename1,filename3);*/

        Frequency frequency=new Frequency(filename2, filename3);
        Graphic first=frequency.Frequency(true);
        Graphic second=frequency.Frequency(false);

        SecondCharact test=new SecondCharact(first, second);
        test.secondCharacterization(first, second);
        System.out.println();
        System.out.println();
        System.out.println("Smoothing by average 5");
        Smoothing smoothing2=new Smoothing(first, second, 5);
        smoothing2.Second();
        System.out.println();
        System.out.println();
        System.out.println("Exponential smoothing 0.3");
        SmoothingExp smoothingExp1=new SmoothingExp(first, second, 0.3);
        smoothingExp1.Second();/*
        System.out.println("Smoothing by average 6");
        Smoothing smoothing=new Smoothing(first, second, 6);
        smoothing.Second();
        System.out.println();
        System.out.println();
        System.out.println("Smoothing by average 10");
        Smoothing smoothing2=new Smoothing(first, second, 10);
        smoothing2.Second();
        System.out.println();
        System.out.println();
        System.out.println("Smoothing by average 2");
        Smoothing smoothing3=new Smoothing(first, second, 2);
        smoothing3.Second();
        System.out.println();
        System.out.println();*/
        /*System.out.println("Exponential smoothing 0.2");
        SmoothingExp smoothingExp1=new SmoothingExp(first, second, 0.2);
        smoothingExp1.Second();
        System.out.println("Exponential smoothing 0.022");
        SmoothingExp smoothingExp2=new SmoothingExp(first, second, 0.022);
        smoothingExp2.Second();
        System.out.println("Exponential smoothing 0.1");
        SmoothingExp smoothingExp3=new SmoothingExp(first, second, 0.1);
        smoothingExp3.Second();*/
    }
    public static void main(String[] args) throws FileNotFoundException {
        /*System.out.println("Тест1");
        System.out.println("Делать-сделать");
        Algorithm("C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\totalcounts.txt","C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\test1\\testDO1.txt","C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\test1\\testDO2.txt");
        System.out.println("Копать-выкопать");
        Algorithm("C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\totalcounts.txt","C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\test1\\testDIG1.txt","C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\test1\\testDIG2.txt");
        System.out.println("Просить-попросить");
        Algorithm("C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\totalcounts.txt","C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\test1\\testASK1.txt","C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\test1\\testASK2.txt");
        System.out.println("Нюхать-понюхать");
        Algorithm("C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\totalcounts.txt","C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\test1\\testSMELL1.txt","C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\test1\\testSMELL2.txt");
        System.out.println("Работать-сработать");
        Algorithm("C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\totalcounts.txt","C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\test1\\testWORK1.txt","C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\test1\\testWORK2.txt");
        System.out.println("Мерзнуть-замерзнуть");
        Algorithm("C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\totalcounts.txt","C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\test1\\testFREEZE1.txt","C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\test1\\testFREEZE2.txt");
        System.out.println("Растить-вырастить");
        Algorithm("C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\totalcounts.txt","C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\test1\\testGROW1.txt","C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\test1\\testGROW2.txt");
        System.out.println("Выпросить-выпрашивать");
        Algorithm("C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\totalcounts.txt","C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\test1\\testOBTAIN1.txt","C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\test1\\testOBTAIN2.txt");
        System.out.println("Переработать-перерабатывать");
        Algorithm("C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\totalcounts.txt","C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\test1\\testOVERWORK1.txt","C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\test1\\testOVERWORK2.txt");
        System.out.println("Прятать-спрятать");
        Algorithm("C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\totalcounts.txt","C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\test1\\testHIDE1.txt","C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\test1\\testHIDE2.txt");
        System.out.println("Рисовать-нарисовать");
        Algorithm("C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\totalcounts.txt","C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\test1\\testDRAW1.txt","C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\test1\\testDRAW2.txt");
        System.out.println("Верить-поверить");
        Algorithm("C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\totalcounts.txt","C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\test1\\testBELIEVE1.txt","C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\test1\\testBELIEVE2.txt");
        System.out.println("Казаться-показаться");
        Algorithm("C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\totalcounts.txt","C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\test1\\testSEEM1.txt","C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\test1\\testSEEM2.txt");

        System.out.println("Тест2");
        System.out.println("Играть-сыграть");
        Algorithm("C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\totalcounts.txt","C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\test2\\testPLAY1.txt","C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\test2\\testPLAY2.txt");
        System.out.println("Влечь-повлечь");
        Algorithm("C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\totalcounts.txt","C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\test2\\Attract1.txt","C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\test2\\Attract2.txt");
        System.out.println("Оказаться-оказываться");
        Algorithm("C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\totalcounts.txt","C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\test2\\testHAPPEN1.txt","C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\test2\\testHAPPEN2.txt");
        System.out.println("Проверить-проверять");
        Algorithm("C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\totalcounts.txt","C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\test2\\Verify1.txt","C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\test2\\Verify2.txt");
        System.out.println("Приставить-Приставлять");
        Algorithm("C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\totalcounts.txt","C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\test2\\Set1.txt","C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\test2\\Set2.txt");
        System.out.println("Назвать-Называть");
        Algorithm("C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\totalcounts.txt","C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\test2\\Name1.txt","C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\test2\\Name2.txt");
        System.out.println("Охранить-Охранять");
        Algorithm("C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\totalcounts.txt","C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\test2\\Protect1.txt","C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\test2\\Protect2.txt");
        System.out.println("Срисовать-Срисовывать");
        Algorithm("C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\totalcounts.txt","C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\test2\\Copy1.txt","C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\test2\\Copy2.txt");
        System.out.println("Припрятать-Припрятывать");
        Algorithm("C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\totalcounts.txt","C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\test2\\HideAway1.txt","C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\test2\\HideAway2.txt");
        System.out.println("Привлечь-Привлекать");
        Algorithm("C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\totalcounts.txt","C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\test2\\Allure1.txt","C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\test2\\Allure2.txt");
        System.out.println("Оплевать-Оплевывать");
        Algorithm("C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\totalcounts.txt","C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\test2\\SpitOver1.txt","C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\test2\\SpitOver2.txt");
        System.out.println("Зажечь-зажигать");
        Algorithm("C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\totalcounts.txt","C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\test2\\Light1.txt","C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\test2\\Light2.txt");
        System.out.println("Отрастить-отращивать");
        Algorithm("C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\totalcounts.txt","C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\test2\\Sprout1.txt","C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\test2\\Sprout2.txt");
        System.out.println("Промерзнуть-промерзать");
        Algorithm("C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\totalcounts.txt","C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\test2\\Chilled1.txt","C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\test2\\Chilled2.txt");
        System.out.println("Раскопать-раскапывать");
        Algorithm("C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\totalcounts.txt","C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\test2\\DigOut1.txt","C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\test2\\DigOut2.txt");
        System.out.println("Вынюхать-вынюхивать");
        Algorithm("C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\totalcounts.txt","C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\test2\\SniffUp1.txt","C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\test2\\SniffUp2.txt");
        System.out.println("Обокрасть-обкрадывать");
        Algorithm("C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\totalcounts.txt","C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\test2\\Rob1.txt","C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\test2\\Rob2.txt");
        System.out.println("Нащупать-нащупывать");
        Algorithm("C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\totalcounts.txt","C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\test2\\Fumble1.txt","C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\test2\\Fumble2.txt");
        System.out.println("Переделать-переделывать");
        Algorithm("C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\totalcounts.txt","C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\test2\\Redo1.txt","C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\test2\\Redo2.txt");

        System.out.println("Тест3");
        System.out.println("Плевать-Наплевать");
        Algorithm("C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\totalcounts.txt","C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\test\\Spit1.txt","C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\test7865\\Spit2.txt");
        System.out.println("Звонить-позвонить");
        Algorithm("C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\totalcounts.txt","C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\test\\Call1.txt","C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\test8315\\Call2.txt");
        System.out.println("Перезвонить-Перезванивать");1685
        Algorithm("C:\\Users\\Аделя\\IdeaProjects\\CourseWork37rdYear\\src\\CourseWork3rdYear\\totalcounts.txt","C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\test2\\testHAPPEN1.txt","C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\test2\\testHAPPEN2.txt");
        System.out.println("Выиграть-выигрывать");
        Algorithm("C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\totalcounts.txt","C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\test\\Win1.txt","C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\test\\Win2.txt");
        System.out.println("Приставить-Приставлять");
        Algorithm("C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\totalcounts.txt","C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\test2\\Set1.txt","C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\test2\\Set2.txt");
        System.out.println("Назвать-Называть");
        Algorithm("C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\totalcounts.txt","C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\test2\\Name1.txt","C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\test2\\Name2.txt");
*/

        System.out.println("Тест 4");
        /*System.out.println("Красивый-прекрасный");
        Algorithm("C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\totalcounts.txt", "C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\Coursework3rdYear\\test4\\Beautiful1.txt","C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\Coursework3rdYear\\test4\\Beautiful2.txt");
        System.out.println("Красивый-привлекательный");
        Algorithm("C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\totalcounts.txt", "C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\Coursework3rdYear\\test4\\Beautiful1.txt","C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\Coursework3rdYear\\test4\\Beautiful3.txt");
        System.out.println("Красивый-великолепный");
        Algorithm("C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\totalcounts.txt", "C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\Coursework3rdYear\\test4\\Beautiful1.txt","C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\Coursework3rdYear\\test4\\Beautiful4.txt");
        System.out.println("Грустный-печальный");
        Algorithm("C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\totalcounts.txt", "C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\Coursework3rdYear\\test4\\Sad1.txt","C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\Coursework3rdYear\\test4\\Sad2.txt");
        System.out.println("Грустный-унылый");
        Algorithm("C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\totalcounts.txt", "C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\Coursework3rdYear\\test4\\Sad1.txt","C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\Coursework3rdYear\\test4\\Sad3.txt");
        System.out.println("Грустный-невеселый");
        Algorithm("C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\totalcounts.txt", "C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\Coursework3rdYear\\test4\\Sad1.txt","C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\Coursework3rdYear\\test4\\Sad4.txt");
        System.out.println("Зеленый-юный");
        Algorithm("C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\totalcounts.txt", "C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\Coursework3rdYear\\test4\\Green1.txt","C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\Coursework3rdYear\\test4\\Green2.txt");
        System.out.println("Зеленый-ранний");
        Algorithm("C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\totalcounts.txt", "C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\Coursework3rdYear\\test4\\Green1.txt","C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\Coursework3rdYear\\test4\\Green3.txt");
        System.out.println("Зеленый-изумрудный");
        Algorithm("C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\totalcounts.txt", "C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\Coursework3rdYear\\test4\\Green1.txt","C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\Coursework3rdYear\\test4\\Green4.txt");
        System.out.println("Зеленый-зрелый");
        Algorithm("C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\totalcounts.txt", "C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\Coursework3rdYear\\test4\\Green1.txt","C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\Coursework3rdYear\\test4\\GreenOpposite1.txt");
        System.out.println("Зеленый-опытный");
        Algorithm("C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\totalcounts.txt", "C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\Coursework3rdYear\\test4\\Green1.txt","C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\Coursework3rdYear\\test4\\GreenOpposite2.txt");
        System.out.println("Зеленый-красный");
        Algorithm("C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\totalcounts.txt", "C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\Coursework3rdYear\\test4\\Green1.txt","C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\Coursework3rdYear\\test4\\GreenOpposite3.txt");
        System.out.println("Грустный-веселый");
        Algorithm("C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\totalcounts.txt", "C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\Coursework3rdYear\\test4\\Sad1.txt","C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\Coursework3rdYear\\test4\\SadOpposite1.txt");
        System.out.println("Грустный-радостный");
        Algorithm("C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\totalcounts.txt", "C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\Coursework3rdYear\\test4\\Sad1.txt","C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\Coursework3rdYear\\test4\\SadOpposite2.txt");
        System.out.println("Грустный-жизнерадостный");
        Algorithm("C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\totalcounts.txt", "C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\Coursework3rdYear\\test4\\Sad1.txt","C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\Coursework3rdYear\\test4\\SadOpposite3.txt");
        System.out.println("Красивый-страшный");
        Algorithm("C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\totalcounts.txt", "C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\Coursework3rdYear\\test4\\Beautiful1.txt","C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\Coursework3rdYear\\test4\\BeautifulOpposite1.txt");
        System.out.println("Красивый-уродливый");
        Algorithm("C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\totalcounts.txt", "C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\Coursework3rdYear\\test4\\Beautiful1.txt","C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\Coursework3rdYear\\test4\\BeautifulOpposite2.txt");
        System.out.println("Красивый-безобразный");
        Algorithm("C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\totalcounts.txt", "C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\Coursework3rdYear\\test4\\Beautiful1.txt","C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\Coursework3rdYear\\test4\\BeautifulOpposite3.txt");
        System.out.println("Мороз-морозный");
        Algorithm("C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\totalcounts.txt", "C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\Coursework3rdYear\\test4\\Frost1.txt","C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\Coursework3rdYear\\test4\\Frost2.txt");
        System.out.println("Мороз-изморозь");
        Algorithm("C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\totalcounts.txt", "C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\Coursework3rdYear\\test4\\Frost1.txt","C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\Coursework3rdYear\\test4\\Frost3.txt");
        System.out.println("Морозный-изморозь");
        Algorithm("C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\totalcounts.txt", "C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\Coursework3rdYear\\test4\\Frost2.txt","C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\Coursework3rdYear\\test4\\Frost3.txt");
        System.out.println("Лист-Листок");
        Algorithm("C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\totalcounts.txt", "C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\Coursework3rdYear\\test4\\Leaf.txt","C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\Coursework3rdYear\\test4\\Leaf2.txt");
        System.out.println("Лист-листья");
        Algorithm("C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\totalcounts.txt", "C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\Coursework3rdYear\\test4\\Leaf.txt","C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\Coursework3rdYear\\test4\\Leaves.txt");
        System.out.println("Листок-листья");
        Algorithm("C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\totalcounts.txt", "C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\Coursework3rdYear\\test4\\Leaf2.txt","C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\Coursework3rdYear\\test4\\Leaves.txt");
        System.out.println("Ручка-карандаш");
        Algorithm("C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\totalcounts.txt", "C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\Coursework3rdYear\\test4\\Pencil.txt","C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\Coursework3rdYear\\test4\\Pen.txt");
        System.out.println("Карандаш-ластик");
        Algorithm("C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\totalcounts.txt", "C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\Coursework3rdYear\\test4\\Pen.txt","C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\Coursework3rdYear\\test4\\Eraser.txt");
        System.out.println("Ножницы-нож");
        Algorithm("C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\totalcounts.txt", "C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\Coursework3rdYear\\test4\\Scissors.txt","C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\Coursework3rdYear\\test4\\Knife.txt");
        System.out.println("Тетрадь-бумага");
        Algorithm("C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\totalcounts.txt", "C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\Coursework3rdYear\\test4\\Notebook.txt","C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\Coursework3rdYear\\test4\\Paper.txt");
        System.out.println("Стол-стул");
        Algorithm("C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\totalcounts.txt", "C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\Coursework3rdYear\\test4\\Table.txt","C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\Coursework3rdYear\\test4\\Chair.txt");
        *//*System.out.println("Тарелка-чашка");
        Algorithm("C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\totalcounts.txt", "C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\Coursework3rdYear\\test4\\Plate.txt","C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\Coursework3rdYear\\test4\\Cup.txt");
        System.out.println("Веселый-жизнерадостный");
        Algorithm("C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\totalcounts.txt", "C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\Coursework3rdYear\\test4\\SadOpposite1.txt","C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\Coursework3rdYear\\test4\\SadOpposite3.txt");
        System.out.println("Грустный-грустить");
        Algorithm("C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\totalcounts.txt", "C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\Coursework3rdYear\\test4\\Sad1.txt","C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\Coursework3rdYear\\test4\\ToSad.txt");
        System.out.println("Грустный-грусть");
        Algorithm("C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\totalcounts.txt", "C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\Coursework3rdYear\\test4\\Sad1.txt","C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\Coursework3rdYear\\test4\\SadN.txt");
        System.out.println("Грусть-грустить");
        Algorithm("C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\totalcounts.txt", "C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\Coursework3rdYear\\test4\\SadN.txt","C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\Coursework3rdYear\\test4\\ToSad.txt");
*/

        System.out.println("Высокий-низкий");
        Algorithm("C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\totalcounts.txt", "C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\Coursework3rdYear\\test5\\Высокий.txt","C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\Coursework3rdYear\\test5\\Низкий.txt");
        System.out.println("Толстый-тонкий");
        Algorithm("C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\totalcounts.txt", "C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\Coursework3rdYear\\test5\\Толстый.txt","C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\Coursework3rdYear\\test5\\Тонкий.txt");
        System.out.println("Большой-маленький");
        Algorithm("C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\CourseWork3rdYear\\totalcounts.txt", "C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\Coursework3rdYear\\test5\\Большой.txt","C:\\Users\\Аделя\\IdeaProjects\\CourseWork3rdYear\\src\\Coursework3rdYear\\test5\\Маленький.txt");

    }
}
