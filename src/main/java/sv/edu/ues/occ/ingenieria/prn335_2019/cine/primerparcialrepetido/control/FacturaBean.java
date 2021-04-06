/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.ues.occ.ingenieria.prn335_2019.cine.primerparcialrepetido.control;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TemporalType;
import sv.edu.ues.occ.ingenieria.prn335_2019.cine.primerparcialrepetido.entity.Boleto;
import sv.edu.ues.occ.ingenieria.prn335_2019.cine.primerparcialrepetido.entity.Factura;
import sv.edu.ues.occ.ingenieria.prn335_2019.cine.primerparcialrepetido.entity.Orden;

/**
 *
 * @author jcpenya
 */
@Stateless
@LocalBean
public class FacturaBean implements Serializable {

    @PersistenceContext(unitName = "my_persistence_unit")
    EntityManager em;

    @Inject
    BoletoBean boletoBean;

    @Inject
    OrdenBean ordenBean;

    @Inject
    PagoBean pagoBean;

    public List<Factura> findPendientesDePagoByFechas(final Date fechaDesde, final Date fechaHasta, int first, int pageSize) {
        if (fechaDesde != null && fechaHasta != null && fechaDesde.compareTo(fechaHasta) <= 0 && first >= 0 && pageSize > 0) {
            Query q = em.createNamedQuery("Factura.findPendientesDePagoByFechas");
            List<Factura> facturasEnRango = q.setParameter("fechaDesde", fechaDesde, TemporalType.DATE)
                    .setParameter("fechaHasta", fechaHasta, TemporalType.DATE)
                    .setFirstResult(first)
                    .setMaxResults(pageSize)
                    .getResultList();
            if (facturasEnRango != null && !facturasEnRango.isEmpty()) {
                List facturasPendientes = new ArrayList();
                facturasEnRango.forEach((f) -> {
                    Double totalFactura = calcularTotalFactura(f);
                    Double totalPagado = pagoBean.findTotalPagadoByFactura(f);
                    System.out.println("totalFactura ================= " + totalFactura);
                    System.out.println("totalPagado ================= " + totalPagado);
                    if (totalFactura.compareTo(totalPagado) > 0) {
                        facturasPendientes.add(f);
                    }
                });
                return facturasPendientes;
            }
        }
        return Collections.EMPTY_LIST;
    }

    public Double calcularTotalFactura(Factura f) {
        Double total = 0d;
        total += calcularTotalFacturaBoletos(f);
        total += calcularTotalFacturaOrdenes(f);
        System.out.println("METODOOO TOTAL = "+ total);
        return total;
    }

    public Double calcularTotalFacturaBoletos(Factura f) {
        if (f.getBoletoList() != null && !f.getBoletoList().isEmpty()) {
            Double totalBoletos = 0d;
            for (Boleto b : f.getBoletoList()) {
                try {
                    totalBoletos += boletoBean.calcularCostoBoleto(b);
                } catch (IllegalStateException ex) {
                    Logger.getLogger(getClass().getName()).log(Level.WARNING, ex.getMessage(), ex);
                }
            }
            System.out.println("calcularTotalFacturaBoletos ========= " +totalBoletos);
            return totalBoletos;
        }
        return 0d;
    }

    public Double calcularTotalFacturaOrdenes(Factura f) {
        if (f.getOrdenList() != null && !f.getOrdenList().isEmpty()) {
            Double totalOrdenes = 0d;
            for (Orden o : f.getOrdenList()) {
                totalOrdenes += ordenBean.calcularCostoOrden(o);
            }
            System.out.println("calcularTotalFacturaOrdenes ========= " +totalOrdenes);
            return totalOrdenes;
        }
        return 0d;
    }
}
