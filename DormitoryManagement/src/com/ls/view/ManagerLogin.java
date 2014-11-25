package com.ls.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import com.ls.bean.LoginInfor;
import com.ls.db.DB;

import javax.swing.JPasswordField;

public class ManagerLogin extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField login_name;
	private static List<LoginInfor> loginInfors;
	private JPasswordField login_password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagerLogin frame = new ManagerLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		loginInfors = DB.queryLoginInfor();
	}

	/**
	 * Create the frame.
	 */
	public ManagerLogin() {
		setResizable(false);// ½ûÖ¹¸Ä±ä´óÐ¡
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(
				Alignment.TRAILING).addGroup(
				gl_contentPane
						.createSequentialGroup()
						.addGap(2)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 382,
								Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(
				Alignment.TRAILING).addGroup(
				Alignment.LEADING,
				gl_contentPane
						.createSequentialGroup()
						.addComponent(panel, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)));

		JLabel lblNewLabel = new JLabel("\u5BDD\u5BA4\u7BA1\u7406\u7CFB\u7EDF");
		lblNewLabel.setFont(new Font("Ó×Ô²", Font.BOLD, 18));

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);

		JLabel lblNewLabel_2 = new JLabel("develope by ls");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel
				.createParallelGroup(Alignment.LEADING)
				.addGroup(
						gl_panel.createSequentialGroup()
								.addContainerGap(298, Short.MAX_VALUE)
								.addComponent(lblNewLabel_2))
				.addGroup(
						gl_panel.createSequentialGroup()
								.addGap(91)
								.addComponent(panel_1,
										GroupLayout.PREFERRED_SIZE, 200,
										GroupLayout.PREFERRED_SIZE)
								.addContainerGap(91, Short.MAX_VALUE))
				.addGroup(
						gl_panel.createSequentialGroup().addGap(134)
								.addComponent(lblNewLabel)
								.addContainerGap(134, Short.MAX_VALUE)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(
				Alignment.TRAILING).addGroup(
				gl_panel.createSequentialGroup()
						.addContainerGap(28, Short.MAX_VALUE)
						.addComponent(lblNewLabel)
						.addGap(26)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 155,
								GroupLayout.PREFERRED_SIZE).addGap(13)
						.addComponent(lblNewLabel_2)));

		JLabel label = new JLabel("\u8D26\u53F7");

		login_name = new JTextField();
		login_name.setColumns(5);

		JLabel lblNewLabel_1 = new JLabel("\u5BC6\u7801");

		JButton login_btn_enture = new JButton("\u767B\u9646");
		login_btn_enture.addActionListener(this);
		JButton login_btn_quit = new JButton("\u9000\u51FA");
		login_btn_quit.addActionListener(this);

		login_password = new JPasswordField();
		login_password.setColumns(5);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1
				.setHorizontalGroup(gl_panel_1
						.createParallelGroup(Alignment.TRAILING)
						.addGroup(
								gl_panel_1
										.createSequentialGroup()
										.addGap(31)
										.addGroup(
												gl_panel_1
														.createParallelGroup(
																Alignment.TRAILING)
														.addGroup(
																gl_panel_1
																		.createSequentialGroup()
																		.addComponent(
																				login_btn_enture,
																				GroupLayout.DEFAULT_SIZE,
																				65,
																				Short.MAX_VALUE)
																		.addPreferredGap(
																				ComponentPlacement.UNRELATED)
																		.addComponent(
																				login_btn_quit))
														.addGroup(
																gl_panel_1
																		.createSequentialGroup()
																		.addGroup(
																				gl_panel_1
																						.createParallelGroup(
																								Alignment.TRAILING)
																						.addComponent(
																								lblNewLabel_1)
																						.addComponent(
																								label))
																		.addPreferredGap(
																				ComponentPlacement.UNRELATED)
																		.addGroup(
																				gl_panel_1
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addComponent(
																								login_password,
																								GroupLayout.DEFAULT_SIZE,
																								98,
																								Short.MAX_VALUE)
																						.addComponent(
																								login_name,
																								GroupLayout.DEFAULT_SIZE,
																								98,
																								Short.MAX_VALUE))))
										.addGap(37)));
		gl_panel_1
				.setVerticalGroup(gl_panel_1
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_panel_1
										.createSequentialGroup()
										.addGap(24)
										.addGroup(
												gl_panel_1
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(label)
														.addComponent(
																login_name,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addGap(27)
										.addGroup(
												gl_panel_1
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																lblNewLabel_1)
														.addComponent(
																login_password,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addGap(29)
										.addGroup(
												gl_panel_1
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																login_btn_enture)
														.addComponent(
																login_btn_quit))
										.addContainerGap()));
		panel_1.setLayout(gl_panel_1);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}

	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		// TODO Auto-generated method stub
		// System.out.println(actionEvent.getActionCommand());
		String command = actionEvent.getActionCommand();
		if (command.equals("µÇÂ½")) {
			// System.out.println("ok");
			String name = login_name.getText();
			String password = String.valueOf(login_password.getPassword());
			for (LoginInfor loginInfor : loginInfors) {
				if (loginInfor.getName().equals(name)
						&& loginInfor.getPassword().equals(password)) {
					System.out.println("³É¹¦");
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
					this.dispose();
				} else {
					JOptionPane.showMessageDialog(this, "ÕËºÅ»òÃÜÂë´íÎó£¡", "´íÎó",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		} else if (command.equals("ÍË³ö")) {
			this.dispose();
		}
	}
}
