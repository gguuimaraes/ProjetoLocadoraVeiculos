package data.frames;

import data.classes.client.Cliente;
import data.classes.vehicle.Marca;
import data.persistence.MarcaDAO;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class TelaConsultarMarca extends javax.swing.JInternalFrame {

    private JDesktopPane desktopPane;
    private final MarcaDAO marcaDAO = new MarcaDAO();

    public TelaConsultarMarca(JDesktopPane parent) {
        this.desktopPane = parent;
        initComponents();
        jButtonBuscar.doClick();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableMarcas = new javax.swing.JTable();
        jButtonAlterar = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();
        jTextFieldParametroBusca = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Consultar Marca");
        setVisible(true);

        jButtonBuscar.setText("Consultar");
        jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarActionPerformed(evt);
            }
        });

        jTableMarcas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Valor do aluguel", "Número de modelos"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Float.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableMarcas);
        jTableMarcas.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    jButtonAlterar.doClick();
                }
            }
        });

        jButtonAlterar.setText("Alterar");
        jButtonAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAlterarActionPerformed(evt);
            }
        });

        jButtonExcluir.setText("Excluir");
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonAlterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonExcluir))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextFieldParametroBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonBuscar)
                    .addComponent(jTextFieldParametroBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAlterar)
                    .addComponent(jButtonExcluir))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed
        try {
            DefaultTableModel tableMarcasModel = (DefaultTableModel) jTableMarcas.getModel();
            tableMarcasModel.setRowCount(0);
            String parametrosBusca[] = jTextFieldParametroBusca.getText().split(" ");
            ArrayList<Marca> resultadoBusca = new ArrayList<Marca>();
            if (parametrosBusca.length == 0) {
                resultadoBusca = marcaDAO.listar();
            } else {
                for (Marca marca : marcaDAO.listar()) {
                    for (int i = 0; i < parametrosBusca.length; i++) {
                        String valorAluguel = marca.getValor().toString().replace('.', Character.MIN_VALUE);
                        if (marca.getNome().toUpperCase().contains(parametrosBusca[i].toUpperCase()) ||
                                valorAluguel.contains(parametrosBusca[i]) ||
                                String.valueOf(marca.getModelos().size()).contains(parametrosBusca[i])) {
                            resultadoBusca.add(marca);
                            i = parametrosBusca.length;
                        }
                    }
                }
            }
            for (Marca marca : resultadoBusca) {
                int linha = tableMarcasModel.getRowCount();
                tableMarcasModel.setRowCount(linha + 1);
                for (int coluna = 0; coluna < tableMarcasModel.getColumnCount(); coluna++) {
                    switch (tableMarcasModel.getColumnName(coluna)) {
                        case "Nome":
                            tableMarcasModel.setValueAt(marca.getNome(), linha, coluna);
                            break;
                        case "Valor do aluguel":
                            tableMarcasModel.setValueAt(marca.getValor(), linha, coluna);
                            break;
                        case "Número de modelos":
                            tableMarcasModel.setValueAt(marca.getModelos().size(), linha, coluna);
                            break;
                    }
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(), this.getTitle(), JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_jButtonBuscarActionPerformed

    private void jButtonAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAlterarActionPerformed
        if (jTableMarcas.getSelectedRowCount() == 0) return;
        try {
            DefaultTableModel tableMarcasModel = (DefaultTableModel) jTableMarcas.getModel();
            for (int coluna = 0; coluna < tableMarcasModel.getColumnCount(); coluna++) {
                switch (tableMarcasModel.getColumnName(coluna)) {
                    case "Nome":
                        desktopPane.add(new TelaCadastrarMarca(desktopPane, marcaDAO.getByNome(tableMarcasModel.getValueAt(jTableMarcas.getSelectedRows()[0], coluna).toString())));
                        moveToBack();
                        return;
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(), this.getTitle(), JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButtonAlterarActionPerformed

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        if (jTableMarcas.getSelectedRowCount() == 0) return;
        try {
            DefaultTableModel tableMarcasModel = (DefaultTableModel) jTableMarcas.getModel();
            for (int coluna = 0; coluna < tableMarcasModel.getColumnCount(); coluna++) {
                switch (tableMarcasModel.getColumnName(coluna)) {
                    case "Nome":
                        Marca marca = marcaDAO.getByNome(tableMarcasModel.getValueAt(jTableMarcas.getSelectedRows()[0], coluna).toString());
                        if (JOptionPane.showConfirmDialog(rootPane, "Continuar e excluir o cadastro da marca do sistema?", this.getTitle(), JOptionPane.YES_NO_OPTION) == 0) {
                            marcaDAO.remover(marca);
                            JOptionPane.showMessageDialog(rootPane, "Marca excluída com sucesso!", this.getTitle(), JOptionPane.INFORMATION_MESSAGE);
                            jTextFieldParametroBusca.setText("");
                            jButtonBuscar.doClick();
                            return;
                        }
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(), this.getTitle(), JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButtonExcluirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAlterar;
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableMarcas;
    private javax.swing.JTextField jTextFieldParametroBusca;
    // End of variables declaration//GEN-END:variables
}
