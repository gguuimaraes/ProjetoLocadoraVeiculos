package data.frames;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;

public class TelaPrincipal extends JFrame {

    public TelaPrincipal() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuClientes = new javax.swing.JMenu();
        jMenuItemCadastrarCliente = new javax.swing.JMenuItem();
        jMenuItemConsultarClientes = new javax.swing.JMenuItem();
        jMenuMarcas = new javax.swing.JMenu();
        jMenuItemCadastrarMarca = new javax.swing.JMenuItem();
        jMenuItemConsultarMarcas = new javax.swing.JMenuItem();
        jMenuFrota = new javax.swing.JMenu();
        jMenuItemCadastrarVeiculo = new javax.swing.JMenuItem();
        jMenuItemConsultarVeiculos = new javax.swing.JMenuItem();
        jMenuLocacao = new javax.swing.JMenu();
        jMenuItemLocar = new javax.swing.JMenuItem();
        jMenuItemDevolver = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(800, 640));

        javax.swing.GroupLayout jDesktopPaneLayout = new javax.swing.GroupLayout(jDesktopPane);
        jDesktopPane.setLayout(jDesktopPaneLayout);
        jDesktopPaneLayout.setHorizontalGroup(
            jDesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        jDesktopPaneLayout.setVerticalGroup(
            jDesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 619, Short.MAX_VALUE)
        );

        jMenuClientes.setText("Clientes");

        jMenuItemCadastrarCliente.setText("Cadastro");
        jMenuItemCadastrarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCadastrarClienteActionPerformed(evt);
            }
        });
        jMenuClientes.add(jMenuItemCadastrarCliente);

        jMenuItemConsultarClientes.setText("Consultar");
        jMenuItemConsultarClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemConsultarClientesActionPerformed(evt);
            }
        });
        jMenuClientes.add(jMenuItemConsultarClientes);

        jMenuBar1.add(jMenuClientes);

        jMenuMarcas.setText("Marcas");

        jMenuItemCadastrarMarca.setText("Cadastro");
        jMenuItemCadastrarMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCadastrarMarcaActionPerformed(evt);
            }
        });
        jMenuMarcas.add(jMenuItemCadastrarMarca);

        jMenuItemConsultarMarcas.setText("Consultar");
        jMenuItemConsultarMarcas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemConsultarMarcasActionPerformed(evt);
            }
        });
        jMenuMarcas.add(jMenuItemConsultarMarcas);

        jMenuBar1.add(jMenuMarcas);

        jMenuFrota.setText("Frota");

        jMenuItemCadastrarVeiculo.setText("Cadastro");
        jMenuItemCadastrarVeiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCadastrarVeiculoActionPerformed(evt);
            }
        });
        jMenuFrota.add(jMenuItemCadastrarVeiculo);

        jMenuItemConsultarVeiculos.setText("Consultar");
        jMenuItemConsultarVeiculos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemConsultarVeiculosActionPerformed(evt);
            }
        });
        jMenuFrota.add(jMenuItemConsultarVeiculos);

        jMenuBar1.add(jMenuFrota);

        jMenuLocacao.setText("Aluguel");

        jMenuItemLocar.setText("Locação");
        jMenuItemLocar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemLocarActionPerformed(evt);
            }
        });
        jMenuLocacao.add(jMenuItemLocar);

        jMenuItemDevolver.setText("Devolução");
        jMenuItemDevolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemDevolverActionPerformed(evt);
            }
        });
        jMenuLocacao.add(jMenuItemDevolver);

        jMenuBar1.add(jMenuLocacao);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane)
        );

        setSize(new java.awt.Dimension(800, 640));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemCadastrarVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadastrarVeiculoActionPerformed
        ((JInternalFrame) jDesktopPane.add(new TelaCadastrarVeiculo(jDesktopPane))).moveToFront();
    }//GEN-LAST:event_jMenuItemCadastrarVeiculoActionPerformed

    private void jMenuItemConsultarVeiculosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemConsultarVeiculosActionPerformed
        ((JInternalFrame) jDesktopPane.add(new TelaConsultarVeiculo(jDesktopPane))).moveToFront();
    }//GEN-LAST:event_jMenuItemConsultarVeiculosActionPerformed

    private void jMenuItemCadastrarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadastrarClienteActionPerformed
        ((JInternalFrame) jDesktopPane.add(new TelaCadastrarCliente(jDesktopPane))).moveToFront();
    }//GEN-LAST:event_jMenuItemCadastrarClienteActionPerformed

    private void jMenuItemConsultarClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemConsultarClientesActionPerformed
        ((JInternalFrame) jDesktopPane.add(new TelaConsultarCliente(jDesktopPane))).moveToFront();
    }//GEN-LAST:event_jMenuItemConsultarClientesActionPerformed

    private void jMenuItemCadastrarMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadastrarMarcaActionPerformed
        ((JInternalFrame) jDesktopPane.add(new TelaCadastrarMarca(jDesktopPane))).moveToFront();
    }//GEN-LAST:event_jMenuItemCadastrarMarcaActionPerformed

    private void jMenuItemConsultarMarcasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemConsultarMarcasActionPerformed
        ((JInternalFrame) jDesktopPane.add(new TelaConsultarMarca(jDesktopPane))).moveToFront();
    }//GEN-LAST:event_jMenuItemConsultarMarcasActionPerformed

    private void jMenuItemLocarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemLocarActionPerformed
        ((JInternalFrame) jDesktopPane.add(new TelaAlugarVeiculo(jDesktopPane))).moveToFront();
    }//GEN-LAST:event_jMenuItemLocarActionPerformed

    private void jMenuItemDevolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemDevolverActionPerformed
        ((JInternalFrame) jDesktopPane.add(new TelaDevolverVeiculo(jDesktopPane))).moveToFront();
    }//GEN-LAST:event_jMenuItemDevolverActionPerformed

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
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPane;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuClientes;
    private javax.swing.JMenu jMenuFrota;
    private javax.swing.JMenuItem jMenuItemCadastrarCliente;
    private javax.swing.JMenuItem jMenuItemCadastrarMarca;
    private javax.swing.JMenuItem jMenuItemCadastrarVeiculo;
    private javax.swing.JMenuItem jMenuItemConsultarClientes;
    private javax.swing.JMenuItem jMenuItemConsultarMarcas;
    private javax.swing.JMenuItem jMenuItemConsultarVeiculos;
    private javax.swing.JMenuItem jMenuItemDevolver;
    private javax.swing.JMenuItem jMenuItemLocar;
    private javax.swing.JMenu jMenuLocacao;
    private javax.swing.JMenu jMenuMarcas;
    // End of variables declaration//GEN-END:variables
}
