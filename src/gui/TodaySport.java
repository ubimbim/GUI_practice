package gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
	// JList<String> chests;
	JList<String> cnts;
	JList<String> sets;
	
	JScrollPane jsp = new JScrollPane();
	
	JPanel jPanel4_1 = new JPanel(new BorderLayout()); // 운동 리스트
	
	public TodaySport() {
		
		String pattern = "yyyy/MM/dd";
		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
		
		String date = dateFormat.format(new Date());
		
		setTitle("오늘의 성장");
		
		// 컨테이너 만들기
		JPanel jPanel1 = new JPanel(); // 상단-north
		JPanel jPanel2 = new JPanel(); // 상단-center
		JPanel jPanel3 = new JPanel(new GridLayout(1, 3)); // 상단-south
		// JPanel jPanel4_1 = new JPanel(new BorderLayout()); jPanel4_1.setVisible(false); // 운동 리스트
		JPanel jPanel4_2 = new JPanel(new BorderLayout()); // 횟수 리스트
		JPanel jPanel4_3 = new JPanel(new BorderLayout()); // 세트 리스트
		// JPanel jPanel4 = new JPanel(new GridLayout(1, 3, 5, 5)); // center
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
		String[] list2 = {"가슴운동1", "가슴운동2", "가슴운동3", "가슴운동4", "가슴운동5"};
		String[] list3 = {"어깨운동1", "어깨운동2", "어깨운동3", "어깨운동4", "어깨운동5"};
		String[] cnt = {"5", "10", "15", "20", "25", "30", "35", "40"};
		String[] set = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
		
		backs = new JList<String>(list1);
		jPanel4_1.add(new JScrollPane(backs)); // 컨테이너에 컴포넌트 올리기(스크롤바 추가)
		jPanel4_1.setVisible(false);
		
		cnts = new JList<String>(cnt);
		jPanel4_2.add(new JScrollPane(cnts), BorderLayout.CENTER); // 컨테이너에 컴포넌트 올리기(스크롤바 추가)
		
		sets = new JList<String>(set);
		jPanel4_3.add(new JScrollPane(sets), BorderLayout.CENTER); // 컨테이너에 컴포넌트 올리기(스크롤바 추가)
		
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
		
		// 상위 컨테이너 만들기 - 리스트
		JPanel jGrouplist = new JPanel(new GridLayout(1, 3, 5, 5));
		jGrouplist.add(jPanel4_1);
		jGrouplist.add(jPanel4_2);
		jGrouplist.add(jPanel4_3);
		
		// 상위 컨테이너 만들기 : 하단
		JPanel jGroup2 = new JPanel(new BorderLayout());
		jGroup2.add(jPanel5, BorderLayout.NORTH); 
		jGroup2.add(jPanel6, BorderLayout.CENTER); // 하단 컨테이너 올리기
		
		// 프레임에 상위 컨테이너 올리기
		add(jGroup1, BorderLayout.NORTH);
		add(jGrouplist, BorderLayout.CENTER);
		add(jGroup2, BorderLayout.SOUTH);
		
		setBounds(200, 200, 300, 300);
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		RbuttonListener listener = new RbuttonListener();
		for(int i=0;i<sports.length;i++) {
			button[i].addActionListener(listener);
		}
		
		// 이벤트처리
		// 추가(sp_add)버튼 클릭 시 선택된 리스트 내용을 하단 텍스트 공간에 추가
		sp_add.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				jta.append(backs.getSelectedValue() +
						", " + cnts.getSelectedValue() + "회, " + 
						sets.getSelectedValue() + "세트\n");
				backs.clearSelection();
				cnts.clearSelection();
				sets.clearSelection();
				
			}
		});
		
		// 확인(sp_confrim)버튼 클릭 시 라디오버튼 선택 초기화
		sp_confrim.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				group.clearSelection(); 
				
			}
		});
		
		// 종료(sp_exit)버튼 클릭 시 종료
		sp_exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
				
			}
		});
		
	}
	
	class RbuttonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			switch(e.getActionCommand()) {
				case "등" : 
					jPanel4_1.setVisible(true);
			}
			
		}
		
	}

	public static void main(String[] args) {
	
		new TodaySport();

	}

}
