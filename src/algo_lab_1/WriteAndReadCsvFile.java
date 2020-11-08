package algo_lab_1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WriteAndReadCsvFile {

    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";
    private static final int NAME_OF_PLANE = 0;
    private static final int VOLUME_OF_FUEL_THANKS_IN_LITERS = 1;
    private static final int PASSENGER_CAPACITY = 2;

    private static final String FILE_HEADER = "name,volumeOfFuelTanksInLiters,passengerCapacity";

    protected static void writePlaneToCsvFile(String fileName) {

        Plane plane = new Plane("Plane", 25.4D, 200);
        Plane plane1 = new Plane("Plane1", 30.5D, 190);
        Plane plane2 = new Plane("Plane2", 24D, 197);
        Plane plane3 = new Plane("Plane3", 25D, 210);
        Plane plane4 = new Plane("Plane4", 27D, 207);
        Plane plane5 = new Plane("Plane5", 25D, 222);
        Plane plane6 = new Plane("Plane6", 19.2D, 232);
        Plane plane7 = new Plane("Plane7", 32D, 212);
        Plane plane8 = new Plane("Plane8", 18D, 184);
        Plane plane9 = new Plane("Plane9", 22.5D, 195);

        List<Plane> planes = new ArrayList<>();
        planes.add(plane);
        planes.add(plane1);
        planes.add(plane2);
        planes.add(plane3);
        planes.add(plane4);
        planes.add(plane5);
        planes.add(plane6);
        planes.add(plane7);
        planes.add(plane8);
        planes.add(plane9);

        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(fileName);
            fileWriter.append(FILE_HEADER);
            fileWriter.append(NEW_LINE_SEPARATOR);

            for (Plane planeToCsv : planes) {
                fileWriter.append(String.valueOf(planeToCsv.getName()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(planeToCsv.getVolumeOfFuelTanksInLiters().toString());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(planeToCsv.getPassengerCapacity().toString());
                fileWriter.append(NEW_LINE_SEPARATOR);
            }

            System.out.println("CSV file was created successfully !!!");

        } catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        } finally {
            try {
                assert fileWriter != null;
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }
        }
    }

    protected static List<Plane> getPlanesFromCsvFile(String fileName) {
        BufferedReader fileReader = null;
        List<Plane> planes = new ArrayList<>();
        try {
            String line = "";
            fileReader = new BufferedReader(new FileReader(fileName));
            //Read the CSV file header to skip it
            fileReader.readLine();

            while ((line = fileReader.readLine()) != null) {
                //Get all tokens available in line
                String[] tokens = line.split(",");
                if (tokens.length > 0) {
                    //Create a new plane object and fill his  data
                    Plane student = new Plane(tokens[NAME_OF_PLANE],
                            Double.parseDouble(tokens[VOLUME_OF_FUEL_THANKS_IN_LITERS]),
                            Integer.parseInt(tokens[PASSENGER_CAPACITY]));
                    planes.add(student);
                }
            }
        } catch (Exception e) {
            System.out.println("Error in CsvFileReader !!!");
            e.printStackTrace();
        } finally {
            try {
                assert fileReader != null;
                fileReader.close();
            } catch (IOException e) {
                System.out.println("Error while closing fileReader !!!");
                e.printStackTrace();
            }
        }
        return planes;
    }
}
