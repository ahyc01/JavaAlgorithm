import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i=0;i<T;i++){
            LinkedList<String> keylog = new LinkedList<>();
            String st = br.readLine();

            int idx = 0;
            for(int j=0;j<st.length();j++){
                char key = st.charAt(j);

                if(key == '<'){
                    if(idx != 0 ){
                        idx--;
                    }
                } else if (key =='>') {
                    if(idx < keylog.size()){
                        idx++;
                    }
                }
                else if(key == '-'){
                    if(!keylog.isEmpty()){
                        if(idx == keylog.size()){
                            keylog.removeLast();
                        }
                        else {
                            keylog.remove(idx);
                        }
                        if(idx > 0){
                            idx--;
                        }
                    }
                }
                else{
                    if(idx == keylog.size()){
                        keylog.add(String.valueOf(key));
                    }
                    else {
                        keylog.add(idx, String.valueOf(key));
                    }
                    idx++;
                }
            }
            while(!keylog.isEmpty()){
                System.out.print(keylog.pop());
            }
            System.out.println();
        }
    }
}
