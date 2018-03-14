import java.util.*;

public class MembershipManagement{
  
  private List<Session> sessions = new ArrayList<Session>();
 private HashMap<String,int[]> memberPaid;
  //private List<Coach> coaches = new ArrayList<Coach>();
  
  public static void main(String args[]){
    
    for (int i = 0; i < 12; i++){
      
      sessions.add(new Session(i));
    }
    
    
    
    System.out.println("Hello World!");
    
  }
  
  
  public ArrayList<String> organizeByPayments(boolean order){
    //2d array create
    int[][] temp; 
    //array of 2 integers, paid & not paid
    int[] paidOrNot = {0,0};
    memberPaid = new HashMap<String,int[]>();
    for (int i = 0; i < sessions.size(); i++){
      temp = sessions.get(i).getMemberReportInfo();
      //loop thru 2d array
      for (int x = 0; x < temp.length; x++){
        if (memberPaid.containsKey(temp[x][0])){
          paidOrNot = memberPaid.get(temp[x][0]);
          if (temp[x][1] == "True"){
            paidOrNot[0]++;
          }
          else{
            paidOrNot[1]++;
          }
          memberPaid.put(temp[x][0], paidOrNot);
        }
        else{
          paidOrNot[0] = 0;
          paidOrNot[1] = 0;
          if (temp[x][1] == "true"){
            paidOrNot[0]++;
          }else{
            paidOrNot[1]++;
          }
          memberPaid.put(temp[x][0], paidOrNot);
        }
      }
    }
  if (order){
    //look for the highest key (name) of paid, second highest of paid....etc.
    HashMap<String,int[]> tempMap;
    tempPaid = memberPaid;
    ArrayList<String> orderedPaid = new ArrayList<String>(); 
    for (int i = 0; i < tempMap.size(); i++){
      int highestVal = -1;
      String highestKey = "";
      Iterator it = tempMap.entrySet().iterator();
      while (it.hasNext()) {
        Map.Entry pair = (Map.Entry)it.next();
        if (pair.getValue()[0] > highestVal){
          highestVal = pair.getValue()[0];
          highestKey = pair.getKey(); //cast to String
        }
        it.remove(); // avoids a ConcurrentModificationException
      }
      orderedPaid.add(highestKey);
      tempMap.remove(HighestKey);
    }
    return orderedPaid;
  }else{
    //look for the highest value of not paid, second highest of not paid... etc.
    HashMap<String,int[]> tempMap;
    tempPaid = memberPaid;
    ArrayList<String> orderedNotPaid = new ArrayList<String>(); 
    for (int i = 0; i < tempMap.size(); i++){
      int highestVal = -1;
      String highestKey = "";
      Iterator it = tempMap.entrySet().iterator();
      while (it.hasNext()) {
        Map.Entry pair = (Map.Entry)it.next();
        if (pair.getValue()[1] > highestVal){
          highestVal = pair.getValue()[1];
          highestKey = pair.getKey();
        }
        it.remove(); // avoids a ConcurrentModificationException
      }
      orderedNotPaid.add(highestKey);
      tempMap.remove(HighestKey);
    }
    return orderedNotPaid;
  }
  
}

public void missedPayments(){
  /*//If the member has not paid more than once, then he will be subject to a penalty fee and possibly exclusion from the group.
  ArrayList<String> notPaid = organizeByPayments(false)
    for(x=0;x<notPaid.
  //A reminder will be sent for any member who has skipped at least one payment.
  
  //If the member does not skip a payment for 3 months, he will receive a complimentary discount for 10% off for one class.*/
}

}