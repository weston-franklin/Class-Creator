import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
//creates new class and potential constructors

public class classCreator {
    
    //create final doc, the attribute string, getter and setter string, and class name
    String classDoc = "";
    String atString = "";
    String getSetString = "";
    String className = "";
    
    //getters and setters
    public void setClassName(String newClassName){
        className =  newClassName;
    }
    public String getClassName(){
        return className;
    }
    public void setGetSetString(String newGetSetString){
        getSetString =  newGetSetString;
    }
    public String getGetSetString(){
        return getSetString;
    }
    public void setAtString(String newAtString){
        atString =  newAtString;
    }
    public String getAtString(){
        return atString;
    }
    public void setClassDoc(String newClassDoc){
        classDoc =  newClassDoc;
    }
    public String getClassDoc(){
        return classDoc;
    }

    //creates the whole document for a new class
    public void createClass(String newClassName){
        className = newClassName;
        String input = "";
        System.out.println("Please enter the path up to the folder you'd like this file to occupy");
        input = interactable.sc.nextLine();
        File dir = new File(input);
        getAttributes();
        interactable.sc.close();
        classDoc = "public class " + className + "{\n\n\t//Creates attributes\n" + atString + "\n\n\t//Getters and setters\n" + 
        getSetString + "\n}";
        try {
            File file = new File(dir, className + ".java");
            FileWriter content = new FileWriter(input + "\\" + className + ".java");
            System.out.println("File created");
            content.write(classDoc);
            content.close();
        } catch (IOException e) {
            System.out.println("Something went wrong. Cannot create file.");
            e.printStackTrace();
        }
    }

    //gets attributes for creation of new class.
    public void getAttributes(){
        attributeCreator a = new attributeCreator();
        String input = "";
        System.out.println("Please enter attributes' types and names, split by a space. When you are done, type \"Done\"");
        while(!input.equalsIgnoreCase("Done")){
            input = interactable.sc.nextLine();
            if(input.equalsIgnoreCase("Done")){
                break;
            }
            char[] c = input.toCharArray();
            int numbSpaces = 0;
            int spaceLocation = 0;
            for(int i = 0; i < c.length; i++){
                if(c[i] == ' '){
                    numbSpaces ++;
                    spaceLocation = i;
                }
            }
            if(numbSpaces != 1){
                System.out.println("Please make sure to enter the attribute's type and name seperated by a single space. Thank you.");
                continue;
            }
            String atType = input.substring(0, spaceLocation);
            String atName = input.substring(spaceLocation+1);
            atString = atString.concat("\n" + a.createAttribute(atType, atName));
            getSetString = getSetString.concat("\n" + a.createGetSet(atType, atName));
        }
    }
}
