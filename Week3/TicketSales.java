import java.security.SecureRandom;
public class TicketSales {
    public static void main(String[] args){
        TicketMachine machine1 = new TicketMachine("Machine A");
        TicketMachine machine2 = new TicketMachine("Machine B");
        TicketMachine machine3 = new TicketMachine("Machine C");
        TicketMachine machine4 = new TicketMachine("Machine D");
        Thread thread1 = new Thread(machine1);
        Thread thread2 = new Thread(machine2);
        Thread thread3 = new Thread(machine3);
        Thread thread4 = new Thread(machine4);
        Thread tMain = new Thread(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("\n四台機器總共賣出:"+(machine1.salesTicket+machine2.salesTicket+machine3.salesTicket+machine4.salesTicket)+"張票");
        });

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        tMain.start();
    }
}

class TicketMachine extends Thread{
    private static int MAX_TICKET_SELES = 4;
    private static int TICKET = 10000;
    private static SecureRandom random = new SecureRandom();
    public int salesTicket;
    public String machineName;

    public TicketMachine(String machineName){
        this.machineName = machineName;
        salesTicket = 0;
    }

    @Override
    public void run() {
        while(sellTicket(this)){}
        System.out.printf("%s 販售了 %3d 張車票%n",machineName,salesTicket);
    }

    public static boolean sellTicket(TicketMachine machine){
        synchronized(TicketMachine.class){
            if(TICKET<=0) return false;
            int sales = random.nextInt(MAX_TICKET_SELES)+1;
            if(TICKET-sales>=0){
                TICKET = TICKET-sales;
                machine.salesTicket = machine.salesTicket+sales;
            }  
            return true;
        } 
    }  
}
