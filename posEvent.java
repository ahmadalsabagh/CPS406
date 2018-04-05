import java.util.List;

/**
 * Created by Zamakhshari Abd Al-Ahad on 2018-03-15.
 */
public class posEvent {
 
 MembershipManagement membership;
 String usrName;
 int paidUp;

 public posEvent(MembershipManagement membership, String name){
     this.membership = membership;
     this.usrName = name;
    // this.paidUp = paidAccounts();
   }
 
 
 //Cycles through the array of members in a given session and returns the number of members who have paid for that session
 /* public int paidAccounts(Session current) {
  
  String[][] temp = current.getMemberReportInfo();
  
  for (int i = 0; i < temp.length; i++)
        {
            if (temp[i][2] == "true")
            {
             paidUp++;
            }
        } 
  return paidUp;
 } */
 
 
 

 //accepts a member ID and whether or not the customer is paying in advance, determines if the customer already exists and charges them accordingly
 public double acceptPayment(String usrName, int type) {
	 this.usrName = usrName;
  double bill = 0.0;

 // String[][] temp = this.session.getMemberReportInfo();
  
        if (type == 2) {
         bill = membership.getUserFees(usrName).makePayment() + 100; //base class fee is $100
        }
        
        else if (type == 1){
         bill = membership.getUserFees(usrName).makePayment();
        }
        
        else {
        	
        	bill = membership.getUserFees(usrName).getFee();
        }
        
        System.out.println("Your total is: $" + bill);
        
        
        
        //increment the number of settled accounts by 1
        paidUp++;
        
        //SEND NOTIFICATION TO COACH AND TREASURER
        String notification = String.format("Customer %2d just paid their bill", usrName);
        //treasurer.notifications.CreateMessage("Customer Paid", notification); TODO set up treasurer and coach message system
        //coach.notifications.CreateMessage("Customer Paid", notification);
        
        return bill;
        
  }
 
 public void scheduleSession(int sessionId) {
	 
	 membership.getSession(sessionId - 1).addMember(usrName, "0", "true", "180 Bloor St. W");
	 
 }
  
}
