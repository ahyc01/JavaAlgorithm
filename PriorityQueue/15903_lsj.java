import java.io.BufferedReader; // Scanner와 유사, 입력된 데이터가 바로 전달되지 않고 버퍼를 거쳐 전달되므로 System.out.println()보다 데이터 처리 효율성(속도)을 높임
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import java.util.StringTokenizer;
import java.util.PriorityQueue;

public class baekjoon_15903 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        PriorityQueue<Long> pq = new PriorityQueue<>(); // 우선순위 큐 선언 (낮은 숫자 순으로 우선순위 결정), 이진트리 힙으로 구성됨 O(log(n))

        st = new StringTokenizer(br.readLine());
        while(n != 0) {
            pq.offer(Long.valueOf(st.nextToken()));
            n--;
        }

        while(m != 0) {
            if(pq.size() >= 2) {
                Long sum = pq.poll();
                sum += pq.poll();

                pq.offer(sum);
                pq.offer(sum);
            }
            m--;
        }

        Long result = 0L;
        while(!pq.isEmpty()) {
            result += pq.poll();
        }

        bw.write(result + "\n");
        bw.close();
    }
}
