/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raven.form;

import com.mycompany.domainModel.Loai;
import com.mycompany.domainModel.MonAn;
import com.mycompany.domainModel.NhanVien;
import com.mycompany.service.impl.LoaiService;
import com.mycompany.service.impl.MonAnService;
import java.awt.Component;
import java.awt.Image;
import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

/**
 *
 * @author RAVEN
 */
public class Form_SanPham extends javax.swing.JPanel {

    // gọi service
    private MonAnService monAnService = new MonAnService();
    private LoaiService loaiService = new LoaiService();
    // tạo list
    private List<MonAn> listMonAn = new ArrayList<>();
    // tạo default 
    private DefaultTableModel dtm = new DefaultTableModel();
    private DefaultComboBoxModel dcbm = new DefaultComboBoxModel();
    // tạo thực thể
    private MonAn monAn;
    /// đường dẫn ảnh
    private String selectedImagePath = "";

    /**
     * Creates new form Form_1
     */
    public Form_SanPham(NhanVien nv) {
        initComponents();
        String header[] = {"STT", "MÃ SẢN PHẨM", "TÊN SẢN PHẨM", "ĐƠN GIÁ", "ĐƠN VỊ TÍNH", "ẢNH"};
        dtm.setColumnIdentifiers(header);
        tbMonAn.setModel(dtm);
        cbbLoai.setModel(dcbm);
        tbMonAn.setFillsViewportHeight(true);
        tbMonAn.getColumn("ẢNH").setCellRenderer(new CellRenderer());
        listMonAn = monAnService.getMonAnByTrangThai(0);
        showData(listMonAn);
        txtId.setEnabled(false);
        txtMa.setEnabled(false);
        setCBB();
    }

