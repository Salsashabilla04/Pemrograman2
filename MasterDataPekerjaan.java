import javax.swing.*;
import java.awt.*;

public class MasterDataPekerjaan extends JFrame {

    public MasterDataPekerjaan() {
        setTitle("Master Data Pekerjaan");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel Atas (Form Input)
        JPanel panelInput = new JPanel();
        panelInput.setBackground(new Color(180, 255, 180)); // Warna hijau muda
        panelInput.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        // Kode Pekerjaan
        gbc.gridx = 0;
        gbc.gridy = 0;
        panelInput.add(new JLabel("Kode Pekerjaan"), gbc);

        gbc.gridx = 1;
        JTextField txtKode = new JTextField(10);
        panelInput.add(txtKode, gbc);

        gbc.gridx = 2;
        JButton btnLihat = new JButton("Lihat");
        panelInput.add(btnLihat, gbc);

        // Nama Pekerjaan
        gbc.gridx = 0;
        gbc.gridy = 1;
        panelInput.add(new JLabel("Nama Pekerjaan"), gbc);

        gbc.gridx = 1;
        gbc.gridwidth = 2;
        JTextField txtNama = new JTextField(20);
        panelInput.add(txtNama, gbc);
        gbc.gridwidth = 1;

        // Jumlah Tugas (Dropdown)
        gbc.gridx = 0;
        gbc.gridy = 2;
        panelInput.add(new JLabel("Jumlah Tugas"), gbc);

        gbc.gridx = 1;
        String[] items = {"Item 1", "Item 2", "Item 3", "Item 4", "Item 5"};
        JComboBox<String> comboTugas = new JComboBox<>(items);
        panelInput.add(comboTugas, gbc);

        // Panel Bawah (Tombol)
        JPanel panelButton = new JPanel();
        panelButton.setBackground(new Color(255, 200, 200)); // Warna merah muda
        panelButton.setLayout(new FlowLayout());

        JButton btnSimpan = new JButton("Simpan");
        JButton btnHapus = new JButton("Hapus");
        JButton btnTutup = new JButton("Tutup");

        panelButton.add(btnSimpan);
        panelButton.add(btnHapus);
        panelButton.add(btnTutup);

        // Event untuk tombol Tutup
        btnTutup.addActionListener(e -> System.exit(0));

        // Tambahkan panel ke frame
        add(panelInput, BorderLayout.CENTER);
        add(panelButton, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MasterDataPekerjaan frame = new MasterDataPekerjaan();
            frame.setVisible(true);
        });
    }
}
