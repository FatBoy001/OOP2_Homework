import java.security.SecureRandom;
import java.util.TreeSet;
import java.util.Iterator;
public class treeset {
    static int ONE_HUNDRED = 100;
    static int SIZE_OF_NUMBER = 10;
    static int RANGE_MAX = 70;
    static int RANGE_MIN = 30;
    public static void main(String[] args) {
        TreeSet ts = new TreeSet<Integer>();
        SecureRandom random = new SecureRandom();
        int counter = 0;

        while(ts.size()<SIZE_OF_NUMBER){
            int randomNumber = random.nextInt(ONE_HUNDRED);
            if(ts.add(randomNumber)){
                counter++;
                System.out.printf("第%d個號碼：%s%n",counter,randomNumber);
            }
            
        }
        Iterator iterator = ts.iterator();
        System.out.printf("物件內元素個數為：%d%n",ts.size());
        System.out.printf("物件內元素的內容：%s%n",ts.toString());
        System.out.printf("第一個元素內容為：%s%n",ts.first());
        System.out.printf("最後一個元素內容：%s%n",ts.last()); 

        while(iterator.hasNext()){
            int value = Integer.parseInt(iterator.next().toString());
            if(RANGE_MIN>value||value>RANGE_MAX)
                iterator.remove();
        }
        System.out.printf("內容介於%d～%d者：%s%n",RANGE_MIN,RANGE_MAX,ts); 
    }
}
