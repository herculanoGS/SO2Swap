package swap;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;

public class JanelaPrincipal extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JanelaPrincipal frame = new JanelaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JanelaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSelecioneAEntrada = new JLabel("Selecione a entrada:");
		lblSelecioneAEntrada.setBounds(5, 5, 424, 14);
		contentPane.add(lblSelecioneAEntrada);
		
		JLabel lblNewLabel = new JLabel("Quantidade de frames m\u00EDnima (Q1):");
		lblNewLabel.setBounds(5, 48, 230, 48);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(5, 92, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblQuantidadeDeFrames = new JLabel("Quantidade de frames m\u00E1xima: (Q2):");
		lblQuantidadeDeFrames.setBounds(5, 123, 241, 14);
		contentPane.add(lblQuantidadeDeFrames);
		
		textField_1 = new JTextField();
		textField_1.setBounds(5, 148, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(5, 28, 241, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblTempoParaZerar = new JLabel("Tempo para zerar bit R:");
		lblTempoParaZerar.setBounds(5, 179, 180, 14);
		contentPane.add(lblTempoParaZerar);
		
		textField_3 = new JTextField();
		textField_3.setBounds(5, 204, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnAbrir = new JButton("Abrir");
		btnAbrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser fc = new JFileChooser();
                int res = fc.showOpenDialog(null);
                
               if(res == JFileChooser.APPROVE_OPTION){
                    File arquivo = fc.getSelectedFile();  
                    String caminho = arquivo.getPath();
                    textField_2.setText(caminho);
                 }
                else
                    JOptionPane.showMessageDialog(null, "Voce nao selecionou nenhum arquivo."); 
            }

		});
		btnAbrir.setBounds(256, 27, 79, 23);
		contentPane.add(btnAbrir);
		
		JButton btnI = new JButton("Iniciar");
		btnI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			JanelaSaida jn = new JanelaSaida();
			jn.setVisible(true);
			}
		});
		btnI.setBounds(180, 227, 89, 23);
		contentPane.add(btnI);
	}
}
