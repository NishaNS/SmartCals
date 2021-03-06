
package edu.scu.dp.smartcals.ui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;

import edu.scu.dp.smartcals.vm.VMController;
import edu.scu.dp.smartcals.vm.VendingMachine;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author Aparna Ganesh
 * @author Nisha
 */
public class VMSelectionView extends javax.swing.JPanel  {

	// code change done Aparna
	private VMController vmController;
	
	/**
	 * Creates new form SelectVM
	 */
	public VMSelectionView(VMController vmController) {		//Nisha - 8/15 - added argument to constr
		
		this.vmController = vmController;

		initComponents();
		
		//end - Nisha - 8/15

		
		//initComponents();

	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	private void initComponents() {
		/*setLayout(new java.awt.GridBagLayout());
		java.awt.GridBagConstraints gridBagConstraints;
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.gridwidth = 2;
		gridBagConstraints.gridheight = 2;
		gridBagConstraints.ipadx = 10;
		gridBagConstraints.ipady = 10;
		gridBagConstraints.weightx = 0.3;
		gridBagConstraints.weighty = 0.3;
		gridBagConstraints.insets = new java.awt.Insets(10, 10, 60, 80);*/
	
		//code change done Aparna
		FlowLayout experimentLayout = new FlowLayout();
		setLayout(experimentLayout);
		/**
		 * Code change done -Aparna
		 * To display all the VM to the user view
		 */
		List<VendingMachine> vendingMachines = vmController.getAllVendingMachines();

		VMButtonActionListener vmButtonActionListener = new VMButtonActionListener();
		
		for (VendingMachine vm : vendingMachines) {
			JButton button = new JButton(vm.getLocationType() + "@"+ vm.getLocation());
			button.setActionCommand(vm.getVendingMachineId() + "");
			add(button, experimentLayout);
			button.addActionListener(vmButtonActionListener);
			
		}
		}// </editor-fold>
	
	/**
	 * On button click of School/Hospital VM its Id shud be passed to Controller
	 * @author Aparna Ganesh
	 *
	 */
	class VMButtonActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			long vmId = Long.parseLong(e.getActionCommand());
			
			//code change done-Aparna
			//Load the Vending Machine object corresponding to the VM selection
			VendingMachine vendingMachine = vmController.getVendingMachine(vmId);
			
			//Set the Vending Machine object in the Vending Machine view
			VendingMachineView vmView = vmController.getVendingMachineView();
			vmView.setVendingMachine(vendingMachine);
			
			vmController.getSelectView().setVisible(false);
			//code change done-Aparna 8/21
			vmController.getView().addPanels(vmController.getTabbedView());
			
		}
		
	}

}
