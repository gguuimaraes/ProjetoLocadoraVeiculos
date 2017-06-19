package data.frames;

import data.classes.JNumberTextField;
import data.classes.location.Locacao;
import data.classes.vehicle.Veiculo;
import data.persistence.LocacaoDAO;
import data.persistence.VeiculoDAO;
import java.text.SimpleDateFormat;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

public class TelaDevolverVeiculo extends javax.swing.JInternalFrame {

    private final JDesktopPane desktopPane;
    private final LocacaoDAO locacaoDAO = new LocacaoDAO();
    private Locacao locacao = null;
    
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    
    public TelaDevolverVeiculo(JDesktopPane desktopPane) {
        this.desktopPane = desktopPane;
        initComponents();
    }
    
    public void setVeiculo(Veiculo veiculo) {
        try {
            locacao = locacaoDAO.getAbertaByPlaca(veiculo.getPlaca());
            jTextFieldPlaca.setText(veiculo.getPlaca());
            jTextFieldPlaca.setEditable(false);
            jLabelQuilometragemAnterior.setText(veiculo.getQuilometragem() + " km");
            jLabelCNH.setText(locacao.getCliente().getCNH());
            jLabelNome.setText(locacao.getCliente().getNomeCompleto());
            jLabelDataAberta.setText(dateFormat.format(locacao.getDataAbertura()));
            jLabelDataPrevisao.setText(dateFormat.format(locacao.getDataPrevisaoFechamento()));
            jLabelValorPago.setText(String.format("R$ %.2f", locacao.getValorPagar()));
            locacao.fechar();
            jLabelValorExtornar.setText(String.format("R$ %.2f", locacao.getValorExtornar()));
            jLabelValorPagar.setText(String.format("R$ %.2f", locacao.getValorFinalPagar()));         
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(), this.getTitle(), JOptionPane.WARNING_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextFieldPlaca = new javax.swing.JTextField();
        jComboBoxSituacao = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jButtonDevolver = new javax.swing.JButton();
        jButtonConsultarDevolver = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButtonCancelar = new javax.swing.JButton();
        jNumberTextFieldQuilometragem = new data.classes.JNumberTextField(7, JNumberTextField.DECIMAL);
        jLabel5 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabelNome = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabelDataAberta = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabelDataPrevisao = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabelValorPago = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabelCNH = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabelValorExtornar = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabelQuilometragemAnterior = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabelValorPagar = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Devolver Veículo");
        setVisible(true);

        jLabel1.setText("Placa:");

        DefaultComboBoxModel comboBoxSituacaoModel = (DefaultComboBoxModel) jComboBoxSituacao.getModel();
        for (Veiculo.Situacao veiculoSituacao : Veiculo.Situacao.values()) {
            if (!veiculoSituacao.toString().equals("LOCADO")) comboBoxSituacaoModel.addElement(veiculoSituacao);
        }

        jLabel2.setText("Quilometragem atual: ");

        jButtonDevolver.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButtonDevolver.setText("Devolver");
        jButtonDevolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDevolverActionPerformed(evt);
            }
        });

        jButtonConsultarDevolver.setText("Pesquisar");
        jButtonConsultarDevolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConsultarDevolverActionPerformed(evt);
            }
        });

        jLabel3.setText("Nome:");

        jButtonCancelar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jNumberTextFieldQuilometragem.setText("jNumberTextField1");

        jLabel5.setText("Situação:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Veículo");
        jLabel11.setAutoscrolls(true);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Cliente");
        jLabel12.setAutoscrolls(true);

        jLabelNome.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Locação");
        jLabel13.setAutoscrolls(true);

        jLabelDataAberta.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jLabel6.setText("Aberta em:");

        jLabelDataPrevisao.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jLabel7.setText("Data prevista:");

        jLabelValorPago.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jLabel8.setText("Valor pago:");

        jLabelCNH.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jLabel9.setText("CNH:");

        jLabel10.setText("Valor a extornar:");

        jLabelValorExtornar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jLabel4.setText("Quilometragem anterior:");

        jLabel14.setText("Valor a pagar:");

        jLabelValorPagar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonDevolver)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonCancelar))
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelCNH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelDataAberta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelDataPrevisao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelValorPago, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelValorExtornar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelValorPagar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxSituacao, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(73, 73, 73))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonConsultarDevolver))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jNumberTextFieldQuilometragem, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 77, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelQuilometragemAnterior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jButtonConsultarDevolver))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jNumberTextFieldQuilometragem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelQuilometragemAnterior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabelCNH, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabelNome, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabelDataAberta, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabelDataPrevisao, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabelValorPago, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabelValorExtornar, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jLabelValorPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonDevolver, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonConsultarDevolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConsultarDevolverActionPerformed
        TelaConsultarVeiculo telaConsultarVeiculo = new TelaConsultarVeiculo(desktopPane, this, jTextFieldPlaca.getText(), false);
        desktopPane.add(telaConsultarVeiculo, new Integer(10));
    }//GEN-LAST:event_jButtonConsultarDevolverActionPerformed

    public void validarCampos() throws Exception {
        if (locacao == null) throw new Exception("Selecione o Veículo da Locação!");
        if (jNumberTextFieldQuilometragem.getText().isEmpty()) throw new Exception("Digite a Quilometragem do Veículo!");
        if (jNumberTextFieldQuilometragem.getFloat() < locacao.getVeiculo().getQuilometragem()) throw new Exception("Digite uma Quilometragem válida para o Veículo!");
        locacao.getVeiculo().setQuilometragem(jNumberTextFieldQuilometragem.getFloat());
        locacao.getVeiculo().setSituacao(jComboBoxSituacao.getSelectedItem().toString());
    }
    
    private void jButtonDevolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDevolverActionPerformed
        try {
            validarCampos();
            if (JOptionPane.showConfirmDialog(rootPane, "Continuar e finalizar esta Locação no sistema?", this.getTitle(), JOptionPane.YES_NO_OPTION) == 0) {
                locacao.fechar();
                new VeiculoDAO().alterar(locacao.getVeiculo());
                locacaoDAO.alterar(locacao);
                if (JOptionPane.showConfirmDialog(rootPane, "Locacão finalizada com sucesso!\n\nDeseja realizar outra?", this.getTitle(), JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE) == 0) {
                    ((JInternalFrame) desktopPane.add(new TelaAlugarVeiculo(desktopPane))).moveToFront();
                }
                this.dispose();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(), this.getTitle(), JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButtonDevolverActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        try {
            validarCampos();
            if (JOptionPane.showConfirmDialog(rootPane, "Alterações foram encontradas, deseja mesmo fechar esta tela?", this.getTitle(), JOptionPane.YES_NO_OPTION) == 0) {
                this.dispose();
            }
        } catch (Exception ex) {
            this.dispose();
        }
    }//GEN-LAST:event_jButtonCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonConsultarDevolver;
    private javax.swing.JButton jButtonDevolver;
    private javax.swing.JComboBox<String> jComboBoxSituacao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelCNH;
    private javax.swing.JLabel jLabelDataAberta;
    private javax.swing.JLabel jLabelDataPrevisao;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JLabel jLabelQuilometragemAnterior;
    private javax.swing.JLabel jLabelValorExtornar;
    private javax.swing.JLabel jLabelValorPagar;
    private javax.swing.JLabel jLabelValorPago;
    private data.classes.JNumberTextField jNumberTextFieldQuilometragem;
    private javax.swing.JTextField jTextFieldPlaca;
    // End of variables declaration//GEN-END:variables
}
