
package com.chat.client.view;

import com.chat.client.ClientController;
import com.chat.client.utils.Utils;
import com.chat.common.ClientInt;
import com.chat.common.Message;
import com.chat.common.UserDTO;

import java.rmi.RemoteException;

import java.util.Date;

import javax.swing.JOptionPane;

/**
 *
 * @author orcl
 */
public class ChatForm extends javax.swing.JFrame implements ChatView {

    /** Creates new form ChatForm */
    UserDTO otherPeer;
    ClientController clientController;
    String myEmail;
    UserDTO currentUser;
    public ChatForm(ClientController clientController, UserDTO currentUser, UserDTO otherPeer) {
        initComponents();
        this.otherPeer = otherPeer;
        this.clientController = clientController;
        this.currentUser = currentUser;
        this.myEmail = currentUser.getEmail();
        
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(HIDE_ON_CLOSE);

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {//GEN-BEGIN:initComponents

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        allMessages = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        messageToSend = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));

        allMessages.setColumns(20);
        allMessages.setRows(5);
        jScrollPane1.setViewportView(allMessages);

        messageToSend.setColumns(20);
        messageToSend.setRows(5);
        jScrollPane2.setViewportView(messageToSend);

        jButton1.setText("Send Online Message");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Send As Mail");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(117, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        Message message = prepareNormalMessage();
        
        try {
            otherPeer.getClientInt().recieveMessage(message);
            displayChatMessage(message);
            messageToSend.setText("");
        } catch (RemoteException e) {
            Utils.displayErrorMessage(this,
                                      "Not able to send message to " + otherPeer.getUserName() +
                                      " you can send message as a mail instead");
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        boolean sendingResult = clientController.sendMessageAsMail(prepareMessageWithPeerEmail());
       try
       {
            JOptionPane.showMessageDialog(this, "Message has been ordered  tp ");
            messageToSend.setText("");
        } catch(Exception ex) {
            Utils.displayErrorMessage(this, "Not able to send message as email ..., Please try again later");

        }
    }//GEN-LAST:event_jButton2ActionPerformed


    private Message prepareNormalMessage() {
        Message message = new Message();
        message.setSender(myEmail);
        message.setMessageText(messageToSend.getText());
        message.setSendingDate(new Date());
        message.setSenderDTO(currentUser);
        return message;
    }

    private Message prepareMessageWithPeerEmail() {
        Message message = prepareNormalMessage();
        message.setEmail(otherPeer.getEmail());
        return message;
    }

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
            java.util.logging.Logger.getLogger(ChatForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChatForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChatForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChatForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>


    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea allMessages;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea messageToSend;
    // End of variables declaration//GEN-END:variables

    @Override
    public void displayChatMessage(Message message) {
    if(otherPeer==null && message.getSenderDTO()!=null)
    {
        otherPeer = message.getSenderDTO();
    }
        allMessages.append("\n");
        allMessages.append(String.format("%s (%s) ", message.getSender(),
                                         Utils.dateToTimeStirng(message.getSendingDate())));
        allMessages.append("\n");
        allMessages.append(message.getMessageText());

        this.setVisible(true);

    }

    @Override
    public void displayScreen() {
        setVisible(true);
    }

    @Override
    public void setChatTitle(String string) {
        // TODO Implement this method
    }
}