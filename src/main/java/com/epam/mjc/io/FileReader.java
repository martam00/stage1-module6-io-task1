package com.epam.mjc.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class FileReader {

    public Profile getDataFromFile(File file) {
        Map<String, String> map = new HashMap<>();
        try {
            BufferedReader reader = new BufferedReader(new java.io.FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] str = line.split(": ");
                map.put(str[0], str[1]);
            }
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String name = map.get("Name");
        Integer age = Integer.parseInt(map.get("Age"));
        String email = map.get("Email");
        Long phone = Long.parseLong(map.get("Phone"));
        return new Profile(name, age, email, phone);
    }
}
