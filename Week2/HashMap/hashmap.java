import java.util.HashMap;
import java.util.Scanner;
public class hashmap{
    public static void main(String[] args){  
        try(Scanner input = new Scanner(System.in)){
            HashMap<Integer,String> hm = new HashMap<Integer,String>();
            hm.put(1,"January");
            hm.put(2,"February ");
            hm.put(3,"March");
            hm.put(4,"April");
            hm.put(5,"May");
            hm.put(6,"June");
            hm.put(7,"July");
            hm.put(8,"August");
            hm.put(9,"September");
            hm.put(10,"October");
            hm.put(11,"November");
            hm.put(12,"December");
    
            System.out.print("請輸入1～12？");
            int value = input.nextInt();
            while(value>12||value<1){
                System.out.println("範圍錯誤！");
                System.out.print("請輸入1～12？");
                value = input.nextInt();
            }
            System.out.printf("第%d月的英文單字為 %s%n",value,hm.get(value));
        }
    }
}