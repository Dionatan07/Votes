package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Program {
    public static void main(String[] args) {

        Map<String, Integer> map = new HashMap<>();

        String path = "C:\\temp\\registers.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            String line = br.readLine();
            while (line != null) {
                String[] fields = line.split(",");

                String name = fields[0];
                int votes = Integer.parseInt(fields[1]);

                if(map.get(name) == null){
                    map.put(name, votes);
                }
                else{
                    map.put(name, votes + map.get(name));
                }

                line = br.readLine();
            }

            for (String key : map.keySet()){
                System.out.println(key + ": " + map.get(key));
            }

        } catch (IOException e) {
            System.out.println("Error " + e.getMessage());
        }



    }
}
