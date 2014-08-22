import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class FileChooser extends JPanel implements ActionListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton openButton, saveButton, confirmButton, showCodeButton;
	JLabel enterSubjectLabel, enterSessionLabel, enterRepLabel;
	JTextField enterSubject, enterSession, enterRep;
	JTextPane ilog;	
	JFileChooser fc;
	
	private String inputFileName;
    private String outputFileName;
	private String subject;
	private String session;
	private String rep;
	
	public FileChooser()
	{
		super(new BorderLayout());
		ilog = new JTextPane();
		ilog.setEditable(false);
		ilog.setSize(40, 80);
		ilog.setText("Please select an input file and an output location.\n");

	    JScrollPane logScrollpane = new JScrollPane(ilog);
		
		fc = new JFileChooser();
		
		openButton = new JButton("Open the target file");
		openButton.addActionListener(this);
		
		saveButton = new JButton("choose a directory to save the code");
		saveButton.addActionListener(this);
		
		confirmButton = new JButton("Start");
		confirmButton.addActionListener(this);
		
		showCodeButton = new JButton("show Code");
		showCodeButton.addActionListener(this);
		showCodeButton.setEnabled(false);
		
		enterSubjectLabel = new JLabel("Subject:");
		enterSubjectLabel.setToolTipText("Enter the subject, eg: s002");
		enterSessionLabel = new JLabel("Session(s):");
		enterSessionLabel.setToolTipText("Enter session(s), eg: 1, 1-3, or 2~4");
		enterRepLabel = new JLabel("Rep(s):");
		enterRepLabel.setToolTipText("Enter rep(s), eg: 1, 1-3, or 2~4");
		enterSubject = new JTextField(4);
		enterSession = new JTextField(4);
		enterRep = new JTextField(4);
		
		JPanel topButtonPanel = new JPanel();
		topButtonPanel.add(openButton);
		topButtonPanel.add(saveButton);
		topButtonPanel.add(enterSubjectLabel);
		topButtonPanel.add(enterSubject);
		topButtonPanel.add(enterSessionLabel);
		topButtonPanel.add(enterSession);
		topButtonPanel.add(enterRepLabel);
		topButtonPanel.add(enterRep);
		

		JPanel bottomButtonPanel = new JPanel();
		bottomButtonPanel.add(confirmButton);
		bottomButtonPanel.add(showCodeButton);
		
		add(topButtonPanel, BorderLayout.PAGE_START);
		add(logScrollpane, BorderLayout.CENTER);
		add(bottomButtonPanel, BorderLayout.PAGE_END);
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource() == openButton) {
			fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
			int returnVal = fc.showOpenDialog(FileChooser.this);
			StyledDocument doc = ilog.getStyledDocument();
			Style style = ilog.addStyle("openButton", null);
			
			if(returnVal == JFileChooser.APPROVE_OPTION)
			{
				File file = fc.getSelectedFile();
				inputFileName = file.getAbsolutePath();
				
				try {
					StyleConstants.setForeground(style, Color.black);
					doc.insertString(doc.getLength(), "Opening "+inputFileName+".\n", style);
				} catch (BadLocationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else
			{
				try {
					StyleConstants.setForeground(style, Color.red);
					doc.insertString(doc.getLength(), "Please select an input file.\n", style);
				} catch (BadLocationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		else if (arg0.getSource() == saveButton)
		{
			fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			int returnVal = fc.showSaveDialog(FileChooser.this);
			StyledDocument doc = ilog.getStyledDocument();
			Style style = ilog.addStyle("saveButton", null);
			
			if(returnVal == JFileChooser.APPROVE_OPTION)
			{
				File file = fc.getSelectedFile();
				outputFileName = file.getPath()+"\\"+(new GenerateFileName()).generateFileName();
				try {
					StyleConstants.setForeground(style, Color.black);
					doc.insertString(doc.getLength(), "Arduino code will be saved into " + outputFileName+".\n", style);
				} catch (BadLocationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else
			{
				try {
					StyleConstants.setForeground(style, Color.red);
					doc.insertString(doc.getLength(), "Please select a directory to save "+outputFileName+".\n", style);
				} catch (BadLocationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}	
		
		else if (arg0.getSource() == confirmButton)
		{
			StyledDocument doc = ilog.getStyledDocument();
			Style style = ilog.addStyle("confirmButton", null);
			try
			{
				subject = enterSubject.getText();
			}
			catch(NullPointerException e)
			{
				subject = null;
			}
			
			try
			{
				session = enterSession.getText();
			}
			catch(NullPointerException e)
			{
				session = null;
			}
			
			try
			{
				rep = enterRep.getText();
			}
			catch(NullPointerException e)
			{
				rep = null;
			}
			
			if(inputFileName!=null && outputFileName!=null && subject!=null && session!=null && rep!=null)
			{
				try {
					subject = enterSubject.getText();
					session = enterSession.getText();
					rep = enterRep.getText();
					CodeGenerator codeGen = new CodeGenerator();
					FileConverter fc = new FileConverter(inputFileName);
					fc.generateTempFile(subject,session,rep);
					codeGen.run("tempData.txt", outputFileName);
					showCodeButton.setEnabled(true);;
					try {
						doc.insertString(doc.getLength(), "The Arduino board will run for "+
					String.valueOf(codeGen.getMinutes())+" minutes and "+String.valueOf(codeGen.getSeconds())+" seconds.\n", null);
					} catch (BadLocationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			else
			{
				if(inputFileName==null)
				{
					try {
						StyleConstants.setForeground(style, Color.red);
						doc.insertString(doc.getLength(), "Please select a input file.\n", style);
					} catch (BadLocationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				else if(outputFileName==null)
				{
					try {
						StyleConstants.setForeground(style, Color.red);
						doc.insertString(doc.getLength(), "Please select a directory.\n", style);
					} catch (BadLocationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else if(subject==null)
				{
					try {
						StyleConstants.setForeground(style, Color.red);
						doc.insertString(doc.getLength(), "Please enter the subject.\n", style);
					} catch (BadLocationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else if(session==null)
				{
					try {
						StyleConstants.setForeground(style, Color.red);
						doc.insertString(doc.getLength(), "Please enter session(s).\n", style);
					} catch (BadLocationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else if(rep==null)
				{
					try {
						StyleConstants.setForeground(style, Color.red);
						doc.insertString(doc.getLength(), "Please enter rep(s).\n", style);
					} catch (BadLocationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		
		else if(arg0.getSource() == showCodeButton)
		{
			JTextArea ta = new JTextArea(20,60);
			try {
				ta.read(new FileReader(outputFileName), null);
				ta.setEditable(false);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			StyledDocument doc = ilog.getStyledDocument();
			Style style = ilog.addStyle("confirmButton", null);
			StyleConstants.setForeground(style, Color.black);
			try {
				doc.insertString(doc.getLength(), "Please copy and paste the code into the Arduino IDE", style);
			} catch (BadLocationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			JFrame frame = new JFrame("Generated Arduino Code");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			JScrollPane logScrollpaneCode = new JScrollPane(ta);
			frame.add(logScrollpaneCode);
			
			frame.pack();
			frame.setVisible(true);
		}
	}
	
	public void createAndShowGUI()
	{
		JFrame frame = new JFrame("FileChooser");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new FileChooser());
		
		frame.pack();
		frame.setVisible(true);
	}
	
    
	
}