package view;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.JTextField;

import controller.ContinenteController;
import controller.MarcaController;
import controller.PaisController;
import model.Continente;
import model.Marca;
import model.Pai;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GestionMarcas extends JPanel {
	private static JTextField jtfId;
	private static JTextField jtfDenominacion;
	private static JComboBox<Continente> jcbContinente;
	private static JComboBox<Pai> jcbPais;

	/**
	 * Create the panel.
	 */
	public GestionMarcas() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0 };
//		gridBagLayout.columnWidths = new int[]{0, 0};
//		gridBagLayout.rowHeights = new int[]{0, 0};
//		gridBagLayout.columnWeights = new double[]{0.0, Double.MIN_VALUE};
//		gridBagLayout.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);

		JLabel lblNewLabel = new JLabel("Gestión de Marcas");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Id:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		add(lblNewLabel_1, gbc_lblNewLabel_1);

		jtfId = new JTextField();
		jtfId.setEnabled(false);
		GridBagConstraints gbc_jtfId = new GridBagConstraints();
		gbc_jtfId.insets = new Insets(0, 0, 5, 0);
		gbc_jtfId.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfId.gridx = 1;
		gbc_jtfId.gridy = 1;
		add(jtfId, gbc_jtfId);
		jtfId.setColumns(10);

		JLabel lblNewLabel_1_1 = new JLabel("Denominación:");
		GridBagConstraints gbc_lblNewLabel_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1.gridx = 0;
		gbc_lblNewLabel_1_1.gridy = 2;
		add(lblNewLabel_1_1, gbc_lblNewLabel_1_1);

		jtfDenominacion = new JTextField();
		GridBagConstraints gbc_jtfDenominacion = new GridBagConstraints();
		gbc_jtfDenominacion.insets = new Insets(0, 0, 5, 0);
		gbc_jtfDenominacion.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfDenominacion.gridx = 1;
		gbc_jtfDenominacion.gridy = 2;
		add(jtfDenominacion, gbc_jtfDenominacion);
		jtfDenominacion.setColumns(10);

		JLabel lblNewLabel_1_1_1 = new JLabel("Continente:");
		GridBagConstraints gbc_lblNewLabel_1_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1_1.gridx = 0;
		gbc_lblNewLabel_1_1_1.gridy = 3;
		add(lblNewLabel_1_1_1, gbc_lblNewLabel_1_1_1);

		jcbContinente = new JComboBox<Continente>();
		jcbContinente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jcbPais.removeAllItems();
				Continente p = (Continente) jcbContinente.getSelectedItem();
				if (p != null) {
					for (Pai m : p.getPais()) {
						jcbPais.addItem(m);
					}
				}
			}
		});
		GridBagConstraints gbc_jcbContinente = new GridBagConstraints();
		gbc_jcbContinente.insets = new Insets(0, 0, 5, 0);
		gbc_jcbContinente.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbContinente.gridx = 1;
		gbc_jcbContinente.gridy = 3;
		add(jcbContinente, gbc_jcbContinente);

		JLabel lblNewLabel_1_1_2 = new JLabel("País:");
		GridBagConstraints gbc_lblNewLabel_1_1_2 = new GridBagConstraints();
		gbc_lblNewLabel_1_1_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1_1_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1_2.gridx = 0;
		gbc_lblNewLabel_1_1_2.gridy = 4;
		add(lblNewLabel_1_1_2, gbc_lblNewLabel_1_1_2);

		jcbPais = new JComboBox<Pai>();
		GridBagConstraints gbc_jcbPais = new GridBagConstraints();
		gbc_jcbPais.insets = new Insets(0, 0, 5, 0);
		gbc_jcbPais.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbPais.gridx = 1;
		gbc_jcbPais.gridy = 4;
		add(jcbPais, gbc_jcbPais);

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
		gbc_btnGuardar.gridwidth = 2;
		gbc_btnGuardar.gridx = 0;
		gbc_btnGuardar.gridy = 5;
		add(btnGuardar, gbc_btnGuardar);

		llenarCampos();

	}

	private static void llenarCampos() {
		Marca o = VentanaPrincipal.devolverCampos();

		jtfId.setText("" + o.getId());
		jtfDenominacion.setText(o.getDenominacion());

		jcbContinente.removeAllItems();
		for (Continente o1 : ContinenteController.findAll()) {
			jcbContinente.addItem(o1);
		}

		jcbPais.removeAllItems();
		for (Pai o2 : PaisController.findAll()) {
			jcbPais.addItem(o2);
		}

		jcbPais.setSelectedItem(o.getPai());
		jcbContinente.setSelectedItem(o.getPai().getContinente());
	}

	/**
	 * 
	 * @return
	 */
	private boolean checks(Pai o1) {
		String dni = jtfDenominacion.getText();
		dni = dni.trim();

		char numeros[] = dni.toCharArray();

		if (numeros.length < 2) {
			JOptionPane.showMessageDialog(null, "El SN introducido no es válido.");
			return false;
		}

		if (o1 == null) {
			JOptionPane.showMessageDialog(null, "El continente seleccionado no tiene países asociados.");
			return false;
		}
		return true;
	}

	/**
	 * 
	 */
	public void guardar() {
		Pai o1 = (Pai) jcbPais.getSelectedItem();
		if (checks(o1)) {
			Marca o = MarcaController.findById(Integer.parseInt(jtfId.getText()));
			o.setDenominacion(jtfDenominacion.getText());
			o.setPai(o1);
			MarcaController.update(o);

			VentanaPrincipal.llenarJcbMarca();
			VentanaPrincipal.getInstance().getDialog().dispose();
			VentanaPrincipal.getInstance().getJcbMarca().setSelectedItem(o);

		}
	}

}
