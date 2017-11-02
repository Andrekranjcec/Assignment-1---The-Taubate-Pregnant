import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import Models.Baby;
import Models.Gift;

import java.util.ArrayList;

public class BabyRegister{
	
	static ArrayList<Baby> babiesList= new ArrayList<Baby>();
	static ArrayList<Gift> giftsList= new ArrayList<Gift>();
	static Scanner scanner = new Scanner(System.in);
	static Scanner scannerbaby = new Scanner(System.in);
	static Scanner scannergift = new Scanner(System.in);
	static SimpleDateFormat myFormat= new SimpleDateFormat("dd/MM/yyyy HH:mm");
	
	
	public static void main(String args[]){
		String date1="10/10/2017 23:15";
		String date2="31/10/2017 20:10";
		String date3="22/09/2017 10:10";
		
		Date d1= new Date();
		Date d2= new Date();
		
		try {
			d1=myFormat.parse(date1);
			d2=myFormat.parse(date3);
			
		} catch (ParseException e) {
			System.out.println("Error while declaring dates");
		}
		
        // Creating objects from the class Baby & Gift with all types of constructors
		
		Baby b1= new Baby(date2,"Marya",'F'); 
		Baby b2= new Baby(d1,"Mohammed",'M');
		Baby b3= new Baby();
		
	    Gift g1= new Gift("ZAK","Video game",d1);
		Gift g2= new Gift("KATALIN","Iphone 5S with special edition for illness kids",d1);
		Gift g3= new Gift("MARK","a trip to fuji islands",d1);
		
		b3.setBirthday(d2);
		b3.setName("Eduardo");
		b3.setGender('M');
		
		babiesList.add(b1);
		babiesList.add(b2);
		babiesList.add(b3);
		
		giftsList.add(g1);
		giftsList.add(g2);
		giftsList.add(g3);
		
		String userCommand;
		do{
			System.out.println("Say 'Exit', 'Add_new_baby', 'List_babies_by_age', 'List_babies_by_list', 'Add_gift' or 'List_gifts' ");
			userCommand = scanner.next();

			switch(userCommand){
				case "Add_new_baby":
                    addBaby();
					break;
					
				case "List_babies_by_age":
					sortByAge();
					printAll(1);
					break;
					
				case "List_babies_by_list":
					sortByName();
					printAll(1);
					break;
					
                case "Add_gift":
                	addGift();
					break;
					
                case "List_gifts":
                	printAll(2);
					break;

			}
			
		}while(!userCommand.equals("Exit"));

		
	}
	
	
	
	
	
	
	// method to add new baby to the list of babies
	public void addBaby(Baby b){
		babiesList.add(b);
	}
	
	// method to add new gift to the list of gifts
	public void addGift(Gift g){
		giftsList.add(g);
	}

	// method to print one of desired list (baby or gift)
	public static void printAll(int i){
		
		if(i==1){
			
		    for(Baby b: babiesList){
			 
			    System.out.println(b.getName());
			    System.out.println(b.getBirthday());
		   	    System.out.println(b.getGender());
			    System.out.println("-----------------------------------------------");
		 }
		 
		}
		
		if(i==2){
			
			for(Gift g: giftsList){
				System.out.println(g.getName());
				System.out.println(g.getDescription());
				System.out.println(g.getDate());
				System.out.println("-----------------------------------------------");
			}
			
		}
	}
	
	// method to add new baby on getting its data
	public static void addBaby(){

		System.out.println("Say the name of the Baby");
		String name1 = scanner.next();

		System.out.println("Say the birthday of the baby(dd/MM/yyyy HH:mm)");
		Date day1 = new Date();

		boolean validDate1 = false;
		do{
			try{
				day1 = myFormat.parse(scannerbaby.nextLine());
				validDate1 = true;
			}catch(ParseException e){
				System.out.println("Invalid date, type it again");
				validDate1 = false;

			}
		}while(!validDate1);
		System.out.println("Say the gender of the Baby");
		Scanner s1= new Scanner(System.in);
		char gender = s1.next().charAt(0);
		Baby baby= new Baby(day1,name1,gender);
		babiesList.add(baby);
		System.out.println("There is : "+babiesList.size()+" babies registred into the baby list ");
	
	}
	
	// method to add new gift on getting its description and details
	public static void addGift(){
		SimpleDateFormat myFormat1= new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		System.out.println("Say the name of the person who gave the gift");
		String name2 = scanner.next();

		System.out.println("Say the description of the gift");
		String descr= scanner.next();
		
		System.out.println("Say when the gift was given (dd/MM/yyyy HH:mm)");
		Date day2 = new Date();

		boolean validDate2 = false;
		while(!validDate2){
			
			try{
				day2 = myFormat1.parse(scannergift.nextLine());
				validDate2 = true;
			}catch(ParseException e){
				System.out.println("Invalid date, type it again");
				validDate2 = false;
			}
		}
		
		Gift gift= new Gift(name2,descr,day2);
		giftsList.add(gift);
		System.out.println("There is : "+giftsList.size()+" gift in the list ");
	}
	
	// sorting babies by name (alphabetical order)
	public static void sortByName(){	
		
		for(int i=0; i<babiesList.size()-1; i++){
			
			for(int j=i+1; j<babiesList.size(); j++){
				
				Baby b1 = babiesList.get(i);
				Baby b2 = babiesList.get(j);
				
				if(b1.getName().compareTo(b2.getName())>0){
					
					Baby aux = b1;
					babiesList.set(j,aux);
					babiesList.set(i, b2);
				}
				
			}
		}
	}
	
	// sorting babies by age (from the oldest to the youngest)
	public static void sortByAge(){	
		
		for(int i=0; i<babiesList.size()-1; i++){
			
			for(int j=i+1; j<babiesList.size(); j++){
				
				Baby b1 = babiesList.get(i);
				Baby b2 = babiesList.get(j);
				
				if(b1.isOlder(b2)){
					
					Baby aux = b1;
					babiesList.set(j,aux);
					babiesList.set(i, b2);
				}
				
			}
		}
	}
	



}