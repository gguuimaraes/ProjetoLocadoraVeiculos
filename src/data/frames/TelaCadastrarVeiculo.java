package data.frames;

import data.classes.vehicle.Marca;
import data.classes.vehicle.Modelo;
import data.classes.vehicle.Veiculo;
import data.persistence.LocacaoDAO;
import data.persistence.MarcaDAO;
import data.persistence.VeiculoDAO;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;

public class TelaCadastrarVeiculo extends javax.swing.JInternalFrame {

    private JDesktopPane desktopPane;
    private final boolean modoEdicao;
    private final VeiculoDAO veiculoDAO = new VeiculoDAO();
    private final Veiculo veiculo;
    private Veiculo novoVeiculo;
    
    private int anoAtual = new GregorianCalendar().get(Calendar.YEAR);
    private int anoMinimo = anoAtual - 8;
    private int anoMaximo = anoAtual + 1;
    
    private final MarcaDAO marcaDAO = new MarcaDAO();

    public TelaCadastrarVeiculo(JDesktopPane desktopPane) {
        this.desktopPane = desktopPane;
        modoEdicao = false;
        veiculo = new Veiculo();
        initComponents();
    }
    
    public TelaCadastrarVeiculo(JDesktopPane desktopPane, Veiculo veiculo) {
        this.desktopPane = desktopPane;
        modoEdicao = true;
        this.veiculo = veiculo;
        if (veiculo.getAno() < anoMinimo) anoMinimo = veiculo.getAno();
        initComponents();
        setTitle(getTitle() + " - " + veiculo.getPlaca());
        jFormattedTextFieldPlaca.setEditable(false);
        jFormattedTextFieldPlaca.setText(veiculo.getPlaca());
        jSpinner1.setValue(veiculo.getAno());
        jComboBoxSituacao.setSelectedIndex(veiculo.getSituacao().ordinal());
        for (int indexMarca = 0; indexMarca < jComboBoxMarca.getItemCount(); indexMarca++) {
            if (jComboBoxMarca.getItemAt(indexMarca).equals(veiculo.getMarca().getNome())) {
                jComboBoxMarca.setSelectedIndex(indexMarca);
                indexMarca = jComboBoxMarca.getItemCount();
            }
        }
        jComboBoxModelo.setSelectedIndex(veiculo.getMarca().getModelos().indexOf(veiculo.getModelo()));
        boolean jaLocado = true;
        try {
            jaLocado = new LocacaoDAO().existsByPlaca(veiculo.getPlaca());
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, ex.toString(), this.getTitle(), JOptionPane.WARNING_MESSAGE);
        }
        jSpinner1.setEnabled(!jaLocado);
        jComboBoxMarca.setEditable(!jaLocado);
        jComboBoxModelo.setEditable(!jaLocado);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jComboBoxMarca = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jComboBoxModelo = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButtonSalvar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jComboBoxSituacao = new javax.swing.JComboBox<>();
        jSpinner1 = new javax.swing.JSpinner();
        jFormattedTextFieldPlaca = new javax.swing.JFormattedTextField();
        jButtonCancelar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Cadastro do Veículo");
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

        jLabel1.setText("Marca:");

        jComboBoxMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxMarcaActionPerformed(evt);
            }
        });
        DefaultComboBoxModel comboBoxMarcasModel = (DefaultComboBoxModel) jComboBoxMarca.getModel();
        comboBoxMarcasModel.removeAllElements();
        try {
            for (Marca marca : marcaDAO.listar()) {
                comboBoxMarcasModel.addElement(marca.getNome());
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, ex.toString(), this.getTitle(), JOptionPane.WARNING_MESSAGE);
        }

        jLabel2.setText("Modelo:");

        jLabel3.setText("Placa:");

        jLabel4.setText("Ano:");

        jButtonSalvar.setText("Salvar");
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });

        jLabel5.setText("Status:");

        DefaultComboBoxModel comboBoxSituacaoModel = (DefaultComboBoxModel) jComboBoxSituacao.getModel();
        for (Veiculo.Situacao veiculoSituacao : Veiculo.Situacao.values()) {
            comboBoxSituacaoModel.addElement(veiculoSituacao);
        }

        JSpinner.NumberEditor editor = new JSpinner.NumberEditor(jSpinner1);
        editor.getFormat().setGroupingUsed(false);
        editor.getFormat().setMaximumIntegerDigits(4);
        editor.getFormat().setMaximumFractionDigits(0);
        editor.getFormat().setMinimumIntegerDigits(4);
        jSpinner1.setEditor(editor);
        jSpinner1.setValue(anoAtual);
        jSpinner1.setModel(new javax.swing.SpinnerNumberModel(anoAtual, anoMinimo, anoMaximo, 1));

        try {
            jFormattedTextFieldPlaca.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("AAA-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonCancelar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jFormattedTextFieldPlaca, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxMarca, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBoxModelo, 0, 150, Short.MAX_VALUE)
                            .addComponent(jComboBoxSituacao, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jComboBoxSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormattedTextFieldPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBoxMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBoxModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                    .addComponent(jButtonCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxMarcaActionPerformed
        if (jComboBoxMarca.getItemCount() == 0) return;
        DefaultComboBoxModel comboBoxModelosModel = (DefaultComboBoxModel) jComboBoxModelo.getModel();
        comboBoxModelosModel.removeAllElements();
        try {
            for (Modelo modelo : new MarcaDAO().getByNome(jComboBoxMarca.getSelectedItem().toString()).getModelos()) {
                comboBoxModelosModel.addElement(modelo.getNome());
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, ex.toString(), this.getTitle(), JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jComboBoxMarcaActionPerformed

    private void validarCampos() throws Exception {
        if (!jFormattedTextFieldPlaca.isEditValid()) throw new Exception("Digite uma Placa válida para o Veículo!");
        String placa = jFormattedTextFieldPlaca.getText();
        if (placa.isEmpty()) throw new Exception("Digite a Placa do Veículo!");
        String ano = jSpinner1.getValue().toString();
        if (ano.isEmpty()) throw new Exception("Digite o Ano do Veículo!");
        if (!ano.matches("^[0-9]+$")) throw new Exception("Digite um Ano válido para o Veículo!");
        int anoInt = Integer.parseInt(ano);
        if (anoInt < anoMinimo || anoInt > anoMaximo) throw new Exception("Digite um Ano válido para o Veículo!");
        if (jComboBoxMarca.getItemCount() == 0) throw new Exception("Selecione uma Marca para o Veículo!");
        
        novoVeiculo = new Veiculo();
        novoVeiculo.setPlaca(placa.toUpperCase());
        novoVeiculo.setAno(anoInt);
        novoVeiculo.setSituacao(jComboBoxSituacao.getSelectedItem().toString());
        Marca marca = marcaDAO.getByNome(jComboBoxMarca.getSelectedItem().toString());
        novoVeiculo.setMarca(marca);
        for (int indexModelo = 0; indexModelo < marca.getModelos().size(); indexModelo++) {
            if (marca.getModelos().get(indexModelo).getNome().equals(jComboBoxModelo.getSelectedItem().toString())) {
                novoVeiculo.setModelo(marca.getModelos().get(indexModelo));
                indexModelo = marca.getModelos().size();
            }
        }
    }

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        try {
            validarCampos();
            if(!modoEdicao) {
                if (JOptionPane.showConfirmDialog(rootPane, "Continuar e realizar o cadastro do Veículo no sistema?", this.getTitle(), JOptionPane.YES_NO_OPTION) == 0) {
                    veiculoDAO.incluir(novoVeiculo);
                    if (JOptionPane.showConfirmDialog(rootPane, "Veículo cadastrado com sucesso!\n\nDeseja fechar esta tela?", this.getTitle(), JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE) != 0) {
                        desktopPane.add(new TelaCadastrarVeiculo(desktopPane, novoVeiculo));
                    }
                    this.dispose();
                }
            } else {
                if(veiculo.toString().equals(novoVeiculo.toString())) 
                    JOptionPane.showMessageDialog(rootPane, "Nenhuma alteração foi feita.", this.getTitle(), JOptionPane.INFORMATION_MESSAGE);
                else {
                    if (JOptionPane.showConfirmDialog(rootPane, "Continuar e alterar o cadastro do Veículo no sistema?", this.getTitle(), JOptionPane.YES_NO_OPTION) == 0) {
                        veiculoDAO.alterar(novoVeiculo);
                        if (JOptionPane.showConfirmDialog(rootPane, "Veículo alterado com sucesso!\n\nDeseja fechar esta tela?", this.getTitle(), JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE) != 0) {
                            desktopPane.add(new TelaCadastrarVeiculo(desktopPane, novoVeiculo));
                        }
                        this.dispose();
                    }
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, ex, this.getTitle(), JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        try {
            validarCampos();
            if (veiculo.toString().equals(novoVeiculo.toString())) this.dispose();
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
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JComboBox<String> jComboBoxMarca;
    private javax.swing.JComboBox<String> jComboBoxModelo;
    private javax.swing.JComboBox<String> jComboBoxSituacao;
    private javax.swing.JFormattedTextField jFormattedTextFieldPlaca;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JSpinner jSpinner1;
    // End of variables declaration//GEN-END:variables
}
