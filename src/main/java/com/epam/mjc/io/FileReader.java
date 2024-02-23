package com.epam.mjc.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;


public class FileReader {
    public Profile getDataFromFile(File file) {
        Profile profile = new Profile();

        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                parseAndSetProfileData(line, profile);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return profile;
    }
    private void parseAndSetProfileData(String line, Profile profile) {
        String[] keyValue = line.split(":");
        if (keyValue.length == 2) {
            String key = keyValue[0].trim();
            String value = keyValue[1].trim();

            switch (key) {
                case "Name":
                    profile.setName(value);
                    break;
                case "Age":
                    profile.setAge(Integer.parseInt(value));
                    break;
                case "Email":
                    profile.setEmail(value);
                    break;
                case "Phone":
                    profile.setPhone(Long.parseLong(value));
                    break;
            }
        }
    }
}
