/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package btvn1;

import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;


public class GUI extends JFrame {
    private ArrayList<Class> classs;
    private JComboBox<String> classComboBox;
    private JTable studentTable;
    private DefaultTableModel tableModel;
    private JLabel summaryLabel;

    public GUI() {
        initData();
        setTitle("Quản Lý Lớp Học CNTT");
        setSize(800, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initComponents();
    }

    private void initData() {
        classs = new ArrayList<>();
        Class class1 = new Class("CNTT1");
        class1.add_student(new Student("Nguyễn", "An", "01-02-2004", "Hà Nội", "CNTT1",
                9.0, 8.5, 8.0, 9.0, 8.5));
        class1.add_student(new Student("Trần", "Bình", "10-01-2004", "Hồ Chí Minh", "CNTT1",
                6.0, 7.0, 6.5, 6.0, 7.0));
        class1.add_student(new Student("Vũ", "Hưng", "03-04-2004", "Hồ Chí Minh", "CNTT1",
                8.0, 7.0, 7.5, 7.0, 6.0));
        class1.add_student(new Student("Hoàng", "Nam", "06-10-2003", "Hưng Yên", "CNTT1",
                9.0, 5.0, 6.5, 6.0, 7.0));
        classs.add(class1);

        Class class2 = new Class("CNTT2");
        class2.add_student(new Student("Hoàng", "Anh", "05-05-2002", "Hải Phòng", "CNTT2",
                8.5, 8.0, 9.0, 8.5, 9.0));
        class2.add_student(new Student("Đỗ", "Bảo", "06-06-2003", "Cần Thơ", "CNTT2",
                6.5, 6.0, 7.0, 6.5, 6.0));
        class2.add_student(new Student("Trần", "Cung", "09-06-2004", "Hà Nội", "CNTT2",
                8.5, 7.0, 8.0, 7.5, 8.0));
        class2.add_student(new Student("Nguyễn", "Văn", "10-08-2004", "Cần Thơ", "CNTT2",
                6.5, 9.0, 7.0, 6.5, 7.0));
        classs.add(class2);
    }

    private void initComponents() {
        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("Chọn lớp:"));

        classComboBox = new JComboBox<>();
        for (Class x : classs) {
            classComboBox.addItem(x.getClassName());
        }
        topPanel.add(classComboBox);

        JButton viewButton = new JButton("Xem danh sách");
        topPanel.add(viewButton);
        mainPanel.add(topPanel, BorderLayout.NORTH);

        // Tạo bảng
        String[] columnNames = {"Họ", "Tên", "Ngày sinh", "Địa chỉ", "Lớp", "Điểm TB", "Xếp loại"};
        tableModel = new DefaultTableModel(columnNames, 0);
        studentTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(studentTable);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        summaryLabel = new JLabel("Tổng kết: ");
        mainPanel.add(summaryLabel, BorderLayout.SOUTH);
        add(mainPanel);

        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedClass = (String) classComboBox.getSelectedItem();
                Class selectedClassRoom = findClassRoom(selectedClass);
                if (selectedClassRoom != null) {
                    displayStudents(selectedClassRoom);
                    displaySummary(selectedClassRoom);
                }
            }
        });
    }

    private Class findClassRoom(String className) {
        for (Class x : classs) {
            if (x.getClassName().equals(className)) {
                return x;
            }
        }
        return null;
    }

    private void displayStudents(Class cl) {
        tableModel.setRowCount(0);
        for (Student s : cl.getStudent()) {
            Object[] rowData = {
                s.getFirstName(),s.getLastName(), s.getBirthdate(),
                s.getAddress(), s.getClassName(), String.format("%.2f", s.diem_TB()), s.xepLoai()
            };
            tableModel.addRow(rowData);
        }
    }

    private void displaySummary(Class cl) {
        int countA = cl.countRank("A");
        int countB = cl.countRank("B");
        int countC = cl.countRank("C");
        int countD = cl.countRank("D");
        int countF = cl.countRank("<D");
        summaryLabel.setText("Tổng kết: A: " + countA + "   -   B: " + countB +
                "   -   C: " + countC + "   -   D: " + countD + "   -   <D: " + countF);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GUI().setVisible(true));
    }
}
