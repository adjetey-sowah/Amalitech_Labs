/**
 * @author Julius Adjetey Sowah
 * This program reads grades of N students in a class on an assignment and stores them in
 * an array of scores. It then plots the values of the ranges in an array and 
 * also allows you to search for the maximum, minimum and average grades.
 * 
 */

import java.util.Arrays;
import java.util.Scanner;


public class StatisticsOfGrades {
    public static void main(String[] args) {
        mainMenu();

    }

    /**
     * The mainMenu() displays the option for the user to input the number of grades he/she want's to enter.
     * It then calls the other functions to work on the input the user has input. 
     */

    protected static  void  mainMenu(){
        Scanner input = new Scanner(System.in);

        System.out.println("STATISTICS OF GRADES");
        System.out.println("----------------------");
    
        System.out.print("Enter the number of students in the class: ");
            
        int numOfStudents = input.nextInt();
    
        int[] grades =  new int[numOfStudents];
    
        for (int count = 0; count < numOfStudents; count++){
            System.out.print("Enter the grade for student "+count +": ");
                grades[count] = input.nextInt();
        }        

        System.out.println();
        System.out.println();

        
        System.out.println("The max grade in the list is :"+ maxGrade(grades));
        System.out.println();
        System.out.println("The minimum grade in the list :"+ minGrade(grades));
        System.out.println();
        System.out.println("The average grade in the list :"+ averageGrade(grades));

        drawGraph(grades);

    }



    /**
    *  maxGrade This method returns the maximum grade in the array of grades.
    *  @param grades The grades of the students in the class.
    *  @return The maximum grade in the array.
    */

    protected static int maxGrade(int[] grades) {
        int max = grades[0];
        for (int i = 1; i < grades.length; i++) {
            if (max < grades[i]) {
                max = grades[i];
            }
        }
        return max;
    }

    /**
    *  minGrade This method returns the minimum grade in the array of grades.
    *  @param grades The grades of the students in the class.
    *  @return The minimum grade in the array.
    */

    protected static int minGrade(int[] grades) {
        int min = grades[0];
        for (int i = 1; i < grades.length; i++) {
            if (min > grades[i]) {
                min = grades[i];
            }
        }
        return min;
    }

    /**
    *  maxGrade This method returns the maximum grade in the array of grades.
    *  @param grades The grades of the students in the class.
    *  @return The maximum grade in the array.
    */

    protected static double averageGrade(int[] grades) {
        int sum = 0;
        for (int i = 0; i < grades.length; i++) {
            sum += grades[i];
        }
        return (double) sum / grades.length;
    }


    /**
     * drawGraph This method does the actual computation. It count the values of each range and stores it in an array.
     * It then plots the values on a graph.
     * @param array
     */
    public static void drawGraph(int[] array){

        int[] stat = new int[5];

        for(int grade : array){
            if(grade >= 0 && grade < 21){   // If grade is between 0 - 20
                stat[0]++;
            }
            else if(grade >= 21 && grade < 41){     // If grade is between 0 - 20
                stat[1]++;
            }
            else if(grade >= 41 && grade < 61){     // If grade is between 0 - 20
                stat[2]++;
            }
            else if(grade >= 61 && grade < 81){     // If grade is between 0 - 20
                stat[3]++;
            }
            else if(grade >= 81){           // If grade is between 0 - 20
                stat[4]++;
            }
        }


        // Check for the highest range of grade.
        int maxHeight = 0;
        for(int height : stat){
            if(height > maxHeight){
                maxHeight = height;
            }
        }


        // Display the stats
        System.out.println("Statistics of Grades : "+Arrays.toString(stat));
        System.out.println();

        System.out.println("GRAPH");
        System.out.println("--------");
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