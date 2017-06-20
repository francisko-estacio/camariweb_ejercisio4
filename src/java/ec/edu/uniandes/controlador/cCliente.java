/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uniandes.controlador;

import ec.edu.uniandes.entidades.clsCliente;
import ec.edu.uniandes.funciones.CrudCliente;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Francisco-E
 */
@ManagedBean
@ViewScoped
public class cCliente {
    private List<clsCliente> lista;
    private  clsCliente newcliente;// cuando ingrese un cleinte nevo
    private clsCliente selectedcliente;//cuando seleccione un cliente para borrar

    public cCliente() {
        newcliente = new clsCliente ();
        cargardatos();
    }
    
    private void cargardatos(){
         lista = CrudCliente.findbyAll();
    }

    

    public List<clsCliente> getLista() {
        return lista;
    }

    public void setLista(List<clsCliente> lista) {
        this.lista = lista;
    }

    public clsCliente getNewcliente() {
        return newcliente;
    }

    public void setNewcliente(clsCliente newcliente) {
        this.newcliente = newcliente;
    }

    public clsCliente getSelectedcliente() {
        return selectedcliente;
    }

    public void setSelectedcliente(clsCliente selectedcliente) {
        this.selectedcliente = selectedcliente;
    }

}
 