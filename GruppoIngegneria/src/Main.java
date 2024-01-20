import javax.xml.transform.Result;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Singleton mySingleton = new Singleton();

        List<String> comuni = mySingleton.getComuni();
        for(String s: comuni){
            System.out.print(s + "\n");
        }

    }

}