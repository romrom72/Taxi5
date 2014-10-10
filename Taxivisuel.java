package Wbuilder;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Package.AR;
import Package.AS;




public class Taxivisuel extends JFrame {

	private JPanel contentPane;
	private JTextField NumDept;
	private JTextField NbKM;
	private JTextField Duretrajet;
	private JLabel lblSaisirUnDept ;
	private JLabel lblNombreDeKm ;
	private JLabel lblDureDuTrajet;
	private JRadioButton rdbtnAllerSimple;
	private JRadioButton rdbtnAllerRetour;
	private JRadioButton rdbtnSemaine;
	private JRadioButton rdbtnWeekEnd;
	private JRadioButton rdbtnJour;
	private JRadioButton rdbtnNuit;
	private JButton btnCalculer;
	private JButton btnRinitialiser;
	private JLabel lblPourCeDplacement;
	private ButtonGroup Voyage = new ButtonGroup();
	private ButtonGroup Jour = new ButtonGroup();
	private ButtonGroup semaine= new ButtonGroup();
	private static  List<AR> AR1 =  new ArrayList<AR>();
	private static  List<AS> AS1 =  new ArrayList<AS>();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		Methodes.connectionBase(AR1, AS1);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Taxivisuel frame = new Taxivisuel();
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
	public Taxivisuel() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 598, 520);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null); 
		
		lblNombreDeKm = new JLabel("Nombre de km à parcourir :");
		lblNombreDeKm.setBounds(30, 175, 213, 15);
		contentPane.add(lblNombreDeKm);
		lblNombreDeKm.setVisible(false);
		
		NbKM = new JTextField();
		NbKM.setBounds(243, 173, 114, 19);
		contentPane.add(NbKM);
		NbKM.setColumns(10);
		NbKM.setVisible(false);
		
		lblDureDuTrajet = new JLabel("Durée du trajet (en min) :");
		lblDureDuTrajet.setBounds(30, 225, 183, 15);
		contentPane.add(lblDureDuTrajet);
		lblDureDuTrajet.setVisible(false);
		
		Duretrajet = new JTextField();
		Duretrajet.setBounds(243, 223, 114, 19);
		contentPane.add(Duretrajet);
		Duretrajet.setColumns(10);
		Duretrajet.setVisible(false);
		
		rdbtnAllerSimple = new JRadioButton("Aller simple");
		rdbtnAllerSimple.setBounds(53, 262, 149, 23);
		contentPane.add(rdbtnAllerSimple);
		Voyage.add(rdbtnAllerSimple);
		rdbtnAllerSimple.setVisible(false);
		
		rdbtnAllerRetour = new JRadioButton("Aller - retour");
		rdbtnAllerRetour.setBounds(208, 262, 149, 23);
		contentPane.add(rdbtnAllerRetour);
		Voyage.add(rdbtnAllerRetour);
		rdbtnAllerRetour.setVisible(false);
		
		
		rdbtnSemaine = new JRadioButton("Semaine");
		rdbtnSemaine.setBounds(53, 313, 149, 23);
		contentPane.add(rdbtnSemaine);
		rdbtnSemaine.setVisible(false);
		semaine.add(rdbtnSemaine);
		
		rdbtnWeekEnd = new JRadioButton("Week end");
		rdbtnWeekEnd.setBounds(208, 313, 149, 23);
		contentPane.add(rdbtnWeekEnd);
		rdbtnWeekEnd.setVisible(false);
		semaine.add(rdbtnWeekEnd);
		
		
		rdbtnJour = new JRadioButton("Jour");
		rdbtnJour.setBounds(53, 354, 149, 23);
		contentPane.add(rdbtnJour);
		rdbtnJour.setVisible(false);
		Jour.add(rdbtnJour);
		
		rdbtnNuit = new JRadioButton("Nuit");
		rdbtnNuit.setBounds(208, 354, 149, 23);
		contentPane.add(rdbtnNuit);
		rdbtnNuit.setVisible(false);
		Jour.add(rdbtnNuit);
		
		btnCalculer = new JButton("Calculer");
		btnCalculer.setBounds(423, 393, 117, 25);
		contentPane.add(btnCalculer);
		btnCalculer.setVisible(false);
			
		
	    lblPourCeDplacement = new JLabel("Pour ce déplacement vous devrez payer :");
		lblPourCeDplacement.setBounds(53, 460, 292, 15);
		contentPane.add(lblPourCeDplacement);
		lblPourCeDplacement.setVisible(false);
	
		 
		
		
		JLabel lblCalculDuCot = new JLabel("Calcul du coût d'un trajet en taxi: ");
		lblCalculDuCot.setBounds(160, 12, 283, 15);
		contentPane.add(lblCalculDuCot);	
		
		
		JLabel lblNumeroDuDepartement = new JLabel("Numero du departement :");
		lblNumeroDuDepartement.setBounds(30, 70, 195, 15);
		contentPane.add(lblNumeroDuDepartement);
				
		NumDept = new JTextField();
		NumDept.setBounds(243, 68, 114, 19);
		contentPane.add(NumDept);
		NumDept.setColumns(10);
		
		lblSaisirUnDept = new JLabel("");
		lblSaisirUnDept.setBounds(39, 119, 249, 15);
		contentPane.add(lblSaisirUnDept);
	 
				
		
		JButton btnValider = new JButton("Valider");
		btnValider.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) 
		{
		
			 			 
			 int i =0;
			 boolean trouve= false;

			 while (!trouve && i < AR1.size())
			 { // si le departement correspond à celui saisie lors de la fonction
		         if(AR1.get(i).getDept() == Integer.parseInt(NumDept.getText()))
		             trouve=true;
		         else
		         	i++;
		     }
			 
			 if (!trouve)
			 { 
				 lblSaisirUnDept.setText("Erreur, Saisir un dept valide");
			 }
			 else
			 {
				 lblSaisirUnDept.setText("Departement validé : " + NumDept.getText());
				 lblNombreDeKm.setVisible(true);
				 NbKM.setVisible(true);
				 lblDureDuTrajet.setVisible(true);
				 Duretrajet.setVisible(true);
				 rdbtnAllerSimple.setVisible(true);
				 rdbtnAllerRetour.setVisible(true);
				 rdbtnJour.setVisible(true);
				 rdbtnNuit.setVisible(true);
				 rdbtnSemaine.setVisible(true);
				 rdbtnWeekEnd.setVisible(true);
				 btnCalculer.setVisible(true);
			 }

		}
		});
		btnValider.setBounds(368, 65, 117, 25);
		contentPane.add(btnValider);		
		
		
		btnRinitialiser = new JButton("Réinitialiser");
		btnRinitialiser.setBounds(368, 114, 117, 25);
		contentPane.add(btnRinitialiser);
		
		
		
		
		
		
	
		
	}
}
