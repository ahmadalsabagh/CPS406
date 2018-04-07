/**
 * Created by Zamakhshari Abd Al-Ahad on 2018-03-15.
 k*/
import java.util.*;
public class Treasurer {
 
 public MessageSystem notifications;
 private int paidUp;
 private double treasury;
 public MembershipManagement membership;
 public Treasurer(double treasury){
     this.notifications = new MessageSystem();
     this.treasury = treasury;
     this.membership = new MembershipManagement();
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
             if (temp[i][1] == "true")
             {
              paid++;
             }
         }
   
   return paid;
  }

  public int sessionSum(int month){
    int sum = 0;
    Session session = membership.getSession(month);
    boolean notfound = false;
    ArrayList<MemberFee> temp = new ArrayList<MemberFee>(membership.fees.size());
    for (MemberFee item : membership.fees) temp.add(new MemberFee(item.getFee(), item.getName()));
    String[][] members = session.getMembers();
    for (String[] member : members){
      for (MemberFee fee : temp){
        if (member[0].equals(fee.getName())){
          fee.incrementFee(100);
          notfound = true;
          
        }
      }
     if (!notfound){
       temp.add(new MemberFee(100,member[0]));
       membership.fees.add(new MemberFee(100,member[0]));
     }
    }

    for (int i = 0; i < membership.fees.size(); i++)
    {
        temp.get(i).isPenalty = false;
    }
    for (int i = 0; i < membership.fees.size(); i++)
    {
        temp.get(i).isPenalty = false;
    }
    for (int i = 0; i < membership.fees.size(); i++)
    {
        temp.get(i).isPenalty = false;
    }

   temp = membership.missedPayments(temp);
   temp = membership.applyDiscount(temp);
   temp = membership.applyAttendDiscount(temp);

   for (int i = 0 ; i < temp.size(); i++){
     sum += temp.get(i).getFee() - membership.fees.get(i).getFee() + 100;
   }
      System.out.println(sum);
    return sum;
  }
  
 //Returns a String value containing information pertaining to club revenue, expenses, and profit for the session.
  public String profitInvoice(Session current, int num){
   String[][] temp = current.getMemberReportInfo();
   final int hall_pay = 1500;
   final int coach_pay = 250;
   this.paidUp = paidAccounts(current);
   


   int num_members = temp.length;
   int notPaid = num_members - this.paidUp;
   int total = sessionSum(num) - hall_pay - coach_pay;
   String ret =  "+-----Monthly Revenue-----+\nMembers: " 
   + num_members 
   + "\nPaid Members:  " + this.paidUp 
   + "\nUnpaid Members: " + notPaid 
   +"\n\nThis month's Revenue: +" + sessionSum(num)
   + "$\nClub Expenses: -" + hall_pay
  + "$ Location rent\n                    -" + coach_pay + "$ Coach payment" 
  + "\n\nThis month's Total Profit: " + total + "$";
   return ret;

  }
}
