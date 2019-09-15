package tc58;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class p01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strs = sc.nextLine().split(",");
        List<String> stringArrayList = new ArrayList<>();
        for (String i:strs){
            if (stringArrayList.contains(i))
                continue;
            stringArrayList.add(i);
        }
        System.out.println(stringArrayList.size());
    }
}
