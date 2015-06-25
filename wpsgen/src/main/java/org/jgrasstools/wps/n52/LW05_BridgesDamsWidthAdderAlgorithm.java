/* THIS FILE IS GENERATED, DO NOT EDIT, IT WILL BE OVERWRITTEN */
package org.jgrasstools.wps.n52; 
 
import java.util.Collection; 
import java.util.HashMap; 
import java.util.ArrayList; 
import java.util.List; 
import java.io.*; 
 
import oms3.Access; 
import oms3.ComponentAccess; 
import oms3.annotations.Execute; 
import oms3.annotations.Finalize; 
import oms3.annotations.Initialize; 
 
import org.n52.wps.server.AbstractAnnotatedAlgorithm;
import org.n52.wps.algorithm.annotation.*; 
 
import org.n52.wps.io.data.binding.literal.*; 
import org.slf4j.Logger; 
import org.slf4j.LoggerFactory; 
 
import org.geotools.process.ProcessException; 
import org.jgrasstools.modules.LW05_BridgesDamsWidthAdder; 
 
@Algorithm(version = "1.0.0", abstrakt = "Correct the bankfull width of the sections of the channels where a bridge or a check dam is found, set the attribute with the origin of the width to the corresponding value.")
public class LW05_BridgesDamsWidthAdderAlgorithm extends AbstractAnnotatedAlgorithm { 

  static final Logger logger = LoggerFactory.getLogger(LW05_BridgesDamsWidthAdderAlgorithm.class); 

  public LW05_BridgesDamsWidthAdderAlgorithm() { 
    super();
  }
    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String innetpoints;

  @LiteralDataInput(identifier = "inNetPoints", abstrakt = "The input hierarchy point network layer.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinNetPoints(String innetpoints) { 
    this.innetpoints = innetpoints;
  }

    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String inbridges;

  @LiteralDataInput(identifier = "inBridges", abstrakt = "The input point layer with the bridges to consider to modify channel width.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinBridges(String inbridges) { 
    this.inbridges = inbridges;
  }

    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String indams;

