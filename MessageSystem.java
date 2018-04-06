
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
  public ArrayList<String[]> getMessages()
  {
    return messages;
  }
}
