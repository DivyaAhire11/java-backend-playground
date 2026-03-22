import java.io.*;
import java.util.ArrayList;

// Thread class
class FileSearch extends Thread {
    File file;
    String keyword;

    static boolean found = false;

    FileSearch(File file, String keyword) {
        this.file = file;
        this.keyword = keyword;
    }

    public void run() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            int lineNo = 0;

            while ((line = br.readLine()) != null) {
                lineNo++;

                // simple search (case-sensitive)
                if (line.contains(keyword)) {
                    System.out.println("Found in " 
                        + file.getName() + " at line " + lineNo);
                    found = true;
                }
            }

            br.close();

        } catch (Exception e) {
            System.out.println("Error in file: " + file.getName());
        }
    }
}

// Main class
class SimpleSearchEngine {
    public static void main(String[] args) throws Exception {

        BufferedReader input = new BufferedReader(
                new InputStreamReader(System.in));

        // input keyword
        System.out.print("Enter word to search: ");
        String keyword = input.readLine();

        File folder = new File(".");
        File[] files = folder.listFiles();

        ArrayList<FileSearch> list = new ArrayList<>();

        // create threads
        for (File f : files) {
            if (f.isFile() && f.getName().endsWith(".txt")) {

                FileSearch t = new FileSearch(f, keyword);
                list.add(t);
                t.start();
            }
        }

        // wait for threads
        for (FileSearch t : list) {
            t.join();
        }

        // result
        if (!FileSearch.found) {
            System.out.println("Not Found");
        }

        System.out.println("Search Completed");
    }
}