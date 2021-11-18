package homework4;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class Customer implements Serializable {
    public static void main(String[] args)  {
//        List<Customer> customers = new ArrayList<>();
//        customers.add(new Customer("Artashes", null, 10,"7894 4567 1234 0012"));
//        customers.add(new Customer("Artavazd", null, 12,"7894 4567 1234 0892"));
//        customers.add(new Customer("Tigran", null, 8,"7894 4567 8534 0012"));
//        String path = "C:\\Users\\Student\\Projects_Grigor_Tumanyan\\homework4.2\\customer.txt";
//        Customer.write(customers, path);
//        read(path);
        final String encode = encode("7856 1258 8745 4567");
        System.out.println(("It's encode " + encode));
        System.out.println("It's decode " + decode(encode));

    }

    private String name;
    private String phone;
    private int score;
    private String numberCreditCard;

    public Customer(String name, String phone, int score, String numberCreditCard) {
        this.name = name;
        this.phone = phone;
        this.score = score;
        this.numberCreditCard = numberCreditCard;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public int getScore() {
        return score;
    }

    public String numberCreditCard() {
        return numberCreditCard;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", score=" + score +
                '}';
    }

    public static void createFile(String path) {
        try {
            if (!Files.isExecutable(Path.of(path))) {
                Files.createFile(Path.of(path));
            } else {
                System.err.println("File is exists");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static List<Customer> sortedByScore(List<Customer> customer) {
        return customer.stream()
                .sorted(Comparator.comparing(Customer::getScore)).collect(Collectors.toList());
    }

    public static void writeOFPrint(List<Customer> customers, String path) {
        createFile(path);
        try (FileWriter fw = new FileWriter(path);
             BufferedWriter bf = new BufferedWriter(fw);
             PrintWriter pw = new PrintWriter(bf)) {
            for (Customer customer : customers) {
                pw.println(customer.getName());
                pw.println(customer.getPhone());
                pw.println(customer.getScore());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readOfScanner(String path) throws FileNotFoundException {
        File file = new File(path);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }
        scanner.close();
    }

    public static void read(String path) {
        Object obj = null;
        try (FileInputStream fileInput = new FileInputStream(path);
             ObjectInputStream objectInput = new ObjectInputStream(fileInput)) {
            while ((!((obj = objectInput.readObject()) instanceof Customer))) {
                System.out.println(((Customer) obj).name + ((Customer) obj).phone + ((Customer) obj).score);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void write(List<Customer> customers, String path) {
        createFile(path);
        try (FileOutputStream fileOutputStream = new FileOutputStream(path);
             ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream)) {
            for (Customer customer : customers) {
                outputStream.writeObject(customer.getName());
                outputStream.writeObject(customer.getPhone());
                outputStream.writeObject(customer.getScore());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String encode(String numberCreditCard) {
        Base64.Encoder encoder = Base64.getEncoder();
        final byte[] encode = encoder.encode(numberCreditCard.getBytes());
        return new String(encode);
    }
    public static String decode(String numberCreditCard) {
        Base64.Decoder decoder = Base64.getDecoder();
        final byte[] decode = decoder.decode(numberCreditCard);
        return new String(decode);
    }

}
