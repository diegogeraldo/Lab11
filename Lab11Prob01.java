import java.io.*;

public class Lab11Prob01 {
    public static void main(String[] args) {
        DataInputStream in = null;
        DataOutputStream out = null;

        try {
            in = new DataInputStream(new FileInputStream("src\\people.dat"));
            out = new DataOutputStream(new FileOutputStream("src\\people-copy.dat"));

            while (true) {
                int age = in.readInt();
                String name = in.readUTF();
                String address = in.readUTF();
                int zip = in.readInt();
                double salary = in.readDouble();

                // Print to console
                System.out.println("Age: " + age);
                System.out.println("Name: " + name);
                System.out.println("Address: " + address);
                System.out.println("Zip: " + zip);
                System.out.println("Salary: " + salary);
                System.out.println();

                // Write exact copy
                out.writeInt(age);
                out.writeUTF(name);
                out.writeUTF(address);
                out.writeInt(zip);
                out.writeDouble(salary);
            }

        } catch (EOFException e) {
            System.out.println("Finished reading file.");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) in.close();
                if (out != null) out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
