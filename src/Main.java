import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String filePath = "C:\\Java projelerim\\file\\documents.txt";
        CreateFile(filePath);
        InfoFile(filePath);
        WriteFile(filePath, "Ahmet"); // Yazma işlemi burada çağrılıyor
        ReadFile(filePath);
    }

    public static void CreateFile(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            try {
                file.createNewFile();
                System.out.println("Dosya oluşturuldu: " + file.getName());
            } catch (IOException e) {
                throw new RuntimeException("Dosya oluşturulurken hata: " + e.getMessage());
            }
        } else {
            System.out.println("Dosya zaten mevcut: " + file.getName());
        }
    }

    public static void InfoFile(String filePath) {
        File file = new File(filePath);
        if (file.exists()) {
            System.out.println("Dosya adı : " + file.getName());
            System.out.println("Dosya yolu : " + file.getAbsolutePath());
            System.out.println("Dosya okunabilir mi ? : " + file.canRead());
            System.out.println("Dosya yazılabilir mi ? : " + file.canWrite());
            System.out.println("Dosya boyutu (byte cinsinden): " + file.length());
        } else {
            System.out.println("Dosya mevcut değil.");
        }
    }

    public static void ReadFile(String filePath) {
        File file = new File(filePath);
        if (file.exists()) {
            try (Scanner reader = new Scanner(file)) {
                while (reader.hasNextLine()) {
                    String line = reader.nextLine();
                    System.out.println(line);
                }
            } catch (IOException e) {
                System.out.println("Dosya okunurken bir hata oluştu: " + e.getMessage());
            }
        } else {
            System.out.println("Dosya okunamadı çünkü mevcut değil.");
        }
    }

    public static void WriteFile(String filePath, String content) {
        File file = new File(filePath);
        try (FileWriter writer = new FileWriter(file, true)) { // 'true' eklemek dosyayı sonuna yazmak için
            writer.write(content + System.lineSeparator()); // İçeriği yaz
            System.out.println("İçerik dosyaya yazıldı: " + content);
        } catch (IOException e) {
            System.out.println("Dosyaya yazılırken bir hata oluştu: " + e.getMessage());
        }
    }
}


