package Pract2.company;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

        public static void main(String[] args)throws IOException, ClassNotFoundException   {
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("Вібор задания 1-7 выход 0 ");
                int selection = scanner.nextInt();
                switch (selection) {
                    case 1: {
                        Zd1 zd1 = new Zd1();
                        FileReader fr = new FileReader(zd1.MyMetod());
                        Scanner scan = new Scanner(fr);
                        int i = 1;
                        while (scan.hasNextLine()) {
                            System.out.println(i + " : " + scan.nextLine());
                            i++;
                        }
                        fr.close();
                        break;
                    }
                    case 2:
                    {
                        int saiz=0;//количество ячеек массива
                        int saiz_sim=50;//количество символов в строке
                        Zd1 zd2 = new Zd1();
                        String Name_Fail=zd2.MyMetod();
                        String[] subStr;
                        String subStr1;
                        FileReader fr2 = new FileReader(Name_Fail);

                        Scanner scan2 = new Scanner(fr2);

                         saiz=(int) Math.ceil((scan2.nextLine().length()/saiz_sim));
                        fr2.close();
                        FileReader fr3= new FileReader(Name_Fail);

                        Scanner scan3 = new Scanner(fr3);
                        System.out.println(saiz);
                        subStr =new String[saiz+1] ;
                        int saiz1=0;


                        while (scan3.hasNextLine()) {
                            subStr1=scan3.nextLine();
                            subStr[0] = subStr1.substring(0, saiz_sim);
                            for (int i=1;i<saiz;i++) {

                                saiz_sim += 50;
                                saiz1 += 50;
                                subStr[i] = subStr1.substring(saiz1, saiz_sim);

                            }

                            subStr[saiz]=subStr1.substring(saiz_sim,subStr1.length());

                        }

                        for (int i = 0; i <subStr.length;i++)
                        {System.out.println(" : " + subStr[i]);
                        }
                       fr3.close();
                        break;

                    }
                    case 3:
                    {
                      String  subStr1=null;
                        Zd1 zd3 = new Zd1();
                        FileReader fr3 = new FileReader(zd3.MyMetod());
                        Scanner scan3 = new Scanner(fr3);
                        System.out.println("Введите слово для поиска ");
                        Scanner scan = new Scanner(System.in);
                        String search = scan.nextLine();

                        while (scan3.hasNextLine()) {
                            subStr1=scan3.nextLine();
                            String lines[]=subStr1.split(search);//розбиваем на массив строк по слову
                            System.out.println(search+" повторений="+(lines.length-1));//количество элементов массива и есть количество повторений указаных слов

                        }
                        fr3.close();
                        break;
                    }

                    case 4: {
                        String  subStr1=null;
                        int count=0;
                        Zd1 zd3 = new Zd1();
                        FileReader fr3 = new FileReader(zd3.MyMetod());
                        Scanner scan3 = new Scanner(fr3);
                        while (scan3.hasNextLine()) {
                            subStr1 = scan3.nextLine();
                            for (int i = 0; i < subStr1.length(); i++) {
                                if (subStr1.charAt(i) != ' ') {
                                    count++;
                                }
                            }

                        }
                        System.out.println("количество символов не считая пробелов ="+count);

                        fr3.close();
                        break;

                    }
                    case 5: {
                        String  subStr1=null;
                        String zamen;
                        String New_Stroc=null;
                        Zd1 zd3 = new Zd1();
                        FileReader fr3 = new FileReader(zd3.MyMetod());
                        Scanner scan3 = new Scanner(fr3);
                        System.out.println("Введите слово для поиска ");
                        Scanner scan = new Scanner(System.in);
                        String search = scan.nextLine();
                        System.out.println("новое слово ");
                         zamen = scan.nextLine();

                        while (scan3.hasNextLine()) {
                            subStr1=scan3.nextLine();
                            String lines[]=subStr1.split(search);//розбиваем на массив строк по слову
                            subStr1="";
                            for (int i =0;i<lines.length;i++)//пробегаем по массиву строк
                            {
                                     if (i>0) {//пропускаем если первый елемент массива "если небыло найдено совпадений в массиве один элемент "
                                         New_Stroc = zamen + lines[i];//формируем новую строку с добавленым в начяло новым словом
                                         lines[i] = New_Stroc;//возврвщаем изменённую строку в масив
                                     }
                                           subStr1+=lines[i];//собираем все строки массива назад в одну строу уже с изменёными словами

                            }

                            System.out.println(":" + subStr1);
                            System.out.println(search+" количество заменыних слов ="+(lines.length-1));

                        }
                        fr3.close();
                        break;
                    }
                    case 6: {
                        String [] name_Fail=new String[4];
                        Zd1 zd3 = new Zd1();
                        for(int i=0;i<name_Fail.length-1;i++)
                        {

                                name_Fail[i]=zd3.MyMetod();

                        }
                        System.out.println("Записть в файл  ");
                        name_Fail[3]=zd3.MyMetod();

                        OutputStream Out_Stream  = new FileOutputStream(new File(name_Fail[3]), true);
                        int count;
                        int saiz=0;

                        InputStream in_Stream = new FileInputStream(name_Fail[0]);
                        byte[] buffer = new byte[1];//буфер в 1 byte записуем по одному символу для коректного подсчёта количества записаных byte



                        while ((count = in_Stream.read(buffer)) != -1) {


                            saiz++;
                            Out_Stream .write(buffer, 0, count);
                            Out_Stream .flush();

                        }

                        in_Stream.close();

                        in_Stream = new FileInputStream(name_Fail[1]);

                        while ((count = in_Stream.read(buffer)) != -1) {
                            saiz++;
                            Out_Stream .write(buffer, 0, count);
                            Out_Stream .flush();

                        }

                        in_Stream.close();
                        in_Stream = new FileInputStream(name_Fail[2]);

                        while ((count = in_Stream.read(buffer)) != -1) {

                            saiz++;
                            Out_Stream .write(buffer, 0, count);
                            Out_Stream .flush();
                        }
                        in_Stream.close();
                        Out_Stream .close();
                        System.out.println("количество переписаных байт ="+ saiz);


                        break;
                    }
                    case 7: {
                        String  subStr1=null;
                        int caunt=0;
                        String New_Stroc=null;
                        Zd1 zd3 = new Zd1();
                        FileReader fr3 = new FileReader(zd3.MyMetod());
                        Scanner scan3 = new Scanner(fr3);
                        System.out.println("Введите количество слов для поиска и удаления  ");

                        int saiz=zd3.MuScan().nextInt();
                        String[] search=new String[saiz] ;
                        for(int i=0;i<search.length;i++)
                        { System.out.println("Введите "+(i+1)+" слово ");

                            search[i] =zd3.MuScan().nextLine();

                        }
                        while (scan3.hasNextLine()) {
                            subStr1=scan3.nextLine();
                            String lines[]=subStr1.split(" ");//розбиваем на массив строк по слову
                            for (int j = 0; j < search.length; j++) {
                                for (int i = 0; i < lines.length; i++)//пробегаем по массиву строк
                                {
                                    if (lines[i].contains(search[j]))//ищем совпадения совпадения
                                    {
                                        lines[i] = "";
                                        caunt++;
                                    }

                                }
                            }
                            System.out.println( search[0]);
                            subStr1="";
                            for (int i = 0; i < lines.length; i++)//пробегаем по массиву строк
                            {

                                subStr1+=" "+lines[i];//собираем все строки массива назад в одну строу уже с изменёными словами+=lines[i];//собираем все строки массива назад в одну строу уже с изменёными словами


                            }
                            System.out.println(subStr1);
                            System.out.println(" количество удалённых слов ="+caunt);

                        }


                        fr3.close();
                        break;


                    }
                    case 0: {
                        System.exit(1);
                        break;
                    }
                    default: {
                        System.out.println("не коректные данные");
                    }

                }

            }

        }
    }

