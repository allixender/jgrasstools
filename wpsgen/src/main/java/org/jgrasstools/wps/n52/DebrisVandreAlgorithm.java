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
import org.jgrasstools.modules.DebrisVandre; 
 
@Algorithm(version = "1.0.0", abstrakt = "Implementation of the Vandre methodology for Debris handling.")
public class DebrisVandreAlgorithm extends AbstractAnnotatedAlgorithm { 

  static final Logger logger = LoggerFactory.getLogger(DebrisVandreAlgorithm.class); 

  public DebrisVandreAlgorithm() { 
    super();
  }
    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String inelev;

  @LiteralDataInput(identifier = "inElev", abstrakt = "The map of elevation.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinElev(String inelev) { 
    this.inelev = inelev;
  }

    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String inflow;

  @LiteralDataInput(identifier = "inFlow", abstrakt = "The map of flow directions.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinFlow(String inflow) { 
    this.inflow = inflow;
  }

    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
    // uom = degree
  private String inslope;

  @LiteralDataInput(identifier = "inSlope", abstrakt = "The map of slope.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinSlope(String inslope) { 
    this.inslope = inslope;
  }

    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String intriggers;

  @LiteralDataInput(identifier = "inTriggers", abstrakt = "The map of debris triggering points.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinTriggers(String intriggers) { 
    this.intriggers = intriggers;
  }

    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String insoil;

