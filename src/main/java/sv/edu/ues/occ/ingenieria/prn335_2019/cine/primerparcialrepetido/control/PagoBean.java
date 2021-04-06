/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.ues.occ.ingenieria.prn335_2019.cine.primerparcialrepetido.control;

import java.io.Serializable;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import sv.edu.ues.occ.ingenieria.prn335_2019.cine.primerparcialrepetido.entity.Factura;

/**
 *
 * @author jcpenya
 */
@Stateless
@LocalBean
public class PagoBean implements Serializable {

    public Double findTotalPagadoByFactura(Factura f) {
        if (f != null && f.getPagoList() != null && !f.getPagoList().isEmpty()) {
            Double totalPagado = 0d;
            totalPagado = f.getPagoList().stream().filter((p) -> (p.getMonto() > 0)).map((p) -> p.getMonto()).reduce(totalPagado, (accumulator, _item) -> accumulator + _item);
            return totalPagado;
        }
        return 0d;
    }

}
