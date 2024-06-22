package newspaper.service;

import newspaper.model.Newspaper;
import users.models.Users;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class NewspaperQueryServiceImpl implements NewspaperQueryService{

    private ArrayList<Newspaper> newspapers;
    private NewspaperFileManager newspaperFileManager;

    public NewspaperQueryServiceImpl() {
        this.newspapers = new ArrayList<>();
        this.newspaperFileManager = new NewspaperFileManager();
        this.loadData();
    }

    @Override
    public void loadData() {
        try{
            String filePath="C:\\mycode\\java\\mostenire\\OnlineShopMostenire\\src\\newspaper\\data\\newspaper.txt";
            File file = new File(filePath);
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {

                String line = sc.nextLine();
                Newspaper newspaper = new Newspaper(line);

                this.newspapers.add(newspaper);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void afisare(){
        for(int i =0 ; i < newspapers.size();i++){
            System.out.println(newspapers.get(i).descriere());
        }
    }

    @Override
    public void notifyUsers(){

    }

    @Override
    public String toString() {

        String text="";
        int i=0;
        for(i=0;i<this.newspapers.size()-1;i++){
            text+=this.newspapers.get(i)+"\n";
        }
        return text+=this.newspapers.get(i);
    }
}
