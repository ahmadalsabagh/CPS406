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
   session.RemoveMember(n); 
    return session;
  }  
  public Session add(String n)
  {
   //session.AddMember(n); 
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
   String[][] temp=session.GetMemberReportInfo();
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
}