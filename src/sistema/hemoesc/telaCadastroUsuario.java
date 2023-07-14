package sistema.hemoesc;

import Controller.UsuariosDAO;

public class telaCadastroUsuario extends javax.swing.JFrame {

    public static telaCadastroUsuario telaCadastroUsuario = new telaCadastroUsuario();
    public String usuario, senha, confirmaSenha;
    
    public telaCadastroUsuario() {
        initComponents();
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNovoUsuario = new javax.swing.JLabel();
        txtNovaSenha = new javax.swing.JTextField();
        lblNovaSenha = new javax.swing.JLabel();
        txtNovoUsuario = new javax.swing.JTextField();
        lblConfirmaSenha = new javax.swing.JLabel();
        txtConfirmaSenha = new javax.swing.JTextField();
        btnCadastro = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblNovoUsuario.setText("Usuário:");

        lblNovaSenha.setText("Senha:");

        lblConfirmaSenha.setText("Confirmar senha:");

        btnCadastro.setText("Cadastrar");
        btnCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNovoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNovaSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNovaSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNovoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblConfirmaSenha)
                            .addComponent(txtConfirmaSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(btnCadastro)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lblNovoUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtNovoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNovaSenha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtNovaSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblConfirmaSenha)
                .addGap(18, 18, 18)
                .addComponent(txtConfirmaSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCadastro)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastroActionPerformed
        UsuariosDAO dao = new UsuariosDAO();
        telaLogin t = new telaLogin();
                
        usuario = txtNovoUsuario.getText();
        senha = txtNovaSenha.getText();
        confirmaSenha = txtConfirmaSenha.getText();
        
        dao.cadastro(usuario, senha, confirmaSenha);
        
        t.detalhamentoLogin();
        this.dispose();
    }//GEN-LAST:event_btnCadastroActionPerformed

    public void detalhamento(){
        telaCadastroUsuario.setVisible(true);
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                telaCadastroUsuario.detalhamento();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastro;
    private javax.swing.JLabel lblConfirmaSenha;
    private javax.swing.JLabel lblNovaSenha;
    private javax.swing.JLabel lblNovoUsuario;
    private javax.swing.JTextField txtConfirmaSenha;
    private javax.swing.JTextField txtNovaSenha;
    private javax.swing.JTextField txtNovoUsuario;
    // End of variables declaration//GEN-END:variables
}
