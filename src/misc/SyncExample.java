package misc;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class SyncExample implements Runnable{
    FileWriter fp;
    BufferedWriter writer;
    Thread t;
    String content;
    public SyncExample(String content){
        t = new Thread(this);
        this.content = content;
        t.start();
    }
     public void writeToFile(BufferedWriter writer,String str) throws IOException {
        writer.write(str);
        writer.close();
    }
    public static void main(String args[]) throws IOException {

      SyncExample obj[] = new SyncExample[10];
      for(int i=0;i<obj.length;i++){
          obj[i] = new SyncExample(String.valueOf(i));
      }

    }

    @Override
    public void run() {
        try {
            fp = new FileWriter("test.txt",true);
            writer = new BufferedWriter(fp);
            Thread t = Thread.currentThread();
            writeToFile(writer,this.content);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