  @LiteralDataInput(identifier = "inSoil", abstrakt = "The optional map of soil height.", minOccurs = 0, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinSoil(String insoil) { 
    this.insoil = insoil;
  }

    // inputOutputIndicator = input
    // fileIndicator = infile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String innet;

  @LiteralDataInput(identifier = "inNet", abstrakt = "The optional map of the network (needed if the soil map is supplied).", minOccurs = 0, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinNet(String innet) { 
    this.innet = innet;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = boolean
    // fieldBindingType = Boolean
    // fieldVariableType = Boolean
  private Boolean dowholenet;

  @LiteralDataInput(identifier = "doWholenet", abstrakt = "The flag that defines (in the case of supplied soil map0 if the cumulated should be propagated down the whole network channel.", minOccurs = 1, maxOccurs = 1, binding = LiteralBooleanBinding.class)
  public void setdoWholenet(Boolean dowholenet) { 
    this.dowholenet = dowholenet;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = double
    // fieldBindingType = Double
    // fieldVariableType = double
    // uom = [m]
  private double pdistance;

  @LiteralDataInput(identifier = "pDistance", abstrakt = "The optional maximum distance (used if the soil map is supplied, defaults to 100 meters).", minOccurs = 0, maxOccurs = 1, binding = LiteralDoubleBinding.class)
  public void setpDistance(double pdistance) { 
    this.pdistance = pdistance;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String inobstacles;

  @LiteralDataInput(identifier = "inObstacles", abstrakt = "An optional point map of obstacles on the network, that can stop the debris path.", minOccurs = 0, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setinObstacles(String inobstacles) { 
    this.inobstacles = inobstacles;
  }

    // inputOutputIndicator = input
    // fileIndicator = null
    // fieldType = int
    // fieldBindingType = Int
    // fieldVariableType = int
  private int pmode;

  @LiteralDataInput(identifier = "pMode", abstrakt = "The criteria mode to use (0 = Burton/Bathurst = default, 1 = Tn modified Barton/Bathurst).", minOccurs = 1, maxOccurs = 1, binding = LiteralIntBinding.class)
  public void setpMode(int pmode) { 
    this.pmode = pmode;
  }

    // inputOutputIndicator = output
    // fileIndicator = outfile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String outpaths;

  @LiteralDataInput(identifier = "outPaths", abstrakt = "The debris paths for every trigger point.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setoutPaths(String outpaths) { 
    this.outpaths = outpaths;
  }

  private String res_outpaths;

  @LiteralDataOutput(identifier = "res_outPaths", abstrakt = "The debris paths for every trigger point.", binding = LiteralStringBinding.class)
  public String getRes_outPaths() { 
    return res_outpaths;
  }

    // inputOutputIndicator = output
    // fileIndicator = outfile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String outindexedtriggers;

  @LiteralDataInput(identifier = "outIndexedTriggers", abstrakt = "The trigger map, linked to the id of its path.", minOccurs = 1, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setoutIndexedTriggers(String outindexedtriggers) { 
    this.outindexedtriggers = outindexedtriggers;
  }

  private String res_outindexedtriggers;

  @LiteralDataOutput(identifier = "res_outIndexedTriggers", abstrakt = "The trigger map, linked to the id of its path.", binding = LiteralStringBinding.class)
  public String getRes_outIndexedTriggers() { 
    return res_outindexedtriggers;
  }

    // inputOutputIndicator = output
    // fileIndicator = outfile
    // fieldType = String
    // fieldBindingType = String
    // fieldVariableType = String
  private String outsoil;

  @LiteralDataInput(identifier = "outSoil", abstrakt = "The optional output map of cumulated soil.", minOccurs = 0, maxOccurs = 1, binding = LiteralStringBinding.class)
  public void setoutSoil(String outsoil) { 
    this.outsoil = outsoil;
  }

  private String res_outsoil;

  @LiteralDataOutput(identifier = "res_outSoil", abstrakt = "The optional output map of cumulated soil.", binding = LiteralStringBinding.class)
  public String getRes_outSoil() { 
    return res_outsoil;
  }

  @org.n52.wps.algorithm.annotation.Execute
  public void runAlgorithm() throws Exception { 
    logger.info("org.jgrasstools.wps.n52.DebrisVandreAlgorithm");
    
    DebrisVandre tmpModule = new DebrisVandre(); 
    
    // set the inputs to the model 
    HashMap<String, Object> inputs = new HashMap<String, Object>();
    inputs.put("outIndexedTriggers",  (String) outindexedtriggers); 
    logger.info("outIndexedTriggers " + ( (String) outindexedtriggers) );
    inputs.put("outSoil",  (String) outsoil); 
    logger.info("outSoil " + ( (String) outsoil) );
    inputs.put("outPaths",  (String) outpaths); 
    logger.info("outPaths " + ( (String) outpaths) );
    inputs.put("pDistance",  (double) pdistance); 
    logger.info("pDistance " + ( (double) pdistance) );
    inputs.put("inSlope",  (String) inslope); 
    logger.info("inSlope " + ( (String) inslope) );
    inputs.put("doWholenet",  (Boolean) dowholenet); 
    logger.info("doWholenet " + ( (Boolean) dowholenet) );
    inputs.put("inNet",  (String) innet); 
    logger.info("inNet " + ( (String) innet) );
    inputs.put("inSoil",  (String) insoil); 
    logger.info("inSoil " + ( (String) insoil) );
    inputs.put("inTriggers",  (String) intriggers); 
    logger.info("inTriggers " + ( (String) intriggers) );
    inputs.put("pMode",  (int) pmode); 
    logger.info("pMode " + ( (int) pmode) );
    inputs.put("inObstacles",  (String) inobstacles); 
    logger.info("inObstacles " + ( (String) inobstacles) );
    inputs.put("inElev",  (String) inelev); 
    logger.info("inElev " + ( (String) inelev) );
    inputs.put("inFlow",  (String) inflow); 
    logger.info("inFlow " + ( (String) inflow) );
    
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
    
    outputs.put("outIndexedTriggers", "String"); 
    outputs.put("outSoil", "String"); 
    outputs.put("outPaths", "String"); 
    
    res_outindexedtriggers = (String) outindexedtriggers; 
    res_outsoil = (String) outsoil; 
    res_outpaths = (String) outpaths; 
    
    for( Access access : outputsCollection ) { 
        String fieldName = access.getField().getName(); 
        logger.info("access.getField().getName() = " + fieldName); 
        Object fieldValue = access.getFieldValue(); 
        
        if (fieldName.equalsIgnoreCase("outIndexedTriggers")) { 
            // and put them into the output result variables 
            res_outindexedtriggers = (String) access.getFieldValue(); 
        }
        if (fieldName.equalsIgnoreCase("outSoil")) { 
            // and put them into the output result variables 
            res_outsoil = (String) access.getFieldValue(); 
        }
        if (fieldName.equalsIgnoreCase("outPaths")) { 
            // and put them into the output result variables 
            res_outpaths = (String) access.getFieldValue(); 
        }
        } 
    
    }

}

