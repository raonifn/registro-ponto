/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.raonifn.registroponto;

import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author raoni
 */
public class RegistroPontoJFrame extends javax.swing.JFrame {

    /**
     * Creates new form RegistroPontoJFrame
     */
    public RegistroPontoJFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btIniciar = new javax.swing.JButton();
        btParar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabelHora = new javax.swing.JLabel();
        jLabelTempo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Registro Ponto");

        btIniciar.setText("Iniciar");
        btIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btIniciarActionPerformed(evt);
            }
        });

        btParar.setText("Parar");

        jPanel1.setLayout(new java.awt.GridLayout(2, 1));

        jLabelHora.setText("jLabel1");
        jPanel1.add(jLabelHora);

        jLabelTempo.setText("jLabel1");
        jPanel1.add(jLabelTempo);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 567, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btParar, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btParar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
                    .addComponent(btIniciar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btIniciarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btIniciarActionPerformed

    public JButton getBtIniciar() {
        return btIniciar;
    }
    
    public JButton getBtParar() {
        return btParar;
    }
    
    public JLabel getJLabelTempo() {
        return jLabelTempo;
    }
    
     public JLabel getJLabelHora() {
        return jLabelHora;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btIniciar;
    private javax.swing.JButton btParar;
    private javax.swing.JLabel jLabelHora;
    private javax.swing.JLabel jLabelTempo;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
