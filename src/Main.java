/**
 * @author Julius Adjetey Sowah
 * This program reads grades of N students in a class on an assignment and stores them in
 * an array scores. It also allows you to search for the maximum, minimum and average grades.
 *
 */

import java.util.Arrays;
import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        int[] grades = {2, 20, 21, 22, 23, 30, 48, 49, 50, 55, 60, 65, 72, 63, 76, 80, 68, 90, 85, 98};

        System.out.println("The max grade in the list is :"+ maxGrade(grades));
        System.out.println();
        System.out.println("The minimum grade in the list :"+ minGrade(grades));
        System.out.println();
        System.out.println("The average grade in the list :"+ averageGrade(grades));

        System.out.println();
        System.out.println();
        System.out.println();

        drawGraph(grades);
    }


    protected static  int  mainMenu(){
        System.out.println("STATISTICS OF GRADES");
        System.out.println("----------------------");

        System.out.println("Enter the number of students in the class: ");

    }
    protected static int maxGrade(int[] grades) {
        int max = grades[0];
        for (int i = 1; i < grades.length; i++) {
            if (max < grades[i]) {
                max = grades[i];
            }
        }
        return max;
    }

    protected static int minGrade(int[] grades) {
        int min = grades[0];
        for (int i = 1; i < grades.length; i++) {
            if (min > grades[i]) {
                min = grades[i];
            }
        }
        return min;
    }

    protected static double averageGrade(int[] grades) {
        int sum = 0;
        for (int i = 0; i < grades.length; i++) {
            sum += grades[i];
        }
        return (double) sum / grades.length;
    }

    protected static void drawGraph(int[] array){

        int[] stat = new int[5];

        for(int grade : array){
            if(grade >= 0 && grade < 21){
                stat[0]++;
            }
            else if(grade >= 21 && grade < 41){
                stat[1]++;
            }
            else if(grade >= 41 && grade < 61){
                stat[2]++;
            }
            else if(grade >= 61 && grade < 81){
                stat[3]++;
            }
            else if(grade >= 81){
                stat[4]++;
            }
        }


        int maxHeight = 0;
        for(int height : stat){
            if(height > maxHeight){
                maxHeight = height;
            }
        }




        System.out.println(Arrays.toString(stat));
        System.out.println();

        System.out.println("Graph");
        for(int level = maxHeight;level > 0;level--){
            System.out.printf(level+"%5s",">      ");
            for (int count : stat) {
                if (count >= level) {
                    System.out.printf("%7s     ","######");
                }
                else
                    System.out.printf("%6s      ","");
            }

            System.out.println();
        }

        System.out.println(String.format("     +-----------+-----------+-----------+-----------+-----------+"));
        String value = "0 - 20";
        System.out.printf("%6s%9s  |%9s  |%9s  |%9s  |%9s  |\n","|",value,"21 - 40","41 - 60","61 - 80","81 - 100");

    }
}