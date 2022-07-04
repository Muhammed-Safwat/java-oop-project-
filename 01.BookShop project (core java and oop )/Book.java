package BookShop;
import java.util.Scanner;

public class Book {

    private int key ; 
    private int versionNum;
    private String name ; 
    private String type ; 
    private String author ; 
    private double  salePrice ; 
    private double  borrowPrice ; 
    private String publicationDate ;
    Scanner input = new Scanner(System.in);
    public Book() {
        createBook();
    }
    public void createBook(){
       String name= setName();
        setType();
        setAuthor();
        setPublicationDate();
        setKey(); 
        setVersionNum();
        setSalePrice();
        setBorrowPrice(); 
        System.out.println(name+" added successfully"); 
          
    }

    public int getKey() {
        return key;
    }

    public void setKey() {
        System.out.println("Enter book id : ");
        int key = input.nextInt();
        this.key = key;
        input.nextLine();
    }

    public int getVersionNum() {
        return versionNum;
    }

    public void setVersionNum( ) {
        System.out.println("Enter version numbers :");
        int versionNum = input.nextInt();
                input.nextLine();
        this.versionNum = versionNum;
    }
    public String getName() {
        return name;
    }

    public String setName() {
        System.out.println("Enter Book name :");
        String name = input.nextLine();
        this.name = name;
        return name;
    }

    public String getType() {
        return type;
    }

    public void setType() {
        System.out.println("Enter Book type :");
        String type = input.nextLine();
        this.type = type;
    }

    public String  getAuthor() {
        return author;
    }

    public void setAuthor() {
        System.out.println("Enter Book Author :");
        String author = input.nextLine();
        this.author = author;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice() {
        System.out.println("Enter Book sale Price :");
        double sale = input.nextDouble();
        this.salePrice = sale;
    }

    public double getBorrowPrice() {
        return borrowPrice;
    }

    public void setBorrowPrice() {
        System.out.println("Enter Book borrow Price :");
        double borrowPrice = input.nextDouble();
                input.nextLine();
        this.borrowPrice = borrowPrice;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate() {
        System.out.println("Enter Book publication Date :");
         String publicationDate = input.nextLine();
        this.publicationDate = publicationDate;
    }
    public boolean buybook(int amout){
        if(versionNum==0){
            System.out.println("this book not available now ");
            return false ; 
        }else if (versionNum<amout){
            System.out.println("available right now "+versionNum);
            return false ;
        }else{
            versionNum=versionNum-amout;
           return true;
        }
    }

    
    public void displayBookData() {
         System.out.println("Name = " + name + " ,Book type = " + type + " ,Author = " + author+" ,Publication date "+publicationDate );
         System.out.println("Version number in shop "+versionNum+"\nSalePrice = " + salePrice + "\nSorrowPrice = " + borrowPrice );
         System.out.println("*********************************************************************************");
    }
    
}
