import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // use one str -> token, else - readline
        int W = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        Queue<Integer> truck = new LinkedList<Integer>();
        st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++){
            truck.offer(Integer.parseInt(st.nextToken()));
        }

        Queue<Integer> bridge = new LinkedList<Integer>();
        for(int j=0;j<W;j++) {
            bridge.offer(0);
        }
        int time = 0;
        int weight = 0;

        // System.out.println("W: "+ W+ " , L : "+L);
        while(!bridge.isEmpty()) {
            weight -= bridge.poll();

            // System.out.println("weight : " + weight);
            if (!truck.isEmpty()) {
                if (weight + truck.peek() <= L) {
                    int nextT = truck.poll();
                    weight += nextT;
                    bridge.offer(nextT);
                } else {
                    bridge.offer(0);
                }
            }
            time++;
        }
        System.out.println(time);
    }
}
