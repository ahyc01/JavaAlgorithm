import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s, tmp;
        StringTokenizer st;
        int t, n;
        Deque<String> deque = new ArrayDeque<>();

        t = Integer.parseInt(bf.readLine());

        for(int i = 0 ; i < t; i++) {
            n = Integer.parseInt(bf.readLine());
            s = bf.readLine();
            st = new StringTokenizer(s);

            for(int j = 0; j < n; j++) {
                tmp = st.nextToken();

                if(deque.isEmpty()) {
                    deque.add(tmp);
                }
                else if(deque.peekFirst().compareTo(tmp) >= 0){
                    deque.addFirst(tmp);
                }
                else {
                    deque.addLast(tmp);
                }
            }

            while(!deque.isEmpty()) {
                bw.write(deque.pollFirst());
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }
}
