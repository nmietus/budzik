package views;

import java.awt.BorderLayout;
import java.awt.*;
import java.io.*;
import sun.audio.*;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import common.Budzik;
import common.Czas;
import common.Dzwiek;

import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.Toolkit;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.awt.event.ActionEvent;

import java.util.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
public class ZegarGui extends JFrame 
{

	private JPanel contentPane;
	private JTextField interwal;
	private JButton btnNewButton;
	private JLabel lblDzien;
	private JLabel lblCzas;
	private JLabel lblLicznik;

	Budzik b = new Budzik();
	Dzwiek d = new Dzwiek();
	
	private JButton STOP;
	private JLabel lblTest;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					ZegarGui frame = new ZegarGui();
					frame.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
				
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ZegarGui() 
	{
//		addKeyListener(new KeyAdapter() {
//			@Override
//			public void keyReleased(KeyEvent arg0) 
//			{
//				lblTest.setText(lblTest.getText()+arg0.toString());
//			}
//		});
		
		initComponents();
		createEvents();
		Czas.zegar(lblDzien, lblCzas);
	}
	
	
	
	
	/////////////////////////////////////////////////////////////
	//KOD NA TWORZENIE I INICJOWANIE KOMPONENTÓW
	/////////////////////////////////////////////////////////////
	private void initComponents() 
	{
		
	setTitle("Zegar");
	setIconImage(Toolkit.getDefaultToolkit().getImage(ZegarGui.class.getResource("/resources/clock_13.png")));
		
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 450, 300);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	
	btnNewButton = new JButton("Ustaw interwa\u0142");
	
	
	JLabel lblNewLabel = new JLabel("Data:");
	lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
	
	JLabel lblGodzina = new JLabel("Godzina:");
	lblGodzina.setFont(new Font("Tahoma", Font.PLAIN, 18));
	
	interwal = new JTextField();
	interwal.setText("60");
	interwal.setColumns(10);
	
	JLabel lblMinut = new JLabel("minut");
	lblMinut.setFont(new Font("Tahoma", Font.PLAIN, 18));
	
	//Czas time = new Czas();
	lblDzien = new JLabel("Czas");	//label zmieniający czas
	lblDzien.setFont(new Font("Tahoma", Font.PLAIN, 18));
	
	lblCzas = new JLabel("Czas");
	lblCzas.setFont(new Font("Tahoma", Font.PLAIN, 18));
	
	lblLicznik = new JLabel("Licznik");
	lblLicznik.setFont(new Font("Tahoma", Font.PLAIN, 18));
	
	STOP = new JButton("STOP");
	
	lblTest = new JLabel("test");
	
	GroupLayout gl_contentPane = new GroupLayout(contentPane);
	gl_contentPane.setHorizontalGroup(
		gl_contentPane.createParallelGroup(Alignment.TRAILING)
			.addGroup(gl_contentPane.createSequentialGroup()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPane.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblGodzina))
						.addGap(3)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addComponent(lblCzas, GroupLayout.PREFERRED_SIZE, 302, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblDzien, GroupLayout.PREFERRED_SIZE, 302, GroupLayout.PREFERRED_SIZE)))
					.addGroup(gl_contentPane.createSequentialGroup()
						.addContainerGap(221, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(lblLicznik, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(interwal, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblMinut, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(btnNewButton)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(STOP))))
					.addGroup(gl_contentPane.createSequentialGroup()
						.addGap(313)
						.addComponent(lblTest, GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)))
				.addContainerGap())
	);
	gl_contentPane.setVerticalGroup(
		gl_contentPane.createParallelGroup(Alignment.LEADING)
			.addGroup(gl_contentPane.createSequentialGroup()
				.addContainerGap()
				.addComponent(lblTest, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
				.addGap(18)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
					.addComponent(lblNewLabel)
					.addComponent(lblDzien, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
					.addComponent(lblCzas, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
					.addComponent(lblGodzina, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addComponent(lblLicznik, GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
				.addGap(18)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
					.addComponent(interwal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addComponent(lblMinut, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
					.addComponent(btnNewButton)
					.addComponent(STOP))
				.addContainerGap())
	);
	contentPane.setLayout(gl_contentPane);

	
	}

	/////////////////////////////////////////////////////////////
	//KOD NA TWORZENIE EVENTÓW
	/////////////////////////////////////////////////////////////
	private void createEvents() 
	{
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				int budzik = 0;
				try 
				{
					budzik = Integer.parseInt(interwal.getText());
				}
				catch(Exception e) 
				{
					budzik = 0;
				}
				b.budzik(budzik, lblLicznik);
			}
		});
		
		STOP.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				
				b.koniec();
			}
		});
		
		interwal.addKeyListener(new KeyAdapter() 
		{
			@Override
			public void keyReleased(KeyEvent e) 
			{
				int temp = e.getKeyCode();
				if(temp==KeyEvent.VK_ENTER) {
					int budzik = 0;
					try 
					{
						budzik = Integer.parseInt(interwal.getText());
					}
					catch(Exception f) 
					{
						budzik = 0;
					}
					b.budzik(budzik, lblLicznik);
				}
				
			}
		});
		
	}
}
