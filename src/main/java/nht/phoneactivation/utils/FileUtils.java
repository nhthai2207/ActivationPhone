package nht.phoneactivation.utils;

import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {
    public static List<String> readCSV(String filePath) {
        try {
            List<String> ret = new ArrayList<>();
            InputStream resourceAsStream = FileUtils.class.getClassLoader().getResourceAsStream(filePath);
            BufferedReader reader = new BufferedReader(new InputStreamReader(resourceAsStream));
            String line = reader.readLine();
            while (StringUtils.isNotEmpty(line)) {
                ret.add(line);
                line = reader.readLine();
            }
            return ret;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
