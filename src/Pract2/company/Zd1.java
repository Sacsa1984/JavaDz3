package Pract2.company;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class Zd1 {

    public static String str_Rez;

    public String getStr_Rez() {
        return str_Rez;
    }

    public void setStr_Rez(String str_Rez) {
        this.str_Rez = str_Rez;
    }

    public String MyMetod() {
        String Dan = null;

        System.out.println("Введите путь к файлу");

        Scanner scan = new Scanner(System.in);
        Dan = scan.nextLine();
        this.str_Rez = Dan.replaceAll("\\\\", "\\\\\\\\").trim();

        System.out.println(str_Rez);

return str_Rez;
    }
    public int Saiz(String Lain){

        int saiz=(int)Math.ceil(Lain.length()/100);
        return saiz;
    }
    public Scanner  MuScan()
    {
        Scanner scan = new Scanner(System.in);
        return scan;
    }

}