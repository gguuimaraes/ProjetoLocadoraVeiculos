package data.frames;

import data.classes.client.Cliente;
import data.persistence.ClienteDAO;
import data.persistence.LocacaoDAO;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class TelaConsultarCliente extends javax.swing.JInternalFrame {

    private JDesktopPane parent;
    private final ClienteDAO clienteDAO = new ClienteDAO();

    public TelaConsultarCliente(JDesktopPane parent) {
        this.parent = parent;
        initComponents();
        jButtonBuscar.doClick();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableClientes = new javax.swing.JTable();
        jButtonAlterar = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();
        jTextFieldParametroBusca = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Consultar Cliente");

        jButtonBuscar.setText("Consultar");
        jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarActionPerformed(evt);
            }
        });

        jTableClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CNH", "Nome Completo", "Email", "Aluguel aberto?"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableClientes);
        jTableClientes.addMouseListener(new MouseAdapter() {
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
            DefaultTableModel tableClientesModel = (DefaultTableModel) jTableClientes.getModel();
            tableClientesModel.setRowCount(0);
            String parametrosBusca[] = jTextFieldParametroBusca.getText().split(" ");
            ArrayList<Cliente> resultadoBusca = new ArrayList<Cliente>();
            if (parametrosBusca.length == 0) {
                resultadoBusca = clienteDAO.listar();
            } else {
                for (Cliente cliente : clienteDAO.listar()) {
                    for (int i = 0; i < parametrosBusca.length; i++) {
                        String aluguelAberto = (new LocacaoDAO().existsAbertaByCNH(cliente.getCNH()) ? "SIM" : "NAO");
                        if (cliente.getCNH().contains(parametrosBusca[i]) ||
                                cliente.getNomeCompleto().toUpperCase().contains(parametrosBusca[i].toUpperCase()) || 
                                cliente.getEmail().toString().toUpperCase().contains(parametrosBusca[i].toUpperCase()) ||
                                aluguelAberto.contains(parametrosBusca[i].toUpperCase()) ||
                                aluguelAberto.contains(parametrosBusca[i].toUpperCase().replace('Ã', 'A'))) {
                            resultadoBusca.add(cliente);
                            i = parametrosBusca.length;
                        }
                    }
                }
            }
            for (Cliente cliente : resultadoBusca) {
                int linha = tableClientesModel.getRowCount();
                tableClientesModel.setRowCount(linha + 1);
                for (int coluna = 0; coluna < tableClientesModel.getColumnCount(); coluna++) {
                    switch (tableClientesModel.getColumnName(coluna)) {
                        case "Nome Completo":
                            tableClientesModel.setValueAt(cliente.getNomeCompleto(), linha, coluna);
                            break;
                        case "CNH":
                            tableClientesModel.setValueAt(cliente.getCNH(), linha, coluna);
                            break;
                        case "Email":
                            tableClientesModel.setValueAt(cliente.getEmail().toString(), linha, coluna);
                            break;
                        case "Aluguel aberto?":
                            tableClientesModel.setValueAt((new LocacaoDAO().existsAbertaByCNH(cliente.getCNH())) ? "Sim" : "Não", linha, coluna);
                            break;
                    }
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(), this.getTitle(), JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_jButtonBuscarActionPerformed

    private void jButtonAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAlterarActionPerformed
        if (jTableClientes.getSelectedRowCount() == 0) return;
        try {
            DefaultTableModel tableClientesModel = (DefaultTableModel) jTableClientes.getModel();
            for (int coluna = 0; coluna < tableClientesModel.getColumnCount(); coluna++) {
                switch (tableClientesModel.getColumnName(coluna)) {
                    case "CNH":
                        TelaCadastrarCliente novaTela = new TelaCadastrarCliente(parent, clienteDAO.getByCNH(tableClientesModel.getValueAt(jTableClientes.getSelectedRows()[0], coluna).toString()));
                        parent.add(novaTela);
                        novaTela.setVisible(true);
                        return;
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(), this.getTitle(), JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButtonAlterarActionPerformed

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        if (jTableClientes.getSelectedRowCount() == 0) return;
        try {
            DefaultTableModel tableClientesModel = (DefaultTableModel) jTableClientes.getModel();
            for (int coluna = 0; coluna < tableClientesModel.getColumnCount(); coluna++) {
                switch (tableClientesModel.getColumnName(coluna)) {
                    case "CNH":
                        Cliente cliente = clienteDAO.getByCNH(tableClientesModel.getValueAt(jTableClientes.getSelectedRows()[0], coluna).toString());
                        if (JOptionPane.showConfirmDialog(rootPane, "Continuar e excluir o cadastro do cliente no sistema?", this.getTitle(), JOptionPane.YES_NO_OPTION) == 0) {
                            clienteDAO.remover(cliente);
                            JOptionPane.showMessageDialog(rootPane, "Cliente excluído com sucesso!", this.getTitle(), JOptionPane.INFORMATION_MESSAGE);
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
    private javax.swing.JTable jTableClientes;
    private javax.swing.JTextField jTextFieldParametroBusca;
    // End of variables declaration//GEN-END:variables
}
