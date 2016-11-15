
package serializacion2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author oracle
 */
public class Serializacion2 {

    /**
     *
     * @param args
     */
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        String[] cod={"p1","p2","p3"};
        String[] desc ={"parafusos","cravos ","tachas"};
        Double[] prezo ={3.0,4.0,5.0};
        
        Product pr1 = new Product(cod[0],desc[0],prezo[0]);
        Product pr2 = new Product(cod[1],desc[1],prezo[1]);
        Product pr3 = new Product(cod[2],desc[2],prezo[2]);
        
        
        
        ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream("serialtxt.txt"));
        ObjectInputStream reader = new ObjectInputStream(new FileInputStream("serialtxt.txt"));
        
        writer.writeObject(pr1);
        writer.writeObject(pr2);
        writer.writeObject(pr3);
        writer.writeObject(null);
        writer.close();
        
        Object aux= reader.readObject();
        
        while(aux!=null){
            System.out.print(aux);
            aux=reader.readObject();
        }
        reader.close();
    }
    
}
