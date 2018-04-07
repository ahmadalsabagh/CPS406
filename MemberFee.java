//k
public class MemberFee{
  
  private double fee;
  private String name;
  public boolean isPenalty = false;
  public boolean consecApplied = false;
  public boolean attendDiscount = false;
  public int standardFee = 100;
  
  public MemberFee(double fee, String name){
    this.fee = fee;
    this.name = name;
  }
  
  public void incrementFee(double n){
    this.fee += n;
  }
  
  public void decrementFee(double n){
    this.fee -= n;
  }
  
  public void applyConsecDiscount(double n){
    if (!consecApplied){
      double price = n/100;
      this.fee -= (price * standardFee);
      consecApplied = true;
    }
  }
  
  public void applyAttendDiscount(double n){
    if (!attendDiscount){
      double price = n/100;
      this.fee -= (price * standardFee);
      attendDiscount = true;
    }
  }
  
  public void applyPenalty(double n){
    if (!isPenalty){
      incrementFee(n);
      isPenalty = true;
    }
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
  
  public double makePayment(){
    double temp = this.fee;
    isPenalty = false;
    consecApplied = false;
    attendDiscount = false;
    this.fee = 0;
    return temp;
  }
}
