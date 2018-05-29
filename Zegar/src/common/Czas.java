package common;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JLabel;

public class Czas
{
	
public static void zegar(JLabel lblDzien, JLabel lblCzas) {
		
		Thread watek = new Thread() {
			public void run() {
				try {
					while(true) {
						Calendar kalendarz = new GregorianCalendar();
						
						String rok = Integer.toString(kalendarz.get(Calendar.YEAR));
						String miesiac = Integer.toString(kalendarz.get(Calendar.MONTH)+1);
						String dzien = Integer.toString(kalendarz.get(Calendar.DAY_OF_MONTH));
						
						String godzina = Integer.toString(kalendarz.get(Calendar.HOUR_OF_DAY));
						String minuta = Integer.toString(kalendarz.get(Calendar.MINUTE));
						String sekunda = Integer.toString(kalendarz.get(Calendar.SECOND));
						
						if(miesiac.length()==1) miesiac = "0"+miesiac;
						if(dzien.length()==1) dzien = "0"+dzien;
						if(godzina.length()==1) godzina = "0"+godzina;
						if(minuta.length()==1) minuta = "0"+minuta;
						if(sekunda.length()==1) sekunda = "0"+sekunda;
						
						lblDzien.setText(dzien + "/" + miesiac + "/" + rok);
						lblCzas.setText(godzina + ":" + minuta + ":" + sekunda);
						
						sleep(1000);	
					}
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		watek.start();
		
	}
	
}
