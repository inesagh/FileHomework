package com.exercises;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        File file = new File("documents.txt");
        Circle circle = new Circle("circle 1", 4);
        Circle circle2 = new Circle("circle 2", 6);
        Stream<Circle> circleStream = Stream.of(circle, circle2);
        String collect = circleStream
                .map(each -> each.toString())
                .collect(Collectors.joining("\n"));
        String string = "";

        try (OutputStream outputStream = new FileOutputStream(file)) {
            outputStream.write(collect.getBytes());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

//        Read from file and create a list of objects
        try (InputStream inputStream = new FileInputStream(file)) {
            byte[] bytes1 = inputStream.readAllBytes();
            string = new String(bytes1);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        String[] splitedString = string
                .replaceAll("\\{\n", "")
                .replaceAll("},\\n", "")
                .split("\\n\\n");


        List<Circle> circleList = new ArrayList<>();
        for (String s : splitedString) {
            circleList.add(conversion(s));
        }

        System.out.println(circleList);


//        Read the first 3 lines
        String[] split = string.split("\n");
        Arrays.stream(split).limit(3).forEach(each -> System.out.println(each));


//        Copy a file from Desktop to Documents
        File desktopFile = new File("C://Users//user//Desktop//desktopFile.txt");
        File documentFile = new File("C://Users//user//Documents//desktopFileCopy.txt");

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(desktopFile))) {
            bufferedWriter.write(circle.toString());
            bufferedWriter.write(circle2.toString());

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }


        try (FileOutputStream fileOutputStream = new FileOutputStream(documentFile)) {
            Files.copy(Paths.get("C://Users//user//Desktop//desktopFile.txt"), fileOutputStream);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

    }

    public static Circle conversion(String string) {
        String[] split = string.split("\n");
        Circle circle = new Circle();
        String[] split2 = split[0].split(" : ");
        circle.setName(split2[1]);
        String[] split3 = split[1].split(" : ");
        circle.setRadius(Integer.parseInt(split3[1]));
        return circle;
    }

}
