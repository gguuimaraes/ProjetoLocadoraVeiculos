package data.frames;

import data.classes.client.Cliente;
import data.classes.location.Locacao;
import data.classes.vehicle.Veiculo;
import data.persistence.LocacaoDAO;
import data.persistence.VeiculoDAO;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

public class TelaAlugarVeiculo extends javax.swing.JInternalFrame {
    private final JDesktopPane desktopPane;
    private final LocacaoDAO locacaoDAO = new LocacaoDAO();
    private Locacao locacao = new Locacao();
    
    public void setCliente(Cliente cliente) {
        locacao.setCliente(cliente);
        jLabelNome.setText(cliente.getNomeCompleto());
        jNumberTextFieldCNH.setText(cliente.getCNH());
        jNumberTextFieldCNH.setEditable(false);
    }
    
    public void setVeiculo(Veiculo veiculo) {
        locacao.setVeiculo(veiculo);
        jTextFieldPlaca.setText(veiculo.getPlaca());
        jLabelMarca.setText(veiculo.getMarca().getNome());
        jLabelModelo.setText(veiculo.getModelo().getNome());
        jLabelValorDiaria.setText(String.format("R$ %.2f", veiculo.getDiaria()));
        jTextFieldPlaca.setEditable(false);
        escreveValorAdicionais();
        escreveValorPagar();
    }
    
    private void setDataPrevisaoFechamento() {
        try {
            Date data = new SimpleDateFormat("dd/MM/yyyy").parse(jFormattedTextFieldDataPrevista.getText());
            data.setHours(new GregorianCalendar().getTime().getHours());
            data.setMinutes(new GregorianCalendar().getTime().getMinutes());
            data.setSeconds(new GregorianCalendar().getTime().getSeconds());
            locacao.setDataPrevisaoFechamento(data); 
        } catch (Exception ex) {
            locacao.setDataPrevisaoFechamento(null); 
        }
        escreveValorPagar();
    }
    
    public void escreveValorPagar() {
        if (locacao.getVeiculo() != null && locacao.getArea() != null && locacao.getFinalidade() != null && locacao.getDataPrevisaoFechamento() != null && locacao.getDataPrevisaoFechamento().getTime() > locacao.getDataAbertura().getTime()) {
            jLabelValorPagar.setText(String.format("R$ %.2f", locacao.getValorPagar()));
        } else {
            jLabelValorPagar.setText("R$ 0");
        }
    }
    
    public void escreveValorAdicionais() {
        if (locacao.getVeiculo() != null && locacao.getArea() != null && locacao.getFinalidade() != null) {
            jLabelValorAdicionais.setText(String.format("R$ %.2f", locacao.getValorAdicionais()));
        }
    }
    
    public void validarCampos() throws Exception {
        if (locacao.getCliente() == null) throw new Exception("Selecione o Cliente da Locação!");
        if (locacao.getVeiculo() == null) throw new Exception("Selecione o Veículo da Locação!");
        if (locacao.getDataPrevisaoFechamento() == null) throw new Exception("Digite a Data prevista para a Devolução!");
        if (locacao.getDataPrevisaoFechamento().getTime() < locacao.getDataAbertura().getTime()) throw new Exception("Digite uma Data prevista válida!");
    }
    
