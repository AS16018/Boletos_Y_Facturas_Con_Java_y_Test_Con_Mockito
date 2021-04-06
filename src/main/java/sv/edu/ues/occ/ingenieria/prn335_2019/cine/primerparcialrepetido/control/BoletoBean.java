/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.ues.occ.ingenieria.prn335_2019.cine.primerparcialrepetido.control;

import java.io.Serializable;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import sv.edu.ues.occ.ingenieria.prn335_2019.cine.primerparcialrepetido.entity.Boleto;

/**
 *
 * @author jcpenya
 */
@Stateless
@LocalBean
public class BoletoBean implements Serializable {

    public Double calcularCostoBoleto(Boleto b) throws IllegalStateException {
        Double salida = 0d;
        if (b != null && b.getPrecioBase() != null) {
            if (b.getPrecioBase().compareTo(salida) > 0) {
                salida = b.getPrecioBase();
                if (b.getIdDescuento() != null && b.getIdDescuento().getPorcentaje() > 0) {
                    if (b.getIdDescuento().getPorcentaje() > 1) {
                        throw new IllegalStateException("El porcentaje de descuento no puede ser mayor que 1");
                    }
                    salida = salida - (salida * b.getIdDescuento().getPorcentaje());
                }
            }
        }
        return salida;
    }

}
