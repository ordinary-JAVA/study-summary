package com.example.test.loacl.test.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lizongren
 * @create 2020.06.01 9:31
 */

public class Test {
    public static void main(String[] args) {
        FileInputStream fileInputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;
        String str;
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;

        try {
            List<String> list = new ArrayList<>();
            fileInputStream = new FileInputStream("D:\\idea-workspace\\test3\\src\\main\\resources\\read.txt");
            inputStreamReader = new InputStreamReader(fileInputStream);
            bufferedReader = new BufferedReader(inputStreamReader);
            while ((str = bufferedReader.readLine()) != null) {
                list.add(str);
            }
            File file = new File("D:\\idea-workspace\\test3\\src\\main\\resources\\writer.txt");
            fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (String s : list) {
                System.out.println(s);
                bufferedWriter.write(s+"\r\n");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //流关闭顺序,先开后关
                bufferedReader.close();
                inputStreamReader.close();
                fileInputStream.close();

                bufferedWriter.close();
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
