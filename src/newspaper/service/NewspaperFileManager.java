package newspaper.service;

import newspaper.model.Newspaper;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class NewspaperFileManager implements Data{

    private ArrayList<Newspaper> newspapers = new ArrayList<>();

    @Override
    public void saveData(){
        String filePath="C:\\mycode\\java\\mostenire\\OnlineShopMostenire\\src\\newspaper\\data\\newspaper.txt";
        try (FileWriter fileWriter = new FileWriter(filePath, false);
             PrintWriter printWriter = new PrintWriter(fileWriter)) {
            for (Newspaper newspaper : newspapers) {
                printWriter.println(newspaper.toString());
            }
        } catch (Exception e) {
            System.out.println(e);
        }

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

}
