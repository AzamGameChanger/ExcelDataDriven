import org.apache.batik.css.engine.value.css2.SrcManager;

import java.io.IOException;
import java.util.ArrayList;

public class test {
    public static void main(String[] args) throws IOException {
        dataDriven data = new dataDriven();
        ArrayList<String> d= data.getData("BTC");

        for(String a : d){
            System.out.println(a);
        }

    }
}
