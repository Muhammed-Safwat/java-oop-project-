package BookShop;

import java.util.ArrayList;
import java.util.Scanner;

public class BookShop {
    public ArrayList<Book>books=new ArrayList<>() ; 
    public ArrayList<Admin>admins =new ArrayList<>();
    public ArrayList<String>waitList =new ArrayList<>();
    public ArrayList<user>users =new ArrayList<>();
    private long SalesNumber=0;
    Scanner input= new Scanner(System.in);
    
    BookShop(){
 
    }
  public void openShop(){
        intiAdmin();
        mainMenu();
  }
    private void intiAdmin(){
         Admin admin1 =new Admin();
         admin1.setId(1);
         admin1.setName("adminName");
         admin1.setPassword("admin");
         admins.add(admin1);
       }
     
    public void mainMenu() {
        System.out.println("1:Admin");
        System.out.println("2:User");
        int x = input.nextInt();
        input.nextLine();
        switch (x) {
            case 1:
                longIn();
                break;
            case 2:
                CustomerMenu();
                break;
            default:
                System.out.println("InValid choice !");
                break;
        }
    }
public void AddminMenu(){
   System.out.println("1:add book");
   System.out.println("2:delete book");
   System.out.println("3:update book price ");
   System.out.println("4:add new Admin");
   System.out.println("5:display all books");
   System.out.println("6:main menu");
   System.out.println("7:Exist");
   int x = input.nextInt();
      input.nextLine();
        switch (x) {
            case 1:
                addBook();
                break;
            case 2:
                {
                    System.out.println("Enter book name ");
                    String name   = input.nextLine();
                    deleteALlBookVersion(name);
                    break;
                }
            case 3:
                {
                    System.out.println("Enter book name ");
                    String name   = input.nextLine();
                    updateBookPricing(name);
                    break;
                }
            case 4:
                addNewAdmin();
                break;
            case 5:
                displayBooks();
                AddminMenu();
                break;
            case 6:
                mainMenu();
                break;
            case 7:
                System.out.println("Thanks,for your time");
                break;
            default:
                System.out.println("Invalid choice");
                AddminMenu();
                break;
        }
   
}
public void CustomerMenu(){
    System.out.println("1:display all books ");
    System.out.println("2:search for book");
    System.out.println("3:borrow book ");
    System.out.println("4:buy book");
    System.out.println("5:book books");
    System.out.println("6:CONNECT US");
    System.out.println("7:main menu");
    System.out.println("8:Exist");
    int x = input.nextInt();
            input.nextLine();
        switch (x) {
            case 1:
                displayBooks();
                CustomerMenu();
                break;
            case 2:
                {
                    System.out.println("Enter book name:");
                    String bookName = input.nextLine();
                    bookSearch(bookName);
                    CustomerMenu();
                    break;
                }
            case 3:
                {
                    System.out.println("Enter book name ");
                    String bookName =input.nextLine();
                    System.out.println("Enter number of books: ");
                    int num = input.nextInt();
                    input.nextLine();
                    borrowBook(bookName,num);
                    CustomerMenu();
                    break;
                }
            case 4:
                {
                    System.out.println("Enter book name ");
                    String bookName =input.nextLine();
                    System.out.println("Enter number of books: ");
                    int num = input.nextInt();
                    buyBook(bookName,num);
                    CustomerMenu();
                    break;
                }
            case 5:
                {  
                    System.out.println("Enter book name :");
                    String bookName =input.nextLine();
                    waitList.add(bookName);
                     BookOrder(bookName);
                    CustomerMenu();
                    break;
                }
            case 6:
                System.out.println("Our phone number :************");
                System.out.println("Our email :************");
                CustomerMenu();
                break;
            case 7:
                mainMenu();
                break;
            case 8:
                System.out.println("Thank you for your time");
                break;
            default:
                System.out.println("InValid opption!");
                break;
        }
    
 }
public void longIn(){
    System.out.println("Enter your id :");
    int id = input.nextInt();
    input.nextLine();
    System.out.println("Enter your passward");
    String passward = input.nextLine();
    searchAdmin(id , passward ); 
}
public void searchAdmin(int id , String pass){
    for (int i=0; i<admins.size(); i++) {
        int curr = admins.get(i).getId();
        String password = admins.get(i).getPassword();
         if(curr==id && password.equals(pass)){
             System.out.println("Hello "+admins.get(i).getName());
             AddminMenu();
             
         }else {
             System.out.println("invlaid password and id !");
             mainMenu();
         }
    }
    
}



