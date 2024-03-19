package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class main {
    public static Map<String, String> processDictionaryFile(String fileName) throws IOException {
        Map<String, String> dictionaryMap = new HashMap<>();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = reader.readLine()) != null) {
            line = line.trim().substring(1, line.length() - 1);
            String[] parts = line.split(", ");
            String english = parts[0].toLowerCase();
            String spanish = parts[1];
            dictionaryMap.put(english, spanish);
        }
        reader.close();
        return dictionaryMap;
    }

    public static String translateText(Map<String, String> dictionaryMap, String fileName) throws IOException {
        StringBuilder translatedText = new StringBuilder();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] words = line.split(" ");
            for (String word : words) {
                String translation = dictionaryMap.get(word.toLowerCase());
                if (translation != null) {
                    translatedText.append(translation).append(" ");
                } else {
                    translatedText.append("*").append(word).append("* ").append(" ");
                }
            }
            translatedText.append("\n");
        }
        reader.close();
        return translatedText.toString();
    }

    public static void main(String[] args) {
        try {
            // Procesar archivo de diccionario
            Map<String, String> dictionaryMap = processDictionaryFile("diccionario.txt");

            // Mostrar diccionario
            System.out.println("Diccionario:");
            for (Map.Entry<String, String> entry : dictionaryMap.entrySet()) {
                System.out.println(entry.getKey() + " -> " + entry.getValue());
            }

            // Traducir texto
            String translatedText = translateText(dictionaryMap, "texto.txt");
            System.out.println("\nTexto traducido:");
            System.out.println(translatedText);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
