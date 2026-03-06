package JavaJourney;
/*
  write a java program for a simple search engine. Accept a string to be searched. Search the string in all text files in the currect folder. Use a separate thread for each file. The result should display the filename and line number where the string is found.
*/

import java.io.BufferedReader;
//thread class for searching a word in one file
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

class FileSearchThread extends Thread {
    public static void main(String[] args) {
       try {
        
     
        private File file;
        private String search;

        FileSearchThread(File file ,String search){
             this.file = file;
             this.search = search;
        }

        public void run(){
             try {
                BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            int lineNo = 0;
            boolean found = false;

           while((line = br.readLine()) != null){
               lineNo++;
               if(line.contains(search)){
                System.out.println("Found in File : "+ file.getName()+ "at line No :" + lineNo);
                found= true;
               }
           }

             } catch (IOException e) {
                e.printStackTrace();
             }catch(ClassNotFoundException ee){
                ee.printStackTrace();
             }
        }

        } catch (Exception ex) {
               ex.printStackTrace();
        }
    }

}
