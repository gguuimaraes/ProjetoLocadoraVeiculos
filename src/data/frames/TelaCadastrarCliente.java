package data.frames;

import data.classes.client.CPF;
import data.classes.client.Cliente;
import data.classes.client.Email;
import data.classes.client.Endereco;
import data.classes.client.Telefone;
import data.persistence.ClienteDAO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;

public class TelaCadastrarCliente extends javax.swing.JInternalFrame {

    private JDesktopPane parent;
    private final ClienteDAO clienteDAO = new ClienteDAO();
    private final boolean modoEdicao;
    private final Cliente cliente;
    private Cliente novoCliente;
    
    public TelaCadastrarCliente(JDesktopPane parent) {
        this.parent = parent;
        modoEdicao = false;
        cliente = new Cliente();
        initComponents();
    }

    public TelaCadastrarCliente(JDesktopPane parent, Cliente cliente) {
        this.parent = parent;
        this.modoEdicao = true;
        this.cliente = cliente;
        initComponents();
        setTitle(getTitle() +  " - " + cliente.getCNH());
        jNumberTextFieldCNH.setEditable(false);
        jTextFieldNomeCompleto.setText(cliente.getNomeCompleto());
        jNumberTextFieldDDI.setText(cliente.getTelefone().getDDI().toString());
        jNumberTextFieldDDD.setText(cliente.getTelefone().getDDD().toString());
        jNumberTextFieldNumeroTelefone.setText(cliente.getTelefone().getNumero().toString());
        jComboBoxTipoTelefone.setSelectedItem(cliente.getTelefone().getTipo().ordinal());
        jTextFieldEmail.setText(cliente.getEmail().toString());
        jTextFieldLogradouro.setText(cliente.getEndereco().getLogradouro());
        jNumberTextFieldNumeroEndereco.setText(cliente.getEndereco().getNumero().toString());
        jNumberTextFieldCEP.setText(cliente.getEndereco().getCEP().toString());
        jTextFieldPais.setText(cliente.getEndereco().getPais());
        jTextFieldCidade.setText(cliente.getEndereco().getCidade());
        jTextFieldEstado.setText(cliente.getEndereco().getEstado());
        jTextFieldBairro.setText(cliente.getEndereco().getBairro());
        jTextFieldComplemento.setText(cliente.getEndereco().getComplemento());
        jComboBoxTipoEndereco.setSelectedIndex(cliente.getEndereco().getTipo().ordinal());
        jNumberTextFieldCNH.setText(cliente.getCNH());
        jNumberTextFieldCPF.setText(cliente.getCPF().toString());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSlider1 = new javax.swing.JSlider();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldNomeCompleto = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldEmail = new javax.swing.JTextField();
        jComboBoxTipoTelefone = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jTextFieldLogradouro = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jTextFieldCidade = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jTextFieldEstado = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jTextFieldPais = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jTextFieldBairro = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jTextFieldComplemento = new javax.swing.JTextField();
        jComboBoxTipoEndereco = new javax.swing.JComboBox<>();
        jButtonSalvar = new javax.swing.JButton();
        jNumberTextFieldDDI = new data.classes.JNumberTextField();
        jNumberTextFieldDDD = new data.classes.JNumberTextField();
        jNumberTextFieldNumeroTelefone = new data.classes.JNumberTextField();
        jNumberTextFieldCPF = new data.classes.JNumberTextField();
        jNumberTextFieldCNH = new data.classes.JNumberTextField();
        jNumberTextFieldCEP = new data.classes.JNumberTextField();
        jNumberTextFieldNumeroEndereco = new data.classes.JNumberTextField();
        jButtonCancelar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Cadastro do Cliente");
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

        jLabel1.setText("Nome Completo:");

        jLabel2.setText("CPF:");

        jLabel3.setText("CNH:");

        jLabel4.setText("DDI:");

        jLabel5.setText("DDD:");

        jLabel6.setText("Número:");

        jLabel7.setText("CONTATO");

        jLabel8.setText("Email:");

        DefaultComboBoxModel tipoTelefoneModel = (DefaultComboBoxModel) jComboBoxTipoTelefone.getModel();
        for (Telefone.Tipo telefoneTipo : Telefone.Tipo.values()) {
            tipoTelefoneModel.addElement(telefoneTipo);
        }

        jLabel9.setText("ENDEREÇO");

        jLabel10.setText("Logradouro:");

        jLabel11.setText("Número:");

        jLabel12.setText("CEP:");

        jLabel13.setText("Cidade:");

        jLabel14.setText("Estado:");

        jLabel15.setText("Pais:");

        jLabel16.setText("Bairro:");

        jLabel17.setText("Complemento:");

        DefaultComboBoxModel tipoEnderecoModel = (DefaultComboBoxModel) jComboBoxTipoEndereco.getModel();
        for (Endereco.Tipo enderecoTipo : Endereco.Tipo.values()) {
            tipoEnderecoModel.addElement(enderecoTipo);
        }

        jButtonSalvar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButtonSalvar.setText("Salvar");
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });

        jNumberTextFieldDDI.setText("jNumberTextField1");
        jNumberTextFieldDDI.setMaxLength(3);

        jNumberTextFieldDDD.setText("jNumberTextField1");
        jNumberTextFieldDDD.setMaxLength(3);

        jNumberTextFieldNumeroTelefone.setText("jNumberTextField1");

        jNumberTextFieldCPF.setText("jNumberTextField1");
        jNumberTextFieldCPF.setMaxLength(11);

        jNumberTextFieldCNH.setText("jNumberTextField1");
        jNumberTextFieldCNH.setMaxLength(11);

        jNumberTextFieldCEP.setText("jNumberTextField1");
        jNumberTextFieldCEP.setMaxLength(8);

        jNumberTextFieldNumeroEndereco.setText("jNumberTextField1");

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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldComplemento))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldLogradouro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jNumberTextFieldNumeroEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldEmail))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldNomeCompleto))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jNumberTextFieldCPF, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                            .addComponent(jNumberTextFieldCNH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonCancelar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel16))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jNumberTextFieldCEP, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldPais, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
                            .addComponent(jTextFieldBairro))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldCidade))
                            .addComponent(jComboBoxTipoEndereco, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel9))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jNumberTextFieldDDI, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jNumberTextFieldDDD, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jNumberTextFieldNumeroTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxTipoTelefone, 0, 120, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNomeCompleto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jComboBoxTipoTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jNumberTextFieldDDI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jNumberTextFieldDDD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jNumberTextFieldNumeroTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jTextFieldLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jNumberTextFieldNumeroEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(jTextFieldCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(jTextFieldPais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jNumberTextFieldCEP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jTextFieldEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(jTextFieldBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxTipoEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jTextFieldComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jNumberTextFieldCNH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jNumberTextFieldCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jButtonSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void validarCampos() throws Exception {
        String nomeCompleto = jTextFieldNomeCompleto.getText();
        if (!modoEdicao) {
            if (nomeCompleto.isEmpty()) throw new Exception("Digite o Nome Completo do Cliente!");
            for (char c : nomeCompleto.toCharArray()) {
                if (!Character.isLetter(c) && c != ' ') {
                    throw new Exception("Digite apenas letras e espaços no Nome Completo do Cliente!");
                }
            }
        }
        String ddi = jNumberTextFieldDDI.getText();
        if (ddi.isEmpty()) throw new Exception("Digite o DDI do Telefone do Cliente!");
        String ddd = jNumberTextFieldDDD.getText();
        if (ddd.isEmpty()) throw new Exception("Digite o DDD do Telefone do Cliente!");
        String numeroTelefone = jNumberTextFieldNumeroTelefone.getText();
        if (numeroTelefone.isEmpty()) throw new Exception("Digite o Número de Telefone do Cliente!");

        Email email = new Email(jTextFieldEmail.getText());
        if (email.toString().isEmpty()) throw new Exception("Digite o Endereço de Email do Cliente!");
        if (!email.valido()) throw new Exception("Digite um Endereço de Email válido para o Cliente!");
        
        String logradouro = jTextFieldLogradouro.getText();
        if (logradouro.isEmpty()) throw new Exception("Digite o Logradouro do Endereço do Cliente!");
        Integer numeroEndereco = jNumberTextFieldNumeroEndereco.getInt();
        if (numeroEndereco.toString().isEmpty()) throw new Exception("Digite o Número do Endereço do Cliente!");
        Integer cep = jNumberTextFieldCEP.getInt();
        if (cep.toString().isEmpty()) throw new Exception("Digite o CEP do Endereço do Cliente!");
        String pais = jTextFieldPais.getText();
        if (pais.isEmpty()) throw new Exception("Digite o País do Endereço do Cliente!");
        String cidade = jTextFieldCidade.getText();
        if (cidade.isEmpty()) throw new Exception("Digite a Cidade do Endereço do Cliente!");
        String estado = jTextFieldEstado.getText();
        if (estado.isEmpty()) throw new Exception("Digite o Estado do Endereço do Cliente!");
        String bairro = jTextFieldBairro.getText();
        if (bairro.isEmpty()) throw new Exception("Digite a Bairro do Endereço do Cliente!");
        String complemento = jTextFieldComplemento.getText();
        
        String cnh = jNumberTextFieldCNH.getText();
        if (cnh.isEmpty()) throw new Exception("Digite a CNH do Cliente!");
        CPF cpf = new CPF(jNumberTextFieldCPF.getText());
        if ((cpf.toString().length() > 0 && cpf.toString().length() < 11) || (cpf.toString().length() == 11 && !cpf.valido())) throw new Exception("Digite um CPF válido para o Cliente!");
        
        novoCliente = new Cliente(
                cnh, nomeCompleto, cpf, email, 
                new Endereco(logradouro, numeroEndereco, cep, cidade, estado, pais, bairro, complemento, jComboBoxTipoEndereco.getSelectedItem().toString()), 
                new Telefone(Integer.parseInt(ddi), Integer.parseInt(ddd), Long.parseLong(numeroTelefone), jComboBoxTipoTelefone.getSelectedItem().toString()));
        
    }
    
    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        try {
            validarCampos();
            if(!modoEdicao) {
                if (JOptionPane.showConfirmDialog(rootPane, "Continuar e realizar o cadastro do cliente no sistema?", this.getTitle(), JOptionPane.YES_NO_OPTION) == 0) {
                    clienteDAO.incluir(novoCliente);
                    if (JOptionPane.showConfirmDialog(rootPane, "Cliente cadastrado com sucesso!\n\nDeseja fechar esta tela?", this.getTitle(), JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE) != 0) {
                        TelaCadastrarCliente novaTela = new TelaCadastrarCliente(parent, novoCliente);
                        parent.add(novaTela);
                        novaTela.setVisible(true);
                    }
                    this.dispose();
                }
            } else {
                if(cliente.toString().equals(novoCliente.toString())) 
                    JOptionPane.showMessageDialog(rootPane, "Nenhuma alteração foi feita.", this.getTitle(), JOptionPane.INFORMATION_MESSAGE);
                else {
                    if (JOptionPane.showConfirmDialog(rootPane, "Continuar e alterar o cadastro do cliente no sistema?", this.getTitle(), JOptionPane.YES_NO_OPTION) == 0) {
                        clienteDAO.alterar(novoCliente);
                        if (JOptionPane.showConfirmDialog(rootPane, "Cliente alterado com sucesso!\n\nDeseja fechar esta tela?", this.getTitle(), JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE) != 0) {
                            TelaCadastrarCliente novaTela = new TelaCadastrarCliente(parent, novoCliente);
                            parent.add(novaTela);
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
            if (cliente.toString().equals(novoCliente.toString())) this.dispose();
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
    private javax.swing.JComboBox<String> jComboBoxTipoEndereco;
    private javax.swing.JComboBox<String> jComboBoxTipoTelefone;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private data.classes.JNumberTextField jNumberTextFieldCEP;
    private data.classes.JNumberTextField jNumberTextFieldCNH;
    private data.classes.JNumberTextField jNumberTextFieldCPF;
    private data.classes.JNumberTextField jNumberTextFieldDDD;
    private data.classes.JNumberTextField jNumberTextFieldDDI;
    private data.classes.JNumberTextField jNumberTextFieldNumeroEndereco;
    private data.classes.JNumberTextField jNumberTextFieldNumeroTelefone;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JTextField jTextFieldBairro;
    private javax.swing.JTextField jTextFieldCidade;
    private javax.swing.JTextField jTextFieldComplemento;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldEstado;
    private javax.swing.JTextField jTextFieldLogradouro;
    private javax.swing.JTextField jTextFieldNomeCompleto;
    private javax.swing.JTextField jTextFieldPais;
    // End of variables declaration//GEN-END:variables
}
