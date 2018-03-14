
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
  public void CreateMessage(String message,String name)
  {
    String[] temp = {name,message};
    messages.add(temp);
  }
  
}