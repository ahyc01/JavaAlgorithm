import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class baekjoon_13417 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        while (T != 0) {
            int N = Integer.parseInt(br.readLine());
            Deque<String> deque = new LinkedList<>();

            StringTokenizer st = new StringTokenizer(br.readLine());
            deque.addFirst(st.nextToken());

            while (N != 1) {
                String Spelling = st.nextToken();
                if (deque.getFirst().compareTo(Spelling) >= 0) { // 문자열 비교 compareTo() -1 0 1 deque.getFirst() Spelling 을 비교
                    deque.addFirst(Spelling);
                }
                else {
                    deque.addLast(Spelling);
                }
                N--;
            }
            while(!deque.isEmpty()) {
                bw.write(deque.pollFirst());
            }
            bw.write("\n");
            T--;
        }
        bw.close();
    }
}
