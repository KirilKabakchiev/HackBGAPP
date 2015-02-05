/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listofdirectories;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author Win7
 */
public class ListOfDirectories {

    /**
     * @param args the command line arguments
     */
    // first way to do it. I personally highly dislike this one thats why there are more ways :P
    public static List<File> listf(String directoryName) {
        File directory = new File(directoryName);
        List<File> resultList = new ArrayList<>();
        // get all the files from a directory
        File[] fList = directory.listFiles();
        resultList.addAll(Arrays.asList(fList));
        for (File file : fList) {
            if (file.isFile()) {
                System.out.println(file.getAbsolutePath());
            } else if (file.isDirectory()) {
                resultList.remove(file);
                resultList.addAll(listf(file.getAbsolutePath()));
            }
        }
        return resultList;
    }

//    public static List<File> listfCleanUpFolders(String directoryName){
//       return listfInProgess(directoryName).stream().filter(file -> file.isFile()).collect(Collectors.toList());
//    }
    
    
    //second way to do it... looks cleaner atleast to me...
    public static void listf(String directoryName, ArrayList<File> files) {
        File directory = new File(directoryName);
        // get all the files from a directory
        File[] fList = directory.listFiles();
        for (File file : fList) {
            if (file.isFile()) {
                files.add(file);
            } else if (file.isDirectory()) {
                listf(file.getAbsolutePath(), files);
            }
        }
    }
    
    //Comparison is done byte by byte. 
    //Warning: One drawback of this approach, is that if one of the files has 
    // additional metadata but same  content, the comparison still returns false.

    public static List<File> cleanDuplicates(List<File> fileData){
        List<File> temp = new ArrayList<>(fileData);
        for (int i = 0; i < temp.size(); i++) {
            for (int j = i + 1; j < temp.size(); j++) {
                try {
                    if (FileUtils.contentEquals(temp.get(i), temp.get(j))) {
                        temp.remove(temp.get(i));
                    }
                } catch (IOException ex) {
                    System.out.println("Problem occured while comparing files. Program is closing.");
                    System.exit(1);
                }
            }
        }
        return temp;
    }

    public static void main(String[] args) {
        System.out.println(cleanDuplicates(listf("C:\\Users\\Win7\\Desktop\\1\\commons-io-2.4")).size());
        ArrayList<File> hello = new ArrayList<>();

        listf("C:\\Users\\Win7\\Desktop\\1\\commons-io-2.4", hello);
        System.out.println(cleanDuplicates(hello).size());
    }

}
