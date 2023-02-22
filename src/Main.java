import java.util.*;
import java.io.*;
import java.lang.*;

public class Main {
    public static String ArToRm(int num) //функция для перевода арабских чисел в римские
    {
        String[] keys = new String[] { "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
        int[] vals = new int[] { 100, 90, 50, 40, 10, 9, 5, 4, 1 };

        StringBuilder ret = new StringBuilder();
        int ind = 0;

        while(ind < keys.length)
        {
            while(num >= vals[ind])
            {
                int d = num / vals[ind];
                num = num % vals[ind];
                for(int i=0; i<d; i++)
                    ret.append(keys[ind]);
            }
            ind++;
        }
        return ret.toString();
    }

    public static String calc(String input)
    { //функция калькулятора
        int indexPlus = input.indexOf("+");
        int indexUmn = input.indexOf("*");
        int indexDel = input.indexOf("/");
        int indexV = input.indexOf("-");
        String[] operands = input.trim().split("\\+|\\*|\\/|\\-");
        Arrays.toString(operands);

        if (operands.length>2){
          try
          {
           throw new IOException();
          }
          catch (IOException e){
          System.out.println("Введено более двух операндов!"); return "";
          }
        }

        //вспомогательные переменные
        int a1=0, a2=0, b1=0, b2=0, result=0;
        String c1="", c2="";
        switch (operands[0].trim()){ //проверка первого операнда
            case "I":a1+=1; c1="1"; break;
            case "II":a1+=1; c1="2"; break;
            case "III":a1+=1; c1="3"; break;
            case "IV":a1+=1; c1="4"; break;
            case "V":a1+=1; c1="5"; break;
            case "VI":a1+=1; c1="6"; break;
            case "VII":a1+=1; c1="7"; break;
            case "VIII":a1+=1; c1="8"; break;
            case "IX":a1+=1; c1="9"; break;
            case "X":a1+=1; c1="10"; break;
            case "1":a2+=1; c1=operands[0].trim(); break;
            case "2":a2+=1; c1=operands[0].trim(); break;
            case "3":a2+=1; c1=operands[0].trim(); break;
            case "4":a2+=1; c1=operands[0].trim(); break;
            case "5":a2+=1; c1=operands[0].trim(); break;
            case "6":a2+=1; c1=operands[0].trim(); break;
            case "7":a2+=1; c1=operands[0].trim(); break;
            case "8":a2+=1; c1=operands[0].trim(); break;
            case "9":a2+=1; c1=operands[0].trim(); break;
            case "10":a2+=1; c1=operands[0].trim(); break;
            default: System.out.println("Первый операнд не соответствует требованиям ввода!"); return "";
        }
        switch (operands[1].trim()){ //проверка второго операнда
            case "I":b1+=1; c2="1"; break;
            case "II":b1+=1; c2="2"; break;
            case "III":b1+=1; c2="3"; break;
            case "IV":b1+=1; c2="4"; break;
            case "V":b1+=1; c2="5"; break;
            case "VI":b1+=1; c2="6"; break;
            case "VII":b1+=1; c2="7"; break;
            case "VIII":b1+=1; c2="8"; break;
            case "IX":b1+=1; c2="9"; break;
            case "X":b1+=1; c2="10"; break;
            case "1":b2+=1; c2=operands[1].trim(); break;
            case "2":b2+=1; c2=operands[1].trim(); break;
            case "3":b2+=1; c2=operands[1].trim(); break;
            case "4":b2+=1; c2=operands[1].trim(); break;
            case "5":b2+=1; c2=operands[1].trim(); break;
            case "6":b2+=1; c2=operands[1].trim(); break;
            case "7":b2+=1; c2=operands[1].trim(); break;
            case "8":b2+=1; c2=operands[1].trim(); break;
            case "9":b2+=1; c2=operands[1].trim(); break;
            case "10":b2+=1; c2=operands[1].trim(); break;
            default: System.out.println("Второй операнд не соответствует требованиям ввода!"); return "";
        }
        if ((a1==1 && b1!=1) || (a1!=1 && b1==1)){ //проверка, содержит ли выражение и арабские и римские цифры одновременно
            try
            {
                throw new IOException();
            }
            catch (IOException e) {
            System.out.println("Введенное выражение содержит арабские и римские цифры!"); return "";
            }
        }

        if (a1==1 && b1==1) //когда римские цифры
        {
            Integer r1 = Integer.valueOf(c1);
            Integer r2 = Integer.valueOf(c2);
            if (indexPlus!=-1)
            {
                result=r1+r2;
                System.out.println(ArToRm(result));
            }
            if (indexUmn!=-1)
            {
                result=r1*r2;
                System.out.println(ArToRm(result));
            }
            if (indexDel!=-1)
            {
                result=r1/r2;
                if (result<1)
                {
                    try
                      {
                          throw new IOException();
                      }
                    catch (IOException e)
                      {
                          System.out.println("Результат с отрицательным значением!"); return "";
                      }
                }
                System.out.println(ArToRm(result));
            }
            if (indexV!=-1)
            {
                result=r1-r2;
                if (result<1)
                {
                    try
                    {
                        throw new IOException();
                    }
                    catch (IOException e)
                    {
                        System.out.println("Результат с отрицательным значением!"); return "";
                    }
                }
                System.out.println(ArToRm(result));
            }
        }

        if (a2==1 && b2==1) //когда арабские цифры
        {
            Integer r1 = Integer.valueOf(c1);
            Integer r2 = Integer.valueOf(c2);
            if (indexPlus!=-1)
            {
                result=r1+r2;
                System.out.println(Integer.toString(result));
            }
            if (indexUmn!=-1)
            {
                result=r1*r2;
                System.out.println(Integer.toString(result));
            }
            if (indexDel!=-1)
            {
                result=r1/r2;
                System.out.println(Integer.toString(result));
            }
            if (indexV!=-1)
            {
                result=r1-r2;
                System.out.println(Integer.toString(result));
            }
        }
        return "Все отлично";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите выражение для вычисления: ");
        String str = in.nextLine();
        System.out.print(calc(str));
    }
}