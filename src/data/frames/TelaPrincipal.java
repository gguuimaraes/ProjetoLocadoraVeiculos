package data.frames;

import javax.swing.JFrame;

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
        jMenuListas = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(1024, 768));

        javax.swing.GroupLayout jDesktopPaneLayout = new javax.swing.GroupLayout(jDesktopPane);
        jDesktopPane.setLayout(jDesktopPaneLayout);
        jDesktopPaneLayout.setHorizontalGroup(
            jDesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 643, Short.MAX_VALUE)
        );
        jDesktopPaneLayout.setVerticalGroup(
            jDesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 485, Short.MAX_VALUE)
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
        jMenuLocacao.add(jMenuItemLocar);

        jMenuItemDevolver.setText("Devolução");
        jMenuLocacao.add(jMenuItemDevolver);

        jMenuBar1.add(jMenuLocacao);

        jMenuListas.setText("Listas");

        jMenuItem5.setText("Lista de Clientes");
        jMenuListas.add(jMenuItem5);

        jMenuItem6.setText("Lista de Veículos");
        jMenuListas.add(jMenuItem6);

        jMenuItem9.setText("Lista de Locação");
        jMenuListas.add(jMenuItem9);

        jMenuBar1.add(jMenuListas);

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

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemCadastrarVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadastrarVeiculoActionPerformed
        jDesktopPane.add(new TelaCadastrarVeiculo());
    }//GEN-LAST:event_jMenuItemCadastrarVeiculoActionPerformed

    private void jMenuItemConsultarVeiculosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemConsultarVeiculosActionPerformed
        jDesktopPane.add(new TelaConsultarVeiculo());
    }//GEN-LAST:event_jMenuItemConsultarVeiculosActionPerformed

    private void jMenuItemCadastrarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadastrarClienteActionPerformed
        jDesktopPane.add(new TelaCadastrarCliente(jDesktopPane));
    }//GEN-LAST:event_jMenuItemCadastrarClienteActionPerformed

    private void jMenuItemConsultarClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemConsultarClientesActionPerformed
        jDesktopPane.add(new TelaConsultarCliente(jDesktopPane));
    }//GEN-LAST:event_jMenuItemConsultarClientesActionPerformed

    private void jMenuItemCadastrarMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCadastrarMarcaActionPerformed
        jDesktopPane.add(new TelaCadastrarMarca(jDesktopPane));
    }//GEN-LAST:event_jMenuItemCadastrarMarcaActionPerformed

    private void jMenuItemConsultarMarcasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemConsultarMarcasActionPerformed
        jDesktopPane.add(new TelaConsultarMarca(jDesktopPane));
    }//GEN-LAST:event_jMenuItemConsultarMarcasActionPerformed

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
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JMenuItem jMenuItemCadastrarCliente;
    private javax.swing.JMenuItem jMenuItemCadastrarMarca;
    private javax.swing.JMenuItem jMenuItemCadastrarVeiculo;
    private javax.swing.JMenuItem jMenuItemConsultarClientes;
    private javax.swing.JMenuItem jMenuItemConsultarMarcas;
    private javax.swing.JMenuItem jMenuItemConsultarVeiculos;
    private javax.swing.JMenuItem jMenuItemDevolver;
    private javax.swing.JMenuItem jMenuItemLocar;
    private javax.swing.JMenu jMenuListas;
    private javax.swing.JMenu jMenuLocacao;
    private javax.swing.JMenu jMenuMarcas;
    // End of variables declaration//GEN-END:variables
}
