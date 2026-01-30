package org.hojatrabajo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 *Class to read de txt
 */
public class LectorArchivo {

    private String ruta;

    public LectorArchivo(String ruta) {
        this.ruta = ruta;
    }

    /**
     * reed the lines of the txt.
     * @return a list of postfix
     * @throws Exception if the document can not read
     */
    public List<String> leerLineas() throws Exception {
        List<String> postfix = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(ruta));
        String linea;

        while ((linea = br.readLine()) != null) {
            if (!linea.trim().isEmpty()) {
                postfix.add(linea);
            }
        }

        br.close();
        return postfix;
    }
}

