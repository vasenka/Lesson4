package task2;


//import task1.Task1;

import java.io.*;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

public class Task2 {
    public static void main(String[] args) throws URISyntaxException{
        File fileIn = new File("src/main/resources/task2/fileIn.txt");
        File fileOut = new File("src/main/resources/task2/fileOut.txt");


        readAndWrite(fileIn, fileOut);


    }
    static void readAndWrite(File fileIn, File fileOut) {

        try(BufferedReader bfIn = new BufferedReader(new FileReader(fileIn));
            BufferedWriter bfOut = new BufferedWriter(new PrintWriter(fileOut))){

            String s;
            JavaKeyWords[] javaKeyWords = JavaKeyWords.values();
            Map<String,Integer> map = new HashMap<>();
            while ((s=bfIn.readLine())!=null) {
                for (int i = 0; i < javaKeyWords.length; i++) {
                    if (s.contains(javaKeyWords[i].toString())) {

                        if (!map.containsKey(javaKeyWords[i].toString())) {
                            map.put(javaKeyWords[i].toString(), 1);
                        } else {
                            map.put(javaKeyWords[i].toString(), map.get(javaKeyWords[i].toString())+1);
                        }
                    }
                }

            }
            bfOut.write("JavaKeyWords:\n");
            bfOut.write(map.toString());
            bfOut.write("\n:)");
            System.out.println(map);


        }catch (IOException e) {

        }
    }
}

enum JavaKeyWords {BYTE, SHORT,INT,LONG,FLOAT,DOUBLE,CHAR,BOOLEAN,IF,ELSE,SWITCH,CASE,DEFAULT,WHILE,DO,BREAK,CONTINUE,FOR,
    TRY,CATCH,FINALLY,THROW,THROWS,PRIVATE,PROTECTED,PUBLIC,IMPORT,PACKAGE,CLASS,INTERFACE,EXTENDS,IMPLEMENTS,STATIC,
    FINAL,VOID,ABSTRACT,NATIVE,NEW,RETURN,THIS,SUPER,SYNCHRONIZED,VOLATILE,CONST,GOTO,INSTANSEOF,ENUM,
    ASSERT,TRANSIENT,STRICTFP;

    @Override
    public String toString() {
        return super.toString().toLowerCase();
    }
}

