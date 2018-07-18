import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FilterFiles {
    public List<String> listing(File[] listOfFiles, String searchString) throws FileNotFoundException {
        java.util.List<String> files = new ArrayList<String>();
        for (File file : listOfFiles) {
            if (file.isDirectory()) {
                listing(file.listFiles(), searchString);
            } else if (file.getName().contains(searchString)) {
                System.out.println(file.getName());
                files.add(file.getName());
                readContents(file);
            }
        }
        return files;
    }

    public void readContents(File file) throws FileNotFoundException {
        FileInputStream stream = null;

        try {
            stream = new FileInputStream(file);
            byte fileContent[] = new byte[(int) file.length()];
            stream.read(fileContent);
            String s = new String(fileContent);
            System.out.println("File content: ");
            System.out.println(s);
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: File not found");
            e.printStackTrace();
        } catch (IOException ioe) {
            System.out.println("ERROR: File could not be read");
            ioe.printStackTrace();
        } finally {
            try {
                if (stream != null) {
                    stream.close();
                }
            } catch (IOException ioe) {
                System.out.println("ERROR: There was a problem in closing the stream");
                ioe.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        File folder = new File("/home/tanmaya/Desktop");
        File[] listOfFiles = folder.listFiles();
        FilterFiles ff = new FilterFiles();
        try {
            ff.listing(listOfFiles, ".java");
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: File not found");
        }
    }
}