    class CellRenderer implements TableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table,
                Object value,
                boolean isSelected,
                boolean hasFocus,
                int row,
                int column) {

            TableColumn tb = tbMonAn.getColumn("ẢNH");
            tb.setMaxWidth(100);
            tb.setMinWidth(100);

            tbMonAn.setRowHeight(60);

            return (Component) value;
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    private void clearData() {
        txtDonGia.setText("");
        txtDonViTinh.setText("");
        txtId.setText("");
        txtMa.setText("");
        txtTen.setText("");
        rdoApDung.setSelected(true);
        jLabelImage.setIcon(null);
    }

    private void showData(List<MonAn> listMonAn) {
        dtm.setRowCount(0);
//        int i = 1;
//        for (MonAn ma : list) {
//            dtm.addRow(ma.toDataRow(i++));
//        }
        for (int i = 0; i < listMonAn.size(); i++) {
            if (listMonAn.get(i).getHinhAnh() != null) {
                JLabel imageLabel = new JLabel();
                ImageIcon imageicon = new ImageIcon(listMonAn.get(i).getHinhAnh());
                Image img = imageicon.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
                imageLabel.setIcon(new ImageIcon(img));
                imageLabel.setIcon(imageicon);
                dtm.addRow(new Object[]{i + 1, listMonAn.get(i).getMaMonAn(), listMonAn.get(i).getTenMonAn(), listMonAn.get(i).getDonGia() + "K", listMonAn.get(i).getDonViTinh(), imageLabel});
            } else {
                dtm.addRow(new Object[]{i + 1, listMonAn.get(i).getMaMonAn(), listMonAn.get(i).getTenMonAn(), listMonAn.get(i).getDonGia() + "K", listMonAn.get(i).getDonViTinh(), null});
            }
        }
    }

    private void fillData() {
        txtDonGia.setText(monAn.getDonGia().toString());
        txtDonViTinh.setText(monAn.getDonViTinh());
        txtId.setText(monAn.getId());
        txtMa.setText(monAn.getMaMonAn());
        txtTen.setText(monAn.getTenMonAn());
        cbbLoai.setSelectedItem(monAn.getLoai().getMaLoai());
        if (monAn.getTrangThai() == 0) {
            rdoApDung.setSelected(true);
        } else {
            rdoNgungApDung.setSelected(true);
        }
        ImageIcon imageicon = new ImageIcon(monAn.getHinhAnh());
        Image img = imageicon.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        jLabelImage.setIcon(new ImageIcon(img));
        jLabelImage.setIcon(imageicon);

    }

    private void setCBB() {
        List<Loai> listLoai = loaiService.getAllByTrangThai(0);
        dcbm.removeAllElements();
        for (Loai dm : listLoai) {
            dcbm.addElement(dm.getMaLoai());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        panelBorder1 = new com.raven.swing.PanelBorder();
        searchText1 = new com.raven.swing.SearchText();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtMa = new javax.swing.JTextField();
        txtTen = new javax.swing.JTextField();
        txtId = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtDonGia = new javax.swing.JTextField();
        txtDonViTinh = new javax.swing.JTextField();
        btnAddDanhMuc = new javax.swing.JButton();
        cbbLoai = new javax.swing.JComboBox<>();
        lbLoaiMon = new javax.swing.JLabel();
        rdoApDung = new javax.swing.JRadioButton();
        rdoNgungApDung = new javax.swing.JRadioButton();
        jLabel14 = new javax.swing.JLabel();
        btnLoad = new javax.swing.JButton();
        jLabelImage = new javax.swing.JLabel();
        btnChonAnh = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbMonAn = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        rdoListNgungApDung = new javax.swing.JRadioButton();
        rdoListApDung = new javax.swing.JRadioButton();

        panelBorder1.setBackground(new java.awt.Color(204, 204, 255));

        searchText1.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                searchText1CaretUpdate(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("ID Món Ăn             :");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Loại                        :");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Mã Món Ăn           :");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setText("Tên Món Ăn          :");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setText("Đơn Giá     :");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setText("Đơn vị tính:");

        btnAddDanhMuc.setText("+");
        btnAddDanhMuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddDanhMucActionPerformed(evt);
            }
        });

        cbbLoai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbLoai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbLoaiActionPerformed(evt);
            }
        });

        lbLoaiMon.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbLoaiMon.setText("tenMon");

        buttonGroup2.add(rdoApDung);
        rdoApDung.setSelected(true);
        rdoApDung.setText("Áp dụng");

        buttonGroup2.add(rdoNgungApDung);
        rdoNgungApDung.setText("Ngừng áp dụng");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel14.setText("Trạng thái   :");

        btnLoad.setText("@");
        btnLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadActionPerformed(evt);
            }
        });

        jLabelImage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnChonAnh.setBackground(new java.awt.Color(204, 204, 204));
        btnChonAnh.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnChonAnh.setText("Chọn Ảnh    :");
        btnChonAnh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChonAnhActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDonViTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(rdoApDung)
                                .addGap(18, 18, 18)
                                .addComponent(rdoNgungApDung))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(btnChonAnh)
                                .addGap(18, 18, 18))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel8)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel5)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel7)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(177, 177, 177)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel13)
                                            .addComponent(jLabel12)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(18, 18, 18)
                                        .addComponent(cbbLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lbLoaiMon)
                                        .addGap(88, 88, 88)
                                        .addComponent(btnAddDanhMuc)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnLoad)))
                                .addGap(23, 23, 23)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelImage, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnChonAnh)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(19, 19, 19)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(cbbLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbLoaiMon))
                                .addGap(19, 19, 19))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnLoad)
                                        .addComponent(btnAddDanhMuc))
                                    .addComponent(jLabelImage, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel12)
                                .addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel13)
                                .addComponent(txtDonViTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(rdoApDung)
                            .addComponent(rdoNgungApDung))))
                .addGap(21, 21, 21))
        );

        tbMonAn.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "STT", "MA", "TEN", "DON GIA", "DON VI TINH", "HINH ANH"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Double.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Byte.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbMonAn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbMonAnMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tbMonAn);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Thiết lập thông tin món ăn");

        btnAdd.setBackground(new java.awt.Color(51, 255, 0));
        btnAdd.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnUpdate.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnRemove.setBackground(new java.awt.Color(255, 0, 51));
        btnRemove.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnRemove.setText("Remove");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        btnClear.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Danh sách món ăn");

        buttonGroup1.add(rdoListNgungApDung);
        rdoListNgungApDung.setText("Ngừng áp dụng");
        rdoListNgungApDung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoListNgungApDungActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdoListApDung);
        rdoListApDung.setSelected(true);
        rdoListApDung.setText("Áp dụng");
        rdoListApDung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoListApDungActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(panelBorder1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(searchText1, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 636, Short.MAX_VALUE))
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane5)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(panelBorder1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(36, 36, 36)
                                .addComponent(rdoListApDung)
                                .addGap(32, 32, 32)
                                .addComponent(rdoListNgungApDung)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAdd)
                                .addGap(18, 18, 18)
                                .addComponent(btnUpdate)
                                .addGap(18, 18, 18)
                                .addComponent(btnRemove)
                                .addGap(18, 18, 18)
                                .addComponent(btnClear)))
                        .addContainerGap())))
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(searchText1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(jLabel2)
                .addGap(8, 8, 8)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAdd)
                            .addComponent(btnUpdate)
                            .addComponent(btnRemove)
                            .addComponent(btnClear)
                            .addComponent(jLabel4)))
                    .addGroup(panelBorder1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdoListApDung)
                            .addComponent(rdoListNgungApDung))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddDanhMucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddDanhMucActionPerformed
        // TODO add your handling code here:
        JDialogLoaiMonAn dialogLoaiMonAn = new JDialogLoaiMonAn(null, true);
        dialogLoaiMonAn.setVisible(true);
    }//GEN-LAST:event_btnAddDanhMucActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        String hinhAnh = selectedImagePath;
        if (txtMa.getText().isEmpty()) {
            if (txtTen.getText().isEmpty() || txtTen.getText().matches("\\s+")) {
                JOptionPane.showMessageDialog(this, "Không được để trống tên");
            } else if (txtDonGia.getText().isEmpty() || txtDonGia.getText().matches("\\s+")) {
                JOptionPane.showMessageDialog(this, "Không được để trống đơn giá");
            } else if (txtDonViTinh.getText().isEmpty() || txtDonViTinh.getText().matches("\\s+")) {
                JOptionPane.showMessageDialog(this, "Không được để trống đơn vị tính");
            } else if (txtTen.getText().matches("[0-9]+")) {
                JOptionPane.showMessageDialog(this, "Không đúng định dạng tên");
            } else if (!txtTen.getText().matches("^[A-Za-zÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚÝàáâãèéêìíòóôõùúýĂăĐđĨĩŨũƠơƯưẠ-ỹ ]+$")) {
                JOptionPane.showMessageDialog(this, "Tên không được để kí tự đặc biệt!");
            } else if (!txtDonGia.getText().matches("[0-9]+")) {
                JOptionPane.showMessageDialog(this, "Không đúng định dạng đơn giá");
            } else if (!txtDonViTinh.getText().matches("^[A-Za-zÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚÝàáâãèéêìíòóôõùúýĂăĐđĨĩŨũƠơƯưẠ-ỹ ]+$")) {
                JOptionPane.showMessageDialog(this, "Đơn vị tính không được để kí tự đặc biệt!");
            } else {
                Loai loai = loaiService.getOne((String) cbbLoai.getSelectedItem());
                // bỏ KM khỏi món ăn
//            MonAn ma = new MonAn(null, loai, null, monAnService.maTuDong(), txtTen.getText(), null, new BigDecimal(txtDonGia.getText()), txtDonViTinh.getText(), 0);
                MonAn ma = new MonAn(null, loai, monAnService.maTuDong(), txtTen.getText(), hinhAnh, new BigDecimal(txtDonGia.getText()), txtDonViTinh.getText(), 0);
                int checkConfirm = JOptionPane.showConfirmDialog(this, "Xác nhận thêm!");
                if (checkConfirm == 0) {
                    String add = monAnService.add(ma);
                    JOptionPane.showMessageDialog(this, add);
                    rdoListApDungActionPerformed(evt);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "vui lòng clear trước khi add");
        }
        selectedImagePath = "";
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
        clearData();
    }//GEN-LAST:event_btnClearActionPerformed

    private void tbMonAnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbMonAnMouseClicked
        // TODO add your handling code here:
        int index = tbMonAn.getSelectedRow();
        monAn = listMonAn.get(index);
        fillData();
    }//GEN-LAST:event_tbMonAnMouseClicked

    private void cbbLoaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbLoaiActionPerformed
        // TODO add your handling code here:
        if (cbbLoai.getSelectedItem() != null) {
            String ma = (String) cbbLoai.getSelectedItem();
            Loai loai = loaiService.getOne(ma);
            lbLoaiMon.setText(loai.getTenLoai());
        }
    }//GEN-LAST:event_cbbLoaiActionPerformed

    private void rdoListApDungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoListApDungActionPerformed
        // TODO add your handling code here:
        showData(listMonAn = monAnService.getMonAnByTrangThai(0));
        monAn = null;
        clearData();
    }//GEN-LAST:event_rdoListApDungActionPerformed

    private void rdoListNgungApDungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoListNgungApDungActionPerformed
        // TODO add your handling code here:
        showData(listMonAn = monAnService.getMonAnByTrangThai(1));
        monAn = null;
        clearData();
    }//GEN-LAST:event_rdoListNgungApDungActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        // TODO add your handling code here:
        int index = tbMonAn.getSelectedRow();
        if (index < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn món cần xóa");
        } else {
            int checkConfirm = JOptionPane.showConfirmDialog(this, "Xác nhận xóa!");
            if (checkConfirm == 0) {
                String xoa = monAnService.remove(txtMa.getText());
                JOptionPane.showMessageDialog(this, xoa);
                rdoListNgungApDung.setSelected(true);
                rdoListNgungApDungActionPerformed(evt);
            }
        }
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        //t
        String hinhAnh;
        int index = tbMonAn.getSelectedRow();
        if (index < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn monAn");
        } else {
            MonAn monAnn = listMonAn.get(index);
            hinhAnh = monAnn.getHinhAnh();
            if (selectedImagePath != null) {
                hinhAnh = selectedImagePath;
            } else {
                hinhAnh = monAnn.getHinhAnh();
            }

            int trangThai;
            if (rdoApDung.isSelected()) {
                trangThai = 0;
            } else {
                trangThai = 1;
            }
            //
            if (txtTen.getText().isEmpty() || txtTen.getText().matches("\\s+")) {
                JOptionPane.showMessageDialog(this, "Không được để trống tên");
            } else if (txtDonGia.getText().isEmpty() || txtDonGia.getText().matches("\\s+")) {
                JOptionPane.showMessageDialog(this, "Không được để trống đơn giá");
            } else if (txtDonViTinh.getText().isEmpty() || txtDonViTinh.getText().matches("\\s+")) {
                JOptionPane.showMessageDialog(this, "Không được để trống đơn vị tính");
            } else if (txtTen.getText().matches("[0-9]+")) {
                JOptionPane.showMessageDialog(this, "Không đúng định dạng tên");
            } else if (!txtTen.getText().matches("^[A-Za-zÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚÝàáâãèéêìíòóôõùúýĂăĐđĨĩŨũƠơƯưẠ-ỹ ]+$")) {
                JOptionPane.showMessageDialog(this, "Tên không được để kí tự đặc biệt!");
            } else if (!txtDonGia.getText().matches("[0-9]+")) {
                JOptionPane.showMessageDialog(this, "Không đúng định dạng đơn giá");
            } else if (txtDonViTinh.getText().matches("[0-9]+")) {
                JOptionPane.showMessageDialog(this, "Không đúng định dạng đơn vị tính");
            } else if (!txtDonViTinh.getText().matches("^[A-Za-zÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚÝàáâãèéêìíòóôõùúýĂăĐđĨĩŨũƠơƯưẠ-ỹ ]+$")) {
                JOptionPane.showMessageDialog(this, "Đơn vị tính không được để kí tự đặc biệt!");
            } else {
                Loai loai = loaiService.getOne((String) cbbLoai.getSelectedItem());
                //bỏ KM
//            MonAn ma = new MonAn(monAn.getId(), loai, monAn.getKhuyenMai(), monAn.getMaMonAn(), txtTen.getText(), monAn.getHinhAnh(), new BigDecimal(txtDonGia.getText()), txtDonViTinh.getText(), trangThai);
                MonAn ma = new MonAn(this.monAn.getId(), loai, this.monAn.getMaMonAn(), txtTen.getText(),
                        hinhAnh, new BigDecimal(txtDonGia.getText()), txtDonViTinh.getText(), trangThai);
                int checkConfirm = JOptionPane.showConfirmDialog(this, "Xác nhận update!");
                if (checkConfirm == 0) {
                    String update = monAnService.update(ma, txtMa.getText());
                    JOptionPane.showMessageDialog(this, update);
                    rdoApDung.setSelected(true);
                    rdoListApDungActionPerformed(evt);
                }
            }
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadActionPerformed
        setCBB();
    }//GEN-LAST:event_btnLoadActionPerformed

    private void btnChonAnhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChonAnhActionPerformed
        // TODO add your handling code here:
        JFileChooser browseImageFile = new JFileChooser("C:\\Users\\Public\\Pictures\\Sample Pictures");
        //Filter image extensions
        FileNameExtensionFilter fnef = new FileNameExtensionFilter("IMAGES", "png", "jpg", "jpeg");
        browseImageFile.addChoosableFileFilter(fnef);
        int showOpenDialogue = browseImageFile.showOpenDialog(null);

        if (showOpenDialogue == JFileChooser.APPROVE_OPTION) {
            File selectedImageFile = browseImageFile.getSelectedFile();
            selectedImagePath = selectedImageFile.getAbsolutePath();
            JOptionPane.showMessageDialog(null, "Bạn đã chọn ảnh: " + selectedImagePath);
            //Display image on jlable
            ImageIcon ii = new ImageIcon(selectedImagePath);
//            Resize image to fit jlabel
            Image image = ii.getImage().getScaledInstance(jLabelImage.getWidth(), jLabelImage.getHeight(), Image.SCALE_SMOOTH);
//
            jLabelImage.setIcon(new ImageIcon(image));
        }
    }//GEN-LAST:event_btnChonAnhActionPerformed

    private void searchText1CaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_searchText1CaretUpdate
        // TODO add your handling code here:
        String ten = searchText1.getText();
        listMonAn = monAnService.getMonAnTheoTen(ten);
        showData(listMonAn);
    }//GEN-LAST:event_searchText1CaretUpdate


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnAddDanhMuc;
    private javax.swing.JButton btnChonAnh;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnLoad;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnUpdate;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cbbLoai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelImage;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel lbLoaiMon;
    private com.raven.swing.PanelBorder panelBorder1;
    private javax.swing.JRadioButton rdoApDung;
    private javax.swing.JRadioButton rdoListApDung;
    private javax.swing.JRadioButton rdoListNgungApDung;
    private javax.swing.JRadioButton rdoNgungApDung;
    private com.raven.swing.SearchText searchText1;
    private javax.swing.JTable tbMonAn;
    private javax.swing.JTextField txtDonGia;
    private javax.swing.JTextField txtDonViTinh;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtTen;
    // End of variables declaration//GEN-END:variables
}
