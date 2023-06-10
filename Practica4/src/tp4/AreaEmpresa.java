/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp4;

/**
 *
 * @author frank
 */
public class AreaEmpresa {
    private String identificacion;
    private int tardanza;

    public AreaEmpresa(String identificacion, int tardanza) {
        this.identificacion = identificacion;
        this.tardanza = tardanza;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public int getTardanza() {
        return tardanza;
    }

    public void setTardanza(int tardanza) {
        this.tardanza = tardanza;
    }
    
    
}
