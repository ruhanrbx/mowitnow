package fr.com.mowitnow.main;

import fr.com.mowitnow.model.LawnMower;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * Created by ruhan.silva on 13/05/2017.
 */
public class RunLawnMower {

    public static void main(String args[]) {
        // c://textFile.txt
        final String FILE_NAME = args[0];

        List<String> list = new ArrayList<>();


        try (Stream<String> stream = Files.lines(Paths.get(FILE_NAME))) {

            list = stream.collect(Collectors.toList());


        } catch (IOException e) {
            e.printStackTrace();
        }

        final int DIMENSION = 0;
        System.out.println("INPUT");
        list.forEach(System.out::println);


        String[] dimension = list.get(DIMENSION).split(" ");

        list.remove(list.get(DIMENSION));
        System.out.println("\nOUTPUT");
        LawnMower lm = new LawnMower(dimension, list);
        lm.run();


    }


}
