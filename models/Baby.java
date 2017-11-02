package Models;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Baby {

	private Date birthday=new Date();
	private String name;
    private char gender;

  // Empty constructor
	public Baby(){
		super();
	}

  // Constructor with all arguments
	public Baby(String birthday, String name, char gender) {
		super();
		  SimpleDateFormat myFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		try {
      
		this.birthday = myFormat.parse(birthday);
        }
        catch (Exception e) {
        System.out.println("error , wrong input");
        }
		
		this.name = name;
		this.gender = gender;
	}
    
  // Constructor with all arguments (birthday is a date )
    public Baby(Date birthday, String name, char gender) {
		super();
		this.birthday = birthday;
		this.name = name;
		this.gender = gender;
	}
  
  // Getters and Setters
	
	public void setBirthday(Date birthday){
		this.birthday = birthday;
	}

	public Date getBirthday(){
		return this.birthday;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public char getGender() {
		return gender;
	}


 // If a given kid is older than the current one 
    public boolean isOlder(Baby baby){
    	boolean b = (this.howOld()< baby.howOld()) ? true : false;
    	return b;
    }


 // The actual age of the kid in days
   public int howOld(){
   
   	 Date date = new Date();
	 Date dateBeforeString = this.birthday;
     int actualAge=0;
	 try {
	       Date dateBefore = dateBeforeString;
	       Date dateAfter = date;
	       long difference = dateAfter.getTime() - dateBefore.getTime();
	       float daysBetween = (difference / (1000*60*60*24));
 	       actualAge=(int)daysBetween;
	 } catch (Exception e) {
	       e.printStackTrace();
	 }
	 return actualAge;
   }



}

