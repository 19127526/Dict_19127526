import java.io.*;
import java.util.*;

/**
 * PACKAGE_NAME
 * Created by Admin
 * Date 12/13/2021 - 11:19 PM
 * Description: ...
 */
public class Dict {
    public TreeMap<String,Vector<String>> dict;
    private String NameFile="slang.txt";
    private String History="History.csv";
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
    public void Writefile(Object[]temp){
        BufferedWriter a=null;
        try{
                a=new BufferedWriter(new FileWriter(History,true));
                Date d=new Date();
                a.append(d.toString());
                a.append((String)temp[0]);
                a.append(",");
                a.append((String) temp[1]);
                a.newLine();
                a.close();
        }
        catch (Exception ev){
            ev.printStackTrace();
        }
    }
    public String[][] readfile()throws  IOException{
        String[][]value=null;
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
            int i=0;
            value=new String[dict.keySet().size()][];
            Set<String>tempkey=dict.keySet();
            for(String tk:tempkey){
                value[i]=new String[2];
                value[i][0]=tk;
                value[i][1]=dict.get(tk.toString()).toString();
                i++;
                /*System.out.println(tk + " - " + dict.get(tk.toString()));*/
            }
            a.close();
            return value;
        }
        catch(IOException ex){
            System.out.println("Error opening file");
            return null;
        }
    }
}
