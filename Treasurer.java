/**
 * Created by Zamakhshari Abd Al-Ahad on 2018-03-15.
 k*/
public class Treasurer {
 
 public MessageSystem notifications;
 private int paidUp;
 private double treasury;
 
 public Treasurer(double treasury){
     this.notifications = new MessageSystem();
     this.treasury = treasury;
     this.paidUp = 0;
   }
 
 //returns the balance of the treasury
 public double viewTreasury() {
  return this.treasury;
 }
 
 //adds a specified amount to the treasury
 public void addToTreasury(double amount) {
  
  this.treasury += amount;
  
 }
 
 //sets the treasury to a specified amount
  public void setTreasury(double amount) {
   
   this.treasury = amount;
   
  }
 //Cycles through the array of members in a given session and returns the number of members who have paid for that session
  public int paidAccounts(Session current) {
  // this.current = current;
   String[][] temp = current.getMemberReportInfo();
   int paid = 0;
   for (int i = 0; i < temp.length; i++)
         {
             if (temp[i][2] == "true")
             {
              paid++;
             }
         }
   
   return paid;
  }
  
 //Returns a String value containing information pertaining to club revenue, expenses, and profit for the session.
  public String profitInvoice(Session current){
   String[][] temp = current.getMemberReportInfo();
   final int hall_pay = 1500;
   final int coach_pay = 500;
   this.paidUp = paidAccounts(current);
   //Other expenses?
   
   int num_members = temp.length;
   int notPaid = num_members - this.paidUp;
   String ret =  "+-----Monthly Revenue-----+\nMembers: " 
   + num_members 
   + "\nPaid Members:  " + this.paidUp 
   + "\nUnpaid Members: " + notPaid 
   +"\n\nClub Revenue: +" + (this.paidUp * 200) 
   + "$\nClub Expenses: -" + hall_pay + "$ Location rent\n               -" + coach_pay + "$ Coach payment" ;
   return ret;

  }
}
