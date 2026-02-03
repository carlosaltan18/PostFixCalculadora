package org.hojatrabajo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Reads postfix expressions from a text file.
 * @author Sergio & Carlos
 */
public class LectorArchivo {

    private File file;

    /**
     * Constructs a file reader for the specified path.
     * @param ruta path to the file
     */
    public LectorArchivo(String ruta) {
        this.file = new File(ruta);
    }

    /**
     * Reads all non-empty lines from the file.
     * @return list of expressions, one per line
     * @throws IOException if file cannot be read
     * @throws FileNotFoundException if file does not exist
     */
    public List<String> leerLineas() throws IOException {
        if (!file.exists()) {
            throw new FileNotFoundException("The file was not found at path: " + file.getAbsolutePath());
        }

        if (!file.isFile() || !file.canRead()) {
            throw new IOException("The path exists but is not a valid readable file");
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
            System.out.println("Warning: The file is empty");
        }

        return postfix;
    }
}