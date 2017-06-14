package data.frames;


import data.classes.vehicle.Veiculo;
import data.persistence.VeiculoDAO;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class TelaConsultarVeiculo extends javax.swing.JInternalFrame {

    private final JDesktopPane desktopPane;
    private final JInternalFrame requester;
    private final VeiculoDAO veiculoDAO = new VeiculoDAO();
    private boolean modoBusca = false;
    private boolean alugar = false;
    private Veiculo veiculo;
    
    public TelaConsultarVeiculo(JDesktopPane desktopPane) {
        this.desktopPane = desktopPane;
        requester = null;
        initComponents();
        jButtonBuscar.doClick();
    }
    
    public TelaConsultarVeiculo(JDesktopPane desktopPane, JInternalFrame requester, String placa, boolean alugar) {
        this.desktopPane = desktopPane;
        this.requester = requester;
        this.alugar = alugar;
        this.modoBusca = true;
        initComponents();
        jButtonExcluir.setText("Cancelar");
        jButtonAlterar.setText("Selecionar");
        jTextFieldParametroBusca.setText(placa);
        jButtonBuscar.doClick();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextFieldParametroBusca = new javax.swing.JTextField();
        jButtonBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableVeiculos = new javax.swing.JTable();
        jButtonAlterar = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Consultar Veículo");
        setVisible(true);

        jButtonBuscar.setText("Consultar");
        jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarActionPerformed(evt);
            }
        });

        jTableVeiculos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Placa", "Marca", "Modelo", "Ano", "Situação"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableVeiculos);
        jTableVeiculos.addMouseListener(new MouseAdapter() {
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
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 599, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextFieldParametroBusca)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonBuscar))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonAlterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonExcluir)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldParametroBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
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
            DefaultTableModel tableVeiculosModel = (DefaultTableModel) jTableVeiculos.getModel();
            tableVeiculosModel.setRowCount(0);
            String parametrosBusca[] = jTextFieldParametroBusca.getText().split(" ");
            ArrayList<Veiculo> resultadoBusca = new ArrayList<Veiculo>();
            if (parametrosBusca.length == 0) {
                resultadoBusca = veiculoDAO.listar();
            } else {
                for (Veiculo veiculoTemporario : veiculoDAO.listar()) {
                    if ((modoBusca && 
                        ((alugar && veiculoTemporario.getSituacao() == Veiculo.Situacao.DISPONIVEL) || 
                        !alugar && veiculoTemporario.getSituacao() == Veiculo.Situacao.LOCADO)) || 
                        !modoBusca) {
                        for (int i = 0; i < parametrosBusca.length; i++) {
                            if (veiculoTemporario.getPlaca().replace("-", "").contains(parametrosBusca[i].replace("-", "").toUpperCase())
                                    || veiculoTemporario.getMarca().getNome().toUpperCase().contains(parametrosBusca[i].toUpperCase())
                                    || veiculoTemporario.getModelo().getNome().toUpperCase().contains(parametrosBusca[i].toUpperCase())
                                    || veiculoTemporario.getAno().toString().contains(parametrosBusca[i])
                                    || veiculoTemporario.getSituacao().toString().toUpperCase().contains(parametrosBusca[i].toUpperCase().replace("Ã", "A"))) {
                                resultadoBusca.add(veiculoTemporario);
                                i = parametrosBusca.length;
                            }
                        }
                    }
                }
            }
            for (Veiculo veiculoTemporario : resultadoBusca) {
                int linha = tableVeiculosModel.getRowCount();
                tableVeiculosModel.setRowCount(linha + 1);
                for (int coluna = 0; coluna < tableVeiculosModel.getColumnCount(); coluna++) {
                    switch (tableVeiculosModel.getColumnName(coluna)) {
                        case "Placa":
                            tableVeiculosModel.setValueAt(veiculoTemporario.getPlaca(), linha, coluna);
                            break;
                        case "Marca":
                            tableVeiculosModel.setValueAt(veiculoTemporario.getMarca().getNome(), linha, coluna);
                            break;
                        case "Modelo":
                            tableVeiculosModel.setValueAt(veiculoTemporario.getModelo().getNome(), linha, coluna);
                            break;
                        case "Ano":
                            tableVeiculosModel.setValueAt(veiculoTemporario.getAno(), linha, coluna);
                            break;
                        case "Situação":
                            tableVeiculosModel.setValueAt(veiculoTemporario.getSituacao().toString(), linha, coluna);
                            break;
                    }
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(), this.getTitle(), JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButtonBuscarActionPerformed

    private void jButtonAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAlterarActionPerformed
        if (jTableVeiculos.getSelectedRowCount() == 0) return;
        try {
            DefaultTableModel tableVeiculosModel = (DefaultTableModel) jTableVeiculos.getModel();
            for (int coluna = 0; coluna < tableVeiculosModel.getColumnCount(); coluna++) {
                switch (tableVeiculosModel.getColumnName(coluna)) {
                    case "Placa":
                        veiculo = veiculoDAO.getByPlaca(tableVeiculosModel.getValueAt(jTableVeiculos.getSelectedRows()[0], coluna).toString());
                        if (!modoBusca) ((JInternalFrame) desktopPane.add(new TelaCadastrarVeiculo(desktopPane, veiculo))).moveToFront();
                        else {
                            dispose();
                            if (alugar) {
                                ((TelaAlugarVeiculo) requester).setVeiculo(veiculo);
                            } else {
                                ((TelaDevolverVeiculo) requester).setVeiculo(veiculo);
                            }
                        }
                        return;
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(), this.getTitle(), JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButtonAlterarActionPerformed

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        if (jTableVeiculos.getSelectedRowCount() == 0) return;
        try {
            DefaultTableModel tableVeiculosModel = (DefaultTableModel) jTableVeiculos.getModel();
            for (int coluna = 0; coluna < tableVeiculosModel.getColumnCount(); coluna++) {
                switch (tableVeiculosModel.getColumnName(coluna)) {
                    case "Placa":
                        if (!modoBusca) {
                            if (JOptionPane.showConfirmDialog(rootPane, "Continuar e excluir o cadastro do Veículo do sistema?", this.getTitle(), JOptionPane.YES_NO_OPTION) == 0) {
                                veiculo = veiculoDAO.getByPlaca(tableVeiculosModel.getValueAt(jTableVeiculos.getSelectedRows()[0], coluna).toString());
                                veiculoDAO.remover(veiculo);
                                JOptionPane.showMessageDialog(rootPane, "Veículo excluído com sucesso!", this.getTitle(), JOptionPane.INFORMATION_MESSAGE);
                                jTextFieldParametroBusca.setText("");
                                jButtonBuscar.doClick();
                                return;
                            }
                        } else {
                            setVisible(false);
                            dispose();
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
    private javax.swing.JTable jTableVeiculos;
    private javax.swing.JTextField jTextFieldParametroBusca;
    // End of variables declaration//GEN-END:variables
}
