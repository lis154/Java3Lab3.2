import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Java3Lab22 {


    public static void main(String[] args) {

        // vuvodFaila("7.txt"); // 1 задание


        //schit("1.txt", "2.txt", "3.txt", "4.txt", "5.txt"); // 2 задача

        Chtenie("8.txt"); // 3 задание

    }

    public static void schit(String ... name)
    {
        ArrayList<InputStream> inputStream = new ArrayList<InputStream>();
        try {
            inputStream.add(new FileInputStream(name[0]));
            inputStream.add(new FileInputStream(name[1]));
            inputStream.add(new FileInputStream(name[2]));
            inputStream.add(new FileInputStream(name[3]));
            inputStream.add(new FileInputStream(name[4]));
            FileOutputStream out = new FileOutputStream("6.txt");

            SequenceInputStream seq = new SequenceInputStream(Collections.enumeration(inputStream));
            int x;
            while((x = seq.read()) != -1)
            {
                out.write(x);
            }
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void vuvodFaila(String nameFile)
    {
        ArrayList<Integer> mass = new ArrayList<Integer>();
        try {
            FileInputStream fileInput = new FileInputStream(nameFile);
            int i;
            while (!((i = fileInput.read()) == -1))
            {
                mass.add(i);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int b: mass) {
            System.out.println(b);
        }

    }

    public static void Chtenie(String name)
    {
        try {
            FileInputStream fin = new FileInputStream(name);
            BufferedReader reader = new BufferedReader(new InputStreamReader(fin));
            String str;
            while ((str = reader.readLine()) != null)
            {
                System.out.println(str);
            }
            reader.close();
            fin.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
