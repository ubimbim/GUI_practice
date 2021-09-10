package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;

public class SportRoutine extends JFrame {
	
	String[] name1 = {"등운동1", "등운동2", "등운동3", "등운동4", "등운동5"};
	String[] name2 = {"가슴운동1", "가슴운동2", "가슴운동3", "가슴운동4", "가슴운동5"};
	String[] name3 = {"어깨운동1", "어깨운동2", "어깨운동3", "어깨운동4", "어깨운동5"};
	String[] name4 = {"팔운동1", "팔운동2", "팔운동3", "팔운동4", "팔운동5"};
	String[] name5 = {"하체운동1", "하체운동2", "하체운동3", "하체운동4", "하체운동5"};
 	
	JComboBox<String> combo1;
	
	public SportRoutine() {
		
		setTitle("운동표");
		
		String pattern = "yyyy/MM/dd";
		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
		
		String date = dateFormat.format(new Date());
		
		JPanel container1 = new JPanel();
		JPanel container2 = new JPanel();
		JPanel container3 = new JPanel(new GridLayout(2, 3, 5, 5));
		JPanel container4 = new JPanel();
		
		JLabel title = new JLabel("<< " + date + " 운동표 >>");
		title.setFont(new Font("굴림체", Font.BOLD, 15));
		title.setForeground(Color.DARK_GRAY);
		
		JRadioButton rb1 = new JRadioButton("등");
		JRadioButton rb2 = new JRadioButton("가슴");
		JRadioButton rb3 = new JRadioButton("어깨");
		JRadioButton rb4 = new JRadioButton("팔");
		JRadioButton rb5 = new JRadioButton("하체");
		
		ButtonGroup group = new ButtonGroup();
		group.add(rb1); group.add(rb2); group.add(rb3);
		group.add(rb4); group.add(rb5);
		
		JLabel label1 = new JLabel("운동");
		JLabel label2 = new JLabel("횟수");
		JLabel label3 = new JLabel("세트");
		
		String[] cnt = {"5", "10", "15", "20", "25", "30", "35", "40"};
		String[] set = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};

		combo1 = new JComboBox<String>();
		JComboBox<String> combo2 = new JComboBox<String>(cnt);
		JComboBox<String> combo3 = new JComboBox<String>(set);
		
		JButton sp_add = new JButton("추가");
		JButton sp_confrim = new JButton("완료");
		JButton sp_exit = new JButton("종료");
		
		JTextArea jta = new JTextArea(5, 20);
		JScrollPane jsp = new JScrollPane(
				jta, 
				ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, 
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		jta.setLineWrap(true);
		
		container1.add(title);
		
		container2.add(rb1); container2.add(rb2); container2.add(rb3);
		container2.add(rb4); container2.add(rb5);
		
		container3.add(label1); container3.add(label2); container3.add(label3);
		container3.add(combo1); container3.add(combo2); container3.add(combo3);
		
		container4.add(sp_add); container4.add(sp_confrim); container4.add(sp_exit);
		
		JPanel jGroup1 = new JPanel(new BorderLayout());
		JPanel jGroup2 = new JPanel(new BorderLayout());
		
		jGroup1.add(container1, BorderLayout.NORTH);
		jGroup1.add(container2, BorderLayout.SOUTH);
		
		jGroup2.add(container4, BorderLayout.NORTH);
		jGroup2.add(jsp, BorderLayout.CENTER);
		
		add(jGroup1, BorderLayout.NORTH);
		add(container3, BorderLayout.CENTER);
		add(jGroup2, BorderLayout.SOUTH);
		
		setBounds(200, 200, 350, 350);
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		rb1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(rb1.isSelected()) {
					label1.setText("등 운동");
					
					combo1.removeAllItems();
					
					for(int i=0;i<name1.length;i++) {
						combo1.addItem(name1[i]);
					}
				}
		
			}
		});
		
		rb2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(rb2.isSelected()) {
					label1.setText("가슴 운동");
					
					combo1.removeAllItems();
					
					for(int i=0;i<name2.length;i++) {
						combo1.addItem(name2[i]);
					}
				}
				
			}
		});
		
		rb3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(rb3.isSelected()) {
					label1.setText("어깨 운동");
					
					combo1.removeAllItems();
					
					for(int i=0;i<name3.length;i++) {
						combo1.addItem(name3[i]);
					}
				}
				
			}
		});
		
		rb4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(rb4.isSelected()) {
					label1.setText("팔 운동");
					
					combo1.removeAllItems();
					
					for(int i=0;i<name4.length;i++) {
						combo1.addItem(name4[i]);
					}
				}
				
			}
		});
		
		rb5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(rb5.isSelected()) {
					label1.setText("하체 운동");
					
					combo1.removeAllItems();
					
					for(int i=0;i<name5.length;i++) {
						combo1.addItem(name5[i]);
					}
				}
				
			}
		});
		
		// 추가(sp_add)버튼 이벤트
		sp_add.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String name = combo1.getSelectedItem().toString();
				String cnt = combo2.getSelectedItem().toString();
				String set = combo3.getSelectedItem().toString();
				
				jta.append(name + ", " + cnt + "회, " + set + "세트\n");
				
			}
		});

	}

	public static void main(String[] args) {
		
		new SportRoutine();

	}

}
