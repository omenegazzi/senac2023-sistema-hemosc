/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package sistema.hemoesc;

import Model.TelaAgendarDoacao;


/**
 *
 * @author guest01
 */
public class principalForm extends javax.swing.JFrame {

    /**
     * Creates new form principalForm
     */
    public principalForm() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setExtendedState(principalForm.MAXIMIZED_BOTH);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
   


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        mnCadastros = new javax.swing.JMenu();
        mniCidade = new javax.swing.JMenuItem();
        mnMovimentacoes = new javax.swing.JMenu();
        mniAgendamento = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mnCadastros.setText("Cadastros");
        mnCadastros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnCadastrosActionPerformed(evt);
            }
        });

        mniCidade.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/cidade.png"))); // NOI18N
        mniCidade.setText("Cidades");
        mniCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniCidadeActionPerformed(evt);
            }
        });
        mnCadastros.add(mniCidade);

        jMenuBar1.add(mnCadastros);

        mnMovimentacoes.setText("Movimentações");

        mniAgendamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/agendamento.jpg"))); // NOI18N
        mniAgendamento.setText("Agendamento");
        mniAgendamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniAgendamentoActionPerformed(evt);
            }
        });
        mnMovimentacoes.add(mniAgendamento);

        jMenuBar1.add(mnMovimentacoes);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 277, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnCadastrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnCadastrosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mnCadastrosActionPerformed

    private void mniCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniCidadeActionPerformed
        telaCidades cidades = new telaCidades();
        cidades.setVisible(true);
    }//GEN-LAST:event_mniCidadeActionPerformed

    private void mniAgendamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniAgendamentoActionPerformed
        TelaAgendarDoacao agendamento = new TelaAgendarDoacao();
        agendamento.setVisible(true);
    }//GEN-LAST:event_mniAgendamentoActionPerformed


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
            java.util.logging.Logger.getLogger(principalForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(principalForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(principalForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(principalForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new principalForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu mnCadastros;
    private javax.swing.JMenu mnMovimentacoes;
    private javax.swing.JMenuItem mniAgendamento;
    private javax.swing.JMenuItem mniCidade;
    // End of variables declaration//GEN-END:variables
}