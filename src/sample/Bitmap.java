package sample;

import api.CreateTxt;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class Bitmap implements CreateTxt{

        private BufferedImage bufferedImage;
        private int width;      //szerokosc obrazka
        private int height;     //wysokosc obrazka
        private File file;

    public boolean isCorrect() {
        return correct;
    }

    private boolean correct=true;

        private String getFileExtension(String path){
            if(path!=null){
                String fileName = new File(path).getName();
                int dotIndex = fileName.lastIndexOf('.');
                return (dotIndex == -1) ? "" : fileName.substring(dotIndex + 1);
            }
            else return "";
        }
        public Bitmap(String path) {    //konstruktor klasy jest odpowiedialny za pobranie odpowiednich danych o obrazku
            try {
                file = new File(path);
                if(file.exists()){
                    bufferedImage = ImageIO.read(file);
                    height = bufferedImage.getHeight();
                    width = bufferedImage.getWidth();
                }else{
                    correct=false;
                }
                if(!(getFileExtension(path).equals("png"))){
                    correct=false;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void createTxt()  {
            if(correct==true){
                //stworzenie odpowiedniej ścieżki pliku txt
                //plik txt bedzie zapisany w tej samej lokalizacji gdzie obrazek
                try{
                    String path=file.getPath().substring(0,file.getPath().lastIndexOf("."))+".txt";
                    PrintWriter printWriter=new PrintWriter(path);
                    //tworzenie bitmapy
                    for(int row=0;row<height;row++){
                        if(row==0){
                            printWriter.write("{{");
                        }
                        else{
                            printWriter.write("{");
                        }
                        for(int column=0;column<width;column++){
                            if(column==width-1){
                                printWriter.write(Integer.toString(bufferedImage.getRGB(column, row)&0xffffff));
                            }
                            else{
                                printWriter.write(Integer.toString(bufferedImage.getRGB(column, row)&0xffffff)+",");
                            }
                        }
                        if(row==height-1){
                            printWriter.write("}};");
                        }
                        else{
                            printWriter.write("},\n");
                        }
                    }
                    printWriter.close();
                }catch(Exception e){}
                }

        }
    }