    private void addBook() {
        Book  book = new Book();
        books.add(book);

        AddminMenu();
    }
    public int search(String name){
        
        for (int i=0; i<books.size(); i++) {
        String curr = books.get(i).getName().toLowerCase();
            if(curr.equals(name.toLowerCase())){
                System.out.print(i+4);
                 
            }
        }
        return 0; 
    }
    public void deleteALlBookVersion(String name) {
        boolean a = false;
        for (int i=0; i<books.size(); i++) {
        String curr = books.get(i).getName().toLowerCase();
            if(curr.equals(name.toLowerCase())){
                 books.remove(i);
                 a=true;
                System.out.println("book deleted successfully");
                break;
            } 
        }
        if(!a){
            System.out.println("book not found");
        }
        AddminMenu();
    }
        
       

    private void updateBookPricing(String lastName) {
             boolean a = false;
    for(int i= 0; i<books.size();i++){
       
        if(books.get(i).getName().equals(lastName)){
                    books.get(i).setSalePrice();
                    books.get(i).setBorrowPrice();
                    System.out.println("book after update :");
                    books.get(i).displayBookData();
                    System.out.println("update complete.");
                    a=true;
                    break;
             }
        }
            if(!a){
                System.out.println("book not found");
            }
            AddminMenu();
    }

    private void addNewAdmin() {
              Admin newAdmin = new Admin();
              System.out.println("enter id ");
              int id = input.nextInt();
              input.nextLine();
              newAdmin.setId(id);
              System.out.println("enter name ");
              String name  = input.nextLine();
              newAdmin.setName(name);
              System.out.println("set password ");
              String pass  = input.nextLine();
              newAdmin.setPassword(pass);
       System.out.println("admin "+newAdmin.getName()+" successfuly ");
       AddminMenu();
    }
   public void displayBooks(){
       for(int i =0  ;i<books.size() ;i++){
           System.out.println("Book "+(i+1));
           books.get(i).displayBookData();
       }
       
   }

    
   public void bookSearch(String name){
       boolean a = false ;
       for(int i =0  ;i<books.size() ;i++){
           if(books.get(i).getName().toLowerCase().equals(name.toLowerCase())){
               books.get(i).displayBookData();
               a=true;
               break;
           }
       }
       if(!a){
           System.out.println("book is not avilable ");
       }
   }
    private  void comfirmation(int i,int num){
        System.out.println("To comfirm order");
        System.out.println("1:YES");
        System.out.println("2:NO");
        int x= input.nextInt();
                input.nextLine();
        if(x==1){
           if(books.get(i).buybook(num)){
           System.out.println("fill your data for Delivery");
           customerData();
          }
        }else if(x==2){
            System.out.println("Thanks for your time ");
            
        }
    }
    
    private void borrowBook(String name , int num) {
       boolean a=false;
          for(int i =0  ;i<books.size() ;i++){
            if(books.get(i).getName().toLowerCase().equals(name.toLowerCase())){
                System.out.println("The cost of borrowing this book = "+(books.get(i).getBorrowPrice()*num)+" $");
                comfirmation(i,num); 
                a=true;
            }
          }
          if(!a){
              System.err.println("Sorry , not avilable now");
          }
    }

    private String customerData() {
        user newUser = new user();
        System.out.println("Enter your name :");

        String name = input.nextLine();
        newUser.setName(name);
        System.out.println("Enter your address :");

        String address = input.nextLine();
        newUser.setName(address);
        System.out.println("Enter your phone Number :");

        String phoneNumber = input.nextLine();
        newUser.setName(phoneNumber);
        System.out.println("Enter your email :");

        String email = input.nextLine();
        newUser.setName(email);
        users.add(newUser);
        
  return name;  }
    private void BookOrder(String name) {
        System.out.println("fill your personal data for Delivery");
        String s = customerData();
        System.out.println("Mr "+s+"\nYour order booked sucssufly");
    }
    private void buyBook(String name , int num) {
        boolean a=false;
          for(int i =0  ;i<books.size() ;i++){
            if(books.get(i).getName().toLowerCase().equals(name.toLowerCase())){
                System.out.println("The cost of borrowing this book = "+(books.get(i).getSalePrice()*num)+" $");
                comfirmation(i,num);
                a=true;
                SalesNumber++;
            }
          }
          if(!a){
              System.err.println("Sorry , not avilable now");
          }
    }
     
 
}

