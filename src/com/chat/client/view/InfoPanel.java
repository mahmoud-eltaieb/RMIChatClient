
package com.chat.client.view;

import com.chat.client.utils.Utils;
import com.chat.common.Hobies;
import com.chat.common.UserDTO;

import com.neovisionaries.i18n.CountryCode;

import javax.swing.DefaultListModel;

/**
 *
 * @author orcl
 */
public class InfoPanel extends javax.swing.JPanel {

    /** Creates new form InfoPanel */
    public InfoPanel()
    {
        initComponents();

        setVisible(false);    
    }
    public InfoPanel(UserDTO currentPeer) {
        initComponents();
        loadCurrentPeerData(currentPeer);
    }
    
    
    

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {//GEN-BEGIN:initComponents

        jLabel18 = new javax.swing.JLabel();
        peerUserName = new javax.swing.JTextField();
        peerEmail = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        peerGender = new javax.swing.JTextField();
        peerCountry = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        peerBirithYear = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        peerHobbies = new javax.swing.JList();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        peerKeywords = new javax.swing.JList();

        jLabel18.setText("User Name");

        jLabel19.setText("Email");

        jLabel20.setText("Gender");

        jLabel21.setText("Country");

        jLabel22.setText("Year of Birith");

        peerHobbies.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane5.setViewportView(peerHobbies);

        jLabel23.setText("Hobbies");

        jLabel24.setText("Keywords");

        peerKeywords.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane6.setViewportView(peerKeywords);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addGap(33, 33, 33)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addGap(40, 40, 40)
                        .addComponent(peerCountry))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22)
                            .addComponent(jLabel23))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane5)
                            .addComponent(peerBirithYear)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19)
                            .addComponent(jLabel20)
                            .addComponent(jLabel18))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(peerEmail, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(peerGender)
                            .addComponent(peerUserName))))
                .addGap(38, 38, 38))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(peerUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(peerEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(peerGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(peerCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(peerBirithYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel23))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                        .addComponent(jLabel24)
                        .addGap(151, 151, 151))))
        );
    }//GEN-END:initComponents



    public void loadCurrentPeerData(UserDTO currentPeer) {
        Utils.fillTextFieldWith(peerUserName, currentPeer.getUserName());
        Utils.fillTextFieldWith(peerEmail, currentPeer.getEmail());
        Utils.fillTextFieldWith(peerGender,
                                currentPeer.getGender() != null ? currentPeer.getGender().toString() : null);
        Utils.fillTextFieldWith(peerCountry,
                                currentPeer.getCountry() != null ?
                                CountryCode.getByCode(Integer.parseInt(currentPeer.getCountry())).getName() : null);
        Utils.fillTextFieldWith(peerBirithYear,
                                currentPeer.getBirthYear() != null ? currentPeer.getBirthYear() + "" : null);
        peerHobbies.setModel(new DefaultListModel());
        if (currentPeer.getHobbies() != null) {
            for (Hobies hobby : currentPeer.getHobbies()) {
                ((DefaultListModel) peerHobbies.getModel()).addElement(hobby.getValue());
            }
        }


        peerKeywords.setModel(new DefaultListModel());
        if (currentPeer.getKeywords() != null) {
            for (String keyWord : currentPeer.getKeywords()) {
                ((DefaultListModel) peerKeywords.getModel()).addElement(keyWord);
            }
        }
        setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTextField peerBirithYear;
    private javax.swing.JTextField peerCountry;
    private javax.swing.JTextField peerEmail;
    private javax.swing.JTextField peerGender;
    private javax.swing.JList peerHobbies;
    private javax.swing.JList peerKeywords;
    private javax.swing.JTextField peerUserName;
    // End of variables declaration//GEN-END:variables

}
