/*
 * This file is part of JGrasstools (http://www.jgrasstools.org)
 * (C) HydroloGIS - www.hydrologis.com 
 * 
 * JGrasstools is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.jgrasstools.wps.utils;

import oms3.annotations.Description;
import org.jgrasstools.Modules;
import org.jgrasstools.gears.libs.modules.ClassField;
import org.jgrasstools.gears.libs.modules.JGTConstants;
import org.jgrasstools.gears.utils.files.FileUtilities;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * This class generates the wps classes for 52N
 * 
 * @author Andrea Antonello (www.hydrologis.com)
 * @author akmoch
 *
 */
public class Generator52N {

    private static final String EMPTY_DOC = " - ";

    public static void generate() throws IOException {
        File classesPackageFile = new File("./src/main/java/org/jgrasstools/wps/n52");

        if (!classesPackageFile.exists()) {
            throw new IOException("Output package doesn't exist: " + classesPackageFile.getAbsolutePath());
        }

        String[] allClasses = Modules.getInstance().allClasses;
        LinkedHashMap<String, List<ClassField>> moduleName2Fields = Modules.getInstance().moduleName2Fields;
        LinkedHashMap<String, Class< ? >> moduleName2Class = Modules.getInstance().moduleName2Class;

        /**
         * TODO We don't need a WPS algo for reading or writing raster itself, or other JGrass internal helper classes
         * - RasterReader
         * - RasterWriter
         * - VectorReader
         * - VectorWriter
         * - FileIterator
         * - GridGeometryReader
         * -
         *
         * TODO Also problematic mapping with special inputs/outputs. 52N WPS could handle those though :-)
         * - MapCalc, Variogram, VectorTableJoiner
         */
        List<String> skipModules = Arrays.asList(new String[]{"RasterReader", "RasterWriter", "VectorReader",
                "VectorWriter", "FileIterator", "GridGeometryReader", "VectorTableJoiner", "Variogram", "MapCalc"});

        for( String className : allClasses ) {
            Class< ? > clazz = moduleName2Class.get(className);

            if (skipModules.contains(className)) {
                continue;
            }

            String newClassCanonicalName = "org.jgrasstools.wps.n52." + className + "Algorithm";
            String newClassSimpleName = className + "Algorithm";

            HashMap<String, String> outputs = new HashMap<String, String>();
            List<String> fileInOutputs = new ArrayList<String>();
            HashMap<String, String> inputs = new HashMap<String, String>();

            Description description = clazz.getAnnotation(Description.class);
            String descriptionStr = description.value();

            List<ClassField> fieldsList = moduleName2Fields.get(className);

            // GENERATE CLASS
            StringBuilder sb = new StringBuilder();
            sb.append("/* THIS FILE IS GENERATED, DO NOT EDIT, IT WILL BE OVERWRITTEN */\n");
            sb.append("package org.jgrasstools.wps.n52; \n");
            sb.append(" \n");
            sb.append("import java.util.Collection; \n");
            sb.append("import java.util.HashMap; \n");
            sb.append("import java.util.ArrayList; \n");
            sb.append("import java.util.List; \n");
            sb.append("import java.io.*; \n");
            sb.append(" \n");
            sb.append("import oms3.Access; \n");
            sb.append("import oms3.ComponentAccess; \n");
            sb.append("import oms3.annotations.Execute; \n");
            sb.append("import oms3.annotations.Finalize; \n");
            sb.append("import oms3.annotations.Initialize; \n");
            sb.append(" \n");
            sb.append("import org.n52.wps.server.AbstractAnnotatedAlgorithm;\n");
            sb.append("import org.n52.wps.algorithm.annotation.*; \n");
            sb.append(" \n");
            sb.append("import org.n52.wps.io.data.binding.literal.*; \n");
            sb.append("import org.slf4j.Logger; \n");
            sb.append("import org.slf4j.LoggerFactory; \n");
            sb.append(" \n");
            sb.append("import org.geotools.process.ProcessException; \n");
            sb.append("import org.jgrasstools.modules." + className + "; \n");
            sb.append(" \n");
            sb.append("@Algorithm(version = \"1.0.0\", abstrakt = \"" + descriptionStr + "\")\n");
            sb.append("public class " + newClassSimpleName + " extends AbstractAnnotatedAlgorithm { \n");
            sb.append("\n");
            sb.append("  static final Logger logger = LoggerFactory.getLogger(" + newClassSimpleName + ".class); \n");
            sb.append("\n");
            sb.append("  public " + newClassSimpleName + "() { \n");
            sb.append("    super();\n");
            sb.append("  }\n");

            for( ClassField classField : fieldsList ) {

                String fieldName = classField.fieldName;
                if (!acceptField(fieldName)) {
                    continue;
                }

                // more info
                String fieldDescription = classField.fieldDescription;
                String fieldBindingType = getFieldBindingType(classField.fieldClass.getSimpleName());
                String fieldVariableType = getFieldVariableType(classField.fieldClass.getSimpleName());
                String fieldType = classField.fieldClass.getSimpleName();
                String inputOutputIndicator = "input";
                boolean optionalFieldIndicator = false;
                String fileIndicator = classField.uiString;

                if (fileIndicator != null) {
                    if (fileIndicator.equals(JGTConstants.FILEOUT_UI_HINT) || fileIndicator.equals(JGTConstants.FOLDEROUT_UI_HINT)) {
                        inputOutputIndicator = "output";
                    } else if (fileIndicator.equals(JGTConstants.FILEIN_UI_HINT) || fileIndicator.equals(JGTConstants.FILESPATHLIST_UI_HINT)) {
                        inputOutputIndicator = "input";
                    }
                } else {
                    if (fieldName.startsWith("out")) {
                        inputOutputIndicator = "output";
                    }
                }
                sb.append("    // inputOutputIndicator = " + inputOutputIndicator).append("\n");
                sb.append("    // fileIndicator = " + fileIndicator).append("\n");


                sb.append("    // fieldType = " + fieldType).append("\n");
                sb.append("    // fieldBindingType = " + fieldBindingType).append("\n");
                sb.append("    // fieldVariableType = " + fieldVariableType).append("\n");
                if (classField.rangeString != null) {
                    sb.append("    // range = [" + classField.rangeString + "]").append("\n");
                }

                if (classField.unitsString != null) {
                    sb.append("    // uom = " + classField.unitsString).append("\n");
                }

                if (fieldDescription.contains("optional") || fieldDescription.contains("Optional")) {
                    optionalFieldIndicator = true;
                }

                // FILEOUT hints still necessary to provide JGrasstools the paths etc
                if ( inputOutputIndicator.equalsIgnoreCase("input") ||
                        ((fileIndicator != null) && (fileIndicator.equals(JGTConstants.FILEOUT_UI_HINT) || fileIndicator.equals(JGTConstants.FOLDEROUT_UI_HINT)))) {

                    /*
                        @LiteralDataInput(identifier = "input", abstrakt = "input commands", defaultValue = "SWAT",
                            minOccurs = 0, maxOccurs = 1, binding = LiteralStringBinding.class)
                        public void setInput(String input) {

                            this.input = input;
                        }
                     */
                    inputs.put(fieldName, fieldVariableType);

                    sb.append("  private " + fieldVariableType + " " + fieldName.toLowerCase() + ";\n");
                    sb.append("\n");
                    sb.append("  @LiteralDataInput(identifier = \"" + fieldName + "\", abstrakt = \"" + fieldDescription + "\"");
                    if (optionalFieldIndicator) {
                        sb.append(", minOccurs = 0");
                    } else {
                        sb.append(", minOccurs = 1");
                    }
                    sb.append(", maxOccurs = 1, binding = Literal" + fieldBindingType + "Binding.class)").append("\n");
                    sb.append("  public void set" + fieldName + "(" + fieldVariableType + " " + fieldName.toLowerCase() + ") { \n");
                    sb.append("    this." + fieldName.toLowerCase() + " = " + fieldName.toLowerCase() + ";\n");
                    sb.append("  }\n");
                    sb.append("\n");

                }

                // need the outfile / outfolder parameters as inputs and outputs for now, until we possibly encapsulate local file operations
                if ( inputOutputIndicator.equalsIgnoreCase("output")) {
                    /*
                        @LiteralDataOutput(identifier = "result", abstrakt = "for now basically, raw plain text output", binding = LiteralStringBinding.class)
                        public String getResult() {
                            return result;
                        }
                     */
                    // we add res_ as prefix to avoid duplicate names
                    outputs.put(fieldName, fieldVariableType);

                    sb.append("  private " + fieldVariableType + " res_" + fieldName.toLowerCase() + ";\n");
                    sb.append("\n");
                    sb.append("  @LiteralDataOutput(identifier = \"res_" + fieldName + "\", abstrakt = \"" + fieldDescription + "\"");
                    sb.append(", binding = Literal" + fieldBindingType + "Binding.class)").append("\n");
                    sb.append("  public " + fieldVariableType + " getRes_" + fieldName + "() { \n");
                    sb.append("    return res_" + fieldName.toLowerCase() + ";\n");
                    sb.append("  }\n");
                    sb.append("\n");
                }

            }

            /*
                @Execute
                public void runAlgorithm() throws IOException {
             */
            sb.append("  @org.n52.wps.algorithm.annotation.Execute").append("\n");
            sb.append("  public void runAlgorithm() throws Exception { \n");
            sb.append("    logger.info(\"" + newClassCanonicalName + "\");\n");
            sb.append("    \n");
            sb.append("    " + className + " tmpModule = new " + className + "(); \n");
            sb.append("    \n");
            sb.append("    // set the inputs to the model \n");
            sb.append("    HashMap<String, Object> inputs = new HashMap<String, Object>();").append("\n");
            for (String inKey : inputs.keySet()) {
                sb.append("    inputs.put(\"" + inKey +"\",  (" + inputs.get(inKey) + ") " + inKey.toLowerCase() + "); \n");
                sb.append("    logger.info(\"" + inKey + " \" + ( (" + inputs.get(inKey) + ") " + inKey.toLowerCase() + ") );\n");
            }
            sb.append("    \n");
            sb.append("    // trigger execution of the module \n");
            sb.append("    try { \n");
            sb.append("        java.util.logging.Logger uLog = java.util.logging.Logger.getLogger(RasterReprojectorAlgorithm.class.getName()); \n");
            sb.append("        ComponentAccess.setInputData(inputs, tmpModule, uLog); \n");
            sb.append("    } catch (Exception ex) { \n");
            sb.append("       ex.printStackTrace();\n");
            sb.append("    }\n");
            sb.append("    // trigger execution of the module \n");
            sb.append("    try { \n");
            sb.append("        java.util.logging.Logger uLog = java.util.logging.Logger.getLogger(RasterReprojectorAlgorithm.class.getName()); \n");
            sb.append("        ComponentAccess.callAnnotated(tmpModule, Initialize.class, true); \n");
            sb.append("    } catch (Exception ex) { \n");
            sb.append("       ex.printStackTrace();\n");
            sb.append("    }\n");

            sb.append("    try { \n");
            sb.append("        ComponentAccess.callAnnotated(tmpModule, Execute.class, false); \n");
            sb.append("    } catch (Exception ex) { \n");
            sb.append("       ex.printStackTrace();\n");
            sb.append("    }\n");

            sb.append("    try { \n");
            sb.append("        ComponentAccess.callAnnotated(tmpModule, Finalize.class, true); \n");
            sb.append("    } catch (Exception ex) { \n");
            sb.append("       ex.printStackTrace();\n");
            sb.append("    }\n");

            sb.append("    \n");
            sb.append("    // get the results \n");
            sb.append("    HashMap<String, String> outputs = new HashMap<String, String>();").append("\n");
            sb.append("    ComponentAccess cA = new ComponentAccess(tmpModule); \n");
            sb.append("    Collection<Access> outputsCollection = cA.outputs(); \n");
            sb.append("    \n");
            /*
            transfer output list into inner outkeylist
             */
            for (String outKey : outputs.keySet()) {
                sb.append("    outputs.put(\"" + outKey +"\", \"" + outputs.get(outKey) + "\"); \n");
            }

            sb.append("    \n");
            for (String outKey : outputs.keySet()) {
                if (fileInOutputs.contains(outKey)) {
                    sb.append("    res_" + outKey.toLowerCase() +" = (" + outputs.get(outKey) + ") " + outKey.toLowerCase() + "; \n");
                }
            }
            sb.append("    \n");
            sb.append("    for( Access access : outputsCollection ) { \n");
            sb.append("        String fieldName = access.getField().getName(); \n");
            sb.append("        logger.info(\"access.getField().getName() = \" + fieldName); \n");
            sb.append("        Object fieldValue = access.getFieldValue(); \n");
            sb.append("        \n");

            /*
            foreach in inner outputs key list, if fieldname equals outKey then outKey.lowerCase = (cast outKEy fieldType) fieldValue
             */
            for (String outKey : outputs.keySet()) {
                sb.append("        if (fieldName.equalsIgnoreCase(\"" + outKey +"\")) { \n");
                sb.append("            // and put them into the output result variables \n");
                sb.append("            res_" + outKey.toLowerCase() +" = (" + outputs.get(outKey) + ") access.getFieldValue(); \n");
                sb.append("        }\n");
            }

            sb.append("        } \n");
            sb.append("    \n");
            sb.append("    }\n");
            sb.append("\n");
            sb.append("}\n");
            sb.append("\n");

            File outJavaFile = new File(classesPackageFile, newClassSimpleName + ".java");
            FileUtilities.writeFile(sb.toString(), outJavaFile);

        }

    }

