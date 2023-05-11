package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.MarcaController;
import controller.PortatilController;
import model.Marca;
import model.Portatil;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JToolBar;
import javax.swing.ButtonGroup;

public class VentanaPrincipal extends JFrame {

	public static VentanaPrincipal singuerton = null;
	private JPanel contentPane;
	private static JTextField jtfId;
	private static JTextField jtfModelo;
	private static JTextField jtfSerialNumber;
	private static JTextField jtfFecha;
	private static JComboBox<Marca> jcbMarca;
	private static JCheckBox cbxVendido;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private static JRadioButton rbtn1;
	private static JRadioButton rbtn2;
	private static JRadioButton rbtn3;
	private static JRadioButton rbtn4;
	private JDialog dialogo;
	private static JButton jbt = new JButton();
	private static JButton jbt2 = new JButton();
	private static JButton jbt3 = new JButton();
	private static JButton jbt4 = new JButton();
	private static JButton jbt5 = new JButton();
	private static JButton jbt6 = new JButton();
	private static JButton jbt7 = new JButton();

	public static VentanaPrincipal getInstance() {
		if (singuerton == null)
			singuerton = new VentanaPrincipal();
		return singuerton;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal.getInstance().setVisible(true);
//					singuerton.setMinimumSize(new Dimension(800, 600));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 513, 365);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

//		this.add(new ToolBar(), BorderLayout.NORTH);

//		this.add(new model.ToolBar(), BorderLayout.NORTH);

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0 };
//		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0};
//		gbl_contentPane.columnWidths = new int[]{0, 0};
//		gbl_contentPane.rowHeights = new int[]{0, 0};
//		gbl_contentPane.columnWeights = new double[]{0.0, Double.MIN_VALUE};
//		gbl_contentPane.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);

		JToolBar toolBar = new JToolBar();
		GridBagConstraints gbc_toolBar = new GridBagConstraints();
		gbc_toolBar.anchor = GridBagConstraints.WEST;
		gbc_toolBar.gridwidth = 4;
		gbc_toolBar.insets = new Insets(0, 0, 5, 5);
		gbc_toolBar.gridx = 0;
		gbc_toolBar.gridy = 0;
		contentPane.add(toolBar, gbc_toolBar);

		// 1
		jbt.setText("1");
		jbt.setToolTipText("Primer registro");

