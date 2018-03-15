public class MemberFee{
  
  private int fee;
  private String name;
  
  public MemberFee(int fee, String name){
    this.fee = fee;
    this.name = name;
  }
  
  public void incrementFee(int n){
    this.fee = this.fee + n;
  }
  
  public void decrementFee(int n){
    this.fee = this.fee - n;
  }
  
  public void applyDiscount(int n){
    int price = n/100;
    this.fee = this.fee - (price* this.fee);
  }
  
  public int getFee(){
    return this.fee;
  }
  
  public void setFee(int n){
    this.fee = n;
  }
  
  public String getName(){
    return this.name;
  }
}