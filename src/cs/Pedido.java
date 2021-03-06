/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs;

import Conectar.Conectar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author usuario
 */
public class Pedido extends javax.swing.JFrame {

    /**
     * Creates new form RegistroComida
     */

    DefaultTableModel modelo;
    public Pedido() {
        initComponents();
        actualizar();
    }
    
    
    private void actualizar(){
        modelo=new DefaultTableModel();
        modelo.addColumn("Código del pedido");
        modelo.addColumn("Número de mesa");
        modelo.addColumn("Estado del pedido");
        modelo.addColumn("Monto del pedido");
        
        
        this.jTable1.setModel(modelo);
        this.setLocationRelativeTo(null);
        try{
            
            PreparedStatement ps = null;
            ResultSet rs = null;
            
            Conectar conn = new Conectar();
            Connection con = conn.getConnection();
            
            String sql = "SELECT PEDCOD, PEDNUMMES, PEDESTCOD, PEDTOT FROM PEDIDO";
            
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            ResultSetMetaData rsMd = rs.getMetaData();
            int cantidadColumnas = rsMd.getColumnCount();
         
            
            while(rs.next()){
                Object[] filas = new Object[cantidadColumnas];
                for(int i = 0; i<cantidadColumnas; i++){
                    if(i!=2){
                        filas[i] = rs.getObject(i + 1);
                    }
                    else{
                        ResultSet rs2 = null;
                        sql = "SELECT ESTNOM FROM ESTADO WHERE ESTCOD = ?";
                        ps = con.prepareStatement(sql);
                        ps.setString(1, rs.getObject(i+1).toString());
                        rs2 = ps.executeQuery();
                        rs2.next();
                        filas[i] = rs2.getObject(1);
                    }
                }
                modelo.addRow(filas);              
            }
            
            conn.desconectar();
        }
        catch(SQLException ex){
            System.err.println(ex.toString());
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(74, 4, 21));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setBackground(new java.awt.Color(204, 204, 204));
        jLabel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 610, 60));

        jTable1.setBackground(new java.awt.Color(74, 4, 21));
        jTable1.setForeground(new java.awt.Color(255, 255, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Código de pedido", "Numero de mesa", "Estado del pedido", "Monto del pedido"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setSelectionBackground(new java.awt.Color(204, 204, 204));
        jTable1.setSelectionForeground(new java.awt.Color(0, 0, 0));
        jScrollPane2.setViewportView(jTable1);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 590, 100));

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setText("Listado de pedidos");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, -1, -1));

        jButton1.setIcon(new javax.swing.ImageIcon("C:\\Users\\maxim\\Documents\\NetBeansProjects\\CS\\src\\imagen\\Vector (3).png")); // NOI18N
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 30, -1, -1));

        jButton4.setFont(new java.awt.Font("Yu Gothic Light", 0, 11)); // NOI18N
        jButton4.setText("MODIFICAR");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 320, -1, 20));
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 320, 20, 20));

        jButton2.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 11)); // NOI18N
        jButton2.setText("VER");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 320, -1, 20));
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 320, 20, 20));

        jLabel9.setBackground(new java.awt.Color(204, 204, 204));
        jLabel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 610, 190));

        jLabel10.setBackground(new java.awt.Color(204, 204, 204));
        jLabel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 610, 190));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 480));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
       int fila = jTable1.getSelectedRow();   
        String codigo = jTable1.getValueAt(fila, 0).toString();
        String estado = jTable1.getValueAt(fila, 2).toString();
        try{
            Conectar conn = new Conectar();
            Connection con = conn.getConnection();
            PreparedStatement ps = null;
            String sql;
            ResultSet rs2 = null;
            sql = "SELECT ESTCOD FROM ESTADO WHERE ESTNOM = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, estado);
            rs2 = ps.executeQuery();
            rs2.next();
            int estadoActual = (int)rs2.getObject(1);
            if(estadoActual != 4){
                sql = "UPDATE PEDIDO SET PEDESTCOD = ? WHERE PEDCOD = ?";
                ps = con.prepareStatement(sql);
                ps.setString(1, (++estadoActual)+"");
                ps.setString(2, codigo);
                ps.executeUpdate();
            }
        }
        catch(SQLException ex){
            System.err.println(ex.toString());
        }
        actualizar();

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        DetallePedido detalle =new DetallePedido();
        detalle.setVisible(true);
     
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int fila = jTable1.getSelectedRow();
        String indice = jTable1.getValueAt(fila, 0).toString();
        Factura fac=new Factura(indice);
        fac.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    
    
    public void setBox(JTable tabla,TableColumn columna){
        JComboBox c=new JComboBox();
        c.addItem("Postre");
        c.addItem("Bebidas");
        c.addItem("Comida");
        
        columna.setCellEditor(new DefaultCellEditor(c));
        DefaultTableCellRenderer renderer=new DefaultTableCellRenderer();
        renderer.setToolTipText("Selecione categoria");
        columna.setCellRenderer(renderer);
    }
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
            java.util.logging.Logger.getLogger(Pedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pedido().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
