package File;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyText {
	public static void main(String[] args) {

//        if (args.length != 2) {
//            System.out.println("Usage: java FileCopy <src/Data/copy.txt> <src/Data/CopiedText.txt>");
//            System.exit(1);
//        }


        String sourceFile = "src/Data/copy.txt";
        String targetFile = "src/Data/CopiedTex1t.txt";

        try {
        	File source = new File(sourceFile);
            File target = new File(targetFile);

            // Check if the source file exists
            if (!source.exists()) {
                System.out.println("Source file not found: " + sourceFile);
                System.exit(1);
            }

            // Check if the target file already exists
            if (target.exists()) {
                System.out.println("Target file already exists. Choose a different target file.");
                System.exit(1);
            }
        	
             FileReader fileReader = new FileReader(sourceFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);


            FileWriter fileWriter = new FileWriter(targetFile);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);


            int character;
            while ((character = bufferedReader.read()) != -1) {
                bufferedWriter.write(character);
            }


            bufferedReader.close();
            bufferedWriter.close();


            System.out.println("File copied successfully.");
            System.out.println("Number of characters in the target file: " + new File(targetFile).length());
        } catch (FileNotFoundException e) {
            System.out.println("Source file not found: " + sourceFile);
        } catch (IOException e) {
            System.out.println("Error occurred during file copy: " + e.getMessage());
        }
    }
}
