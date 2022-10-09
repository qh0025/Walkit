package com.mycompany.a1;
import com.codename1.ui.Form;
import com.codename1.ui.events.ActionListener; 
import com.codename1.ui.Label; 
import com.codename1.ui.TextField; 
import com.codename1.ui.events.ActionEvent; 
import java.lang.String; 


public class Game extends Form
{
	private GameWorld gw;
	
	public Game()
	{
		gw = new GameWorld();
		gw.init();
		play();
	}

	private void play() 
	{ 
		Label myLabel=new Label("Enter a Command:"); 
		this.addComponent(myLabel); 
		final TextField myTextField=new TextField(); 
		this.addComponent(myTextField); 
		this.show(); 
 
		myTextField.addActionListener(new ActionListener()
		{ 
 
			public void actionPerformed(ActionEvent evt) 
			{ 
     
				String sCommand=myTextField.getText().toString(); 
				myTextField.clear(); 
				if(sCommand.length() != 0) 
					switch (sCommand.charAt(0)) 
					{ 
					case 'a': 
	    				gw.accelerate();  
	    				break;
	    			case 'b': 
	    				gw.brake();  
	    				break; 
	    			case 'l': 
	    				gw.steerLeft();  
	    				break; 
	    			case 'r': 
	    				gw.steerRight();  
	    				break; 
	    			case 'f': 
	    				gw.collideFood();  
	    				break; 
	    			case 'g': 
	    				gw.collideSpider();  
	    				break; 
	    			case 't': 
	    				gw.addTime();  
	    				break; 
	    			case 'd': 
	    				gw.display();  
	    				break; 
	    			case 'm': 
	    				gw.map();  
	    				break; 
	    			case '1': 
	    				gw.collideFlag(1);  
	    				break;
	    			case '2': 
	    				gw.collideFlag(2);  
	    				break;
	    			case '3': 
	    				gw.collideFlag(3);  
	    				break;
	    			case '4': 
	    				gw.collideFlag(4);  
	    				break;
	    			case '5': 
	    				gw.collideFlag(5);  
	    				break;
	    			case '6': 
	    				gw.collideFlag(6);  
	    				break;
	    			case '7': 
	    				gw.collideFlag(7);  
	    				break;
	    			case '8': 
	    				gw.collideFlag(8);  
	    				break;
	    			case '9': 
	    				gw.collideFlag(9);  
	    				break;
	    			case 'x': 
	    				System.out.println("Are you sure you want to quit? (Y/N)");  
	    				break;
	    			case 'n': 
	    				System.out.println("The Fight Continues...");  
	    				break; 
	    			case 'y': 
	    				System.out.println("Til Next Time!");
	    				System.exit(0);
	    				
      
					} 
			}  
		} 
	  );

	}

}