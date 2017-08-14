package solutions;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;

public class Order implements Serializable {
    private int custId;
    private String name;

    public Order(int id, String n) {
        custId = id;
        name = n;
    }

    public void writeText(String fn) {
        try (PrintWriter pout = 
                new PrintWriter(new FileWriter(fn))) {
            pout.print("ID: ");
            pout.println(custId);
            pout.print("Name: ");
            pout.print(name);
        }
        catch (IOException e) {
            System.err.println(e);
        }
    }

    public void writeBinary(String fn) {
        try (DataOutputStream doutput = 
                new DataOutputStream(new FileOutputStream(fn))) {
            doutput.writeInt(custId);
            doutput.writeUTF(name);
            doutput.close();
        }
        catch (IOException e) {
            System.err.println(e);
        }
    }

    public void writeObj(String fn) {
        try (ObjectOutputStream out = 
                new ObjectOutputStream(new FileOutputStream(fn))) {
            out.writeObject(this);
            out.close();
        }
        catch (IOException e) {
            System.err.println(e);
        }
    }

    public static void main(String[] args) {
        Order o = new Order(23, "Bob Dobbs");
        o.writeText("order.txt");
        o.writeBinary("order.dat");
        o.writeObj("order.ser");
    }
}
