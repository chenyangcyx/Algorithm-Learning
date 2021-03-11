import CSNotes.BFS.No127WordLadder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> list=new ArrayList(Arrays.asList("cog"));
        System.out.println(new No127WordLadder().ladderLength2("hog","cog",list));
    }
}
