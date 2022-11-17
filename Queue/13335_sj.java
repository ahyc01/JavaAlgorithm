import java.io.BufferedReader; // Scanner와 유사, 입력된 데이터가 바로 전달되지 않고 버퍼를 거쳐 전달되므로 System.out.println()보다 데이터 처리 효율성(속도)을 높임
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.Queue;

public class baekjoon_13335 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int T = 0;
        int weight = 0;
        Queue<Integer> truck = new LinkedList<>();
        Queue<Integer> bridge = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            truck.offer(Integer.parseInt(st.nextToken()));
        }
        for (int i = 0; i < w; i++) { // 다리 길이만큼 Size를 설정해서 T 값 재기
            bridge.offer(0);
        }

        // bridge 0 0 -> 0 7 -> 7 0 -> 0 4 -> 4 5 -> 5 0 -> 0 6 -> 6 0 | -> 0
        // weight 0   -> 7   -> 7   -> 4   -> 9   -> 5   -> 6   -> 6   | -> 0
        while (!bridge.isEmpty()) {
            T += 1;
            weight -= bridge.poll();

            if (!truck.isEmpty()) {
                if (L >= truck.peek() + weight) {
                    weight += truck.peek();
                    bridge.offer(truck.poll()); // poll, peek는 없을 때 null, remove는 Error
                } else {
                    bridge.offer(0);
                }
            }
        }

        bw.write(T + "\n");
        bw.close();
    }
}
