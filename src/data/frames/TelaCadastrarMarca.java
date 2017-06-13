package data.frames;

import data.classes.JNumberTextField;
import data.classes.vehicle.Marca;
import data.classes.vehicle.Modelo;
import data.persistence.MarcaDAO;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class TelaCadastrarMarca extends javax.swing.JInternalFrame {

    private JDesktopPane desktopPane;
    private final boolean modoEdicao;
    private final MarcaDAO marcaDAO = new MarcaDAO();
    private final Marca marca;
    private Marca novaMarca;

    public TelaCadastrarMarca(JDesktopPane desktopPane) {
        this.desktopPane = desktopPane;
        modoEdicao = false;
        marca = new Marca();
        novaMarca = new Marca();
        initComponents();
    }

    public TelaCadastrarMarca(JDesktopPane desktopPane, Marca marca) {
        this.desktopPane = desktopPane;
        modoEdicao = true;
        this.marca = marca;
        this.novaMarca = new Marca(marca.getNome(), marca.getValor(), new ArrayList<Modelo>(marca.getModelos()));
        initComponents();
        setTitle(getTitle() + " - " + marca.getNome());
        jTextFieldNomeMarca.setEditable(false);
        jTextFieldNomeMarca.setText(marca.getNome());
        jNumberTextFieldValorMarca.setFloat(marca.getValor());
        DefaultTableModel tableModelosModel = (DefaultTableModel) jTableModelos.getModel();
        for (Modelo modelo : marca.getModelos()) {
            int linha = tableModelosModel.getRowCount();
            for (int coluna = 0; coluna < tableModelosModel.getColumnCount(); coluna++) {
                tableModelosModel.setRowCount(linha + 1);
                switch (tableModelosModel.getColumnName(coluna)) {
                    case "Nome":
                        tableModelosModel.setValueAt(modelo.getNome(), linha, coluna);
                        break;
                    case "Valor do aluguel":
                        tableModelosModel.setValueAt(modelo.getValor(), linha, coluna);
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextFieldNomeMarca = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableModelos = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButtonSalvar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldNomeModelo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jButtonCancelarEdicao = new javax.swing.JButton();
        jButtonRemoverModelo = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jButtonAdicionarModelo = new javax.swing.JButton();
        jNumberTextFieldValorMarca = new data.classes.JNumberTextField(10, JNumberTextField.DECIMAL);
        jNumberTextFieldValorModelo = new data.classes.JNumberTextField(10, JNumberTextField.DECIMAL);

        setClosable(true);
        setIconifiable(true);
        setTitle("Cadastro da Marca");
        setVisible(true);
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosing(evt);
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        jLabel1.setText("Nome:");

        jTableModelos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Valor do aluguel"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableModelos);
        jTableModelos.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    jButtonAdicionarModelo.setText("Alterar");
                    jButtonCancelarEdicao.setVisible(true);
                    DefaultTableModel tableModelosModel = (DefaultTableModel) jTableModelos.getModel();
                    for (int coluna = 0; coluna < tableModelosModel.getColumnCount(); coluna++) {
                        switch (tableModelosModel.getColumnName(coluna)) {
                            case "Nome":
                            jTextFieldNomeModelo.setText(tableModelosModel.getValueAt(jTableModelos.getSelectedRows()[0], coluna).toString());
                            break;
                            case "Valor do aluguel":
                            jNumberTextFieldValorModelo.setFloat(Float.parseFloat(tableModelosModel.getValueAt(jTableModelos.getSelectedRows()[0], coluna).toString()));
                            break;
                        }
                    }

                }
            }
        });
        jTableModelos.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent lse) {
                if (!lse.getValueIsAdjusting()) {
                    jButtonCancelarEdicao.doClick();
                }
            }
        });

        jLabel2.setText("MODELOS");

        jLabel3.setText("Valor do aluguel:");

        jButtonSalvar.setText("Salvar");
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });

        jLabel4.setText("MARCA");

        jLabel7.setText("Valor do aluguel:");

        jLabel6.setText("Nome:");

        jButtonCancelarEdicao.setText("Cancelar");
        jButtonCancelarEdicao.setVisible(false);
        jButtonCancelarEdicao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarEdicaoActionPerformed(evt);
            }
        });

        jButtonRemoverModelo.setText("Remover");
        jButtonRemoverModelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoverModeloActionPerformed(evt);
            }
        });

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jButtonAdicionarModelo.setText("Adicionar");
        jButtonAdicionarModelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAdicionarModeloActionPerformed(evt);
            }
        });

        jNumberTextFieldValorMarca.setText("jNumberTextField1");
        jNumberTextFieldValorMarca.setMaxLength(7);

        jNumberTextFieldValorModelo.setText("jNumberTextField1");
        jNumberTextFieldValorModelo.setMaxLength(7);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 517, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldNomeModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jNumberTextFieldValorModelo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonAdicionarModelo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonCancelarEdicao))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonRemoverModelo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonCancelar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldNomeMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jNumberTextFieldValorMarca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldNomeMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jNumberTextFieldValorMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextFieldNomeModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jButtonCancelarEdicao)
                    .addComponent(jButtonAdicionarModelo)
                    .addComponent(jNumberTextFieldValorModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(jButtonRemoverModelo)
                    .addComponent(jButtonSalvar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCancelarEdicaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarEdicaoActionPerformed
        jButtonAdicionarModelo.setText("Adicionar");
        jButtonCancelarEdicao.setVisible(false); 
        jTextFieldNomeModelo.setText("");
        jNumberTextFieldValorModelo.setText("");
    }//GEN-LAST:event_jButtonCancelarEdicaoActionPerformed

    private void jButtonAdicionarModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAdicionarModeloActionPerformed
        boolean modoModeloEdicao = !jButtonAdicionarModelo.getText().equals("Adicionar");
        try {
            String nomeModelo = jTextFieldNomeModelo.getText();
            String valorModelo = jNumberTextFieldValorModelo.getText();
            if (nomeModelo.length() == 0) {
                JOptionPane.showMessageDialog(rootPane, "Digite um Nome para o Modelo!", this.getTitle(), JOptionPane.WARNING_MESSAGE);
                return;
            }
            if (valorModelo.length() == 0) {
                JOptionPane.showMessageDialog(rootPane, "Digite um Valor para o Modelo!", this.getTitle(), JOptionPane.WARNING_MESSAGE);
                return;
            }
            Modelo modeloNovo = new Modelo(nomeModelo, Float.parseFloat(valorModelo));
            DefaultTableModel tableModelosModel = (DefaultTableModel) jTableModelos.getModel();
            int linha = !modoModeloEdicao ? tableModelosModel.getRowCount() : jTableModelos.getSelectedRows()[0];
            if (!modoModeloEdicao) {
                novaMarca.incluirModelo(modeloNovo);
                tableModelosModel.setRowCount(linha + 1);
            }
            Modelo modeloAntigo = novaMarca.getModelos().get(linha);
            if (modoModeloEdicao) novaMarca.alterarModelo(modeloAntigo, modeloNovo);
            for (int coluna = 0; coluna < tableModelosModel.getColumnCount(); coluna++) {
                switch (tableModelosModel.getColumnName(coluna)) {
                    case "Nome":
                        tableModelosModel.setValueAt(modeloNovo.getNome(), linha, coluna);
                        break;
                    case "Valor do aluguel":
                        tableModelosModel.setValueAt(modeloNovo.getValor(), linha, coluna);
                        break;
                }
            }
            jButtonCancelarEdicao.doClick();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(), this.getTitle(), JOptionPane.WARNING_MESSAGE);
            jTextFieldNomeModelo.requestFocus();
        } finally {
            if (modoModeloEdicao) jButtonCancelarEdicao.doClick();
        }
    }//GEN-LAST:event_jButtonAdicionarModeloActionPerformed

    private void jButtonRemoverModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoverModeloActionPerformed
        try {
            DefaultTableModel tableModelosModel = (DefaultTableModel) jTableModelos.getModel();
            while (jTableModelos.getSelectedRows().length > 0) {
                int linha = jTableModelos.getSelectedRows()[0];
                Modelo modeloAntigo = new Modelo();
                for (int coluna = 0; coluna < tableModelosModel.getColumnCount(); coluna++) {
                    switch (tableModelosModel.getColumnName(coluna)) {
                        case "Nome":
                            modeloAntigo.setNome(tableModelosModel.getValueAt(linha, coluna).toString());
                            break;
                        case "Valor do aluguel":
                            modeloAntigo.setValor(Float.parseFloat(tableModelosModel.getValueAt(linha, coluna).toString()));
                            break;
                    }
                }
                novaMarca.removerModelo(modeloAntigo);
                tableModelosModel.removeRow(jTableModelos.getSelectedRows()[0]);
            }
            if (jButtonAdicionarModelo.getText().equals("Alterar")) jButtonCancelarEdicao.doClick();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(), this.getTitle(), JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButtonRemoverModeloActionPerformed

    public void validarCampos() throws Exception {
        String nomeMarca = jTextFieldNomeMarca.getText();
        if (!modoEdicao)
            if (nomeMarca.isEmpty()) throw new Exception("Digite o Nome da Marca!");
        String valorMarca = jNumberTextFieldValorMarca.getText();
        if (valorMarca.isEmpty()) throw new Exception("Digite o Valor do aluguel da Marca!");
        novaMarca.setNome(nomeMarca);
        novaMarca.setValor(Float.parseFloat(valorMarca));
    }

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        try {
            validarCampos();
            if(!modoEdicao) {
                if (JOptionPane.showConfirmDialog(rootPane, "Continuar e realizar o cadastro da Marca no sistema?", this.getTitle(), JOptionPane.YES_NO_OPTION) == 0) {
                    marcaDAO.incluir(novaMarca);
                    if (JOptionPane.showConfirmDialog(rootPane, "Marca cadastrada com sucesso!\n\nDeseja fechar esta tela?", this.getTitle(), JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE) != 0) {
                        TelaCadastrarMarca novaTela = new TelaCadastrarMarca(desktopPane, novaMarca);
                        desktopPane.add(novaTela);
                        novaTela.setVisible(true);
                    }
                    this.dispose();
                }
            } else {
                if(marca.toString().equals(novaMarca.toString()) && marca.getModelos().equals(novaMarca.getModelos())) 
                    JOptionPane.showMessageDialog(rootPane, "Nenhuma alteração foi feita.", this.getTitle(), JOptionPane.INFORMATION_MESSAGE);
                else {
                    if (JOptionPane.showConfirmDialog(rootPane, "Continuar e alterar o cadastro da Marca no sistema?", this.getTitle(), JOptionPane.YES_NO_OPTION) == 0) {
                        marcaDAO.alterar(novaMarca);
                        if (JOptionPane.showConfirmDialog(rootPane, "Marca alterado com sucesso!\n\nDeseja fechar esta tela?", this.getTitle(), JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE) != 0) {
                            TelaCadastrarMarca novaTela = new TelaCadastrarMarca(desktopPane, novaMarca);
                            desktopPane.add(novaTela);
                            novaTela.setVisible(true);
                        }
                        this.dispose();
                    }
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(), this.getTitle(), JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        try {
            validarCampos();
            if (marca.toString().equals(novaMarca.toString()) && marca.getModelos().equals(novaMarca.getModelos())) this.dispose();
            else {
                if (JOptionPane.showConfirmDialog(rootPane, "Alterações foram encontradas, deseja mesmo fechar esta tela?", this.getTitle(), JOptionPane.YES_NO_OPTION) == 0) {
                    this.dispose();
                }
            }
        } catch (Exception ex) {
            this.dispose();
        }
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        jButtonCancelar.doClick();
    }//GEN-LAST:event_formInternalFrameClosing


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAdicionarModelo;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonCancelarEdicao;
    private javax.swing.JButton jButtonRemoverModelo;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private data.classes.JNumberTextField jNumberTextFieldValorMarca;
    private data.classes.JNumberTextField jNumberTextFieldValorModelo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableModelos;
    private javax.swing.JTextField jTextFieldNomeMarca;
    private javax.swing.JTextField jTextFieldNomeModelo;
    // End of variables declaration//GEN-END:variables
}
