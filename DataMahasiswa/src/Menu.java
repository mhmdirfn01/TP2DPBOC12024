import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Menu extends JFrame {
    private int selectedIndex = -1;
    private ArrayList<Mahasiswa> listMahasiswa;
private Database database;
    private JPanel mainPanel;
    private JTextField nimField;
    private JTextField namaField;
    private JTextField emailField; // Tambahkan JTextField untuk email
    private JTable mahasiswaTable;
    private JButton addUpdateButton;
    private JButton cancelButton;
    private JComboBox<String> jenisKelaminComboBox;
    private JButton deleteButton;
    private JLabel titleLabel;
    private JLabel nimLabel;
    private JLabel namaLabel;
    private JLabel jenisKelaminLabel;

    public Menu() {
        listMahasiswa = new ArrayList<>();
        database = new Database();
        mahasiswaTable.setModel(setTable());
        titleLabel.setFont(titleLabel.getFont().deriveFont(Font.BOLD, 20f));
        String[] JenisKelaminData = {"", "Laki-laki", "Perempuan"};
        String[] jenisKelaminData = new String[0];
        jenisKelaminComboBox.setModel(new DefaultComboBoxModel(jenisKelaminData));
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (selectedIndex == -1) {
                    insertData();
                } else {
                    updateData();
                }
            }
        });
        setSize(480, 560);
        setLocationRelativeTo(null);

        mainPanel = new JPanel();
        mainPanel.setLayout(null);

        titleLabel = new JLabel("Menu Mahasiswa");
        titleLabel.setBounds(180, 10, 200, 30);
        mainPanel.add(titleLabel);

        nimLabel = new JLabel("NIM:");
        nimLabel.setBounds(50, 50, 120, 25);
        mainPanel.add(nimLabel);

        nimField = new JTextField();
        nimField.setBounds(180, 50, 200, 25);
        mainPanel.add(nimField);

        namaLabel = new JLabel("Nama:");
        namaLabel.setBounds(50, 90, 120, 25);
        mainPanel.add(namaLabel);

        namaField = new JTextField();
        namaField.setBounds(180, 90, 200, 25);
        mainPanel.add(namaField);

        // Tambahkan label dan field untuk email
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(50, 130, 120, 25);
        mainPanel.add(emailLabel);

        emailField = new JTextField();
        emailField.setBounds(180, 130, 200, 25);
        mainPanel.add(emailField);

        jenisKelaminLabel = new JLabel("Jenis Kelamin:");
        jenisKelaminLabel.setBounds(50, 170, 120, 25);
        mainPanel.add(jenisKelaminLabel);

        jenisKelaminComboBox = new JComboBox<>();
        jenisKelaminComboBox.setBounds(180, 170, 200, 25);
        mainPanel.add(jenisKelaminComboBox);

        mahasiswaTable = new JTable();
        JScrollPane scrollPane = new JScrollPane(mahasiswaTable);
        scrollPane.setBounds(50, 210, 350, 250);
        mainPanel.add(scrollPane);

        addUpdateButton = new JButton("Add");
        addUpdateButton.setBounds(50, 480, 100, 25);
        mainPanel.add(addUpdateButton);

        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(180, 480, 100, 25);
        mainPanel.add(cancelButton);

        deleteButton = new JButton("Delete");
        deleteButton.setBounds(300, 480, 100, 25);
        mainPanel.add(deleteButton);

        listMahasiswa = new ArrayList<>();
        populateList();
        mahasiswaTable.setModel(setTable());

        titleLabel.setFont(titleLabel.getFont().deriveFont(Font.BOLD, 20f));

        jenisKelaminData = new String[]{"", "laki-laki", "perempuan"};
        jenisKelaminComboBox.setModel(new DefaultComboBoxModel<>(jenisKelaminData));

        deleteButton.setVisible(false);

        addUpdateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (selectedIndex == -1) {
                    insertData();
                } else {
                    updateData();
                }
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (selectedIndex >= 0) {
                    deleteData();
                }
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearForm();
            }
        });

        mahasiswaTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                selectedIndex = mahasiswaTable.getSelectedRow();

                String selectedNim = mahasiswaTable.getModel().getValueAt(selectedIndex, 1).toString();
                String selectedNama = mahasiswaTable.getModel().getValueAt(selectedIndex, 2).toString();
                String selectedEmail = mahasiswaTable.getModel().getValueAt(selectedIndex, 3).toString();
                String selectedJenisKelamin = mahasiswaTable.getModel().getValueAt(selectedIndex, 4).toString();

                nimField.setText(selectedNim);
                namaField.setText(selectedNama);
                emailField.setText(selectedEmail);
                jenisKelaminComboBox.setSelectedItem(selectedJenisKelamin);

                addUpdateButton.setText("Update");
                deleteButton.setVisible(true);
            }
        });

        setContentPane(mainPanel);
        getContentPane().setBackground(Color.white);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    public final DefaultTableModel setTable() {

        Object[] column = {"No", "NIM", "Nama", "Jenis Kelamin", "Email" };

        DefaultTableModel temp = new DefaultTableModel(null, column);
try {
    ResultSet resultSet = database.selectQuery("SELECT * FROM mahasiswa");
    int i = 0;
    while (resultSet.next()) {
        Object[] row = new Object[5];

        row[0] = i + 1;
        row[1] = resultSet.getString("nim");
        row[2] = resultSet.getString("nama");
        row[3] = resultSet.getString("jenis_kelamin");
        row[4] = resultSet.getString("email");

        temp.addRow(row);
        i++;
    }
    }catch(SQLException e){
        throw new RuntimeException(e);
    }
    return temp;

}

    public void insertData() {
        String nim = nimField.getText();
        String nama = namaField.getText();
        String jenisKelamin = jenisKelaminComboBox.getSelectedItem().toString();
        String email = emailField.getText();

        // Periksa apakah ada input yang kosong
        if (nim.isEmpty() || nama.isEmpty() || jenisKelamin.isEmpty() || email.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Silakan lengkapi semua input.", "Error", JOptionPane.ERROR_MESSAGE);
            return; // Keluar dari metode jika ada input yang kosong
        }

        // Periksa apakah NIM sudah ada dalam database
        for (Mahasiswa mahasiswa : listMahasiswa) {
            if (mahasiswa.getNim().equals(nim)) {
                JOptionPane.showMessageDialog(null, "NIM sudah ada dalam database.", "Error", JOptionPane.ERROR_MESSAGE);
                return; // Keluar dari metode jika NIM sudah ada
            }
        }

        // Lanjutkan dengan operasi insert jika NIM belum ada dalam database
        String sql = "INSERT INTO mahasiswa VALUES (null, '" + nim + "', '" + nama + "', '" + email + "', '" + jenisKelamin + "' );";
        database.insertUpdateDeleteQuery(sql);
        mahasiswaTable.setModel(setTable());

        clearForm();
        JOptionPane.showMessageDialog(null, "Data berhasil ditambahkan");

        listMahasiswa.add(new Mahasiswa(nim, nama, jenisKelamin, email));
        mahasiswaTable.setModel(setTable());
        clearForm();
        JOptionPane.showMessageDialog(null, "Data berhasil ditambahkan");
    }


    public void updateData() {
        String nim = nimField.getText();
        String nama = namaField.getText();
        String email = emailField.getText();
        String jenisKelamin = jenisKelaminComboBox.getSelectedItem().toString();

        // Periksa apakah ada input yang kosong
        if (nim.isEmpty() || nama.isEmpty() || jenisKelamin.isEmpty() || email.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Silakan lengkapi semua input.", "Error", JOptionPane.ERROR_MESSAGE);
            return; // Keluar dari metode jika ada input yang kosong
        }

        // Lanjutkan dengan operasi update jika semua input sudah diisi
        String sql = "UPDATE mahasiswa SET nama = '" + nama + "', email = '" + email + "', jenis_kelamin = '" + jenisKelamin + "' WHERE nim = '" + nim + "';";

        database.insertUpdateDeleteQuery(sql);

        mahasiswaTable.setModel(setTable());

        clearForm();

        JOptionPane.showMessageDialog(null, "Data berhasil diubah");
    }



    public void deleteData() {
        int dialogResult = JOptionPane.showConfirmDialog(null, "Anda yakin ingin menghapus data ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (dialogResult == JOptionPane.YES_OPTION) {
            String nim = nimField.getText();

            // Persiapkan query SQL untuk menghapus data mahasiswa berdasarkan NIM
            String sql = "DELETE FROM mahasiswa WHERE nim = '" + nim + "';";

            // Jalankan query delete ke database
            database.insertUpdateDeleteQuery(sql);

            // Hapus data dari list
            listMahasiswa.remove(selectedIndex);

            // Perbarui model tabel
            mahasiswaTable.setModel(setTable());

            // Bersihkan formulir
            clearForm();

            // Tampilkan pesan sukses
            JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
        }
    }


    public void clearForm() {
        nimField.setText("");
        namaField.setText("");
        emailField.setText("");
        jenisKelaminComboBox.setSelectedItem("");

        addUpdateButton.setText("Add");
        deleteButton.setVisible(false);
        selectedIndex = -1;
    }

    private void populateList() {
        listMahasiswa.add(new Mahasiswa("2203999", "Amelia Zalfa Julianti", "Perempuan", "example@gmail.com"));
        listMahasiswa.add(new Mahasiswa("2202292", "Muhammad Iqbal Fadhilah", "Laki-laki", "example@gmail.com"));
        listMahasiswa.add(new Mahasiswa("2202346", "Muhammad Rifky Afandi", "Laki-laki", "example@gmail.com"));
        listMahasiswa.add(new Mahasiswa("2210239", "Muhammad Hanif Abdillah", "Laki-laki", "example@gmail.com"));
        listMahasiswa.add(new Mahasiswa("2202046", "Nurainun", "Perempuan", "example@gmail.com"));
        listMahasiswa.add(new Mahasiswa("2205101", "Kelvin Julian Putra", "Laki-laki", "example@gmail.com"));
        listMahasiswa.add(new Mahasiswa("2200163", "Rifanny Lysara Annastasya", "Perempuan", "example@gmail.com"));
        listMahasiswa.add(new Mahasiswa("2202869", "Revana Faliha Salma", "Perempuan", "example@gmail.com"));
        listMahasiswa.add(new Mahasiswa("2209489", "Rakha Dhifiargo Hariadi", "Laki-laki", "example@gmail.com"));
        listMahasiswa.add(new Mahasiswa("2203142", "Roshan Syalwan Nurilham", "Laki-laki", "example@gmail.com"));
        listMahasiswa.add(new Mahasiswa("2200311", "Raden Rahman Ismail", "Laki-laki", "example@gmail.com"));
        listMahasiswa.add(new Mahasiswa("2200978", "Ratu Syahirah Khairunnisa", "Perempuan", "example@gmail.com"));
        listMahasiswa.add(new Mahasiswa("2204509", "Muhammad Fahreza Fauzan", "Laki-laki", "example@gmail.com"));
        listMahasiswa.add(new Mahasiswa("2205027", "Muhammad Rizki Revandi", "Laki-laki", "example@gmail.com"));
        listMahasiswa.add(new Mahasiswa("2203484", "Arya Aydin Margono", "Laki-laki", "example@gmail.com"));
        listMahasiswa.add(new Mahasiswa("2200481", "Marvel Ravindra Dioputra", "Laki-laki", "example@gmail.com"));
        listMahasiswa.add(new Mahasiswa("2209889", "Muhammad Fadlul Hafiizh", "Laki-laki", "example@gmail.com"));
        listMahasiswa.add(new Mahasiswa("2206697", "Rifa Sania", "Perempuan", "example@gmail.com"));
        listMahasiswa.add(new Mahasiswa("2207260", "Imam Chalish Rafidhul Haque", "Laki-laki", "example@gmail.com"));
        listMahasiswa.add(new Mahasiswa("2204343", "Meiva Labibah Putri", "Perempuan", "example@gmail.com"));
    }

    public static void main(String[] args) {
        Menu window = new Menu();
        window.setVisible(true);
    }
}
