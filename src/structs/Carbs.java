package organizing

public class Carbs {
	public String carbType;
	public String carbAmount;
	public int carbPercent;
	
	public Carbs(String carb, String amount, int percentage){
		carbType = carb;
		carbAmount = amount;
		carbPercent = percentage;
	}
	
	public Carbs(){
		this("","",0);
	}
	
	public String getType(){
		return carbType;
	}
	
	public String getAmount(){
		return carbAmount;
	}
	
	public int getPercentage(){
		return carbPercent;
	}
	
	public void setType(String newType){
		carbType = newType;
	}
	
	public void setAmount(String newAmount){
		carbAmount = newAmount;
	}
	
	public void setPercent(int newPercent){
		carbPercent = newPercent;
	}
	
	public String toString(){
		return carbType + " " + carbAmount + " " + carbPercent + "%";
	}
}
