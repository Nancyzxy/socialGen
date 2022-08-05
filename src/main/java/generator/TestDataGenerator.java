package generator;

import java.io.FileWriter;
import java.io.IOException;

import datatype.Message;

public class TestDataGenerator{
    public static void main(String[] args) throws IOException {
        String controllerInstallDir = args[0];
        int num = Integer.parseInt(args[1]);
        String msgGenConfigFile = controllerInstallDir + "/metadata/config.txt";
        String parentDir = controllerInstallDir + "/metadata";
        String output = controllerInstallDir + "/Data.csv";
        FileWriter fileWriter = new FileWriter(output,false);
        RandomMessageGenerator randMessageGen = new RandomMessageGenerator(msgGenConfigFile, parentDir, System.currentTimeMillis());
        fileWriter.write("text,sentiment\n");
        for(int i=0;i<num;i++){
            Message m = randMessageGen.getNextRandomMessage(false);
            fileWriter.write("\"");
            fileWriter.write(String.valueOf(m.getMessage()).substring(0,m.getLength()));
            fileWriter.write("\"");
            fileWriter.write(",");
            fileWriter.write(String.valueOf(m.getSentiment()));
            fileWriter.write("\n");
        }
        fileWriter.close();
    }
}