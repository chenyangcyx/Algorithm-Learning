import QuestionBank.No781RabbitsinForest;

public class Main {
    public static void main(String[] args) {
        No781RabbitsinForest rf=new No781RabbitsinForest();
        System.out.println(rf.numRabbits(new int[]{1,1,2}));
        System.out.println(rf.numRabbits(new int[]{10,10,10}));
        System.out.println(rf.numRabbits(new int[]{}));
        System.out.println(rf.numRabbits(new int[]{1,0,1,0,0}));
        System.out.println(rf.numRabbits(new int[]{0,0,1,1,1}));
    }
}