  @LiteralDataInput(identifier = "inDams", abstrakt = "The input point layer with the check dams to consider to modify channel width.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinDams(String indams) { 
    this.indams = indams;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = double
    // fieldBindingType = Double
    // fieldVariableType = double
    // uom = m
  private double pdamsonnetdistance;

  @LiteralDataInput(identifier = "pDamsOnNetDistance", abstrakt = "Distance within which a dam is assumed to be on the network.", minOccurs = 1, maxOccurs = 1, binding = LiteralDoubleBinding.class)
  public void setpDamsOnNetDistance(double pdamsonnetdistance) { 
    this.pdamsonnetdistance = pdamsonnetdistance;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = double
    // fieldBindingType = Double
    // fieldVariableType = double
    // uom = m
  private double pbridgesonnetdistance;

  @LiteralDataInput(identifier = "pBridgesOnNetDistance", abstrakt = "Distance within which a bridge is assumed to be on the network.", minOccurs = 1, maxOccurs = 1, binding = LiteralDoubleBinding.class)
  public void setpBridgesOnNetDistance(double pbridgesonnetdistance) { 
    this.pbridgesonnetdistance = pbridgesonnetdistance;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = double
    // fieldBindingType = Double
    // fieldVariableType = double
    // uom = m
  private double pfixeddamswidth;

  @LiteralDataInput(identifier = "pFixedDamsWidth", abstrakt = "Fixed value of the width to assign to the sections where there is a check dam.", minOccurs = 1, maxOccurs = 1, binding = LiteralDoubleBinding.class)
  public void setpFixedDamsWidth(double pfixeddamswidth) { 
    this.pfixeddamswidth = pfixeddamswidth;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String fbridgelenght;

  @LiteralDataInput(identifier = "fBridgeLenght", abstrakt = "Name of the attribute field of the bridges layer to use as width of the channel under the bridge.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setfBridgeLenght(String fbridgelenght) { 
    this.fbridgelenght = fbridgelenght;
  }

    // inputOutputIndicator = output
    // fileIndicator = outfile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String outnetpoints;

  @LiteralDataInput(identifier = "outNetPoints", abstrakt = "The output points network layer with the bankfull width updated with the information of bridges and dams width.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setoutNetPoints(String outnetpoints) { 
    this.outnetpoints = outnetpoints;
  }

  private String res_outnetpoints;

  @LiteralDataOutput(identifier = "res_outNetPoints", abstrakt = "The output points network layer with the bankfull width updated with the information of bridges and dams width.", binding = LiteralStringBinding.class)
  public String getRes_outNetPoints() { 
    return res_outnetpoints;
  }

    // inputOutputIndicator = output
    // fileIndicator = outfile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String outproblembridges;

  @LiteralDataInput(identifier = "outProblemBridges", abstrakt = "The output layer containing the points of the structures containing no information of the width.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setoutProblemBridges(String outproblembridges) { 
    this.outproblembridges = outproblembridges;
  }

  private String res_outproblembridges;

  @LiteralDataOutput(identifier = "res_outProblemBridges", abstrakt = "The output layer containing the points of the structures containing no information of the width.", binding = LiteralStringBinding.class)
  public String getRes_outProblemBridges() { 
    return res_outproblembridges;
  }

  @org.n52.wps.algorithm.annotation.Execute
  public void runAlgorithm() throws Exception { 
    logger.info("org.jgrasstools.wps.n52.LW05_BridgesDamsWidthAdderAlgorithm");
    
    LW05_BridgesDamsWidthAdder tmpModule = new LW05_BridgesDamsWidthAdder(); 
    
    // set the inputs to the model 
    HashMap<String, Object> inputs = new HashMap<String, Object>();
    inputs.put("pFixedDamsWidth",  (double) pfixeddamswidth); 
    logger.info("pFixedDamsWidth " + ( (double) pfixeddamswidth) );
    inputs.put("inNetPoints",  (String) innetpoints); 
    logger.info("inNetPoints " + ( (String) innetpoints) );
    inputs.put("pBridgesOnNetDistance",  (double) pbridgesonnetdistance); 
    logger.info("pBridgesOnNetDistance " + ( (double) pbridgesonnetdistance) );
    inputs.put("outProblemBridges",  (String) outproblembridges); 
    logger.info("outProblemBridges " + ( (String) outproblembridges) );
    inputs.put("inDams",  (String) indams); 
    logger.info("inDams " + ( (String) indams) );
    inputs.put("fBridgeLenght",  (String) fbridgelenght); 
    logger.info("fBridgeLenght " + ( (String) fbridgelenght) );
    inputs.put("inBridges",  (String) inbridges); 
    logger.info("inBridges " + ( (String) inbridges) );
    inputs.put("outNetPoints",  (String) outnetpoints); 
    logger.info("outNetPoints " + ( (String) outnetpoints) );
    inputs.put("pDamsOnNetDistance",  (double) pdamsonnetdistance); 
    logger.info("pDamsOnNetDistance " + ( (double) pdamsonnetdistance) );
    
    // trigger execution of the module 
    try { 
        java.util.logging.Logger uLog = java.util.logging.Logger.getLogger(RasterReprojectorAlgorithm.class.getName()); 
        ComponentAccess.setInputData(inputs, tmpModule, uLog); 
    } catch (Exception ex) { 
       ex.printStackTrace();
    }
    // trigger execution of the module 
    try { 
        java.util.logging.Logger uLog = java.util.logging.Logger.getLogger(RasterReprojectorAlgorithm.class.getName()); 
        ComponentAccess.callAnnotated(tmpModule, Initialize.class, true); 
    } catch (Exception ex) { 
       ex.printStackTrace();
    }
    try { 
        ComponentAccess.callAnnotated(tmpModule, Execute.class, false); 
    } catch (Exception ex) { 
       ex.printStackTrace();
    }
    try { 
        ComponentAccess.callAnnotated(tmpModule, Finalize.class, true); 
    } catch (Exception ex) { 
       ex.printStackTrace();
    }
    
    // get the results 
    HashMap<String, String> outputs = new HashMap<String, String>();
    ComponentAccess cA = new ComponentAccess(tmpModule); 
    Collection<Access> outputsCollection = cA.outputs(); 
    
    outputs.put("outProblemBridges", "String"); 
    outputs.put("outNetPoints", "String"); 
    
    res_outproblembridges = (String) outproblembridges; 
    res_outnetpoints = (String) outnetpoints; 
    
    for( Access access : outputsCollection ) { 
        String fieldName = access.getField().getName(); 
        logger.info("access.getField().getName() = " + fieldName); 
        Object fieldValue = access.getFieldValue(); 
        
        if (fieldName.equalsIgnoreCase("outProblemBridges")) { 
            // and put them into the output result variables 
            res_outproblembridges = (String) access.getFieldValue(); 
        }
        if (fieldName.equalsIgnoreCase("outNetPoints")) { 
            // and put them into the output result variables 
            res_outnetpoints = (String) access.getFieldValue(); 
        }
        } 
    
    }

}

