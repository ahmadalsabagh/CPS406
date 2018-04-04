import java.util.*;
public class Coach
{
  private Session session;
  private String name;
  private int sessionID;
  private ArrayList<int[]> frequency;
  public Coach(Session s,String n,int id)
  {
   session=s;
   name=n;
   sessionID=id;
   initializeArray();
   
    
  }
  public  Session remove(String n)
  {
    
    String[][] members = session.getMemberReportInfo();
    for(int x = 0;x < members.length;x++)
    {
     if(members[x][0].equals(n))
     {
       frequency.remove(x);
     }  
      
    }  
   session.removeMember(n); 
    return session;
  }  
  public Session add(String name, String number, String isPaid, String address)
  {
    int[] empty = {0,0};
   session.addMember(name,number,isPaid,address);
    frequency.add(empty);
   return session;
    
  } 
 
  public int getSessionID()
  {
   return sessionID; 
    
    
  }
  public  Session getSession()
  {
    return session;
  
  }
  public void setSession(Session s)
  {
  session= s;
   
    
  }
  public void initializeArray()
  {
   String[][] temp=session.getMemberReportInfo();
   int[] blank ={0,0};
     for (int x = 0; x < temp.length; x++)
     {
       frequency.add(blank);
       
     }
    
  }  
  public void attendPractice(int[] index)
   {
  int[] temp;
    for(int i =0;i<index.length;i++)
    {
     temp = frequency.get(index[i]);
     temp[1]++;
     frequency.set(index[i],temp);
    }  
  
   }
  
  public void attendSession(int[] index)
   {
  int[] temp;
    for(int i =0;i<index.length;i++)
    {
     temp = frequency.get(index[i]);
     temp[0]++;
     frequency.set(index[i],temp);
    }
   }
  
  public String getName()
  {
    return name;
  }
  
  public void setFrequency(ArrayList<int[]> newFrequency)
  {
      frequency = newFrequency;
  }
  
  public ArrayList<int[]> getFrequency()
  {
   return frequency; 
  }  
}
