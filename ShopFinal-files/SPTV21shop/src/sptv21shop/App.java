/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sptv21shop;
import enyity.Client;


import enyity.Product;
import java.util.Scanner;
import managers.ClientManager;
import managers.HistoryManager;
import managers.ProductManager;
import managers.OborotManager;
import enyity.History;
import enyity.Oborot;
import java.util.List;
import managers.DataManeger;
/**
 *
 * @author NikitaSkr
 */
public class App {
    private final Scanner scanner;
    private final ProductManager productManager;
    private final ClientManager clientManager;
    private final OborotManager oborotman;
    private final DataManeger dataManager;
    private List<Product> products;
    private List<Oborot> oborots;
    private List<Client> clients;
    private final HistoryManager historyManager;
    private List<History> histories;
 
    
    public App() {
        scanner = new Scanner(System.in);
        dataManager = new DataManeger();       
        clientManager=new ClientManager();
        histories = dataManager.loadHistories();
        products=dataManager.loadBooks();
        historyManager = new HistoryManager();
        productManager = new ProductManager();
        oborotman= new OborotManager();
    }
    
    
   public void run(){
       
        boolean repeat = true;
        
        do{
            System.out.println("Задачи: ");
            System.out.println("1. Закончить программу");
            System.out.println("2. Добавить обувь");
            System.out.println("3. список обуви");
            System.out.println("4. Добавить покупателя");
            System.out.println("5. Список зарегистрированных покупателей");
            System.out.println("6. Покупка покупателем продукта");
            System.out.println("7. Оборот магазина за все время работы");
            System.out.println("8. Добавить денег покупателю ");
            System.out.print("Выберите задачу: ");
            int task = scanner.nextInt();
            scanner.nextLine();
            switch (task) {
                case 1:
                    repeat = false;
                    break;
                case 2:
                    System.out.println("2. Добавить обувь");
                    System.out.print("Введите название обуви: ");
                    String prodName = scanner.nextLine();
                    System.out.print("Введите цену обуви: ");
                    String price= scanner.nextLine();
                    System.out.print("Введите количество пар: ");
                    String quantity= scanner.nextLine();
                    
                    Product product = createProd(prodName,new Integer(quantity), new Integer(price));
                    dataManager.saveBooks(products);
                    
                    break;

                case 3:
                    
                    productManager.printListProducts(products);
                    break;
                            
                    
                case 4:
                    
                    clients.add(clientManager.createClient());
                    
                    break;
                case 5:
                    System.out.println("5. Список клиентов");
                    for (int i = 0; i < clients.size(); i++) {
                        System.out.printf("%d. %s %s. щет: %s%n"
                                ,i+1
                                ,clients.get(i).getFirstname()
                                ,clients.get(i).getLastname()
                                ,clients.get(i).getMony()
                        );
                    }
                    break;
                case 6:
                    System.out.println("Покупка покупателем продукта");
                    History history=historyManager.takeOnProduct(products, clients);
                    if(history!=null)  {
                     
                     
                    }                   
                    oborotman.createOborotList(oborots);
                    
                    
                    break;
                case 7:
                    System.out.println("7. Оборот магазина за все время работы");                    
                    
                    break;  
                case 8:
                    System.out.println("8. Пополнить счет");
                    clientManager.Refill(clients);
                    
                    break;    
                   
                   
            }}while(repeat);
}
   public Product createProd(String prodName,int quantity, int price){
        Product product = new Product();
        product.setProdName(prodName);
        product.setQuantity(quantity);
        product.setPrice(price);
        return product;
   }
//private void addClient(Client client) {
//        this.clients = Arrays.copyOf(this.clients, this.clients.length+1);
        
//        this.clients[this.clients.length - 1] = client;   
    }
//    private void addHistory(History histories) {
//        this.histories = Arrays.copyOf(this.histories, this.histories.length+1);
//        this.histories[this.histories.length - 1] = histories;   
//    }
//private void addSumma(Oborot oborot){
//        this.oborots = Arrays.copyOf(this.oborots, this.oborots.length + 1);
//        this.oborots[this.oborots.length  - 1] = oborot;
//            }}
