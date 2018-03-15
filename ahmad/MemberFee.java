public class MemberFee{
  
  private double fee;
  private String name;
  
  public MemberFee(double fee, String name){
    this.fee = fee;
    this.name = name;
  }
  
  public void incrementFee(double n){
    this.fee =+ n;
  }
  
  public void decrementFee(double n){
    this.fee =- n;
  }
  
  public void applyDiscount(double n){
    double price = n/100;
    this.fee =- (price * this.fee);
  }
  
  public double getFee(){
    return this.fee;
  }
  
  public void setFee(double n){
    this.fee = n;
  }
  
  public String getName(){
    return this.name;
  }
}