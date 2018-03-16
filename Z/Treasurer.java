/**
 * Created by Zamakhshari Abd Al-Ahad on 2018-03-15.
 */
public class Treasurer {
	
	public MessageSystem notifications;
	private int paidUp;
	double treasury;
	
	public Treasurer(double treasury){
	    this.notifications = new MessageSystem();
	    this.treasury = treasury;
	  }
	
	//returns the balance of the treasury
	public double viewTreasury() {
		return treasury;
	}
	
	//adds a specified amount to the treasury
	public void addToTreasury(double amount) {
		
		treasury = treasury + amount;
		
	}
	
	//sets the treasury to a specified amount
		public void setTreasury(double amount) {
			
			treasury = amount;
			
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
}
