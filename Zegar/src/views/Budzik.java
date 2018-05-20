package views;

import java.awt.Toolkit;
import java.time.LocalTime;

import javax.swing.JLabel;

public class Budzik {
	public Budzik() {
		zakoncz = false;
	}
	private boolean zakoncz;
	
	public void koniec() {
		zakoncz = true;
	}
	
	public void budzik(int minuty, JLabel lblLicznik) {
		int temp = minuty;
		zakoncz = false;
		
		Thread watekBudzika = new Thread() {
			boolean warunek = true;
			public void run() {
				int minuty = temp;
				int godziny = 0;
				int sekundy = 0;
				if(minuty<60) {
					godziny = 0;
				}
				else {
					godziny = (minuty-minuty%60)/60;
					minuty = minuty-godziny*60;
					if(godziny>23) {
						godziny = 23;
						minuty = 59;
						sekundy = 59;
					}
				}
				
				try {
					LocalTime wpisanyCzas = LocalTime.of(godziny, minuty, sekundy);
					
					while(warunek && zakoncz==false) {
							
						lblLicznik.setText(wpisanyCzas.toString());
						wpisanyCzas = wpisanyCzas.minusSeconds(1);
						
						lblLicznik.setText(wpisanyCzas.toString());
						if(wpisanyCzas.getSecond()==0 && wpisanyCzas.getMinute()==0 && wpisanyCzas.getHour()==0) 
							{
								Dzwiek.odtworz();
								warunek=false;
							}
							else
							{
								sleep(1000);
							}
					}
				}
				catch(InterruptedException e) {
					e.printStackTrace();
				}
				
			}
		};
		
		watekBudzika.start();
	}
}
