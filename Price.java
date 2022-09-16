class Ticket{

    int ticketNumber;
    public Ticket(int TN){

        ticketNumber = TN;
    }

    public int getTicketNumber(){
        return ticketNumber;
    }
}

class adultAdvanceTicket extends Ticket{
    public adultAdvanceTicket(int TN) {
        super(TN);
    }
    public float getAdultPrice(){
        return 20;
    }
}

public class Price {
    public static void main(String[]args) {
        adultAdvanceTicket test = new adultAdvanceTicket(321);
        System.out.println(test.getTicketNumber());
        System.out.println(test.getAdultPrice());
    }
}
