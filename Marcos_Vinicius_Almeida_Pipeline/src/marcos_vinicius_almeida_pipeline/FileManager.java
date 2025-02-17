package marcos_vinicius_almeida_pipeline;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileManager {

    public static ArrayList<String> stringReader(String path) {
        BufferedReader buffRead = null;
        try {
            buffRead = new BufferedReader(new FileReader(path));
            ArrayList<String> text = new ArrayList<>();
            String line = buffRead.readLine();
            while (line != null) {
                text.add(line);
                line = buffRead.readLine();
            }
            return text;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, "Arquivo não encontrado: " + path, ex);
            return null;
        } catch (IOException ex) {
            Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, "Erro ao ler o arquivo: " + path, ex);
            return null;
        } finally {
            if (buffRead != null) {
                try {
                    buffRead.close();
                } catch (IOException ex) {
                    Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, "Erro ao fechar o BufferedReader", ex);
                }
            }
        }
    }

    public static void writer(String path, String text) {
        BufferedWriter buffWrite = null;
        try {
            buffWrite = new BufferedWriter(new FileWriter(path));
            buffWrite.append(text);
        } catch (IOException ex) {
            Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, "Erro ao escrever no arquivo: " + path, ex);
        } finally {
            if (buffWrite != null) {
                try {
                    buffWrite.close();
                } catch (IOException ex) {
                    Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, "Erro ao fechar o BufferedWriter", ex);
                }
            }
        }
    }

    public static void writerAppend(String path, String text) {
        BufferedWriter buffWrite = null;
        try {
            buffWrite = new BufferedWriter(new FileWriter(path, true));
            buffWrite.append(text);
        } catch (IOException ex) {
            Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, "Erro ao anexar ao arquivo: " + path, ex);
        } finally {
            if (buffWrite != null) {
                try {
                    buffWrite.close();
                } catch (IOException ex) {
                    Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, "Erro ao fechar o BufferedWriter", ex);
                }
            }
        }
    }


    public static String stringToBinaryString(String value, int size) {
        int number = Integer.parseInt(value);
        String binaryString = Integer.toBinaryString(number);

        // Se a representação binária for menor que o tamanho desejado, preencha com zeros à esquerda
        if (binaryString.length() < size) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < size - binaryString.length(); i++) {
                sb.append('0');
            }
            sb.append(binaryString);
            return sb.toString();
        }

        // Se a representação binária for maior que o tamanho desejado, corte os bits excedentes
        if (binaryString.length() > size) {
            return binaryString.substring(binaryString.length() - size);
        }

        return binaryString;
    }
}


