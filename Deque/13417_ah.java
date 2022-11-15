import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i=0;i<T;i++){
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            Deque<String> cards = new LinkedList<String>();

            for(int j=0; j<N; j++){
                String sCard = st.nextToken();
                int iCard = sCard.charAt(0);
                if(!cards.isEmpty()){
                    int cardFront = cards.peek().charAt(0);
                    if(iCard <= cardFront){
                        cards.offerFirst(sCard);
                    }
                    else{
                        cards.offer(sCard);
                    }
                }
                else{
                    cards.offer(sCard);
                }
            }
            while(!cards.isEmpty()){
                System.out.print(cards.pop());
            }
            System.out.println();
        }
    }
}
