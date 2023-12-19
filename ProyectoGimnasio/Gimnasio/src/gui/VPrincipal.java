package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 *
 * @author alumnogreibd
 */
public class VPrincipal extends javax.swing.JFrame {

    aplicacion.FachadaAplicacion fa;
    FachadaGui fgui;

    /**
     * Creates new form VPrincipal
     *
     * @param fa
     */
    public VPrincipal(aplicacion.FachadaAplicacion fa, FachadaGui fgui) {
        initComponents();
        this.fa = fa;
        this.fgui = fgui;
        rellenarComboBox();
        Material.setVisible(false);
        AnhadirActividad.setVisible(false);
        apuntarse.setVisible(false);
        errorApuntarse.setVisible(false);
        desapuntarse.setVisible(false);
        errorDesapuntarse.setVisible(false);
        desorganizarActividad.setVisible(false);
        cambiarSala.setVisible(false);
        AnhadirMonitor.setVisible(false);
        Organizar.setVisible(false);
        Aumentar.setVisible(false);
        Reducir.setVisible(false);
        cambiarEspecialidad.setVisible(false);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        logInButton = new javax.swing.JButton();
        singUpButton = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        Material = new javax.swing.JButton();
        apuntarse = new javax.swing.JButton();
        AnhadirActividad = new javax.swing.JButton();
        errorApuntarse = new javax.swing.JLabel();
        desorganizarActividad = new javax.swing.JButton();
        desapuntarse = new javax.swing.JButton();
        errorDesapuntarse = new javax.swing.JLabel();
        cambiarSala = new javax.swing.JButton();
        AnhadirMonitor = new javax.swing.JButton();
        Organizar = new javax.swing.JButton();
        Aumentar = new javax.swing.JButton();
        Reducir = new javax.swing.JButton();
        cambiarEspecialidad = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Santa Isabel Complejo Deportivo");

        logInButton.setText("Iniciar Sesión ");
        logInButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logInButtonActionPerformed(evt);
            }
        });

        singUpButton.setText("Registrarse ");
        singUpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                singUpButtonActionPerformed(evt);
            }
        });

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Sala");

        jTable1.setModel(new ModeloTablaActividades());
        jScrollPane1.setViewportView(jTable1);

        Material.setText("Añadir Material");
        Material.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MaterialActionPerformed(evt);
            }
        });

        apuntarse.setText("Apuntarse");
        apuntarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                apuntarseActionPerformed(evt);
            }
        });

        AnhadirActividad.setText("Añadir Actividad");
        AnhadirActividad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnhadirActividadActionPerformed(evt);
            }
        });

        errorApuntarse.setForeground(new java.awt.Color(255, 0, 0));
        errorApuntarse.setText("Error al apuntarse en la actividad");

        desorganizarActividad.setText("Desorganizar Actividad");
        desorganizarActividad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                desorganizarActividadActionPerformed(evt);
            }
        });

        desapuntarse.setText("Desapuntarse");
        desapuntarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                desapuntarseActionPerformed(evt);
            }
        });

        errorDesapuntarse.setForeground(new java.awt.Color(255, 0, 0));
        errorDesapuntarse.setText("Error al desapuntarse de la actividad");

        cambiarSala.setText("Cambiar Sala");
        cambiarSala.setName("CambiarSala"); // NOI18N
        cambiarSala.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cambiarSalaActionPerformed(evt);
            }
        });

        AnhadirMonitor.setText("Añadir Monitor");
        AnhadirMonitor.setActionCommand("");
        AnhadirMonitor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnhadirMonitor(evt);
            }
        });

        Organizar.setText("Organizar Actividad");
        Organizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OrganizarActionPerformed(evt);
            }
        });

        Aumentar.setText("Aumentar Plazas");
        Aumentar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AumentarActionPerformed(evt);
            }
        });

        Reducir.setText("Reducir Plazas");
        Reducir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReducirActionPerformed(evt);
            }
        });

        cambiarEspecialidad.setText("Cambiar especialidad");
        cambiarEspecialidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cambiarEspecialidadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(AnhadirActividad, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                            .addComponent(Material, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(AnhadirMonitor, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                            .addComponent(cambiarSala, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(desorganizarActividad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Organizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(apuntarse, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                            .addComponent(desapuntarse, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cambiarEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Aumentar, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                            .addComponent(Reducir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(singUpButton, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(logInButton, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(errorApuntarse)
                                .addGap(29, 29, 29))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(errorDesapuntarse)
                                .addContainerGap())))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Aumentar, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Reducir, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(singUpButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(logInButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Material, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cambiarSala, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(apuntarse, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Organizar, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(AnhadirActividad, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AnhadirMonitor, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(desapuntarse, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(desorganizarActividad, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(cambiarEspecialidad, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(errorApuntarse)
                .addGap(13, 13, 13)
                .addComponent(errorDesapuntarse)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void singUpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_singUpButtonActionPerformed
        VRegistro SignUp = new VRegistro(fa);
        SignUp.setVisible(true);
    }//GEN-LAST:event_singUpButtonActionPerformed

    private void logInButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logInButtonActionPerformed
        fgui.iniciarSesion();
        aplicacion.Usuario us = fa.getLogged();
        if (us != null) {
            logInButton.setVisible(false);
            singUpButton.setVisible(false);
            if (us.getTipo() == aplicacion.TipoUsuario.Monitor) {
                Material.setVisible(true);
                AnhadirActividad.setVisible(true);
                desorganizarActividad.setVisible(true);
                cambiarSala.setVisible(true);
                AnhadirMonitor.setVisible(true);
                Organizar.setVisible(true);
                Aumentar.setVisible(true);
                Reducir.setVisible(true);
                cambiarEspecialidad.setVisible(true);
            } else {
                apuntarse.setVisible(true);
                desapuntarse.setVisible(true);

                if (fa.comprobarAvisos(us)) {
                    VAvisos avisos = new VAvisos(fa, us);
                    avisos.setVisible(true);
                }
            }
        }
    }//GEN-LAST:event_logInButtonActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        buscarActividades();
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void MaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MaterialActionPerformed
        fgui.iniciarMaterial();
    }//GEN-LAST:event_MaterialActionPerformed

    private void apuntarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apuntarseActionPerformed
        aplicacion.Organizar actividad = fa.obtenerActividades((String) jComboBox1.getSelectedItem()).get(jTable1.getSelectedRow());
        if (fa.apuntarseActividad(fa.getSesionCliente(), actividad))
            errorApuntarse.setVisible(false);
        else
            errorApuntarse.setVisible(true);
    }//GEN-LAST:event_apuntarseActionPerformed

    private void AnhadirActividadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnhadirActividadActionPerformed
        fgui.iniciarActividad();
    }//GEN-LAST:event_AnhadirActividadActionPerformed

    private void desorganizarActividadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_desorganizarActividadActionPerformed
        fgui.desorganizarActividad();
    }//GEN-LAST:event_desorganizarActividadActionPerformed

    private void desapuntarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_desapuntarseActionPerformed
        aplicacion.Organizar actividad = fa.obtenerActividades((String) jComboBox1.getSelectedItem()).get(jTable1.getSelectedRow());
        if (fa.desapuntarseActividad(fa.getSesionCliente(), actividad) == true)
            errorDesapuntarse.setVisible(false);
        else {
            errorDesapuntarse.setVisible(true);
        }
    }//GEN-LAST:event_desapuntarseActionPerformed

    private void cambiarSalaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cambiarSalaActionPerformed
        aplicacion.Organizar actividad = fa.obtenerActividades((String) jComboBox1.getSelectedItem()).get(jTable1.getSelectedRow());
        VCamSala newSala = new VCamSala(fa, actividad);
        newSala.setVisible(true);
    }//GEN-LAST:event_cambiarSalaActionPerformed

    private void AnhadirMonitor(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnhadirMonitor
        fgui.anhadirMonitor();
    }//GEN-LAST:event_AnhadirMonitor

    private void OrganizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OrganizarActionPerformed
        fgui.organizarActividad();
    }//GEN-LAST:event_OrganizarActionPerformed

    private void AumentarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AumentarActionPerformed
        fgui.aumentarPlazas();
    }//GEN-LAST:event_AumentarActionPerformed

    private void ReducirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReducirActionPerformed
        fgui.reducirPlazas();
    }//GEN-LAST:event_ReducirActionPerformed

    private void cambiarEspecialidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cambiarEspecialidadActionPerformed
        fgui.cambiarEspecialidad();
    }//GEN-LAST:event_cambiarEspecialidadActionPerformed

    private void rellenarComboBox() {
        jComboBox1.addItem("Todas");
        for (aplicacion.Instalacion e : fa.obtenerInstalaciones()) {
            jComboBox1.addItem(e.getNombre());
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AnhadirActividad;
    private javax.swing.JButton AnhadirMonitor;
    private javax.swing.JButton Aumentar;
    private javax.swing.JButton Material;
    private javax.swing.JButton Organizar;
    private javax.swing.JButton Reducir;
    private javax.swing.JButton apuntarse;
    private javax.swing.JButton cambiarEspecialidad;
    private javax.swing.JButton cambiarSala;
    private javax.swing.JButton desapuntarse;
    private javax.swing.JButton desorganizarActividad;
    private javax.swing.JLabel errorApuntarse;
    private javax.swing.JLabel errorDesapuntarse;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton logInButton;
    private javax.swing.JButton singUpButton;
    // End of variables declaration//GEN-END:variables
    public void buscarActividades() {
        ModeloTablaActividades m = (ModeloTablaActividades) jTable1.getModel();
        m.setFilas(fa.obtenerActividades((String) jComboBox1.getSelectedItem()));
        if (m.getRowCount() > 0) {
            jTable1.setRowSelectionInterval(0, 0);
        }
    }

}