		jbt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cargarPrimerRegistro();
			}
		});
		toolBar.add(jbt);

		// 2
		jbt2.setText("2");
		jbt2.setToolTipText("Anterior registro");

		jbt2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cargarAnteriorRegistro();
			}
		});
		toolBar.add(jbt2);

		// 3
		jbt3.setText("3");
		jbt3.setToolTipText("Siguiente registro");

		jbt3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cargarSiguienteRegistro();
			}
		});
		toolBar.add(jbt3);

		// 4
		jbt4.setText("4");
		jbt4.setToolTipText("Último registro");

		jbt4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cargarUltimoRegistro();
			}
		});
		toolBar.add(jbt4);

		// 5
		jbt5.setText("5");
		jbt5.setToolTipText("Nuevo registro");

		jbt5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				insertar();
			}
		});
		toolBar.add(jbt5);

		// 6
		jbt6.setText("6");
		jbt6.setToolTipText("Guardar registro");

		jbt6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		toolBar.add(jbt6);

		// 7
		jbt7.setText("7");
		jbt7.setToolTipText("Eliminar registro");

		jbt7.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				eliminar();
			}
		});
		toolBar.add(jbt7);

		JLabel lblNewLabel = new JLabel("Gestión de Ordenadores Portátiles");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 4;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Id:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 2;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);

		jtfId = new JTextField();
		jtfId.setEnabled(false);
		GridBagConstraints gbc_jtfId = new GridBagConstraints();
		gbc_jtfId.gridwidth = 3;
		gbc_jtfId.insets = new Insets(0, 0, 5, 0);
		gbc_jtfId.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfId.gridx = 1;
		gbc_jtfId.gridy = 2;
		contentPane.add(jtfId, gbc_jtfId);
		jtfId.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Marca:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 3;
		contentPane.add(lblNewLabel_2, gbc_lblNewLabel_2);

		jcbMarca = new JComboBox<Marca>();
		GridBagConstraints gbc_jcbMarca = new GridBagConstraints();
		gbc_jcbMarca.gridwidth = 2;
		gbc_jcbMarca.insets = new Insets(0, 0, 5, 5);
		gbc_jcbMarca.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbMarca.gridx = 1;
		gbc_jcbMarca.gridy = 3;
		contentPane.add(jcbMarca, gbc_jcbMarca);

		JButton btnVerMarca = new JButton("Ver Marca");
		btnVerMarca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirNuevoDialogo();
			}
		});
		GridBagConstraints gbc_btnVerMarca = new GridBagConstraints();
		gbc_btnVerMarca.insets = new Insets(0, 0, 5, 0);
		gbc_btnVerMarca.gridx = 3;
		gbc_btnVerMarca.gridy = 3;
		contentPane.add(btnVerMarca, gbc_btnVerMarca);

		JLabel lblNewLabel_3 = new JLabel("Modelo:");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 4;
		contentPane.add(lblNewLabel_3, gbc_lblNewLabel_3);

		jtfModelo = new JTextField();
		GridBagConstraints gbc_jtfModelo = new GridBagConstraints();
		gbc_jtfModelo.gridwidth = 3;
		gbc_jtfModelo.insets = new Insets(0, 0, 5, 0);
		gbc_jtfModelo.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfModelo.gridx = 1;
		gbc_jtfModelo.gridy = 4;
		contentPane.add(jtfModelo, gbc_jtfModelo);
		jtfModelo.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Serial Number:");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 5;
		contentPane.add(lblNewLabel_4, gbc_lblNewLabel_4);

		jtfSerialNumber = new JTextField();
		GridBagConstraints gbc_jtfSerialNumber = new GridBagConstraints();
		gbc_jtfSerialNumber.gridwidth = 3;
		gbc_jtfSerialNumber.insets = new Insets(0, 0, 5, 0);
		gbc_jtfSerialNumber.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfSerialNumber.gridx = 1;
		gbc_jtfSerialNumber.gridy = 5;
		contentPane.add(jtfSerialNumber, gbc_jtfSerialNumber);
		jtfSerialNumber.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("Num procesadores:");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.gridheight = 2;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 6;
		contentPane.add(lblNewLabel_5, gbc_lblNewLabel_5);

		rbtn1 = new JRadioButton("1 Procesador");
		buttonGroup.add(rbtn1);
		GridBagConstraints gbc_rbtn1 = new GridBagConstraints();
		gbc_rbtn1.anchor = GridBagConstraints.WEST;
		gbc_rbtn1.insets = new Insets(0, 0, 5, 5);
		gbc_rbtn1.gridx = 1;
		gbc_rbtn1.gridy = 6;
		contentPane.add(rbtn1, gbc_rbtn1);

		rbtn2 = new JRadioButton("2 Procesadores");
		buttonGroup.add(rbtn2);
		GridBagConstraints gbc_rbtn2 = new GridBagConstraints();
		gbc_rbtn2.anchor = GridBagConstraints.WEST;
		gbc_rbtn2.insets = new Insets(0, 0, 5, 5);
		gbc_rbtn2.gridx = 2;
		gbc_rbtn2.gridy = 6;
		contentPane.add(rbtn2, gbc_rbtn2);

		rbtn3 = new JRadioButton("3 Procesadores");
		buttonGroup.add(rbtn3);
		GridBagConstraints gbc_rbt3 = new GridBagConstraints();
		gbc_rbt3.anchor = GridBagConstraints.WEST;
		gbc_rbt3.insets = new Insets(0, 0, 5, 5);
		gbc_rbt3.gridx = 1;
		gbc_rbt3.gridy = 7;
		contentPane.add(rbtn3, gbc_rbt3);

		rbtn4 = new JRadioButton("4 Procesadores");
		buttonGroup.add(rbtn4);
		GridBagConstraints gbc_rbtn4 = new GridBagConstraints();
		gbc_rbtn4.anchor = GridBagConstraints.WEST;
		gbc_rbtn4.insets = new Insets(0, 0, 5, 5);
		gbc_rbtn4.gridx = 2;
		gbc_rbtn4.gridy = 7;
		contentPane.add(rbtn4, gbc_rbtn4);

		JLabel lblNewLabel_6 = new JLabel("Vendido:");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 0;
		gbc_lblNewLabel_6.gridy = 8;
		contentPane.add(lblNewLabel_6, gbc_lblNewLabel_6);

		cbxVendido = new JCheckBox("");
		cbxVendido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cbxVendido.isSelected()) {
					jtfFecha.setEnabled(true);
				} else {
					jtfFecha.setEnabled(false);
					jtfFecha.setText("");
				}
			}
		});
		GridBagConstraints gbc_chckbxNewCheckBox = new GridBagConstraints();
		gbc_chckbxNewCheckBox.anchor = GridBagConstraints.WEST;
		gbc_chckbxNewCheckBox.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxNewCheckBox.gridx = 1;
		gbc_chckbxNewCheckBox.gridy = 8;
		contentPane.add(cbxVendido, gbc_chckbxNewCheckBox);

		JLabel lblNewLabel_7 = new JLabel("Fecha de venta:");
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7.gridx = 0;
		gbc_lblNewLabel_7.gridy = 9;
		contentPane.add(lblNewLabel_7, gbc_lblNewLabel_7);

		jtfFecha = new JTextField();
		GridBagConstraints gbc_jtfFecha = new GridBagConstraints();
		gbc_jtfFecha.insets = new Insets(0, 0, 5, 0);
		gbc_jtfFecha.gridwidth = 3;
		gbc_jtfFecha.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfFecha.gridx = 1;
		gbc_jtfFecha.gridy = 9;
		contentPane.add(jtfFecha, gbc_jtfFecha);
		jtfFecha.setColumns(10);

		JButton btnNumeroTotal = new JButton("Número total de portátiles");
		btnNumeroTotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Total de portátiles: " + PortatilController.count());
			}
		});
		GridBagConstraints gbc_btnNumeroTotal = new GridBagConstraints();
		gbc_btnNumeroTotal.gridwidth = 2;
		gbc_btnNumeroTotal.insets = new Insets(0, 0, 0, 5);
		gbc_btnNumeroTotal.gridx = 1;
		gbc_btnNumeroTotal.gridy = 10;
		contentPane.add(btnNumeroTotal, gbc_btnNumeroTotal);

		cargarPrimerRegistro();
	}

	public static void deshabilitarBotones(Portatil o) {
		if (o != null) {
			if (o.getId() == PortatilController.minId()) {
				jbt.setEnabled(false);
				jbt2.setEnabled(false);
			} else {
				jbt.setEnabled(true);
				jbt2.setEnabled(true);
			}

			if (o.getId() == PortatilController.maxId()) {
				jbt3.setEnabled(false);
				jbt4.setEnabled(false);
			} else {
				jbt3.setEnabled(true);
				jbt4.setEnabled(true);
			}
		}
	}

	/**
	 * 
	 */
	public static void llenarJcbMarca() {
		jcbMarca.removeAllItems();
		for (Marca o : MarcaController.findAll()) {
			jcbMarca.addItem(o);
		}
	}

	/**
	 * 
	 * @param o
	 */
	private static void seleccionarRadioButton(Portatil o) {
		if (o.getNumProcesadores() == 1) {
			rbtn1.setSelected(true);
		} else if (o.getNumProcesadores() == 2) {
			rbtn2.setSelected(true);
		} else if (o.getNumProcesadores() == 3) {
			rbtn3.setSelected(true);
		} else if (o.getNumProcesadores() == 4) {
			rbtn4.setSelected(true);
		}
	}

	/**
	 * 
	 * @param o
	 */
	private static int devolverRadioButton() {
		if (rbtn1.isSelected()) {
			return 1;

		} else if (rbtn2.isSelected()) {
			return 2;

		} else if (rbtn3.isSelected()) {
			return 3;

		} else if (rbtn4.isSelected()) {
			return 4;
		}
		return 0;
	}

	/**
	 * 
	 */
	private static void cargarPrimerRegistro() {
		Portatil o = PortatilController.findFirst();

		jtfId.setText("" + o.getId());

		llenarJcbMarca();
		jcbMarca.setSelectedItem(o.getMarca());

		jtfModelo.setText(o.getModelo());
		jtfSerialNumber.setText(o.getSn());

		seleccionarRadioButton(o);

		cbxVendido.setSelected(o.getVendido());

		if (cbxVendido.isSelected()) {
			jtfFecha.setEnabled(true);
			jtfFecha.setText(new SimpleDateFormat("dd/MM/yyyy").format(o.getFechaVenta()));
		} else {
			jtfFecha.setEnabled(false);
			jtfFecha.setText("");
		}

		deshabilitarBotones(o);

	}

	/**
	 * 
	 */
	private static void cargarUltimoRegistro() {
		jbt2.setEnabled(false);

		Portatil o = PortatilController.findLast();

		jtfId.setText("" + o.getId());

		llenarJcbMarca();
		jcbMarca.setSelectedItem(o.getMarca());

		jtfModelo.setText(o.getModelo());
		jtfSerialNumber.setText(o.getSn());

		seleccionarRadioButton(o);

		cbxVendido.setSelected(o.getVendido());

		if (cbxVendido.isSelected()) {
			jtfFecha.setEnabled(true);
			jtfFecha.setText(new SimpleDateFormat("dd/MM/yyyy").format(o.getFechaVenta()));
		} else {
			jtfFecha.setEnabled(false);
			jtfFecha.setText("");
		}

		deshabilitarBotones(o);
	}

	/**
	 * 
	 */
	private static void cargarAnteriorRegistro() {
		Portatil o = PortatilController.findPrevious(Integer.parseInt(jtfId.getText()));

		if (o != null) {
			jtfId.setText("" + o.getId());

			llenarJcbMarca();
			jcbMarca.setSelectedItem(o.getMarca());

			jtfModelo.setText(o.getModelo());
			jtfSerialNumber.setText(o.getSn());

			seleccionarRadioButton(o);

			cbxVendido.setSelected(o.getVendido());

			if (cbxVendido.isSelected()) {
				jtfFecha.setEnabled(true);
				jtfFecha.setText(new SimpleDateFormat("dd/MM/yyyy").format(o.getFechaVenta()));
			} else {
				jtfFecha.setEnabled(false);
				jtfFecha.setText("");
			}
		}

		deshabilitarBotones(o);
	}

	/**
	 * 
	 */
	private static void cargarSiguienteRegistro() {
		Portatil o = PortatilController.findNext(Integer.parseInt(jtfId.getText()));

		if (o != null) {
			jtfId.setText("" + o.getId());

			llenarJcbMarca();
			jcbMarca.setSelectedItem(o.getMarca());

			jtfModelo.setText(o.getModelo());
			jtfSerialNumber.setText(o.getSn());

			seleccionarRadioButton(o);

			cbxVendido.setSelected(o.getVendido());

			if (cbxVendido.isSelected()) {
				jtfFecha.setEnabled(true);
				jtfFecha.setText(new SimpleDateFormat("dd/MM/yyyy").format(o.getFechaVenta()));
			} else {
				jtfFecha.setEnabled(false);
				jtfFecha.setText("");
			}
		}

		deshabilitarBotones(o);
	}

	/**
	 * 
	 * @return
	 */
	private boolean checks() {
		String dni = jtfSerialNumber.getText();
		dni = dni.trim();

		char numeros[] = dni.toCharArray();

		if (numeros.length < 4) {
			JOptionPane.showMessageDialog(null, "El SN introducido no es válido.");
			return false;
		}

		if (cbxVendido.isSelected()) {
			if (jtfFecha.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "No has introducido una fecha válida.");
				return false;
			}
		}

		return true;
	}

	public static java.sql.Date getFecha(String fecha) {
		SimpleDateFormat sdfEntrada = new SimpleDateFormat("dd/MM/yyyy");

		Date date = new Date();
		try {
			date = sdfEntrada.parse(fecha);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		SimpleDateFormat sdfSalida = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		long fechaMilis = date.getTime();
		java.sql.Date fechaSQL = new java.sql.Date(fechaMilis);

		return fechaSQL;

	}

	/**
	 * 
	 */
	public void guardar() {
		if (jtfId.getText().isEmpty()) {
			Portatil o = new Portatil();
			o.setModelo(jtfModelo.getText());

			if (checks()) {
				o.setSn(jtfSerialNumber.getText());

				o.setNumProcesadores(devolverRadioButton());

				if (cbxVendido.isSelected()) {
					Date fechaSQL = getFecha(jtfFecha.getText());
					o.setVendido(true);
					o.setFechaVenta(fechaSQL);
				} else {
					o.setVendido(false);
					o.setFechaVenta(null);
				}

				Marca o1 = (Marca) jcbMarca.getSelectedItem();
				o.setMarca(o1);
				PortatilController.insert(o);
				cargarUltimoRegistro();
			}
		} else {
			Portatil o = PortatilController.findById(Integer.parseInt(jtfId.getText()));
			o.setModelo(jtfModelo.getText());

			if (checks()) {
				o.setSn(jtfSerialNumber.getText());

				o.setNumProcesadores(devolverRadioButton());

				if (cbxVendido.isSelected()) {
					Date fechaSQL = getFecha(jtfFecha.getText());
					o.setVendido(true);
					o.setFechaVenta(fechaSQL);
				} else {
					o.setVendido(false);
					o.setFechaVenta(null);
				}

				Marca o1 = (Marca) jcbMarca.getSelectedItem();
				o.setMarca(o1);
				PortatilController.update(o);
			}

		}
	}

	/**
	 * 
	 */
	public void insertar() {
		if (!jtfId.getText().isEmpty())
			jtfId.setText("");
		if (!jtfModelo.getText().isEmpty())
			jtfModelo.setText("");
		if (!jtfSerialNumber.getText().isEmpty())
			jtfSerialNumber.setText("");
		if (!jtfFecha.getText().isEmpty())
			jtfFecha.setText("");
	}

	/**
	 * 
	 */
	public void abrirNuevoDialogo() {
		dialogo = new JDialog();
		// El usuario no puede redimensionar el di�logo
		dialogo.setResizable(true);
		// t�tulo del d�alogo
		dialogo.setTitle("Gestión de empresas");
		// Introducimos el panel creado sobre el di�logo
		dialogo.setContentPane(new GestionMarcas());
		// Empaquetar el di�logo hace que todos los componentes ocupen el espacio que
		// deben y el lugar adecuado
		dialogo.pack();
		// El usuario no puede hacer clic sobre la ventana padre, si el Di�logo es modal
		dialogo.setModal(true);
		// Centro el di�logo en pantalla
		dialogo.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width) / 2 - dialogo.getWidth() / 2,
				(Toolkit.getDefaultToolkit().getScreenSize().height) / 2 - dialogo.getHeight() / 2);
		// Muestro el di�logo en pantalla
		dialogo.setVisible(true);
	}

	/**
	 * 
	 * @return
	 */
	public static Marca devolverCampos() {
		Marca o = (Marca) jcbMarca.getSelectedItem();
		return o;

	}

	/**
	 * 
	 */
	public static void eliminar() {
		Portatil o = PortatilController.findById(Integer.parseInt(jtfId.getText()));
		PortatilController.remove(o);
		cargarSiguienteRegistro();
	}

	/**
	 * 
	 * @return
	 */
	public JDialog getDialog() {
		return dialogo;
	}

	/**
	 * 
	 * @return
	 */
	public JComboBox<Marca> getJcbMarca() {
//		llenarJcbArtista();
		return jcbMarca;
	}

}
