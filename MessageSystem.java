<<<<<<< HEAD
//k
import java.util.*;
public class MessageSystem
{
  private ArrayList<String[]> messages;
  
  public MessageSystem()
  {
    messages = new ArrayList<String[]>();
    
  }
  public MessageSystem(ArrayList<String[]> messages)
  {
    this.messages=messages;
  }
  public void createMessage(String name,String message)
  {
    String[] temp = {name,message};
    messages.add(temp);
  }
  public void showMessages(String name)
  {
   for(int x=0;x<messages.size();x++)
   {
     if(messages.get(x)[0]==name)
     System.out.println(messages.get(x)[1]);
   }
  } 
  
}
=======

import java.util.*;
public class MessageSystem
{
  private ArrayList<String[]> messages;
  
  public MessageSystem()
  {
    messages = new ArrayList<String[]>();
    
  }
  public MessageSystem(ArrayList<String[]> messages)
  {
    this.messages=messages;
  }
  public void createMessage(String name,String message)
  {
    String[] temp = {name,message};
    messages.add(temp);
  }
  public ArrayList<String> showMessages(String name)
  {
    ArrayList<String> temp = new ArrayList<String>();
   for(int x=0;x<messages.size();x++)
   {
     if(messages.get(x)[0]==name)
       temp.add(messages.get(x)[1]);
   }
   return temp;
  } 
}
>>>>>>> 3a69da088ab4e7ac02451c70c1a010d9c101abb3
