/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.ues.occ.ingenieria.prn335_2019.cine.primerparcialrepetido.control;

import java.io.Serializable;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import sv.edu.ues.occ.ingenieria.prn335_2019.cine.primerparcialrepetido.entity.Orden;

/**
 *
 * @author jcpenya
 */
@Stateless
@LocalBean
public class OrdenBean implements Serializable {

    public Double calcularCostoOrden(Orden o) {
        if (o != null && o.getMontoTotal() != null && o.getMontoTotal().compareTo(0d) > 0) {
            return o.getMontoTotal();
        }
        return 0d;
    }

}
