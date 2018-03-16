/**
 * Created by Zamakhshari Abd Al-Ahad on 2018-03-15.
 */
public class posEvent {
	
	Session session;
	MemberFee account;
	Treasurer treasurer;
	Coach coach;
	int paidUp;

	public posEvent(Session session, Treasurer treasurer, Coach coach, MemberFee account){
	    this.session = session;
	    this.account = account;
	    this.treasurer = treasurer;
	    this.coach = coach;
	    
	    this.paidUp = paidAccounts(session);
	  }
	
	
	//Cycles through the array of members in a given session and returns the number of members who have paid for that session
	public int paidAccounts(Session current) {
		
		String[][] temp = current.GetMemberReportInfo();
		
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
	public void acceptPayment(int memberId, boolean nextSessionInc) {
		double bill = 0.0;

		String[][] temp = this.session.GetMemberReportInfo();
		
		if (memberId > temp.length) {
			
	            if (temp[memberId][0] == account.getName())
	            {
	            	if (nextSessionInc) {
	    				bill = account.makePayment() + 100; //base class fee is $100
	    			}
	    			
	    			else {
	    				bill = account.makePayment();
	    			}
	    			
	    			System.out.println("Your total is: $" + bill);
	    			//PENDING METHOD OF PAYMENT IN UI
	    			
	    			//increment the number of settled accounts by 1
	    			paidUp++;
	    			
	    			//SEND NOTIFICATION TO COACH AND TREASURER
	    			String notification = String.format("Customer %2d just paid their bill", memberId);
	    			treasurer.notifications.CreateMessage("Customer Paid", notification);
	    			//coach.notifications.CreateMessage("Customer Paid", notification);
	    			
	    			//set isPaid to "true"
	            }
	        	
	            else {
	            	System.out.print("ID does not match name. Please create a new profile and try again");
	            }
			
		}
		
		else {
			System.out.println("INVALID ID. PLEASE CREATE A NEW USER PROFILE AND TRY AGAIN");
		}
		
	}
}
