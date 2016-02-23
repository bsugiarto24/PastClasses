/**
 *SodaMachineFrame
 *@author Bryan Sugiarto
 *@version program7
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.event.*;

public class SodaMachineFrame extends JFrame{
	private JPanel coinPanel,sodaPanel,displayPanel;
	private JButton nickel, quarter, dime, 
				dollar, halfdollar,change;
	private JTextField t, returned,total;
	private SodaMachine m;
	private ArrayList<JButton> buttons;
	
	public SodaMachineFrame(SodaMachine m){
		this.m =m;
		createCoinPanel();
		createDisplayPanel();
		createSodaPanel();
		sodaPanel.setPreferredSize(new Dimension(150,300));
		coinPanel.setPreferredSize(new Dimension(150,300));
		displayPanel.setPreferredSize(new Dimension(150,300));
		pack();
		setVisible(true);
		setResizable(false);
	}

	public void createSodaPanel(){
		class SodaListener implements ActionListener{
			private int index;
			public SodaListener(int index){
				this.index = index;
			}
			public void actionPerformed(ActionEvent arg0) {
				if(m.sufficientFunds()){
					updateReturn(m.dispenseSoda(index));
					update();
					updateSales(m.getSales());
				}
				
			}
		}
		
		buttons = new ArrayList<JButton>();
		for(int i = 0; i<m.getCount(); i++){
			buttons.add(new JButton(m.getSodaName(i)));
			SodaListener s = new SodaListener(i);
			buttons.get(i).addActionListener(s);
			buttons.get(i).setEnabled(false);
		}
		
		sodaPanel= new JPanel();
		sodaPanel.setLayout(new GridLayout(m.getCount(),1));
		
		for(JButton b: buttons){
			sodaPanel.add(b);
		}
		sodaPanel.setBorder(new EtchedBorder());
		getContentPane().add(sodaPanel,BorderLayout.WEST);	
		
	}
	
	public void createDisplayPanel(){
		class ReturnListener implements ActionListener{
			public void actionPerformed(ActionEvent arg0) {
				if(m.getDeposits()!=0){	
					updateReturn(m.returnDeposits());
					update();
				}
			}
		}
		//top Panel
		JPanel top = new JPanel();
		ReturnListener r = new ReturnListener();
		JLabel d = new JLabel("Amount Deposited");
		t = new JTextField(6);
		t.setText("$"+0+"."+"00");
		t.setEditable(false);
		t.setHorizontalAlignment(JTextField.RIGHT);
		change = new JButton("Coin Return");
		change.setEnabled(false);
		change.addActionListener(r);
		top.add(d);
		top.add(t);
		top.add(change);
		top.setBorder(new EtchedBorder());
		
		//Center panel
		JPanel center = new JPanel();
		JLabel ret = new JLabel("Change Returned");
		returned = new JTextField(6);
		returned.setText("$"+0+"."+"00");
		returned.setEditable(false);
		center.add(ret);
		center.add(returned);
		returned.setHorizontalAlignment(JTextField.RIGHT);
		center.setBorder(new EtchedBorder());
		
		//bottom panel
		JPanel bottom = new JPanel();
		JLabel sales = new JLabel("   Total Sales   ");
		total = new JTextField(6);
		total.setText("$"+0+"."+"00");
		total.setEditable(false);
		bottom.add(sales);
		bottom.add(total);
		bottom.setBorder(new EtchedBorder());
		total.setHorizontalAlignment(JTextField.RIGHT);
		
		displayPanel = new JPanel();
		
		displayPanel.setLayout(new GridLayout(3,1));
		displayPanel.add(top,BorderLayout.NORTH);
		displayPanel.add(center,BorderLayout.CENTER);
		displayPanel.add(bottom,BorderLayout.SOUTH);
		displayPanel.setBorder(new EtchedBorder());
		getContentPane().add(displayPanel,BorderLayout.CENTER);	
	}
	
	
	public void createCoinPanel(){
		class Coin implements ActionListener{
			private int amount;
			public Coin(int amount){
				this.amount = amount;
			}
			public void actionPerformed(ActionEvent arg0) {
				m.deposit(amount);
				update();
			}
		}
		
		Coin n = new Coin(5);
		Coin d = new Coin(10);
		Coin q = new Coin(25);
		Coin h = new Coin(50);
		Coin dl = new Coin(100);
		
		nickel = new JButton("Nickel");
		nickel.addActionListener(n);
		dime = new JButton("Dime");
		dime.addActionListener(d);
		quarter = new JButton("Quarter");
		quarter.addActionListener(q);
		halfdollar = new JButton("Half Dollar");
		halfdollar.addActionListener(h);
		dollar = new JButton("Dollar");
		dollar.addActionListener(dl);
		
		coinPanel = new JPanel();
		coinPanel.setLayout(new GridLayout(5,1));
		
		coinPanel.add(nickel);
		coinPanel.add(dime);
		coinPanel.add(quarter);
		coinPanel.add(halfdollar);
		coinPanel.add(dollar);
		coinPanel.setBorder(new EtchedBorder());
		getContentPane().add(coinPanel,BorderLayout.EAST);	
	}
	
	public void update(){
		int money = m.getDeposits();
		if(money>0)
			change.setEnabled(true);
		else
			change.setEnabled(false);
		
		if(m.sufficientFunds()){
			int i = 0;
			for(JButton b: buttons)
			{
				if(m.getSodaCount(i)>0)
					b.setEnabled(true);
				i++;
			}		
		}else{
			for(JButton b: buttons)
			{
					b.setEnabled(false);
			}	
		}
		
		if(money%100==0)
			t.setText("$"+money/100+"."+money%100+"0");
		else
			t.setText("$"+money/100+"."+money%100);
	}
	public void updateReturn(int money){
		if(money%100==0)
			returned.setText("$"+money/100+"."+money%100+"0");
		else
			returned.setText("$"+money/100+"."+money%100);
	}
	public void updateSales(int money){
		if(money%100==0)
			total.setText("$"+money/100+"."+money%100+"0");
		else
			total.setText("$"+money/100+"."+money%100);
	}
}
