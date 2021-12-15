import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * PACKAGE_NAME
 * Created by Admin
 * Date 12/13/2021 - 11:19 PM
 * Description: ...
 */
public class Dict {
    private TreeMap<String,Vector<String>> dict;
    private String NameFile="slang.txt";
    public String Key=null;
    Dict(){
        dict=new TreeMap<String,Vector<String>>();
    }
    String[] xuly(String temp){
        try {
            String[] key = temp.split("`");
            String[] value_temp = key[1].split("\\| ");
            Key = key[0];
            return value_temp;
        }
        catch(Exception ex){
            String []h=temp.split("");
            String str = String.join("", h);
            String[]a=new String[1];
            a[0]=str;
     /*      System.out.println(a[0]);*/
            return a;
        }
    }
    void ReadFile()throws  IOException{
        String thisLine=null;
        String temp_key=null;
        Vector<String>temp=new Vector<String>();
        try{
            BufferedReader a=new BufferedReader(new FileReader(NameFile));
            while((thisLine= a.readLine())!=null){
                String[]Temp=xuly(thisLine);
                if(temp_key==Key) {
                }
                else{
                    temp=new Vector<String>();
                }
                temp.addAll(List.of(Temp));
                dict.put(Key,temp);
                temp_key=Key;
            }
            Set<String>tempkey=dict.keySet();
            for(String tk:tempkey){
              System.out.println(tk + " - " + dict.get(tk.toString()));
            }
        }
        catch(IOException ex){
            System.out.println("Error opening file");
            return;
        }
    }
}
