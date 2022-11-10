import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Queue<Integer> wait = new LinkedList<>();
        Stack<Integer> space = new Stack<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++){
            wait.offer(Integer.parseInt(st.nextToken()));
        }

        int start = 1;

        while(!wait.isEmpty()){
            if(wait.peek() == start){
                wait.poll();
                start++;
            } else if (!space.isEmpty() && space.peek() == start) {
                space.pop();
                start++;
            }else {
                space.push(wait.poll());
            }
        }
        while(!space.isEmpty()){
            if(space.peek() == start){
                space.pop();
                start++;
            }else {
                System.out.println("Sad");
                return;
            }
        }
        System.out.println("Nice");
    }
}
