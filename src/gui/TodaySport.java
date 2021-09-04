package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;

public class TodaySport extends JFrame {
	
	// 상단-center : JRadioButton 5개
	JRadioButton[] button = new JRadioButton[5];
	String[] sports = {"등", "가슴", "어깨", "팔", "하체"};
	ButtonGroup group = new ButtonGroup();
	
	// center : JList 3개
	JList<String> backs;
	JList<String> cnts;
	JList<String> sets;
	
	public TodaySport() {
		
		String pattern = "yyyy/MM/dd";
		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
		
		String date = dateFormat.format(new Date());
		
		setTitle("오늘의 성장");
		
		// 컨테이너 만들기
		JPanel jPanel1 = new JPanel(); // 상단-north
		JPanel jPanel2 = new JPanel(); // 상단-center
		JPanel jPanel3 = new JPanel(new GridLayout(1, 3)); // 상단-south
		JPanel jPanel4 = new JPanel(new GridLayout(1, 3, 5, 5)); // center
		JPanel jPanel5 = new JPanel(); // 하단-north
		JPanel jPanel6 = new JPanel(); // 하단-south
		
		// 컴포넌트 만들기, 컨테이너에 올리기
		// 상단-north : JLabel
		JLabel title = new JLabel("<< " + date + " 운동표 >>");
		jPanel1.add(title);
		
		// 상단-center : JRadioButton 5개
		for(int i=0;i<sports.length;i++) {
			button[i] = new JRadioButton(sports[i]); // 라디오버튼 생성
			group.add(button[i]); // 라디오버튼 그룹화
			jPanel2.add(button[i]); // 컨테이너에  컴포넌트 올리기
		}
		
		// 상단-south : JLabel 3개
		JLabel sportlb = new JLabel("운                     동");
		JLabel countlb = new JLabel(" 횟                     수");
		JLabel setlb = new JLabel(" 세                     트");
		jPanel3.add(sportlb); jPanel3.add(countlb); jPanel3.add(setlb);
		
		// center : JList 3개
		String[] list1 = {"운동1", "운동2", "운동3", "운동4" , "운동5", "운동6", "운동7", "운동8", "운동9"};
		String[] cnt = {"5", "10", "15", "20", "25", "30", "35", "40"};
		String[] set = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
		
		backs = new JList<String>(list1);
		jPanel4.add(new JScrollPane(backs)); // 컨테이너에 컴포넌트 올리기(스크롤바 추가)
		
		cnts = new JList<String>(cnt);
		jPanel4.add(new JScrollPane(cnts)); // 컨테이너에 컴포넌트 올리기(스크롤바 추가)
		
		sets = new JList<String>(set);
		jPanel4.add(new JScrollPane(sets)); // 컨테이너에 컴포넌트 올리기(스크롤바 추가)
		
		// 하단-north : JButton 3개
		JButton sp_add = new JButton("추가");
		JButton sp_confrim = new JButton("확인");
		JButton sp_exit = new JButton("종료");
		jPanel5.add(sp_add); jPanel5.add(sp_confrim); jPanel5.add(sp_exit);
		
		// 하단-center : JTextArea
		JTextArea jta = new JTextArea(5, 20);
		jPanel6.add(new JScrollPane(jta)); // 컨테이너에 컴포넌트 올리기(스크롤바 추가)
		jta.setLineWrap(true); // 자동 줄바꿈
		
		// 프레임에 컨테이너 올리기
		// 상위 컨테이너 만들기 - 상단
		JPanel jGroup1 = new JPanel(new BorderLayout());
		jGroup1.add(jPanel1, BorderLayout.NORTH); // 상단 컨테이너 올리기
		jGroup1.add(jPanel2, BorderLayout.CENTER);
		jGroup1.add(jPanel3, BorderLayout.SOUTH); 
		
		// 상위 컨테이너 만들기 : 하단
		JPanel jGroup2 = new JPanel(new BorderLayout());
		jGroup2.add(jPanel5, BorderLayout.NORTH); 
		jGroup2.add(jPanel6, BorderLayout.CENTER); // 하단 컨테이너 올리기
		
		// 프레임에 상위 컨테이너 올리기
		add(jGroup1, BorderLayout.NORTH);
		add(jPanel4, BorderLayout.CENTER);
		add(jGroup2, BorderLayout.SOUTH);
		
		setBounds(200, 200, 300, 300);
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}

	public static void main(String[] args) {
	
		new TodaySport();

	}

}
