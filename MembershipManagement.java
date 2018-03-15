import java.util.*;

public class MembershipManagement{

    private static List<Session> sessions;
    private static ArrayList<MemberFee> fees;
    private static MessageSystem messageSystem;

    //Initialize  the HashMap from the memberPayments method
    private static HashMap<String,int[]> memberPaid;

    //private List<Coach> coaches = new ArrayList<Coach>();

    public static void main(String args[])
    {
        List<Session> sessions = new ArrayList<Session>();
        MessageSystem messageSystem = new MessageSystem();

        for (int i = 0; i < 12; i++){

            sessions.add(new Session(i));
        }

        memberPaid = memberPayments();
        fees = createFees();

        //test:How to use MessageSystem
        messageSystem.CreateMessage("Elton","Practice on Thursday Be There or be Square");
        messageSystem.CreateMessage("Elton","Can u Switch Shifts with me");
        messageSystem.CreateMessage("Ahmad","Pay ur Fucking Bills");
        messageSystem.ShowMessages("Elton");
        //end of Test
    }

    /*
     * Orders the member names by most payments to least payments and vice versa
     * @param order true for ordering high to low, false for low to high
     * @return returns an arraylist of  string names ordered depending on the parameter value
     * */
    public static ArrayList<String> organizeByPayments(boolean order){
        HashMap<String,int[]> tempMap;
        tempMap = memberPaid;
        ArrayList<String> orderedNames = new ArrayList<String>();
        int highestVal;
        String highestKey;

        //If the order is from highest to lowest
        if (order){
            //look for the highest key (name) of paid, second highest of paid....etc.
            for (int i = 0; i < tempMap.size(); i++){
                highestVal = -1;
                highestKey = "";
                //iterate over key
                for (String key : tempMap.keySet()){
                    if (tempMap.get(key)[1] > highestVal){
                        highestVal = tempMap.get(key)[1];
                        highestKey = key; //cast to String
                    }
                }
                orderedNames.add(highestKey);
                tempMap.remove(highestKey);
            }
        }
        else{ //Orders from least payments to most payments
            //look for the highest value of not paid, second highest of not paid... etc.
            for (int i = 0; i < tempMap.size(); i++){
                highestVal = -1;
                highestKey = "";

                //iterate over key
                for (String key : tempMap.keySet()){
                    if (tempMap.get(key)[0] > highestVal){
                        highestVal = tempMap.get(key)[0];
                        highestKey = key; //cast to String
                    }
                }
                orderedNames.add(highestKey);
                tempMap.remove(highestKey);
            }
        }

        return orderedNames;
    }


    /*
     * Creates a HashMap wit the members being the key and an array of integers
     * being the value, the array holds 2 ints first one is the number of sessions
     * paid and the 2nd value is the sessions not paid
     * @return HashMap with string as key and int array as value
     * */
    public static HashMap<String, int[]> memberPayments(){
        //2d array create
        String[][] temp;
        //array of 2 integers, paid & not paid
        int[] paidOrNot = {0,0};
        memberPaid = new HashMap<String,int[]>();
        for (int i = 0; i < sessions.size(); i++){
            temp = sessions.get(i).GetMemberReportInfo();
            //loop thru 2d array
            for (int x = 0; x < temp.length; x++){
                if (memberPaid.containsKey(temp[x][0])){
                    paidOrNot = memberPaid.get(temp[x][0]);
                    if (temp[x][1] == "True")
                    {
                        paidOrNot[0]++;
                    }
                    memberPaid.put(temp[x][0], paidOrNot);
                }
                else{
                    paidOrNot[0] = 0;
                    paidOrNot[1] = 0;

                    if (temp[x][1] == "true")
                    {
                        paidOrNot[0]++;
                    }

                    memberPaid.put(temp[x][0], paidOrNot);
                }
            }
        }

        HashMap<String, int[]> tempMap = updatePaymentsDue();

        for (Map.Entry<String, int[]> entry : tempMap.entrySet()) {
            String key = entry.getKey();
            int[] value = entry.getValue();

            paidOrNot = memberPaid.get(key);
            paidOrNot[1] = value[0];

            memberPaid.put(key, paidOrNot);
        }

        return memberPaid;
    }


    private static HashMap<String, int[]> updatePaymentsDue() {
        String[][] temp;

        memberPaid = new HashMap<String, int[]>();
        for (int i = 0; i < sessions.size(); i++){
            temp = sessions.get(i).GetMemberReportInfo();

            for (int j = 0; j < temp.length; j++){
                if (!memberPaid.containsKey(temp[j][0])){
                    int[] tempArr = {12 - i};
                    memberPaid.put(temp[j][0], tempArr);
                }
            }
        }

        return memberPaid;
    }


    private static ArrayList<MemberFee> createFees()
    {
        ArrayList<MemberFee> newFees = new ArrayList<MemberFee>();
        int[] paidOrNot = {0,0};

        for (Map.Entry<String, int[]> entry : memberPaid.entrySet()) {
            String key = entry.getKey();
            int[] value = entry.getValue();

            paidOrNot = memberPaid.get(key);

            double fee = paidOrNot[1] * 100;

            newFees.add(new MemberFee(fee, key));
        }

        newFees = missedPayments(newFees);
        newFees = applyDiscount(newFees);
        newFees = applyAttendDiscount(newFees);

        return newFees;
    }


    /*
     * Checks the times the member paid, if they have not paid more than once
     * they receieve a penalty fee, and a message warning of possible exclusion
     * from the group. If the member skips 1 or more payments they will receieve
     * a warning message.
     * */
    public static ArrayList<MemberFee> missedPayments(ArrayList<MemberFee> newFees){
        //If the member has not paid more than once, then he will be subject to a penalty fee and possibly exclusion from the group.
        for (String key : memberPaid.keySet()){
            if (memberPaid.get(key)[1] > 1){
                for (int i = 0; i < newFees.size(); i++){
                    if (newFees.get(i).getName == key){
                        newFees.get(i).applyPenalty(10.0);
                        i = newFees.size();
                    }
                }

                createMessage(key,"Excluded from the group");

                //A reminder will be sent for any member who has skipped at least one payment (1 or more).
                createMessage(key,"Don't forget to make your payment, or you may face serious consequences!");
            }
        }

        return newFees;
    }

    /*
     * //If the member does not skip a payment for 3 months he will
     * receive a complimentary discount for 10% off for one class.
     *
     */
    public static ArrayList<MemberFee> applyDiscount(ArrayList<MemberFee> newFees){
        //if the member did not skip 3 months
        //then
        //fee.applyDiscount(10) 10 percent

        return newFees;
    }

    /*
     * The top 10 people on the list of most practices attended will receive
     * a complimentary discount of %10 off for one class
     */
    public static ArrayList<MemberFee> applyAttendDiscount(ArrayList<MemberFee> newFees) {

        return  newFees;
    }

    /*
     * Creates a message given the name and content of the messsage
     * and sends it to the member
     * @param name takes the name of the member to send the message to
     * @param message the message to send the member
     * */
    public void createMessage(String name,String message)
    {
        messageSystem= new MessageSystem();
        messageSystem.CreateMessage(name,message);
    }

}
