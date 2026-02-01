package org.hojatrabajo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Class to read the txt file with robust error handling.
 */
public class LectorArchivo {

    private File file;

    public LectorArchivo(String ruta) {
        this.file = new File(ruta);
    }

    /**
     * Reads lines from the text file safely.
     * @return a list of postfix expressions
     * @throws IOException if the file cannot be read
     */
    public List<String> leerLineas() throws IOException {
        if (!file.exists()) {
            throw new FileNotFoundException("Error: The file was not found at path ");
        }

        if (!file.isFile() || !file.canRead()) {
            throw new IOException("Error: The path exists but is not a valid readable file");
        }

        List<String> postfix = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (!linea.trim().isEmpty()) {
                    postfix.add(linea.trim());
                }
            }
        }

        if (postfix.isEmpty()) {
            System.out.println("The file is empty :(");
        }
        return postfix;
    }
}