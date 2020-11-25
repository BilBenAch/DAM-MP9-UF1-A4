import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.security.Key;

public class Exercicis {
    public static void Exercici5() throws IOException {
        System.out.println();
        System.out.println("Exercici5");
        String text = "paraula desencriptada";
        try {
            Xifrar xifrar = new Xifrar();
            int keySize = 128;
            SecretKey myKey = xifrar.keygenKeyGeneration(keySize);
            byte[] data = text.getBytes("UTF-8");
            byte[] encryptedData = xifrar.encryptData(myKey, data);
            String encriptedString = new String(xifrar.decryptData(encryptedData, myKey), "UTF-8");
            System.out.println(encriptedString);

        } catch (Exception e) {

        }
    }

    public static void Exercici6() throws IOException {
        System.out.println();
        System.out.println();
        System.out.println("Exercici 6");
        String text = "Segona paraula desencriptada";
        try {
            Xifrar xifrar = new Xifrar();
            int keySize = 128;
            SecretKey myKey = xifrar.passwordKeyGeneration(text, keySize);
            byte[] data = text.getBytes("UTF-8");
            byte[] encryptedData = xifrar.encryptData(myKey, data);
            String decriptedString = new String(xifrar.decryptData(encryptedData, myKey), "UTF8");
            System.out.println(decriptedString);

        } catch (Exception e) {

        }
    }

    public static void Exercici7() throws IOException {
        System.out.println();
        System.out.println();
        System.out.println("Exercici 7");
        String text = "Provant mètodes de SecretKey";
        try {
            Xifrar xifrar = new Xifrar();
            int keySize = 128;
            SecretKey myKey = xifrar.passwordKeyGeneration(text, keySize);
            System.out.println("Get alorithm--> " + myKey.getAlgorithm());
            System.out.println("Get encoded ---> " + myKey.getEncoded());
            System.out.println("Get format ---->" + myKey.getFormat());
            System.out.println("Avanç de cridar el metode destroy ---> " + myKey.isDestroyed());
            byte[] data = text.getBytes("UTF-8");
            byte[] encryptedData = xifrar.encryptData(myKey, data);
            String decriptedString = new String(xifrar.decryptData(encryptedData, myKey), "UTF8");
            System.out.println(decriptedString);
            destroy(myKey);
            System.out.println("Després cridar el metode destroy --->" + myKey.isDestroyed());

        } catch (Exception e) {

        }
    }

    public static void destroy(SecretKey myKey) throws IOException {
        try {

            myKey.destroy();

        } catch (Exception e) {

        }
    }
    public static void Exercici8() throws IOException {
        System.out.println();
        System.out.println();
        System.out.println("Exercici 8");
        String text = "Probant BadPaddingException";
        try {
            Xifrar xifrar = new Xifrar();
            int keySize = 128;
            SecretKey mykey2 = xifrar.passwordKeyGeneration("TestError", 128);
            SecretKey myKey = xifrar.passwordKeyGeneration(text, keySize);
            byte[] data = text.getBytes("UTF-8");
            byte[] encryptedData = xifrar.encryptData(mykey2, data);
            String decriptedString = new String(xifrar.decryptData(encryptedData, myKey), "UTF8");
            System.out.println(decriptedString);

        } catch (Exception e) {

        }
    }

    public static void main(String[] args) throws IOException {
       Exercici5();
       Exercici6();
       Exercici7();
       Exercici8();
    }
}
