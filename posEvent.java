import java.util.List;

/**
 * Created by Zamakhshari Abd Al-Ahad on 2018-03-15.
 */
public class posEvent {
 
 MembershipManagement membership;
 String usrName;
 int type;

 public posEvent(MembershipManagement membership, String name){
     this.membership = membership;
     this.usrName = name;
     this.type = 0;
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
	 this.type = type;
     double bill = 0.0;

 // String[][] temp = this.session.getMemberReportInfo();k
  
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
        
        for (int i = 0; i < membership.sessions.size(); i ++)
        {
        	membership.sessions.get(i).setIsPaid(findUser(usrName), "true");
        }
        
        //SEND NOTIFICATION TO COACH AND TREASURER
        String notification = String.format("Customer %2d just paid their bill", usrName);
        //treasurer.notifications.CreateMessage("Customer Paid", notification); TODO set up treasurer and coach message system
        //coach.notifications.CreateMessage("Customer Paid", notification);
        
        return bill;
        
  }
 
 public void scheduleSession(int sessionId, int type) {
	 
	 if (type == 1){
	 membership.getSession(sessionId - 1).addMember(usrName, "null", "null", "null");
	 }
	 
	 else if (type == 2)
	 {
		 membership.getSession(sessionId - 1).addMember(usrName, "null", "null", "null");
		 membership.getSession(sessionId).addMember(usrName, "null", "null", "null");
	 }
	 
 }
 
 public int findUser(String userName)
 {
     for (int i = 0; i < membership.sessions.size(); i++)
     {
         String[][] temp = membership.sessions.get(i).getMemberNames();

         for (int j = 0; j < temp.length; j++)
         {
             if (temp[j][0].equals(userName))
             {
                 System.out.println(j);
            	 return j;
             }
         }
     }

     return -1;
 }
  
}
