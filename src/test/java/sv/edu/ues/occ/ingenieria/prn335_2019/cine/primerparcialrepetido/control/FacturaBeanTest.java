/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.ues.occ.ingenieria.prn335_2019.cine.primerparcialrepetido.control;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TemporalType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import sv.edu.ues.occ.ingenieria.prn335_2019.cine.primerparcialrepetido.entity.Boleto;
import sv.edu.ues.occ.ingenieria.prn335_2019.cine.primerparcialrepetido.entity.Factura;
import sv.edu.ues.occ.ingenieria.prn335_2019.cine.primerparcialrepetido.entity.Orden;

/**
 *
 * @author jcpenya
 */
@ExtendWith(MockitoExtension.class)
public class FacturaBeanTest {

    public FacturaBeanTest() {
    }

    @Test
    public void testFindPendientesDePagoByFechas() throws Exception {
        System.out.println("findPendientesDePagoByFechas");

        FacturaBean factura = new FacturaBean();
        EntityManager emMock = Mockito.mock(EntityManager.class);
        FacturaBean beanMock = Mockito.mock(FacturaBean.class);
        PagoBean pagoMock = Mockito.mock(PagoBean.class);

        try {
            
            

            Date fechaDesde = new Date();
            Date fechaHasta = new Date();
            fechaHasta.setYear(fechaDesde.getYear() + 1);
            int first = 0, pageSize = 100;
            //probamos que el resultado del metodo sea una lista vacia
            List listaNull = factura.findPendientesDePagoByFechas(null, fechaHasta, first, pageSize);
            Assertions.assertTrue(listaNull.isEmpty());
            
            List<Factura> lista = new ArrayList();
            lista.add(new Factura(1));
            
            //probamos la consulta
            Query queryMock = Mockito.mock(Query.class);
            Mockito.when(emMock.createNamedQuery(Mockito.anyString())).thenReturn(queryMock);
            Mockito.when(emMock.createNamedQuery(Mockito.anyString()).setParameter("fechaDesde", fechaDesde, TemporalType.DATE)).thenReturn(queryMock);
            Mockito.when(emMock.createNamedQuery(Mockito.anyString()).setParameter("fechaDesde", fechaDesde, TemporalType.DATE).setParameter("fechaHasta", fechaHasta, TemporalType.DATE)).thenReturn(queryMock);
            Mockito.when(emMock.createNamedQuery(Mockito.anyString()).setParameter("fechaDesde", fechaDesde, TemporalType.DATE).setParameter("fechaHasta", fechaHasta, TemporalType.DATE).setFirstResult(first)).thenReturn(queryMock);
            Mockito.when(emMock.createNamedQuery(Mockito.anyString()).setParameter("fechaDesde", fechaDesde, TemporalType.DATE).setParameter("fechaHasta", fechaHasta, TemporalType.DATE).setFirstResult(first).setMaxResults(pageSize)).thenReturn(queryMock);
            Mockito.when(emMock.createNamedQuery(Mockito.anyString()).setParameter("fechaDesde", fechaDesde, TemporalType.DATE).setParameter("fechaHasta", fechaHasta, TemporalType.DATE).setFirstResult(first).setMaxResults(pageSize).getResultList()).thenReturn(lista);
            Factura fac = new Factura(1);
            System.out.println("LISTAAAAAAAAAAAAAAmOOOOOOOOOOOOOOOCKKKKKKK = " + lista);
            Double totalPagado = 2.0;
            Double totalFactura = 3.0;
            

           // Mockito.when(beanMock.calcularTotalFactura(fac)).thenReturn(totalFactura);
            Mockito.when(pagoMock.findTotalPagadoByFactura(fac)).thenReturn(totalPagado);

            factura.em = emMock;
            factura.pagoBean = pagoMock;
            factura.findPendientesDePagoByFechas(fechaDesde, fechaHasta, first, pageSize);
        } catch (Exception e) {
        }

    }

    @Test
    public void testCalcularTotalFactura() throws Exception {
        System.out.println("calcularTotalFactura");
        FacturaBean factura = new FacturaBean();
        Factura fac = new Factura();
        factura.calcularTotalFactura(fac);

    }

    @Test
    public void testCalcularTotalFacturaBoletos() throws Exception {
        System.out.println("calcularTotalFacturaBoletos");
        try {
            FacturaBean factura = new FacturaBean();
            BoletoBean boletoMock = Mockito.mock(BoletoBean.class);

            Factura fac = new Factura(1);
            List<Boleto> listaBoleto = new ArrayList();
            listaBoleto.add(new Boleto(1));
            fac.setBoletoList(listaBoleto);
            Double totalBoletos = 10.0;
            for (Boleto b : fac.getBoletoList()) {
                try {
                    Mockito.when(boletoMock.calcularCostoBoleto(b)).thenReturn(totalBoletos);
                } catch (IllegalStateException ex) {
                    Logger.getLogger(getClass().getName()).log(Level.WARNING, ex.getMessage(), ex);
                }
            }

            factura.boletoBean = boletoMock;
            factura.calcularTotalFacturaBoletos(fac);

        } catch (Exception e) {
        }

    }

    @Test
    public void testCalcularTotalFacturaOrdenes() throws Exception {
        System.out.println("calcularTotalFacturaOrdenes");
        FacturaBean factura = new FacturaBean();
        OrdenBean ordenMock = Mockito.mock(OrdenBean.class);
        try {

            Factura fac = new Factura(1);
            List<Orden> listaOrden = new ArrayList();
            listaOrden.add(new Orden(1));
            fac.setOrdenList(listaOrden);
            Double totalOrdenes = 5.0;
            for (Orden o : fac.getOrdenList()) {
                Mockito.when(ordenMock.calcularCostoOrden(o)).thenReturn(totalOrdenes);
            }
            
            factura.ordenBean = ordenMock;
            factura.calcularTotalFacturaOrdenes(fac);
            
            
        } catch (Exception e) {
        }

    }

}
