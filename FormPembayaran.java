import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FormPembayaran extends JFrame implements ActionListener {
    private JTextField txtNoMeja, txtTotalPesan, txtPPN, txtUangBayar, txtUangKembali, txtTotalPendapatan;
    private JTextArea areaStruk;
    private JButton btnStruk, btnBayar;
    private JTable table;
    private double totalPendapatan = 0;

    public FormPembayaran() {
        setTitle("Form Pembayaran");
        setSize(600, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        JLabel lblNoMeja = new JLabel("NO. MEJA");
        lblNoMeja.setBounds(20, 20, 100, 20);
        add(lblNoMeja);

        txtNoMeja = new JTextField();
        txtNoMeja.setBounds(140, 20, 150, 20);
        add(txtNoMeja);

        JLabel lblTotalPesan = new JLabel("TOTAL PESANAN");
        lblTotalPesan.setBounds(20, 50, 100, 20);
        add(lblTotalPesan);

        txtTotalPesan = new JTextField();
        txtTotalPesan.setBounds(140, 50, 150, 20);
        add(txtTotalPesan);

        JLabel lblPPN = new JLabel("PPN");
        lblPPN.setBounds(20, 80, 100, 20);
        add(lblPPN);

        txtPPN = new JTextField();
        txtPPN.setBounds(140, 80, 150, 20);
        add(txtPPN);

        JLabel lblUangBayar = new JLabel("UANG PEMBAYARAN");
        lblUangBayar.setBounds(20, 110, 120, 20);
        add(lblUangBayar);

        txtUangBayar = new JTextField();
        txtUangBayar.setBounds(140, 110, 150, 20);
        add(txtUangBayar);

        JLabel lblUangKembali = new JLabel("UANG KEMBALI");
        lblUangKembali.setBounds(20, 140, 100, 20);
        add(lblUangKembali);

        txtUangKembali = new JTextField();
        txtUangKembali.setBounds(140, 140, 150, 20);
        txtUangKembali.setEditable(false);
        add(txtUangKembali);

        areaStruk = new JTextArea();
        areaStruk.setBounds(320, 20, 250, 140);
        add(areaStruk);

        btnStruk = new JButton("STRUK");
        btnStruk.setBounds(50, 180, 100, 30);
        btnStruk.addActionListener(this);
        add(btnStruk);

        btnBayar = new JButton("BAYAR");
        btnBayar.setBounds(170, 180, 100, 30);
        btnBayar.addActionListener(this);
        add(btnBayar);

        String[] columnNames = {"Title 1", "Title 2", "Title 3", "Title 4"};
        Object[][] data = {}; // Kosong dulu
        table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(20, 230, 550, 150);
        add(scrollPane);

        JLabel lblTotalPendapatan = new JLabel("TOTAL PENDAPATAN");
        lblTotalPendapatan.setBounds(350, 390, 150, 20);
        add(lblTotalPendapatan);

        txtTotalPendapatan = new JTextField();
        txtTotalPendapatan.setBounds(480, 390, 90, 20);
        txtTotalPendapatan.setEditable(false);
        add(txtTotalPendapatan);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnBayar) {
            double totalPesanan = Double.parseDouble(txtTotalPesan.getText());
            double ppn = Double.parseDouble(txtPPN.getText());
            double uangBayar = Double.parseDouble(txtUangBayar.getText());

            double totalBayar = totalPesanan + (totalPesanan * ppn / 100);
            double uangKembali = uangBayar - totalBayar;

            txtUangKembali.setText(String.format("%.2f", uangKembali));

            // Update total pendapatan
            totalPendapatan += totalBayar;
            txtTotalPendapatan.setText(String.format("%.2f", totalPendapatan));
        }

        if (e.getSource() == btnStruk) {
            areaStruk.setText(
                "=== STRUK PEMBAYARAN ===\n" +
                "No Meja : " + txtNoMeja.getText() + "\n" +
                "Total Pesanan : " + txtTotalPesan.getText() + "\n" +
                "PPN : " + txtPPN.getText() + "%\n" +
                "Uang Pembayaran : " + txtUangBayar.getText() + "\n" +
                "Uang Kembali : " + txtUangKembali.getText() + "\n" +
                "========================="
            );
        }
    }

    public static void main(String[] args) {
        FormPembayaran form = new FormPembayaran();
        form.setVisible(true);
    }
}

