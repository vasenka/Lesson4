package task3;


import java.io.*;

public class Task3 {
    public static void main(String[] args) {

        String fileIn = "utf8.txt";
        File fileOut = new File("src/main/resources/task3/utf16.txt");
        writeToUtf16(fileIn,fileOut);
    }
    static void writeToUtf16(String fileIn, File fileOut){
        try(BufferedReader bf = new BufferedReader(new InputStreamReader(Task3.class.getResourceAsStream(fileIn)));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileOut),"utf-16"))) {

            String s;
            while ((s = bf.readLine()) != null) {
                bw.write(s+"\n");
            }
        }catch (IOException e) {

        }
    }
}
