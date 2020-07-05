package local.nix.sorting.algorithms.main;

import local.nix.sorting.algorithms.*;

import java.io.FileInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Main {

    static Logger LOGGER;
    static {
        URL systemResource = ClassLoader.getSystemResource("application.properties");
        String path = systemResource.getPath();
        try(FileInputStream ins = new FileInputStream(path)){
            LogManager.getLogManager().readConfiguration(ins);
            LOGGER = Logger.getLogger(Main.class.getName());
        }catch (Exception ignore){
            ignore.printStackTrace();
        }
    }

    public static void main(String[] args) {

            int j = 1;
            while (j < 11) {

                int[] ints = new int[100000];
                int index = 0;
                for (int i = 0; i < ints.length; i++) {
                    index = (int) Math.floor(Math.random() * 100000);
                    ints[i] = index;

                }

                List<Integer> intList = new ArrayList<Integer>(ints.length);
                for (int k : ints) {
                    intList.add(k);
                }


                try{
                    long startCollectionSort = System.nanoTime();
                    Collections.sort(intList);
                    long endCollectionSort = System.nanoTime() - startCollectionSort;

                    LOGGER.log(Level.INFO,"- - - - - - - - - " + j +" - - - - - - - - - - - -  - -" + "\n" +
                            "____________________________________________________________________________________________________________________________________________________" + "\n" +
                            "|Collections.sort()   | BubbleSort       | InsertionSort     | MergeSort      | QuickSort     | SelectionSort    | ShellSort     | ShuttleSort      | " + "\n" +
                            "_____________________________________________________________________________________________________________________________________________________" + "\n" +
                            "|" +   endCollectionSort + "              " +
                            algorithmRunningTime(ints, new BubbleSort()) + "          " +
                            algorithmRunningTime(ints, new InsertionSort()) + "             " +
                            algorithmRunningTime(ints, new MergeSort()) + "        " +
                            algorithmRunningTime(ints, new QuickSort()) + "         " +
                            algorithmRunningTime(ints, new SelectionSort()) + "         " +
                            algorithmRunningTime(ints, new ShellSort()) + "        " +
                            algorithmRunningTime(ints, new ShuttleSort())
                    );

                    j++;

                } catch (Exception e) {
                    LOGGER.log(Level.WARNING,"что-то пошло не так" , e);
                }
             }
    }

        private static long algorithmRunningTime(int[] arr, Sort algorithm) {
            long start = System.nanoTime();
            int[] result = algorithm.sort(arr);
            long end = System.nanoTime() - start;
            return end;
        }
}