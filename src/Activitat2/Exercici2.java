package Activitat2;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class Exercici2 {
    public static void main(String[] args) throws IOException, BadPaddingException, IllegalBlockSizeException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException {
        Path path = Paths.get("C:\\Users\\bilal\\Desktop\\textamagat");
        byte[] textenbytes = Files.readAllBytes(path);
        File f = new File("C:\\Users\\bilal\\Desktop\\clausA4.txt");
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        Xifrar xifrar = new Xifrar();
        String line = br.readLine();
        Boolean encontrado = true;
        String decrypt = null;
        while (line != null && encontrado) { //fins que no hi ha més línies a llegir
            try {
                //fer alguna cosa amb la línia llegida
                SecretKey key = xifrar.passwordKeyGeneration(line, 128);
                decrypt = new String(xifrar.decryptData(textenbytes, key), "UTF8");
                //següent línia
                if(decrypt.equals(decrypt)){
                    System.out.print("lectura: " + line);
                    System.out.print(" " + decrypt);
                    encontrado= false;
                }

            } catch (BadPaddingException ex) {
                line = br.readLine();

            }

        }

    }
}


