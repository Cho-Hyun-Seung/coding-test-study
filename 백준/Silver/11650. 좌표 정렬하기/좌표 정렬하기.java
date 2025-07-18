import java.util.*;
import java.io.*;

public class Main{
    static class Coordinate{
        int x;
        int y;

        Coordinate(int x , int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int length = Integer.parseInt(br.readLine());
        List<Coordinate> coord = new ArrayList<>();

        while(length-- > 0){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            coord.add(new Coordinate(x, y));
        }

        coord.sort((a, b) -> {
            if(a.x == b.x){
                return a.y - b.y;
            }
            return a.x - b.x;
        });

        for(Coordinate cd: coord){
            sb.append(cd.x).append(" ").append(cd.y).append("\n");
        }

        System.out.println(sb);
    }
}