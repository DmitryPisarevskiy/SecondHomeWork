import sun.font.FontRunIterator;

import java.awt.*;
import java.sql.SQLOutput;
import java.util.Arrays;

public class SecondHomeWork {
    public static final String ANSI_RESET="\u001B[0m";
    public static final String ANSI_GREEN="\u001B[32m";

    public static void main(String[] args) {
        task01();
        task02();
        task03();
        task04();
        task05();
        int[] a = {5, 1, 1, 2, 5};
        System.out.println("Проверка массива возможность разбиения на правую и левую части, суммы которых равны - "+ task06(a)+"\n");
        task07(a,-2);
    }

    //    1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;
    public static void task01(){
        System.out.println(ANSI_GREEN+"1. Задать массив из 0 и 1. Инвертировать 0 в 1, и 1 в 0"+ANSI_RESET);
        int[] arr={1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.println("Заданный массив - " + Arrays.toString(arr));
        for (int i = 0; i <arr.length ; i++) {
//            arr[i]=(arr[i]+1)%2;
            if (arr[i]==0) {
                arr[i]=1;
            } else {
                arr[i]=0;
            }
        }
        System.out.println("Обработанный массисв - "+ Arrays.toString(arr)+"\n");

    }

    //    2. Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
    public static void task02(){
        System.out.println(ANSI_GREEN+"2. Задать пустой массив размеров 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21"+ANSI_RESET);
        int[] arr = new int[8];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=i*3;
        }
        System.out.println("Заполненный массисв - "+ Arrays.toString(arr)+"\n");
    }

    //    3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
    public static void task03(){
        System.out.println(ANSI_GREEN+"3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2"+ANSI_RESET);
        int[] arr = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
        System.out.println("Заданный массив - "+ Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]<6) {
                arr[i]*=2;
            }
        }
        System.out.println("Обработанный массисв - "+ Arrays.toString(arr)+"\n");
    }

    //    4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое), и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
    public static void task04(){
        System.out.println(ANSI_GREEN+"4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое), и с помощью цикла(-ов) заполнить его диагональные элементы единицами;"+ANSI_RESET);
        int n=5; //число строк и столбцов
        int[][] arr= new int[n][n];
        for (int i = 0; i <n ; i++) {
            arr[i][i]=1;
            arr[i][n-1-i]=1;
        }
        System.out.println("Обработанный массисв:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
//               if (i==j || i+j==n-1) {
//                   arr[i][j]=1;
//               }
               System.out.printf("%4d",arr[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    //    5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
    public static void task05(){
        System.out.println(ANSI_GREEN+"5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);"+ANSI_RESET);
        int n=10; //Величина массива
        int[] arr= new int[n];
        // Задаем случайный массив до от 0 до 10
        for (int i = 0; i <n; i++) {
            arr[i]=(int)(Math.round(Math.random()*10));
        }
        System.out.println("Случайный массив - "+ Arrays.toString(arr));
        int maxNumber=1; //Задаем номер максимального числа. Предполагаем, что оно первое
        int minNumber=1; //Задаем номер минимального числа. Предполагаем, что оно первое
        int max=arr[0];
        int min=arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i]>max){
                max=arr[i];
                maxNumber=i+1;
            }
            if (arr[i]<min){
                min=arr[i];
                minNumber=i+1;
            }
        }
        System.out.printf("Максимальное число равно %d. Оно %d по счету \n", max,maxNumber);
        System.out.printf("Минимальное число равно %d. Оно %d по счету \n\n", min, minNumber);
    }

    //    6. ** Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны. Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, || 2, 1]) → true, граница показана символами ||, эти символы в массив не входят.
    public static boolean task06(int[] arr){
        System.out.println(ANSI_GREEN+"6. ** Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны;"+ANSI_RESET);
        System.out.println("Задан массив - "+ Arrays.toString(arr));
        // Инициализируем суммы левой и правой частей.
        int sumLeft=0;
        int sumRight=0;
        // Суммируем все элементы массива в правую часть, так как проверять будем слева направо
        for (int arrElement:arr) {
            sumRight+=arrElement;
        }
        // Проходимся по массиву слева направо, поэтапно вычитая каждый элемент из правой суммы и прибавляя его к левой до выполнения условия или конца массива;
        int i=0;
        do {
            sumRight-=arr[i];
            sumLeft+=arr[i];
            if (sumLeft==sumRight)  {
                return true;
            }
            i++;
        } while (i<arr.length);
        return false;
    }

    //    7. **** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным, или отрицательным), при этом метод должен сместить все элементымассива на n позиций. Для усложнения задачи нельзя пользоваться вспомогательными массивами.
    public static void task07(int[] arr, int n){
        System.out.println(ANSI_GREEN+"7. **** Написать метод, смещающий элементы массива на n позиций;"+ANSI_RESET);
        System.out.println("Задан массив "+ Arrays.toString(arr));
        System.out.println("Задано смещение "+ n);
        if (n>0) {
            for (int i = 1; i <=n; i++) {
                arrSwing(arr,false);
            }
        } else {
            for (int i = 1; i <=-n; i++) {
                arrSwing(arr,true);
            }
        }
        System.out.println("Обработанный массив "+ Arrays.toString(arr));
    }

    public static void arrSwing(int[] arr,boolean toRight){
        int buf;
        if (toRight){
            buf=arr[arr.length-1];
            for (int i = arr.length-1; i >0; i--) {
                arr[i]=arr[i-1];
            }
            arr[0]=buf;
        } else {
            buf=arr[0];
            for (int i = 0; i < arr.length-1; i++) {
                arr[i]=arr[i+1];
            }
            arr[arr.length-1]=buf;
        }
    }


}
