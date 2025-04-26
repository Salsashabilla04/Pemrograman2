import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class DataPekerjaanForm extends JFrame {
    private JTextField txtKodePekerjaan, txtNamaPekerjaan;
    private JComboBox<Integer> cbJumlahTugas;
    private JButton btnSimpan, btnHapus, btnTutup, btnLihat;
    private JTable table;
    private DefaultTableModel model;

    public DataPekerjaanForm() {
        setTitle("Aplikasi Gaji Karyawan");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JTabbedPane tabbedPane = new JTabbedPane();
        JPanel panelMaster = new JPanel();
        panelMaster.setBackground(new Color(144, 238, 144)); // soft green

        GroupLayout layout = new GroupLayout(panelMaster);
        panelMaster.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        JLabel lblKodePekerjaan = new JLabel("Kode Pekerjaan");
        txtKodePekerjaan = new JTextField(15);
        btnLihat = new JButton("Lihat");

        JLabel lblNamaPekerjaan = new JLabel("Nama Pekerjaan");
        txtNamaPekerjaan = new JTextField(15);

        JLabel lblJumlahTugas = new JLabel("Jumlah Tugas");
        cbJumlahTugas = new JComboBox<>();
        for (int i = 1; i <= 10; i++) {
            cbJumlahTugas.addItem(i);
        }

        btnSimpan = new JButton("Simpan");
        btnHapus = new JButton("Hapus");
        btnTutup = new JButton("Tutup");

        JPanel panelButton = new JPanel();
        panelButton.setBackground(new Color(255, 182, 193)); // soft pink
        panelButton.add(btnSimpan);
        panelButton.add(btnHapus);
        panelButton.add(btnTutup);

        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(lblKodePekerjaan)
                        .addComponent(lblNamaPekerjaan)
                        .addComponent(lblJumlahTugas))
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(txtKodePekerjaan)
                            .addComponent(btnLihat))
                        .addComponent(txtNamaPekerjaan)
                        .addComponent(cbJumlahTugas))
                )
                .addComponent(panelButton)
        );

        layout.setVerticalGroup(
            layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(lblKodePekerjaan)
                    .addComponent(txtKodePekerjaan)
                    .addComponent(btnLihat))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNamaPekerjaan)
                    .addComponent(txtNamaPekerjaan))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(lblJumlahTugas)
                    .addComponent(cbJumlahTugas))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelButton)
        );

        tabbedPane.addTab("Master Data Pekerjaan", panelMaster);
        add(tabbedPane);

        btnLihat.addActionListener(e -> tampilkanDataPekerjaan());
        btnTutup.addActionListener(e -> dispose());
    }

    private void tampilkanDataPekerjaan() {
        JFrame frame = new JFrame("Data Pekerjaan");
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(this);

        String[] columnNames = {"Kode", "Nama Pekerjaan"};
        Object[][] data = {
            {"1415", "admin"},
            {"2231", "sales"},
            {"4444", "direktur"},
            {"4545", "KULI"}
        };

        model = new DefaultTableModel(data, columnNames);
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);

        JButton btnPilih = new JButton("Pilih");
        JButton btnTutup = new JButton("Tutup");

        JPanel panelButton = new JPanel();
        panelButton.add(btnPilih);
        panelButton.add(btnTutup);

        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(panelButton, BorderLayout.SOUTH);

        frame.setVisible(true);

        btnPilih.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                String kode = (String) table.getValueAt(selectedRow, 0);
                String nama = (String) table.getValueAt(selectedRow, 1);
                txtKodePekerjaan.setText(kode);
                txtNamaPekerjaan.setText(nama);
                frame.dispose();
            }
        });

        btnTutup.addActionListener(e -> frame.dispose());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new DataPekerjaanForm().setVisible(true);
        });
    }
}
