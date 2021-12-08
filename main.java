import java.util.Scanner;
class main {
    static Scanner input=new Scanner(System.in); 
    public static void main(String[] args){
         /*this program will help use to keep info of student in university
        with caracteristic name,age,matriculation,sex,faculty
        -it it will also help use to keep the student marks
        -we shall also have the profesor information which will be caractarise by
        --name,course,sex,salary
        the variouse request will be 
        -have list of student
        -have student mark
        -have student average
        //
        ***syntax in declarating tablle of student
        etudient[] tab_etu=new etudient[5];  
        tab_etu[1]=etu;
         System.out.print(tab_etu[1].name);
        */
        int num;
       
      
       student[] stu_tab=new student[100];
       subject[] marks=new subject[100];
        
        int chx=1;
        do{
           System.out.println("[1]Regiser student"); 
           System.out.println("[2]list of student"); 
           System.out.println("[3]search student"); 
           System.out.println("[4]student index"); 
           System.out.println("[5]student editing"); 
           System.out.println("[6]register student marks");
           System.out.println("enter your choise or enter [0] to exit"); 
           chx=input.nextInt();
           input.nextLine();
           switch(chx){
               case 0:
               System.out.println("exit succesfull");
               break;
               case 1:
               System.out.println("how many student do you want to register");
               num=input.nextInt();
               input.nextLine();
               register_student(num,stu_tab,marks);
               break;
               case 2:
               name_student(stu_tab);
               break;
               case 3:
               System.out.println("enter the matricule of student you are searching");
                String mat=input.nextLine();
                if(search_student(stu_tab, mat))
                    System.out.println("the student is well register!!!");
                else System.out.println("the student is not register!!!!");
                
               break;

               case 4:
               System.out.println("enter the student matriculation");
               String smat=input.nextLine();
               System.out.println(index_stut(stu_tab, smat));
               break;

               case 5:
               edit_stut(stu_tab);
               break;

               case 6:
                System.out.println("!!!!--EXIT successfull---!!!");
                break;
               default:
               System.out.println("your enter a wrong option chose between 1-3");
               break;
           }
        }while(chx!=0);
      

    }

    //this function help use to register student 
    public static void register_student(int n,student tab[],subject marks[]){
        
        String name,mat,course;
        
        int age;
        for(int i=0;i<n;i++){
            System.out.println("---------------------register student--------------------");
            System.out.println("enter student name");
             name=input.nextLine();
            System.out.println("enter student matriculation");
             mat=input.nextLine();
            System.out.println("enter student age");
            age=input.nextInt();
            input.nextLine();
            System.out.println("enter student course");
            course=input.nextLine();
            System.out.println("All the marks of "+name+" will be initialise to 0/20");
            marks[i]=new subject(0, 0, 0, 0);
            tab[i]=new student(name, mat, age, course,marks[i]);
        }
      
    }
    
    //this function help us to have list of student
    static void name_student(student tab[])
    {
        System.out.println("\tthe lis of student are ");
        
        for(int i=0;i <student.numberOfstu;i++){
            System.out.println("["+(i)+"] "+tab[i].name);
        }
        
    }
    
    //search student in the student list
    public static boolean search_student(student tab[],String matri){//this function is to search student in database
        
            for(int i=0;i<student.numberOfstu;i++){
                boolean equalsIgnoreCase = tab[i].mat.equalsIgnoreCase(matri);
                if(equalsIgnoreCase){
                    tab[i].stut_info();
                    return true;
                }
            }
        
            return false; 
    }
   
    //find student index in the database
    public static int index_stut(student tab[],String mat){
        int ind=-1;
        if(search_student(tab, mat)){
            for(int i=0;i<student.numberOfstu;i++){
                boolean equalsIgnoreCase = tab[i].mat.equalsIgnoreCase(mat);
                if(equalsIgnoreCase){
                    return i;
                }
            }
        }
        return ind;
    }

    //menu to change student inforrrmation
    public static void edit_stut(student tab[]){
        int chx=0;
        System.out.println("enter the matricule  of student you want to edit");
        
        String mat=input.nextLine();
        if(search_student(tab, mat)){
            int index=index_stut(tab, mat);
            System.out.println("-----------------"+ tab[index].name +" present info--------------");
            tab[index].stut_info();
            do{
                System.out.println("\n\n-----------------------EDIT MENU-------------------");
                System.out.println("choose what you want to edit on "+tab[index].name);
                System.out.println("[1]Name");
                System.out.println("[2]Matricule");
                System.out.println("[3]age");
                System.out.println("[4]Course");
                System.out.println("[5]Change everything");
                System.out.println("[6]Exit Edit Menu ");
                System.out.println("Enter option");
                chx=input.nextInt();
                input.nextLine();
            switch (chx) {
                case 1:
                    new_name(tab, index);
                    System.out.println("!!!!!!-Name update successfull-!!!!!");
                    break;
                case 2:
                    new_matriculation(tab, index);
                    System.out.println("!!!!!!-Matricule update successfull-!!!!!");
                    break;
                case 3:
                    new_age(tab, index);
                    System.out.println("!!!!!!-Age update successfull-!!!!!");
                    break;
                case 4:
                    new_course(tab, index);
                    System.out.println("!!!!!!-course update successfull-!!!!!");
                    break;
                case 5:
                    new_name(tab, index);
                    new_matriculation(tab, index);
                    new_age(tab, index);
                    new_course(tab, index);
                    System.out.println("!!!!!!-student update successfull-!!!!!");
                    break;
            
                default:
                    System.out.println("incorect option enter [6] to exit menu");
                    break;
            }
            }while(chx!=6);
        }
        else{
            System.out.println("!!the student with matricule:"+mat+" does not exist!!!");
        }

    }

    //change student name
    public static void new_name(student tab[],int index)
    {   
        System.out.println("enter new name");
        String name=input.nextLine();
        tab[index].name=name;
    }

    //change student matricule
    public static void new_matriculation(student tab[],int index)
    {   
        System.out.println("enter new matricule");
        String mat=input.nextLine();
        tab[index].mat=mat;
    }

    //change student age 
    public static void new_age(student tab[],int index)
    {   
        System.out.println("enter new age");
        int age=input.nextInt();
        tab[index].age=age;
    }

    //change student course name
    public static void new_course(student tab[],int index)
    {   
        System.out.println("enter new course");
        String course=input.nextLine();
        tab[index].course=course;
    }

    //change all he marksof a student
    public static void record_marks(student tab[]) 
    {

        System.out.println("Enter the matriculation of student you want ot record");
        String mat=input.nextLine();
        if(search_student(tab, mat))
        {
            int index=index_stut(tab, mat);
            System.out.println("---------------older Marks of"+tab[index].name+" --------");
            tab[index].sub.stut_marks();
            System.out.println("Enter biology Marks");
            float bios=input.nextFloat();
            input.nextLine();
            tab[index].sub.bios=bios;
            System.out.println("Enter physics Marks");
            float phy=input.nextFloat();
            input.nextLine();
            tab[index].sub.phy=phy;
            System.out.println("Enter Math Marks");
            float math=input.nextFloat();
            input.nextLine();
            tab[index].sub.math=math;
            System.out.println("Enter chem Marks");
            float chem=input.nextFloat();
            input.nextLine();
            tab[index].sub.chem=chem;
        }
        else
        {
            System.out.println("this matricule does not exist in database");
        }
    }




}


