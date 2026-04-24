import java.io.*;

public class Lab11Prob01 {
    public static void main(String[] args) {
        DataInputStream in = null;
        DataOutputStream out = null;

        try {
            in = new DataInputStream(new FileInputStream("src/people.dat"));
            out = new DataOutputStream(new FileOutputStream("src/people-copy.dat"));

            while (true) {
            	// Sets variables to the current needed in that line
                int age = in.readInt();
                String name = in.readUTF();
                String address = in.readUTF();
                int zip = in.readInt();
                double salary = in.readDouble();

                // Print to console
                System.out.printf("%d %s %s %d %.2f%n", age, name, address, zip, salary);
            
                // Write exact copy
                out.writeInt(age);
                out.writeUTF(name);
                out.writeUTF(address);
                out.writeInt(zip);
                out.writeDouble(salary);
            }

	         // Catches exceptions specified.
	        } catch (EOFException e) {
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
