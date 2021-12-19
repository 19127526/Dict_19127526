import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
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
            return a;
        }
    }
    public String[] xulyhistory(String temp){
        String []v=temp.split(",");
        return v;
    }
    public String[][] Readfile_History()throws  IOException {
        String[][]value=null;
        String[]temp=null;
        String thisLine = null;
        Vector<String[]>t=new Vector<String[]>();
        try {
            int i=0;
            BufferedReader br = new BufferedReader(new FileReader(History));
            while ((thisLine = br.readLine()) != null) {
                temp=xulyhistory(thisLine);
                t.add(temp);
            }
            value=new String[t.size()][3];
            for(int i2=0;i2<value.length;i2++){
                String te="\0";
                for(int j2=0;j2<value[i2].length;j2++){
                    if(j2==2){
                        te+=t.get(i2)[j2];
                    }
                    else {
                        value[i2][j2] = t.get(i2)[j2];
                    }
                }
                value[i2][2]=te;
            }
        } catch (IOException ev) {
            ev.printStackTrace();
        }
        return value;
    }
    public static void main(String arv[]){
        Dict a= new Dict();
        try {
            String[][] value = a.Readfile_History();
        }
        catch (Exception ev){
            ev.printStackTrace();
        }
    }
    public void Writefile_History(Object[]temp){
        BufferedWriter a=null;
        try{
                a=new BufferedWriter(new FileWriter(History,true));
                Date d=new Date();
                a.append(d.toString());
                a.append(",");
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
            }
            a.close();
            return value;
        }
        catch(IOException ex){
            System.out.println("Error opening file");
            return null;
        }
    }
    public void writefile(){

    }
    public void Writefile_data(String slang,String word,int check)throws  IOException{
        BufferedWriter bw=null;
        BufferedReader br=null;
        String thisLine=null;
        try{
            Vector<String> temp=null;
            br=new BufferedReader(new FileReader(NameFile));
            if(check==0){
                bw=new BufferedWriter(new FileWriter(NameFile,true));
                bw.append(slang);
                bw.append("`");
                bw.append(word);
                bw.newLine();
                bw.close();
                return;
            }
            //overwrite
            if(check==1) {
                bw=new BufferedWriter(new FileWriter("1"+NameFile,true));
                Set<String>tempkey=dict.keySet();
                for(String tk:tempkey){
                    if(tk.equals(slang)){
                        dict.get(tk).add(word);
                    }
                    String tmp=tk+"`"+dict.get(tk).toString().replace(',','|').replace("[","").replace("]","");
                    bw.append(tmp);
                    bw.newLine();
                }
                br.close();
                bw.close();
                File a =new File(NameFile);
                File b=new File("1"+NameFile);
                a.delete();
                b.renameTo(a);
                return;
            }
            if(check==2){//duplicate
                Set<String>tempkey=dict.keySet();
                temp=new Vector<>();
                temp.add(word);
                for(String tk:tempkey){
                    if(tk.equals(slang)){
                        temp.addAll(dict.get(tk));
                        break;
                    }
                }
                dict.put(slang,temp);
                for(String tk:tempkey){
                    bw.append(tk);
                    bw.append("`");
                    bw.append(tempkey.toString());
                    bw.newLine();
                    bw.close();
                }
                return;
            }
        }
        catch (Exception ev){
            ev.printStackTrace();
        }
    }
}

