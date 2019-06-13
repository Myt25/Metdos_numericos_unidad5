package interpolacion;


public class ctrInterpolacion {
    csInterpolacion interpolacion;
    
    public ctrInterpolacion(csInterpolacion inter){
        this.interpolacion = inter;
       
    }
    
    public String obtener(){
        double fx10 = this.fx(this.interpolacion.getFx1(),this.interpolacion.getFx0(),this.interpolacion.getX1(),this.interpolacion.getX0());
        double fx21 = this.fx(this.interpolacion.getFx2(),this.interpolacion.getFx1(),this.interpolacion.getX2(),this.interpolacion.getX1());
        double fx32 = this.fx(this.interpolacion.getFx3(),this.interpolacion.getFx2(),this.interpolacion.getX3(),this.interpolacion.getX2());
        double fx210 = this.fx(fx21, fx10,this.interpolacion.getX2(),this.interpolacion.getX0());
        double fx321 = this.fx(fx32, fx21,this.interpolacion.getX3(),this.interpolacion.getX1());
        double fx3210 = this.fx(fx321, fx210,this.interpolacion.getX3(),this.interpolacion.getX0());
        
        
        this.interpolacion.setDif1(fx10);
        this.interpolacion.setDif11(fx21);
        this.interpolacion.setDif111(fx32);
        this.interpolacion.setDif2(fx210);
        this.interpolacion.setDif22(fx321);
        this.interpolacion.setDif3(fx3210);
        
      
        String polinomio = this.interpolacion.getFx0()+"+" + fx10 +"(x-x0)" +"+"+ fx210 + "(x-x0)(x-x1)" +"+"+fx3210+ "(x-x0)(x-x1)(x-x2)";
        return polinomio;
    }
    
    public double fx(double A, double B,double a,double b){
        double resultado = (A - B)/(a-b);
        return resultado;
    }
    
}
