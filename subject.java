public class subject {
    float math;
    float phy;
    float bios;
    float chem;
    
    subject(float math,float phy,float bios,float chem){
        this.math=math;
        this.phy=phy;
        this.bios=bios;
        this.chem=chem;
        
    }
    float sum_note(){
        return this.math+this.phy+this.bios+this.chem;
    }

    float average(float sum){
        return sum/5;
    }
    public void stut_marks(){
        System.out.println("Physics:"+this.phy+"\nMath:"+this.math+"\nBios: "+this.bios+
        "\nChem: "+this.chem);
    }

}