    private static boolean acceptField( String fieldName ) {
        if (fieldName.equals("pm")) {
            return false;
        }
        return true;
    }

    private static String getFieldBindingType(String fieldType) {
        if (fieldType.equalsIgnoreCase("int")) {
            return "Int";
        } else if (fieldType.equalsIgnoreCase("int[]")) {
            return "String";
        } else if (fieldType.equalsIgnoreCase("Integer")) {
            return "Int";
        } else if (fieldType.equalsIgnoreCase("boolean")) {
            return "Boolean";
        } else if (fieldType.equalsIgnoreCase("double")) {
            return "Double";
        } else if (fieldType.equalsIgnoreCase("double[][]")) {
            return "String";
        } else if (fieldType.equalsIgnoreCase("long")) {
            return "Long";
        } else if (fieldType.equalsIgnoreCase("string")) {
            return "String";
        } else if (fieldType.equalsIgnoreCase("String[][]")) {
            return "String";
        } else if (fieldType.equalsIgnoreCase("List")) {
            return "String";
        } else if (fieldType.equalsIgnoreCase("short")) {
            return "Short";
        } else if (fieldType.equalsIgnoreCase("long")) {
            return "Long";
        }  else {
            return fieldType;
        }
    }

    private static String getFieldVariableType(String fieldType) {
        if (fieldType.equalsIgnoreCase("int")) {
            return "int";
        } else if (fieldType.equalsIgnoreCase("int[]")) {
            return "String";
        } else if (fieldType.equalsIgnoreCase("Integer")) {
            return "Integer";
        } else if (fieldType.equalsIgnoreCase("boolean")) {
            return "Boolean";
        } else if (fieldType.equals("Double")) {
            return "Double";
        } else if (fieldType.equals("double")) {
            return "double";
        } else if (fieldType.equalsIgnoreCase("double[][]")) {
            return "String";
        } else if (fieldType.equalsIgnoreCase("long")) {
            return "Long";
        } else if (fieldType.equalsIgnoreCase("string")) {
            return "String";
        } else if (fieldType.equalsIgnoreCase("String[][]")) {
            return "String";
        } else if (fieldType.equalsIgnoreCase("List")) {
            return "String";
        } else if (fieldType.equalsIgnoreCase("short")) {
            return "Short";
        } else if (fieldType.equalsIgnoreCase("long")) {
            return "Long";
        } else {
            return fieldType;
        }
    }

    public static void main( String[] args ) throws IOException {
        Generator52N.generate();
    }

}
