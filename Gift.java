import java.util.Date;

public class Gift{

	private String nameOfPer;
	private String descr;
	private Date delivDate=new Date();


	public Gift(String nameOfPer,String descr,Date delivDate){
		this.nameOfPer=nameOfPer;
		this.descr=descr;
		this.delivDate=delivDate;
		
	}
	public void setName(String nameOfPer) {
		this.nameOfPer = nameOfPer;
	}

	public String getName() {
		return nameOfPer;
	}
	public void setDescription(String descr) {
		this.descr = descr;
	}

	public String getDescription() {
		return descr;
	}
	
	public void setDate(Date delivDate) {
		this.delivDate = delivDate;
	}

	public Date getDate() {
		return delivDate;
	}
	
}