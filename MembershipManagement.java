import javax.swing.*;
import java.io.*;
import java.util.*;

public class MembershipManagement{

    private List<Session> sessions;
    private ArrayList<MemberFee> fees;
    private MessageSystem messageSystem;

    //Initialize  the HashMap from the memberPayments method
    private HashMap<String,int[]> memberPaid;

    private List<Coach> coaches = new ArrayList<Coach>();

    public MembershipManagement()
    {
        List<Session> sessions = loadSessionData();

        //Load Coach's, Load Treasurers

        //Load messages as well
        MessageSystem messageSystem = new MessageSystem();

        memberPaid = memberPayments();
        fees = createFees();

        //test:How to use MessageSystem
        messageSystem.CreateMessage("Elton","Practice on Thursday Be There or be Square");
        messageSystem.CreateMessage("Elton","Can u Switch Shifts with me");
        messageSystem.CreateMessage("Ahmad","Pay ur Fucking Bills");
        messageSystem.ShowMessages("Elton");
        //end of Test
    }


    public boolean checkUserLogin(String userName)
    {
        boolean isValid = false;
        
        for (int i = 0; i < sessions.size(); i++)
        {
            String[][] temp = sessions.get(i).getMemberNames();

            for (int j = 0; j < temp.length; j++)
            {
                if (temp[j][0] == userName)
                {
                    isValid = true;
                    j = temp.length;
                    i = sessions.size();
                }
            }
        }

        return isValid;
    }
    
    
    public boolean checkCoachLogin(String coachName)
    {
        return true;
    }

    
    public boolean checkTreasurerLogin(String treasurerLogin)
    {
        return true;
    }


    /*
     * Using the list of members, organize the members by the amount of times they have attended practice at the club.
     */
    public ArrayList<String> organizeByAttendance(){
        HashMap<String,int[]> tempMap = new HashMap<String,int[]>();
        ArrayList<int[]> temp;
        String[][] temp2;
        int[] frequency;

        for (int i = 0; i < coaches.size(); i++)
        {
            temp = coaches.get(i).getFrequency();
            temp2 = sessions.get(i).getMemberReportInfo();

            for (int j = 0; j < temp.size(); i++)
            {
                if(tempMap.containsKey(temp2[j][0]))
                {
                    frequency = tempMap.get(temp2[j][0]);

                    frequency[0] += temp.get(j)[1];

                    tempMap.put(temp2[j][0], frequency);
                }
                else
                {
                    frequency = new int[1];
                    frequency[0] = 0;

                    tempMap.put(temp2[j][0], frequency);
                }
            }
        }

        return sortHashMap(tempMap, 0);
    }


    /*
     * Function to sort a hash map
     */
    public ArrayList<String> sortHashMap (HashMap<String,int[]> tempMap, int index)
    {
        ArrayList<String> orderedNames = new ArrayList<String>();
        int highestVal;
        String highestKey;

        //look for the highest key (name) of paid, second highest of paid....etc.
        for (int i = 0; i < tempMap.size(); i++){
            highestVal = -1;
            highestKey = "";

            //iterate over key
            for (String key : tempMap.keySet()){
                if (tempMap.get(key)[index] > highestVal){
                    highestVal = tempMap.get(key)[index];
                    highestKey = key; //cast to String
                }
            }

            orderedNames.add(highestKey);
            tempMap.remove(highestKey);
        }

        return orderedNames;
    }


    /*
     * Orders the member names by most payments to least payments and vice versa
     * @param order true for ordering high to low, false for low to high
     * @return returns an arraylist of  string names ordered depending on the parameter value
     * */
    public ArrayList<String> organizeByPayments(boolean order){
        HashMap<String,int[]> tempMap = memberPaid;
        ArrayList<String> orderedNames = new ArrayList<String>();
        int highestVal;
        String highestKey;

        //If the order is from highest to lowest
        if (order)
        {
            orderedNames = sortHashMap(tempMap, 0);
        }
        //Orders from least payments to most payments
        else
        {
            orderedNames = sortHashMap(tempMap, 1);
        }

        return orderedNames;
    }


