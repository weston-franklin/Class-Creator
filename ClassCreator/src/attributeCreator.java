//a class that creates attributes and their getters and setters.

public class attributeCreator {
    //declare and initalize both attribute name and attribute data-type
    String atName = "";
    String atType = "";

    //Getters and Setters
    public void setAtName(String newAtName){
        atName = newAtName;
    }
    public String getAtName(){
        return atName;
    }
    public void setAtType(String newAtType){
        atType = newAtType;
    }
    public String getAtType(){
        return atType;
    }

    //creates attribute statement
    public String createAttribute(String newAtType, String newAtName){
        if(newAtType.equalsIgnoreCase("string")){
            newAtType = newAtType.substring(0,1).toUpperCase()+newAtType.substring(1);
        }
        else if(newAtType.equalsIgnoreCase("int") || newAtType.equalsIgnoreCase("boolean") || 
        newAtType.equalsIgnoreCase("char") || newAtType.equalsIgnoreCase("long") || 
        newAtType.equalsIgnoreCase("float") || newAtType.equalsIgnoreCase("double") || 
        newAtType.equalsIgnoreCase("byte") || newAtType.equalsIgnoreCase("short")){
            newAtType = newAtType.substring(0,1).toLowerCase()+newAtType.substring(1);
        }
        String value = "";
        if(newAtType.equalsIgnoreCase("string")){
            value = "\"\"";
        }
        else if(newAtType.equalsIgnoreCase("int") || newAtType.equalsIgnoreCase("short")){
            value = "0";
        }
        else if(newAtType.equalsIgnoreCase("boolean")){
            value = "true";
        }
        else if(newAtType.equalsIgnoreCase("byte")){
            value = "10";
        }
        else if(newAtType.equalsIgnoreCase("char")){
            value = "'a'";
        }
        else if(newAtType.equalsIgnoreCase("long")){
            value = "0L";
        }
        else if(newAtType.equalsIgnoreCase("float")){
            value = "0.5f";
        }
        else if(newAtType.equalsIgnoreCase("double")){
            value = "0.5";
        }

        String atString = "\t" + newAtType + " " + newAtName + " = " + value + ";";
        return atString;
    }

    //creates getter and setters
    public String createGetSet(String newAtType, String newAtName){
        String getSet = "\tpublic void set";
        String capName = newAtName.substring(0,1).toUpperCase()+newAtName.substring(1);
        getSet = getSet.concat(capName + "(" + newAtType + " new" + capName + "){\n\t\t"+ newAtName + " = " + " new" + 
            capName + ";\n\t}\n\tpublic " + newAtType + " get" + capName + "(){\n\t\treturn " + newAtName + ";\n\t}");
        return getSet;
    }

}
