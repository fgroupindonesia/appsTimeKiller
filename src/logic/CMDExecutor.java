/*
 *  This is a Supplemental File from the Main Project used
 *  in APPSTIMERKILLER
 *  with FGroupIndonesia online & offline sessions.
 *  (c) FGroupIndonesia.com
 */
package logic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class CMDExecutor {

    public static void main(String[] args) {
        getAppsList();
    }
    
    public static boolean kill(String appName){
        
        boolean succ = false;
        
        // taskkill /F /IM "notepad.exe" 
        
        return succ;
        
    }
    
    public static boolean kill(int appPID){
        
        boolean succ = false;
        
        // taskkill /F /PID pid_number
        
        return succ;
        
    }
    
    private static Process execute(String command){
        
         Runtime rt = Runtime.getRuntime();
         Process prx = null;

        String[] commands = {command, ""};

        try {
            prx = rt.exec(commands);
        }catch (Exception ex){
            System.err.println("Error while executing Commands " + command);
        }
        
        return prx;
        
    }
    
    public static ArrayList<Data> getAppsList() {
        ArrayList<Data> hasil = new ArrayList<Data>();

       
        try {

            Process proc = execute("tasklist.exe");

            BufferedReader stdInput = new BufferedReader(new InputStreamReader(proc.getInputStream()));

            BufferedReader stdError = new BufferedReader(new InputStreamReader(proc.getErrorStream()));

            System.out.println("Here is the standard output of the command:\n");
            String s = null;
            String dataTemp [];
            int lineNum = 0, found=0;
            while ((s = stdInput.readLine()) != null) {
                //System.out.println(s);  
                s = s.trim().replaceAll(" +", " ");
                dataTemp = s.split(" ");
                
                
                if(lineNum>=5){
                found++;
                
                Data satuan = new Data();
                satuan.setNo(found);
                satuan.setName(dataTemp[0]);
                satuan.setPid(Integer.parseInt(dataTemp[1]));
                satuan.setType(dataTemp[2]);
                satuan.setMemoryUsed(dataTemp[4] + " k");
                
                //System.out.println(satuan.getName() + " " + satuan.getMemoryUsed() );    
                
                hasil.add(satuan);
                
                System.out.println(s);
                
                
                }
                
                lineNum++;
            }

        } catch (Exception ex) {
            System.out.println("Err " + ex.getMessage());
            ex.printStackTrace();
            
        }

        return hasil;
    }

}
