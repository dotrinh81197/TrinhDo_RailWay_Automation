package PageObjects.Railway;

public class Ticket {
    String ticketDepartDate;
    String ticketDepartFrom ;
    String ticketArriveAt;
    String ticketSeatType ;
    String ticketTicketAmount;

    public Ticket(String ticketDepartDate, String ticketDepartFrom, String ticketArriveAt, String ticketSeatType, String ticketTicketAmount) {
        this.ticketDepartDate = ticketDepartDate;
        this.ticketDepartFrom = ticketDepartFrom;
        this.ticketArriveAt = ticketArriveAt;
        this.ticketSeatType = ticketSeatType;
        this.ticketTicketAmount = ticketTicketAmount;
    }

    public String getTicketDepartDate() {
        return ticketDepartDate;
    }

    public String getTicketDepartFrom() {
        return ticketDepartFrom;
    }

    public String getTicketArriveAt() {
        return ticketArriveAt;
    }

    public String getTicketSeatType() {
        return ticketSeatType;
    }

    public String getTicketTicketAmount() {
        return ticketTicketAmount;
    }

}
