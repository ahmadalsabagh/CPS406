/**
 * Created by Zamakhshari Abd Al-Ahad on 2018-03-15.
 */
public class posEvent {
 
 Session session;
 String usrName;
 MemberFee account;
 Treasurer treasurer;
 Coach coach;
 int paidUp;

 public posEvent(Session session, Treasurer treasurer, Coach coach, MemberFee account, String name){
     this.session = session;
     this.account = account;
     this.treasurer = treasurer;
     this.coach = coach;
     this.usrName = name;
     this.paidUp = paidAccounts(session);
   }
 
 
 //Cycles through the array of members in a given session and returns the number of members who have paid for that session
 public int paidAccounts(Session current) {
  
  String[][] temp = current.getMemberReportInfo();
  
  for (int i = 0; i < temp.length; i++)
        {
            if (temp[i][2] == "true")
            {
             paidUp++;
            }
        } 
  return paidUp;
 }
 
 
 public Session getSession() {
  return session;
 }


 public void setSession(Session session) {
  this.session = session;
 }


 public MemberFee getAccount() {
  return account;
 }


 public void setAccount(MemberFee account) {
  this.account = account;
 }


 public Treasurer getTreasurer() {
  return treasurer;
 }


 public void setTreasurer(Treasurer treasurer) {
  this.treasurer = treasurer;
 }


 public Coach getCoach() {
  return coach;
 }


 public void setCoach(Coach coach) {
  this.coach = coach;
 }


 //accepts a member ID and whether or not the customer is paying in advance, determines if the customer already exists and charges them accordingly
 public void acceptPayment(String usrName, int type) {
  double bill = 0.0;

 // String[][] temp = this.session.getMemberReportInfo();
  
        if (type == 2) {
         bill = account.makePayment() + 100; //base class fee is $100
        }
        
        else if (type == 1){
         bill = account.makePayment();
        }
        
        else {
        	
        	bill = account.getFee();
        }
        
        System.out.println("Your total is: $" + bill);
        
        session.addMember(usrName, "0", "true", "180 Bloor St. W");
        
        //increment the number of settled accounts by 1
        paidUp++;
        
        //SEND NOTIFICATION TO COACH AND TREASURER
        String notification = String.format("Customer %2d just paid their bill", usrName);
        treasurer.notifications.CreateMessage("Customer Paid", notification);
        //coach.notifications.CreateMessage("Customer Paid", notification);
        
   
  }
  
}
