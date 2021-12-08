public class student{
    String name;
    String mat;
    int age;
    String course;
    subject sub;
    public float average;
    static int numberOfstu;  //this static int increment after any student is created
   
    
   public student(String name,String mat,int age,String course,subject sub)
   {    
        
        this.name=name;
        this.mat=mat;
        this.age=age;
        this.course=course;
        this.sub=sub;
        numberOfstu++;
   }

   
   public void stut_info(){ //the tostring permit use to return the following characters

       System.out.println("Name:"+this.name+"\nMatricule:"+this.mat+"\nAge: "+this.age+"\nCourse: "+this.course);
   }


}