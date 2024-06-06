package com.test.customfile.jsonUtil;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class JsonUtil {
    public static void write(Object data, File path) {
        String json = new GsonBuilder().setPrettyPrinting().create().toJson(data);

        if (!path.exists()) {
            path.mkdirs();
        }

        File file = new File(path, data.getClass().getSimpleName() + ".json");
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(json);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static <T> T read(Class<T> clazz, File path) {
        File file = new File(path, clazz.getSimpleName() + ".json");
        try (FileReader reader = new FileReader(file)) {
            return new Gson().fromJson(reader, clazz);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