    public TelaAlugarVeiculo(JDesktopPane desktopPane) {
        this.desktopPane = desktopPane;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jButtonPesquisarCliente = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButtonAlugar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jButtonPesquisarVeiculo = new javax.swing.JButton();
        jComboBoxArea = new javax.swing.JComboBox<>();
        jComboBoxFinalidade = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jFormattedTextFieldDataPrevista = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabelMarca = new javax.swing.JLabel();
        jLabelModelo = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabelValorDiaria = new javax.swing.JLabel();
        jLabelValorPagar = new javax.swing.JLabel();
        jNumberTextFieldCNH = new data.classes.JNumberTextField();
        jLabelNome = new javax.swing.JLabel();
        jTextFieldPlaca = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabelValorAdicionais = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Alugar Veículo");
        setVisible(true);

        jLabel2.setText("CNH: ");

        jButtonPesquisarCliente.setText("Pesquisar");
        jButtonPesquisarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisarClienteActionPerformed(evt);
            }
        });

        jButtonCancelar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jLabel6.setText("Valor total com caução:");
        jLabel6.setAutoscrolls(true);

        jLabel7.setText("Nome:");

        jButtonAlugar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButtonAlugar.setText("Alugar");
        jButtonAlugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAlugarActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Cliente");

        jLabel10.setText("Placa:");
        jLabel10.setAutoscrolls(true);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Veículo");
        jLabel11.setAutoscrolls(true);

        jButtonPesquisarVeiculo.setText("Pesquisar");
        jButtonPesquisarVeiculo.setAutoscrolls(true);
        jButtonPesquisarVeiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisarVeiculoActionPerformed(evt);
            }
        });

        DefaultComboBoxModel comboBoxAreaModel = (DefaultComboBoxModel) jComboBoxArea.getModel();
        for (Locacao.Area locacaoArea : Locacao.Area.values()) {
            comboBoxAreaModel.addElement(locacaoArea);
        }
        jComboBoxArea.setAutoscrolls(true);
        jComboBoxArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxAreaActionPerformed(evt);
            }
        });

        DefaultComboBoxModel comboBoxFinalidadeModel = (DefaultComboBoxModel) jComboBoxFinalidade.getModel();
        for (Locacao.Finalidade locacaoFinalidade : Locacao.Finalidade.values()) {
            comboBoxFinalidadeModel.addElement(locacaoFinalidade);
        }
        jComboBoxFinalidade.setAutoscrolls(true);
        jComboBoxFinalidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxFinalidadeActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Locação");
        jLabel1.setAutoscrolls(true);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Área de trafego e Finalidade");
        jLabel12.setAutoscrolls(true);

        jFormattedTextFieldDataPrevista.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));
        jFormattedTextFieldDataPrevista.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jFormattedTextFieldDataPrevistaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jFormattedTextFieldDataPrevistaKeyReleased(evt);
            }
        });

        jLabel9.setText("Data prevista:");
        jLabel9.setAutoscrolls(true);

        jLabel14.setText("Valor diária:");

        jLabel15.setText("Marca:");

        jLabelMarca.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelMarca.setText("Selecione um veículo...");

        jLabelModelo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jLabel18.setText("Modelo:");

        jLabelValorDiaria.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelValorDiaria.setText("R$ 0");

        jLabelValorPagar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelValorPagar.setText("R$ 0");

        jNumberTextFieldCNH.setText("jNumberTextField1");
        jNumberTextFieldCNH.setMaxLength(11);

        jLabelNome.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelNome.setText("Selecione um cliente...");

        jLabel16.setText("Valor com adicionais:");

        jLabelValorAdicionais.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabelValorAdicionais.setText("R$ 0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelValorDiaria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelModelo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonAlugar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonCancelar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelValorPagar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jComboBoxArea, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxFinalidade, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jNumberTextFieldCNH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButtonPesquisarCliente)
                                    .addGap(21, 21, 21))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabelNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel15)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabelMarca, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel10)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTextFieldPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButtonPesquisarVeiculo)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jFormattedTextFieldDataPrevista, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelValorAdicionais, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jButtonPesquisarCliente)
                    .addComponent(jNumberTextFieldCNH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabelNome, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jButtonPesquisarVeiculo)
                    .addComponent(jTextFieldPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel15)
                    .addComponent(jLabelMarca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jLabelModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelValorDiaria))
                .addGap(15, 15, 15)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxFinalidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelValorAdicionais))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFormattedTextFieldDataPrevista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabelValorPagar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAlugar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonPesquisarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisarClienteActionPerformed
        TelaConsultarCliente telaConsultarCliente = new TelaConsultarCliente(desktopPane, this, jNumberTextFieldCNH.getText());
        desktopPane.add(telaConsultarCliente, new Integer(10));
    }//GEN-LAST:event_jButtonPesquisarClienteActionPerformed

    private void jButtonPesquisarVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisarVeiculoActionPerformed
        TelaConsultarVeiculo telaConsultarVeiculo = new TelaConsultarVeiculo(desktopPane, this, jTextFieldPlaca.getText(), true);
        desktopPane.add(telaConsultarVeiculo, new Integer(10));
    }//GEN-LAST:event_jButtonPesquisarVeiculoActionPerformed

    private void jComboBoxAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxAreaActionPerformed
        locacao.setArea(jComboBoxArea.getSelectedItem().toString());
        escreveValorAdicionais();
        escreveValorPagar();
    }//GEN-LAST:event_jComboBoxAreaActionPerformed

    private void jComboBoxFinalidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxFinalidadeActionPerformed
        locacao.setFinalidade(jComboBoxFinalidade.getSelectedItem().toString());
        escreveValorAdicionais();
        escreveValorPagar();
    }//GEN-LAST:event_jComboBoxFinalidadeActionPerformed

    private void jFormattedTextFieldDataPrevistaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFormattedTextFieldDataPrevistaKeyReleased
        setDataPrevisaoFechamento();
    }//GEN-LAST:event_jFormattedTextFieldDataPrevistaKeyReleased

    private void jFormattedTextFieldDataPrevistaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jFormattedTextFieldDataPrevistaKeyPressed
        setDataPrevisaoFechamento();
    }//GEN-LAST:event_jFormattedTextFieldDataPrevistaKeyPressed

    private void jButtonAlugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAlugarActionPerformed
        try {
            validarCampos();
            if (JOptionPane.showConfirmDialog(rootPane, "Continuar e iniciar esta Locação no sistema?", this.getTitle(), JOptionPane.YES_NO_OPTION) == 0) {
                locacao.abrir();
                setDataPrevisaoFechamento();
                new VeiculoDAO().alterar(locacao.getVeiculo());
                locacaoDAO.incluir(locacao);
                if (JOptionPane.showConfirmDialog(rootPane, "Locacão iniciada com sucesso!\n\nDeseja realizar outra?", this.getTitle(), JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE) == 0) {
                    ((JInternalFrame) desktopPane.add(new TelaAlugarVeiculo(desktopPane))).moveToFront();
                }
                this.dispose();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(), this.getTitle(), JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButtonAlugarActionPerformed

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
    private javax.swing.JButton jButtonAlugar;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonPesquisarCliente;
    private javax.swing.JButton jButtonPesquisarVeiculo;
    private javax.swing.JComboBox<String> jComboBoxArea;
    private javax.swing.JComboBox<String> jComboBoxFinalidade;
    private javax.swing.JFormattedTextField jFormattedTextFieldDataPrevista;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelMarca;
    private javax.swing.JLabel jLabelModelo;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JLabel jLabelValorAdicionais;
    private javax.swing.JLabel jLabelValorDiaria;
    private javax.swing.JLabel jLabelValorPagar;
    private data.classes.JNumberTextField jNumberTextFieldCNH;
    private javax.swing.JTextField jTextFieldPlaca;
    // End of variables declaration//GEN-END:variables
}
