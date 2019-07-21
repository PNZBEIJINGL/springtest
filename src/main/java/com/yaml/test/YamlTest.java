package com.yaml.test;

import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Map;

public class YamlTest {
    public static void main(String[] args) {
        Yaml yaml = new Yaml();
        java.net.URL url = YamlTest.class.getClassLoader().getResource("myconfig.yaml");
        try {
            Map<String, String> map = (Map) yaml.load(new FileInputStream(url.getFile()));
            System.out.println("key:");
            for (String key : map.keySet()) {
                System.out.println(key);
            }
            System.out.println("value:"+map.size());

            for (String value : map.values()) {
                System.out.println(value);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
