package com.ls.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

import com.ls.bean.StudentInfor;
import com.ls.db.DB;

public class DormitoryManagement extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// public JFrame frame;
	private JTextField inforAdd_number;
	private JTextField inforAdd_name;
	private JTextField inforAdd_class;
	private JTextField inforSeek_content;
	private JTextField inforDelete_content;
	private JTextField inforUpdate_content;
	private JPanel inforAdd;
	private JPanel inforSeek;
	private JPanel inforUpdate;
	private JPanel inforDelete;
	private String inforSeek_selection_item = "学号";
	private String inforUpdate_selection_item = "学号";
	private String inforDelete_selection_item = "学号";
	private String inforAdd_selection_academy = "通信";
	private String inforAdd_selection_item_hostel_floor = "1";// 楼层数
	private String inforAdd_selection_item_hostel_number = "01";// 宿舍号
	private JTable infor_table;
	private List<StudentInfor> listStudentInfors;
	private String[][] arrayStudentinfor;
	private String[] tableTitle = new String[] { "学号", "姓名", "寝室", "班级", "学院" };
	private DefaultTableModel tableModel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DormitoryManagement window = new DormitoryManagement();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DormitoryManagement() {
		showTableData();
		tableModel = new DefaultTableModel(arrayStudentinfor, tableTitle);
		initialize();
	}

	private void showTableData() {
		// TODO Auto-generated method stub
		listStudentInfors = DB.queryAll();
		getStudnetInfor(listStudentInfors);
	}

	private void getStudnetInfor(List<StudentInfor> list) {
		// TODO Auto-generated method stub
		if (list == null) {
			return;
		}
		arrayStudentinfor = new String[list.size()][5];
		for (int i = 0; i < list.size(); i++) {
			StudentInfor studentInfor = list.get(i);
			arrayStudentinfor[i][0] = studentInfor.getStudentNumber();// 学号
			arrayStudentinfor[i][1] = studentInfor.getStudentName();// 姓名
			arrayStudentinfor[i][2] = studentInfor.getStudentHostel();
			arrayStudentinfor[i][3] = studentInfor.getStudentClass();
			arrayStudentinfor[i][4] = studentInfor.getStudentAcademy();
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		// frame = new JFrame();
		setBounds(100, 100, 600, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);// 禁止改变大小
		JPanel function = new JPanel();
		function.setBackground(Color.LIGHT_GRAY);

		JLabel lblNewLabel = new JLabel("\u5BDD\u5BA4\u7BA1\u7406\u7CFB\u7EDF");
		lblNewLabel.setFont(new Font("幼圆", Font.BOLD, 18));

		inforAdd = new JPanel();
		// inforAdd.setVisible(false);
		inforAdd.setBackground(Color.LIGHT_GRAY);

		inforSeek = new JPanel();
		inforSeek.setBackground(Color.LIGHT_GRAY);

		inforDelete = new JPanel();
		inforDelete.setBackground(Color.LIGHT_GRAY);

		JLabel label_8 = new JLabel("\u4FE1\u606F\u5220\u9664");

		JLabel label_9 = new JLabel("\u9009\u62E9\u5220\u9664\u9009\u9879");

		JComboBox inforDelete_selection = new JComboBox();
		inforDelete_selection.addItemListener(new ItemListener() {// 删除条目

					@Override
					public void itemStateChanged(ItemEvent e) {
						// TODO Auto-generated method stub
						if (e.getStateChange() == ItemEvent.SELECTED) {
							inforDelete_selection_item = (String) e.getItem();
						}
					}
				});
		inforDelete_selection.setModel(new DefaultComboBoxModel(new String[] {
				"\u5B66\u53F7", "\u59D3\u540D", "\u5B66\u9662", "\u73ED\u7EA7",
				"\u5BDD\u5BA4\u53F7" }));

		inforDelete_content = new JTextField();
		inforDelete_content.setColumns(10);

		JButton inforDelete_btn_delete = new JButton("\u786E\u8BA4\u5220\u9664");
		inforDelete_btn_delete.addActionListener(this);
		GroupLayout gl_inforDelete = new GroupLayout(inforDelete);
		gl_inforDelete
				.setHorizontalGroup(gl_inforDelete
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_inforDelete
										.createSequentialGroup()
										.addGroup(
												gl_inforDelete
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_inforDelete
																		.createSequentialGroup()
																		.addGap(34)
																		.addComponent(
																				label_9)
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addComponent(
																				inforDelete_selection,
																				GroupLayout.PREFERRED_SIZE,
																				71,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addComponent(
																				inforDelete_content,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(12)
																		.addComponent(
																				inforDelete_btn_delete))
														.addGroup(
																gl_inforDelete
																		.createSequentialGroup()
																		.addGap(216)
																		.addComponent(
																				label_8)))
										.addContainerGap(71, Short.MAX_VALUE)));
		gl_inforDelete
				.setVerticalGroup(gl_inforDelete
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_inforDelete
										.createSequentialGroup()
										.addGap(6)
										.addComponent(label_8)
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addGroup(
												gl_inforDelete
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_inforDelete
																		.createSequentialGroup()
																		.addPreferredGap(
																				ComponentPlacement.UNRELATED)
																		.addComponent(
																				label_9))
														.addGroup(
																gl_inforDelete
																		.createSequentialGroup()
																		.addGap(4)
																		.addGroup(
																				gl_inforDelete
																						.createParallelGroup(
																								Alignment.BASELINE)
																						.addComponent(
																								inforDelete_content,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								inforDelete_btn_delete)
																						.addComponent(
																								inforDelete_selection,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE))))
										.addContainerGap(
												GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)));
		inforDelete.setLayout(gl_inforDelete);

		inforUpdate = new JPanel();
		inforUpdate.setBackground(Color.LIGHT_GRAY);

		JLabel label_10 = new JLabel("\u4FE1\u606F\u4FEE\u6539");

		JLabel label_11 = new JLabel("\u9009\u62E9\u67E5\u8BE2\u9009\u9879");

		JComboBox inforUpdate_selection = new JComboBox();
		inforUpdate_selection.addItemListener(new ItemListener() {// 更新信息条目

					@Override
					public void itemStateChanged(ItemEvent e) {
						// TODO Auto-generated method stub
						if (e.getStateChange() == ItemEvent.SELECTED) {
							inforUpdate_selection_item = (String) e.getItem();
						}
					}
				});

		inforUpdate_selection.setModel(new DefaultComboBoxModel(new String[] {
				"\u5B66\u53F7", "\u59D3\u540D", "\u5B66\u9662", "\u73ED\u7EA7",
				"\u5BDD\u5BA4\u53F7" }));

		inforUpdate_content = new JTextField();
		inforUpdate_content.setColumns(10);

		JButton inforUpdate_btn_modify = new JButton("\u67E5\u8BE2");
		inforUpdate_btn_modify.addActionListener(this);

		JButton inforUpdate_btn_update = new JButton("\u4FEE\u6539");
		inforUpdate_btn_update.addActionListener(this);
		GroupLayout gl_inforUpdate = new GroupLayout(inforUpdate);
		gl_inforUpdate
				.setHorizontalGroup(gl_inforUpdate
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_inforUpdate
										.createSequentialGroup()
										.addGroup(
												gl_inforUpdate
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_inforUpdate
																		.createSequentialGroup()
																		.addGap(34)
																		.addComponent(
																				label_11)
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addComponent(
																				inforUpdate_selection,
																				GroupLayout.PREFERRED_SIZE,
																				71,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addComponent(
																				inforUpdate_content,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				ComponentPlacement.UNRELATED)
																		.addComponent(
																				inforUpdate_btn_modify)
																		.addGap(6)
																		.addComponent(
																				inforUpdate_btn_update))
														.addGroup(
																gl_inforUpdate
																		.createSequentialGroup()
																		.addGap(216)
																		.addComponent(
																				label_10)))
										.addContainerGap(31, Short.MAX_VALUE)));
		gl_inforUpdate
				.setVerticalGroup(gl_inforUpdate
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_inforUpdate
										.createSequentialGroup()
										.addGap(6)
										.addComponent(label_10)
										.addGap(4)
										.addGroup(
												gl_inforUpdate
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																inforUpdate_content,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																inforUpdate_selection,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(label_11)
														.addComponent(
																inforUpdate_btn_modify)
														.addComponent(
																inforUpdate_btn_update))
										.addContainerGap(
												GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)));
		inforUpdate.setLayout(gl_inforUpdate);
		// groupLayout.setAutoCreateGaps(true);

		JLabel label_6 = new JLabel("\u4FE1\u606F\u67E5\u8BE2");

		JLabel label_7 = new JLabel("\u9009\u62E9\u67E5\u8BE2\u9009\u9879");

		JComboBox inforSeek_selection = new JComboBox();// 查询条目
		inforSeek_selection.addItemListener(new ItemListener() {// 选择条目发生变化

					@Override
					public void itemStateChanged(ItemEvent e) {
						// TODO Auto-generated method stub
						if (e.getStateChange() == ItemEvent.SELECTED) {
							inforSeek_selection_item = (String) e.getItem();
							System.out.println(inforSeek_selection_item);
						}
					}
				});
		inforSeek_selection.setModel(new DefaultComboBoxModel(new String[] {
				"\u5B66\u53F7", "\u59D3\u540D", "\u5B66\u9662", "\u73ED\u7EA7",
				"\u5BDD\u5BA4\u53F7" }));

		inforSeek_content = new JTextField();
		inforSeek_content.setColumns(10);

		JButton inforSeek_btn_enture = new JButton("\u786E\u8BA4\u67E5\u8BE2");

		inforSeek_btn_enture.addActionListener(this);

		GroupLayout gl_inforSeek = new GroupLayout(inforSeek);
		gl_inforSeek
				.setHorizontalGroup(gl_inforSeek
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_inforSeek
										.createSequentialGroup()
										.addGroup(
												gl_inforSeek
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_inforSeek
																		.createSequentialGroup()
																		.addGap(34)
																		.addComponent(
																				label_7)
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addComponent(
																				inforSeek_selection,
																				GroupLayout.PREFERRED_SIZE,
																				71,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addComponent(
																				inforSeek_content,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(12)
																		.addComponent(
																				inforSeek_btn_enture))
														.addGroup(
																gl_inforSeek
																		.createSequentialGroup()
																		.addGap(216)
																		.addComponent(
																				label_6)))
										.addContainerGap(46, Short.MAX_VALUE)));
		gl_inforSeek
				.setVerticalGroup(gl_inforSeek
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_inforSeek
										.createSequentialGroup()
										.addGap(6)
										.addComponent(label_6)
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addGroup(
												gl_inforSeek
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																inforSeek_selection,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																inforSeek_btn_enture)
														.addComponent(label_7)
														.addComponent(
																inforSeek_content,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addContainerGap(
												GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)));
		inforSeek.setLayout(gl_inforSeek);

		JLabel label = new JLabel("\u4FE1\u606F\u6DFB\u52A0");

		JLabel label_1 = new JLabel("\u5B66\u53F7");

		inforAdd_number = new JTextField();
		inforAdd_number.setColumns(5);

		JLabel label_2 = new JLabel("\u59D3\u540D");

		inforAdd_name = new JTextField();
		inforAdd_name.setColumns(10);

		JLabel label_3 = new JLabel("\u5BDD\u5BA4\u53F7");

		JComboBox inforAdd_hostel_floor = new JComboBox();// 宿舍楼层
		inforAdd_hostel_floor.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if (e.getStateChange() == ItemEvent.SELECTED) {
					inforAdd_selection_item_hostel_floor = (String) e.getItem();
				}

			}
		});
		inforAdd_hostel_floor.setModel(new DefaultComboBoxModel(new String[] {
				"1", "2", "3", "4", "5", "6" }));
		inforAdd_hostel_floor.setMaximumRowCount(3);

		JComboBox inforAdd_hostel_number = new JComboBox();// 宿舍号
		inforAdd_hostel_number.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if (e.getStateChange() == ItemEvent.SELECTED) {
					inforAdd_selection_item_hostel_number = (String) e
							.getItem();
				}

			}
		});
		inforAdd_hostel_number.setModel(new DefaultComboBoxModel(new String[] {
				"01", "02", "03", "04", "05", "06", "07", "08", "09", "10",
				"11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
				"21", "22", "23", "24", "25", "26", "27", "28", "29", "30" }));
		inforAdd_hostel_number.setMaximumRowCount(5);

		JLabel label_4 = new JLabel("\u73ED\u7EA7");

		inforAdd_class = new JTextField();
		inforAdd_class.setColumns(5);

		JLabel label_5 = new JLabel("\u5B66\u9662");

		JComboBox inforAdd_academy = new JComboBox();// 添加学院信息
		inforAdd_academy.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if (e.getStateChange() == ItemEvent.SELECTED) {
					inforAdd_selection_academy = (String) e.getItem();
					// System.out.println(inforAdd_selection_academy);
				}
			}
		});
		inforAdd_academy.setModel(new DefaultComboBoxModel(new String[] {
				"\u901A\u4FE1", "\u81EA\u52A8\u5316", "\u8BA1\u7B97\u673A",
				"\u4F20\u5A92", "\u7ECF\u7BA1\u3001", "\u9A6C\u514B\u601D",
				"\u6CD5\u5B66" }));

		JButton inforAdd_btn_enture = new JButton("\u786E\u8BA4\u6DFB\u52A0");
		inforAdd_btn_enture.addActionListener(this);
		GroupLayout gl_inforAdd = new GroupLayout(inforAdd);
		gl_inforAdd
				.setHorizontalGroup(gl_inforAdd
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_inforAdd
										.createSequentialGroup()
										.addGroup(
												gl_inforAdd
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_inforAdd
																		.createSequentialGroup()
																		.addContainerGap()
																		.addGroup(
																				gl_inforAdd
																						.createParallelGroup(
																								Alignment.LEADING,
																								false)
																						.addGroup(
																								gl_inforAdd
																										.createSequentialGroup()
																										.addComponent(
																												label_4)
																										.addPreferredGap(
																												ComponentPlacement.RELATED)
																										.addComponent(
																												inforAdd_class))
																						.addGroup(
																								gl_inforAdd
																										.createSequentialGroup()
																										.addComponent(
																												label_1)
																										.addPreferredGap(
																												ComponentPlacement.RELATED)
																										.addComponent(
																												inforAdd_number,
																												GroupLayout.PREFERRED_SIZE,
																												74,
																												GroupLayout.PREFERRED_SIZE)))
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addGroup(
																				gl_inforAdd
																						.createParallelGroup(
																								Alignment.LEADING,
																								false)
																						.addGroup(
																								gl_inforAdd
																										.createSequentialGroup()
																										.addComponent(
																												label_2)
																										.addPreferredGap(
																												ComponentPlacement.RELATED)
																										.addComponent(
																												inforAdd_name,
																												GroupLayout.PREFERRED_SIZE,
																												GroupLayout.DEFAULT_SIZE,
																												GroupLayout.PREFERRED_SIZE))
																						.addGroup(
																								gl_inforAdd
																										.createSequentialGroup()
																										.addComponent(
																												label_5)
																										.addPreferredGap(
																												ComponentPlacement.RELATED)
																										.addComponent(
																												inforAdd_academy,
																												0,
																												GroupLayout.DEFAULT_SIZE,
																												Short.MAX_VALUE)))
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addGroup(
																				gl_inforAdd
																						.createParallelGroup(
																								Alignment.TRAILING)
																						.addGroup(
																								gl_inforAdd
																										.createSequentialGroup()
																										.addComponent(
																												label_3)
																										.addPreferredGap(
																												ComponentPlacement.RELATED)
																										.addComponent(
																												inforAdd_hostel_floor,
																												GroupLayout.PREFERRED_SIZE,
																												GroupLayout.DEFAULT_SIZE,
																												GroupLayout.PREFERRED_SIZE)
																										.addPreferredGap(
																												ComponentPlacement.RELATED)
																										.addComponent(
																												inforAdd_hostel_number,
																												GroupLayout.PREFERRED_SIZE,
																												GroupLayout.DEFAULT_SIZE,
																												GroupLayout.PREFERRED_SIZE))
																						.addComponent(
																								inforAdd_btn_enture)))
														.addGroup(
																gl_inforAdd
																		.createSequentialGroup()
																		.addGap(216)
																		.addComponent(
																				label)))
										.addContainerGap(50, Short.MAX_VALUE)));
		gl_inforAdd
				.setVerticalGroup(gl_inforAdd
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_inforAdd
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(label)
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addGroup(
												gl_inforAdd
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(label_1)
														.addComponent(
																inforAdd_number,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(label_2)
														.addComponent(
																inforAdd_name,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(label_3)
														.addComponent(
																inforAdd_hostel_floor,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																inforAdd_hostel_number,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addGap(18)
										.addGroup(
												gl_inforAdd
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(label_4)
														.addComponent(
																inforAdd_class,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(label_5)
														.addComponent(
																inforAdd_academy,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																inforAdd_btn_enture))
										.addContainerGap(
												GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)));
		inforAdd.setLayout(gl_inforAdd);

		JButton functionBtnAdd = new JButton("\u4FE1\u606F\u6DFB\u52A0");
		functionBtnAdd.addActionListener(this);
		function.add(functionBtnAdd);

		JButton functionBtnSeek = new JButton("\u4FE1\u606F\u67E5\u8BE2");
		functionBtnSeek.addActionListener(this);
		function.add(functionBtnSeek);

		JButton functionBtnUpdate = new JButton("\u4FE1\u606F\u4FEE\u6539");
		functionBtnUpdate.addActionListener(this);
		function.add(functionBtnUpdate);

		JButton functionBtnDelete = new JButton("\u4FE1\u606F\u5220\u9664");
		function.add(functionBtnDelete);
		functionBtnDelete.addActionListener(this);
		gl_inforAdd.setAutoCreateGaps(false);
		gl_inforAdd.setAutoCreateContainerGaps(false);// 设置自动填充与容器间的空隙
		gl_inforDelete.setAutoCreateGaps(false);
		gl_inforDelete.setAutoCreateContainerGaps(false);// 设置自动填充与容器间的空隙
		gl_inforSeek.setAutoCreateGaps(false);
		gl_inforSeek.setAutoCreateContainerGaps(false);// 设置自动填充与容器间的空隙
		gl_inforUpdate.setAutoCreateGaps(false);
		gl_inforUpdate.setAutoCreateContainerGaps(false);

		JScrollPane scrollPane = new JScrollPane();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout
				.setHorizontalGroup(groupLayout
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								groupLayout.createSequentialGroup().addGap(235)
										.addComponent(lblNewLabel))
						.addGroup(
								groupLayout
										.createSequentialGroup()
										.addGap(10)
										.addComponent(function,
												GroupLayout.PREFERRED_SIZE, 89,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																groupLayout
																		.createSequentialGroup()
																		.addGroup(
																				groupLayout
																						.createParallelGroup(
																								Alignment.LEADING,
																								false)
																						.addComponent(
																								inforAdd,
																								GroupLayout.DEFAULT_SIZE,
																								479,
																								Short.MAX_VALUE)
																						.addComponent(
																								inforUpdate,
																								GroupLayout.DEFAULT_SIZE,
																								479,
																								Short.MAX_VALUE)
																						.addComponent(
																								inforDelete,
																								GroupLayout.DEFAULT_SIZE,
																								479,
																								Short.MAX_VALUE)
																						.addComponent(
																								inforSeek,
																								GroupLayout.PREFERRED_SIZE,
																								484,
																								GroupLayout.PREFERRED_SIZE))
																		.addGap(10))
														.addGroup(
																groupLayout
																		.createSequentialGroup()
																		.addComponent(
																				scrollPane,
																				GroupLayout.DEFAULT_SIZE,
																				482,
																				Short.MAX_VALUE)
																		.addContainerGap()))));
		groupLayout
				.setVerticalGroup(groupLayout
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								groupLayout
										.createSequentialGroup()
										.addGap(10)
										.addComponent(lblNewLabel)
										.addGap(6)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.LEADING)
														.addComponent(
																function,
																GroupLayout.DEFAULT_SIZE,
																422,
																Short.MAX_VALUE)
														.addGroup(
																groupLayout
																		.createSequentialGroup()
																		.addComponent(
																				inforSeek,
																				GroupLayout.PREFERRED_SIZE,
																				70,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addComponent(
																				inforAdd,
																				GroupLayout.PREFERRED_SIZE,
																				120,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(6)
																		.addComponent(
																				inforUpdate,
																				GroupLayout.PREFERRED_SIZE,
																				70,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addComponent(
																				inforDelete,
																				GroupLayout.PREFERRED_SIZE,
																				70,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addComponent(
																				scrollPane,
																				GroupLayout.DEFAULT_SIZE,
																				76,
																				Short.MAX_VALUE)))
										.addContainerGap()));
		groupLayout.setAutoCreateGaps(true);

		infor_table = new JTable();
		infor_table.setFillsViewportHeight(true);
		infor_table.setModel(tableModel);
		scrollPane.setViewportView(infor_table);
		scrollPane.setVisible(true);

		getContentPane().setLayout(groupLayout);
		setWindowsPart(true, false, false, false);
	}

	private void setWindowsPart(boolean b, boolean c, boolean d, boolean e) {
		// TODO Auto-generated method stub
		inforAdd.setVisible(b);
		inforDelete.setVisible(c);
		inforSeek.setVisible(d);
		inforUpdate.setVisible(e);
	}

	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		// TODO Auto-generated method stub
		String command = actionEvent.getActionCommand();

		System.out.println(command);
		if (command.equals("信息添加")) {
			inforAdd.setVisible(!inforAdd.isVisible());
		} else if (command.equals("信息查询")) {
			inforSeek.setVisible(!inforSeek.isVisible());
		} else if (command.equals("信息修改")) {
			inforUpdate.setVisible(!inforUpdate.isVisible());
		} else if (command.equals("信息删除")) {
			inforDelete.setVisible(!inforDelete.isVisible());
		} else if (command.equals("确认查询")) {
			// System.out.println(inforSeek_content.getText());
			seekInfor();

		} else if (command.equals("确认添加")) {
			addInputInfor();

		} else if (command.equals("查询")) {

		} else if (command.equals("修改")) {

		} else if (command.equals("确认删除")) {
			deleteInfor();
		}
	}

	private void deleteInfor() {
		// TODO Auto-generated method stub
		String item = inforDelete_content.getText();
		String where = inforDelete_selection_item;

		if (!item.equals("")) {
			int count = DB.delete(item, getSelectionToString(where));
			if (count == 0) {
				JOptionPane.showMessageDialog(this, "删除信息失敗！", "警告",
						JOptionPane.ERROR_MESSAGE);
			} else {
				showTableData();
				tableModel.setDataVector(arrayStudentinfor, tableTitle);
				tableModel.fireTableDataChanged();
			}
		} else {
			JOptionPane.showMessageDialog(this, "请填写要删除的选项！", "警告",
					JOptionPane.ERROR_MESSAGE);
		}
		inforDelete_content.setText("");
	}

	private void seekInfor() {
		// TODO Auto-generated method stub
		String item = inforSeek_content.getText();
		String where = inforSeek_selection_item;
		if (!item.equals("")) {
			tableModel.setRowCount(0);
			tableModel.fireTableDataChanged();
			List<StudentInfor> list = DB.query(item,
					getSelectionToString(where));
			if (list.size() == 0) {
				JOptionPane.showMessageDialog(this, "查询的信息不存在！", "警告",
						JOptionPane.ERROR_MESSAGE);
			} else {
				getStudnetInfor(list);
				tableModel.setDataVector(arrayStudentinfor, tableTitle);
				tableModel.fireTableDataChanged();
			}
		} else {
			JOptionPane.showMessageDialog(this, "请填写要查询的选项！", "警告",
					JOptionPane.ERROR_MESSAGE);
		}
		inforSeek_content.setText("");
	}

	private void addInputInfor() {
		// TODO Auto-generated method stub
		String number = inforAdd_number.getText();
		String name = inforAdd_name.getText();
		String classStr = inforAdd_class.getText();
		String hostel = inforAdd_selection_item_hostel_floor
				+ inforAdd_selection_item_hostel_number;
		String academy = inforAdd_selection_academy + "学院";
		System.out.println("name:" + name);
		if (!number.equals("") && !name.equals("") && !classStr.equals("")) {

			StudentInfor infor = new StudentInfor(number, name, hostel,
					classStr, academy);
			int count = DB.insert(infor);
			if (count != 0) {
				tableModel.addRow(new String[] { number, name, hostel,
						classStr, academy });
				tableModel.fireTableDataChanged();
			} else {
				JOptionPane.showMessageDialog(this, "插入数据失败！", "错误",
						JOptionPane.ERROR_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(this, "请填写完整信息！", "警告",
					JOptionPane.ERROR_MESSAGE);
		}
		inforAdd_class.setText("");
		inforAdd_name.setText("");
		inforAdd_number.setText("");
	}

	private String getSelectionToString(String selection) {
		String string = null;
		if (selection.equals("学号")) {
			string = "student_number";
		} else if (selection.equals("姓名")) {
			string = "student_name";
		} else if (selection.equals("学院")) {
			string = "student_academy";
		} else if (selection.equals("寝室号")) {
			string = "student_hostel";
		} else if (selection.equals("班级")) {
			string = "student_class";
		}
		return string;
	}
}
