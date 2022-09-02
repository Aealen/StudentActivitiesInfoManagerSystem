/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;

import bean.Activity;
import service.ActService;
import service.UsrActService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 *
 * @author Aealen
 */
public class AdminEditActUI extends javax.swing.JFrame {
    private ActService actService;
    private UsrActService usrActService;
    private Activity activity;
    /** Creates new form AdminEditActUI */
    public AdminEditActUI() {
        actService=new ActService();
        usrActService=new UsrActService();
        activity=new Activity();

        initComponents();
        this.setTitle("学生活动管理系统丨编辑活动");
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setSize(600,450);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        ActIDEd = new javax.swing.JLabel();
        ActIDEdText = new javax.swing.JTextField();
        DelActBt = new javax.swing.JButton();
        UpdateActBt = new javax.swing.JButton();
        ActDescLabel = new javax.swing.JLabel();
        DescScroll = new javax.swing.JScrollPane();
        UpdateActDescTextArea = new javax.swing.JTextArea();
        UpdateActTimeLabel = new javax.swing.JLabel();
        UpdateActTimeText = new javax.swing.JTextField();
        UpdateActStatusLabel = new javax.swing.JLabel();
        UpdateActStatusCombox = new javax.swing.JComboBox<>();
        UpdateActNameLabel = new javax.swing.JLabel();
        UpdateActNameText = new javax.swing.JTextField();
        AdminActTableScroll = new javax.swing.JScrollPane();
        ActShowTable = new javax.swing.JTable();
        AdminMenu = new javax.swing.JMenuBar();
        ActMenu = new javax.swing.JMenu();
        UsrQueryAct = new javax.swing.JMenuItem();
        UsrEditAct = new javax.swing.JMenuItem();
        UsrMenu = new javax.swing.JMenu();
        UsrQuitSystem = new javax.swing.JMenuItem();
        ActManagementMenu = new javax.swing.JMenu();
        AddAct = new javax.swing.JMenuItem();
        editAct = new javax.swing.JMenuItem();
        UsrManagementMenu = new javax.swing.JMenu();
        UsrManagement = new javax.swing.JMenuItem();


        ActShowTable.setFont(new java.awt.Font("宋体", 0, 13)); // NOI18N
        DefaultTableModel model=new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                        "ID", "Name", "Desc", "Time", "Remain", "Status"
                }
        ) {
            Class[] types = new Class [] {
                    java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                    false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        };
        ActShowTable.setModel(model);
        ActShowTable.setModel(model);
        AdminActTableScroll.setViewportView(ActShowTable);
        if (ActShowTable.getColumnModel().getColumnCount() > 0) {
            ActShowTable.getColumnModel().getColumn(0).setPreferredWidth(40);
            ActShowTable.getColumnModel().getColumn(1).setPreferredWidth(100);
            ActShowTable.getColumnModel().getColumn(2).setPreferredWidth(220);
            ActShowTable.getColumnModel().getColumn(3).setPreferredWidth(80);
            ActShowTable.getColumnModel().getColumn(4).setPreferredWidth(60);
            ActShowTable.getColumnModel().getColumn(5).setPreferredWidth(70);
        }
        ActShowTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);//不自动画框
        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        ActIDEd.setFont(new java.awt.Font("宋体", 0, 18)); // NOI18N
        ActIDEd.setText("编号:");
        ActIDEd.setForeground(new java.awt.Color(255, 51, 51));


        ActIDEdText.setFont(new java.awt.Font("宋体", 0, 18)); // NOI18N
        ActIDEdText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActIDEdTextActionPerformed(evt);
            }
        });

        DelActBt.setFont(new java.awt.Font("宋体", 0, 18)); // NOI18N
        DelActBt.setText("删除活动");
        DelActBt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                activity=actService.queryActById(ActIDEdText.getText()).get(0);

                if (actService.DelAct(activity)){
                    JOptionPane.showMessageDialog(null,"活动删除成功!!");
                    List<Activity> actList = actService.queryAct();
                    int remainNum;
                    String Status = new String();
                    model.setRowCount(0);
                    for (int i = 0; i < actList.size(); i++) {
                        remainNum = Integer.valueOf(actList.get(i).getMaxNum()) - Integer.valueOf(actList.get(i).getCurrentNum());
                        if (actList.get(i).getStatus().equals("0"))
                            Status = "未进行";
                        else if (actList.get(i).getStatus().equals("1"))
                            Status = "正在进行";
                        else if (actList.get(i).getStatus().equals("2"))
                            Status = "已结束";
                        model.addRow(new Object[]{
                                actList.get(i).getId(),
                                actList.get(i).getName(),
                                actList.get(i).getDesc(),
                                actList.get(i).getTime(),
                                remainNum,
                                Status,
                                usrActService.UsrJoinedAct(actList.get(i))
                        });
                    }
                }else {
                    JOptionPane.showMessageDialog(null,"活动删除操作发生错误,请检查输入!!");
                }
            }
        });

        UpdateActBt.setFont(new java.awt.Font("宋体", 0, 18)); // NOI18N
        UpdateActBt.setText("更新活动");
        UpdateActBt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                activity=actService.queryActById(ActIDEdText.getText()).get(0);
                if (UpdateActNameText.getText().length()!=0)
                    activity.setName(UpdateActNameText.getText());
                if (UpdateActDescTextArea.getText().length()!=0)
                    activity.setDesc(UpdateActDescTextArea.getText());
                if (UpdateActTimeText.getText().length()!=0)
                    activity.setTime(UpdateActTimeText.getText());
                if (UpdateActStatusCombox.getSelectedIndex()!=3)
                    activity.setStatus(String.valueOf(UpdateActStatusCombox.getSelectedIndex()));
                if (actService.EditAct(activity)) {
                    JOptionPane.showMessageDialog(null,"活动信息更新成功!!");
                    List<Activity> actList = actService.queryAct();
                    int remainNum;
                    String Status = new String();
                    model.setRowCount(0);
                    for (int i = 0; i < actList.size(); i++) {
                        remainNum = Integer.valueOf(actList.get(i).getMaxNum()) - Integer.valueOf(actList.get(i).getCurrentNum());
                        if (actList.get(i).getStatus().equals("0"))
                            Status = "未进行";
                        else if (actList.get(i).getStatus().equals("1"))
                            Status = "正在进行";
                        else if (actList.get(i).getStatus().equals("2"))
                            Status = "已结束";
                        model.addRow(new Object[]{
                                actList.get(i).getId(),
                                actList.get(i).getName(),
                                actList.get(i).getDesc(),
                                actList.get(i).getTime(),
                                remainNum,
                                Status,
                                usrActService.UsrJoinedAct(actList.get(i))
                        });
                    }

                }else {
                    JOptionPane.showMessageDialog(null,"活动信息更新操作出现错误,请检查输入!!!");
                }
            }
        });

        ActDescLabel.setFont(new java.awt.Font("宋体", 0, 18)); // NOI18N
        ActDescLabel.setText("活动描述:");

        UpdateActDescTextArea.setColumns(20);
        UpdateActDescTextArea.setRows(5);
        DescScroll.setViewportView(UpdateActDescTextArea);

        UpdateActTimeLabel.setFont(new java.awt.Font("宋体", 0, 18)); // NOI18N
        UpdateActTimeLabel.setText("活动时间:");

        UpdateActTimeText.setFont(new java.awt.Font("宋体", 0, 18)); // NOI18N
        UpdateActTimeText.setText("样式:1999-12-31");

        UpdateActStatusLabel.setFont(new java.awt.Font("宋体", 0, 18)); // NOI18N
        UpdateActStatusLabel.setText("活动状态:");

        UpdateActStatusCombox.setFont(new java.awt.Font("宋体", 0, 18)); // NOI18N
        UpdateActStatusCombox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "未开始", "正在进行", "已结束" }));
        UpdateActStatusCombox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateActStatusComboxActionPerformed(evt);
            }
        });

        UpdateActNameLabel.setFont(new java.awt.Font("宋体", 0, 18)); // NOI18N
        UpdateActNameLabel.setText("活动名称:");

        UpdateActNameText.setFont(new java.awt.Font("宋体", 0, 18)); // NOI18N


        {
            List<Activity> actList = actService.queryAct();
            int remainNum;
            String Status = new String();
            model.setRowCount(0);
            for (int i = 0; i < actList.size(); i++) {
                remainNum = Integer.valueOf(actList.get(i).getMaxNum()) - Integer.valueOf(actList.get(i).getCurrentNum());
                if (actList.get(i).getStatus().equals("0"))
                    Status = "未进行";
                else if (actList.get(i).getStatus().equals("1"))
                    Status = "正在进行";
                else if (actList.get(i).getStatus().equals("2"))
                    Status = "已结束";
                model.addRow(new Object[]{
                        actList.get(i).getId(),
                        actList.get(i).getName(),
                        actList.get(i).getDesc(),
                        actList.get(i).getTime(),
                        remainNum,
                        Status,
                        usrActService.UsrJoinedAct(actList.get(i))
                });
            }
        }

        ActMenu.setText("活动");

        UsrQueryAct.setText("活动查询");
        UsrQueryAct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsrQueryActActionPerformed(evt);
            }
        });
        ActMenu.add(UsrQueryAct);

        UsrEditAct.setText("活动编辑");
        UsrEditAct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsrEditActActionPerformed(evt);
            }
        });
        ActMenu.add(UsrEditAct);

        AdminMenu.add(ActMenu);

        UsrMenu.setText("用户");

        UsrQuitSystem.setText("注销");
        UsrQuitSystem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsrQuitSystemActionPerformed(evt);
            }
        });
        UsrMenu.add(UsrQuitSystem);

        AdminMenu.add(UsrMenu);

        ActManagementMenu.setText("活动管理");

        AddAct.setText("新增活动");
        AddAct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddActActionPerformed(evt);
            }
        });
        ActManagementMenu.add(AddAct);

        editAct.setText("编辑活动");
        editAct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActActionPerformed(evt);
            }
        });
        ActManagementMenu.add(editAct);

        AdminMenu.add(ActManagementMenu);

        UsrManagementMenu.setText("用户管理");

        UsrManagement.setText("用户管理");
        UsrManagement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsrManagementActionPerformed(evt);
            }
        });
        UsrManagementMenu.add(UsrManagement);

        AdminMenu.add(UsrManagementMenu);

        setJMenuBar(AdminMenu);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(30, 30, 30)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(ActDescLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 90, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(ActIDEd, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 54, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createSequentialGroup()
                                .add(3, 3, 3)
                                .add(ActIDEdText, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 63, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                    .add(DelActBt, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 110, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(UpdateActStatusLabel))
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(layout.createSequentialGroup()
                                        .add(81, 81, 81)
                                        .add(UpdateActBt))
                                    .add(layout.createSequentialGroup()
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                        .add(UpdateActStatusCombox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                            .add(layout.createSequentialGroup()
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(DescScroll, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 452, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(18, Short.MAX_VALUE))
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createSequentialGroup()
                                .add(UpdateActNameLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 90, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(UpdateActNameText, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 150, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(layout.createSequentialGroup()
                                .add(UpdateActTimeLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 90, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(UpdateActTimeText, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 150, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(AdminActTableScroll, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 580, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(ActIDEdText, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 31, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(ActIDEd, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 22, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(DelActBt, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 30, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(UpdateActBt))
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(UpdateActNameLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(UpdateActNameText, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(19, 19, 19)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE, false)
                        .add(UpdateActStatusLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(UpdateActStatusCombox, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                        .add(UpdateActTimeLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 28, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(UpdateActTimeText, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(ActDescLabel)
                    .add(DescScroll, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 53, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(18, 18, 18)
                .add(AdminActTableScroll, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 136, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ActIDEdTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActIDEdTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ActIDEdTextActionPerformed

    private void UpdateActStatusComboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateActStatusComboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UpdateActStatusComboxActionPerformed

    private void UsrQueryActActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsrQueryActActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new QueryActUI().setVisible(true);
    }//GEN-LAST:event_UsrQueryActActionPerformed

    private void UsrEditActActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsrEditActActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new EditActUI().setVisible(true);
    }//GEN-LAST:event_UsrEditActActionPerformed

    private void UsrQuitSystemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsrQuitSystemActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new LoginUI().setVisible(true);
    }//GEN-LAST:event_UsrQuitSystemActionPerformed

    private void AddActActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddActActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new AdminAddActUI().setVisible(true);
    }//GEN-LAST:event_AddActActionPerformed

    private void editActActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActActionPerformed
        // TODO add your handling code here:
        //this.dispose();
        //new AdminEditActUI().setVisible(true);
    }//GEN-LAST:event_editActActionPerformed

    private void UsrManagementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsrManagementActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new UsrManageUI().setVisible(true);
    }//GEN-LAST:event_UsrManagementActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AdminEditActUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminEditActUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminEditActUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminEditActUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminEditActUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ActDescLabel;
    private javax.swing.JLabel ActIDEd;
    private javax.swing.JTextField ActIDEdText;
    private javax.swing.JMenu ActManagementMenu;
    private javax.swing.JMenu ActMenu;
    private javax.swing.JTable ActShowTable;
    private javax.swing.JMenuItem AddAct;
    private javax.swing.JScrollPane AdminActTableScroll;
    private javax.swing.JMenuBar AdminMenu;
    private javax.swing.JButton DelActBt;
    private javax.swing.JScrollPane DescScroll;
    private javax.swing.JButton UpdateActBt;
    private javax.swing.JTextArea UpdateActDescTextArea;
    private javax.swing.JLabel UpdateActNameLabel;
    private javax.swing.JTextField UpdateActNameText;
    private javax.swing.JComboBox<String> UpdateActStatusCombox;
    private javax.swing.JLabel UpdateActStatusLabel;
    private javax.swing.JLabel UpdateActTimeLabel;
    private javax.swing.JTextField UpdateActTimeText;
    private javax.swing.JMenuItem UsrEditAct;
    private javax.swing.JMenuItem UsrManagement;
    private javax.swing.JMenu UsrManagementMenu;
    private javax.swing.JMenu UsrMenu;
    private javax.swing.JMenuItem UsrQueryAct;
    private javax.swing.JMenuItem UsrQuitSystem;
    private javax.swing.JMenuItem editAct;
    private javax.swing.JMenuItem jMenuItem1;
    // End of variables declaration//GEN-END:variables

}