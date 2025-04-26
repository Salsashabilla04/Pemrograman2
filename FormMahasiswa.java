import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class FormMahasiswa extends JFrame {
    private JTable table;
    private DefaultTableModel model;
    private JTextField txtNIM, txtNama, txtNilai;
    private JButton btnTambah;

    public FormMahasiswa() {
        setTitle("Data Mahasiswa");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        String[] columnNames = {"NIM", "Nama Mahasiswa", "Nilai"};
        
        // Bikin tabel kosong, tanpa data awal
        model = new DefaultTableModel(null, columnNames);
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);

        JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel lblNIM = new JLabel("NIM:");
        JLabel lblNama = new JLabel("Nama:");
        JLabel lblNilai = new JLabel("Nilai:");

        txtNIM = new JTextField(10);
        txtNama = new JTextField(10);
        txtNilai = new JTextField(5);

        btnTambah = new JButton("Tambah Data");

        gbc.gridx = 0;
        gbc.gridy = 0;
        inputPanel.add(lblNIM, gbc);

        gbc.gridx = 1;
        inputPanel.add(txtNIM, gbc);

        gbc.gridx = 2;
        inputPanel.add(lblNama, gbc);

        gbc.gridx = 3;
        inputPanel.add(txtNama, gbc);

        gbc.gridx = 4;
        inputPanel.add(lblNilai, gbc);

        gbc.gridx = 5;
        inputPanel.add(txtNilai, gbc);

        gbc.gridx = 6;
        inputPanel.add(btnTambah, gbc);

        add(scrollPane, BorderLayout.CENTER);
        add(inputPanel, BorderLayout.SOUTH);

        btnTambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tambahData();
            }
        });
    }

    private void tambahData() {
        String nim = txtNIM.getText();
        String nama = txtNama.getText();
        String nilai = txtNilai.getText();

        if (!nim.isEmpty() && !nama.isEmpty() && !nilai.isEmpty()) {
            model.addRow(new Object[]{nim, nama, nilai});
            txtNIM.setText("");
            txtNama.setText("");
            txtNilai.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Harap isi semua field!", "Peringatan", JOptionPane.WARNING_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new FormMahasiswa().setVisible(true);
        });
    }
}
