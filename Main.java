import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

//import com.ibm.jvm.Log;

//import jdk.internal.org.jline.utils.InputStreamReader;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in)) ;
        String[] str = read.readLine().trim().split(" ") ;
        int n = Integer.parseInt(str[0]) ;
        long m = Long.parseLong(str[1]) ;
        str = read.readLine().trim().split(" ") ;
        long[] arr = new long[n] ;
        for(int i=0; i<n; i++) {
            arr[i] = Long.parseLong(str[i]) ;
        }

        long maxCount = 0L ;
        TreeSet<Long> tree = new TreeSet<>() ;
        tree.add(0L) ;
        long prefix = 0L ;
        for(int i=0; i<n; i++) {
            prefix = (prefix + arr[i]) % m ;
            maxCount = Math.max(prefix, maxCount) ;

            Long temp = tree.higher(prefix) ;
            System.out.println(temp);
            if(temp != null) {
                maxCount = Math.max((prefix-temp+m)%m, maxCount) ;
            } 
            
            //System.out.println(maxCount);
            tree.add(prefix) ;
        }

        System.out.println(maxCount);
    }
}