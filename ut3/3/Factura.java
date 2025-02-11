import java.io.Serializable;
public class Factura implements Serializable{
    private static final long serialVersionUID = 1L;
    String numerofactura;
    String fechafactura;
    double importe;
    String tipoiva;
    double iva;
    double importetotal;
    public Factura(String numerofactura,String fechafactura,double importe,String tipoiva){
        super();
        this.numerofactura = numerofactura;
        this.fechafactura = fechafactura;
        this.importe = importe;
        this.tipoiva = tipoiva;
    }
    public Factura(){super();}
    public String getFechafactura() {
        return fechafactura;
    }
    public double getImporte() {
        return importe;
    }
    public double getImportetotal() {
        return importetotal;
    }
    public double getIva() {
        return iva;
    }
    public String getNumerofactura() {
        return numerofactura;
    }
    public String getTipo() {
        return tipoiva;
    }
    public void setFechafactura(String fechaFactura) {
        this.fechafactura = fechaFactura;
    }
    public void setImporte(double importe) {
        this.importe = importe;
    }
    public void setImportetotal(double importeTotal) {
        this.importetotal = importeTotal;
    }
    public void setIva(double iva) {
        this.iva = iva;
    }
    public void setNumerofactura(String numeroFactura) {
        this.numerofactura = numeroFactura;
    }
    public void setTipo(String tipo) {
        this.tipoiva = tipo;
    }
}
