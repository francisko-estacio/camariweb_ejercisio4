/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uniandes.funciones;

import java.util.ArrayList;
import ec.edu.uniandes.accesodatos.AccesoDatos;
import ec.edu.uniandes.accesodatos.ConjuntoResultado;
import ec.edu.uniandes.accesodatos.Parametro;
import ec.edu.uniandes.entidades.clsCliente;
import ec.edu.uniandes.entidades.clsProducto;

/**
 *
 * @author Usuario
 */
public class CrudProducto {
   
     public boolean save(clsProducto producto){
        boolean resultado = false;
        String sql = "INSERT INTO public.producto(nombre, stock, precio_venta) VALUES(?,?,?)";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, producto.getNombre()));
        lstPar.add(new Parametro(2, producto.getStock()));
        lstPar.add(new Parametro(3, producto.getPrecio_venta()));
        
        try {
            resultado = AccesoDatos.ejecutaComando(sql, lstPar);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return resultado;
    }
         public boolean delete(clsProducto producto) {
        boolean res=false;
        String sql = "DELETE FROM public.producto WHERE id_producto=?";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1,producto.getId_producto()));
        try {
            res= AccesoDatos.ejecutaComando(sql, lstPar);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        return res;
    }

    public static boolean update(clsProducto miProducto) {
        boolean res = false;
        String sql = "UPDATE public.producto " +
                "SET nombre=?, stock=?, precio_venta=? " +
                "WHERE id_producto=?";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1,miProducto.getId_producto()));
        lstPar.add(new Parametro(2,miProducto.getNombre()));
        lstPar.add(new Parametro(3,miProducto.getStock()));
        lstPar.add(new Parametro(4,miProducto.getPrecio_venta()));
        
        try{
            res= AccesoDatos.ejecutaComando(sql, lstPar);
        }catch (Exception e) {
            System.out.println(e.getMessage());
            }
        return res;
    }

    public static ArrayList<clsProducto> findbyAll() {
        ArrayList<clsProducto> listado = new ArrayList<>();
        String sql = "SELECT id_producto, nombre, stock, precio_venta "+
                "FROM public.producto";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar);
            clsProducto producto = null;
            while (cres.next())
            {
                producto = new clsProducto();
                producto.setId_producto(cres.getInt("id_producto"));
                   producto.setNombre(cres.getString("nombre"));
                producto.setStock(cres.getInt("stock"));
                producto.setPrecio_venta(cres.getInt("precio_venta"));
                listado.add((producto));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listado;
    }
       
    public static ArrayList<clsProducto> findbyStock( int stock) {
        ArrayList<clsProducto> listado = new ArrayList<>();
        String sql = "SELECT id_producto, nombre, stock "+
                "FROM public.producto"+
                "WHERE stock <?";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(1, new Parametro(1, stock));
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar);
            clsProducto producto = null;
            while (cres.next())
            {
                producto = new clsProducto();
                producto.setId_producto(cres.getInt("id_producto"));
                   producto.setNombre(cres.getString("nombre"));
              
                producto.setPrecio_venta(cres.getInt("precio_venta"));
                  producto.setStock(cres.getInt("stock"));
                listado.add((producto));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listado;
    }
    public clsProducto findbyId(clsProducto pro) {
        clsProducto producto = null;
        String sql = "SELECT id_producto, nombre, stock, precio_venta "+
                "FROM public.producto WHERE id_producto=?";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1, pro.getId_producto()));
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar);
            while (cres.next()) {
                producto = new clsProducto();
                producto.setId_producto(cres.getInt("id_producto"));
                producto.setNombre(cres.getString("nombre"));
                producto.setStock(cres.getInt("stock"));
                producto.setPrecio_venta(cres.getInt("precio_venta"));
               
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return producto;
    }
     public static clsProducto findbyId(int id_producto) {
         clsProducto producto = null;
        String sql = "SELECT id_producto, nombre, stock, precio_venta "+
                "FROM public.producto WHERE id_producto=?";
        ArrayList<Parametro> lstPar = new ArrayList<>();
        lstPar.add(new Parametro(1,id_producto));
        try {
            ConjuntoResultado cres = AccesoDatos.ejecutaQuery(sql, lstPar);
            while (cres.next()) {
                producto = new clsProducto();
               producto.setId_producto(cres.getInt("id_producto"));
                producto.setNombre(cres.getString("nombre"));
                producto.setStock(cres.getInt("stock"));
                producto.setPrecio_venta(cres.getInt("precio_venta"));
                     
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return producto;
    }
}