    /*
     * Creates a HashMap wit the members being the key and an array of integers
     * being the value, the array holds 2 ints first one is the number of sessions
     * paid and the 2nd value is the sessions not paid
     * @return HashMap with string as key and int array as value
     * */
    public HashMap<String, int[]> memberPayments(){
        //2d array create
        String[][] temp;
        //array of 2 integers, paid & not paid
        int[] paidOrNot = {0,0};
        memberPaid = new HashMap<String,int[]>();
        for (int i = 0; i < sessions.size(); i++){
            temp = sessions.get(i).getMemberReportInfo();
            //loop thru 2d array
            for (int x = 0; x < temp.length; x++){
                if (memberPaid.containsKey(temp[x][0])){
                    paidOrNot = memberPaid.get(temp[x][0]);

                    if (temp[x][1] == "true")
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


    private HashMap<String, int[]> updatePaymentsDue() {
        String[][] temp;

        memberPaid = new HashMap<String, int[]>();
        for (int i = 0; i < sessions.size(); i++){
            temp = sessions.get(i).getMemberReportInfo();

            for (int j = 0; j < temp.length; j++){
                if (!memberPaid.containsKey(temp[j][0])){
                    int[] tempArr = {12 - i};
                    memberPaid.put(temp[j][0], tempArr);
                }
            }
        }

        return memberPaid;
    }


    private ArrayList<MemberFee> createFees()
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
    public ArrayList<MemberFee> missedPayments(ArrayList<MemberFee> newFees){
        //If the member has not paid more than once, then he will be subject to a penalty fee and possibly exclusion from the group.
        for (String key : memberPaid.keySet()){
            if (memberPaid.get(key)[1] > 1){
                for (int i = 0; i < newFees.size(); i++){
                    if (newFees.get(i).getName() == key){
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
    public ArrayList<MemberFee> applyDiscount(ArrayList<MemberFee> newFees){
        //if the member did not skip 3 months

        //iterate over key
        for (String key : memberPaid.keySet()){
            if (memberPaid.get(key)[0] >= 3 && memberPaid.get(key)[1] == 0){
                for (int i = 0; i < newFees.size(); i++)
                {
                    if (newFees.get(i).getName() == key)
                    {
                        newFees.get(i).applyConsecDiscount(10.0);
                        i = newFees.size();
                    }
                }
            }
        }

        return newFees;
    }

    /*
     * The top 10 people on the list of most practices attended will receive
     * a complimentary discount of %10 off for one class
     */
    public ArrayList<MemberFee> applyAttendDiscount(ArrayList<MemberFee> newFees)
    {
        ArrayList<String> orderedNames = organizeByAttendance();
        int temp = 10;

        if (orderedNames.size() < 10)
        {
            temp = orderedNames.size();
        }

        for (int i = 0; i < temp; i++)
        {
            for (int j = 0; j < newFees.size(); j++)
            {
                if (newFees.get(j).getName() == orderedNames.get(i))
                {
                    newFees.get(j).applyAttendDiscount(10.0);
                    j = newFees.size();
                }
            }
        }

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

    /*
     * Loads a file into memory and returns an array containing the file contents
     */
    public String[] loadFile(String fileName)
    {
        String[] result = null;

        try
        {
            File file = new File(fileName);
            Scanner input = new Scanner(file);
            List<String> list = new ArrayList<String>();

            while (input.hasNextLine())
            {
                list.add(input.nextLine());
            }

            Object[] temp = list.toArray();
            result = Arrays.copyOf(temp, temp.length, String[].class);
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage(), fileName + " File Load Exception", JOptionPane.INFORMATION_MESSAGE);
        }

        return result;
    }


    /*
     * Writes a file into memory and returns an array containing the file contents
     */
    public void saveFile(String fileName, String[] fileText)
    {
        try
        {
            Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("filename.txt"), "utf-8"));

            for (String text : fileText)
            {
                writer.write(text);
            }

            writer.close();
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage(), fileName + " File Write Exception", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    /*
     * Function for loading in all the session data from a text file
     */
    public List<Session> loadSessionData()
    {
        List<Session> tempSessions = new ArrayList<Session>();
        List<String[]> loadedData = new ArrayList<String[]>();

        for (int i = 0; i < 12; i++)
        {
            String[] tempArr = loadFile("sessions" + i + ".txt");
            loadedData.add(tempArr);
        }

        for (int i = 0; i < 12; i++)
        {
            Session newSession = new Session(i);

            for (int j = 0; j < loadedData.get(i).length; j++)
            {
                newSession.addMember(loadedData.get(i)[j], loadedData.get(i)[j + 1],
                        loadedData.get(i)[j + 2], loadedData.get(i)[j + 3]);
                j += 3;
            }

            tempSessions.add(newSession);
        }

        return tempSessions;
    }

    /*
     * Function for saving all the session data into a text file
     */
    public void saveSessionData(List<Session> sessions)
    {
        List<String> writeData = new ArrayList<String>();

        for (int i = 0; i < sessions.size(); i++)
        {
            String[][] currMembers = sessions.get(i).getMembers();

            for (int j = 0; j < currMembers.length; j++)
            {
                for (int k = 0; k < currMembers[j].length; k++)
                {
                    writeData.add(currMembers[j][k]);
                }
            }

            Object[] temp = writeData.toArray();
            saveFile("sessions" + i + ".txt", Arrays.copyOf(temp, temp.length, String[].class));
            writeData = new ArrayList<String>();
        }
    }
}
