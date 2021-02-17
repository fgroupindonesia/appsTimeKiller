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
        kill("cmd.exe");
    }

    private static boolean killExecutor(String ... command){
        
        boolean res = false;
        
         try {

            Process proc = execute(command);

            BufferedReader stdInput = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            BufferedReader stdError = new BufferedReader(new InputStreamReader(proc.getErrorStream()));

            // System.out.println("Here is the standard output of the command:\n");
            String s = null;
            
            while ((s = stdInput.readLine()) != null) {
                System.out.println(s);  
               if(s.toLowerCase().contains("success")){
                   res = true;
               }else if(s.toLowerCase().contains("error")){
                   res = false;
               }
            }

            
            stdError.close();
            stdInput.close();
            proc.destroyForcibly();
            
        } catch (Exception ex) {
            System.out.println("Err " + ex.getMessage());
            ex.printStackTrace();

        }
        
         return res;
         
    }
    
    public static boolean kill(String appName) {

        boolean succ = false;

        // taskkill /F /IM "notepad.exe" 
        succ = killExecutor("taskkill", "/F", "/IM", "\"" + appName + "\"");
        return succ;

    }

    public static boolean kill(int appPID) {

        boolean succ = false;

        // taskkill /F /PID pid_number
        succ = killExecutor("taskkill","/F", "/PID", ""+appPID);
        return succ;

    }

    private static Process execute(String ... commands) {

        Runtime rt = Runtime.getRuntime();
        Process prx = null;
        String arg = null;

        try {
            prx = rt.exec(commands);
        } catch (Exception ex) {
            System.err.println("Error while executing Commands " + String.join(" ", commands));
        }

        return prx;

    }

    public static ArrayList<Data> getAppsList() {
        ArrayList<Data> hasil = new ArrayList<Data>();

        try {

            Process proc = execute("tasklist");

            BufferedReader stdInput = new BufferedReader(new InputStreamReader(proc.getInputStream()));

            BufferedReader stdError = new BufferedReader(new InputStreamReader(proc.getErrorStream()));

            // System.out.println("Here is the standard output of the command:\n");
            String s = null;
            String dataTemp[];
            int lineNum = 0, found = 0;
            while ((s = stdInput.readLine()) != null) {
                //System.out.println(s);  
                s = s.trim().replaceAll(" +", " ");
                dataTemp = s.split(" ");

                if (lineNum >= 5) {
                    found++;

                    Data satuan = new Data();
                    satuan.setNo(found);
                    satuan.setName(dataTemp[0]);
                    satuan.setPid(Integer.parseInt(dataTemp[1]));
                    satuan.setType(dataTemp[2]);
                    satuan.setMemoryUsed(dataTemp[4] + " k");

                    //System.out.println(satuan.getName() + " " + satuan.getMemoryUsed() );    
                    hasil.add(satuan);

                    //System.out.println(s);

                }

                lineNum++;
                
            }

            stdError.close();
            stdInput.close();
            
            proc.destroyForcibly();
            
        } catch (Exception ex) {
            System.out.println("Err " + ex.getMessage());
            ex.printStackTrace();

        }

        return hasil;
    }

}
