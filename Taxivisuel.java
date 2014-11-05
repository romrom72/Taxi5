/**
 * Taxivisuel est la classe permettant l'aper�u en interface homme machine. Ainsi que le calcul du remboursement
 *
 * @author Romain Locquet
 * @version 1.0
 */


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

import AR;
import AS;
import Saisie;
import java.awt.Color;




public class Taxivisuel extends JFrame {

	private JPanel contentPane;
	private JTextField NumDept;
	private JTextField NbKM;
	private JTextField Duretrajet;
	private JLabel lblSaisirUnDept ;
	private JLabel lblNombreDeKm ;
	private JLabel lblDureDuTrajet;
	private JLabel lblVeuillezRemplirLes;	
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
	private int i;


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
		NbKM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
			}
		});
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
		btnCalculer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				double prix = 0.0;
				
					if(rdbtnAllerSimple.isSelected())
					{ //Aller - Simple

			            if(rdbtnSemaine.isSelected() && rdbtnJour.isSelected())
			            {
			            	System.out.print(AS1.get(i).getPriseCharge()+" - "+AS1.get(i).getTarifJS());
			                prix = (AS1.get(i).getPriseCharge()) + ((Integer.parseInt(NbKM.getText())* AS1.get(i).getTarifJS()));
			                if(Integer.parseInt(Duretrajet.getText()) > 60) //Et de plus d'une heure
			                	prix = (int)(Integer.parseInt(Duretrajet.getText())/60) * AS1.get(i).getTarifHoraireJ();
			        }
			            else
			            {
			            	
			                prix = AS1.get(i).getPriseCharge() + (Integer.parseInt(NbKM.getText()) * AS1.get(i).getTarifNW());
			                if(Integer.parseInt(Duretrajet.getText()) > 60)
			                    prix = (int)(Integer.parseInt(Duretrajet.getText())/60) * AS1.get(i).getTarifHoraireNWE();
			            }
			        }
			        else if(rdbtnAllerRetour.isSelected())
			        { //Aller - Retour
			            if(rdbtnWeekEnd.isSelected() && rdbtnNuit.isSelected())
			            {
			            	
			                prix = AR1.get(i).getPriseCharge() + (Integer.parseInt(NbKM.getText()) * AR1.get(i).getTarifNW());
			                if(Integer.parseInt(Duretrajet.getText()) > 60)
			                    prix = (int)(Integer.parseInt(Duretrajet.getText())/60) * AR1.get(i).getTarifHoraireJ();
			            }
			            else

			            {
			                prix = AR1.get(i).getPriseCharge() + (Integer.parseInt(NbKM.getText()) * AR1.get(i).getTarifJS());
			                if(Integer.parseInt(Duretrajet.getText()) > 60)
			                    prix = (int)(Integer.parseInt(Duretrajet.getText())/60) * AR1.get(i).getTarifHoraireNWE();
			            }
			        }
					
										
						lblPourCeDplacement.setVisible(true);
						lblPourCeDplacement.setText("Pour ce déplacement vous devrez payer :" + prix + "€");
				}
					//return prix;
					
			});
		btnCalculer.setBounds(423, 393, 117, 25);
		contentPane.add(btnCalculer);
		btnCalculer.setVisible(false);
			
		
	    lblPourCeDplacement = new JLabel();
		lblPourCeDplacement.setBounds(53, 460, 409, 15);
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
		
			 			 
			 i =0;
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
		btnRinitialiser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				
				
				NumDept.setText(null);
				lblSaisirUnDept.setText(null);
				NbKM.setText(null);
				Duretrajet.setText(null);
				Voyage.clearSelection();
				Jour.clearSelection();
				semaine.clearSelection();
				lblPourCeDplacement.setText(null);
							
			}
		});
		btnRinitialiser.setBounds(368, 114, 117, 25);
		contentPane.add(btnRinitialiser);
		
		lblVeuillezRemplirLes = new JLabel("Veuillez remplir les champs SVP");
		lblVeuillezRemplirLes.setForeground(Color.RED);
		lblVeuillezRemplirLes.setBounds(343, 192, 241, 19);
		contentPane.add(lblVeuillezRemplirLes);
		lblVeuillezRemplirLes.setVisible(false);
		
		
		
		
		
		
		
	
		
	}
}
