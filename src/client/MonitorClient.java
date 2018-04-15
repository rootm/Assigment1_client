package client;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public class MonitorClient {
	JFrame frame = new JFrame("Monitor");
	JLabel numSensors=new JLabel();
	JLabel numClients=new JLabel();
	JTextArea alertsData = new JTextArea(10, 60);
    JTextArea sensorData = new JTextArea(10, 60);
    JList sensorList = new JList();
    //JTextField textField = new JTextField(40);
    JButton request=new JButton("Request Sensor Data");
    
	public MonitorClient() {
		 // Layout GUI
        GridBagConstraints gbc = new GridBagConstraints();
        GridBagLayout layout = new GridBagLayout();
        frame.setLayout(layout);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        frame.add(numSensors, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        frame.add(numClients, gbc);
        
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 1;
        JScrollPane paneA = new JScrollPane(sensorList);
        paneA.setPreferredSize(new Dimension(paneA.getPreferredSize().height, 163));
        
        
        frame.getContentPane().add(paneA, gbc);
        gbc.fill = GridBagConstraints.HORIZONTAL;  
        gbc.gridwidth = 1;
        gbc.gridx = 1;
        gbc.gridy = 1;
        frame.getContentPane().add(new JScrollPane(sensorData), gbc);
        gbc.fill = GridBagConstraints.HORIZONTAL;  
      
        gbc.gridx = 1;
        gbc.gridy = 2;
        frame.add(request, gbc);
       //gbc.fill = GridBagConstraints.HORIZONTAL;  
        gbc.gridwidth = 2;
        gbc.gridx = 0;
        gbc.gridy = 3;
        frame.getContentPane().add(new JScrollPane(alertsData), gbc);

        /*   msgList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
         textField.setEditable(false);
         messageArea.setEditable(false);
         frame.getContentPane().add(transmit, BorderLayout.NORTH);
         frame.getContentPane().add(new JScrollPane(msgList), BorderLayout.WEST);
         frame.getContentPane().add(textField, BorderLayout.NORTH);

         frame.getContentPane().add(new JScrollPane(messageArea), BorderLayout.EAST);*/
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
        
	}
	void run() {
		String line="fck;fck;fck";
	        
	        sensorList.setListData(line.split(";"));
	}
	
	private void restrictPanelWidth(JScrollPane panel) {
		int panelCurrentWidth = panel.getWidth();
		int panelPreferredHeight = (int)panel.getPreferredSize().getHeight();
		int panelMaximumHeight = (int)panel.getMaximumSize().getHeight();
		panel.setPreferredSize(new Dimension(panelCurrentWidth, panelPreferredHeight));	
		panel.setMaximumSize(new Dimension(panelCurrentWidth, panelMaximumHeight));
	}
	
	public static void main(String[] args) {
		MonitorClient client = new MonitorClient();
	        client.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        client.frame.setVisible(true);
	        client.frame.setResizable(false);
	       client.run();
	        
	}

}
